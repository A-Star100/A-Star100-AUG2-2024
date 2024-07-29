package androidx.camera.core.impl.utils;

import com.amazon.a.a.o.b.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

final class ExifAttribute {
    static final Charset ASCII = StandardCharsets.US_ASCII;
    public static final long BYTES_OFFSET_UNKNOWN = -1;
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final int IFD_FORMAT_DOUBLE = 12;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int IFD_FORMAT_SBYTE = 6;
    static final int IFD_FORMAT_SINGLE = 11;
    static final int IFD_FORMAT_SLONG = 9;
    static final int IFD_FORMAT_SRATIONAL = 10;
    static final int IFD_FORMAT_SSHORT = 8;
    static final int IFD_FORMAT_STRING = 2;
    static final int IFD_FORMAT_ULONG = 4;
    static final int IFD_FORMAT_UNDEFINED = 7;
    static final int IFD_FORMAT_URATIONAL = 5;
    static final int IFD_FORMAT_USHORT = 3;
    private static final String TAG = "ExifAttribute";
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    ExifAttribute(int i, int i2, byte[] bArr) {
        this(i, i2, -1, bArr);
    }

    ExifAttribute(int i, int i2, long j, byte[] bArr) {
        this.format = i;
        this.numberOfComponents = i2;
        this.bytesOffset = j;
        this.bytes = bArr;
    }

    public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
        wrap.order(byteOrder);
        for (int i : iArr) {
            wrap.putShort((short) i);
        }
        return new ExifAttribute(3, iArr.length, wrap.array());
    }

    public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
        return createUShort(new int[]{i}, byteOrder);
    }

    public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
        wrap.order(byteOrder);
        for (long j : jArr) {
            wrap.putInt((int) j);
        }
        return new ExifAttribute(4, jArr.length, wrap.array());
    }

    public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
        return createULong(new long[]{j}, byteOrder);
    }

    public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
        wrap.order(byteOrder);
        for (int putInt : iArr) {
            wrap.putInt(putInt);
        }
        return new ExifAttribute(9, iArr.length, wrap.array());
    }

    public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
        return createSLong(new int[]{i}, byteOrder);
    }

    public static ExifAttribute createByte(String str) {
        if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
            byte[] bytes2 = str.getBytes(ASCII);
            return new ExifAttribute(1, bytes2.length, bytes2);
        }
        return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
    }

    public static ExifAttribute createString(String str) {
        byte[] bytes2 = (str + 0).getBytes(ASCII);
        return new ExifAttribute(2, bytes2.length, bytes2);
    }

    public static ExifAttribute createURational(LongRational[] longRationalArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[5] * longRationalArr.length)]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.getNumerator());
            wrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(5, longRationalArr.length, wrap.array());
    }

    public static ExifAttribute createURational(LongRational longRational, ByteOrder byteOrder) {
        return createURational(new LongRational[]{longRational}, byteOrder);
    }

    public static ExifAttribute createSRational(LongRational[] longRationalArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[10] * longRationalArr.length)]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.getNumerator());
            wrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(10, longRationalArr.length, wrap.array());
    }

    public static ExifAttribute createSRational(LongRational longRational, ByteOrder byteOrder) {
        return createSRational(new LongRational[]{longRational}, byteOrder);
    }

    public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
        wrap.order(byteOrder);
        for (double putDouble : dArr) {
            wrap.putDouble(putDouble);
        }
        return new ExifAttribute(12, dArr.length, wrap.array());
    }

    public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
        return createDouble(new double[]{d}, byteOrder);
    }

    public String toString() {
        return "(" + IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0197 A[SYNTHETIC, Splitter:B:163:0x0197] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getValue(java.nio.ByteOrder r11) {
        /*
            r10 = this;
            java.lang.String r0 = "IOException occurred while closing InputStream"
            java.lang.String r1 = "ExifAttribute"
            r2 = 0
            androidx.camera.core.impl.utils.ByteOrderedDataInputStream r3 = new androidx.camera.core.impl.utils.ByteOrderedDataInputStream     // Catch:{ IOException -> 0x0181, all -> 0x017f }
            byte[] r4 = r10.bytes     // Catch:{ IOException -> 0x0181, all -> 0x017f }
            r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0181, all -> 0x017f }
            r3.setByteOrder(r11)     // Catch:{ IOException -> 0x017d }
            int r11 = r10.format     // Catch:{ IOException -> 0x017d }
            r4 = 0
            switch(r11) {
                case 1: goto L_0x0147;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00a8;
                case 6: goto L_0x0147;
                case 7: goto L_0x00ff;
                case 8: goto L_0x008e;
                case 9: goto L_0x0074;
                case 10: goto L_0x004f;
                case 11: goto L_0x0034;
                case 12: goto L_0x001a;
                default: goto L_0x0015;
            }
        L_0x0015:
            r3.close()     // Catch:{ IOException -> 0x0178 }
            goto L_0x017c
        L_0x001a:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            double[] r11 = new double[r11]     // Catch:{ IOException -> 0x017d }
        L_0x001e:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x002b
            double r5 = r3.readDouble()     // Catch:{ IOException -> 0x017d }
            r11[r4] = r5     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x001e
        L_0x002b:
            r3.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x0033:
            return r11
        L_0x0034:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            double[] r11 = new double[r11]     // Catch:{ IOException -> 0x017d }
        L_0x0038:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x0046
            float r5 = r3.readFloat()     // Catch:{ IOException -> 0x017d }
            double r5 = (double) r5     // Catch:{ IOException -> 0x017d }
            r11[r4] = r5     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x0038
        L_0x0046:
            r3.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x004e:
            return r11
        L_0x004f:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            androidx.camera.core.impl.utils.LongRational[] r11 = new androidx.camera.core.impl.utils.LongRational[r11]     // Catch:{ IOException -> 0x017d }
        L_0x0053:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x006b
            int r5 = r3.readInt()     // Catch:{ IOException -> 0x017d }
            long r5 = (long) r5     // Catch:{ IOException -> 0x017d }
            int r7 = r3.readInt()     // Catch:{ IOException -> 0x017d }
            long r7 = (long) r7     // Catch:{ IOException -> 0x017d }
            androidx.camera.core.impl.utils.LongRational r9 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ IOException -> 0x017d }
            r9.<init>(r5, r7)     // Catch:{ IOException -> 0x017d }
            r11[r4] = r9     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x0053
        L_0x006b:
            r3.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x0073:
            return r11
        L_0x0074:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            int[] r11 = new int[r11]     // Catch:{ IOException -> 0x017d }
        L_0x0078:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x0085
            int r5 = r3.readInt()     // Catch:{ IOException -> 0x017d }
            r11[r4] = r5     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x0078
        L_0x0085:
            r3.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x008d:
            return r11
        L_0x008e:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            int[] r11 = new int[r11]     // Catch:{ IOException -> 0x017d }
        L_0x0092:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x009f
            short r5 = r3.readShort()     // Catch:{ IOException -> 0x017d }
            r11[r4] = r5     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x0092
        L_0x009f:
            r3.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00a7:
            return r11
        L_0x00a8:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            androidx.camera.core.impl.utils.LongRational[] r11 = new androidx.camera.core.impl.utils.LongRational[r11]     // Catch:{ IOException -> 0x017d }
        L_0x00ac:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x00c2
            long r5 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x017d }
            long r7 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x017d }
            androidx.camera.core.impl.utils.LongRational r9 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ IOException -> 0x017d }
            r9.<init>(r5, r7)     // Catch:{ IOException -> 0x017d }
            r11[r4] = r9     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x00ac
        L_0x00c2:
            r3.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00ca:
            return r11
        L_0x00cb:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            long[] r11 = new long[r11]     // Catch:{ IOException -> 0x017d }
        L_0x00cf:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x00dc
            long r5 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x017d }
            r11[r4] = r5     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x00cf
        L_0x00dc:
            r3.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00e4:
            return r11
        L_0x00e5:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            int[] r11 = new int[r11]     // Catch:{ IOException -> 0x017d }
        L_0x00e9:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x00f6
            int r5 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x017d }
            r11[r4] = r5     // Catch:{ IOException -> 0x017d }
            int r4 = r4 + 1
            goto L_0x00e9
        L_0x00f6:
            r3.close()     // Catch:{ IOException -> 0x00fa }
            goto L_0x00fe
        L_0x00fa:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00fe:
            return r11
        L_0x00ff:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            byte[] r5 = EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x017d }
            int r5 = r5.length     // Catch:{ IOException -> 0x017d }
            if (r11 < r5) goto L_0x0119
            r11 = r4
        L_0x0107:
            byte[] r5 = EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x017d }
            int r6 = r5.length     // Catch:{ IOException -> 0x017d }
            if (r11 >= r6) goto L_0x0118
            byte[] r6 = r10.bytes     // Catch:{ IOException -> 0x017d }
            byte r6 = r6[r11]     // Catch:{ IOException -> 0x017d }
            byte r5 = r5[r11]     // Catch:{ IOException -> 0x017d }
            if (r6 == r5) goto L_0x0115
            goto L_0x0119
        L_0x0115:
            int r11 = r11 + 1
            goto L_0x0107
        L_0x0118:
            int r4 = r5.length     // Catch:{ IOException -> 0x017d }
        L_0x0119:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x017d }
            r11.<init>()     // Catch:{ IOException -> 0x017d }
        L_0x011e:
            int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x017d }
            if (r4 >= r5) goto L_0x013a
            byte[] r5 = r10.bytes     // Catch:{ IOException -> 0x017d }
            byte r5 = r5[r4]     // Catch:{ IOException -> 0x017d }
            if (r5 != 0) goto L_0x0129
            goto L_0x013a
        L_0x0129:
            r6 = 32
            if (r5 < r6) goto L_0x0132
            char r5 = (char) r5     // Catch:{ IOException -> 0x017d }
            r11.append(r5)     // Catch:{ IOException -> 0x017d }
            goto L_0x0137
        L_0x0132:
            r5 = 63
            r11.append(r5)     // Catch:{ IOException -> 0x017d }
        L_0x0137:
            int r4 = r4 + 1
            goto L_0x011e
        L_0x013a:
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x017d }
            r3.close()     // Catch:{ IOException -> 0x0142 }
            goto L_0x0146
        L_0x0142:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x0146:
            return r11
        L_0x0147:
            byte[] r11 = r10.bytes     // Catch:{ IOException -> 0x017d }
            int r5 = r11.length     // Catch:{ IOException -> 0x017d }
            r6 = 1
            if (r5 != r6) goto L_0x0168
            byte r5 = r11[r4]     // Catch:{ IOException -> 0x017d }
            if (r5 < 0) goto L_0x0168
            if (r5 > r6) goto L_0x0168
            java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x017d }
            char[] r6 = new char[r6]     // Catch:{ IOException -> 0x017d }
            int r5 = r5 + 48
            char r5 = (char) r5     // Catch:{ IOException -> 0x017d }
            r6[r4] = r5     // Catch:{ IOException -> 0x017d }
            r11.<init>(r6)     // Catch:{ IOException -> 0x017d }
            r3.close()     // Catch:{ IOException -> 0x0163 }
            goto L_0x0167
        L_0x0163:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x0167:
            return r11
        L_0x0168:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x017d }
            java.nio.charset.Charset r5 = ASCII     // Catch:{ IOException -> 0x017d }
            r4.<init>(r11, r5)     // Catch:{ IOException -> 0x017d }
            r3.close()     // Catch:{ IOException -> 0x0173 }
            goto L_0x0177
        L_0x0173:
            r11 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r11)
        L_0x0177:
            return r4
        L_0x0178:
            r11 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r11)
        L_0x017c:
            return r2
        L_0x017d:
            r11 = move-exception
            goto L_0x0183
        L_0x017f:
            r11 = move-exception
            goto L_0x0195
        L_0x0181:
            r11 = move-exception
            r3 = r2
        L_0x0183:
            java.lang.String r4 = "IOException occurred during reading a value"
            androidx.camera.core.Logger.w(r1, r4, r11)     // Catch:{ all -> 0x0193 }
            if (r3 == 0) goto L_0x0192
            r3.close()     // Catch:{ IOException -> 0x018e }
            goto L_0x0192
        L_0x018e:
            r11 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r11)
        L_0x0192:
            return r2
        L_0x0193:
            r11 = move-exception
            r2 = r3
        L_0x0195:
            if (r2 == 0) goto L_0x019f
            r2.close()     // Catch:{ IOException -> 0x019b }
            goto L_0x019f
        L_0x019b:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x019f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
    }

    public double getDoubleValue(ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        } else if (value instanceof String) {
            return Double.parseDouble((String) value);
        } else {
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (double) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return (double) iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof LongRational[]) {
                LongRational[] longRationalArr = (LongRational[]) value;
                if (longRationalArr.length == 1) {
                    return longRationalArr[0].toDouble();
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a double value");
            }
        }
    }

    public int getIntValue(ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        } else if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else {
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a integer value");
            }
        }
    }

    public String getStringValue(ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(f.a);
                }
            }
            return sb.toString();
        } else if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(f.a);
                }
            }
            return sb.toString();
        } else if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(f.a);
                }
            }
            return sb.toString();
        } else if (!(value instanceof LongRational[])) {
            return null;
        } else {
            LongRational[] longRationalArr = (LongRational[]) value;
            while (i < longRationalArr.length) {
                sb.append(longRationalArr[i].getNumerator());
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb.append(longRationalArr[i].getDenominator());
                i++;
                if (i != longRationalArr.length) {
                    sb.append(f.a);
                }
            }
            return sb.toString();
        }
    }

    public int size() {
        return IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }
}
