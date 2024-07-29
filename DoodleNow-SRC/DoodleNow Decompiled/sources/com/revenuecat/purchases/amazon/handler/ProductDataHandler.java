package com.revenuecat.purchases.amazon.handler;

import android.os.Handler;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.StoreProductConversionsKt;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0002JL\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00110\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0018H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002JB\u0010\u001e\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0 2\u0006\u0010\u0016\u001a\u00020\t2\u001c\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00110\u0018j\u0002`!H\u0002J(\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0018j\u0002`%H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8@X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\b8BX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler;", "Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "mainHandler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Landroid/os/Handler;)V", "productDataCache", "", "", "Lcom/amazon/device/iap/model/Product;", "getProductDataCache$purchases_defaultsRelease", "()Ljava/util/Map;", "productDataRequests", "Lcom/amazon/device/iap/model/RequestId;", "Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler$Request;", "addTimeoutToProductDataRequest", "", "requestId", "getProductData", "skus", "", "marketplace", "onReceive", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "getRequest", "handleSuccessfulProductDataResponse", "productData", "", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "handleUnsuccessfulProductDataResponse", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onProductDataResponse", "Companion", "Request", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ProductDataHandler.kt */
public final class ProductDataHandler implements ProductDataResponseListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long GET_PRODUCT_DATA_TIMEOUT_MILLIS = 10000;
    private final Handler mainHandler;
    private final Map<String, Product> productDataCache = new LinkedHashMap();
    private final Map<RequestId, Request> productDataRequests = new LinkedHashMap();
    private final PurchasingServiceProvider purchasingServiceProvider;

    public ProductDataHandler(PurchasingServiceProvider purchasingServiceProvider2, Handler handler) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider2, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        this.purchasingServiceProvider = purchasingServiceProvider2;
        this.mainHandler = handler;
    }

    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        ProductDataResponseListener.DefaultImpls.onPurchaseResponse(this, purchaseResponse);
    }

    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        ProductDataResponseListener.DefaultImpls.onPurchaseUpdatesResponse(this, purchaseUpdatesResponse);
    }

    public void onUserDataResponse(UserDataResponse userDataResponse) {
        ProductDataResponseListener.DefaultImpls.onUserDataResponse(this, userDataResponse);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler$Companion;", "", "()V", "GET_PRODUCT_DATA_TIMEOUT_MILLIS", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ProductDataHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001c\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\u0018\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nHÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\rHÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\rHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler$Request;", "", "skuList", "", "", "marketplace", "onReceive", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/models/StoreProduct;", "", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getMarketplace", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getSkuList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ProductDataHandler.kt */
    private static final class Request {
        private final String marketplace;
        private final Function1<PurchasesError, Unit> onError;
        private final Function1<List<? extends StoreProduct>, Unit> onReceive;
        private final List<String> skuList;

        public static /* synthetic */ Request copy$default(Request request, List<String> list, String str, Function1<List<? extends StoreProduct>, Unit> function1, Function1<PurchasesError, Unit> function12, int i, Object obj) {
            if ((i & 1) != 0) {
                list = request.skuList;
            }
            if ((i & 2) != 0) {
                str = request.marketplace;
            }
            if ((i & 4) != 0) {
                function1 = request.onReceive;
            }
            if ((i & 8) != 0) {
                function12 = request.onError;
            }
            return request.copy(list, str, function1, function12);
        }

        public final List<String> component1() {
            return this.skuList;
        }

        public final String component2() {
            return this.marketplace;
        }

        public final Function1<List<? extends StoreProduct>, Unit> component3() {
            return this.onReceive;
        }

        public final Function1<PurchasesError, Unit> component4() {
            return this.onError;
        }

        public final Request copy(List<String> list, String str, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
            Intrinsics.checkNotNullParameter(list, "skuList");
            Intrinsics.checkNotNullParameter(str, b.m);
            Intrinsics.checkNotNullParameter(function1, "onReceive");
            Intrinsics.checkNotNullParameter(function12, "onError");
            return new Request(list, str, function1, function12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.skuList, (Object) request.skuList) && Intrinsics.areEqual((Object) this.marketplace, (Object) request.marketplace) && Intrinsics.areEqual((Object) this.onReceive, (Object) request.onReceive) && Intrinsics.areEqual((Object) this.onError, (Object) request.onError);
        }

        public final String getMarketplace() {
            return this.marketplace;
        }

        public final Function1<PurchasesError, Unit> getOnError() {
            return this.onError;
        }

        public final Function1<List<? extends StoreProduct>, Unit> getOnReceive() {
            return this.onReceive;
        }

        public final List<String> getSkuList() {
            return this.skuList;
        }

        public int hashCode() {
            return (((((this.skuList.hashCode() * 31) + this.marketplace.hashCode()) * 31) + this.onReceive.hashCode()) * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "Request(skuList=" + this.skuList + ", marketplace=" + this.marketplace + ", onReceive=" + this.onReceive + ", onError=" + this.onError + ')';
        }

        public Request(List<String> list, String str, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
            Intrinsics.checkNotNullParameter(list, "skuList");
            Intrinsics.checkNotNullParameter(str, b.m);
            Intrinsics.checkNotNullParameter(function1, "onReceive");
            Intrinsics.checkNotNullParameter(function12, "onError");
            this.skuList = list;
            this.marketplace = str;
            this.onReceive = function1;
            this.onError = function12;
        }
    }

    public final synchronized Map<String, Product> getProductDataCache$purchases_defaultsRelease() {
        return this.productDataCache;
    }

    public void getProductData(Set<String> set, String str, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Map<String, Product> map;
        Set<String> set2 = set;
        String str2 = str;
        Function1<? super List<? extends StoreProduct>, Unit> function13 = function1;
        Function1<? super PurchasesError, Unit> function14 = function12;
        Intrinsics.checkNotNullParameter(set2, b.O);
        Intrinsics.checkNotNullParameter(str2, b.m);
        Intrinsics.checkNotNullParameter(function13, "onReceive");
        Intrinsics.checkNotNullParameter(function14, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        Iterable iterable = set2;
        String format = String.format(AmazonStrings.REQUESTING_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            map = MapsKt.toMap(this.productDataCache);
        }
        if (map.keySet().containsAll(set2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                if (set2.contains((String) next.getKey())) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            handleSuccessfulProductDataResponse(linkedHashMap, str2, function13);
            return;
        }
        RequestId productData = this.purchasingServiceProvider.getProductData(set2);
        Request request = new Request(CollectionsKt.toList(iterable), str2, function13, function14);
        synchronized (this) {
            this.productDataRequests.put(productData, request);
            addTimeoutToProductDataRequest(productData);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a0, code lost:
        com.revenuecat.purchases.common.LogUtilsKt.errorLog("Exception in onProductDataResponse", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a8, code lost:
        throw r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onProductDataResponse(com.amazon.device.iap.model.ProductDataResponse r7) {
        /*
            r6 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.revenuecat.purchases.common.LogIntent r0 = com.revenuecat.purchases.common.LogIntent.DEBUG     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "Products request finished with result %s"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009f }
            com.amazon.device.iap.model.ProductDataResponse$RequestStatus r4 = r7.getRequestStatus()     // Catch:{ Exception -> 0x009f }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x009f }
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x009f }
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x009f }
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x009f }
            com.revenuecat.purchases.common.LogWrapperKt.log(r0, r1)     // Catch:{ Exception -> 0x009f }
            java.util.Set r0 = r7.getUnavailableSkus()     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "response.unavailableSkus"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x009f }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x009f }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x009f }
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0055
            com.revenuecat.purchases.common.LogIntent r0 = com.revenuecat.purchases.common.LogIntent.DEBUG     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "Unavailable products: %s"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009f }
            java.util.Set r4 = r7.getUnavailableSkus()     // Catch:{ Exception -> 0x009f }
            r3[r5] = r4     // Catch:{ Exception -> 0x009f }
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x009f }
            com.revenuecat.purchases.common.LogWrapperKt.log(r0, r1)     // Catch:{ Exception -> 0x009f }
        L_0x0055:
            com.amazon.device.iap.model.RequestId r0 = r7.getRequestId()     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "requestId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x009f }
            com.revenuecat.purchases.amazon.handler.ProductDataHandler$Request r0 = r6.getRequest(r0)     // Catch:{ Exception -> 0x009f }
            if (r0 != 0) goto L_0x0065
            return
        L_0x0065:
            com.amazon.device.iap.model.ProductDataResponse$RequestStatus r1 = r7.getRequestStatus()     // Catch:{ Exception -> 0x009f }
            com.amazon.device.iap.model.ProductDataResponse$RequestStatus r2 = com.amazon.device.iap.model.ProductDataResponse.RequestStatus.SUCCESSFUL     // Catch:{ Exception -> 0x009f }
            if (r1 != r2) goto L_0x0097
            monitor-enter(r6)     // Catch:{ Exception -> 0x009f }
            java.util.Map<java.lang.String, com.amazon.device.iap.model.Product> r1 = r6.productDataCache     // Catch:{ all -> 0x0094 }
            java.util.Map r2 = r7.getProductData()     // Catch:{ all -> 0x0094 }
            java.lang.String r3 = "response.productData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0094 }
            r1.putAll(r2)     // Catch:{ all -> 0x0094 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0094 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x009f }
            java.util.Map r7 = r7.getProductData()     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "response.productData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = r0.getMarketplace()     // Catch:{ Exception -> 0x009f }
            kotlin.jvm.functions.Function1 r0 = r0.getOnReceive()     // Catch:{ Exception -> 0x009f }
            r6.handleSuccessfulProductDataResponse(r7, r1, r0)     // Catch:{ Exception -> 0x009f }
            goto L_0x009e
        L_0x0094:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ Exception -> 0x009f }
            throw r7     // Catch:{ Exception -> 0x009f }
        L_0x0097:
            kotlin.jvm.functions.Function1 r0 = r0.getOnError()     // Catch:{ Exception -> 0x009f }
            r6.handleUnsuccessfulProductDataResponse(r7, r0)     // Catch:{ Exception -> 0x009f }
        L_0x009e:
            return
        L_0x009f:
            r7 = move-exception
            java.lang.String r0 = "Exception in onProductDataResponse"
            r1 = r7
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.revenuecat.purchases.common.LogUtilsKt.errorLog(r0, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.ProductDataHandler.onProductDataResponse(com.amazon.device.iap.model.ProductDataResponse):void");
    }

    private final void handleSuccessfulProductDataResponse(Map<String, Product> map, String str, Function1<? super List<? extends StoreProduct>, Unit> function1) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AmazonStrings.RETRIEVED_PRODUCT_DATA, Arrays.copyOf(new Object[]{map}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        if (map.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, AmazonStrings.RETRIEVED_PRODUCT_DATA_EMPTY);
        }
        Collection arrayList = new ArrayList();
        for (Product storeProduct : map.values()) {
            StoreProduct storeProduct2 = StoreProductConversionsKt.toStoreProduct(storeProduct, str);
            if (storeProduct2 != null) {
                arrayList.add(storeProduct2);
            }
        }
        function1.invoke((List) arrayList);
    }

    private final void handleUnsuccessfulProductDataResponse(ProductDataResponse productDataResponse, Function1<? super PurchasesError, Unit> function1) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, productDataResponse.getRequestStatus() == ProductDataResponse.RequestStatus.NOT_SUPPORTED ? "Couldn't fetch product data, since it's not supported." : "Error when fetching product data."));
    }

    private final void addTimeoutToProductDataRequest(RequestId requestId) {
        this.mainHandler.postDelayed(new ProductDataHandler$$ExternalSyntheticLambda0(this, requestId), 10000);
    }

    /* access modifiers changed from: private */
    public static final void addTimeoutToProductDataRequest$lambda$6(ProductDataHandler productDataHandler, RequestId requestId) {
        Intrinsics.checkNotNullParameter(productDataHandler, "this$0");
        Intrinsics.checkNotNullParameter(requestId, "$requestId");
        Request request = productDataHandler.getRequest(requestId);
        if (request != null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String format = String.format(AmazonStrings.ERROR_TIMEOUT_GETTING_PRODUCT_DATA, Arrays.copyOf(new Object[]{request.getSkuList().toString()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            request.getOnError().invoke(new PurchasesError(purchasesErrorCode, format));
        }
    }

    private final synchronized Request getRequest(RequestId requestId) {
        return this.productDataRequests.remove(requestId);
    }
}
