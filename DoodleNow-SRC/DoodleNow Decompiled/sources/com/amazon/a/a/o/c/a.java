package com.amazon.a.a.o.c;

import com.amazon.a.a.o.c;

/* compiled from: Serializer */
public class a {
    private static final c a = new c("Serializer");

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029 A[Catch:{ all -> 0x003e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.Serializable r6) {
        /*
            java.lang.String r0 = "Could not serialize object: "
            r1 = 0
            if (r6 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r3.writeObject(r6)     // Catch:{ IOException -> 0x001f }
            byte[] r2 = r2.toByteArray()     // Catch:{ IOException -> 0x001f }
            java.lang.String r6 = com.amazon.c.a.a.c.a((byte[]) r2)     // Catch:{ IOException -> 0x001f }
            com.amazon.a.a.o.a.a((java.io.OutputStream) r3)
            return r6
        L_0x001f:
            r2 = move-exception
            goto L_0x0025
        L_0x0021:
            r6 = move-exception
            goto L_0x0040
        L_0x0023:
            r2 = move-exception
            r3 = r1
        L_0x0025:
            boolean r4 = com.amazon.a.a.o.c.b     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x003a
            com.amazon.a.a.o.c r4 = a     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r5.<init>(r0)     // Catch:{ all -> 0x003e }
            r5.append(r6)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x003e }
            r4.b(r6, r2)     // Catch:{ all -> 0x003e }
        L_0x003a:
            com.amazon.a.a.o.a.a((java.io.OutputStream) r3)
            return r1
        L_0x003e:
            r6 = move-exception
            r1 = r3
        L_0x0040:
            com.amazon.a.a.o.a.a((java.io.OutputStream) r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.o.c.a.a(java.io.Serializable):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d A[Catch:{ all -> 0x0042 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.String r6) {
        /*
            java.lang.String r0 = "Could not read object from string: "
            r1 = 0
            if (r6 == 0) goto L_0x0054
            int r2 = r6.length()
            if (r2 != 0) goto L_0x000c
            goto L_0x0054
        L_0x000c:
            byte[] r2 = r6.getBytes()     // Catch:{ IOException -> 0x0048 }
            byte[] r2 = com.amazon.c.a.a.c.c((byte[]) r2)     // Catch:{ IOException -> 0x0048 }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0027, all -> 0x0025 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0027, all -> 0x0025 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0027, all -> 0x0025 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0027, all -> 0x0025 }
            java.lang.Object r1 = r3.readObject()     // Catch:{ Exception -> 0x0023 }
            goto L_0x003e
        L_0x0023:
            r2 = move-exception
            goto L_0x0029
        L_0x0025:
            r6 = move-exception
            goto L_0x0044
        L_0x0027:
            r2 = move-exception
            r3 = r1
        L_0x0029:
            boolean r4 = com.amazon.a.a.o.c.b     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x003e
            com.amazon.a.a.o.c r4 = a     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r5.<init>(r0)     // Catch:{ all -> 0x0042 }
            r5.append(r6)     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x0042 }
            r4.b(r6, r2)     // Catch:{ all -> 0x0042 }
        L_0x003e:
            com.amazon.a.a.o.a.a((java.io.InputStream) r3)
            return r1
        L_0x0042:
            r6 = move-exception
            r1 = r3
        L_0x0044:
            com.amazon.a.a.o.a.a((java.io.InputStream) r1)
            throw r6
        L_0x0048:
            r6 = move-exception
            boolean r0 = com.amazon.a.a.o.c.b
            if (r0 == 0) goto L_0x0054
            com.amazon.a.a.o.c r0 = a
            java.lang.String r2 = "Could not decode string"
            r0.b(r2, r6)
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.o.c.a.a(java.lang.String):java.lang.Object");
    }
}
