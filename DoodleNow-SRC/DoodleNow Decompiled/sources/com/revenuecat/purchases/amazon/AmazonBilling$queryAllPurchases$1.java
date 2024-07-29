package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$queryAllPurchases$1 extends Lambda implements Function1<Map<String, ? extends StoreTransaction>, Unit> {
    final /* synthetic */ Function1<List<StoreTransaction>, Unit> $onReceivePurchaseHistory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$queryAllPurchases$1(Function1<? super List<StoreTransaction>, Unit> function1) {
        super(1);
        this.$onReceivePurchaseHistory = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, StoreTransaction>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, StoreTransaction> map) {
        Intrinsics.checkNotNullParameter(map, "it");
        this.$onReceivePurchaseHistory.invoke(CollectionsKt.toList(map.values()));
    }
}
