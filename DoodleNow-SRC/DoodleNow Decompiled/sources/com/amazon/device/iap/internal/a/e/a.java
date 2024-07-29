package com.amazon.device.iap.internal.a.e;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.a.a.n.a.h;
import com.amazon.a.a.n.b;
import com.amazon.a.a.n.b.d;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.util.MetricsHelper;
import java.util.Map;

/* compiled from: PurchaseItemCommandBase */
abstract class a extends h {
    protected static final String b = "purchase_item";
    /* access modifiers changed from: private */
    public static final String f = "a";
    @com.amazon.a.a.k.a
    protected b c;
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a d;
    protected final String e;

    a(c cVar, String str, String str2) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.e = str2;
        a("sku", str2);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        Map b2 = jVar.b();
        String str = f;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b2);
        if (!b2.containsKey(com.amazon.a.a.o.b.z)) {
            com.amazon.device.iap.internal.util.b.b(str, "did not find intent");
            return false;
        }
        com.amazon.device.iap.internal.util.b.a(str, "found intent");
        final Intent intent = (Intent) b2.remove(com.amazon.a.a.o.b.z);
        this.c.b(d.FOREGROUND, new com.amazon.a.a.n.a() {
            public void a() {
                try {
                    Activity b2 = a.this.d.b();
                    if (b2 == null) {
                        b2 = a.this.d.a();
                    }
                    String o = a.f;
                    com.amazon.device.iap.internal.util.b.a(o, "About to fire intent with activity " + b2);
                    b2.startActivity(intent);
                } catch (Exception e) {
                    String a2 = a.this.k();
                    MetricsHelper.submitExceptionMetrics(a2, a.f + ".onResult().execute()", e);
                    String o2 = a.f;
                    com.amazon.device.iap.internal.util.b.b(o2, "Exception when attempting to fire intent: " + e);
                }
            }
        });
        return true;
    }
}
