package com.amazon.device.iap.internal.a.a;

import android.os.RemoteException;
import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.util.MetricsHelper;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Promotion;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetItemDataCommandV2 */
public final class c extends a {
    private static final String d = "c";

    public c(com.amazon.device.iap.internal.a.c cVar, Set<String> set) {
        super(cVar, b.ae, set);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        Map b = jVar.b();
        String str = d;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashMap hashMap = new HashMap();
        for (String str2 : this.c) {
            if (!b.containsKey(str2)) {
                linkedHashSet.add(str2);
            } else {
                try {
                    hashMap.put(str2, a(str2, b));
                } catch (IllegalArgumentException e) {
                    linkedHashSet.add(str2);
                    String k = k();
                    StringBuilder sb = new StringBuilder();
                    String str3 = d;
                    sb.append(str3);
                    sb.append(".onResult()");
                    MetricsHelper.submitJsonParsingExceptionMetrics(k, (String) b.get(str2), sb.toString());
                    com.amazon.device.iap.internal.util.b.b(str3, "Error parsing JSON for SKU " + str2 + ": " + e.getMessage());
                }
            }
        }
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        cVar.a().a((Object) new ProductDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(ProductDataResponse.RequestStatus.SUCCESSFUL).setUnavailableSkus(linkedHashSet).setProductData(hashMap).build());
        return true;
    }

    private Product a(String str, Map map) throws IllegalArgumentException {
        JSONObject optJSONObject;
        String str2 = (String) map.get(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ProductType valueOf = ProductType.valueOf(jSONObject.getString(b.k).toUpperCase());
            String string = jSONObject.getString(b.c);
            List<Promotion> list = null;
            String optString = jSONObject.optString(b.x, (String) null);
            if (f.a(optString) && (optJSONObject = jSONObject.optJSONObject(b.y)) != null) {
                Currency instance = Currency.getInstance(optJSONObject.getString(b.a));
                optString = instance.getSymbol() + new BigDecimal(optJSONObject.getString("value"));
            }
            String string2 = jSONObject.getString("title");
            String string3 = jSONObject.getString(b.j);
            int optInt = jSONObject.optInt(b.T, 0);
            String string4 = jSONObject.isNull(b.o) ? null : jSONObject.getString(b.o);
            String string5 = jSONObject.isNull(b.p) ? null : jSONObject.getString(b.p);
            if (!jSONObject.isNull(b.q)) {
                list = e.a(jSONObject);
            }
            return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(string).setPrice(optString).setSmallIconUrl(string3).setTitle(string2).setCoinsRewardAmount(optInt).setSubscriptionPeriod(string4).setFreeTrialPeriod(string5).setPromotions(list).build();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("error in parsing json string" + str2);
        }
    }
}
