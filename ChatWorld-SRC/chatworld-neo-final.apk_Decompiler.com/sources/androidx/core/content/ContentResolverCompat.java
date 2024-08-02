package androidx.core.content;

public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.CancellationSignal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.CancellationSignal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.os.CancellationSignal} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.Cursor query(android.content.ContentResolver r8, android.net.Uri r9, java.lang.String[] r10, java.lang.String r11, java.lang.String[] r12, java.lang.String r13, androidx.core.os.CancellationSignal r14) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x002c
            if (r14 == 0) goto L_0x000f
            java.lang.Object r0 = r14.getCancellationSignalObject()     // Catch:{ Exception -> 0x000d }
            goto L_0x0010
        L_0x000d:
            r0 = move-exception
            goto L_0x0021
        L_0x000f:
            r0 = 0
        L_0x0010:
            r7 = r0
            android.os.CancellationSignal r7 = (android.os.CancellationSignal) r7     // Catch:{ Exception -> 0x000d }
            r0 = r7
            android.os.CancellationSignal r0 = (android.os.CancellationSignal) r0     // Catch:{ Exception -> 0x000d }
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x000d }
            return r0
        L_0x0021:
            boolean r1 = r0 instanceof android.os.OperationCanceledException
            if (r1 == 0) goto L_0x002b
            androidx.core.os.OperationCanceledException r1 = new androidx.core.os.OperationCanceledException
            r1.<init>()
            throw r1
        L_0x002b:
            throw r0
        L_0x002c:
            if (r14 == 0) goto L_0x0031
            r14.throwIfCanceled()
        L_0x0031:
            android.database.Cursor r0 = r8.query(r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.ContentResolverCompat.query(android.content.ContentResolver, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, androidx.core.os.CancellationSignal):android.database.Cursor");
    }
}
