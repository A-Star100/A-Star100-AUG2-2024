package com.amazon.device.iap.internal.a.a;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* compiled from: GetProductDataRequest */
public final class d extends c {
    public d(RequestId requestId, Set<String> set) {
        super(requestId);
        c cVar = new c(this, set);
        cVar.b((h) new b(this, set));
        a((h) cVar);
    }

    public void b() {
        a((Object) (ProductDataResponse) a().b());
    }

    public void c() {
        ProductDataResponse productDataResponse = (ProductDataResponse) a().b();
        if (productDataResponse == null) {
            productDataResponse = new ProductDataResponseBuilder().setRequestId(d()).setRequestStatus(ProductDataResponse.RequestStatus.FAILED).build();
        }
        a((Object) productDataResponse);
    }
}
