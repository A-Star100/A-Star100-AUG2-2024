package com.revenuecat.purchases.amazon;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AmazonBilling$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ AmazonBilling$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void run() {
        AmazonBilling.executePendingRequests$lambda$9$lambda$8(this.f$0);
    }
}
