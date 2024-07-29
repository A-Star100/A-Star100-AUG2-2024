package com.amazon.device.iap.internal.a.f;

import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.b.d;
import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PurchaseResponseCommandV1 */
public final class b extends a {
    private static final String c = "b";

    public b(c cVar) {
        super(cVar, "1.0");
    }

    private void a(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString(com.amazon.a.a.o.b.n)) == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                    d.a().a(str, str2, com.amazon.device.iap.internal.util.c.a(jSONObject, str2, str).getReceiptId(), str3);
                }
            } catch (Throwable th) {
                String str4 = c;
                com.amazon.device.iap.internal.util.b.b(str4, "Error in savePendingReceipt: " + th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws Exception {
        Receipt receipt;
        Map b = jVar.b();
        String str = c;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b);
        String str2 = (String) b().get(com.amazon.a.a.o.b.B);
        String str3 = (String) b.get("userId");
        String str4 = (String) b.get(com.amazon.a.a.o.b.m);
        String str5 = (String) b.get(com.amazon.a.a.o.b.D);
        if (str2 == null || !e.a().a(str2)) {
            j().a().c();
            return true;
        } else if (f.a(str5)) {
            a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
            return false;
        } else {
            JSONObject jSONObject = new JSONObject(str5);
            PurchaseResponse.RequestStatus safeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString(com.amazon.a.a.o.b.n));
            if (safeValueOf == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                try {
                    receipt = com.amazon.device.iap.internal.util.c.a(jSONObject, str3, str2);
                    if (ProductType.CONSUMABLE == receipt.getProductType()) {
                        a(str2, str3, str5);
                    }
                } catch (Throwable unused) {
                    a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
                    return false;
                }
            } else {
                receipt = null;
            }
            c cVar = (c) j();
            cVar.a().a((Object) new PurchaseResponseBuilder().setRequestId(cVar.d()).setRequestStatus(safeValueOf).setUserData(new UserDataBuilder().setUserId(str3).setMarketplace(str4).build()).setReceipt(receipt).build());
            return true;
        }
    }
}
