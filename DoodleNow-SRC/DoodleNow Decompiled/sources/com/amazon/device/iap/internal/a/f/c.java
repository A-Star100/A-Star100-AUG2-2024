package com.amazon.device.iap.internal.a.f;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PurchaseResponseCommandV2 */
public final class c extends a {
    private static final String c = "c";

    public c(com.amazon.device.iap.internal.a.c cVar) {
        super(cVar, b.ae);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws Exception {
        Receipt receipt;
        Map b = jVar.b();
        String str = c;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b);
        String str2 = (String) b().get(b.B);
        String str3 = (String) b.get("userId");
        String str4 = (String) b.get(b.m);
        String str5 = (String) b.get(b.D);
        if (f.a(str5)) {
            a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
            return false;
        }
        JSONObject jSONObject = new JSONObject(str5);
        PurchaseResponse.RequestStatus safeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString(b.n));
        if (safeValueOf == PurchaseResponse.RequestStatus.SUCCESSFUL) {
            try {
                receipt = com.amazon.device.iap.internal.util.c.a(jSONObject, str3, str2);
            } catch (Throwable unused) {
                a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
                return false;
            }
        } else {
            receipt = null;
        }
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        cVar.a().a((Object) new PurchaseResponseBuilder().setRequestId(cVar.d()).setRequestStatus(safeValueOf).setUserData(new UserDataBuilder().setUserId(str3).setMarketplace(str4).build()).setReceipt(receipt).build());
        return true;
    }
}
