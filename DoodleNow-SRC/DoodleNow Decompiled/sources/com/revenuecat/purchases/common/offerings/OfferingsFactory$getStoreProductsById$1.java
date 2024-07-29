package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "subscriptionProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsFactory.kt */
final class OfferingsFactory$getStoreProductsById$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> $onCompleted;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Set<String> $productIds;
    final /* synthetic */ OfferingsFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsFactory$getStoreProductsById$1(OfferingsFactory offeringsFactory, Set<String> set, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        super(1);
        this.this$0 = offeringsFactory;
        this.$productIds = set;
        this.$onCompleted = function1;
        this.$onError = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends StoreProduct> list) {
        Intrinsics.checkNotNullParameter(list, "subscriptionProducts");
        Dispatcher.enqueue$default(this.this$0.dispatcher, new OfferingsFactory$getStoreProductsById$1$$ExternalSyntheticLambda0(list, this.$productIds, this.this$0, this.$onCompleted, this.$onError), (Delay) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(List list, Set set, OfferingsFactory offeringsFactory, Function1 function1, Function1 function12) {
        Intrinsics.checkNotNullParameter(list, "$subscriptionProducts");
        Intrinsics.checkNotNullParameter(set, "$productIds");
        Intrinsics.checkNotNullParameter(offeringsFactory, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$onCompleted");
        Intrinsics.checkNotNullParameter(function12, "$onError");
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : list) {
            String productId = ((StoreProduct) next).getPurchasingData().getProductId();
            Object obj = linkedHashMap.get(productId);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(productId, obj);
            }
            ((List) obj).add(next);
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        Set minus = SetsKt.minus(set, mutableMap.keySet());
        if (!minus.isEmpty()) {
            offeringsFactory.billing.queryProductDetailsAsync(ProductType.INAPP, minus, new OfferingsFactory$getStoreProductsById$1$1$1(offeringsFactory, mutableMap, function1), new OfferingsFactory$getStoreProductsById$1$1$2(function12));
        } else {
            function1.invoke(mutableMap);
        }
    }
}
