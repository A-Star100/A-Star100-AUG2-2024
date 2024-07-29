package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.models.StoreTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "activePurchasesByHashedToken", "", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasedProductsFetcher.kt */
final class PurchasedProductsFetcher$queryActiveProducts$1 extends Lambda implements Function1<Map<String, ? extends StoreTransaction>, Unit> {
    final /* synthetic */ Function1<List<PurchasedProduct>, Unit> $onSuccess;
    final /* synthetic */ ProductEntitlementMapping $productEntitlementMapping;
    final /* synthetic */ PurchasedProductsFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasedProductsFetcher$queryActiveProducts$1(Function1<? super List<PurchasedProduct>, Unit> function1, PurchasedProductsFetcher purchasedProductsFetcher, ProductEntitlementMapping productEntitlementMapping) {
        super(1);
        this.$onSuccess = function1;
        this.this$0 = purchasedProductsFetcher;
        this.$productEntitlementMapping = productEntitlementMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, StoreTransaction>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, StoreTransaction> map) {
        Intrinsics.checkNotNullParameter(map, "activePurchasesByHashedToken");
        Iterable<StoreTransaction> list = CollectionsKt.toList(map.values());
        PurchasedProductsFetcher purchasedProductsFetcher = this.this$0;
        ProductEntitlementMapping productEntitlementMapping = this.$productEntitlementMapping;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (StoreTransaction access$createPurchasedProduct : list) {
            arrayList.add(purchasedProductsFetcher.createPurchasedProduct(access$createPurchasedProduct, productEntitlementMapping));
        }
        this.$onSuccess.invoke((List) arrayList);
    }
}
