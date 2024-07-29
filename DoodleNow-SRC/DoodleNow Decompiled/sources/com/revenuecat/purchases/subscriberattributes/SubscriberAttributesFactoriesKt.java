package com.revenuecat.purchases.subscriberattributes;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000\u001a\u001c\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0006*\u00020\u0004H\u0000\u001a0\u0010\u0007\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00060\u0001j\u0002`\t*\u00020\u0004H\u0000¨\u0006\n"}, d2 = {"buildLegacySubscriberAttributes", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lorg/json/JSONObject;", "buildSubscriberAttributesMap", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "buildSubscriberAttributesMapPerUser", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: subscriberAttributesFactories.kt */
public final class SubscriberAttributesFactoriesKt {
    public static final Map<String, SubscriberAttribute> buildLegacySubscriberAttributes(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONObject jSONObject2 = jSONObject.getJSONObject("attributes");
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "attributesJSONObject");
        return buildSubscriberAttributesMap(jSONObject2);
    }

    public static final Map<String, Map<String, SubscriberAttribute>> buildSubscriberAttributesMapPerUser(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONObject jSONObject2 = jSONObject.getJSONObject("attributes");
        Iterator<String> keys = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "attributesJSONObject.keys()");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(keys), new SubscriberAttributesFactoriesKt$buildSubscriberAttributesMapPerUser$1(jSONObject2)));
    }

    public static final Map<String, SubscriberAttribute> buildSubscriberAttributesMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(keys), new SubscriberAttributesFactoriesKt$buildSubscriberAttributesMap$1(jSONObject)));
    }
}
