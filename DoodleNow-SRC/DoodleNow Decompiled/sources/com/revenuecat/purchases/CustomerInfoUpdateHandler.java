package com.revenuecat.purchases;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "handler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/common/AppConfig;Landroid/os/Handler;)V", "lastSentCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "value", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "afterSetListener", "", "listener", "cacheAndNotifyListeners", "customerInfo", "dispatch", "action", "Lkotlin/Function0;", "getCachedCustomerInfo", "appUserID", "", "notifyListeners", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomerInfoUpdateHandler.kt */
public final class CustomerInfoUpdateHandler {
    private final AppConfig appConfig;
    private final DeviceCache deviceCache;
    private final Handler handler;
    private final IdentityManager identityManager;
    private CustomerInfo lastSentCustomerInfo;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private UpdatedCustomerInfoListener updatedCustomerInfoListener;

    public CustomerInfoUpdateHandler(DeviceCache deviceCache2, IdentityManager identityManager2, OfflineEntitlementsManager offlineEntitlementsManager2, AppConfig appConfig2, Handler handler2) {
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(identityManager2, "identityManager");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager2, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(handler2, "handler");
        this.deviceCache = deviceCache2;
        this.identityManager = identityManager2;
        this.offlineEntitlementsManager = offlineEntitlementsManager2;
        this.appConfig = appConfig2;
        this.handler = handler2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerInfoUpdateHandler(DeviceCache deviceCache2, IdentityManager identityManager2, OfflineEntitlementsManager offlineEntitlementsManager2, AppConfig appConfig2, Handler handler2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache2, identityManager2, offlineEntitlementsManager2, appConfig2, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler2);
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.updatedCustomerInfoListener;
    }

    public final void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener2) {
        synchronized (this) {
            this.updatedCustomerInfoListener = updatedCustomerInfoListener2;
            Unit unit = Unit.INSTANCE;
        }
        afterSetListener(updatedCustomerInfoListener2);
    }

    public final void cacheAndNotifyListeners(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        this.deviceCache.cacheCustomerInfo(this.identityManager.getCurrentAppUserID(), customerInfo);
        notifyListeners(customerInfo);
    }

    public final void notifyListeners(CustomerInfo customerInfo) {
        Pair pair;
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        synchronized (this) {
            pair = TuplesKt.to(this.updatedCustomerInfoListener, this.lastSentCustomerInfo);
        }
        UpdatedCustomerInfoListener updatedCustomerInfoListener2 = (UpdatedCustomerInfoListener) pair.component1();
        CustomerInfo customerInfo2 = (CustomerInfo) pair.component2();
        if (updatedCustomerInfoListener2 != null && !Intrinsics.areEqual((Object) customerInfo2, (Object) customerInfo)) {
            if (customerInfo2 != null) {
                LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.CUSTOMERINFO_UPDATED_NOTIFYING_LISTENER);
            } else {
                LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.SENDING_LATEST_CUSTOMERINFO_TO_LISTENER);
            }
            synchronized (this) {
                this.lastSentCustomerInfo = customerInfo;
                Unit unit = Unit.INSTANCE;
            }
            dispatch(new CustomerInfoUpdateHandler$notifyListeners$2$2(updatedCustomerInfoListener2, customerInfo));
        }
    }

    private final void afterSetListener(UpdatedCustomerInfoListener updatedCustomerInfoListener2) {
        CustomerInfo cachedCustomerInfo;
        if (updatedCustomerInfoListener2 != null) {
            LogWrapperKt.log(LogIntent.DEBUG, ConfigureStrings.LISTENER_SET);
            if (!this.appConfig.getCustomEntitlementComputation() && (cachedCustomerInfo = getCachedCustomerInfo(this.identityManager.getCurrentAppUserID())) != null) {
                notifyListeners(cachedCustomerInfo);
            }
        }
    }

    private final CustomerInfo getCachedCustomerInfo(String str) {
        CustomerInfo offlineCustomerInfo = this.offlineEntitlementsManager.getOfflineCustomerInfo();
        return offlineCustomerInfo == null ? this.deviceCache.getCachedCustomerInfo(str) : offlineCustomerInfo;
    }

    private final void dispatch(Function0<Unit> function0) {
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) this.handler.getLooper().getThread())) {
            this.handler.post(new CustomerInfoUpdateHandler$$ExternalSyntheticLambda0(function0));
        } else {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void dispatch$lambda$5(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }
}
