package com.amazon.a.a.i;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.a.a.k.a;
import com.amazon.a.a.k.d;
import com.amazon.a.a.n.b;
import com.amazon.a.a.o.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PromptManagerImpl */
public class f implements e, d {
    public static final c a = new c("PromptManagerImpl");
    @a
    private com.amazon.a.a.a.a b;
    @a
    private com.amazon.a.a.c.f c;
    @a
    private b d;
    @a
    private com.amazon.a.a.k.b e;
    private b f;
    private Set<b> g = new LinkedHashSet();
    private final AtomicBoolean h = new AtomicBoolean(false);

    public void a(final b bVar) {
        if (c.a) {
            c cVar = a;
            cVar.a("Scheduling presentation: " + bVar);
        }
        this.e.b(bVar);
        if (this.h.get()) {
            if (c.b) {
                c cVar2 = a;
                cVar2.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        this.d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() {
            public void a() {
                f.this.c(bVar);
            }

            public String toString() {
                return "Prompt Presentation on Main Thread: " + bVar + ", " + bVar.a();
            }
        });
    }

    /* access modifiers changed from: private */
    public void c(b bVar) {
        if (this.h.get()) {
            if (c.b) {
                c cVar = a;
                cVar.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        if (c.a) {
            c cVar2 = a;
            cVar2.a("Presening Prompt: " + bVar);
        }
        bVar.a(this);
        this.g.add(bVar);
        if (this.f == null) {
            Activity b2 = this.b.b();
            if (b2 != null) {
                a(b2);
            }
        } else if (c.a) {
            a.a("Dialog currently showing, not presenting given dialog");
        }
    }

    private void a(Activity activity) {
        b a2 = a();
        if (a2 != null) {
            a(a2, activity);
        }
    }

    private b a() {
        if (this.g.isEmpty()) {
            return null;
        }
        return this.g.iterator().next();
    }

    private void a(b bVar, Activity activity) {
        this.f = bVar;
        bVar.a(activity);
    }

    public Dialog a(Activity activity, int i) {
        if (c.a) {
            c cVar = a;
            cVar.a("onCreateDialog, id: " + i + ", activity: " + activity);
        }
        b bVar = this.f;
        if (bVar == null) {
            if (c.a) {
                a.a("Showing dialog is null, returning");
            }
            return null;
        } else if (bVar.j() != i) {
            if (c.a) {
                c cVar2 = a;
                cVar2.a("Showing dialog id does not match given id: " + i + ", returning");
            }
            return null;
        } else {
            if (c.a) {
                c cVar3 = a;
                cVar3.a("Creating dialog prompt: " + this.f);
            }
            return this.f.c(activity);
        }
    }

    /* access modifiers changed from: private */
    public void b(Activity activity) {
        b bVar = this.f;
        if (bVar != null) {
            a(bVar, activity);
        } else {
            a(activity);
        }
    }

    /* renamed from: b */
    public void a(final b bVar) {
        this.d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() {
            public void a() {
                f.this.d(bVar);
            }

            public String toString() {
                return "PromptManager:removeExpiredPrompt: " + bVar;
            }
        });
    }

    /* access modifiers changed from: private */
    public void d(b bVar) {
        this.g.remove(bVar);
        if (this.f == bVar) {
            this.f = null;
            Activity b2 = this.b.b();
            if (b2 != null) {
                a(b2);
            }
        }
    }

    public void a(Activity activity, boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(activity, z);
        }
    }

    public void e() {
        b();
        c();
    }

    private void b() {
        this.c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public void a(com.amazon.a.a.a.a.a aVar) {
                f.this.b(aVar.b());
            }
        });
    }

    private void c() {
        this.c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.FIRST;
            }

            public void a(com.amazon.a.a.a.a.c cVar) {
                f.this.d();
            }
        });
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.h.compareAndSet(false, true)) {
            if (c.a) {
                a.a("PromptManager finishing....");
            }
            Iterator<b> it = this.g.iterator();
            while (it.hasNext()) {
                it.remove();
                it.next().c();
            }
            b bVar = this.f;
            if (bVar != null) {
                bVar.k();
            }
        }
    }
}
