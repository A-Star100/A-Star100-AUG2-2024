package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.ConsumeParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConsumePurchaseUseCase.kt */
final class ConsumePurchaseUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ ConsumePurchaseUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConsumePurchaseUseCase$executeAsync$1(ConsumePurchaseUseCase consumePurchaseUseCase) {
        super(1);
        this.this$0 = consumePurchaseUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "$this$invoke");
        ConsumeParams build = ConsumeParams.newBuilder().setPurchaseToken(this.this$0.useCaseParams.getPurchaseToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …\n                .build()");
        billingClient.consumeAsync(build, new ConsumePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0(this.this$0));
    }
}
