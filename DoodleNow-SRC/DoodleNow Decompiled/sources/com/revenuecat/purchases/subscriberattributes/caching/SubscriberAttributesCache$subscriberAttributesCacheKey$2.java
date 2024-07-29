package com.revenuecat.purchases.subscriberattributes.caching;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesCache.kt */
final class SubscriberAttributesCache$subscriberAttributesCacheKey$2 extends Lambda implements Function0<String> {
    final /* synthetic */ SubscriberAttributesCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesCache$subscriberAttributesCacheKey$2(SubscriberAttributesCache subscriberAttributesCache) {
        super(0);
        this.this$0 = subscriberAttributesCache;
    }

    public final String invoke() {
        return this.this$0.getDeviceCache$purchases_defaultsRelease().newKey("subscriberAttributes");
    }
}
