package com.amazon.a;

import android.app.Application;
import android.content.Context;
import com.amazon.a.a.c.f;
import com.amazon.a.a.c.g;
import com.amazon.a.a.i.e;
import com.amazon.a.a.k.d;
import com.amazon.a.a.l.b;
import com.amazon.a.a.o.c;
import java.util.HashMap;

/* compiled from: AppstoreSDK */
public final class a implements d {
    protected static final String a = "ActivityName";
    protected static final String b = "EventName";
    protected static final String c = "Timestamp";
    /* access modifiers changed from: private */
    public static final c d = new c("AppstoreSDK");
    private static final com.amazon.a.a.g.c e = new com.amazon.a.a.g.a();
    /* access modifiers changed from: private */
    public static a f;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a g;
    @com.amazon.a.a.k.a
    private b h;
    @com.amazon.a.a.k.a
    private f i;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b j;
    @com.amazon.a.a.k.a
    private e k;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c l;
    /* access modifiers changed from: private */
    @com.amazon.a.a.k.a
    public Application m;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b n;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.g.c o;

    public static boolean d() {
        return f != null;
    }

    private a(Application application) {
        long currentTimeMillis = System.currentTimeMillis();
        if (c.a) {
            c cVar = d;
            cVar.a("Starting initialization process for application: " + application.getPackageName());
        }
        b(application);
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar2 = d;
            cVar2.a("AppstoreSDK.Constructor Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    private void b(Application application) {
        Object obj;
        com.amazon.a.a.k.c cVar = new com.amazon.a.a.k.c();
        cVar.a(application);
        cVar.a(new com.amazon.a.a.n.d());
        cVar.a(new com.amazon.a.a.m.c());
        cVar.a(new com.amazon.a.a.l.c());
        cVar.a(new com.amazon.a.a.a.c());
        cVar.a(new com.amazon.a.a.i.f());
        cVar.a(new g());
        cVar.a(new com.amazon.a.a.b.b());
        cVar.a(new com.amazon.a.a.h.d());
        cVar.a(new com.amazon.a.a.n.a.d());
        cVar.a(new com.amazon.a.a.o.b.d());
        cVar.a(new com.amazon.a.a.n.a.b());
        if (a(application)) {
            obj = new com.amazon.a.a.g.d();
        } else {
            obj = new com.amazon.a.a.g.b();
        }
        cVar.a(obj);
        cVar.a();
        cVar.b(this);
    }

    public static void a(Context context) {
        if (!d()) {
            synchronized (a.class) {
                if (!d()) {
                    Application application = (Application) context.getApplicationContext();
                    f = new a(application);
                    application.registerActivityLifecycleCallbacks(com.amazon.a.a.f.a.a());
                }
            }
        }
    }

    public static boolean a(Application application) {
        boolean z = (application.getApplicationInfo().flags & 2) != 0;
        boolean l2 = l();
        if (!z || !l2) {
            d.a("Production Mode: Release build or debug.amazon.sandboxmode property is not set on device");
            return false;
        }
        d.a("Sandbox Mode: Debug build and debug.amazon.sandboxmode property is set on device");
        return true;
    }

    private static boolean l() {
        String str;
        try {
            str = (String) Class.forName(com.amazon.a.a.o.b.aq).getMethod(com.amazon.a.a.o.b.ar, new Class[]{String.class}).invoke((Object) null, new Object[]{com.amazon.a.a.o.b.an});
        } catch (Throwable unused) {
            d.b("Unable to retrieve Sandbox property through reflection, using getProp");
            str = a(com.amazon.a.a.o.b.an);
        }
        return com.amazon.a.a.o.b.ao.equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[SYNTHETIC, Splitter:B:19:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC, Splitter:B:24:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r6) {
        /*
            java.lang.String r0 = "Unable to close BufferedReader instance"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x003a }
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ IOException -> 0x003a }
            java.lang.String r4 = "/system/bin/getprop"
            r5 = 0
            r3[r5] = r4     // Catch:{ IOException -> 0x003a }
            r4 = 1
            r3[r4] = r6     // Catch:{ IOException -> 0x003a }
            java.lang.Process r6 = r2.exec(r3)     // Catch:{ IOException -> 0x003a }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003a }
            java.io.InputStream r6 = r6.getInputStream()     // Catch:{ IOException -> 0x003a }
            r3.<init>(r6)     // Catch:{ IOException -> 0x003a }
            r2.<init>(r3)     // Catch:{ IOException -> 0x003a }
            java.lang.String r6 = r2.readLine()     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            r2.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x0031
        L_0x002c:
            com.amazon.a.a.o.c r1 = d
            r1.b(r0)
        L_0x0031:
            return r6
        L_0x0032:
            r6 = move-exception
            r1 = r2
            goto L_0x0050
        L_0x0035:
            r6 = move-exception
            r1 = r2
            goto L_0x003b
        L_0x0038:
            r6 = move-exception
            goto L_0x0050
        L_0x003a:
            r6 = move-exception
        L_0x003b:
            com.amazon.a.a.o.c r2 = d     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "Can't get system property"
            r2.a(r3, r6)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x004d
        L_0x0048:
            com.amazon.a.a.o.c r6 = d
            r6.b(r0)
        L_0x004d:
            java.lang.String r6 = ""
            return r6
        L_0x0050:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ Exception -> 0x0056 }
            goto L_0x005b
        L_0x0056:
            com.amazon.a.a.o.c r1 = d
            r1.b(r0)
        L_0x005b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.a(java.lang.String):java.lang.String");
    }

    @Deprecated
    public static void a(com.amazon.a.a.n.a.a aVar) {
        if (c.a) {
            d.a("WARNING: Use of deprecated method detected.");
        }
        if (d()) {
            c(aVar);
        } else {
            d.b("AppstoreSDK subsystem is not fully initialized.  Cannot process task.");
        }
    }

    /* access modifiers changed from: private */
    public static void c(com.amazon.a.a.n.a.a aVar) {
        if (!d()) {
            d.b("AppstoreSDK subsystem is not fully initialized.  Cannot process task.");
        } else {
            f.j.a(com.amazon.a.a.n.b.d.COMMAND, aVar);
        }
    }

    public static void a(com.amazon.a.a.n.a.a aVar, Context context) {
        if (!d()) {
            if (context == null || context.getApplicationContext() == null) {
                d.b("AppstoreSDK subsystem cannot be initialized because of null context. Unable to enqueue task.");
                return;
            }
            f = new a((Application) context.getApplicationContext());
        }
        c(aVar);
    }

    public static e a() {
        if (d()) {
            return f.k;
        }
        d.b("Appstore SDK is not initialized. Cannot get PromptManager returning null");
        return null;
    }

    public static com.amazon.a.a.a.a b() {
        if (d()) {
            return f.g;
        }
        d.b("Appstore SDK is not initialized. Cannot get ContextManager returning null");
        return null;
    }

    public static com.amazon.a.a.g.c c() {
        if (d()) {
            return f.o;
        }
        d.a("Appstore SDK is not initialized. Returning default log handler");
        return e;
    }

    public static boolean a(String str, String str2) {
        if (d()) {
            try {
                return com.amazon.a.a.o.b.e.a(str, str2, f.n.a());
            } catch (com.amazon.a.a.o.b.a.a e2) {
                c cVar = d;
                cVar.a("Unable to validate signature: " + e2.getMessage());
                return false;
            }
        } else {
            d.a("AppstoreSDK was not yet initialized - cannot do the IAP call");
            return false;
        }
    }

    public static boolean a(String str, Context context) {
        com.amazon.a.a.o.a.a.a();
        if (c.a) {
            c cVar = d;
            cVar.a(str + ": " + context);
        }
        if (d()) {
            return true;
        }
        b(str, context);
        return false;
    }

    private static void b(String str, Context context) {
        if (c.a) {
            c cVar = d;
            cVar.a(str + " called on context: " + context + " when AppstoreSDK is dead, ignoring...");
        }
    }

    public void e() {
        h();
        j();
        f();
        g();
    }

    public void f() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.PAUSE;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(a.b, com.amazon.a.a.a.a.b.PAUSE.name());
                hashMap.put(a.a, aVar.b().getClass().getName());
                hashMap.put("Timestamp", Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(hashMap);
                if (c.a) {
                    a.d.a("Adding lifecycle PAUSE command to pipeline");
                }
                a.c(bVar);
            }
        });
    }

    public void g() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(a.b, com.amazon.a.a.a.a.b.RESUME.name());
                hashMap.put(a.a, aVar.b().getClass().getName());
                hashMap.put("Timestamp", Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(hashMap);
                if (c.a) {
                    a.d.a("Adding lifecycle RESUME command to pipeline");
                }
                a.c(bVar);
            }
        });
    }

    public void h() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.CREATE;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            public void a(com.amazon.a.a.a.a.c cVar) {
                a.this.i();
            }
        });
    }

    public void i() {
        if (c.a) {
            d.a("Enqueuing launch workflow");
        }
        if (!a(this.m)) {
            this.j.a(com.amazon.a.a.n.b.d.COMMAND, m());
        }
    }

    private com.amazon.a.a.n.a m() {
        return new e();
    }

    public void j() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            public void a(com.amazon.a.a.a.a.c cVar) {
                if (c.a) {
                    c k = a.d;
                    k.a("Beginning shutdown process for application: " + a.this.m.getPackageName());
                }
                a unused = a.f = null;
            }
        });
    }
}
