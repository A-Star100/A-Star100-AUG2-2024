package com.amazon.a.a.h;

import com.amazon.a.a.o.c;

/* compiled from: MetricsManagerImpl */
public class d implements c {
    private static final c a = new c("MetricsManagerImpl");
    private b b = new b();

    public synchronized void a(a aVar) {
        if (c.a) {
            c cVar = a;
            cVar.a("Recording Metric: " + aVar);
        }
        this.b.a(aVar);
    }

    public synchronized b a() {
        if (this.b.a()) {
            return this.b;
        }
        b bVar = this.b;
        this.b = new b();
        return bVar;
    }
}
