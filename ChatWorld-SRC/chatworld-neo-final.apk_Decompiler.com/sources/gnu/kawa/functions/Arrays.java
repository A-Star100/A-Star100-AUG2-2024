package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.lists.GeneralArray;
import gnu.lists.SimpleVector;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Arrays {
    static final int[] shapeStrides = {2, 1};
    static final int[] zeros2 = new int[2];

    public static Array shape(Object[] vals) {
        int len = vals.length;
        if ((len & 1) == 0) {
            return new FVector(vals).transpose(zeros2, new int[]{len >> 1, 2}, 0, shapeStrides);
        }
        throw new RuntimeException("shape: not an even number of arguments");
    }

    public static Array make(Array shape, Object value) {
        int rank = shape.getSize(0);
        int[] dimensions = new int[rank];
        int[] lowBounds = null;
        int total = 1;
        int i = rank;
        while (true) {
            i--;
            if (i < 0) {
                return GeneralArray.makeSimple(lowBounds, dimensions, new FVector(total, value));
            }
            int lo = ((Number) shape.getRowMajor(i * 2)).intValue();
            int size = ((Number) shape.getRowMajor((i * 2) + 1)).intValue() - lo;
            dimensions[i] = size;
            if (lo != 0) {
                if (lowBounds == null) {
                    lowBounds = new int[rank];
                }
                lowBounds[i] = lo;
            }
            total *= size;
        }
    }

    public static Array makeSimple(Array shape, SimpleVector base) {
        int rank = shape.getSize(0);
        int[] dimensions = new int[rank];
        int[] lowBounds = null;
        int i = rank;
        while (true) {
            i--;
            if (i < 0) {
                return GeneralArray.makeSimple(lowBounds, dimensions, base);
            }
            int lo = ((Number) shape.getRowMajor(i * 2)).intValue();
            dimensions[i] = ((Number) shape.getRowMajor((i * 2) + 1)).intValue() - lo;
            if (lo != 0) {
                if (lowBounds == null) {
                    lowBounds = new int[rank];
                }
                lowBounds[i] = lo;
            }
        }
    }

    public static int effectiveIndex(Array array, Procedure proc, Object[] args, int[] work) throws Throwable {
        Object mapval = proc.applyN(args);
        if (mapval instanceof Values) {
            Values mapvals = (Values) mapval;
            int i = 0;
            int j = 0;
            while (true) {
                int nextPos = mapvals.nextPos(i);
                i = nextPos;
                if (nextPos == 0) {
                    break;
                }
                work[j] = ((Number) mapvals.getPosPrevious(i)).intValue();
                j++;
            }
        } else {
            work[0] = ((Number) mapval).intValue();
        }
        return array.getEffectiveIndex(work);
    }

    public static Array shareArray(Array array, Array shape, Procedure proc) throws Throwable {
        int offset0;
        Array array2 = array;
        Array array3 = shape;
        Procedure procedure = proc;
        int rank = array3.getSize(0);
        Object[] args = new Object[rank];
        int[] dimensions = new int[rank];
        int[] lowBounds = new int[rank];
        boolean empty = false;
        int i = rank;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            Object low = array3.getRowMajor(i * 2);
            args[i] = low;
            int lo = ((Number) low).intValue();
            lowBounds[i] = lo;
            int size = ((Number) array3.getRowMajor((i * 2) + 1)).intValue() - lo;
            dimensions[i] = size;
            if (size <= 0) {
                empty = true;
            }
        }
        int arank = array.rank();
        int[] offsets = new int[rank];
        if (empty) {
            offset0 = 0;
        } else {
            int[] work = new int[arank];
            int offset02 = effectiveIndex(array2, procedure, args, work);
            int i2 = rank;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                int size2 = dimensions[i2];
                int lo2 = lowBounds[i2];
                if (size2 <= 1) {
                    offsets[i2] = 0;
                } else {
                    Object low2 = args[i2];
                    args[i2] = IntNum.make(lo2 + 1);
                    offsets[i2] = effectiveIndex(array2, procedure, args, work) - offset02;
                    args[i2] = low2;
                }
            }
            offset0 = offset02;
        }
        return array2.transpose(lowBounds, dimensions, offset0, offsets);
    }
}
