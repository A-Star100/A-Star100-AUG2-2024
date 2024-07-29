package com.revenuecat.purchases.subscriberattributes;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "attributeKey", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: subscriberAttributesFactories.kt */
final class SubscriberAttributesFactoriesKt$buildSubscriberAttributesMap$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends SubscriberAttribute>> {
    final /* synthetic */ JSONObject $this_buildSubscriberAttributesMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesFactoriesKt$buildSubscriberAttributesMap$1(JSONObject jSONObject) {
        super(1);
        this.$this_buildSubscriberAttributesMap = jSONObject;
    }

    public final Pair<String, SubscriberAttribute> invoke(String str) {
        Object obj = this.$this_buildSubscriberAttributesMap.get(str);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
        return TuplesKt.to(str, new SubscriberAttribute((JSONObject) obj));
    }
}
