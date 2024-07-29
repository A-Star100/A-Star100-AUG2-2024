package com.amazon.a.a.m;

import com.amazon.a.a.k.a;
import com.amazon.a.a.o.c;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ExpirableValueDataStore */
public class b implements com.amazon.a.a.e.b<a> {
    /* access modifiers changed from: private */
    public static final c a = new c("ExpirableValueDataStore");
    @a
    private com.amazon.a.a.k.b b;
    private final Map<String, a> c = new HashMap();

    public synchronized boolean a(String str) {
        return b(str) != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T b(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "Fetching value: "
            monitor-enter(r3)
            boolean r1 = com.amazon.a.a.o.c.a     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0018
            com.amazon.a.a.o.c r1 = a     // Catch:{ all -> 0x0036 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r2.<init>(r0)     // Catch:{ all -> 0x0036 }
            r2.append(r4)     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0036 }
            r1.a(r0)     // Catch:{ all -> 0x0036 }
        L_0x0018:
            java.util.Map<java.lang.String, com.amazon.a.a.m.a> r0 = r3.c     // Catch:{ all -> 0x0036 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0036 }
            com.amazon.a.a.m.a r4 = (com.amazon.a.a.m.a) r4     // Catch:{ all -> 0x0036 }
            if (r4 != 0) goto L_0x0030
            boolean r4 = com.amazon.a.a.o.c.a     // Catch:{ all -> 0x0036 }
            if (r4 == 0) goto L_0x002d
            com.amazon.a.a.o.c r4 = a     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = "Value not present in store, returning null"
            r4.a(r0)     // Catch:{ all -> 0x0036 }
        L_0x002d:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x0030:
            java.lang.Object r4 = r4.h()     // Catch:{ all -> 0x0036 }
            monitor-exit(r3)
            return r4
        L_0x0036:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.m.b.b(java.lang.String):java.lang.Object");
    }

    public synchronized void a(String str, a aVar) {
        com.amazon.a.a.o.a.a.a((Object) str, SubscriberAttributeKt.JSON_NAME_KEY);
        com.amazon.a.a.o.a.a.a((Object) aVar, "value");
        if (c.a) {
            c cVar = a;
            cVar.a("Placing value into store with key: " + str + ", expiration: " + aVar.a());
        }
        this.b.b(aVar);
        aVar.a(this);
        this.c.put(str, aVar);
    }

    public synchronized <T> void a(String str, T t) {
        if (c.a) {
            c cVar = a;
            cVar.a("Placing non-expiring value into store with key: " + str);
        }
        this.c.put(str, new a(t, new Date()) {
            /* access modifiers changed from: protected */
            public void d() {
                if (c.b) {
                    b.a.b("Woah, non-expirable value was expired!!!!");
                }
            }
        });
    }

    public synchronized void c(String str) {
        a aVar = this.c.get(str);
        if (aVar != null) {
            if (c.a) {
                c cVar = a;
                cVar.a("Removing value associated with key: " + str + ", value: " + aVar);
            }
            this.c.remove(str);
            aVar.f();
        }
    }

    public synchronized void a(a aVar) {
        if (c.a) {
            c cVar = a;
            cVar.a("Observed expiration: " + aVar + " removing from store!");
        }
        Iterator<Map.Entry<String, a>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == aVar) {
                if (c.a) {
                    c cVar2 = a;
                    cVar2.a("Removing entry from store: " + aVar);
                }
                it.remove();
            }
        }
    }

    public String toString() {
        return this.c.toString();
    }
}
