package com.amazon.device.iap.internal.a.f;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.a.g.b;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;

/* compiled from: PurchaseResponseRequest */
public final class d extends c {
    public d(RequestId requestId) {
        super(requestId);
        c cVar = new c(this);
        cVar.b((h) new b(this));
        a((h) cVar);
    }

    public void b() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) a().b();
        if (purchaseResponse != null) {
            Receipt receipt = purchaseResponse.getReceipt();
            boolean z = receipt != null;
            com.amazon.device.iap.internal.a.g.c cVar = new com.amazon.device.iap.internal.a.g.c(this, z);
            if (z && (ProductType.ENTITLED == receipt.getProductType() || ProductType.SUBSCRIPTION == receipt.getProductType())) {
                cVar.b((h) new b(this, d().toString()));
            }
            a(purchaseResponse, cVar);
        }
    }

    public void c() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) a().b();
        if (purchaseResponse == null) {
            purchaseResponse = new PurchaseResponseBuilder().setRequestId(d()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
        }
        a(purchaseResponse, new com.amazon.device.iap.internal.a.g.c(this, false));
    }
}
