package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "storeTxn", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$onPurchasesUpdated$1$1 extends Lambda implements Function1<StoreTransaction, Unit> {
    final /* synthetic */ List<Purchase> $notNullPurchasesList;
    final /* synthetic */ List<StoreTransaction> $storeTransactions;
    final /* synthetic */ BillingWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$onPurchasesUpdated$1$1(List<StoreTransaction> list, List<? extends Purchase> list2, BillingWrapper billingWrapper) {
        super(1);
        this.$storeTransactions = list;
        this.$notNullPurchasesList = list2;
        this.this$0 = billingWrapper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StoreTransaction) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(StoreTransaction storeTransaction) {
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener;
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTxn");
        this.$storeTransactions.add(storeTransaction);
        if (this.$storeTransactions.size() == this.$notNullPurchasesList.size() && (purchasesUpdatedListener = this.this$0.getPurchasesUpdatedListener()) != null) {
            purchasesUpdatedListener.onPurchasesUpdated(this.$storeTransactions);
        }
    }
}
