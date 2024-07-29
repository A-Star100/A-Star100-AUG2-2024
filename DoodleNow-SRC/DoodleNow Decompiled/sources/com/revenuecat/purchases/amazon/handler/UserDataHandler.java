package com.revenuecat.purchases.amazon.handler;

import android.os.Handler;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.utils.DefaultTimestampProvider;
import com.revenuecat.purchases.utils.TimestampProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 $2\u00020\u0001:\u0002$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J4\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001aj\u0002`\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J$\u0010!\u001a\u00020\u0014*\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001aj\u0002`\u001d2\u0006\u0010\"\u001a\u00020#H\u0002R \u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8BX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00118B@BX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/UserDataHandler;", "Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "mainHandler", "Landroid/os/Handler;", "timestampProvider", "Lcom/revenuecat/purchases/utils/TimestampProvider;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Landroid/os/Handler;Lcom/revenuecat/purchases/utils/TimestampProvider;)V", "<set-?>", "", "lastUserDataRequestTimestamp", "Ljava/lang/Long;", "requests", "", "Lcom/amazon/device/iap/model/RequestId;", "Lcom/revenuecat/purchases/amazon/handler/UserDataHandler$Request;", "Lcom/amazon/device/iap/model/UserData;", "userDataCache", "addTimeoutToUserDataRequest", "", "requestId", "getCachedUserDataIfAvailable", "getRequest", "getUserData", "onSuccess", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onUserDataResponse", "response", "Lcom/amazon/device/iap/model/UserDataResponse;", "invokeWithStoreProblem", "message", "", "Companion", "Request", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserDataHandler.kt */
public final class UserDataHandler implements UserDataResponseListener {
    private static final long CACHE_EXPIRATION_TIME_MILLIS = 300000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long GET_USER_DATA_TIMEOUT_MILLIS = 10000;
    private Long lastUserDataRequestTimestamp;
    private final Handler mainHandler;
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final Map<RequestId, Request> requests;
    private final TimestampProvider timestampProvider;
    private UserData userDataCache;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UserDataHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.amazon.device.iap.model.UserDataResponse$RequestStatus[] r0 = com.amazon.device.iap.model.UserDataResponse.RequestStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.amazon.device.iap.model.UserDataResponse$RequestStatus r1 = com.amazon.device.iap.model.UserDataResponse.RequestStatus.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.amazon.device.iap.model.UserDataResponse$RequestStatus r1 = com.amazon.device.iap.model.UserDataResponse.RequestStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.amazon.device.iap.model.UserDataResponse$RequestStatus r1 = com.amazon.device.iap.model.UserDataResponse.RequestStatus.NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.UserDataHandler.WhenMappings.<clinit>():void");
        }
    }

    public UserDataHandler(PurchasingServiceProvider purchasingServiceProvider2, Handler handler, TimestampProvider timestampProvider2) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider2, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        Intrinsics.checkNotNullParameter(timestampProvider2, "timestampProvider");
        this.purchasingServiceProvider = purchasingServiceProvider2;
        this.mainHandler = handler;
        this.timestampProvider = timestampProvider2;
        this.requests = new LinkedHashMap();
    }

    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        UserDataResponseListener.DefaultImpls.onProductDataResponse(this, productDataResponse);
    }

    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        UserDataResponseListener.DefaultImpls.onPurchaseResponse(this, purchaseResponse);
    }

    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        UserDataResponseListener.DefaultImpls.onPurchaseUpdatesResponse(this, purchaseUpdatesResponse);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserDataHandler(PurchasingServiceProvider purchasingServiceProvider2, Handler handler, TimestampProvider timestampProvider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasingServiceProvider2, handler, (i & 4) != 0 ? new DefaultTimestampProvider() : timestampProvider2);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/UserDataHandler$Companion;", "", "()V", "CACHE_EXPIRATION_TIME_MILLIS", "", "GET_USER_DATA_TIMEOUT_MILLIS", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UserDataHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\b¢\u0006\u0002\u0010\tJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\bHÆ\u0003J9\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\bHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/UserDataHandler$Request;", "", "onReceive", "Lkotlin/Function1;", "Lcom/amazon/device/iap/model/UserData;", "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UserDataHandler.kt */
    private static final class Request {
        private final Function1<PurchasesError, Unit> onError;
        private final Function1<UserData, Unit> onReceive;

        public static /* synthetic */ Request copy$default(Request request, Function1<UserData, Unit> function1, Function1<PurchasesError, Unit> function12, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = request.onReceive;
            }
            if ((i & 2) != 0) {
                function12 = request.onError;
            }
            return request.copy(function1, function12);
        }

        public final Function1<UserData, Unit> component1() {
            return this.onReceive;
        }

        public final Function1<PurchasesError, Unit> component2() {
            return this.onError;
        }

        public final Request copy(Function1<? super UserData, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
            Intrinsics.checkNotNullParameter(function1, "onReceive");
            Intrinsics.checkNotNullParameter(function12, "onError");
            return new Request(function1, function12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.onReceive, (Object) request.onReceive) && Intrinsics.areEqual((Object) this.onError, (Object) request.onError);
        }

        public final Function1<PurchasesError, Unit> getOnError() {
            return this.onError;
        }

        public final Function1<UserData, Unit> getOnReceive() {
            return this.onReceive;
        }

        public int hashCode() {
            return (this.onReceive.hashCode() * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "Request(onReceive=" + this.onReceive + ", onError=" + this.onError + ')';
        }

        public Request(Function1<? super UserData, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
            Intrinsics.checkNotNullParameter(function1, "onReceive");
            Intrinsics.checkNotNullParameter(function12, "onError");
            this.onReceive = function1;
            this.onError = function12;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0097, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        com.revenuecat.purchases.common.LogUtilsKt.errorLog("Exception in onUserDataResponse", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a0, code lost:
        throw r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUserDataResponse(com.amazon.device.iap.model.UserDataResponse r7) {
        /*
            r6 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.revenuecat.purchases.common.LogIntent r0 = com.revenuecat.purchases.common.LogIntent.DEBUG     // Catch:{ Exception -> 0x0097 }
            java.lang.String r1 = "User data request finished with result %s"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0097 }
            com.amazon.device.iap.model.UserDataResponse$RequestStatus r4 = r7.getRequestStatus()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x0097 }
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x0097 }
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x0097 }
            com.revenuecat.purchases.common.LogWrapperKt.log(r0, r1)     // Catch:{ Exception -> 0x0097 }
            com.amazon.device.iap.model.RequestId r0 = r7.getRequestId()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r1 = "response.requestId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0097 }
            com.revenuecat.purchases.amazon.handler.UserDataHandler$Request r0 = r6.getRequest(r0)     // Catch:{ Exception -> 0x0097 }
            if (r0 != 0) goto L_0x0037
            return
        L_0x0037:
            com.amazon.device.iap.model.UserDataResponse$RequestStatus r1 = r7.getRequestStatus()     // Catch:{ Exception -> 0x0097 }
            if (r1 != 0) goto L_0x003f
            r1 = -1
            goto L_0x0047
        L_0x003f:
            int[] r3 = com.revenuecat.purchases.amazon.handler.UserDataHandler.WhenMappings.$EnumSwitchMapping$0     // Catch:{ Exception -> 0x0097 }
            int r1 = r1.ordinal()     // Catch:{ Exception -> 0x0097 }
            r1 = r3[r1]     // Catch:{ Exception -> 0x0097 }
        L_0x0047:
            if (r1 == r2) goto L_0x006d
            r7 = 2
            if (r1 == r7) goto L_0x0063
            r7 = 3
            if (r1 == r7) goto L_0x0059
            kotlin.jvm.functions.Function1 r7 = r0.getOnError()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r0 = "Failed to get user data. There was an Amazon store problem."
            r6.invokeWithStoreProblem(r7, r0)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0093
        L_0x0059:
            kotlin.jvm.functions.Function1 r7 = r0.getOnError()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r0 = "Failed to get user data. Call is not supported."
            r6.invokeWithStoreProblem(r7, r0)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0093
        L_0x0063:
            kotlin.jvm.functions.Function1 r7 = r0.getOnError()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r0 = "Failed to get user data. Make sure sandbox mode is enabled if using App Tester. https://rev.cat/enter-amazon-sandbox"
            r6.invokeWithStoreProblem(r7, r0)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0093
        L_0x006d:
            monitor-enter(r6)     // Catch:{ Exception -> 0x0097 }
            com.revenuecat.purchases.utils.TimestampProvider r1 = r6.timestampProvider     // Catch:{ all -> 0x0094 }
            long r1 = r1.getCurrentTimeMillis()     // Catch:{ all -> 0x0094 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0094 }
            r6.lastUserDataRequestTimestamp = r1     // Catch:{ all -> 0x0094 }
            com.amazon.device.iap.model.UserData r1 = r7.getUserData()     // Catch:{ all -> 0x0094 }
            r6.userDataCache = r1     // Catch:{ all -> 0x0094 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0094 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x0097 }
            kotlin.jvm.functions.Function1 r0 = r0.getOnReceive()     // Catch:{ Exception -> 0x0097 }
            com.amazon.device.iap.model.UserData r7 = r7.getUserData()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r1 = "response.userData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch:{ Exception -> 0x0097 }
            r0.invoke(r7)     // Catch:{ Exception -> 0x0097 }
        L_0x0093:
            return
        L_0x0094:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ Exception -> 0x0097 }
            throw r7     // Catch:{ Exception -> 0x0097 }
        L_0x0097:
            r7 = move-exception
            java.lang.String r0 = "Exception in onUserDataResponse"
            r1 = r7
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.revenuecat.purchases.common.LogUtilsKt.errorLog(r0, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.UserDataHandler.onUserDataResponse(com.amazon.device.iap.model.UserDataResponse):void");
    }

    public void getUserData(Function1<? super UserData, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        UserData cachedUserDataIfAvailable = getCachedUserDataIfAvailable();
        if (cachedUserDataIfAvailable != null) {
            LogWrapperKt.log(LogIntent.DEBUG, AmazonStrings.USER_DATA_REQUEST_FROM_CACHE);
            function1.invoke(cachedUserDataIfAvailable);
            return;
        }
        RequestId userData = this.purchasingServiceProvider.getUserData();
        Request request = new Request(function1, function12);
        synchronized (this) {
            this.requests.put(userData, request);
            addTimeoutToUserDataRequest(userData);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized com.amazon.device.iap.model.UserData getCachedUserDataIfAvailable() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.amazon.device.iap.model.UserData r0 = r5.userDataCache     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x001f
            java.lang.Long r1 = r5.lastUserDataRequestTimestamp     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x001f
            java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ all -> 0x0022 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x0022 }
            com.revenuecat.purchases.utils.TimestampProvider r3 = r5.timestampProvider     // Catch:{ all -> 0x0022 }
            long r3 = r3.getCurrentTimeMillis()     // Catch:{ all -> 0x0022 }
            long r3 = r3 - r1
            r1 = 300000(0x493e0, double:1.482197E-318)
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x001f
            monitor-exit(r5)
            return r0
        L_0x001f:
            monitor-exit(r5)
            r0 = 0
            return r0
        L_0x0022:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.handler.UserDataHandler.getCachedUserDataIfAvailable():com.amazon.device.iap.model.UserData");
    }

    private final void invokeWithStoreProblem(Function1<? super PurchasesError, Unit> function1, String str) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, str));
    }

    private final void addTimeoutToUserDataRequest(RequestId requestId) {
        this.mainHandler.postDelayed(new UserDataHandler$$ExternalSyntheticLambda0(this, requestId), 10000);
    }

    /* access modifiers changed from: private */
    public static final void addTimeoutToUserDataRequest$lambda$5(UserDataHandler userDataHandler, RequestId requestId) {
        Intrinsics.checkNotNullParameter(userDataHandler, "this$0");
        Intrinsics.checkNotNullParameter(requestId, "$requestId");
        Request request = userDataHandler.getRequest(requestId);
        if (request != null) {
            request.getOnError().invoke(new PurchasesError(PurchasesErrorCode.UnknownError, AmazonStrings.ERROR_TIMEOUT_GETTING_USER_DATA));
        }
    }

    private final synchronized Request getRequest(RequestId requestId) {
        return this.requests.remove(requestId);
    }
}
