package com.amazon.device.iap.internal.a;

import android.content.Context;
import android.os.Handler;
import com.amazon.a.a.j.a;
import com.amazon.a.a.n.a.h;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.internal.d;
import com.amazon.device.iap.internal.util.b;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* compiled from: KiwiRequest */
public class c extends a {
    /* access modifiers changed from: private */
    public static final String c = "c";
    private RequestId d;

    public void b() {
    }

    public void c() {
    }

    public RequestId d() {
        return this.d;
    }

    public c(RequestId requestId) {
        this.d = requestId;
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) {
        this.b = hVar;
    }

    /* access modifiers changed from: protected */
    public void a(Object obj) {
        a(obj, (h) null);
    }

    /* access modifiers changed from: protected */
    public void a(final Object obj, final h hVar) {
        f.a(obj, "response");
        Context b = d.e().b();
        final PurchasingListener a = d.e().a();
        if (b == null || a == null) {
            String str = c;
            b.a(str, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(b.getMainLooper()).post(new Runnable() {
            public void run() {
                c.this.a().a(com.amazon.a.a.o.b.al, Boolean.FALSE);
                try {
                    Object obj = obj;
                    if (obj instanceof ProductDataResponse) {
                        a.onProductDataResponse((ProductDataResponse) obj);
                    } else if (obj instanceof UserDataResponse) {
                        a.onUserDataResponse((UserDataResponse) obj);
                    } else if (obj instanceof PurchaseUpdatesResponse) {
                        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) obj;
                        a.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
                        Object a2 = c.this.a().a(com.amazon.a.a.o.b.am);
                        if (a2 != null && (a2 instanceof String)) {
                            com.amazon.device.iap.internal.util.a.a(purchaseUpdatesResponse.getUserData().getUserId(), a2.toString());
                        }
                    } else if (obj instanceof PurchaseResponse) {
                        a.onPurchaseResponse((PurchaseResponse) obj);
                    } else {
                        String f = c.c;
                        b.b(f, "Unknown response type:" + obj.getClass().getName());
                    }
                    c.this.a().a(com.amazon.a.a.o.b.al, Boolean.TRUE);
                } catch (Throwable th) {
                    String f2 = c.c;
                    b.b(f2, "Error in sendResponse: " + th);
                }
                h hVar = hVar;
                if (hVar != null) {
                    hVar.a(true);
                    hVar.l();
                }
            }
        });
    }

    public com.amazon.a.a.j.b a() {
        return this.a;
    }

    public void e() {
        if (this.b != null) {
            this.b.l();
        } else {
            b();
        }
    }
}
