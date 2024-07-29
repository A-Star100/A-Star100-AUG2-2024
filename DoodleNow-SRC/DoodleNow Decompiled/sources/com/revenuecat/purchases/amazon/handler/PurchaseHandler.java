package com.revenuecat.purchases.amazon.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0015\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JK\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u001c\u0010\u001e\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u001c\u0010\u001f\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u001c\u0010 \u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0016J2\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00102\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000eH\u0002J\u001c\u0010'\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002JV\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0016JN\u0010,\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000RD\u0010\u000b\u001a8\u0012\u0004\u0012\u00020\f\u0012.\u0012,\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u00120\r0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "applicationContext", "Landroid/content/Context;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Landroid/content/Context;)V", "productTypes", "", "", "Lcom/revenuecat/purchases/ProductType;", "purchaseCallbacks", "Lcom/amazon/device/iap/model/RequestId;", "Lkotlin/Pair;", "Lkotlin/Function2;", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "createRequestIdResultReceiver", "com/revenuecat/purchases/amazon/handler/PurchaseHandler$createRequestIdResultReceiver$1", "mainHandler", "Landroid/os/Handler;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "onSuccess", "onError", "(Landroid/os/Handler;Lcom/revenuecat/purchases/models/StoreProduct;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler$createRequestIdResultReceiver$1;", "onAlreadyPurchased", "onFailed", "onInvalidSku", "onNotSupported", "onPurchaseResponse", "response", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onSuccessfulPurchase", "receipt", "userData", "onUnknownError", "purchase", "activity", "Landroid/app/Activity;", "appUserID", "startProxyActivity", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchaseHandler.kt */
public final class PurchaseHandler implements PurchaseResponseListener {
    private final Context applicationContext;
    /* access modifiers changed from: private */
    public final Map<String, ProductType> productTypes = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<RequestId, Pair<Function2<Receipt, UserData, Unit>, Function1<PurchasesError, Unit>>> purchaseCallbacks = new LinkedHashMap();
    private final PurchasingServiceProvider purchasingServiceProvider;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PurchaseHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus[] r0 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.INVALID_SKU     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.ALREADY_PURCHASED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.amazon.device.iap.model.PurchaseResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseResponse.RequestStatus.NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.PurchaseHandler.WhenMappings.<clinit>():void");
        }
    }

    public PurchaseHandler(PurchasingServiceProvider purchasingServiceProvider2, Context context) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider2, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        this.purchasingServiceProvider = purchasingServiceProvider2;
        this.applicationContext = context;
    }

    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        PurchaseResponseListener.DefaultImpls.onProductDataResponse(this, productDataResponse);
    }

    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        PurchaseResponseListener.DefaultImpls.onPurchaseUpdatesResponse(this, purchaseUpdatesResponse);
    }

    public void onUserDataResponse(UserDataResponse userDataResponse) {
        PurchaseResponseListener.DefaultImpls.onUserDataResponse(this, userDataResponse);
    }

    public void purchase(Handler handler, Activity activity, String str, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        LogIntent logIntent = LogIntent.PURCHASE;
        String format = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{storeProduct.getId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        startProxyActivity(handler, activity, storeProduct, function2, function1);
    }

    private final void startProxyActivity(Handler handler, Activity activity, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        activity.startActivity(ProxyAmazonBillingActivity.Companion.newStartIntent(activity, createRequestIdResultReceiver(handler, storeProduct, function2, function1), storeProduct.getId(), this.purchasingServiceProvider));
    }

    private final PurchaseHandler$createRequestIdResultReceiver$1 createRequestIdResultReceiver(Handler handler, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        return new PurchaseHandler$createRequestIdResultReceiver$1(handler, this, function2, function1, storeProduct);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a4, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        com.revenuecat.purchases.common.LogUtilsKt.errorLog("Exception in onPurchaseResponse", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ad, code lost:
        throw r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPurchaseResponse(com.amazon.device.iap.model.PurchaseResponse r7) {
        /*
            r6 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.revenuecat.purchases.common.LogIntent r0 = com.revenuecat.purchases.common.LogIntent.DEBUG     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = "Purchase request finished: \n %s"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00a4 }
            org.json.JSONObject r4 = r7.toJSON()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = r4.toString(r2)     // Catch:{ Exception -> 0x00a4 }
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x00a4 }
            com.revenuecat.purchases.common.LogWrapperKt.log(r0, r1)     // Catch:{ Exception -> 0x00a4 }
            com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivityBroadcastReceiver$Companion r0 = com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivityBroadcastReceiver.Companion     // Catch:{ Exception -> 0x00a4 }
            android.content.Context r1 = r6.applicationContext     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r3 = "applicationContext.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x00a4 }
            android.content.Intent r0 = r0.newPurchaseFinishedIntent(r1)     // Catch:{ Exception -> 0x00a4 }
            android.content.Context r1 = r6.applicationContext     // Catch:{ Exception -> 0x00a4 }
            r1.sendBroadcast(r0)     // Catch:{ Exception -> 0x00a4 }
            com.amazon.device.iap.model.RequestId r0 = r7.getRequestId()     // Catch:{ Exception -> 0x00a4 }
            monitor-enter(r6)     // Catch:{ Exception -> 0x00a4 }
            java.util.Map<com.amazon.device.iap.model.RequestId, kotlin.Pair<kotlin.jvm.functions.Function2<com.amazon.device.iap.model.Receipt, com.amazon.device.iap.model.UserData, kotlin.Unit>, kotlin.jvm.functions.Function1<com.revenuecat.purchases.PurchasesError, kotlin.Unit>>> r1 = r6.purchaseCallbacks     // Catch:{ all -> 0x00a1 }
            java.lang.Object r0 = r1.remove(r0)     // Catch:{ all -> 0x00a1 }
            kotlin.Pair r0 = (kotlin.Pair) r0     // Catch:{ all -> 0x00a1 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x00a4 }
            if (r0 == 0) goto L_0x00a0
            java.lang.Object r1 = r0.component1()     // Catch:{ Exception -> 0x00a4 }
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r0 = r0.component2()     // Catch:{ Exception -> 0x00a4 }
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch:{ Exception -> 0x00a4 }
            com.amazon.device.iap.model.PurchaseResponse$RequestStatus r3 = r7.getRequestStatus()     // Catch:{ Exception -> 0x00a4 }
            if (r3 != 0) goto L_0x0061
            r3 = -1
            goto L_0x0069
        L_0x0061:
            int[] r4 = com.revenuecat.purchases.amazon.handler.PurchaseHandler.WhenMappings.$EnumSwitchMapping$0     // Catch:{ Exception -> 0x00a4 }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x00a4 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x00a4 }
        L_0x0069:
            if (r3 == r2) goto L_0x008b
            r7 = 2
            if (r3 == r7) goto L_0x0087
            r7 = 3
            if (r3 == r7) goto L_0x0083
            r7 = 4
            if (r3 == r7) goto L_0x007f
            r7 = 5
            if (r3 == r7) goto L_0x007b
            r6.onUnknownError(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a0
        L_0x007b:
            r6.onNotSupported(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a0
        L_0x007f:
            r6.onAlreadyPurchased(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a0
        L_0x0083:
            r6.onInvalidSku(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a0
        L_0x0087:
            r6.onFailed(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a0
        L_0x008b:
            com.amazon.device.iap.model.Receipt r0 = r7.getReceipt()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "response.receipt"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x00a4 }
            com.amazon.device.iap.model.UserData r7 = r7.getUserData()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "response.userData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ Exception -> 0x00a4 }
            r6.onSuccessfulPurchase(r0, r7, r1)     // Catch:{ Exception -> 0x00a4 }
        L_0x00a0:
            return
        L_0x00a1:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ Exception -> 0x00a4 }
            throw r7     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            r7 = move-exception
            java.lang.String r0 = "Exception in onPurchaseResponse"
            r1 = r7
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.revenuecat.purchases.common.LogUtilsKt.errorLog(r0, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.PurchaseHandler.onPurchaseResponse(com.amazon.device.iap.model.PurchaseResponse):void");
    }

    private final void onSuccessfulPurchase(Receipt receipt, UserData userData, Function2<? super Receipt, ? super UserData, Unit> function2) {
        function2.invoke(receipt, userData);
    }

    private final void onUnknownError(Function1<? super PurchasesError, Unit> function1) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_UNKNOWN));
    }

    private final void onNotSupported(Function1<? super PurchasesError, Unit> function1) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_NOT_SUPPORTED));
    }

    private final void onAlreadyPurchased(Function1<? super PurchasesError, Unit> function1) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.ProductAlreadyPurchasedError, AmazonStrings.ERROR_PURCHASE_ALREADY_OWNED));
    }

    private final void onInvalidSku(Function1<? super PurchasesError, Unit> function1) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, AmazonStrings.ERROR_PURCHASE_INVALID_SKU));
    }

    private final void onFailed(Function1<? super PurchasesError, Unit> function1) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.PurchaseCancelledError, AmazonStrings.ERROR_PURCHASE_FAILED));
    }
}
