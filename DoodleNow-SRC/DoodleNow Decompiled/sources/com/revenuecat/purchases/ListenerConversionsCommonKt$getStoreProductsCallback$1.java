package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, d2 = {"com/revenuecat/purchases/ListenerConversionsCommonKt$getStoreProductsCallback$1", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "storeProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ListenerConversionsCommon.kt */
public final class ListenerConversionsCommonKt$getStoreProductsCallback$1 implements GetStoreProductsCallback {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<List<? extends StoreProduct>, Unit> $onReceived;

    ListenerConversionsCommonKt$getStoreProductsCallback$1(Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        this.$onReceived = function1;
        this.$onError = function12;
    }

    public void onReceived(List<? extends StoreProduct> list) {
        Intrinsics.checkNotNullParameter(list, "storeProducts");
        this.$onReceived.invoke(list);
    }

    public void onError(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        this.$onError.invoke(purchasesError);
    }
}
