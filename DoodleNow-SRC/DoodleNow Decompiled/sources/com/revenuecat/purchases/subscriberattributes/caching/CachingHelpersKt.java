package com.revenuecat.purchases.subscriberattributes.caching;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u00060\u0002H\u0000¨\u0006\u0007"}, d2 = {"toJSONObject", "Lorg/json/JSONObject;", "", "", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: cachingHelpers.kt */
public final class CachingHelpersKt {
    public static final JSONObject toJSONObject(Map<String, ? extends Map<String, SubscriberAttribute>> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                jSONObject2.put((String) entry.getKey(), ((SubscriberAttribute) entry.getValue()).toJSONObject());
            }
            jSONObject.put(str, jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("attributes", jSONObject);
        return jSONObject3;
    }
}
