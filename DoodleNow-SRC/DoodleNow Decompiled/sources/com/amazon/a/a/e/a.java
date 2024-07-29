package com.amazon.a.a.e;

import com.amazon.a.a.e.a;
import com.amazon.a.a.k.d;
import com.amazon.a.a.n.b;
import com.amazon.a.a.o.c;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Expirable */
public abstract class a<T extends a<T>> implements d {
    private static final c b = new c("Expirable");
    @com.amazon.a.a.k.a
    protected b a;
    private AtomicBoolean c = new AtomicBoolean(false);
    private final List<b<T>> d = new Vector();

    /* access modifiers changed from: protected */
    public abstract Date a();

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public abstract void d();

    public final void e() {
        h();
        b();
    }

    private void h() {
        this.a.a(com.amazon.a.a.n.b.d.BACKGROUND, (com.amazon.a.a.n.a) new com.amazon.a.a.n.a() {
            public void a() {
                a.this.c();
            }

            public String toString() {
                return "Expire: " + a.this.toString();
            }
        }, a());
    }

    public void c() {
        if (this.c.compareAndSet(false, true)) {
            if (c.a) {
                c cVar = b;
                cVar.a("Expiring: " + this);
            }
            d();
            if (c.a) {
                c cVar2 = b;
                cVar2.a("Notifying Observers of expiration: " + this);
            }
            i();
        }
    }

    public final void f() {
        if (this.c.compareAndSet(false, true)) {
            i();
        }
    }

    public final void a(b<T> bVar) {
        this.d.add(bVar);
    }

    private void i() {
        for (b<T> a2 : this.d) {
            a2.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return this.c.get();
    }
}
