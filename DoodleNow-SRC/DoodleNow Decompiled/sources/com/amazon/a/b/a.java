package com.amazon.a.b;

import android.app.Application;
import android.os.RemoteException;
import com.amazon.a.a.n.b;
import com.amazon.a.a.n.b.d;
import com.amazon.a.a.o.b.f;
import com.amazon.a.a.o.c;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;

/* compiled from: AcquireApplicationLicenseTask */
public class a extends com.amazon.a.a.n.a.a {
    private static final c b = new c("VerifyApplicationEntitlmentTask");
    private f c = new f();
    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c d;
    @com.amazon.a.a.k.a
    private Application e;
    @com.amazon.a.a.k.a
    private b f;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c g;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b h;

    /* access modifiers changed from: protected */
    public String a_() {
        return "get_license";
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> b() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "1.0";
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        g gVar = new g(jVar.b());
        b a = a(gVar, this.h.a());
        if (a != null) {
            a(gVar, a);
            a(a);
            this.d.a(new com.amazon.a.b.b.a());
            this.f.a(d.BACKGROUND, new i());
        }
    }

    private b a(g gVar, PublicKey publicKey) throws com.amazon.a.a.o.b.a.b, com.amazon.a.a.o.b.a.c {
        return new b(new f(gVar.c(), publicKey));
    }

    private void a(b bVar) {
        b.a("License Verification succeeded!");
        this.g.a(com.amazon.a.a.m.c.b, (com.amazon.a.a.m.a) new com.amazon.a.a.m.a(bVar, bVar.d()) {
            public void d() {
                this.a.a(d.COMMAND, new a());
            }
        });
    }

    private void a(g gVar, b bVar) throws com.amazon.a.b.a.a {
        com.amazon.a.a.o.d.c cVar = new com.amazon.a.a.o.d.c();
        cVar.a(gVar.a(), bVar.b(), (com.amazon.a.a.o.d.b) h.CUSTOMER_ID);
        cVar.a(gVar.b(), bVar.c(), (com.amazon.a.a.o.d.b) h.DEVICE_ID);
        cVar.a(bVar.e(), this.e.getPackageName(), (com.amazon.a.a.o.d.b) h.PACKAGE_NAME);
        cVar.a(bVar.d(), new Date(), (com.amazon.a.a.o.d.b) h.EXPIRATION);
        if (cVar.a()) {
            throw new com.amazon.a.b.a.a(cVar);
        }
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) throws RemoteException, com.amazon.a.a.d.b {
        com.amazon.a.a.i.c cVar = new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e());
        c cVar2 = b;
        cVar2.a("onFailure: " + cVar);
        this.g.a(com.amazon.a.a.m.c.c, cVar);
    }

    /* access modifiers changed from: protected */
    public void b(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.i.c a = this.c.a(bVar);
        if (a == null && c.b) {
            c cVar = b;
            cVar.b("No mapping specified for exception: " + bVar, bVar);
        }
        this.g.a(com.amazon.a.a.m.c.c, a);
        this.g.a(com.amazon.a.a.m.c.d, bVar.getClass().getName());
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return this.g.a(com.amazon.a.a.m.c.b) == null;
    }
}
