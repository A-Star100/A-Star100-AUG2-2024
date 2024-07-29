package com.revenuecat.purchases;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.revenuecat.purchases.interfaces.Callback;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PurchasesOrchestrator$Companion$canMakePayments$2$1$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ BillingResult f$0;
    public final /* synthetic */ Callback f$1;
    public final /* synthetic */ BillingClient f$2;
    public final /* synthetic */ List f$3;

    public /* synthetic */ PurchasesOrchestrator$Companion$canMakePayments$2$1$$ExternalSyntheticLambda1(BillingResult billingResult, Callback callback, BillingClient billingClient, List list) {
        this.f$0 = billingResult;
        this.f$1 = callback;
        this.f$2 = billingClient;
        this.f$3 = list;
    }

    public final void run() {
        PurchasesOrchestrator$Companion$canMakePayments$2$1.onBillingSetupFinished$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
