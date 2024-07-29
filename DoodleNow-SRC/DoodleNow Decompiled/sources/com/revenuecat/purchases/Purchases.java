package com.revenuecat.purchases;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.ConfigureStrings;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0016\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u000e\u0010%\u001a\u00020#2\u0006\u0010(\u001a\u00020)J\u001e\u0010*\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0006\u0010(\u001a\u00020-H\u0007J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200J(\u00101\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\u0006\u0010(\u001a\u00020-J\u001c\u00101\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0006\u0010(\u001a\u00020-J\u001e\u00104\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0006\u0010(\u001a\u00020-H\u0007J\u0006\u00105\u001a\u00020#J\u001c\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u000108H\u0007J\u0014\u00109\u001a\u00020#2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0007J\b\u0010:\u001a\u00020#H\u0017J\b\u0010;\u001a\u00020#H\u0017J\u0016\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020>2\u0006\u0010(\u001a\u00020?J(\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010(\u001a\u00020GH\u0007J \u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010/\u001a\u00020?H\u0007J(\u0010H\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020F2\u0006\u0010/\u001a\u00020GH\u0007J \u0010H\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020J2\u0006\u0010(\u001a\u00020?H\u0007J\u0006\u0010K\u001a\u00020#J\u000e\u0010L\u001a\u00020#2\u0006\u0010(\u001a\u00020)J\u0010\u0010M\u001a\u00020#2\b\u0010N\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010O\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010Q\u001a\u00020#2\b\u0010R\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010S\u001a\u00020#2\b\u0010T\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010U\u001a\u00020#2\b\u0010V\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010W\u001a\u00020#2\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0YJ\u0010\u0010Z\u001a\u00020#2\b\u0010[\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\\\u001a\u00020#2\b\u0010]\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010^\u001a\u00020#2\b\u0010_\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010`\u001a\u00020#2\b\u0010a\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010b\u001a\u00020#2\b\u0010c\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010d\u001a\u00020#2\b\u0010e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010f\u001a\u00020#2\b\u0010g\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010h\u001a\u00020#2\b\u0010i\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010j\u001a\u00020#2\b\u0010k\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010l\u001a\u00020#2\b\u0010m\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010n\u001a\u00020#2\b\u0010o\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010p\u001a\u00020#2\b\u0010q\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010r\u001a\u00020#2\b\u0010s\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010t\u001a\u00020#2\b\u0010u\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010v\u001a\u00020#2\b\u0010w\u001a\u0004\u0018\u00010\u000fJ \u0010x\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u000e\b\u0002\u0010y\u001a\b\u0012\u0004\u0012\u00020z0,H\u0007J:\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000f2\b\u0010\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00020#2\u000b\b\u0002\u0010/\u001a\u0005\u0018\u00010\u0001H\u0007J\u0013\u0010\u0001\u001a\u00020#2\b\u0010\u0001\u001a\u00030\u0001H\u0007R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\u0001"}, d2 = {"Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "purchasesOrchestrator", "Lcom/revenuecat/purchases/PurchasesOrchestrator;", "(Lcom/revenuecat/purchases/PurchasesOrchestrator;)V", "value", "", "allowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount$annotations", "()V", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "appUserID", "", "getAppUserID", "()Ljava/lang/String;", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "isAnonymous", "getPurchasesOrchestrator$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesOrchestrator;", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "close", "", "collectDeviceIdentifiers", "getCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "callback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getNonSubscriptionSkus", "productIds", "", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getOfferings", "listener", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "getProducts", "type", "Lcom/revenuecat/purchases/ProductType;", "getSubscriptionSkus", "invalidateCustomerInfoCache", "logIn", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logOut", "onAppBackgrounded", "onAppForegrounded", "purchase", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "purchasePackage", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "upgradeInfo", "Lcom/revenuecat/purchases/UpgradeInfo;", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "purchaseProduct", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "removeUpdatedCustomerInfoListener", "restorePurchases", "setAd", "ad", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirshipChannelID", "airshipChannelID", "setAppsflyerID", "appsflyerID", "setAttributes", "attributes", "", "setCampaign", "campaign", "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "email", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setOnesignalUserID", "onesignalUserID", "setPhoneNumber", "phoneNumber", "setPushToken", "fcmToken", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "syncObserverModeAmazonPurchase", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", "price", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "syncPurchases", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "track", "paywallEvent", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Purchases.kt */
public final class Purchases implements LifecycleDelegate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static /* synthetic */ Purchases backingFieldSharedInstance;
    /* access modifiers changed from: private */
    public static final String frameworkVersion = "7.6.0";
    private final PurchasesOrchestrator purchasesOrchestrator;

    @JvmStatic
    public static final void canMakePayments(Context context, Callback<Boolean> callback) {
        Companion.canMakePayments(context, callback);
    }

    @JvmStatic
    public static final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
        Companion.canMakePayments(context, list, callback);
    }

    @JvmStatic
    public static final Purchases configure(PurchasesConfiguration purchasesConfiguration) {
        return Companion.configure(purchasesConfiguration);
    }

    @Deprecated(message = "Replaced with configuration in the RevenueCat dashboard", replaceWith = @ReplaceWith(expression = "configure through the RevenueCat dashboard", imports = {}))
    public static /* synthetic */ void getAllowSharingPlayStoreAccount$annotations() {
    }

    public static final boolean getDebugLogsEnabled() {
        return Companion.getDebugLogsEnabled();
    }

    public static final String getFrameworkVersion() {
        return Companion.getFrameworkVersion();
    }

    public static final synchronized LogHandler getLogHandler() {
        LogHandler logHandler;
        synchronized (Purchases.class) {
            logHandler = Companion.getLogHandler();
        }
        return logHandler;
    }

    public static final LogLevel getLogLevel() {
        return Companion.getLogLevel();
    }

    public static final PlatformInfo getPlatformInfo() {
        return Companion.getPlatformInfo();
    }

    public static final URL getProxyURL() {
        return Companion.getProxyURL();
    }

    public static final Purchases getSharedInstance() {
        return Companion.getSharedInstance();
    }

    public static final boolean isConfigured() {
        return Companion.isConfigured();
    }

    public static final void setDebugLogsEnabled(boolean z) {
        Companion.setDebugLogsEnabled(z);
    }

    public static final synchronized void setLogHandler(LogHandler logHandler) {
        synchronized (Purchases.class) {
            Companion.setLogHandler(logHandler);
        }
    }

    public static final void setLogLevel(LogLevel logLevel) {
        Companion.setLogLevel(logLevel);
    }

    public static final void setPlatformInfo(PlatformInfo platformInfo) {
        Companion.setPlatformInfo(platformInfo);
    }

    public static final void setProxyURL(URL url) {
        Companion.setProxyURL(url);
    }

    public static final void setSharedInstance$purchases_defaultsRelease(Purchases purchases) {
        Companion.setSharedInstance$purchases_defaultsRelease(purchases);
    }

    public final /* synthetic */ PurchasesOrchestrator getPurchasesOrchestrator$purchases_defaultsRelease() {
        return this.purchasesOrchestrator;
    }

    public final void logIn(String str) {
        Intrinsics.checkNotNullParameter(str, "newAppUserID");
        logIn$default(this, str, (LogInCallback) null, 2, (Object) null);
    }

    public final void logOut() {
        logOut$default(this, (ReceiveCustomerInfoCallback) null, 1, (Object) null);
    }

    public final void showInAppMessagesIfNeeded(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showInAppMessagesIfNeeded$default(this, activity, (List) null, 2, (Object) null);
    }

    public final void syncPurchases() {
        syncPurchases$default(this, (SyncPurchasesCallback) null, 1, (Object) null);
    }

    public Purchases(PurchasesOrchestrator purchasesOrchestrator2) {
        Intrinsics.checkNotNullParameter(purchasesOrchestrator2, "purchasesOrchestrator");
        this.purchasesOrchestrator = purchasesOrchestrator2;
    }

    public final synchronized boolean getFinishTransactions() {
        return this.purchasesOrchestrator.getFinishTransactions();
    }

    public final synchronized void setFinishTransactions(boolean z) {
        this.purchasesOrchestrator.setFinishTransactions(z);
    }

    public final synchronized String getAppUserID() {
        return this.purchasesOrchestrator.getAppUserID();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.purchasesOrchestrator.getUpdatedCustomerInfoListener();
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.purchasesOrchestrator.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final boolean isAnonymous() {
        return this.purchasesOrchestrator.isAnonymous();
    }

    public final Store getStore() {
        return this.purchasesOrchestrator.getStore();
    }

    @Deprecated(message = "Will be removed in next major. Logic has been moved to PurchasesOrchestrator")
    public void onAppBackgrounded() {
        this.purchasesOrchestrator.onAppBackgrounded();
    }

    @Deprecated(message = "Will be removed in next major. Logic has been moved to PurchasesOrchestrator")
    public void onAppForegrounded() {
        this.purchasesOrchestrator.onAppForegrounded();
    }

    public static /* synthetic */ void syncPurchases$default(Purchases purchases, SyncPurchasesCallback syncPurchasesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchases.syncPurchases(syncPurchasesCallback);
    }

    public final void syncPurchases(SyncPurchasesCallback syncPurchasesCallback) {
        this.purchasesOrchestrator.syncPurchases(syncPurchasesCallback);
    }

    public final void syncObserverModeAmazonPurchase(String str, String str2, String str3, String str4, Double d) {
        Intrinsics.checkNotNullParameter(str, "productID");
        Intrinsics.checkNotNullParameter(str2, "receiptID");
        Intrinsics.checkNotNullParameter(str3, "amazonUserID");
        this.purchasesOrchestrator.syncObserverModeAmazonPurchase(str, str2, str3, str4, d);
    }

    public final void getOfferings(ReceiveOfferingsCallback receiveOfferingsCallback) {
        Intrinsics.checkNotNullParameter(receiveOfferingsCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.purchasesOrchestrator.getOfferings(receiveOfferingsCallback);
    }

    public final void getProducts(List<String> list, GetStoreProductsCallback getStoreProductsCallback) {
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(getStoreProductsCallback, "callback");
        getProducts(list, (ProductType) null, getStoreProductsCallback);
    }

    public static /* synthetic */ void getProducts$default(Purchases purchases, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        purchases.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void getProducts(List<String> list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback) {
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(getStoreProductsCallback, "callback");
        this.purchasesOrchestrator.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback purchaseCallback) {
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(purchaseCallback, "callback");
        this.purchasesOrchestrator.purchase(purchaseParams, purchaseCallback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, UpgradeInfo upgradeInfo, ProductChangeCallback productChangeCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        Intrinsics.checkNotNullParameter(productChangeCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        PurchasesOrchestrator purchasesOrchestrator2 = this.purchasesOrchestrator;
        PurchasingData purchasingData = storeProduct.getPurchasingData();
        String oldSku = upgradeInfo.getOldSku();
        GoogleProrationMode fromPlayBillingClientMode = GoogleProrationMode.CREATOR.fromPlayBillingClientMode(upgradeInfo.getProrationMode());
        purchasesOrchestrator2.startDeprecatedProductChange(activity, purchasingData, (PresentedOfferingContext) null, oldSku, fromPlayBillingClientMode != null ? fromPlayBillingClientMode.getAsGoogleReplacementMode$purchases_defaultsRelease() : null, productChangeCallback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, PurchaseCallback purchaseCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(purchaseCallback, "callback");
        this.purchasesOrchestrator.startPurchase(activity, storeProduct.getPurchasingData(), (PresentedOfferingContext) null, (Boolean) null, purchaseCallback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchasePackage(Activity activity, Package packageR, UpgradeInfo upgradeInfo, ProductChangeCallback productChangeCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageR, "packageToPurchase");
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        Intrinsics.checkNotNullParameter(productChangeCallback, "callback");
        PurchasesOrchestrator purchasesOrchestrator2 = this.purchasesOrchestrator;
        PurchasingData purchasingData = packageR.getProduct().getPurchasingData();
        PresentedOfferingContext presentedOfferingContext = packageR.getPresentedOfferingContext();
        String oldSku = upgradeInfo.getOldSku();
        GoogleProrationMode fromPlayBillingClientMode = GoogleProrationMode.CREATOR.fromPlayBillingClientMode(upgradeInfo.getProrationMode());
        purchasesOrchestrator2.startDeprecatedProductChange(activity, purchasingData, presentedOfferingContext, oldSku, fromPlayBillingClientMode != null ? fromPlayBillingClientMode.getAsGoogleReplacementMode$purchases_defaultsRelease() : null, productChangeCallback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchasePackage(Activity activity, Package packageR, PurchaseCallback purchaseCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageR, "packageToPurchase");
        Intrinsics.checkNotNullParameter(purchaseCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.purchasesOrchestrator.startPurchase(activity, packageR.getProduct().getPurchasingData(), packageR.getPresentedOfferingContext(), (Boolean) null, purchaseCallback);
    }

    public final void restorePurchases(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(receiveCustomerInfoCallback, "callback");
        this.purchasesOrchestrator.restorePurchases(receiveCustomerInfoCallback);
    }

    public static /* synthetic */ void logIn$default(Purchases purchases, String str, LogInCallback logInCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            logInCallback = null;
        }
        purchases.logIn(str, logInCallback);
    }

    public final void logIn(String str, LogInCallback logInCallback) {
        Intrinsics.checkNotNullParameter(str, "newAppUserID");
        this.purchasesOrchestrator.logIn(str, logInCallback);
    }

    public static /* synthetic */ void logOut$default(Purchases purchases, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchases.logOut(receiveCustomerInfoCallback);
    }

    public final void logOut(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        this.purchasesOrchestrator.logOut(receiveCustomerInfoCallback);
    }

    public final void close() {
        this.purchasesOrchestrator.close();
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(receiveCustomerInfoCallback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(CacheFetchPolicy.Companion.m1086default(), receiveCustomerInfoCallback);
    }

    public final void getCustomerInfo(CacheFetchPolicy cacheFetchPolicy, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(cacheFetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(receiveCustomerInfoCallback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(cacheFetchPolicy, receiveCustomerInfoCallback);
    }

    public final void removeUpdatedCustomerInfoListener() {
        this.purchasesOrchestrator.removeUpdatedCustomerInfoListener();
    }

    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Purchases purchases, Activity activity, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.listOf(InAppMessageType.BILLING_ISSUES);
        }
        purchases.showInAppMessagesIfNeeded(activity, list);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "inAppMessageTypes");
        this.purchasesOrchestrator.showInAppMessagesIfNeeded(activity, list);
    }

    public final void invalidateCustomerInfoCache() {
        this.purchasesOrchestrator.invalidateCustomerInfoCache();
    }

    public final /* synthetic */ void track(PaywallEvent paywallEvent) {
        Intrinsics.checkNotNullParameter(paywallEvent, "paywallEvent");
        this.purchasesOrchestrator.track(paywallEvent);
    }

    public final void setAttributes(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "attributes");
        this.purchasesOrchestrator.setAttributes(map);
    }

    public final void setEmail(String str) {
        this.purchasesOrchestrator.setEmail(str);
    }

    public final void setPhoneNumber(String str) {
        this.purchasesOrchestrator.setPhoneNumber(str);
    }

    public final void setDisplayName(String str) {
        this.purchasesOrchestrator.setDisplayName(str);
    }

    public final void setPushToken(String str) {
        this.purchasesOrchestrator.setPushToken(str);
    }

    public final void setMixpanelDistinctID(String str) {
        this.purchasesOrchestrator.setMixpanelDistinctID(str);
    }

    public final void setOnesignalID(String str) {
        this.purchasesOrchestrator.setOnesignalID(str);
    }

    public final void setOnesignalUserID(String str) {
        this.purchasesOrchestrator.setOnesignalUserID(str);
    }

    public final void setAirshipChannelID(String str) {
        this.purchasesOrchestrator.setAirshipChannelID(str);
    }

    public final void setFirebaseAppInstanceID(String str) {
        this.purchasesOrchestrator.setFirebaseAppInstanceID(str);
    }

    public final void collectDeviceIdentifiers() {
        this.purchasesOrchestrator.collectDeviceIdentifiers();
    }

    public final void setAdjustID(String str) {
        this.purchasesOrchestrator.setAdjustID(str);
    }

    public final void setAppsflyerID(String str) {
        this.purchasesOrchestrator.setAppsflyerID(str);
    }

    public final void setFBAnonymousID(String str) {
        this.purchasesOrchestrator.setFBAnonymousID(str);
    }

    public final void setMparticleID(String str) {
        this.purchasesOrchestrator.setMparticleID(str);
    }

    public final void setCleverTapID(String str) {
        this.purchasesOrchestrator.setCleverTapID(str);
    }

    public final void setMediaSource(String str) {
        this.purchasesOrchestrator.setMediaSource(str);
    }

    public final void setCampaign(String str) {
        this.purchasesOrchestrator.setCampaign(str);
    }

    public final void setAdGroup(String str) {
        this.purchasesOrchestrator.setAdGroup(str);
    }

    public final void setAd(String str) {
        this.purchasesOrchestrator.setAd(str);
    }

    public final void setKeyword(String str) {
        this.purchasesOrchestrator.setKeyword(str);
    }

    public final void setCreative(String str) {
        this.purchasesOrchestrator.setCreative(str);
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        return this.purchasesOrchestrator.getAllowSharingPlayStoreAccount();
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z) {
        this.purchasesOrchestrator.setAllowSharingPlayStoreAccount(z);
    }

    @Deprecated(message = "Replaced with getProducts() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProducts()", imports = {}))
    public final void getSubscriptionSkus(List<String> list, GetStoreProductsCallback getStoreProductsCallback) {
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(getStoreProductsCallback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(list), SetsKt.setOf(ProductType.SUBS), getStoreProductsCallback);
    }

    @Deprecated(message = "Replaced with getProducts() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProducts()", imports = {}))
    public final void getNonSubscriptionSkus(List<String> list, GetStoreProductsCallback getStoreProductsCallback) {
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(getStoreProductsCallback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(list), SetsKt.setOf(ProductType.INAPP), getStoreProductsCallback);
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0@H\u0007J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00128\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\n8FX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0016\u0010\u000eR*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188F@FX\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8F@FX\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010'\u001a\u00020&2\u0006\u0010\t\u001a\u00020&8F@FX\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\t\u001a\u0004\u0018\u00010-8F@FX\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\u0002\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00104\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@AX\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u0002\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\b¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/Purchases$Companion;", "", "()V", "backingFieldSharedInstance", "Lcom/revenuecat/purchases/Purchases;", "getBackingFieldSharedInstance$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/Purchases;", "setBackingFieldSharedInstance$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/Purchases;)V", "value", "", "debugLogsEnabled", "getDebugLogsEnabled$annotations", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "frameworkVersion", "", "getFrameworkVersion$annotations", "getFrameworkVersion", "()Ljava/lang/String;", "isConfigured", "isConfigured$annotations", "Lcom/revenuecat/purchases/LogHandler;", "logHandler", "getLogHandler$annotations", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "getLogLevel$annotations", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "Lcom/revenuecat/purchases/common/PlatformInfo;", "platformInfo", "getPlatformInfo$annotations", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "Ljava/net/URL;", "proxyURL", "getProxyURL$annotations", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "sharedInstance", "getSharedInstance$annotations", "getSharedInstance", "setSharedInstance$purchases_defaultsRelease", "canMakePayments", "", "context", "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "callback", "Lcom/revenuecat/purchases/interfaces/Callback;", "configure", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Purchases.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Deprecated(message = "Use logLevel instead")
        public static /* synthetic */ void getDebugLogsEnabled$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getFrameworkVersion$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogHandler$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogLevel$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getPlatformInfo$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProxyURL$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getSharedInstance$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isConfigured$annotations() {
        }

        @JvmStatic
        public final void canMakePayments(Context context, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            canMakePayments$default(this, context, (List) null, callback, 2, (Object) null);
        }

        private Companion() {
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.Companion.getPlatformInfo();
        }

        public final void setPlatformInfo(PlatformInfo platformInfo) {
            Intrinsics.checkNotNullParameter(platformInfo, "value");
            PurchasesOrchestrator.Companion.setPlatformInfo(platformInfo);
        }

        public final boolean getDebugLogsEnabled() {
            return PurchasesOrchestrator.Companion.getDebugLogsEnabled();
        }

        public final void setDebugLogsEnabled(boolean z) {
            PurchasesOrchestrator.Companion.setDebugLogsEnabled(z);
        }

        public final LogLevel getLogLevel() {
            return PurchasesOrchestrator.Companion.getLogLevel();
        }

        public final void setLogLevel(LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "value");
            PurchasesOrchestrator.Companion.setLogLevel(logLevel);
        }

        public final synchronized LogHandler getLogHandler() {
            return PurchasesOrchestrator.Companion.getLogHandler();
        }

        public final synchronized void setLogHandler(LogHandler logHandler) {
            Intrinsics.checkNotNullParameter(logHandler, "value");
            PurchasesOrchestrator.Companion.setLogHandler(logHandler);
        }

        public final Purchases getBackingFieldSharedInstance$purchases_defaultsRelease() {
            return Purchases.backingFieldSharedInstance;
        }

        public final void setBackingFieldSharedInstance$purchases_defaultsRelease(Purchases purchases) {
            Purchases.backingFieldSharedInstance = purchases;
        }

        public final Purchases getSharedInstance() {
            Purchases backingFieldSharedInstance$purchases_defaultsRelease = getBackingFieldSharedInstance$purchases_defaultsRelease();
            if (backingFieldSharedInstance$purchases_defaultsRelease != null) {
                return backingFieldSharedInstance$purchases_defaultsRelease;
            }
            throw new UninitializedPropertyAccessException(ConfigureStrings.NO_SINGLETON_INSTANCE);
        }

        public final void setSharedInstance$purchases_defaultsRelease(Purchases purchases) {
            Intrinsics.checkNotNullParameter(purchases, "value");
            Purchases backingFieldSharedInstance$purchases_defaultsRelease = getBackingFieldSharedInstance$purchases_defaultsRelease();
            if (backingFieldSharedInstance$purchases_defaultsRelease != null) {
                backingFieldSharedInstance$purchases_defaultsRelease.close();
            }
            setBackingFieldSharedInstance$purchases_defaultsRelease(purchases);
        }

        public final String getFrameworkVersion() {
            return Purchases.frameworkVersion;
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.Companion.getProxyURL();
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.Companion.setProxyURL(url);
        }

        public final boolean isConfigured() {
            return getBackingFieldSharedInstance$purchases_defaultsRelease() != null;
        }

        @JvmStatic
        public final Purchases configure(PurchasesConfiguration purchasesConfiguration) {
            Intrinsics.checkNotNullParameter(purchasesConfiguration, "configuration");
            if (isConfigured()) {
                LogUtilsKt.infoLog(ConfigureStrings.INSTANCE_ALREADY_EXISTS);
            }
            Purchases createPurchases$default = PurchasesFactory.createPurchases$default(new PurchasesFactory((APIKeyValidator) null, 1, (DefaultConstructorMarker) null), purchasesConfiguration, getPlatformInfo(), getProxyURL(), (BillingAbstract) null, false, false, false, 120, (Object) null);
            Purchases.Companion.setSharedInstance$purchases_defaultsRelease(createPurchases$default);
            return createPurchases$default;
        }

        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        @JvmStatic
        public final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (getSharedInstance().getPurchasesOrchestrator$purchases_defaultsRelease().getAppConfig().getStore() != Store.PLAY_STORE) {
                LogWrapperKt.log(LogIntent.RC_ERROR, BillingStrings.CANNOT_CALL_CAN_MAKE_PAYMENTS);
                callback.onReceived(true);
                return;
            }
            PurchasesOrchestrator.Companion.canMakePayments(context, list, callback);
        }
    }
}
