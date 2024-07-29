package com.amazon.a.a.o.b;

import android.app.Application;
import com.amazon.a.a.k.a;
import com.amazon.a.a.o.c;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: DataAuthenticationKeyLoaderV3 */
public class d implements b {
    private static final c a = new c("DataAuthenticationKeyLoaderV3");
    private static final String b = "AppstoreAuthenticationKey.pem";
    private static final String c = "-----BEGIN PUBLIC KEY-----";
    private static final String d = "-----END PUBLIC KEY-----";
    private static final String e = "RSA";
    @a
    private Application f;
    @a
    private com.amazon.a.a.m.c g;

    public PublicKey a() throws com.amazon.a.a.o.b.a.a {
        if (c.a) {
            a.a("Loading data authentication key...");
        }
        PublicKey b2 = b();
        if (b2 != null) {
            return b2;
        }
        PublicKey c2 = c();
        a(c2);
        return c2;
    }

    private PublicKey b() {
        if (c.a) {
            a.a("Checking KiwiDataStore for key...");
        }
        PublicKey publicKey = (PublicKey) this.g.a(com.amazon.a.a.m.c.a);
        if (c.a) {
            c cVar = a;
            StringBuilder sb = new StringBuilder("Key was cached: ");
            sb.append(publicKey != null);
            cVar.a(sb.toString());
        }
        return publicKey;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0061 A[SYNTHETIC, Splitter:B:28:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.security.PublicKey c() throws com.amazon.a.a.o.b.a.a {
        /*
            r6 = this;
            java.lang.String r0 = "Failed to close stream"
            boolean r1 = com.amazon.a.a.o.c.a
            if (r1 == 0) goto L_0x000d
            com.amazon.a.a.o.c r1 = a
            java.lang.String r2 = "Loading authentication key from apk..."
            r1.a(r2)
        L_0x000d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            android.app.Application r3 = r6.f     // Catch:{ Exception -> 0x0052 }
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = "AppstoreAuthenticationKey.pem"
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ Exception -> 0x0052 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0052 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0052 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0052 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0052 }
        L_0x0029:
            java.lang.String r2 = r4.readLine()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r2 == 0) goto L_0x0033
            r1.append(r2)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            goto L_0x0029
        L_0x0033:
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x0041
        L_0x0037:
            r2 = move-exception
            boolean r3 = com.amazon.a.a.o.c.a
            if (r3 == 0) goto L_0x0041
            com.amazon.a.a.o.c r3 = a
            r3.b(r0, r2)
        L_0x0041:
            java.lang.String r0 = r1.toString()
            java.security.PublicKey r0 = r6.a((java.lang.String) r0)
            return r0
        L_0x004a:
            r1 = move-exception
            r2 = r4
            goto L_0x005f
        L_0x004d:
            r1 = move-exception
            r2 = r4
            goto L_0x0053
        L_0x0050:
            r1 = move-exception
            goto L_0x005f
        L_0x0052:
            r1 = move-exception
        L_0x0053:
            com.amazon.a.a.o.c r3 = a     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "Unable to load authentication Key"
            r3.b(r4, r1)     // Catch:{ all -> 0x0050 }
            com.amazon.a.a.o.b.a.a r1 = com.amazon.a.a.o.b.a.a.d()     // Catch:{ all -> 0x0050 }
            throw r1     // Catch:{ all -> 0x0050 }
        L_0x005f:
            if (r2 == 0) goto L_0x006f
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x006f
        L_0x0065:
            r2 = move-exception
            boolean r3 = com.amazon.a.a.o.c.a
            if (r3 == 0) goto L_0x006f
            com.amazon.a.a.o.c r3 = a
            r3.b(r0, r2)
        L_0x006f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.o.b.d.c():java.security.PublicKey");
    }

    private void a(PublicKey publicKey) {
        if (c.a) {
            a.a("Placing auth key into storage");
        }
        this.g.a(com.amazon.a.a.m.c.a, publicKey);
    }

    public PublicKey a(String str) throws com.amazon.a.a.o.b.a.a {
        try {
            return KeyFactory.getInstance(e).generatePublic(new X509EncodedKeySpec(com.amazon.c.a.a.c.a(str.replace(c, "").replace(d, ""))));
        } catch (Exception e2) {
            throw com.amazon.a.a.o.b.a.a.a(e2);
        }
    }
}
