package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.n.a.h;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.a.c.d;
import com.amazon.device.iap.internal.a.d.b;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;

/* compiled from: GetPurchaseUpdatesRequest */
public final class a extends c {
    public a(RequestId requestId, boolean z) {
        super(requestId);
        d dVar = new d(this);
        dVar.a((h) new d(this, z));
        com.amazon.device.iap.internal.a.c.c cVar = new com.amazon.device.iap.internal.a.c.c(this);
        cVar.a((h) new c(this, z));
        dVar.b((h) cVar);
        a((h) dVar);
    }

    public void b() {
        b bVar;
        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) a().b();
        if (purchaseUpdatesResponse.getReceipts() == null || purchaseUpdatesResponse.getReceipts().size() <= 0) {
            bVar = null;
        } else {
            HashSet hashSet = new HashSet();
            for (Receipt next : purchaseUpdatesResponse.getReceipts()) {
                if (!f.a(next.getReceiptId())) {
                    hashSet.add(next.getReceiptId());
                }
            }
            bVar = new b(this, hashSet, com.amazon.device.iap.internal.model.a.DELIVERED.toString());
        }
        a(purchaseUpdatesResponse, bVar);
    }

    public void c() {
        PurchaseUpdatesResponse purchaseUpdatesResponse;
        Object b = a().b();
        if (b == null || !(b instanceof PurchaseUpdatesResponse)) {
            purchaseUpdatesResponse = new PurchaseUpdatesResponseBuilder().setRequestId(d()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).build();
        } else {
            purchaseUpdatesResponse = (PurchaseUpdatesResponse) b;
        }
        a((Object) purchaseUpdatesResponse);
    }
}
