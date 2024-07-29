package com.revenuecat.purchases;

import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J8\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00180\u001cH\u0002J\u0001\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020(2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2B\u0010\u001e\u001a>\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00180)j\u0002`0H\u0002Jj\u00101\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020(2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00180\u001cJx\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\"\b\u0002\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0018\u0018\u000107j\u0004\u0018\u0001`82\"\b\u0002\u0010\u001e\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0018\u0018\u000107j\u0004\u0018\u0001`9J:\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180<H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/revenuecat/purchases/PostReceiptHelper;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "paywallPresentedCache", "Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;)V", "finishTransactions", "", "getFinishTransactions", "()Z", "calculateOfflineCustomerInfo", "", "appUserID", "", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "postReceiptAndSubscriberAttributes", "purchaseToken", "isRestore", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "storeUserID", "marketplace", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "Lkotlin/ParameterName;", "name", "postReceiptErrorHandlingBehavior", "Lorg/json/JSONObject;", "body", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "postTokenWithoutConsuming", "postTransactionAndConsumeIfNeeded", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "useOfflineEntitlementsCustomerInfoIfNeeded", "errorHandlingBehavior", "Lkotlin/Function0;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostReceiptHelper.kt */
public final class PostReceiptHelper {
    private final AppConfig appConfig;
    /* access modifiers changed from: private */
    public final Backend backend;
    /* access modifiers changed from: private */
    public final BillingAbstract billing;
    /* access modifiers changed from: private */
    public final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    /* access modifiers changed from: private */
    public final DeviceCache deviceCache;
    /* access modifiers changed from: private */
    public final OfflineEntitlementsManager offlineEntitlementsManager;
    /* access modifiers changed from: private */
    public final PaywallPresentedCache paywallPresentedCache;
    /* access modifiers changed from: private */
    public final SubscriberAttributesManager subscriberAttributesManager;

    public PostReceiptHelper(AppConfig appConfig2, Backend backend2, BillingAbstract billingAbstract, CustomerInfoUpdateHandler customerInfoUpdateHandler2, DeviceCache deviceCache2, SubscriberAttributesManager subscriberAttributesManager2, OfflineEntitlementsManager offlineEntitlementsManager2, PaywallPresentedCache paywallPresentedCache2) {
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(backend2, "backend");
        Intrinsics.checkNotNullParameter(billingAbstract, "billing");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler2, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager2, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager2, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache2, "paywallPresentedCache");
        this.appConfig = appConfig2;
        this.backend = backend2;
        this.billing = billingAbstract;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler2;
        this.deviceCache = deviceCache2;
        this.subscriberAttributesManager = subscriberAttributesManager2;
        this.offlineEntitlementsManager = offlineEntitlementsManager2;
        this.paywallPresentedCache = paywallPresentedCache2;
    }

    /* access modifiers changed from: private */
    public final boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    public final void postTokenWithoutConsuming(String str, String str2, ReceiptInfo receiptInfo, boolean z, String str3, String str4, PostReceiptInitiationSource postReceiptInitiationSource, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        String str5 = str;
        Function1<? super CustomerInfo, Unit> function13 = function1;
        Intrinsics.checkNotNullParameter(str, "purchaseToken");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(str3, "appUserID");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(function13, "onSuccess");
        Function1<? super PurchasesError, Unit> function14 = function12;
        Intrinsics.checkNotNullParameter(function14, "onError");
        String str6 = str;
        postReceiptAndSubscriberAttributes(str3, str6, z, receiptInfo, str2, str4, postReceiptInitiationSource, new PostReceiptHelper$postTokenWithoutConsuming$1(this, str, function13), new PostReceiptHelper$postTokenWithoutConsuming$2(this, str6, str3, function13, function14));
    }

    public static /* synthetic */ void postTransactionAndConsumeIfNeeded$default(PostReceiptHelper postReceiptHelper, StoreTransaction storeTransaction, StoreProduct storeProduct, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, Function2 function2, Function2 function22, int i, Object obj) {
        postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, storeProduct, z, str, postReceiptInitiationSource, (i & 32) != 0 ? null : function2, (i & 64) != 0 ? null : function22);
    }

    public final void postTransactionAndConsumeIfNeeded(StoreTransaction storeTransaction, StoreProduct storeProduct, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, Function2<? super StoreTransaction, ? super PurchasesError, Unit> function22) {
        StoreTransaction storeTransaction2 = storeTransaction;
        PostReceiptInitiationSource postReceiptInitiationSource2 = postReceiptInitiationSource;
        Intrinsics.checkNotNullParameter(storeTransaction2, "purchase");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource2, "initiationSource");
        ReceiptInfo receiptInfo = new ReceiptInfo(storeTransaction.getProductIds(), storeTransaction.getPresentedOfferingContext(), storeTransaction.getSubscriptionOptionId(), storeProduct, (Double) null, (String) null, storeTransaction.getReplacementMode(), 48, (DefaultConstructorMarker) null);
        Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function23 = function2;
        postReceiptAndSubscriberAttributes(str, storeTransaction.getPurchaseToken(), z, receiptInfo, storeTransaction.getStoreUserID(), storeTransaction.getMarketplace(), postReceiptInitiationSource2, new PostReceiptHelper$postTransactionAndConsumeIfNeeded$1(this, storeTransaction2, postReceiptInitiationSource2, function23), new PostReceiptHelper$postTransactionAndConsumeIfNeeded$2(this, storeTransaction2, postReceiptInitiationSource, str, function23, function22));
    }

    private final void postReceiptAndSubscriberAttributes(String str, String str2, boolean z, ReceiptInfo receiptInfo, String str3, String str4, PostReceiptInitiationSource postReceiptInitiationSource, Function1<? super CustomerInfo, Unit> function1, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> function3) {
        PaywallEvent andRemovePresentedEvent = this.paywallPresentedCache.getAndRemovePresentedEvent();
        this.subscriberAttributesManager.getUnsyncedSubscriberAttributes(str, new PostReceiptHelper$postReceiptAndSubscriberAttributes$1(this, str2, str, z, receiptInfo, str3, str4, postReceiptInitiationSource, andRemovePresentedEvent, function1, function3));
    }

    /* access modifiers changed from: private */
    public final void useOfflineEntitlementsCustomerInfoIfNeeded(PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, String str, Function1<? super CustomerInfo, Unit> function1, Function0<Unit> function0) {
        if (this.offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInPostReceipt(postReceiptErrorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME)) {
            calculateOfflineCustomerInfo(str, function1, new PostReceiptHelper$useOfflineEntitlementsCustomerInfoIfNeeded$1(function0));
        } else {
            function0.invoke();
        }
    }

    private final void calculateOfflineCustomerInfo(String str, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        this.offlineEntitlementsManager.calculateAndCacheOfflineCustomerInfo(str, new PostReceiptHelper$calculateOfflineCustomerInfo$1(this, function1), new PostReceiptHelper$calculateOfflineCustomerInfo$2(function12));
    }
}
