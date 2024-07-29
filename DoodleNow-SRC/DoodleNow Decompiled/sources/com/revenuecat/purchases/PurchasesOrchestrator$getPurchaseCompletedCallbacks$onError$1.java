package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1 extends Lambda implements Function2<StoreTransaction, PurchasesError, Unit> {
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1(PurchasesOrchestrator purchasesOrchestrator) {
        super(2);
        this.this$0 = purchasesOrchestrator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((StoreTransaction) obj, (PurchasesError) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(storeTransaction, "purchase");
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        PurchaseCallback access$getPurchaseCallback = this.this$0.getPurchaseCallback(storeTransaction.getProductIds().get(0));
        if (access$getPurchaseCallback != null) {
            this.this$0.dispatch(access$getPurchaseCallback, purchasesError);
        }
    }
}
