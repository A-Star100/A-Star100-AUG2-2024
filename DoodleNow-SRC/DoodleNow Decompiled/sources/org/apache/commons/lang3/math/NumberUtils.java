package org.apache.commons.lang3.math;

import androidx.camera.video.AudioStats;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Double DOUBLE_MINUS_ONE = new Double(-1.0d);
    public static final Double DOUBLE_ONE = new Double(1.0d);
    public static final Double DOUBLE_ZERO = new Double(AudioStats.AUDIO_AMPLITUDE_NONE);
    public static final Float FLOAT_MINUS_ONE = new Float(-1.0f);
    public static final Float FLOAT_ONE = new Float(1.0f);
    public static final Float FLOAT_ZERO = new Float(0.0f);
    public static final Integer INTEGER_MINUS_ONE = new Integer(-1);
    public static final Integer INTEGER_ONE = new Integer(1);
    public static final Integer INTEGER_ZERO = new Integer(0);
    public static final Long LONG_MINUS_ONE = new Long(-1);
    public static final Long LONG_ONE = new Long(1);
    public static final Long LONG_ZERO = new Long(0);
    public static final Short SHORT_MINUS_ONE = new Short(-1);
    public static final Short SHORT_ONE = new Short(1);
    public static final Short SHORT_ZERO = new Short(0);

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static short toShort(String str) {
        return toShort(str, 0);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:(1:37)|38|(1:43)(1:42)|44|(5:46|(3:48|(2:50|(2:52|(1:54)))|(2:70|71)(3:64|65|66))|72|73|(1:79))|80|81|(1:87)|88|89|90) */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x018e, code lost:
        return createLong(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0193, code lost:
        return createBigInteger(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ec, code lost:
        if (r1 == 'l') goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x016d, code lost:
        throw new java.lang.NumberFormatException(r15 + " is not a valid number.");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x018a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x01b7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x013e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:88:0x0154 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Number createNumber(java.lang.String r15) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            if (r15 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = org.apache.commons.lang3.StringUtils.isBlank(r15)
            if (r1 != 0) goto L_0x01d6
            java.lang.String r1 = "--"
            boolean r1 = r15.startsWith(r1)
            if (r1 == 0) goto L_0x0013
            return r0
        L_0x0013:
            java.lang.String r1 = "0x"
            boolean r1 = r15.startsWith(r1)
            if (r1 != 0) goto L_0x01d1
            java.lang.String r1 = "-0x"
            boolean r1 = r15.startsWith(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x01d1
        L_0x0025:
            int r1 = r15.length()
            r2 = 1
            int r1 = r1 - r2
            char r1 = r15.charAt(r1)
            r3 = 46
            int r4 = r15.indexOf(r3)
            r5 = 101(0x65, float:1.42E-43)
            int r5 = r15.indexOf(r5)
            r6 = 69
            int r6 = r15.indexOf(r6)
            int r5 = r5 + r6
            int r6 = r5 + 1
            java.lang.String r7 = " is not a valid number."
            r8 = -1
            r9 = 0
            if (r4 <= r8) goto L_0x007b
            if (r6 <= r8) goto L_0x0070
            if (r6 < r4) goto L_0x005b
            int r10 = r15.length()
            if (r6 > r10) goto L_0x005b
            int r10 = r4 + 1
            java.lang.String r10 = r15.substring(r10, r6)
            goto L_0x0076
        L_0x005b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x0070:
            int r10 = r4 + 1
            java.lang.String r10 = r15.substring(r10)
        L_0x0076:
            java.lang.String r4 = r15.substring(r9, r4)
            goto L_0x009f
        L_0x007b:
            if (r6 <= r8) goto L_0x009d
            int r4 = r15.length()
            if (r6 > r4) goto L_0x0088
            java.lang.String r4 = r15.substring(r9, r6)
            goto L_0x009e
        L_0x0088:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x009d:
            r4 = r15
        L_0x009e:
            r10 = r0
        L_0x009f:
            boolean r11 = java.lang.Character.isDigit(r1)
            r12 = 0
            r14 = 0
            if (r11 != 0) goto L_0x016e
            if (r1 == r3) goto L_0x016e
            if (r6 <= r8) goto L_0x00be
            int r3 = r15.length()
            int r3 = r3 - r2
            if (r6 >= r3) goto L_0x00be
            int r5 = r5 + 2
            int r0 = r15.length()
            int r0 = r0 - r2
            java.lang.String r0 = r15.substring(r5, r0)
        L_0x00be:
            int r3 = r15.length()
            int r3 = r3 - r2
            java.lang.String r3 = r15.substring(r9, r3)
            boolean r4 = isAllZeros(r4)
            if (r4 == 0) goto L_0x00d5
            boolean r4 = isAllZeros(r0)
            if (r4 == 0) goto L_0x00d5
            r4 = r2
            goto L_0x00d6
        L_0x00d5:
            r4 = r9
        L_0x00d6:
            r5 = 68
            if (r1 == r5) goto L_0x013e
            r5 = 70
            if (r1 == r5) goto L_0x0129
            r5 = 76
            if (r1 == r5) goto L_0x00ee
            r5 = 100
            if (r1 == r5) goto L_0x013e
            r5 = 102(0x66, float:1.43E-43)
            if (r1 == r5) goto L_0x0129
            r4 = 108(0x6c, float:1.51E-43)
            if (r1 != r4) goto L_0x0159
        L_0x00ee:
            if (r10 != 0) goto L_0x0114
            if (r0 != 0) goto L_0x0114
            char r0 = r3.charAt(r9)
            r1 = 45
            if (r0 != r1) goto L_0x0104
            java.lang.String r0 = r3.substring(r2)
            boolean r0 = isDigits(r0)
            if (r0 != 0) goto L_0x010a
        L_0x0104:
            boolean r0 = isDigits(r3)
            if (r0 == 0) goto L_0x0114
        L_0x010a:
            java.lang.Long r15 = createLong(r3)     // Catch:{ NumberFormatException -> 0x010f }
            return r15
        L_0x010f:
            java.math.BigInteger r15 = createBigInteger(r3)
            return r15
        L_0x0114:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x0129:
            java.lang.Float r0 = createFloat(r3)     // Catch:{ NumberFormatException -> 0x013e }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x013e }
            if (r1 != 0) goto L_0x013e
            float r1 = r0.floatValue()     // Catch:{ NumberFormatException -> 0x013e }
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x013d
            if (r4 == 0) goto L_0x013e
        L_0x013d:
            return r0
        L_0x013e:
            java.lang.Double r0 = createDouble(r3)     // Catch:{ NumberFormatException -> 0x0154 }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x0154 }
            if (r1 != 0) goto L_0x0154
            float r1 = r0.floatValue()     // Catch:{ NumberFormatException -> 0x0154 }
            double r1 = (double) r1
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x0153
            if (r4 == 0) goto L_0x0154
        L_0x0153:
            return r0
        L_0x0154:
            java.math.BigDecimal r15 = createBigDecimal(r3)     // Catch:{ NumberFormatException -> 0x0159 }
            return r15
        L_0x0159:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x016e:
            if (r6 <= r8) goto L_0x0181
            int r1 = r15.length()
            int r1 = r1 - r2
            if (r6 >= r1) goto L_0x0181
            int r5 = r5 + 2
            int r0 = r15.length()
            java.lang.String r0 = r15.substring(r5, r0)
        L_0x0181:
            if (r10 != 0) goto L_0x0194
            if (r0 != 0) goto L_0x0194
            java.lang.Integer r15 = createInteger(r15)     // Catch:{ NumberFormatException -> 0x018a }
            return r15
        L_0x018a:
            java.lang.Long r15 = createLong(r15)     // Catch:{ NumberFormatException -> 0x018f }
            return r15
        L_0x018f:
            java.math.BigInteger r15 = createBigInteger(r15)
            return r15
        L_0x0194:
            boolean r1 = isAllZeros(r4)
            if (r1 == 0) goto L_0x01a1
            boolean r0 = isAllZeros(r0)
            if (r0 == 0) goto L_0x01a1
            goto L_0x01a2
        L_0x01a1:
            r2 = r9
        L_0x01a2:
            java.lang.Float r0 = createFloat(r15)     // Catch:{ NumberFormatException -> 0x01b7 }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x01b7 }
            if (r1 != 0) goto L_0x01b7
            float r1 = r0.floatValue()     // Catch:{ NumberFormatException -> 0x01b7 }
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x01b6
            if (r2 == 0) goto L_0x01b7
        L_0x01b6:
            return r0
        L_0x01b7:
            java.lang.Double r0 = createDouble(r15)     // Catch:{ NumberFormatException -> 0x01cc }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x01cc }
            if (r1 != 0) goto L_0x01cc
            double r3 = r0.doubleValue()     // Catch:{ NumberFormatException -> 0x01cc }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x01cb
            if (r2 == 0) goto L_0x01cc
        L_0x01cb:
            return r0
        L_0x01cc:
            java.math.BigDecimal r15 = createBigDecimal(r15)
            return r15
        L_0x01d1:
            java.lang.Integer r15 = createInteger(r15)
            return r15
        L_0x01d6:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.String r0 = "A blank string is not a valid number"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() > 0) {
            return true;
        }
        return false;
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.valueOf(str);
    }

    public static BigInteger createBigInteger(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (!StringUtils.isBlank(str)) {
            return new BigDecimal(str);
        }
        throw new NumberFormatException("A blank string is not a valid number");
    }

    public static long min(long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (jArr.length != 0) {
            long j = jArr[0];
            for (int i = 1; i < jArr.length; i++) {
                long j2 = jArr[i];
                if (j2 < j) {
                    j = j2;
                }
            }
            return j;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static int min(int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (iArr.length != 0) {
            int i = iArr[0];
            for (int i2 = 1; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i3 < i) {
                    i = i3;
                }
            }
            return i;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static short min(short[] sArr) {
        if (sArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (sArr.length != 0) {
            short s = sArr[0];
            for (int i = 1; i < sArr.length; i++) {
                short s2 = sArr[i];
                if (s2 < s) {
                    s = s2;
                }
            }
            return s;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static byte min(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (bArr.length != 0) {
            byte b = bArr[0];
            for (int i = 1; i < bArr.length; i++) {
                byte b2 = bArr[i];
                if (b2 < b) {
                    b = b2;
                }
            }
            return b;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static double min(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length != 0) {
            double d = dArr[0];
            for (int i = 1; i < dArr.length; i++) {
                if (Double.isNaN(dArr[i])) {
                    return Double.NaN;
                }
                double d2 = dArr[i];
                if (d2 < d) {
                    d = d2;
                }
            }
            return d;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static float min(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length != 0) {
            float f = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (Float.isNaN(fArr[i])) {
                    return Float.NaN;
                }
                float f2 = fArr[i];
                if (f2 < f) {
                    f = f2;
                }
            }
            return f;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static long max(long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (jArr.length != 0) {
            long j = jArr[0];
            for (int i = 1; i < jArr.length; i++) {
                long j2 = jArr[i];
                if (j2 > j) {
                    j = j2;
                }
            }
            return j;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static int max(int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (iArr.length != 0) {
            int i = iArr[0];
            for (int i2 = 1; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i3 > i) {
                    i = i3;
                }
            }
            return i;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static short max(short[] sArr) {
        if (sArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (sArr.length != 0) {
            short s = sArr[0];
            for (int i = 1; i < sArr.length; i++) {
                short s2 = sArr[i];
                if (s2 > s) {
                    s = s2;
                }
            }
            return s;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static byte max(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (bArr.length != 0) {
            byte b = bArr[0];
            for (int i = 1; i < bArr.length; i++) {
                byte b2 = bArr[i];
                if (b2 > b) {
                    b = b2;
                }
            }
            return b;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static double max(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length != 0) {
            double d = dArr[0];
            for (int i = 1; i < dArr.length; i++) {
                if (Double.isNaN(dArr[i])) {
                    return Double.NaN;
                }
                double d2 = dArr[i];
                if (d2 > d) {
                    d = d2;
                }
            }
            return d;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static float max(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length != 0) {
            float f = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (Float.isNaN(fArr[i])) {
                    return Float.NaN;
                }
                float f2 = fArr[i];
                if (f2 > f) {
                    f = f2;
                }
            }
            return f;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
        if (r3 >= r0.length) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
        r0 = r0[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0067, code lost:
        if (r0 < '0') goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0069, code lost:
        if (r0 > '9') goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006b, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006c, code lost:
        if (r0 == 'e') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        if (r0 != 'E') goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0071, code lost:
        if (r0 != '.') goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0073, code lost:
        if (r14 != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0075, code lost:
        if (r13 == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0078, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0079, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007a, code lost:
        if (r11 != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x007e, code lost:
        if (r0 == 'd') goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0082, code lost:
        if (r0 == 'D') goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0084, code lost:
        if (r0 == 'f') goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0088, code lost:
        if (r0 != 'F') goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x008a, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x008d, code lost:
        if (r0 == 'l') goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0091, code lost:
        if (r0 != 'L') goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0094, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0095, code lost:
        if (r12 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0097, code lost:
        if (r13 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0099, code lost:
        if (r14 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x009d, code lost:
        if (r11 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x009f, code lost:
        if (r12 == false) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNumber(java.lang.String r17) {
        /*
            boolean r0 = org.apache.commons.lang3.StringUtils.isEmpty(r17)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            char[] r0 = r17.toCharArray()
            int r2 = r0.length
            char r3 = r0[r1]
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L_0x0016
            r3 = r5
            goto L_0x0017
        L_0x0016:
            r3 = r1
        L_0x0017:
            int r6 = r3 + 1
            r7 = 70
            r8 = 102(0x66, float:1.43E-43)
            r9 = 57
            r10 = 48
            if (r2 <= r6) goto L_0x004d
            char r11 = r0[r3]
            if (r11 != r10) goto L_0x004d
            char r6 = r0[r6]
            r11 = 120(0x78, float:1.68E-43)
            if (r6 != r11) goto L_0x004d
            int r3 = r3 + 2
            if (r3 != r2) goto L_0x0032
            return r1
        L_0x0032:
            int r2 = r0.length
            if (r3 >= r2) goto L_0x004c
            char r2 = r0[r3]
            if (r2 < r10) goto L_0x003b
            if (r2 <= r9) goto L_0x0048
        L_0x003b:
            r4 = 97
            if (r2 < r4) goto L_0x0041
            if (r2 <= r8) goto L_0x0048
        L_0x0041:
            r4 = 65
            if (r2 < r4) goto L_0x004b
            if (r2 <= r7) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            int r3 = r3 + 1
            goto L_0x0032
        L_0x004b:
            return r1
        L_0x004c:
            return r5
        L_0x004d:
            int r6 = r2 + -1
            r11 = r1
            r12 = r11
            r13 = r12
            r14 = r13
        L_0x0053:
            r15 = 69
            r4 = 101(0x65, float:1.42E-43)
            r7 = 46
            if (r3 < r6) goto L_0x00a3
            if (r3 >= r2) goto L_0x0062
            if (r11 == 0) goto L_0x0062
            if (r12 != 0) goto L_0x0062
            goto L_0x00a3
        L_0x0062:
            int r2 = r0.length
            if (r3 >= r2) goto L_0x009d
            char r0 = r0[r3]
            if (r0 < r10) goto L_0x006c
            if (r0 > r9) goto L_0x006c
            return r5
        L_0x006c:
            if (r0 == r4) goto L_0x009c
            if (r0 != r15) goto L_0x0071
            goto L_0x009c
        L_0x0071:
            if (r0 != r7) goto L_0x007a
            if (r14 != 0) goto L_0x0079
            if (r13 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            return r12
        L_0x0079:
            return r1
        L_0x007a:
            if (r11 != 0) goto L_0x008b
            r2 = 100
            if (r0 == r2) goto L_0x008a
            r2 = 68
            if (r0 == r2) goto L_0x008a
            if (r0 == r8) goto L_0x008a
            r2 = 70
            if (r0 != r2) goto L_0x008b
        L_0x008a:
            return r12
        L_0x008b:
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 == r2) goto L_0x0095
            r2 = 76
            if (r0 != r2) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            return r1
        L_0x0095:
            if (r12 == 0) goto L_0x009c
            if (r13 != 0) goto L_0x009c
            if (r14 != 0) goto L_0x009c
            r1 = r5
        L_0x009c:
            return r1
        L_0x009d:
            if (r11 != 0) goto L_0x00a2
            if (r12 == 0) goto L_0x00a2
            r1 = r5
        L_0x00a2:
            return r1
        L_0x00a3:
            r16 = 70
            char r5 = r0[r3]
            if (r5 < r10) goto L_0x00b0
            if (r5 > r9) goto L_0x00b0
            r11 = r1
            r4 = 45
            r12 = 1
            goto L_0x00dd
        L_0x00b0:
            if (r5 != r7) goto L_0x00bc
            if (r14 != 0) goto L_0x00bb
            if (r13 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            r4 = 45
            r14 = 1
            goto L_0x00dd
        L_0x00bb:
            return r1
        L_0x00bc:
            if (r5 == r4) goto L_0x00d3
            if (r5 != r15) goto L_0x00c1
            goto L_0x00d3
        L_0x00c1:
            r4 = 43
            if (r5 == r4) goto L_0x00cb
            r4 = 45
            if (r5 != r4) goto L_0x00ca
            goto L_0x00cd
        L_0x00ca:
            return r1
        L_0x00cb:
            r4 = 45
        L_0x00cd:
            if (r11 != 0) goto L_0x00d0
            return r1
        L_0x00d0:
            r11 = r1
            r12 = r11
            goto L_0x00dd
        L_0x00d3:
            r4 = 45
            if (r13 == 0) goto L_0x00d8
            return r1
        L_0x00d8:
            if (r12 != 0) goto L_0x00db
            return r1
        L_0x00db:
            r11 = 1
            r13 = 1
        L_0x00dd:
            int r3 = r3 + 1
            r7 = r16
            r5 = 1
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.isNumber(java.lang.String):boolean");
    }
}
