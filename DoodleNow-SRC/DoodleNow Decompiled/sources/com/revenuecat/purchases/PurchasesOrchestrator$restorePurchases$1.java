package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "allPurchases", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$restorePurchases$1 extends Lambda implements Function1<List<? extends StoreTransaction>, Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ ReceiveCustomerInfoCallback $callback;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$restorePurchases$1(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, String str) {
        super(1);
        this.this$0 = purchasesOrchestrator;
        this.$callback = receiveCustomerInfoCallback;
        this.$appUserID = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<StoreTransaction>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<StoreTransaction> list) {
        Intrinsics.checkNotNullParameter(list, "allPurchases");
        if (list.isEmpty()) {
            this.this$0.getCustomerInfo(this.$callback);
            return;
        }
        List<StoreTransaction> sortedWith = CollectionsKt.sortedWith(list, new PurchasesOrchestrator$restorePurchases$1$invoke$$inlined$sortedBy$1());
        PurchasesOrchestrator purchasesOrchestrator = this.this$0;
        String str = this.$appUserID;
        ReceiveCustomerInfoCallback receiveCustomerInfoCallback = this.$callback;
        for (StoreTransaction storeTransaction : sortedWith) {
            purchasesOrchestrator.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, (StoreProduct) null, true, str, PostReceiptInitiationSource.RESTORE, new PurchasesOrchestrator$restorePurchases$1$2$1$1(storeTransaction, sortedWith, purchasesOrchestrator, receiveCustomerInfoCallback), new PurchasesOrchestrator$restorePurchases$1$2$1$2(storeTransaction, sortedWith, purchasesOrchestrator, receiveCustomerInfoCallback));
        }
    }
}
