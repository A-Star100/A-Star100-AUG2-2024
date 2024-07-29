package com.amazon.c.a.a;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import okio.Utf8;

/* compiled from: Base64 */
public class c {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 8;
    public static final int g = 16;
    public static final int h = 32;
    static final /* synthetic */ boolean i = true;
    private static final int j = 76;
    private static final byte k = 61;
    private static final byte l = 10;
    private static final String m = "US-ASCII";
    private static final byte n = -5;
    private static final byte o = -1;
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] t = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] u = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private static final byte[] b(int i2) {
        return (i2 & 16) == 16 ? r : (i2 & 32) == 32 ? t : p;
    }

    /* access modifiers changed from: private */
    public static final byte[] c(int i2) {
        return (i2 & 16) == 16 ? s : (i2 & 32) == 32 ? u : q;
    }

    private c() {
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        b(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] b2 = b(i5);
        int i6 = 0;
        int i7 = (i3 > 0 ? (bArr[i2] << Ascii.CAN) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << Ascii.CAN) >>> 16 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << Ascii.CAN) >>> 24;
        }
        int i8 = i7 | i6;
        if (i3 == 1) {
            bArr2[i4] = b2[i8 >>> 18];
            bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = b2[i8 >>> 18];
            bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = b2[i8 >>> 18];
            bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = b2[i8 & 63];
            return bArr2;
        }
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & 255));
            }
        }
    }

    public static String a(Serializable serializable) throws IOException {
        return a(serializable, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.ObjectOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:13|51|52|53|54|55|56|57|58|59) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:4|5|6|(5:8|9|10|11|12)(3:16|17|18)|19|20|21|22|23|24|25|26|27|28|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:2|3|4|5|6|(5:8|9|10|11|12)(3:16|17|18)|19|20|21|22|23|24|25|26|27|28|29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0053, code lost:
        return new java.lang.String(r1.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x007d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.Serializable r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0081
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r1.<init>()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            com.amazon.c.a.a.c$b r2 = new com.amazon.c.a.a.c$b     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r3 = r6 | 1
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r6 = r6 & 2
            if (r6 == 0) goto L_0x0027
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0 = r3
            goto L_0x002f
        L_0x001f:
            r5 = move-exception
            goto L_0x0074
        L_0x0022:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x006f
        L_0x0027:
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x002f:
            r0.writeObject(r5)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.close()     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            r6.close()     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r2.close()     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            r1.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x004a }
            byte[] r6 = r1.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x004a }
            java.lang.String r0 = "US-ASCII"
            r5.<init>(r6, r0)     // Catch:{ UnsupportedEncodingException -> 0x004a }
            return r5
        L_0x004a:
            java.lang.String r5 = new java.lang.String
            byte[] r6 = r1.toByteArray()
            r5.<init>(r6)
            return r5
        L_0x0054:
            r5 = move-exception
            r6 = r0
            goto L_0x0074
        L_0x0057:
            r5 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x006f
        L_0x005c:
            r5 = move-exception
            r6 = r0
            r2 = r6
            goto L_0x0074
        L_0x0060:
            r5 = move-exception
            r6 = r0
            r2 = r6
            r0 = r1
            r1 = r2
            goto L_0x006f
        L_0x0066:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
            goto L_0x0074
        L_0x006b:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
        L_0x006f:
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0074:
            r0.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r6.close()     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            r2.close()     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            r1.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            throw r5
        L_0x0081:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Cannot serialize a null object."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.c.a(java.io.Serializable, int):java.lang.String");
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (i) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2) throws IOException {
        return a(bArr, 0, bArr.length, i2);
    }

    public static String a(byte[] bArr, int i2, int i3) {
        String str;
        try {
            str = a(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (i) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] b2 = b(bArr, i2, i3, i4);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b2);
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return b(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (i) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:31|32|45|46|47|48|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x005e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            r0 = r18
            r7 = r19
            r8 = r20
            if (r0 == 0) goto L_0x011a
            if (r7 < 0) goto L_0x0106
            if (r8 < 0) goto L_0x00f2
            int r1 = r7 + r8
            int r2 = r0.length
            r9 = 1
            if (r1 > r2) goto L_0x00ce
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0062
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0051, all -> 0x004d }
            r2.<init>()     // Catch:{ IOException -> 0x0051, all -> 0x004d }
            com.amazon.c.a.a.c$b r3 = new com.amazon.c.a.a.c$b     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            r4 = r21 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            r3.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x003c:
            r0 = move-exception
            goto L_0x0057
        L_0x003e:
            r0 = move-exception
            goto L_0x004b
        L_0x0040:
            r0 = move-exception
            goto L_0x0058
        L_0x0042:
            r0 = move-exception
            r4 = r1
            goto L_0x004b
        L_0x0045:
            r0 = move-exception
            r3 = r1
            goto L_0x0058
        L_0x0048:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x004b:
            r1 = r2
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0058
        L_0x0051:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x0054:
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            r2 = r1
        L_0x0057:
            r1 = r4
        L_0x0058:
            r1.close()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            r3.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            r2.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            throw r0
        L_0x0062:
            r1 = r21 & 8
            if (r1 == 0) goto L_0x0068
            r11 = r9
            goto L_0x0069
        L_0x0068:
            r11 = 0
        L_0x0069:
            int r1 = r8 / 3
            r12 = 4
            int r1 = r1 * r12
            int r2 = r8 % 3
            if (r2 <= 0) goto L_0x0073
            r2 = r12
            goto L_0x0074
        L_0x0073:
            r2 = 0
        L_0x0074:
            int r1 = r1 + r2
            if (r11 == 0) goto L_0x007a
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x007a:
            r13 = r1
            byte[] r14 = new byte[r13]
            int r15 = r8 + -2
            r6 = 0
            r16 = 0
            r17 = 0
        L_0x0084:
            if (r6 >= r15) goto L_0x00ae
            int r2 = r6 + r7
            r3 = 3
            r1 = r18
            r4 = r14
            r5 = r16
            r10 = r6
            r6 = r21
            b(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r11 == 0) goto L_0x00a7
            r2 = 76
            if (r1 < r2) goto L_0x00a7
            int r1 = r16 + 4
            r2 = 10
            r14[r1] = r2
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00a9
        L_0x00a7:
            r17 = r1
        L_0x00a9:
            int r6 = r10 + 3
            int r16 = r16 + 4
            goto L_0x0084
        L_0x00ae:
            r10 = r6
            if (r10 >= r8) goto L_0x00c1
            int r2 = r10 + r7
            int r3 = r8 - r10
            r1 = r18
            r4 = r14
            r5 = r16
            r6 = r21
            b(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00c1:
            r0 = r16
            int r13 = r13 - r9
            if (r0 > r13) goto L_0x00cd
            byte[] r1 = new byte[r0]
            r2 = 0
            java.lang.System.arraycopy(r14, r2, r1, r2, r0)
            return r1
        L_0x00cd:
            return r14
        L_0x00ce:
            r2 = 0
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            r3[r2] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r3[r9] = r2
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 2
            r3[r2] = r0
            java.lang.String r0 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x00f2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Cannot have length offset: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0106:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Cannot have negative offset: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x011a:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.c.b(byte[], int, int, int):byte[]");
    }

    /* access modifiers changed from: private */
    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        } else if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2)}));
        } else if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i3)}));
        } else {
            byte[] c2 = c(i4);
            byte b2 = bArr[i2 + 2];
            if (b2 == 61) {
                bArr2[i3] = (byte) ((((c2[bArr[i2 + 1]] & 255) << Ascii.FF) | ((c2[bArr[i2]] & 255) << Ascii.DC2)) >>> 16);
                return 1;
            }
            byte b3 = bArr[i5];
            if (b3 == 61) {
                int i7 = ((c2[bArr[i2 + 1]] & 255) << Ascii.FF) | ((c2[bArr[i2]] & 255) << Ascii.DC2) | ((c2[b2] & 255) << 6);
                bArr2[i3] = (byte) (i7 >>> 16);
                bArr2[i3 + 1] = (byte) (i7 >>> 8);
                return 2;
            }
            byte b4 = ((c2[bArr[i2 + 1]] & 255) << Ascii.FF) | ((c2[bArr[i2]] & 255) << Ascii.DC2) | ((c2[b2] & 255) << 6) | (c2[b3] & 255);
            bArr2[i3] = (byte) (b4 >> Ascii.DLE);
            bArr2[i3 + 1] = (byte) (b4 >> 8);
            bArr2[i6] = (byte) b4;
            return 3;
        }
    }

    public static byte[] c(byte[] bArr) throws IOException {
        return c(bArr, 0, bArr.length, 0);
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        } else if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        } else if (i3 == 0) {
            return new byte[0];
        } else {
            if (i3 >= 4) {
                byte[] c2 = c(i4);
                byte[] bArr2 = new byte[((i3 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                while (i2 < i5) {
                    byte b2 = bArr[i2];
                    byte b3 = c2[b2 & 255];
                    if (b3 >= -5) {
                        if (b3 >= -1) {
                            int i8 = i6 + 1;
                            bArr3[i6] = b2;
                            if (i8 > 3) {
                                i7 += b(bArr3, 0, bArr2, i7, i4);
                                if (bArr[i2] == 61) {
                                    break;
                                }
                                i6 = 0;
                            } else {
                                i6 = i8;
                            }
                        }
                        i2++;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)}));
                    }
                }
                byte[] bArr4 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr4, 0, i7);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
    }

    public static byte[] a(String str) throws IOException {
        return a(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:16|17|18|19|20|(6:21|22|(3:23|24|(1:26)(1:67))|27|28|29)|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|(5:17|18|19|20|(6:21|22|(3:23|24|(1:26)(1:67))|27|28|29))|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:54|55|56|57|58|59|60|61) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0089 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x008e
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0009 }
            goto L_0x000d
        L_0x0009:
            byte[] r5 = r5.getBytes()
        L_0x000d:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = c(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L_0x001a
            r6 = r2
            goto L_0x001b
        L_0x001a:
            r6 = r1
        L_0x001b:
            if (r5 == 0) goto L_0x008d
            int r3 = r5.length
            if (r3 < r0) goto L_0x008d
            if (r6 != 0) goto L_0x008d
            byte r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L_0x008d
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            r2.<init>()     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            r3.<init>(r5)     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        L_0x0048:
            int r0 = r4.read(r6)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            if (r0 < 0) goto L_0x0052
            r2.write(r6, r1, r0)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            goto L_0x0048
        L_0x0052:
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            r2.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            r4.close()     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            r3.close()     // Catch:{ Exception -> 0x008d }
            goto L_0x008d
        L_0x0060:
            r5 = move-exception
            goto L_0x006d
        L_0x0062:
            r6 = move-exception
            goto L_0x0072
        L_0x0064:
            r5 = move-exception
            r4 = r0
            goto L_0x006d
        L_0x0067:
            r6 = move-exception
            r4 = r0
            goto L_0x0072
        L_0x006a:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L_0x006d:
            r0 = r2
            goto L_0x0083
        L_0x006f:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x0072:
            r0 = r2
            goto L_0x007b
        L_0x0074:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0083
        L_0x0078:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x007b:
            r6.printStackTrace()     // Catch:{ all -> 0x0082 }
            r0.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x0059
        L_0x0082:
            r5 = move-exception
        L_0x0083:
            r0.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            r4.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0089:
            r3.close()     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            throw r5
        L_0x008d:
            return r5
        L_0x008e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.c.a(java.lang.String, int):byte[]");
    }

    public static void a(byte[] bArr, String str) throws IOException {
        if (bArr != null) {
            b bVar = null;
            try {
                b bVar2 = new b(new FileOutputStream(str), 1);
                try {
                    bVar2.write(bArr);
                    try {
                        bVar2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                    e = e2;
                    bVar = bVar2;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = bVar2;
                    try {
                        bVar.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
            }
        } else {
            throw new NullPointerException("Data to encode was null.");
        }
    }

    public static void a(String str, String str2) throws IOException {
        b bVar = null;
        try {
            b bVar2 = new b(new FileOutputStream(str2), 0);
            try {
                bVar2.write(str.getBytes("US-ASCII"));
                try {
                    bVar2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                bVar = bVar2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                try {
                    bVar.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static byte[] b(String str) throws IOException {
        a aVar = null;
        try {
            File file = new File(str);
            if (file.length() <= 2147483647L) {
                byte[] bArr = new byte[((int) file.length())];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
                int i2 = 0;
                while (true) {
                    try {
                        int read = aVar2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        e = e2;
                        aVar = aVar2;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            }
            throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static String c(String str) throws IOException {
        a aVar = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((((double) file.length()) * 1.4d) + 1.0d), 40)];
            a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
            int i2 = 0;
            while (true) {
                try {
                    int read = aVar2.read(bArr, i2, 4096);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                } catch (IOException e2) {
                    e = e2;
                    aVar = aVar2;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    aVar = aVar2;
                    try {
                        aVar.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i2, "US-ASCII");
            try {
                aVar2.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static void b(String str, String str2) throws IOException {
        String c2 = c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(c2.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static void c(String str, String str2) throws IOException {
        byte[] b2 = b(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(b2);
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    /* compiled from: Base64 */
    public static class a extends FilterInputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private int h;
        private byte[] i;

        public a(InputStream inputStream) {
            this(inputStream, 0);
        }

        public a(InputStream inputStream, int i2) {
            super(inputStream);
            this.h = i2;
            boolean z = true;
            this.g = (i2 & 8) > 0;
            z = (i2 & 1) <= 0 ? false : z;
            this.a = z;
            int i3 = z ? 4 : 3;
            this.d = i3;
            this.c = new byte[i3];
            this.b = -1;
            this.f = 0;
            this.i = c.c(i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[LOOP:1: B:13:0x0036->B:19:0x004c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0052 A[EDGE_INSN: B:49:0x0052->B:20:0x0052 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r10 = this;
                int r0 = r10.b
                r1 = -1
                r2 = 0
                if (r0 >= 0) goto L_0x006c
                boolean r0 = r10.a
                r3 = 4
                if (r0 == 0) goto L_0x0033
                r0 = 3
                byte[] r4 = new byte[r0]
                r5 = r2
                r6 = r5
            L_0x0010:
                if (r5 >= r0) goto L_0x0022
                java.io.InputStream r7 = r10.in
                int r7 = r7.read()
                if (r7 < 0) goto L_0x0022
                byte r7 = (byte) r7
                r4[r5] = r7
                int r6 = r6 + 1
                int r5 = r5 + 1
                goto L_0x0010
            L_0x0022:
                if (r6 <= 0) goto L_0x0032
                r5 = 0
                byte[] r7 = r10.c
                r8 = 0
                int r9 = r10.h
                byte[] unused = com.amazon.c.a.a.c.b(r4, r5, r6, r7, r8, r9)
                r10.b = r2
                r10.e = r3
                goto L_0x006c
            L_0x0032:
                return r1
            L_0x0033:
                byte[] r0 = new byte[r3]
                r4 = r2
            L_0x0036:
                if (r4 >= r3) goto L_0x0052
            L_0x0038:
                java.io.InputStream r5 = r10.in
                int r5 = r5.read()
                if (r5 < 0) goto L_0x0049
                byte[] r6 = r10.i
                r7 = r5 & 127(0x7f, float:1.78E-43)
                byte r6 = r6[r7]
                r7 = -5
                if (r6 <= r7) goto L_0x0038
            L_0x0049:
                if (r5 >= 0) goto L_0x004c
                goto L_0x0052
            L_0x004c:
                byte r5 = (byte) r5
                r0[r4] = r5
                int r4 = r4 + 1
                goto L_0x0036
            L_0x0052:
                if (r4 != r3) goto L_0x0061
                byte[] r3 = r10.c
                int r4 = r10.h
                int r0 = com.amazon.c.a.a.c.b(r0, r2, r3, r2, r4)
                r10.e = r0
                r10.b = r2
                goto L_0x006c
            L_0x0061:
                if (r4 != 0) goto L_0x0064
                return r1
            L_0x0064:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Improperly padded Base64 input."
                r0.<init>(r1)
                throw r0
            L_0x006c:
                int r0 = r10.b
                if (r0 < 0) goto L_0x009f
                int r3 = r10.e
                if (r0 < r3) goto L_0x0075
                return r1
            L_0x0075:
                boolean r3 = r10.a
                if (r3 == 0) goto L_0x0088
                boolean r3 = r10.g
                if (r3 == 0) goto L_0x0088
                int r3 = r10.f
                r4 = 76
                if (r3 < r4) goto L_0x0088
                r10.f = r2
                r0 = 10
                return r0
            L_0x0088:
                int r2 = r10.f
                int r2 = r2 + 1
                r10.f = r2
                byte[] r2 = r10.c
                int r3 = r0 + 1
                r10.b = r3
                byte r0 = r2[r0]
                int r2 = r10.d
                if (r3 < r2) goto L_0x009c
                r10.b = r1
            L_0x009c:
                r0 = r0 & 255(0xff, float:3.57E-43)
                return r0
            L_0x009f:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Error in Base64 code reading stream."
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.c.a.read():int");
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i2 + i4] = (byte) read;
                    i4++;
                } else if (i4 == 0) {
                    return -1;
                }
            }
            return i4;
        }
    }

    /* compiled from: Base64 */
    public static class b extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public void c() {
            this.h = false;
        }

        public b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public b(OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.f = (i2 & 8) != 0;
            z = (i2 & 1) == 0 ? false : z;
            this.a = z;
            int i3 = z ? 3 : 4;
            this.d = i3;
            this.c = new byte[i3];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i2;
            this.j = c.c(i2);
        }

        public void write(int i2) throws IOException {
            if (this.h) {
                this.out.write(i2);
            } else if (this.a) {
                byte[] bArr = this.c;
                int i3 = this.b;
                int i4 = i3 + 1;
                this.b = i4;
                bArr[i3] = (byte) i2;
                if (i4 >= this.d) {
                    this.out.write(c.b(this.g, this.c, this.d, this.i));
                    int i5 = this.e + 4;
                    this.e = i5;
                    if (this.f && i5 >= 76) {
                        this.out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                }
            } else {
                byte b2 = this.j[i2 & 127];
                if (b2 > -5) {
                    byte[] bArr2 = this.c;
                    int i6 = this.b;
                    int i7 = i6 + 1;
                    this.b = i7;
                    bArr2[i6] = (byte) i2;
                    if (i7 >= this.d) {
                        this.out.write(this.g, 0, c.b(bArr2, 0, this.g, 0, this.i));
                        this.b = 0;
                    }
                } else if (b2 != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.h) {
                this.out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }

        public void a() throws IOException {
            if (this.b <= 0) {
                return;
            }
            if (this.a) {
                this.out.write(c.b(this.g, this.c, this.b, this.i));
                this.b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            this.out = null;
        }

        public void b() throws IOException {
            a();
            this.h = true;
        }
    }
}
