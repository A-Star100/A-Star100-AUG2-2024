package com.revenuecat.purchases.google;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BillingWrapper$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BillingWrapper$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final void run() {
        BillingWrapper.executePendingRequests$lambda$3$lambda$2$lambda$1(this.f$0);
    }
}
