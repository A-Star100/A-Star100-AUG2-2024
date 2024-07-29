package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingResult;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BillingWrapper$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ BillingResult f$0;
    public final /* synthetic */ BillingWrapper f$1;

    public /* synthetic */ BillingWrapper$$ExternalSyntheticLambda4(BillingResult billingResult, BillingWrapper billingWrapper) {
        this.f$0 = billingResult;
        this.f$1 = billingWrapper;
    }

    public final void run() {
        BillingWrapper.onBillingSetupFinished$lambda$18(this.f$0, this.f$1);
    }
}
