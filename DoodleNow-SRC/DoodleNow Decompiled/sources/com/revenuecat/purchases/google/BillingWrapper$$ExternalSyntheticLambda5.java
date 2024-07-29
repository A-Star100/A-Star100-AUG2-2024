package com.revenuecat.purchases.google;

import com.revenuecat.purchases.PurchasesError;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BillingWrapper$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ PurchasesError f$1;

    public /* synthetic */ BillingWrapper$$ExternalSyntheticLambda5(Function1 function1, PurchasesError purchasesError) {
        this.f$0 = function1;
        this.f$1 = purchasesError;
    }

    public final void run() {
        BillingWrapper.sendErrorsToAllPendingRequests$lambda$31$lambda$30(this.f$0, this.f$1);
    }
}
