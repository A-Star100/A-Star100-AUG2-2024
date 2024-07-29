package com.revenuecat.purchases.paywalls.events;

import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PaywallEventsManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ PaywallEventsManager$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final void run() {
        PaywallEventsManager.enqueue$lambda$0(this.f$0);
    }
}
