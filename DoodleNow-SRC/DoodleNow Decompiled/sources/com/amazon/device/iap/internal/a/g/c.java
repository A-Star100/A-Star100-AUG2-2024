package com.amazon.device.iap.internal.a.g;

import com.amazon.a.a.o.b;

/* compiled from: ResponseReceivedCommandV2 */
public final class c extends a {
    public c(com.amazon.device.iap.internal.a.c cVar, boolean z) {
        super(cVar, b.ae);
        a(b.aa, Boolean.valueOf(z));
    }

    public void l() {
        Object a = j().a().a(b.al);
        if (a == null || !Boolean.TRUE.equals(a)) {
            a(b.ab, false);
        } else {
            a(b.ab, true);
        }
        super.l();
    }
}
