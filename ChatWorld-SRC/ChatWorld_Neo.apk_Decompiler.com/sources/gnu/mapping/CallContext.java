package gnu.mapping;

import androidx.core.internal.view.SupportMenu;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.math.IntNum;

public class CallContext {
    public static final int ARG_IN_IVALUE1 = 5;
    public static final int ARG_IN_IVALUE2 = 6;
    public static final int ARG_IN_VALUE1 = 1;
    public static final int ARG_IN_VALUE2 = 2;
    public static final int ARG_IN_VALUE3 = 3;
    public static final int ARG_IN_VALUE4 = 4;
    public static final int ARG_IN_VALUES_ARRAY = 0;
    static ThreadLocal currentContext = new ThreadLocal();
    public Consumer consumer;
    public int count;
    public Object[][] evalFrames;
    public int ivalue1;
    public int ivalue2;
    public int next;
    public int pc;
    public Procedure proc;
    public Object value1;
    public Object value2;
    public Object value3;
    public Object value4;
    public Object[] values;
    public ValueStack vstack;
    public int where;

    public CallContext() {
        ValueStack valueStack = new ValueStack();
        this.vstack = valueStack;
        this.consumer = valueStack;
    }

    public static void setInstance(CallContext ctx) {
        Thread currentThread = Thread.currentThread();
        currentContext.set(ctx);
    }

    public static CallContext getOnlyInstance() {
        return (CallContext) currentContext.get();
    }

    public static CallContext getInstance() {
        CallContext ctx = getOnlyInstance();
        if (ctx != null) {
            return ctx;
        }
        CallContext ctx2 = new CallContext();
        setInstance(ctx2);
        return ctx2;
    }

    /* access modifiers changed from: package-private */
    public Object getArgAsObject(int i) {
        if (i < 8) {
            switch ((this.where >> (i * 4)) & 15) {
                case 1:
                    return this.value1;
                case 2:
                    return this.value2;
                case 3:
                    return this.value3;
                case 4:
                    return this.value4;
                case 5:
                    return IntNum.make(this.ivalue1);
                case 6:
                    return IntNum.make(this.ivalue2);
            }
        }
        return this.values[i];
    }

    public int getArgCount() {
        return this.count;
    }

    public Object getNextArg() {
        int i = this.next;
        if (i < this.count) {
            this.next = i + 1;
            return getArgAsObject(i);
        }
        throw new WrongArguments((Procedure) null, this.count);
    }

    public int getNextIntArg() {
        int i = this.next;
        if (i < this.count) {
            this.next = i + 1;
            return ((Number) getArgAsObject(i)).intValue();
        }
        throw new WrongArguments((Procedure) null, this.count);
    }

    public Object getNextArg(Object defaultValue) {
        int i = this.next;
        if (i >= this.count) {
            return defaultValue;
        }
        this.next = i + 1;
        return getArgAsObject(i);
    }

    public int getNextIntArg(int defaultValue) {
        int i = this.next;
        if (i >= this.count) {
            return defaultValue;
        }
        this.next = i + 1;
        return ((Number) getArgAsObject(i)).intValue();
    }

    public final Object[] getRestArgsArray(int next2) {
        Object[] args = new Object[(this.count - next2)];
        int i = 0;
        while (next2 < this.count) {
            args[i] = getArgAsObject(next2);
            i++;
            next2++;
        }
        return args;
    }

    public final LList getRestArgsList(int next2) {
        LList nil = LList.Empty;
        LList list = nil;
        Pair last = null;
        while (next2 < this.count) {
            int next3 = next2 + 1;
            LList pair = new Pair(getArgAsObject(next2), nil);
            if (last == null) {
                list = pair;
            } else {
                last.setCdr(pair);
            }
            last = pair;
            next2 = next3;
        }
        return list;
    }

    public void lastArg() {
        if (this.next >= this.count) {
            this.values = null;
            return;
        }
        throw new WrongArguments((Procedure) null, this.count);
    }

    public Object[] getArgs() {
        if (this.where == 0) {
            return this.values;
        }
        int n = this.count;
        this.next = 0;
        Object[] args = new Object[n];
        for (int i = 0; i < n; i++) {
            args[i] = getNextArg();
        }
        return args;
    }

    public void runUntilDone() throws Throwable {
        while (true) {
            Procedure proc2 = this.proc;
            if (proc2 != null) {
                this.proc = null;
                proc2.apply(this);
            } else {
                return;
            }
        }
    }

    public final int startFromContext() {
        ValueStack vst = this.vstack;
        int oindex = vst.find(this.consumer);
        vst.ensureSpace(3);
        int gapStart = vst.gapStart;
        int gapStart2 = gapStart + 1;
        vst.data[gapStart] = 61698;
        vst.setIntN(gapStart2, oindex);
        int gapStart3 = gapStart2 + 2;
        this.consumer = vst;
        vst.gapStart = gapStart3;
        return gapStart3;
    }

    public final Object getFromContext(int oldIndex) throws Throwable {
        runUntilDone();
        ValueStack vst = this.vstack;
        Object result = Values.make(vst, oldIndex, vst.gapStart);
        cleanupFromContext(oldIndex);
        return result;
    }

    public final void cleanupFromContext(int oldIndex) {
        ValueStack vst = this.vstack;
        char[] data = vst.data;
        int oindex = (data[oldIndex - 2] << 16) | (data[oldIndex - 1] & SupportMenu.USER_MASK);
        this.consumer = (Consumer) vst.objects[oindex];
        vst.objects[oindex] = null;
        vst.oindex = oindex;
        vst.gapStart = oldIndex - 3;
    }

    public final Object runUntilValue() throws Throwable {
        Consumer consumerSave = this.consumer;
        ValueStack vst = this.vstack;
        this.consumer = vst;
        int dindexSave = vst.gapStart;
        int oindexSave = vst.oindex;
        try {
            runUntilDone();
            return Values.make(vst, dindexSave, vst.gapStart);
        } finally {
            this.consumer = consumerSave;
            vst.gapStart = dindexSave;
            vst.oindex = oindexSave;
        }
    }

    public final void runUntilValue(Consumer out) throws Throwable {
        Consumer consumerSave = this.consumer;
        this.consumer = out;
        try {
            runUntilDone();
        } finally {
            this.consumer = consumerSave;
        }
    }

    public void writeValue(Object value) {
        Values.writeValues(value, this.consumer);
    }
}
