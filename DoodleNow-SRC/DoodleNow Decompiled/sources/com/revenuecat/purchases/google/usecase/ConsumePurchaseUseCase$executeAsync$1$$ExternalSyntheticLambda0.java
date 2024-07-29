package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeResponseListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConsumePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0 implements ConsumeResponseListener {
    public final /* synthetic */ ConsumePurchaseUseCase f$0;

    public /* synthetic */ ConsumePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0(ConsumePurchaseUseCase consumePurchaseUseCase) {
        this.f$0 = consumePurchaseUseCase;
    }

    public final void onConsumeResponse(BillingResult billingResult, String str) {
        BillingClientUseCase.processResult$default(this.f$0, billingResult, str, (Function1) null, (Function1) null, 12, (Object) null);
    }
}
