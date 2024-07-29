package com.amazon.a.a.n.c;

import com.amazon.a.a.k.d;
import com.amazon.a.a.n.a;
import com.amazon.a.a.o.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TaskWorkflow */
public abstract class b extends a implements d {
    private static final c b = new c("TaskWorkflow");
    protected final List<a> a = new ArrayList();
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b c;
    private AtomicBoolean d = new AtomicBoolean(false);

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public abstract String b_();

    /* access modifiers changed from: protected */
    public void c() {
    }

    public final void a() {
        try {
            c();
            f();
        } finally {
            b();
        }
    }

    private void f() {
        if (c.a) {
            c cVar = b;
            cVar.a("Exiting task workflow: " + this);
        }
        for (a next : this.a) {
            if (!this.d.get()) {
                next.a();
            } else if (c.a) {
                b.a("Finished set, exiting task workflow early");
                return;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        com.amazon.a.a.o.a.a.a((Object) aVar, "task");
        this.a.add(aVar);
        if (aVar instanceof c) {
            ((c) aVar).a(this);
        }
    }

    public final void d() {
        this.d.set(true);
    }

    public final void e() {
        for (a b2 : this.a) {
            this.c.b(b2);
        }
    }

    public final String toString() {
        return b_();
    }
}
