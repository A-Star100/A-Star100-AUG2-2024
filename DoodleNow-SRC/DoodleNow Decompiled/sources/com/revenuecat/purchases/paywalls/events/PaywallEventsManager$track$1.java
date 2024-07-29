package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.common.LogUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PaywallEventsManager.kt */
final class PaywallEventsManager$track$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PaywallEvent $event;
    final /* synthetic */ PaywallEventsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaywallEventsManager$track$1(PaywallEvent paywallEvent, PaywallEventsManager paywallEventsManager) {
        super(0);
        this.$event = paywallEvent;
        this.this$0 = paywallEventsManager;
    }

    public final void invoke() {
        LogUtilsKt.debugLog("Tracking paywall event: " + this.$event);
        this.this$0.fileHelper.appendEvent(new PaywallStoredEvent(this.$event, this.this$0.identityManager.getCurrentAppUserID()));
    }
}
