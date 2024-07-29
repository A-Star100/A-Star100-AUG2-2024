package com.amazon.a;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.amazon.a.a.c.f;
import com.amazon.a.a.i.e;
import com.amazon.a.a.k.a;
import com.amazon.a.a.k.d;
import com.amazon.a.a.l.b;
import com.amazon.a.a.o.c;
import java.util.HashMap;

/* compiled from: Kiwi */
public final class g implements d {
    protected static final String a = "ActivityName";
    protected static final String b = "EventName";
    protected static final String c = "Timestamp";
    /* access modifiers changed from: private */
    public static final c d = new c("Kiwi");
    /* access modifiers changed from: private */
    public static g e;
    private final boolean f;
    @a
    private com.amazon.a.a.a.a g;
    @a
    private b h;
    @a
    private f i;
    @a
    private com.amazon.a.a.n.b j;
    @a
    private e k;
    @a
    private com.amazon.a.a.m.c l;
    /* access modifiers changed from: private */
    @a
    public Application m;
    @a
    private com.amazon.a.a.o.b.b n;

    private static boolean c() {
        return e != null;
    }

    private g(Application application, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f = z;
        if (c.a) {
            c cVar = d;
            cVar.a("Starting initialization process for application: " + application.getPackageName());
            cVar.a("DRM enabled: " + z);
        }
        a(application);
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar2 = d;
            cVar2.a("Kiwi.Constructor Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    private void a(Application application) {
        com.amazon.a.a.k.c cVar = new com.amazon.a.a.k.c();
        cVar.a(application);
        cVar.a(new com.amazon.a.a.n.d());
        cVar.a(new com.amazon.a.a.m.c());
        cVar.a(new com.amazon.a.a.l.c());
        cVar.a(new com.amazon.a.a.a.b());
        cVar.a(new com.amazon.a.a.i.f());
        cVar.a(new com.amazon.a.a.c.g());
        cVar.a(new com.amazon.a.a.b.b());
        cVar.a(new com.amazon.a.a.h.d());
        cVar.a(new com.amazon.a.a.n.a.d());
        cVar.a(new com.amazon.a.a.o.b.c());
        cVar.a(new com.amazon.a.a.n.a.b());
        cVar.a();
        cVar.b(this);
    }

    public static void a(Activity activity, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!c()) {
            e = new g(activity.getApplication(), z);
        }
        if (a("onCreate", (Context) activity)) {
            e.g.a(activity);
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ActivityOnCreate Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    @Deprecated
    public static void a(com.amazon.a.a.n.a.a aVar) {
        if (c.a) {
            d.a("WARNING: Use of deprecated method detected.");
        }
        if (c()) {
            c(aVar);
        } else {
            d.b("Kiwi subsystem is not fully initialized.  Cannot process task.");
        }
    }

    /* access modifiers changed from: private */
    public static void c(com.amazon.a.a.n.a.a aVar) {
        e.j.a(com.amazon.a.a.n.b.d.COMMAND, aVar);
    }

    public static void a(com.amazon.a.a.n.a.a aVar, Context context) {
        if (!c()) {
            if (context == null || context.getApplicationContext() == null) {
                d.b("Kiwi subsystem cannot be initialized because of null context. Unable to enqueue task.");
                return;
            }
            e = new g((Application) context.getApplicationContext(), false);
        }
        c(aVar);
    }

    public static e a() {
        return e.k;
    }

    public static boolean a(String str, String str2) {
        if (c()) {
            try {
                return com.amazon.a.a.o.b.e.a(str, str2, e.n.a());
            } catch (com.amazon.a.a.o.b.a.a e2) {
                c cVar = d;
                cVar.a("Unable to validate signature: " + e2.getMessage());
                return false;
            }
        } else {
            d.a("Kiwi was not yet initialized - cannot do the IAP call");
            return false;
        }
    }

    private static boolean a(String str, Context context) {
        com.amazon.a.a.o.a.a.a();
        if (c.a) {
            c cVar = d;
            cVar.a(str + ": " + context);
        }
        if (c()) {
            return true;
        }
        b(str, context);
        return false;
    }

    private static void b(String str, Context context) {
        if (c.a) {
            c cVar = d;
            cVar.a(str + " called on context: " + context + " when Kiwi is dead, ignoring...");
        }
    }

    public static void a(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onResume", (Context) activity)) {
            e.g.c(activity);
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ActivityOnResume Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public static void b(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onPause", (Context) activity)) {
            e.g.d(activity);
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ActivityOnPause Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public static void c(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onDestroy", (Context) activity)) {
            try {
                e.g.b(activity);
            } catch (Exception e2) {
                d.b("Kiwi.ActivityOnDestroy Error: ", e2);
            }
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ActivityOnDestroy Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public static void d(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onStart", (Context) activity)) {
            e.g.e(activity);
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ActivityOnStart Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public static void e(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onStop", (Context) activity)) {
            e.g.f(activity);
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ActivityOnStop Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public static Dialog a(Activity activity, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onCreateDialog", (Context) activity)) {
            return e.k.a(activity, i2);
        }
        if (!c.a) {
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        c cVar = d;
        cVar.a("Kiwi.ActivityOnCreateDialog Time: " + (currentTimeMillis2 - currentTimeMillis));
        return null;
    }

    public static boolean a(Activity activity, int i2, int i3, Intent intent) {
        if (!a("onActivityResult", (Context) activity)) {
            return false;
        }
        return e.h.a(new com.amazon.a.a.l.a(activity, i2, i3, intent));
    }

    public static void b(Activity activity, boolean z) {
        if (a("onWindowFocusChanged", (Context) activity)) {
            e.k.a(activity, z);
        }
    }

    public static void a(Service service, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onCreate", (Context) service)) {
            e.g.a(service);
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ServiceOnCreate Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public static void a(Service service) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a("onDestroy", (Context) service)) {
            e.g.b(service);
        }
        if (c.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            c cVar = d;
            cVar.a("Kiwi.ServiceOnDestroy Time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    public void e() {
        g();
        j();
        d();
        f();
    }

    private void d() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.PAUSE;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(g.b, com.amazon.a.a.a.a.b.PAUSE.name());
                hashMap.put(g.a, aVar.b().getClass().getName());
                hashMap.put("Timestamp", Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(hashMap);
                if (c.a) {
                    g.d.a("Adding lifecycle PAUSE command to pipeline");
                }
                g.c((com.amazon.a.a.n.a.a) bVar);
            }
        });
    }

    private void f() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(g.b, com.amazon.a.a.a.a.b.RESUME.name());
                hashMap.put(g.a, aVar.b().getClass().getName());
                hashMap.put("Timestamp", Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(hashMap);
                if (c.a) {
                    g.d.a("Adding lifecycle RESUME command to pipeline");
                }
                g.c((com.amazon.a.a.n.a.a) bVar);
            }
        });
    }

    private void g() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.CREATE;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            public void a(com.amazon.a.a.a.a.c cVar) {
                g.this.h();
            }
        });
    }

    /* access modifiers changed from: private */
    public void h() {
        if (c.a) {
            d.a("Enqueuing launch workflow");
        }
        this.j.a(com.amazon.a.a.n.b.d.COMMAND, i());
    }

    private com.amazon.a.a.n.a i() {
        if (this.f) {
            return new f();
        }
        return new e();
    }

    private void j() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            public void a(com.amazon.a.a.a.a.c cVar) {
                if (c.a) {
                    c b = g.d;
                    b.a("Beginning shutdown process for application: " + g.this.m.getPackageName());
                }
                g unused = g.e = null;
            }
        });
    }
}
