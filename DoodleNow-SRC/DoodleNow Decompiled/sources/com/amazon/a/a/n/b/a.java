package com.amazon.a.a.n.b;

import com.amazon.a.a.c.b;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.d;
import com.amazon.a.a.o.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: ForegroundTaskPipeline */
public class a implements d, c {
    private static final c a = new c("ForegroundTaskPipeline");
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a b;
    @com.amazon.a.a.k.a
    private f c;
    private c d = b.b("KIWI_UI");
    private c e;
    private List<com.amazon.a.a.n.a> f = new ArrayList();

    public a(c cVar) {
        this.e = cVar;
    }

    public void e() {
        this.c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() {
            public String toString() {
                return "ForegroundTaskPipeline:onResume listener";
            }

            public b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            public void a(com.amazon.a.a.a.a.a aVar) {
                a.this.b();
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }
        });
    }

    public void a(com.amazon.a.a.n.a aVar) {
        a(aVar, false);
    }

    /* access modifiers changed from: private */
    public void a(com.amazon.a.a.n.a aVar, boolean z) {
        if (!this.b.c()) {
            if (c.a) {
                c cVar = a;
                cVar.a("No UI visible to execute task: " + aVar + ", placing into pending queue until task is visible");
            }
            this.f.add(aVar);
        } else if (z) {
            this.d.b(aVar);
        } else {
            this.d.a(aVar);
        }
    }

    public void b(com.amazon.a.a.n.a aVar) {
        a(aVar, true);
    }

    public void a(com.amazon.a.a.n.a aVar, Date date) {
        this.e.a(c(aVar), date);
    }

    private com.amazon.a.a.n.a c(final com.amazon.a.a.n.a aVar) {
        return new com.amazon.a.a.n.a() {
            public void a() {
                a.this.a(aVar, true);
            }

            public String toString() {
                return "Future:PostToUITask: " + aVar.toString();
            }
        };
    }

    public void a(com.amazon.a.a.n.a aVar, long j) {
        this.e.a(c(aVar), j);
    }

    public void a() {
        this.d.a();
        this.e.a();
        this.f.clear();
    }

    /* access modifiers changed from: private */
    public void b() {
        if (c.a) {
            a.a("Activity resumed, scheduling tasks on UI thread");
        }
        for (com.amazon.a.a.n.a b2 : this.f) {
            b(b2);
        }
        this.f.clear();
    }
}
