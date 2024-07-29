package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/CustomerInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$syncPurchases$1 extends Lambda implements Function1<CustomerInfo, Unit> {
    final /* synthetic */ SyncPurchasesCallback $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$syncPurchases$1(SyncPurchasesCallback syncPurchasesCallback) {
        super(1);
        this.$listener = syncPurchasesCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "it");
        SyncPurchasesCallback syncPurchasesCallback = this.$listener;
        if (syncPurchasesCallback != null) {
            syncPurchasesCallback.onSuccess(customerInfo);
        }
    }
}
