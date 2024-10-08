package gnu.bytecode;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Variable extends Location implements Enumeration {
    private static final int LIVE_FLAG = 4;
    private static final int PARAMETER_FLAG = 2;
    private static final int SIMPLE_FLAG = 1;
    static final int UNASSIGNED = -1;
    private int flags = 1;
    Variable next;
    int offset = -1;
    Scope scope;

    public final Variable nextVar() {
        return this.next;
    }

    public final boolean hasMoreElements() {
        return this.next != null;
    }

    public Object nextElement() {
        Variable variable = this.next;
        if (variable != null) {
            return variable;
        }
        throw new NoSuchElementException("Variable enumeration");
    }

    public Variable() {
    }

    public Variable(String name) {
        setName(name);
    }

    public Variable(String name, Type type) {
        setName(name);
        setType(type);
    }

    public final boolean isAssigned() {
        return this.offset != -1;
    }

    public final boolean dead() {
        return (this.flags & 4) == 0;
    }

    private void setFlag(boolean setting, int flag) {
        if (setting) {
            this.flags |= flag;
        } else {
            this.flags &= flag ^ -1;
        }
    }

    public final boolean isSimple() {
        return (this.flags & 1) != 0;
    }

    public final void setSimple(boolean simple) {
        setFlag(simple, 1);
    }

    public final boolean isParameter() {
        return (this.flags & 2) != 0;
    }

    public final void setParameter(boolean parameter) {
        setFlag(parameter, 2);
    }

    public boolean reserveLocal(int varIndex, CodeAttr code) {
        int size = getType().getSizeInWords();
        if (code.locals.used == null) {
            code.locals.used = new Variable[(size + 20)];
        } else if (code.getMaxLocals() + size >= code.locals.used.length) {
            Variable[] new_locals = new Variable[((code.locals.used.length * 2) + size)];
            System.arraycopy(code.locals.used, 0, new_locals, 0, code.getMaxLocals());
            code.locals.used = new_locals;
        }
        for (int j = 0; j < size; j++) {
            if (code.locals.used[varIndex + j] != null) {
                return false;
            }
        }
        for (int j2 = 0; j2 < size; j2++) {
            code.locals.used[varIndex + j2] = this;
        }
        if (varIndex + size > code.getMaxLocals()) {
            code.setMaxLocals(varIndex + size);
        }
        this.offset = varIndex;
        this.flags |= 4;
        if (varIndex != 0 || !"<init>".equals(code.getMethod().getName())) {
            return true;
        }
        setType(code.local_types[0]);
        return true;
    }

    public void allocateLocal(CodeAttr code) {
        if (this.offset == -1) {
            for (int i = 0; !reserveLocal(i, code); i++) {
            }
        }
    }

    public void freeLocal(CodeAttr code) {
        this.flags &= -5;
        int vnum = this.offset + (getType().size > 4 ? 2 : 1);
        while (true) {
            vnum--;
            if (vnum >= this.offset) {
                code.locals.used[vnum] = null;
                Type[] local_types = code.local_types;
                if (local_types != null) {
                    local_types[vnum] = null;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldEmit() {
        Scope sc = this.scope;
        if (!(!isSimple() || this.name == null || sc == null)) {
            Label label = sc.start;
            Label start = label;
            if (label != null) {
                int i = start.position;
                int pos = i;
                if (i >= 0) {
                    Label end = sc.end;
                    return end != null && end.position > pos;
                }
            }
        }
    }

    public String toString() {
        return "Variable[" + getName() + " offset:" + this.offset + ']';
    }
}
