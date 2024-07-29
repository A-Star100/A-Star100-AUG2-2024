package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingConfigResponseListener;
import com.android.billingclient.api.BillingResult;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GetBillingConfigUseCase$executeAsync$1$$ExternalSyntheticLambda0 implements BillingConfigResponseListener {
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ GetBillingConfigUseCase f$1;

    public /* synthetic */ GetBillingConfigUseCase$executeAsync$1$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean, GetBillingConfigUseCase getBillingConfigUseCase) {
        this.f$0 = atomicBoolean;
        this.f$1 = getBillingConfigUseCase;
    }

    public final void onBillingConfigResponse(BillingResult billingResult, BillingConfig billingConfig) {
        GetBillingConfigUseCase$executeAsync$1.invoke$lambda$0(this.f$0, this.f$1, billingResult, billingConfig);
    }
}
