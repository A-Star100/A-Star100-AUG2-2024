package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ6\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00170\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u0017J\u0016\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fJ \u0010$\u001a\u00020\u00172\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8B@BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000RH\u0010\u0011\u001a<\u0012\u0004\u0012\u00020\u0013\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00170\u00160\u0015j\u0002`\u00190\u00140\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineCustomerInfoCalculator", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "(Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/AppConfig;)V", "<set-?>", "Lcom/revenuecat/purchases/CustomerInfo;", "_offlineCustomerInfo", "offlineCustomerInfo", "getOfflineCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "offlineCustomerInfoCallbackCache", "", "", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCallback;", "calculateAndCacheOfflineCustomerInfo", "appUserId", "onSuccess", "onError", "isOfflineEntitlementsEnabled", "", "resetOfflineCustomerInfoCache", "shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest", "isServerError", "shouldCalculateOfflineCustomerInfoInPostReceipt", "updateProductEntitlementMappingCacheIfStale", "completion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfflineEntitlementsManager.kt */
public final class OfflineEntitlementsManager {
    /* access modifiers changed from: private */
    public CustomerInfo _offlineCustomerInfo;
    private final AppConfig appConfig;
    private final Backend backend;
    /* access modifiers changed from: private */
    public final DeviceCache deviceCache;
    private final OfflineCustomerInfoCalculator offlineCustomerInfoCalculator;
    /* access modifiers changed from: private */
    public final Map<String, List<Pair<Function1<CustomerInfo, Unit>, Function1<PurchasesError, Unit>>>> offlineCustomerInfoCallbackCache = new LinkedHashMap();

    public final CustomerInfo getOfflineCustomerInfo() {
        return this._offlineCustomerInfo;
    }

    public OfflineEntitlementsManager(Backend backend2, OfflineCustomerInfoCalculator offlineCustomerInfoCalculator2, DeviceCache deviceCache2, AppConfig appConfig2) {
        Intrinsics.checkNotNullParameter(backend2, "backend");
        Intrinsics.checkNotNullParameter(offlineCustomerInfoCalculator2, "offlineCustomerInfoCalculator");
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        this.backend = backend2;
        this.offlineCustomerInfoCalculator = offlineCustomerInfoCalculator2;
        this.deviceCache = deviceCache2;
        this.appConfig = appConfig2;
    }

    public final synchronized void resetOfflineCustomerInfoCache() {
        if (this._offlineCustomerInfo != null) {
            LogUtilsKt.debugLog(OfflineEntitlementsStrings.RESETTING_OFFLINE_CUSTOMER_INFO_CACHE);
            this._offlineCustomerInfo = null;
        }
    }

    public final boolean shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "appUserId");
        return z && isOfflineEntitlementsEnabled() && this.deviceCache.getCachedCustomerInfo(str) == null;
    }

    public final boolean shouldCalculateOfflineCustomerInfoInPostReceipt(boolean z) {
        return z && isOfflineEntitlementsEnabled();
    }

    public final void calculateAndCacheOfflineCustomerInfo(String str, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserId");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        if (!this.appConfig.getEnableOfflineEntitlements()) {
            function12.invoke(new PurchasesError(PurchasesErrorCode.UnsupportedError, OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_NOT_ENABLED));
            return;
        }
        synchronized (this) {
            boolean containsKey = this.offlineCustomerInfoCallbackCache.containsKey(str);
            List list = this.offlineCustomerInfoCallbackCache.get(str);
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            this.offlineCustomerInfoCallbackCache.put(str, CollectionsKt.plus(list, CollectionsKt.listOf(TuplesKt.to(function1, function12))));
            if (containsKey) {
                String format = String.format(OfflineEntitlementsStrings.ALREADY_CALCULATING_OFFLINE_CUSTOMER_INFO, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.debugLog(format);
                return;
            }
            Unit unit = Unit.INSTANCE;
            this.offlineCustomerInfoCalculator.computeOfflineCustomerInfo(str, new OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$2(this, str), new OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$3(this, str));
        }
    }

    public static /* synthetic */ void updateProductEntitlementMappingCacheIfStale$default(OfflineEntitlementsManager offlineEntitlementsManager, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        offlineEntitlementsManager.updateProductEntitlementMappingCacheIfStale(function1);
    }

    public final void updateProductEntitlementMappingCacheIfStale(Function1<? super PurchasesError, Unit> function1) {
        if (isOfflineEntitlementsEnabled() && this.deviceCache.isProductEntitlementMappingCacheStale()) {
            LogUtilsKt.debugLog(OfflineEntitlementsStrings.UPDATING_PRODUCT_ENTITLEMENT_MAPPING);
            this.backend.getProductEntitlementMapping(new OfflineEntitlementsManager$updateProductEntitlementMappingCacheIfStale$1(this, function1), new OfflineEntitlementsManager$updateProductEntitlementMappingCacheIfStale$2(function1));
        } else if (function1 != null) {
            function1.invoke(null);
        }
    }

    private final boolean isOfflineEntitlementsEnabled() {
        return this.appConfig.getFinishTransactions() && this.appConfig.getEnableOfflineEntitlements() && !this.appConfig.getCustomEntitlementComputation();
    }
}
