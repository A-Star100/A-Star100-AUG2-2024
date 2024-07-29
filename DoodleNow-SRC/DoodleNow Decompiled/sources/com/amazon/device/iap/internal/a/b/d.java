package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.o.b;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.a.e;
import com.amazon.device.iap.internal.a.f;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PurchaseUpdatesCommandV2 */
public final class d extends b {
    private static final String d = "d";

    public d(c cVar, boolean z) {
        super(cVar, b.ae, z);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws Exception {
        Map b = jVar.b();
        String str = d;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b);
        String str2 = (String) b.get("userId");
        List<Receipt> a = a(str2, (String) b.get(b.G), (String) b.get(b.B));
        boolean booleanValue = Boolean.valueOf((String) b.get(b.i)).booleanValue();
        c cVar = (c) j();
        PurchaseUpdatesResponse build = new PurchaseUpdatesResponseBuilder().setRequestId(cVar.d()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str2).setMarketplace((String) b.get(b.m)).build()).setReceipts(a).setHasMore(booleanValue).build();
        cVar.a().a(b.am, (String) b.get(b.b));
        cVar.a().a((Object) build);
        return true;
    }

    private List<Receipt> a(String str, String str2, String str3) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(com.amazon.device.iap.internal.util.c.a(jSONArray.getJSONObject(i), str, str3));
            } catch (e e) {
                String str4 = d;
                com.amazon.device.iap.internal.util.b.b(str4, "fail to parse receipt, requestId:" + e.a());
            } catch (f e2) {
                String str5 = d;
                com.amazon.device.iap.internal.util.b.b(str5, "fail to verify receipt, requestId:" + e2.a());
            } catch (Throwable th) {
                String str6 = d;
                com.amazon.device.iap.internal.util.b.b(str6, "fail to verify receipt, requestId:" + th.getMessage());
            }
        }
        return arrayList;
    }
}
