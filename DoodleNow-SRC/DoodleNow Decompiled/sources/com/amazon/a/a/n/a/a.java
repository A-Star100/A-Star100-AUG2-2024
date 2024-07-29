package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.a.a.i.e;
import com.amazon.a.a.l.b;
import com.amazon.a.a.n.a.a.d;
import com.amazon.a.a.n.a.a.f;
import com.amazon.a.a.o.c;
import com.amazon.d.a.c;
import com.amazon.d.a.g;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.Map;

/* compiled from: AbstractCommandTask */
public abstract class a extends com.amazon.a.a.n.c.a {
    private static final c b = new c("AbstractCommandTask");
    @com.amazon.a.a.k.a
    protected b a;
    /* access modifiers changed from: private */
    @com.amazon.a.a.k.a
    public Application c;
    @com.amazon.a.a.k.a
    private d d;
    @com.amazon.a.a.k.a
    private e e;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c f;
    @com.amazon.a.a.k.a
    private b g;

    /* access modifiers changed from: protected */
    public abstract void a(h hVar) throws RemoteException, com.amazon.a.a.d.b;

    /* access modifiers changed from: protected */
    public abstract void a(j jVar) throws RemoteException, com.amazon.a.a.d.b;

    /* access modifiers changed from: protected */
    public abstract String a_();

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> b();

    /* access modifiers changed from: protected */
    public abstract String c();

    /* access modifiers changed from: protected */
    public abstract boolean d();

    /* access modifiers changed from: protected */
    public void e() throws com.amazon.a.a.d.b {
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (com.amazon.a.a.o.c.a != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0079, code lost:
        if (com.amazon.a.a.o.c.a == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
        b.a("Task finished");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0080, code lost:
        j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r6 = this;
            java.lang.String r0 = "----------------------------------------------"
            java.lang.String r1 = "Task finished"
            java.lang.String r2 = "Executing Command: "
            java.lang.String r3 = "Executing: "
            boolean r4 = com.amazon.a.a.o.c.a     // Catch:{ all -> 0x0073 }
            if (r4 == 0) goto L_0x0027
            com.amazon.a.a.o.c r4 = b     // Catch:{ all -> 0x0073 }
            r4.a(r0)     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r5.<init>(r3)     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = r6.a_()     // Catch:{ all -> 0x0073 }
            r5.append(r3)     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0073 }
            r4.a(r3)     // Catch:{ all -> 0x0073 }
            r4.a(r0)     // Catch:{ all -> 0x0073 }
        L_0x0027:
            r6.e()     // Catch:{ all -> 0x0073 }
            boolean r0 = r6.d()     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x0048
            boolean r0 = com.amazon.a.a.o.c.a     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x003b
            com.amazon.a.a.o.c r0 = b     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "Execution not needed, quitting"
            r0.a(r2)     // Catch:{ all -> 0x0073 }
        L_0x003b:
            boolean r0 = com.amazon.a.a.o.c.a
            if (r0 == 0) goto L_0x0044
            com.amazon.a.a.o.c r0 = b
            r0.a(r1)
        L_0x0044:
            r6.j()
            return
        L_0x0048:
            boolean r0 = com.amazon.a.a.o.c.a     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0061
            com.amazon.a.a.o.c r0 = b     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r3.<init>(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = r6.a_()     // Catch:{ all -> 0x0073 }
            r3.append(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
            r0.a(r2)     // Catch:{ all -> 0x0073 }
        L_0x0061:
            com.amazon.a.a.n.a.d r0 = r6.d     // Catch:{ all -> 0x0073 }
            com.amazon.d.a.c r2 = r6.i()     // Catch:{ all -> 0x0073 }
            com.amazon.a.a.n.a.c r0 = r0.a((com.amazon.d.a.c) r2)     // Catch:{ all -> 0x0073 }
            r6.a((com.amazon.a.a.n.a.c) r0)     // Catch:{ all -> 0x0073 }
            boolean r0 = com.amazon.a.a.o.c.a
            if (r0 == 0) goto L_0x0080
            goto L_0x007b
        L_0x0073:
            r0 = move-exception
            r6.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0084 }
            boolean r0 = com.amazon.a.a.o.c.a
            if (r0 == 0) goto L_0x0080
        L_0x007b:
            com.amazon.a.a.o.c r0 = b
            r0.a(r1)
        L_0x0080:
            r6.j()
            return
        L_0x0084:
            r0 = move-exception
            boolean r2 = com.amazon.a.a.o.c.a
            if (r2 == 0) goto L_0x008e
            com.amazon.a.a.o.c r2 = b
            r2.a(r1)
        L_0x008e:
            r6.j()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.n.a.a.a():void");
    }

    private void a(c cVar) throws com.amazon.a.a.d.b, RemoteException {
        if (c.a) {
            c cVar2 = b;
            cVar2.a("Received result from CommandService: " + cVar);
        }
        if (cVar == null) {
            if (c.a) {
                b.a("Received null result from command service, exiting task");
            }
        } else if (cVar.e() != null) {
            a(cVar.e());
        } else {
            this.g.a(cVar.a(), this.d.a());
            if (cVar.b() != null) {
                b(cVar.b());
            } else if (cVar.c() != null) {
                b(cVar.c());
            } else if (f()) {
                a(cVar.d());
            }
        }
    }

    private void a(g gVar) throws RemoteException, com.amazon.a.a.d.b {
        throw new f(gVar);
    }

    private void b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        if (c.a) {
            b.a("Command executed successfully");
        }
        a(jVar);
    }

    private void b(h hVar) throws RemoteException, com.amazon.a.a.d.b {
        if (c.a) {
            c cVar = b;
            cVar.a("Command failed execution: " + hVar.b());
        }
        a(hVar);
    }

    private void a(com.amazon.d.a.f fVar) throws RemoteException, com.amazon.a.a.d.b {
        if (c.a) {
            b.a("Handling Decision");
        }
        try {
            f fVar2 = new f(fVar);
            this.e.a(fVar2);
            com.amazon.d.a.a i = fVar2.i();
            if (i == null) {
                if (c.a) {
                    b.a("DecisionChooser returned null!!, expiring");
                }
                a(fVar, e.EXPIRATION_DURATION_ELAPSED);
                return;
            }
            a(fVar, i);
        } catch (com.amazon.a.a.n.a.a.e e2) {
            a(fVar, e2.a());
        }
    }

    private void a(com.amazon.d.a.f fVar, com.amazon.d.a.a aVar) throws RemoteException, com.amazon.a.a.d.b {
        if (c.a) {
            c cVar = b;
            cVar.a("Handling customer choice: " + aVar);
        }
        Intent b2 = aVar.b();
        if (b2 != null) {
            if (c.a) {
                b.a("Choice has intent, scheduling it to be fired!!");
            }
            com.amazon.a.a.l.a a2 = this.a.a(b2);
            if (a2 == null) {
                if (c.a) {
                    b.a("No result recived, expiring decision");
                }
                a(fVar, e.EXPIRATION_DURATION_ELAPSED);
            } else if (a2.d() == 0) {
                if (c.a) {
                    b.a("Result canceled, expiring decision");
                }
                a(fVar, e.ACTION_CANCELED);
            } else {
                if (c.a) {
                    b.a("Result received!!!, notifying service");
                }
                a(this.d.a(aVar));
            }
        } else {
            if (c.a) {
                b.a("No intent given, choosing now");
            }
            a(this.d.a(aVar));
        }
    }

    private void a(com.amazon.d.a.f fVar, e eVar) throws RemoteException, com.amazon.a.a.d.b {
        if (c.a) {
            c cVar = b;
            cVar.a("Expiring Decision: " + fVar + ", reason: " + eVar);
        }
        a(this.d.a(fVar, eVar));
    }

    private com.amazon.d.a.c i() {
        return new c.a() {
            public String a() throws RemoteException {
                return a.this.c();
            }

            public String b() throws RemoteException {
                return a.this.a_();
            }

            public Map c() throws RemoteException {
                return a.this.b();
            }

            public String d() throws RemoteException {
                return a.this.c.getPackageName();
            }
        };
    }

    private void a(Throwable th) {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = b;
            cVar.a("Exception occurred while processing task: " + th, th);
        }
        com.amazon.a.a.d.b b2 = b(th);
        b(b2);
        this.f.a(a(b2));
    }

    private com.amazon.a.a.d.b b(Throwable th) {
        if (th instanceof com.amazon.a.a.d.b) {
            return (com.amazon.a.a.d.b) th;
        }
        if (th instanceof RemoteException) {
            return new d((RemoteException) th);
        }
        return new com.amazon.a.a.n.a.a.h(th);
    }

    /* access modifiers changed from: protected */
    public com.amazon.a.a.h.a a(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.h.a aVar = new com.amazon.a.a.h.a(g());
        aVar.a("subType", bVar.a()).a("reason", bVar.b()).a("context", bVar.c());
        return aVar;
    }

    /* access modifiers changed from: protected */
    public String g() {
        return a_() + "_failure";
    }

    /* access modifiers changed from: protected */
    public String h() {
        return a_() + "_success";
    }

    /* access modifiers changed from: protected */
    public void b(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.o.c cVar = b;
        cVar.b("On Exception!!!!: " + bVar);
    }

    private void j() {
        if (!m()) {
            this.d.b();
        }
    }
}
