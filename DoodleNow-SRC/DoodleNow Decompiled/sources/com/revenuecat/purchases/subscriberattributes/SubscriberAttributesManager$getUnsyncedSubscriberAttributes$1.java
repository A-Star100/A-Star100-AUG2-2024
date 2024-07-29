package com.revenuecat.purchases.subscriberattributes;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesManager.kt */
final class SubscriberAttributesManager$getUnsyncedSubscriberAttributes$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ Function1<Map<String, SubscriberAttribute>, Unit> $completion;
    final /* synthetic */ SubscriberAttributesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesManager$getUnsyncedSubscriberAttributes$1(Function1<? super Map<String, SubscriberAttribute>, Unit> function1, SubscriberAttributesManager subscriberAttributesManager, String str) {
        super(0);
        this.$completion = function1;
        this.this$0 = subscriberAttributesManager;
        this.$appUserID = str;
    }

    public final void invoke() {
        this.$completion.invoke(this.this$0.getDeviceCache().getUnsyncedSubscriberAttributes(this.$appUserID));
    }
}
