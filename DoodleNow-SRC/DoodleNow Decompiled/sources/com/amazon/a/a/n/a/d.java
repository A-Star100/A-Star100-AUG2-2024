package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.a.a.n.a.a.b;
import com.amazon.a.a.o.c;
import com.amazon.d.a.d;
import com.amazon.d.a.e;
import com.amazon.d.a.f;
import com.amazon.d.a.g;
import com.amazon.d.a.h;
import com.amazon.d.a.i;
import com.amazon.d.a.j;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: CommandServiceClient */
public class d {
    /* access modifiers changed from: private */
    public static final c a = new c("CommandServiceClient");
    private static final String b = "com.amazon.venezia.service.command.CommandServiceImpl";
    private static final String c = "com.amazon.venezia.CommandService";
    private com.amazon.d.a.d d;
    private String e;
    /* access modifiers changed from: private */
    public final BlockingQueue<c> f = new LinkedBlockingQueue();
    /* access modifiers changed from: private */
    public final BlockingQueue<com.amazon.d.a.d> g = new LinkedBlockingQueue();
    @com.amazon.a.a.k.a
    private Application h;
    @com.amazon.a.a.k.a
    private b i;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c j;
    private final ServiceConnection k = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.a.a("onServiceConnected");
            d.this.g.add(d.a.a(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            d.a.a("onServiceDisconnected!!!");
        }
    };
    private final i l = new i.a() {
        public void a(j jVar) throws RemoteException {
            d.this.f.add(new c(jVar));
        }

        public void a(h hVar) throws RemoteException {
            d.this.f.add(new c(hVar));
        }

        public void a(f fVar) throws RemoteException {
            d.this.f.add(new c(fVar));
        }

        public void a(g gVar) throws RemoteException {
            d.this.f.add(new c(gVar));
        }
    };

    private boolean d() {
        return this.d != null;
    }

    public String a() {
        return this.e;
    }

    /* compiled from: CommandServiceClient */
    static class a {
        int a;
        boolean b;
        long c;

        a() {
        }
    }

    public c a(com.amazon.d.a.c cVar) throws com.amazon.a.a.n.a.a.c, b, RemoteException {
        a aVar = new a();
        aVar.a = 6;
        aVar.c = 100;
        while (true) {
            try {
                if (!d()) {
                    e();
                }
                return b(cVar);
            } catch (b e2) {
                a((com.amazon.a.a.d.b) e2, aVar);
                if (!aVar.b) {
                    throw e2;
                }
            } catch (com.amazon.a.a.n.a.a.c e3) {
                a((com.amazon.a.a.d.b) e3, aVar);
                if (!aVar.b) {
                    throw e3;
                }
            }
        }
    }

    static void a(com.amazon.a.a.d.b bVar, a aVar) {
        c cVar = a;
        cVar.b("CommandServiceException happened, retriesLeft=" + aVar.a, bVar);
        if (aVar.a == 0) {
            aVar.b = false;
            return;
        }
        aVar.a--;
        aVar.b = true;
        try {
            cVar.a("Sleeping for " + aVar.c + " ms");
            Thread.sleep(aVar.c);
        } catch (InterruptedException unused) {
            aVar.b = false;
        }
        aVar.c *= 2;
    }

    private void e() throws b, com.amazon.a.a.n.a.a.c {
        long currentTimeMillis = System.currentTimeMillis();
        c cVar = a;
        cVar.a("Binding Service!!!");
        Intent f2 = f();
        if (a((Context) this.h, f2)) {
            cVar.a("Found service on one or more packages");
            Intent a2 = a(f2);
            String packageName = a2.getComponent().getPackageName();
            cVar.a("Attempting to bind to service on " + packageName);
            if (this.h.bindService(a2, this.k, 1)) {
                try {
                    cVar.a("Blocking while service is being bound!!");
                    this.d = this.g.take();
                    cVar.a("service bound, returning!!");
                    if (c.a) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        cVar.a("Kiwi.BindService Time: " + (currentTimeMillis2 - currentTimeMillis));
                    }
                    this.j.a(com.amazon.a.a.m.c.f, packageName);
                    this.e = packageName;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new b();
                }
            } else {
                throw new b();
            }
        } else {
            throw new com.amazon.a.a.n.a.a.c();
        }
    }

    private boolean a(Context context, Intent intent) {
        return context.getPackageManager().resolveService(intent, 64) != null;
    }

    private Intent f() {
        Intent intent = new Intent();
        intent.setAction(c);
        a.a("Created intent with  action  com.amazon.venezia.CommandService");
        return intent;
    }

    private Intent a(String str) {
        Intent intent = new Intent();
        intent.setAction(c);
        intent.setClassName(str, b);
        return intent;
    }

    private Intent a(Intent intent) throws com.amazon.a.a.n.a.a.c {
        if (this.e != null) {
            c cVar = a;
            cVar.a("Using previously determined package " + this.e);
            return a(this.e);
        }
        c cVar2 = a;
        cVar2.a("No previously determined package found, checking for suitable package.");
        Intent a2 = a(this.h.getPackageManager().queryIntentServices(intent, 64));
        if (a2 != null) {
            return a2;
        }
        cVar2.a("No app with valid signature was providing our service.");
        throw new com.amazon.a.a.n.a.a.c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r5.a("Signature of package " + r3 + " is okay");
        r2 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent a(java.util.List<android.content.pm.ResolveInfo> r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
        L_0x0003:
            int r3 = r9.size()     // Catch:{ Exception -> 0x009f }
            r4 = -1
            if (r1 >= r3) goto L_0x0097
            java.lang.Object r2 = r9.get(r1)     // Catch:{ Exception -> 0x009f }
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2     // Catch:{ Exception -> 0x009f }
            android.content.pm.ServiceInfo r3 = r2.serviceInfo     // Catch:{ Exception -> 0x009f }
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo     // Catch:{ Exception -> 0x009f }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x009f }
            com.amazon.a.a.o.c r5 = a     // Catch:{ Exception -> 0x009f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r6.<init>()     // Catch:{ Exception -> 0x009f }
            java.lang.String r7 = "Examining package "
            r6.append(r7)     // Catch:{ Exception -> 0x009f }
            r6.append(r3)     // Catch:{ Exception -> 0x009f }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x009f }
            r5.a(r6)     // Catch:{ Exception -> 0x009f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r6.<init>()     // Catch:{ Exception -> 0x009f }
            java.lang.String r7 = "Priority is "
            r6.append(r7)     // Catch:{ Exception -> 0x009f }
            android.content.IntentFilter r2 = r2.filter     // Catch:{ Exception -> 0x009f }
            int r2 = r2.getPriority()     // Catch:{ Exception -> 0x009f }
            r6.append(r2)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x009f }
            r5.a(r2)     // Catch:{ Exception -> 0x009f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r2.<init>()     // Catch:{ Exception -> 0x009f }
            java.lang.String r6 = "Checking signature of package "
            r2.append(r6)     // Catch:{ Exception -> 0x009f }
            r2.append(r3)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009f }
            r5.a(r2)     // Catch:{ Exception -> 0x009f }
            boolean r2 = r8.b((java.lang.String) r3)     // Catch:{ Exception -> 0x009f }
            java.lang.String r6 = "Signature of package "
            if (r2 == 0) goto L_0x007b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r9.<init>()     // Catch:{ Exception -> 0x009f }
            r9.append(r6)     // Catch:{ Exception -> 0x009f }
            r9.append(r3)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = " is okay"
            r9.append(r2)     // Catch:{ Exception -> 0x009f }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x009f }
            r5.a(r9)     // Catch:{ Exception -> 0x009f }
            r2 = r3
            goto L_0x0098
        L_0x007b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r2.<init>()     // Catch:{ Exception -> 0x009f }
            r2.append(r6)     // Catch:{ Exception -> 0x009f }
            r2.append(r3)     // Catch:{ Exception -> 0x009f }
            java.lang.String r4 = " is bad"
            r2.append(r4)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009f }
            r5.a(r2)     // Catch:{ Exception -> 0x009f }
            int r1 = r1 + 1
            r2 = r3
            goto L_0x0003
        L_0x0097:
            r1 = r4
        L_0x0098:
            if (r1 <= r4) goto L_0x00b3
            android.content.Intent r9 = r8.a((java.lang.String) r2)     // Catch:{ Exception -> 0x009f }
            return r9
        L_0x009f:
            r9 = move-exception
            com.amazon.a.a.o.c r1 = a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Caught exception "
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r1.a(r9)
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.n.a.d.a(java.util.List):android.content.Intent");
    }

    private c b(com.amazon.d.a.c cVar) throws RemoteException {
        this.j.a(com.amazon.a.a.m.c.g, cVar.b());
        this.d.a(cVar, this.l);
        return g();
    }

    private c g() throws RemoteException {
        try {
            c cVar = a;
            cVar.a("Blocking for result from service");
            c take = this.f.take();
            cVar.a("Received result from service");
            return take;
        } catch (InterruptedException unused) {
            a.a("TaskThread interrupted, returning null result");
            return null;
        }
    }

    public c a(com.amazon.d.a.a aVar) throws RemoteException {
        aVar.a((com.amazon.d.a.b) null);
        return g();
    }

    public c a(f fVar, final e eVar) throws RemoteException {
        fVar.a(new e.a() {
            public Map b() throws RemoteException {
                return null;
            }

            public String a() throws RemoteException {
                return eVar.name();
            }
        });
        return g();
    }

    public void b() {
        c cVar = a;
        StringBuilder sb = new StringBuilder("Finishing CommandServiceClient, unbinding service: ");
        sb.append(this.d != null);
        cVar.a(sb.toString());
        if (this.d != null) {
            this.h.unbindService(this.k);
            this.d = null;
        }
    }

    private boolean b(String str) {
        c cVar = a;
        cVar.a("isPackageSignatureTrusted " + str);
        return this.i.a(str, i.a);
    }
}
