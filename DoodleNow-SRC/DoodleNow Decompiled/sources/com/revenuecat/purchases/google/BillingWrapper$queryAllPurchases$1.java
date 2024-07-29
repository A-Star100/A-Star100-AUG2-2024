package com.revenuecat.purchases.google;

import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "subsPurchasesList", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$queryAllPurchases$1 extends Lambda implements Function1<List<? extends PurchaseHistoryRecord>, Unit> {
    final /* synthetic */ Function1<List<StoreTransaction>, Unit> $onReceivePurchaseHistory;
    final /* synthetic */ Function1<PurchasesError, Unit> $onReceivePurchaseHistoryError;
    final /* synthetic */ BillingWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$queryAllPurchases$1(BillingWrapper billingWrapper, Function1<? super PurchasesError, Unit> function1, Function1<? super List<StoreTransaction>, Unit> function12) {
        super(1);
        this.this$0 = billingWrapper;
        this.$onReceivePurchaseHistoryError = function1;
        this.$onReceivePurchaseHistory = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends PurchaseHistoryRecord>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final List<? extends PurchaseHistoryRecord> list) {
        Intrinsics.checkNotNullParameter(list, "subsPurchasesList");
        BillingWrapper billingWrapper = this.this$0;
        final Function1<List<StoreTransaction>, Unit> function1 = this.$onReceivePurchaseHistory;
        billingWrapper.queryPurchaseHistoryAsync("inapp", new Function1<List<? extends PurchaseHistoryRecord>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends PurchaseHistoryRecord>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends PurchaseHistoryRecord> list) {
                Intrinsics.checkNotNullParameter(list, "inAppPurchasesList");
                Function1<List<StoreTransaction>, Unit> function1 = function1;
                Iterable<PurchaseHistoryRecord> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (PurchaseHistoryRecord storeTransaction : iterable) {
                    arrayList.add(StoreTransactionConversionsKt.toStoreTransaction(storeTransaction, ProductType.SUBS));
                }
                Collection collection = (List) arrayList;
                Iterable<PurchaseHistoryRecord> iterable2 = list;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (PurchaseHistoryRecord storeTransaction2 : iterable2) {
                    arrayList2.add(StoreTransactionConversionsKt.toStoreTransaction(storeTransaction2, ProductType.INAPP));
                }
                function1.invoke(CollectionsKt.plus(collection, (List) arrayList2));
            }
        }, this.$onReceivePurchaseHistoryError);
    }
}
