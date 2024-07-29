package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u000f\u001a\u00020\u00102'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0000\u001ax\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\n26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\nH\u0000\u001aR\u0010\u001d\u001a\u00020\u001e2#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00012#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001H\u0000\u001aN\u0010\u001f\u001a\u00020 2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0000\u001aR\u0010#\u001a\u00020\u0006*\u00020$2#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00060\u0001\u001af\u0010%\u001a\u00020\u0006*\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00122#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012'\u0010(\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u0001\u001ap\u0010%\u001a\u00020\u0006*\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00122\b\u0010)\u001a\u0004\u0018\u00010*2#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012'\u0010(\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u0001\u001a\u0001\u0010+\u001a\u00020\u0006*\u00020$2\u0006\u0010,\u001a\u00020-28\b\u0002\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\n28\u0010\u0018\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\n\u001aR\u0010.\u001a\u00020\u0006*\u00020$2#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0001\"/\u0010\u0000\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"D\u0010\t\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006/"}, d2 = {"ON_ERROR_STUB", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "error", "", "getON_ERROR_STUB", "()Lkotlin/jvm/functions/Function1;", "ON_PURCHASE_ERROR_STUB", "Lkotlin/Function2;", "", "userCancelled", "getON_PURCHASE_ERROR_STUB", "()Lkotlin/jvm/functions/Function2;", "getStoreProductsCallback", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "onReceived", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProducts", "onError", "purchaseCompletedCallback", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "onSuccess", "Lcom/revenuecat/purchases/models/StoreTransaction;", "purchase", "Lcom/revenuecat/purchases/CustomerInfo;", "customerInfo", "receiveCustomerInfoCallback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "receiveOfferingsCallback", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "Lcom/revenuecat/purchases/Offerings;", "offerings", "getOfferingsWith", "Lcom/revenuecat/purchases/Purchases;", "getProductsWith", "productIds", "", "onGetStoreProducts", "type", "Lcom/revenuecat/purchases/ProductType;", "purchaseWith", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "restorePurchasesWith", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ListenerConversionsCommon.kt */
public final class ListenerConversionsCommonKt {
    private static final Function1<PurchasesError, Unit> ON_ERROR_STUB = ListenerConversionsCommonKt$ON_ERROR_STUB$1.INSTANCE;
    private static final Function2<PurchasesError, Boolean, Unit> ON_PURCHASE_ERROR_STUB = ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1.INSTANCE;

    public static final Function1<PurchasesError, Unit> getON_ERROR_STUB() {
        return ON_ERROR_STUB;
    }

    public static final Function2<PurchasesError, Boolean, Unit> getON_PURCHASE_ERROR_STUB() {
        return ON_PURCHASE_ERROR_STUB;
    }

    public static final PurchaseCallback purchaseCompletedCallback(Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, Function2<? super PurchasesError, ? super Boolean, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function22, "onError");
        return new ListenerConversionsCommonKt$purchaseCompletedCallback$1(function2, function22);
    }

    public static final GetStoreProductsCallback getStoreProductsCallback(Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onReceived");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return new ListenerConversionsCommonKt$getStoreProductsCallback$1(function1, function12);
    }

    public static final ReceiveOfferingsCallback receiveOfferingsCallback(Function1<? super Offerings, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return new ListenerConversionsCommonKt$receiveOfferingsCallback$1(function1, function12);
    }

    public static final ReceiveCustomerInfoCallback receiveCustomerInfoCallback(Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return new ListenerConversionsCommonKt$receiveCustomerInfoCallback$1(function1, function12);
    }

    public static /* synthetic */ void getOfferingsWith$default(Purchases purchases, Function1<PurchasesError, Unit> function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getOfferingsWith(purchases, function1, function12);
    }

    public static final void getOfferingsWith(Purchases purchases, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function12, "onSuccess");
        purchases.getOfferings(receiveOfferingsCallback(function12, function1));
    }

    public static /* synthetic */ void purchaseWith$default(Purchases purchases, PurchaseParams purchaseParams, Function2<PurchasesError, Boolean, Unit> function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = ON_PURCHASE_ERROR_STUB;
        }
        purchaseWith(purchases, purchaseParams, function2, function22);
    }

    public static final void purchaseWith(Purchases purchases, PurchaseParams purchaseParams, Function2<? super PurchasesError, ? super Boolean, Unit> function2, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function22) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(function2, "onError");
        Intrinsics.checkNotNullParameter(function22, "onSuccess");
        purchases.purchase(purchaseParams, purchaseCompletedCallback(function22, function2));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, Function1<PurchasesError, Unit> function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, function1, function12);
    }

    public static final void getProductsWith(Purchases purchases, List<String> list, Function1<? super PurchasesError, Unit> function1, Function1<? super List<? extends StoreProduct>, Unit> function12) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function12, "onGetStoreProducts");
        purchases.getProducts(list, getStoreProductsCallback(function12, function1));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, ProductType productType, Function1<PurchasesError, Unit> function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, productType, function1, function12);
    }

    public static final void getProductsWith(Purchases purchases, List<String> list, ProductType productType, Function1<? super PurchasesError, Unit> function1, Function1<? super List<? extends StoreProduct>, Unit> function12) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function12, "onGetStoreProducts");
        purchases.getProducts(list, productType, getStoreProductsCallback(function12, function1));
    }

    public static /* synthetic */ void restorePurchasesWith$default(Purchases purchases, Function1<PurchasesError, Unit> function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ON_ERROR_STUB;
        }
        restorePurchasesWith(purchases, function1, function12);
    }

    public static final void restorePurchasesWith(Purchases purchases, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function12, "onSuccess");
        purchases.restorePurchases(receiveCustomerInfoCallback(function12, function1));
    }
}
