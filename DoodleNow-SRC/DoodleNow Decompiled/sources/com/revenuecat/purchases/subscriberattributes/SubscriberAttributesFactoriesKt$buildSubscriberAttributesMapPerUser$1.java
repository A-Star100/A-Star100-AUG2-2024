package com.revenuecat.purchases.subscriberattributes;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u00012\u000e\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "userId", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: subscriberAttributesFactories.kt */
final class SubscriberAttributesFactoriesKt$buildSubscriberAttributesMapPerUser$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends Map<String, ? extends SubscriberAttribute>>> {
    final /* synthetic */ JSONObject $attributesJSONObject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesFactoriesKt$buildSubscriberAttributesMapPerUser$1(JSONObject jSONObject) {
        super(1);
        this.$attributesJSONObject = jSONObject;
    }

    public final Pair<String, Map<String, SubscriberAttribute>> invoke(String str) {
        Object obj = this.$attributesJSONObject.get(str);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
        return TuplesKt.to(str, SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap((JSONObject) obj));
    }
}
