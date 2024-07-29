package com.amazon.device.iap.internal.a.f;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;

/* compiled from: PurchaseResponseCommandBase */
abstract class a extends h {
    protected static final String b = "purchase_response";

    a(c cVar, String str) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
    }

    /* access modifiers changed from: protected */
    public void a(String str, String str2, String str3, PurchaseResponse.RequestStatus requestStatus) {
        c cVar = (c) j();
        cVar.a().a((Object) new PurchaseResponseBuilder().setRequestId(cVar.d()).setRequestStatus(requestStatus).setUserData(new UserDataBuilder().setUserId(str).setMarketplace(str2).build()).setReceipt((Receipt) null).build());
    }
}
