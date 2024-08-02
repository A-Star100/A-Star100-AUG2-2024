package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolString extends CpoolEntry {
    CpoolUtf8 str;

    CpoolString() {
    }

    CpoolString(ConstantPool cpool, int hash, CpoolUtf8 str2) {
        super(cpool, hash);
        this.str = str2;
    }

    public int getTag() {
        return 8;
    }

    public final CpoolUtf8 getString() {
        return this.str;
    }

    static final int hashCode(CpoolUtf8 str2) {
        return str2.hashCode() ^ 62223;
    }

    public int hashCode() {
        if (this.hash == 0) {
            this.hash = hashCode(this.str);
        }
        return this.hash;
    }

    /* access modifiers changed from: package-private */
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeByte(8);
        dstr.writeShort(this.str.index);
    }

    public void print(ClassTypeWriter dst, int verbosity) {
        if (verbosity > 0) {
            dst.print("String ");
            if (verbosity == 2) {
                dst.printOptionalIndex((CpoolEntry) this.str);
            }
        }
        dst.printConstantTersely(this.str.index, 1);
    }
}
