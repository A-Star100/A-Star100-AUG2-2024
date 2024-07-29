package com.amazon.device.iap.internal.a.a;

import android.os.RemoteException;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetItemDataCommandV1 */
public final class b extends a {
    private static final String d = "b";

    public b(c cVar, Set<String> set) {
        super(cVar, "1.0", set);
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
                    String str3 = d;
                    com.amazon.device.iap.internal.util.b.b(str3, "Error parsing JSON for SKU " + str2 + ": " + e.getMessage());
                }
            }
        }
        c cVar = (c) j();
        cVar.a().a((Object) new ProductDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(ProductDataResponse.RequestStatus.SUCCESSFUL).setUnavailableSkus(linkedHashSet).setProductData(hashMap).build());
        return true;
    }

    private Product a(String str, Map map) throws IllegalArgumentException {
        String str2 = (String) map.get(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ProductType valueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
            String string = jSONObject.getString(com.amazon.a.a.o.b.c);
            String optString = jSONObject.optString(com.amazon.a.a.o.b.x);
            String string2 = jSONObject.getString("title");
            String string3 = jSONObject.getString(com.amazon.a.a.o.b.j);
            return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(string).setPrice(optString).setSmallIconUrl(string3).setTitle(string2).setCoinsRewardAmount(jSONObject.optInt(com.amazon.a.a.o.b.T, 0)).build();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("error in parsing json string" + str2);
        }
    }
}
