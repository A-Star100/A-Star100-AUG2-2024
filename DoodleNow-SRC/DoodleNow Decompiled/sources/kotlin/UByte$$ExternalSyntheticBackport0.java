package kotlin;

import java.util.Iterator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UByte$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(boolean z) {
        return z ? 1231 : 1237;
    }

    public static /* synthetic */ String m(long j, int i) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 == 0) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        if (i < 2 || i > 36) {
            i = 10;
        }
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long m$1 = (i & 1) == 0 ? (j >>> 1) / ((long) (i >>> 1)) : m$1(j, (long) i);
            long j2 = (long) i;
            cArr[63] = Character.forDigit((int) (j - (m$1 * j2)), i);
            i3 = 63;
            while (m$1 > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (m$1 % j2), i);
                m$1 /= j2;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }

    public static /* synthetic */ String m(CharSequence charSequence, Iterable iterable) {
        if (charSequence != null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = iterable.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(charSequence);
                }
            }
            return sb.toString();
        }
        throw new NullPointerException(TtmlNode.RUBY_DELIMITER);
    }

    public static /* synthetic */ boolean m(Object obj) {
        return obj == null;
    }

    public static /* synthetic */ int m$1(int i, int i2) {
        return (int) ((((long) i) & 4294967295L) / (((long) i2) & 4294967295L));
    }

    public static /* synthetic */ long m$1(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0 : 1;
        }
        if (j >= 0) {
            return j / j2;
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (((j - (j3 * j2)) ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE)) {
            i = 0;
        }
        return j3 + ((long) i);
    }

    public static /* synthetic */ String m$1(long j, int i) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 == 0) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        if (i < 2 || i > 36) {
            i = 10;
        }
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long m$1 = (i & 1) == 0 ? (j >>> 1) / ((long) (i >>> 1)) : m$1(j, (long) i);
            long j2 = (long) i;
            cArr[63] = Character.forDigit((int) (j - (m$1 * j2)), i);
            i3 = 63;
            while (m$1 > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (m$1 % j2), i);
                m$1 /= j2;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }
}
