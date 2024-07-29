package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.PurchaseErrorCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$dispatch$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PurchasesError $error;
    final /* synthetic */ PurchaseErrorCallback $this_dispatch;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$dispatch$1(PurchaseErrorCallback purchaseErrorCallback, PurchasesError purchasesError) {
        super(0);
        this.$this_dispatch = purchaseErrorCallback;
        this.$error = purchasesError;
    }

    public final void invoke() {
        PurchaseErrorCallback purchaseErrorCallback = this.$this_dispatch;
        PurchasesError purchasesError = this.$error;
        purchaseErrorCallback.onError(purchasesError, purchasesError.getCode() == PurchasesErrorCode.PurchaseCancelledError);
    }
}
