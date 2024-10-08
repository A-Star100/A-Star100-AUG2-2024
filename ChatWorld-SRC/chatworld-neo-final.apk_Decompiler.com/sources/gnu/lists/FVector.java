package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class FVector extends SimpleVector implements Externalizable, Consumable, Comparable {
    protected static Object[] empty = new Object[0];
    public Object[] data;

    public FVector() {
        this.data = empty;
    }

    public FVector(int num) {
        this.size = num;
        this.data = new Object[num];
    }

    public FVector(int num, Object o) {
        Object[] data2 = new Object[num];
        if (o != null) {
            for (int i = 0; i < num; i++) {
                data2[i] = o;
            }
        }
        this.data = data2;
        this.size = num;
    }

    public FVector(Object[] data2) {
        this.size = data2.length;
        this.data = data2;
    }

    public FVector(List seq) {
        this.data = new Object[seq.size()];
        addAll(seq);
    }

    public static FVector make(Object... data2) {
        return new FVector(data2);
    }

    public int getBufferLength() {
        return this.data.length;
    }

    public void setBufferLength(int length) {
        Object[] objArr = this.data;
        int oldLength = objArr.length;
        if (oldLength != length) {
            Object[] tmp = new Object[length];
            System.arraycopy(objArr, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    /* access modifiers changed from: protected */
    public Object getBuffer() {
        return this.data;
    }

    public void shift(int srcStart, int dstStart, int count) {
        Object[] objArr = this.data;
        System.arraycopy(objArr, srcStart, objArr, dstStart, count);
    }

    public final Object getBuffer(int index) {
        return this.data[index];
    }

    public final Object get(int index) {
        if (index < this.size) {
            return this.data[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final Object setBuffer(int index, Object value) {
        Object[] objArr = this.data;
        Object old = objArr[index];
        objArr[index] = value;
        return old;
    }

    /* access modifiers changed from: protected */
    public void clearBuffer(int start, int count) {
        Object[] d = this.data;
        while (true) {
            count--;
            if (count >= 0) {
                d[start] = null;
                start++;
            } else {
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FVector)) {
            return false;
        }
        FVector obj_vec = (FVector) obj;
        int n = this.size;
        if (obj_vec.data == null || obj_vec.size != n) {
            return false;
        }
        Object[] this_data = this.data;
        Object[] obj_data = obj_vec.data;
        for (int i = 0; i < n; i++) {
            if (!this_data[i].equals(obj_data[i])) {
                return false;
            }
        }
        return true;
    }

    public int compareTo(Object obj) {
        FVector vec2 = (FVector) obj;
        Object[] d1 = this.data;
        Object[] d2 = vec2.data;
        int n1 = this.size;
        int n2 = vec2.size;
        int n = n1 > n2 ? n2 : n1;
        for (int i = 0; i < n; i++) {
            int d = ((Comparable) d1[i]).compareTo((Comparable) d2[i]);
            if (d != 0) {
                return d;
            }
        }
        return n1 - n2;
    }

    public final void setAll(Object new_value) {
        Object[] d = this.data;
        int i = this.size;
        while (true) {
            i--;
            if (i >= 0) {
                d[i] = new_value;
            } else {
                return;
            }
        }
    }

    public boolean consumeNext(int ipos, Consumer out) {
        int index = ipos >>> 1;
        if (index >= this.size) {
            return false;
        }
        out.writeObject(this.data[index]);
        return true;
    }

    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (!out.ignoring()) {
            int end = iposEnd >>> 1;
            if (end > this.size) {
                end = this.size;
            }
            for (int i = iposStart >>> 1; i < end; i++) {
                out.writeObject(this.data[i]);
            }
        }
    }

    public void consume(Consumer out) {
        out.startElement("#vector");
        int len = this.size;
        for (int i = 0; i < len; i++) {
            out.writeObject(this.data[i]);
        }
        out.endElement();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        int n = this.size;
        out.writeInt(n);
        for (int i = 0; i < n; i++) {
            out.writeObject(this.data[i]);
        }
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int n = in.readInt();
        Object[] data2 = new Object[n];
        for (int i = 0; i < n; i++) {
            data2[i] = in.readObject();
        }
        this.size = n;
        this.data = data2;
    }
}
