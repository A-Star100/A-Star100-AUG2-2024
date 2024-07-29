package com.amazon.device.iap.internal.b;

import com.amazon.a.a.o.f;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* compiled from: PurchaseRequestTracker */
public class e {
    private static final e b = new e();
    private final Set<String> a = new ConcurrentSkipListSet();

    public static e a() {
        return b;
    }

    public boolean a(String str) {
        if (!f.a(str)) {
            return this.a.remove(str);
        }
        return false;
    }

    public void b(String str) {
        if (!f.a(str)) {
            this.a.add(str);
        }
    }
}
