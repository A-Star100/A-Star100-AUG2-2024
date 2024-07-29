package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AcknowledgePurchaseUseCase.kt */
final class AcknowledgePurchaseUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ AcknowledgePurchaseUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AcknowledgePurchaseUseCase$executeAsync$1(AcknowledgePurchaseUseCase acknowledgePurchaseUseCase) {
        super(1);
        this.this$0 = acknowledgePurchaseUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "$this$invoke");
        AcknowledgePurchaseParams build = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(this.this$0.useCaseParams.getPurchaseToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …\n                .build()");
        billingClient.acknowledgePurchase(build, new AcknowledgePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0(this.this$0));
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(AcknowledgePurchaseUseCase acknowledgePurchaseUseCase, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(acknowledgePurchaseUseCase, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        BillingClientUseCase.processResult$default(acknowledgePurchaseUseCase, billingResult, acknowledgePurchaseUseCase.useCaseParams.getPurchaseToken(), (Function1) null, (Function1) null, 12, (Object) null);
    }
}
