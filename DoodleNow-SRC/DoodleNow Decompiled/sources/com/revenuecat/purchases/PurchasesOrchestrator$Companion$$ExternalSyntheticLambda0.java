package com.revenuecat.purchases;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.revenuecat.purchases.PurchasesOrchestrator;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PurchasesOrchestrator$Companion$$ExternalSyntheticLambda0 implements PurchasesUpdatedListener {
    public final void onPurchasesUpdated(BillingResult billingResult, List list) {
        PurchasesOrchestrator.Companion.canMakePayments$lambda$0(billingResult, list);
    }
}
