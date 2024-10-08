package kawa.standard;

import gnu.kawa.functions.ObjectFormat;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class TracedProcedure extends ProcedureN {
    static Symbol curIndentSym = Symbol.makeUninterned("current-indentation");
    static int indentationStep = 2;
    boolean enabled;
    public Procedure proc;

    public TracedProcedure(Procedure proc2, boolean enable) {
        this.proc = proc2;
        this.enabled = enable;
        String name = proc2.getName();
        if (name != null) {
            setName(name);
        }
    }

    static void put(Object value, PrintWriter out) {
        try {
            if (!ObjectFormat.format(value, (Writer) out, 50, true)) {
                out.print("...");
            }
        } catch (IOException ex) {
            out.print("<caught ");
            out.print(ex);
            out.print('>');
        }
    }

    static void indent(int i, PrintWriter out) {
        while (true) {
            i--;
            if (i >= 0) {
                out.print(' ');
            } else {
                return;
            }
        }
    }

    public Object applyN(Object[] args) throws Throwable {
        int curIndent;
        if (!this.enabled) {
            return this.proc.applyN(args);
        }
        Location curIndentLoc = Environment.getCurrent().getLocation(curIndentSym);
        Object oldIndent = curIndentLoc.get((Object) null);
        if (!(oldIndent instanceof IntNum)) {
            curIndent = 0;
            curIndentLoc.set(IntNum.zero());
        } else {
            curIndent = ((IntNum) oldIndent).intValue();
        }
        PrintWriter out = OutPort.errDefault();
        String name = getName();
        if (name == null) {
            name = "??";
        }
        indent(curIndent, out);
        out.print("call to ");
        out.print(name);
        int len = args.length;
        out.print(" (");
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                out.print(' ');
            }
            put(args[i], out);
        }
        out.println(")");
        Object save = curIndentLoc.setWithSave(IntNum.make(indentationStep + curIndent));
        try {
            Object result = this.proc.applyN(args);
            curIndentLoc.setRestore(save);
            indent(curIndent, out);
            out.print("return from ");
            out.print(name);
            out.print(" => ");
            put(result, out);
            out.println();
            return result;
        } catch (RuntimeException e) {
            indent(curIndent, out);
            out.println("procedure " + name + " throws exception " + e);
            throw e;
        } catch (Throwable th) {
            e = th;
            curIndentLoc.setRestore(save);
            throw e;
        }
    }

    public static Procedure doTrace(Procedure proc2, boolean enable) {
        if (!(proc2 instanceof TracedProcedure)) {
            return new TracedProcedure(proc2, enable);
        }
        ((TracedProcedure) proc2).enabled = enable;
        return proc2;
    }

    public void print(PrintWriter ps) {
        ps.print("#<procedure ");
        String n = getName();
        if (n == null) {
            ps.print("<unnamed>");
        } else {
            ps.print(n);
        }
        ps.print(this.enabled ? ", traced>" : ">");
    }
}
