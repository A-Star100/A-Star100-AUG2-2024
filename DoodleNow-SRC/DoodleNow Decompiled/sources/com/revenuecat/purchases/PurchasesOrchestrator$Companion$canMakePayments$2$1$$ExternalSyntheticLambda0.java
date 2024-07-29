package com.revenuecat.purchases;

import com.android.billingclient.api.BillingClient;
import com.revenuecat.purchases.interfaces.Callback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PurchasesOrchestrator$Companion$canMakePayments$2$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BillingClient f$0;
    public final /* synthetic */ Callback f$1;

    public /* synthetic */ PurchasesOrchestrator$Companion$canMakePayments$2$1$$ExternalSyntheticLambda0(BillingClient billingClient, Callback callback) {
        this.f$0 = billingClient;
        this.f$1 = callback;
    }

    public final void run() {
        PurchasesOrchestrator$Companion$canMakePayments$2$1.onBillingServiceDisconnected$lambda$2(this.f$0, this.f$1);
    }
}
