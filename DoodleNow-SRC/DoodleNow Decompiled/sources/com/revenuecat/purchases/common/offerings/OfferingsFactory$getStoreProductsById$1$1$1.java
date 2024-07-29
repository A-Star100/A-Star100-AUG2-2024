package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "inAppProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsFactory.kt */
final class OfferingsFactory$getStoreProductsById$1$1$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> $onCompleted;
    final /* synthetic */ Map<String, List<StoreProduct>> $productsById;
    final /* synthetic */ OfferingsFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsFactory$getStoreProductsById$1$1$1(OfferingsFactory offeringsFactory, Map<String, List<StoreProduct>> map, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1) {
        super(1);
        this.this$0 = offeringsFactory;
        this.$productsById = map;
        this.$onCompleted = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends StoreProduct> list) {
        Intrinsics.checkNotNullParameter(list, "inAppProducts");
        Dispatcher.enqueue$default(this.this$0.dispatcher, new OfferingsFactory$getStoreProductsById$1$1$1$$ExternalSyntheticLambda0(this.$productsById, list, this.$onCompleted), (Delay) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(Map map, List list, Function1 function1) {
        Intrinsics.checkNotNullParameter(map, "$productsById");
        Intrinsics.checkNotNullParameter(list, "$inAppProducts");
        Intrinsics.checkNotNullParameter(function1, "$onCompleted");
        Iterable<StoreProduct> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (StoreProduct storeProduct : iterable) {
            arrayList.add(TuplesKt.to(storeProduct.getPurchasingData().getProductId(), CollectionsKt.listOf(storeProduct)));
        }
        MapsKt.putAll(map, (List) arrayList);
        function1.invoke(map);
    }
}
