package com.amazon.c.a.a;

import java.io.IOException;

/* compiled from: KiwiVersionEncrypter */
public class d {
    private static final String a = "Kiwi__Version__Obfuscator";

    private d() {
    }

    public static String a(String str) {
        b(str, "text");
        return c.a(a(str.getBytes()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[SYNTHETIC, Splitter:B:12:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r3, java.lang.String r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "text"
            b(r3, r0)
            java.lang.String r0 = "file"
            b(r4, r0)
            byte[] r3 = r3.getBytes()
            byte[] r3 = a((byte[]) r3)
            java.lang.String r3 = com.amazon.c.a.a.c.a((byte[]) r3)
            r0 = 0
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x002e }
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ all -> 0x002e }
            r2.<init>(r4)     // Catch:{ all -> 0x002e }
            r1.<init>(r2)     // Catch:{ all -> 0x002e }
            r1.write(r3)     // Catch:{ all -> 0x002b }
            r1.flush()     // Catch:{ all -> 0x002b }
            r1.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            return
        L_0x002b:
            r3 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r3 = move-exception
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.d.a(java.lang.String, java.lang.String):void");
    }

    public static String b(String str) throws IOException {
        b(str, "text");
        return new String(a(c.c(str.getBytes())), "UTF-8");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[SYNTHETIC, Splitter:B:14:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r3) throws java.io.IOException {
        /*
            java.lang.String r0 = "file"
            b(r3, r0)
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x002e }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x002e }
            r2.<init>(r3)     // Catch:{ all -> 0x002e }
            r1.<init>(r2)     // Catch:{ all -> 0x002e }
            java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x002b }
            r1.close()     // Catch:{ IOException -> 0x0017 }
        L_0x0017:
            java.lang.String r0 = new java.lang.String
            byte[] r3 = r3.getBytes()
            byte[] r3 = com.amazon.c.a.a.c.c((byte[]) r3)
            byte[] r3 = a((byte[]) r3)
            java.lang.String r1 = "UTF-8"
            r0.<init>(r3, r1)
            return r0
        L_0x002b:
            r3 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r3 = move-exception
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.d.c(java.lang.String):java.lang.String");
    }

    private static void b(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("input '" + str2 + "' cannot be null or empty");
        }
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        byte[] bytes = a.getBytes();
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ bytes[i]);
            i++;
            if (i >= bytes.length) {
                i = 0;
            }
        }
        return bArr2;
    }

    public static void a(String[] strArr) throws Exception {
        if (strArr == null || strArr.length == 0) {
            System.out.println("Usage: com.amazon.mas.kiwi.util.KiwiVersionEncrypter <textToBeEncrypted> [<encryptToFileName>]");
        } else if (strArr.length > 1) {
            a(strArr[0], strArr[1]);
        } else {
            System.out.println(a(strArr[0]));
        }
    }
}
