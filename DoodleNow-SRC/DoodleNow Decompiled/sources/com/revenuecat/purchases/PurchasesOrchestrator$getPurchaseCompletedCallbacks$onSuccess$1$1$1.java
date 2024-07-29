package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CustomerInfo $info;
    final /* synthetic */ PurchaseCallback $purchaseCallback;
    final /* synthetic */ StoreTransaction $storeTransaction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1$1$1(PurchaseCallback purchaseCallback, StoreTransaction storeTransaction, CustomerInfo customerInfo) {
        super(0);
        this.$purchaseCallback = purchaseCallback;
        this.$storeTransaction = storeTransaction;
        this.$info = customerInfo;
    }

    public final void invoke() {
        this.$purchaseCallback.onCompleted(this.$storeTransaction, this.$info);
    }
}
