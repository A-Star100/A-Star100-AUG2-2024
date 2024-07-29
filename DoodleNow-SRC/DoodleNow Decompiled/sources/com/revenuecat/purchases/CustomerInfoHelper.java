package com.revenuecat.purchases;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010 \u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J2\u0010!\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019J \u0010$\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/CustomerInfoHelper;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "postPendingTransactionsHelper", "Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "handler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/PostPendingTransactionsHelper;Landroid/os/Handler;)V", "dispatch", "", "action", "Lkotlin/Function0;", "getCachedCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "appUserID", "", "getCustomerInfoCacheOnly", "callback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getCustomerInfoCachedOrFetched", "appInBackground", "", "allowSharingPlayStoreAccount", "getCustomerInfoFetchOnly", "getCustomerInfoNotStaledCachedOrFetched", "postPendingPurchasesAndFetchCustomerInfo", "retrieveCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "updateCachedCustomerInfoIfStale", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomerInfoHelper.kt */
public final class CustomerInfoHelper {
    private final Backend backend;
    /* access modifiers changed from: private */
    public final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    /* access modifiers changed from: private */
    public final DeviceCache deviceCache;
    private final Handler handler;
    /* access modifiers changed from: private */
    public final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PostPendingTransactionsHelper postPendingTransactionsHelper;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CustomerInfoHelper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.revenuecat.purchases.CacheFetchPolicy[] r0 = com.revenuecat.purchases.CacheFetchPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.CacheFetchPolicy r1 = com.revenuecat.purchases.CacheFetchPolicy.CACHE_ONLY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.CacheFetchPolicy r1 = com.revenuecat.purchases.CacheFetchPolicy.FETCH_CURRENT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.CacheFetchPolicy r1 = com.revenuecat.purchases.CacheFetchPolicy.CACHED_OR_FETCHED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.revenuecat.purchases.CacheFetchPolicy r1 = com.revenuecat.purchases.CacheFetchPolicy.NOT_STALE_CACHED_OR_CURRENT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CustomerInfoHelper.WhenMappings.<clinit>():void");
        }
    }

    public CustomerInfoHelper(DeviceCache deviceCache2, Backend backend2, OfflineEntitlementsManager offlineEntitlementsManager2, CustomerInfoUpdateHandler customerInfoUpdateHandler2, PostPendingTransactionsHelper postPendingTransactionsHelper2, Handler handler2) {
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(backend2, "backend");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager2, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler2, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper2, "postPendingTransactionsHelper");
        Intrinsics.checkNotNullParameter(handler2, "handler");
        this.deviceCache = deviceCache2;
        this.backend = backend2;
        this.offlineEntitlementsManager = offlineEntitlementsManager2;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler2;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper2;
        this.handler = handler2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerInfoHelper(DeviceCache deviceCache2, Backend backend2, OfflineEntitlementsManager offlineEntitlementsManager2, CustomerInfoUpdateHandler customerInfoUpdateHandler2, PostPendingTransactionsHelper postPendingTransactionsHelper2, Handler handler2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache2, backend2, offlineEntitlementsManager2, customerInfoUpdateHandler2, postPendingTransactionsHelper2, (i & 32) != 0 ? new Handler(Looper.getMainLooper()) : handler2);
    }

    public static /* synthetic */ void retrieveCustomerInfo$default(CustomerInfoHelper customerInfoHelper, String str, CacheFetchPolicy cacheFetchPolicy, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 16) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.retrieveCustomerInfo(str, cacheFetchPolicy, z, z2, receiveCustomerInfoCallback);
    }

    public final void retrieveCustomerInfo(String str, CacheFetchPolicy cacheFetchPolicy, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(cacheFetchPolicy, "fetchPolicy");
        String format = String.format(CustomerInfoStrings.RETRIEVING_CUSTOMER_INFO, Arrays.copyOf(new Object[]{cacheFetchPolicy}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.debugLog(format);
        int i = WhenMappings.$EnumSwitchMapping$0[cacheFetchPolicy.ordinal()];
        if (i == 1) {
            getCustomerInfoCacheOnly(str, receiveCustomerInfoCallback);
        } else if (i == 2) {
            postPendingPurchasesAndFetchCustomerInfo(str, z, z2, receiveCustomerInfoCallback);
        } else if (i == 3) {
            getCustomerInfoCachedOrFetched(str, z, z2, receiveCustomerInfoCallback);
        } else if (i == 4) {
            getCustomerInfoNotStaledCachedOrFetched(str, z, z2, receiveCustomerInfoCallback);
        }
    }

    static /* synthetic */ void getCustomerInfoCacheOnly$default(CustomerInfoHelper customerInfoHelper, String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoCacheOnly(str, receiveCustomerInfoCallback);
    }

    private final void getCustomerInfoCacheOnly(String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        if (receiveCustomerInfoCallback != null) {
            CustomerInfo cachedCustomerInfo = getCachedCustomerInfo(str);
            if (cachedCustomerInfo != null) {
                LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.VENDING_CACHE);
                dispatch(new CustomerInfoHelper$getCustomerInfoCacheOnly$1(receiveCustomerInfoCallback, cachedCustomerInfo));
                return;
            }
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.CustomerInfoError, CustomerInfoStrings.MISSING_CACHED_CUSTOMER_INFO);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(new CustomerInfoHelper$getCustomerInfoCacheOnly$2(receiveCustomerInfoCallback, purchasesError));
        }
    }

    static /* synthetic */ void postPendingPurchasesAndFetchCustomerInfo$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.postPendingPurchasesAndFetchCustomerInfo(str, z, z2, receiveCustomerInfoCallback);
    }

    private final void postPendingPurchasesAndFetchCustomerInfo(String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        this.postPendingTransactionsHelper.syncPendingPurchaseQueue(z2, new CustomerInfoHelper$postPendingPurchasesAndFetchCustomerInfo$1(this, str, z, receiveCustomerInfoCallback), new CustomerInfoHelper$postPendingPurchasesAndFetchCustomerInfo$2(this, str, z, receiveCustomerInfoCallback));
    }

    static /* synthetic */ void getCustomerInfoFetchOnly$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoFetchOnly(str, z, receiveCustomerInfoCallback);
    }

    /* access modifiers changed from: private */
    public final void getCustomerInfoFetchOnly(String str, boolean z, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        this.deviceCache.setCustomerInfoCacheTimestampToNow(str);
        this.backend.getCustomerInfo(str, z, new CustomerInfoHelper$getCustomerInfoFetchOnly$1(this, receiveCustomerInfoCallback), new CustomerInfoHelper$getCustomerInfoFetchOnly$2(this, str, receiveCustomerInfoCallback));
    }

    static /* synthetic */ void getCustomerInfoCachedOrFetched$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoCachedOrFetched(str, z, z2, receiveCustomerInfoCallback);
    }

    private final void getCustomerInfoCachedOrFetched(String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        CustomerInfo cachedCustomerInfo = getCachedCustomerInfo(str);
        if (cachedCustomerInfo != null) {
            LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.VENDING_CACHE);
            dispatch(new CustomerInfoHelper$getCustomerInfoCachedOrFetched$1(receiveCustomerInfoCallback, cachedCustomerInfo));
            updateCachedCustomerInfoIfStale(str, z, z2);
            return;
        }
        LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.NO_CACHED_CUSTOMERINFO);
        postPendingPurchasesAndFetchCustomerInfo(str, z, z2, receiveCustomerInfoCallback);
    }

    static /* synthetic */ void getCustomerInfoNotStaledCachedOrFetched$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoNotStaledCachedOrFetched(str, z, z2, receiveCustomerInfoCallback);
    }

    private final void getCustomerInfoNotStaledCachedOrFetched(String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        if (this.deviceCache.isCustomerInfoCacheStale(str, z)) {
            postPendingPurchasesAndFetchCustomerInfo(str, z, z2, receiveCustomerInfoCallback);
        } else {
            getCustomerInfoCachedOrFetched(str, z, z2, receiveCustomerInfoCallback);
        }
    }

    private final CustomerInfo getCachedCustomerInfo(String str) {
        CustomerInfo offlineCustomerInfo = this.offlineEntitlementsManager.getOfflineCustomerInfo();
        return offlineCustomerInfo == null ? this.deviceCache.getCachedCustomerInfo(str) : offlineCustomerInfo;
    }

    private final void updateCachedCustomerInfoIfStale(String str, boolean z, boolean z2) {
        if (this.deviceCache.isCustomerInfoCacheStale(str, z)) {
            LogWrapperKt.log(LogIntent.DEBUG, z ? CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_BACKGROUND : CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_FOREGROUND);
            postPendingPurchasesAndFetchCustomerInfo$default(this, str, z, z2, (ReceiveCustomerInfoCallback) null, 8, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void dispatch(Function0<Unit> function0) {
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) this.handler.getLooper().getThread())) {
            this.handler.post(new CustomerInfoHelper$$ExternalSyntheticLambda0(function0));
        } else {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void dispatch$lambda$0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }
}
