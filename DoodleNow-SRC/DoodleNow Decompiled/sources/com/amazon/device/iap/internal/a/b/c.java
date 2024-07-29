package com.amazon.device.iap.internal.a.b;

import com.amazon.d.a.j;
import com.amazon.device.iap.internal.a.e;
import com.amazon.device.iap.internal.a.f;
import com.amazon.device.iap.internal.b.a;
import com.amazon.device.iap.internal.b.d;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.util.b;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PurchaseUpdatesCommandV1 */
public final class c extends b {
    private static final String d = "c";
    private static final Date e = new Date(0);

    public c(com.amazon.device.iap.internal.a.c cVar, boolean z) {
        super(cVar, "1.0", z);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws Exception {
        Map b = jVar.b();
        b.a(d, "data: " + b);
        String str = (String) b.get("userId");
        String str2 = (String) b.get(com.amazon.a.a.o.b.B);
        String str3 = (String) b.get(com.amazon.a.a.o.b.m);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray((String) b.get(com.amazon.a.a.o.b.G));
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Receipt a = com.amazon.device.iap.internal.util.c.a(jSONArray.getJSONObject(i), str, (String) null);
                arrayList.add(a);
                if (ProductType.ENTITLED == a.getProductType()) {
                    a.a().a(str, a.getReceiptId(), a.getSku());
                }
            } catch (e e2) {
                b.b(d, "fail to parse receipt, requestId:" + e2.a());
            } catch (f e3) {
                b.b(d, "fail to verify receipt, requestId:" + e3.a());
            } catch (Throwable th) {
                b.b(d, "fail to verify receipt, requestId:" + th.getMessage());
            }
        }
        JSONArray jSONArray2 = new JSONArray((String) b.get(com.amazon.a.a.o.b.H));
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                String string = jSONArray2.getString(i2);
                arrayList.add(new ReceiptBuilder().setSku(string).setProductType(ProductType.ENTITLED).setPurchaseDate((Date) null).setCancelDate(e).setReceiptId(a.a().a(str, string)).build());
            } catch (JSONException unused) {
                b.b(d, "fail to parse JSON[" + i2 + "] in \"" + jSONArray2 + "\"");
            }
        }
        boolean equalsIgnoreCase = com.amazon.a.a.o.b.ac.equalsIgnoreCase((String) b.get(com.amazon.a.a.o.b.i));
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        PurchaseUpdatesResponse build = new PurchaseUpdatesResponseBuilder().setRequestId(cVar.d()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str).setMarketplace(str3).build()).setReceipts(arrayList).setHasMore(equalsIgnoreCase).build();
        build.getReceipts().addAll(d.a().b(build.getUserData().getUserId()));
        cVar.a().a((Object) build);
        cVar.a().a(com.amazon.a.a.o.b.am, (String) b.get(com.amazon.a.a.o.b.b));
        return true;
    }
}
