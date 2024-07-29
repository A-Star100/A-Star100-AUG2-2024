package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingClientUseCase.kt */
/* synthetic */ class BillingClientUseCase$processResult$2 extends FunctionReferenceImpl implements Function1<BillingResult, Unit> {
    BillingClientUseCase$processResult$2(Object obj) {
        super(1, obj, BillingClientUseCase.class, "forwardError", "forwardError(Lcom/android/billingclient/api/BillingResult;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "p0");
        ((BillingClientUseCase) this.receiver).forwardError(billingResult);
    }
}
