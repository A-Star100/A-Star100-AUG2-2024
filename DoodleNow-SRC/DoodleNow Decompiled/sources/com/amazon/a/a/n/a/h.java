package com.amazon.a.a.n.a;

import android.os.RemoteException;
import com.amazon.a.a.d.b;
import com.amazon.a.a.i.e;
import com.amazon.a.a.j.a;
import com.amazon.a.a.o.c;
import com.amazon.a.b.f;
import com.amazon.d.a.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: KiwiCommand */
public abstract class h extends a {
    private static final c b = new c("KiwiCommand");
    private final a c;
    private final String d;
    private final String e;
    private final String f;
    private final Map<String, Object> g;
    private final f h = new f();
    private boolean i;
    private h j;
    private h k;
    private boolean l = false;

    public h a(boolean z) {
        this.l = z;
        return this;
    }

    public void a(h hVar) {
        this.j = hVar;
    }

    /* access modifiers changed from: protected */
    public String a_() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> b() {
        return this.g;
    }

    public void b(h hVar) {
        this.k = hVar;
    }

    /* access modifiers changed from: protected */
    public void b(com.amazon.d.a.h hVar) {
    }

    /* access modifiers changed from: protected */
    public void b(boolean z) {
        this.i = z;
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(j jVar) throws Exception;

    /* access modifiers changed from: protected */
    public String c() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public void c(b bVar) {
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return true;
    }

    public boolean i() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public a j() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public String k() {
        return this.d;
    }

    public h(a aVar, String str, String str2, String str3, String str4) {
        this.c = aVar;
        this.d = str3;
        this.e = str;
        this.f = str2;
        HashMap hashMap = new HashMap();
        this.g = hashMap;
        hashMap.put(com.amazon.a.a.o.b.B, str3);
        hashMap.put(com.amazon.a.a.o.b.I, str4);
        this.i = true;
        this.j = null;
        this.k = null;
    }

    /* access modifiers changed from: protected */
    public void a(String str, Object obj) {
        this.g.put(str, obj);
    }

    private void a(com.amazon.a.a.i.c cVar) {
        if (cVar != null) {
            com.amazon.a.a.i.a aVar = new com.amazon.a.a.i.a(cVar);
            e a = com.amazon.a.a.a();
            if (a == null) {
                b.b("Prompt manager is null. Cannot show prompt dropping request");
            } else {
                a.a(aVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws RemoteException, b {
        boolean z;
        h hVar;
        String str = (String) jVar.b().get("errorMessage");
        c cVar = b;
        cVar.a("onSuccess: result = " + jVar + ", errorMessage: " + str);
        if (com.amazon.a.a.o.f.a(str)) {
            try {
                z = b(jVar);
            } catch (Exception e2) {
                c cVar2 = b;
                cVar2.a("Error calling onResult: " + e2);
                z = false;
            }
            if (z && (hVar = this.j) != null) {
                hVar.l();
            } else if (this.l) {
            } else {
                if (z) {
                    this.c.b();
                } else {
                    this.c.c();
                }
            }
        } else if (!this.l) {
            this.c.c();
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.amazon.d.a.h hVar) throws RemoteException, b {
        String str;
        h hVar2;
        c cVar = b;
        cVar.a("onFailure: result = " + hVar);
        if (hVar == null || (str = (String) hVar.f().get(com.amazon.a.a.o.b.ak)) == null || !str.equalsIgnoreCase("1.0") || (hVar2 = this.k) == null) {
            try {
                b(hVar);
            } catch (Exception e2) {
                c cVar2 = b;
                cVar2.a("Error calling onResult: " + e2);
            }
            if (this.i) {
                a(new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e()));
            }
            if (!this.l) {
                this.c.c();
                return;
            }
            return;
        }
        hVar2.a(this.l);
        this.k.l();
    }

    /* access modifiers changed from: protected */
    public void b(b bVar) {
        h hVar;
        if (!"UNHANDLED_EXCEPTION".equals(bVar.a()) || !com.amazon.a.a.o.b.ae.equals(this.f) || (hVar = this.k) == null) {
            try {
                c(bVar);
            } catch (Exception e2) {
                c cVar = b;
                cVar.a("Error calling onResult: " + e2);
            }
            if (this.i) {
                a(this.h.a(bVar));
            }
            if (!this.l) {
                this.c.c();
                return;
            }
            return;
        }
        hVar.a(this.l);
        this.k.l();
    }

    public void l() {
        com.amazon.a.a.a((a) this);
    }
}
