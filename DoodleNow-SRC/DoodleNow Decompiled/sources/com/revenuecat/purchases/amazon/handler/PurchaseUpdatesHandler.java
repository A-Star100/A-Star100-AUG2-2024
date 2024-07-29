package com.revenuecat.purchases.amazon.handler;

import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016JD\u0010\u0016\u001a\u00020\r2\"\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u0011H\u0016J$\u0010\u0019\u001a\u00020\r*\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000RV\u0010\u0005\u001aJ\u0012\u0004\u0012\u00020\u0007\u0012@\u0012>\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u00110\bj\u0002`\u00120\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/PurchaseUpdatesHandler;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;)V", "requests", "", "Lcom/amazon/device/iap/model/RequestId;", "Lkotlin/Pair;", "Lkotlin/Function2;", "", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "", "Lcom/revenuecat/purchases/amazon/handler/QueryPurchasesSuccessCallback;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "Lcom/revenuecat/purchases/amazon/handler/QueryPurchasesCallbacks;", "onPurchaseUpdatesResponse", "response", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "queryPurchases", "onSuccess", "onError", "invokeWithStoreProblem", "message", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchaseUpdatesHandler.kt */
public final class PurchaseUpdatesHandler implements PurchaseUpdatesResponseListener {
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final Map<RequestId, Pair<Function2<List<Receipt>, UserData, Unit>, Function1<PurchasesError, Unit>>> requests = new LinkedHashMap();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PurchaseUpdatesHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus[] r0 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r1 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler.WhenMappings.<clinit>():void");
        }
    }

    public PurchaseUpdatesHandler(PurchasingServiceProvider purchasingServiceProvider2) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider2, "purchasingServiceProvider");
        this.purchasingServiceProvider = purchasingServiceProvider2;
    }

    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        PurchaseUpdatesResponseListener.DefaultImpls.onProductDataResponse(this, productDataResponse);
    }

    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        PurchaseUpdatesResponseListener.DefaultImpls.onPurchaseResponse(this, purchaseResponse);
    }

    public void onUserDataResponse(UserDataResponse userDataResponse) {
        PurchaseUpdatesResponseListener.DefaultImpls.onUserDataResponse(this, userDataResponse);
    }

    public void queryPurchases(Function2<? super List<Receipt>, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        RequestId purchaseUpdates = this.purchasingServiceProvider.getPurchaseUpdates(true);
        synchronized (this) {
            this.requests.put(purchaseUpdates, TuplesKt.to(function2, function1));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        com.revenuecat.purchases.common.LogUtilsKt.errorLog("Exception in onPurchaseUpdatesResponse", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        throw r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPurchaseUpdatesResponse(com.amazon.device.iap.model.PurchaseUpdatesResponse r7) {
        /*
            r6 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.revenuecat.purchases.common.LogIntent r0 = com.revenuecat.purchases.common.LogIntent.DEBUG     // Catch:{ Exception -> 0x0082 }
            java.lang.String r1 = "Retrieved productData: %s"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0082 }
            r4 = 0
            r3[r4] = r7     // Catch:{ Exception -> 0x0082 }
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x0082 }
            com.revenuecat.purchases.common.LogWrapperKt.log(r0, r1)     // Catch:{ Exception -> 0x0082 }
            com.amazon.device.iap.model.RequestId r0 = r7.getRequestId()     // Catch:{ Exception -> 0x0082 }
            monitor-enter(r6)     // Catch:{ Exception -> 0x0082 }
            java.util.Map<com.amazon.device.iap.model.RequestId, kotlin.Pair<kotlin.jvm.functions.Function2<java.util.List<com.amazon.device.iap.model.Receipt>, com.amazon.device.iap.model.UserData, kotlin.Unit>, kotlin.jvm.functions.Function1<com.revenuecat.purchases.PurchasesError, kotlin.Unit>>> r1 = r6.requests     // Catch:{ all -> 0x007f }
            java.lang.Object r0 = r1.remove(r0)     // Catch:{ all -> 0x007f }
            kotlin.Pair r0 = (kotlin.Pair) r0     // Catch:{ all -> 0x007f }
            monitor-exit(r6)     // Catch:{ Exception -> 0x0082 }
            if (r0 == 0) goto L_0x007e
            java.lang.Object r1 = r0.component1()     // Catch:{ Exception -> 0x0082 }
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch:{ Exception -> 0x0082 }
            java.lang.Object r0 = r0.component2()     // Catch:{ Exception -> 0x0082 }
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch:{ Exception -> 0x0082 }
            com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r3 = r7.getRequestStatus()     // Catch:{ Exception -> 0x0082 }
            r4 = -1
            if (r3 != 0) goto L_0x0044
            r3 = r4
            goto L_0x004c
        L_0x0044:
            int[] r5 = com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler.WhenMappings.$EnumSwitchMapping$0     // Catch:{ Exception -> 0x0082 }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x0082 }
            r3 = r5[r3]     // Catch:{ Exception -> 0x0082 }
        L_0x004c:
            if (r3 == r4) goto L_0x0079
            if (r3 == r2) goto L_0x0063
            r7 = 2
            if (r3 == r7) goto L_0x005d
            r7 = 3
            if (r3 == r7) goto L_0x0057
            goto L_0x007e
        L_0x0057:
            java.lang.String r7 = "Failed to get purchase updates. Call is not supported."
            r6.invokeWithStoreProblem(r0, r7)     // Catch:{ Exception -> 0x0082 }
            goto L_0x007e
        L_0x005d:
            java.lang.String r7 = "Failed to get purchase updates."
            r6.invokeWithStoreProblem(r0, r7)     // Catch:{ Exception -> 0x0082 }
            goto L_0x007e
        L_0x0063:
            java.util.List r0 = r7.getReceipts()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r2 = "response.receipts"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x0082 }
            com.amazon.device.iap.model.UserData r7 = r7.getUserData()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r2 = "response.userData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ Exception -> 0x0082 }
            r1.invoke(r0, r7)     // Catch:{ Exception -> 0x0082 }
            goto L_0x007e
        L_0x0079:
            java.lang.String r7 = "Failed to get purchase updates. There was an Amazon store problem."
            r6.invokeWithStoreProblem(r0, r7)     // Catch:{ Exception -> 0x0082 }
        L_0x007e:
            return
        L_0x007f:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ Exception -> 0x0082 }
            throw r7     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            r7 = move-exception
            java.lang.String r0 = "Exception in onPurchaseUpdatesResponse"
            r1 = r7
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.revenuecat.purchases.common.LogUtilsKt.errorLog(r0, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler.onPurchaseUpdatesResponse(com.amazon.device.iap.model.PurchaseUpdatesResponse):void");
    }

    private final void invokeWithStoreProblem(Function1<? super PurchasesError, Unit> function1, String str) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, str));
    }
}
