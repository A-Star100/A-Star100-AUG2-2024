package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingResult;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AcknowledgePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0 implements AcknowledgePurchaseResponseListener {
    public final /* synthetic */ AcknowledgePurchaseUseCase f$0;

    public /* synthetic */ AcknowledgePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0(AcknowledgePurchaseUseCase acknowledgePurchaseUseCase) {
        this.f$0 = acknowledgePurchaseUseCase;
    }

    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
        AcknowledgePurchaseUseCase$executeAsync$1.invoke$lambda$0(this.f$0, billingResult);
    }
}
