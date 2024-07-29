package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.util.a;

/* compiled from: PurchaseUpdatesCommandBase */
abstract class b extends h {
    protected static final String b = "purchase_updates";
    protected final boolean c;

    b(c cVar, String str, boolean z) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.c = z;
    }

    /* access modifiers changed from: protected */
    public void e() throws com.amazon.a.a.d.b {
        String str;
        super.e();
        String str2 = (String) ((c) j()).a().a("userId");
        if (this.c) {
            str = null;
        } else {
            str = a.a(str2);
        }
        a(com.amazon.a.a.o.b.b, str);
    }
}
