package com.revenuecat.purchases.amazon;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonCache.kt */
final class AmazonCache$amazonPostedTokensKey$2 extends Lambda implements Function0<String> {
    final /* synthetic */ AmazonCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonCache$amazonPostedTokensKey$2(AmazonCache amazonCache) {
        super(0);
        this.this$0 = amazonCache;
    }

    public final String invoke() {
        return this.this$0.deviceCache.newKey("amazon.tokens");
    }
}
