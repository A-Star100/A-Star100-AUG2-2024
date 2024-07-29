package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "connectionError", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingClientUseCase.kt */
final class BillingClientUseCase$run$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ BillingClientUseCase<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingClientUseCase$run$1(BillingClientUseCase<T> billingClientUseCase) {
        super(1);
        this.this$0 = billingClientUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError == null) {
            this.this$0.executeAsync();
        } else {
            this.this$0.onError.invoke(purchasesError);
        }
    }
}
