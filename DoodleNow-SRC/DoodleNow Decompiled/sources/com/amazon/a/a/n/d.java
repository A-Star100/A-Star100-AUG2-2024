package com.amazon.a.a.n;

import com.amazon.a.a.c.f;
import com.amazon.a.a.k.b;
import com.amazon.a.a.o.c;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TaskManagerImpl */
public class d implements com.amazon.a.a.k.d, b {
    private static final c a = new c("TaskManagerImpl");
    @com.amazon.a.a.k.a
    private b b;
    @com.amazon.a.a.k.a
    private f c;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final Map<com.amazon.a.a.n.b.d, com.amazon.a.a.n.b.c> e;

    /* compiled from: TaskManagerImpl */
    private interface a {
        void a(a aVar, com.amazon.a.a.n.b.c cVar);
    }

    public d() {
        HashMap hashMap = new HashMap();
        this.e = hashMap;
        com.amazon.a.a.n.b.b a2 = com.amazon.a.a.n.b.b.a(com.amazon.a.a.n.b.d.COMMAND.name());
        com.amazon.a.a.n.b.b a3 = com.amazon.a.a.n.b.b.a(com.amazon.a.a.n.b.d.BACKGROUND.name());
        com.amazon.a.a.n.b.a aVar = new com.amazon.a.a.n.b.a(a3);
        hashMap.put(com.amazon.a.a.n.b.d.COMMAND, a2);
        hashMap.put(com.amazon.a.a.n.b.d.BACKGROUND, a3);
        hashMap.put(com.amazon.a.a.n.b.d.FOREGROUND, aVar);
    }

    public void a(com.amazon.a.a.n.b.d dVar, a aVar) {
        if (c.a) {
            c cVar = a;
            cVar.a("Enqueue task on pipeline id: " + dVar);
        }
        a(dVar, aVar, (a) new a() {
            public void a(a aVar, com.amazon.a.a.n.b.c cVar) {
                cVar.a(aVar);
            }
        });
    }

    private void a(com.amazon.a.a.n.b.d dVar, a aVar, a aVar2) {
        if (!b()) {
            if (c.a) {
                c cVar = a;
                cVar.a("Populating Task: " + aVar);
            }
            this.b.b(aVar);
            aVar2.a(aVar, a(dVar));
        } else if (c.b) {
            c cVar2 = a;
            cVar2.b("Task enqueued after TaskManager has been finished! Task: " + aVar);
        }
    }

    private com.amazon.a.a.n.b.c a(com.amazon.a.a.n.b.d dVar) {
        com.amazon.a.a.n.b.c cVar = this.e.get(dVar);
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException("No pipeline registered with id: " + dVar);
    }

    public void b(com.amazon.a.a.n.b.d dVar, a aVar) {
        a(dVar, aVar, (a) new a() {
            public void a(a aVar, com.amazon.a.a.n.b.c cVar) {
                cVar.b(aVar);
            }
        });
    }

    public void a(com.amazon.a.a.n.b.d dVar, a aVar, final Date date) {
        a(dVar, aVar, (a) new a() {
            public void a(a aVar, com.amazon.a.a.n.b.c cVar) {
                cVar.a(aVar, date);
            }
        });
    }

    public void a(com.amazon.a.a.n.b.d dVar, a aVar, final long j) {
        a(dVar, aVar, (a) new a() {
            public void a(a aVar, com.amazon.a.a.n.b.c cVar) {
                cVar.a(aVar, j);
            }
        });
    }

    private boolean b() {
        return this.d.get();
    }

    public void e() {
        for (com.amazon.a.a.n.b.c b2 : this.e.values()) {
            this.b.b(b2);
        }
        c();
    }

    private void c() {
        this.c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() {
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public void a(com.amazon.a.a.a.a.c cVar) {
                d.this.a();
            }
        });
    }

    public void a() {
        if (this.d.compareAndSet(false, true)) {
            if (c.a) {
                a.a("TaskManager finishing....");
            }
            for (com.amazon.a.a.n.b.c a2 : this.e.values()) {
                a2.a();
            }
        }
    }
}
