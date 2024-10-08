package gnu.mapping;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;

public abstract class MethodProc extends ProcedureN {
    public static final int NO_MATCH = -1;
    public static final int NO_MATCH_AMBIGUOUS = -851968;
    public static final int NO_MATCH_BAD_TYPE = -786432;
    public static final int NO_MATCH_TOO_FEW_ARGS = -983040;
    public static final int NO_MATCH_TOO_MANY_ARGS = -917504;
    static final Type[] unknownArgTypes = {Type.pointer_type};
    protected Object argTypes;

    public int isApplicable(Type[] argTypes2) {
        int argCount = argTypes2.length;
        int num = numArgs();
        if (argCount < (num & 4095) || (num >= 0 && argCount > (num >> 12))) {
            return -1;
        }
        int result = 1;
        int i = argCount;
        while (true) {
            i--;
            if (i < 0) {
                return result;
            }
            int code = getParameterType(i).compare(argTypes2[i]);
            if (code == -3) {
                return -1;
            }
            if (code < 0) {
                result = 0;
            }
        }
    }

    public int numParameters() {
        int num = numArgs();
        int max = num >> 12;
        if (max >= 0) {
            return max;
        }
        return (num & 4095) + 1;
    }

    /* access modifiers changed from: protected */
    public void resolveParameterTypes() {
        this.argTypes = unknownArgTypes;
    }

    public Type getParameterType(int index) {
        if (!(this.argTypes instanceof Type[])) {
            resolveParameterTypes();
        }
        Type[] atypes = (Type[]) this.argTypes;
        if (index < atypes.length && (index < atypes.length - 1 || maxArgs() >= 0)) {
            return atypes[index];
        }
        if (maxArgs() < 0) {
            Type rtype = atypes[atypes.length - 1];
            if (rtype instanceof ArrayType) {
                return ((ArrayType) rtype).getComponentType();
            }
        }
        return Type.objectType;
    }

    public static RuntimeException matchFailAsException(int code, Procedure proc, Object[] args) {
        int arg = (short) code;
        if ((code & -65536) != -786432) {
            return new WrongArguments(proc, args.length);
        }
        return new WrongType(proc, arg, arg > 0 ? args[arg - 1] : null);
    }

    public Object applyN(Object[] args) throws Throwable {
        checkArgCount(this, args.length);
        CallContext ctx = CallContext.getInstance();
        checkN(args, ctx);
        return ctx.runUntilValue();
    }

    public static MethodProc mostSpecific(MethodProc proc1, MethodProc proc2) {
        boolean not1 = false;
        boolean not2 = false;
        int min1 = proc1.minArgs();
        int min2 = proc2.minArgs();
        int max1 = proc1.maxArgs();
        int max2 = proc2.maxArgs();
        MethodProc methodProc = null;
        if ((max1 >= 0 && max1 < min2) || (max2 >= 0 && max2 < min1)) {
            return null;
        }
        int num1 = proc1.numParameters();
        int num2 = proc2.numParameters();
        int limit = num1 > num2 ? num1 : num2;
        if (max1 != max2) {
            if (max1 < 0) {
                not1 = true;
            }
            if (max2 < 0) {
                not2 = true;
            }
        }
        if (min1 < min2) {
            not1 = true;
        } else if (min1 > min2) {
            not2 = true;
        }
        for (int i = 0; i < limit; i++) {
            int comp = proc1.getParameterType(i).compare(proc2.getParameterType(i));
            if (comp == -1) {
                not2 = true;
                if (not1) {
                    return null;
                }
            }
            if (comp == 1) {
                not1 = true;
                if (not2) {
                    return null;
                }
            }
            methodProc = null;
        }
        MethodProc methodProc2 = proc1;
        MethodProc methodProc3 = proc2;
        if (not2) {
            return methodProc2;
        }
        return not1 ? methodProc3 : methodProc;
    }

    public static int mostSpecific(MethodProc[] procs, int length) {
        if (length <= 1) {
            return length - 1;
        }
        MethodProc best = procs[0];
        MethodProc[] bests = null;
        int bestn = 0;
        for (int i = 1; i < length; i++) {
            MethodProc method = procs[i];
            if (best == null) {
                int j = 0;
                while (true) {
                    if (j < bestn) {
                        MethodProc old = bests[j];
                        MethodProc winner = mostSpecific(old, method);
                        if (winner == old) {
                            break;
                        } else if (winner == null) {
                            bests[bestn] = method;
                            bestn++;
                            break;
                        } else {
                            j++;
                        }
                    } else {
                        best = method;
                        bestn = i;
                        break;
                    }
                }
            } else {
                MethodProc winner2 = mostSpecific(best, method);
                if (winner2 == null) {
                    if (bests == null) {
                        bests = new MethodProc[length];
                    }
                    bests[0] = best;
                    bests[1] = method;
                    bestn = 2;
                    best = null;
                } else if (winner2 == method) {
                    best = method;
                    bestn = i;
                }
            }
        }
        if (best == null) {
            return -1;
        }
        return bestn;
    }
}
