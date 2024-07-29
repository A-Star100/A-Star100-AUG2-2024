package com.revenuecat.purchases;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Process;
import android.preference.PreferenceManager;
import com.revenuecat.purchases.common.Anonymizer;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.HTTPClient;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.InMemoryCachedObject;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsAnonymizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsFileHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offerings.OfferingsFactory;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.verification.SignatureVerifier;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEventsManager;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CoilImageDownloader;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001'B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JJ\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001dJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\f\u0010\"\u001a\u00020#*\u00020\u000bH\u0002J\u0014\u0010$\u001a\u00020\u001d*\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/PurchasesFactory;", "", "apiKeyValidator", "Lcom/revenuecat/purchases/APIKeyValidator;", "(Lcom/revenuecat/purchases/APIKeyValidator;)V", "createDefaultExecutor", "Ljava/util/concurrent/ExecutorService;", "createEventsExecutor", "createPaywallEventsManager", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;", "context", "Landroid/content/Context;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "eventsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "createPurchases", "Lcom/revenuecat/purchases/Purchases;", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "Ljava/net/URL;", "overrideBillingAbstract", "Lcom/revenuecat/purchases/common/BillingAbstract;", "forceServerErrors", "", "forceSigningError", "runningIntegrationTests", "validateConfiguration", "", "getApplication", "Landroid/app/Application;", "hasPermission", "permission", "", "LowPriorityThreadFactory", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesFactory.kt */
public final class PurchasesFactory {
    private final APIKeyValidator apiKeyValidator;

    public PurchasesFactory() {
        this((APIKeyValidator) null, 1, (DefaultConstructorMarker) null);
    }

    public PurchasesFactory(APIKeyValidator aPIKeyValidator) {
        Intrinsics.checkNotNullParameter(aPIKeyValidator, "apiKeyValidator");
        this.apiKeyValidator = aPIKeyValidator;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PurchasesFactory(APIKeyValidator aPIKeyValidator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new APIKeyValidator() : aPIKeyValidator);
    }

    public static /* synthetic */ Purchases createPurchases$default(PurchasesFactory purchasesFactory, PurchasesConfiguration purchasesConfiguration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, boolean z, boolean z2, boolean z3, int i, Object obj) {
        return purchasesFactory.createPurchases(purchasesConfiguration, platformInfo, url, (i & 8) != 0 ? null : billingAbstract, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? false : z3);
    }

    public final Purchases createPurchases(PurchasesConfiguration purchasesConfiguration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, boolean z, boolean z2, boolean z3) {
        DiagnosticsTracker diagnosticsTracker;
        DiagnosticsFileHelper diagnosticsFileHelper;
        PurchasesStateCache purchasesStateCache;
        BillingAbstract billingAbstract2;
        Intrinsics.checkNotNullParameter(purchasesConfiguration, "configuration");
        PlatformInfo platformInfo2 = platformInfo;
        Intrinsics.checkNotNullParameter(platformInfo2, "platformInfo");
        validateConfiguration(purchasesConfiguration);
        Application application = getApplication(purchasesConfiguration.getContext());
        AppConfig appConfig = new AppConfig(purchasesConfiguration.getContext(), purchasesConfiguration.getObserverMode(), purchasesConfiguration.getShowInAppMessagesAutomatically(), platformInfo2, url, purchasesConfiguration.getStore(), purchasesConfiguration.getDangerousSettings(), z3, z, z2);
        Context context = application;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        ETagManager eTagManager = new ETagManager(purchasesConfiguration.getContext(), (Lazy) null, (DateProvider) null, 6, (DefaultConstructorMarker) null);
        Dispatcher dispatcher = new Dispatcher(createDefaultExecutor(), (Handler) null, z3, 2, (DefaultConstructorMarker) null);
        ExecutorService service = purchasesConfiguration.getService();
        if (service == null) {
            service = createDefaultExecutor();
        }
        Dispatcher dispatcher2 = new Dispatcher(service, (Handler) null, z3, 2, (DefaultConstructorMarker) null);
        Dispatcher dispatcher3 = new Dispatcher(createEventsExecutor(), (Handler) null, z3, 2, (DefaultConstructorMarker) null);
        if (!purchasesConfiguration.getDiagnosticsEnabled() || !AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            if (purchasesConfiguration.getDiagnosticsEnabled()) {
                LogUtilsKt.warnLog("Diagnostics are only supported on Android N or newer.");
            }
            diagnosticsFileHelper = null;
            diagnosticsTracker = null;
        } else {
            DiagnosticsFileHelper diagnosticsFileHelper2 = new DiagnosticsFileHelper(new FileHelper(purchasesConfiguration.getContext()));
            diagnosticsFileHelper = diagnosticsFileHelper2;
            diagnosticsTracker = new DiagnosticsTracker(appConfig, diagnosticsFileHelper2, new DiagnosticsAnonymizer(new Anonymizer()), dispatcher3);
        }
        SigningManager signingManager = new SigningManager(SignatureVerificationMode.Companion.fromEntitlementVerificationMode$default(SignatureVerificationMode.Companion, purchasesConfiguration.getVerificationMode(), (SignatureVerifier) null, 2, (Object) null), appConfig, purchasesConfiguration.getApiKey());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "prefs");
        DeviceCache deviceCache = r3;
        DeviceCache deviceCache2 = new DeviceCache(defaultSharedPreferences, purchasesConfiguration.getApiKey(), (DateProvider) null, 4, (DefaultConstructorMarker) null);
        AppConfig appConfig2 = appConfig;
        Dispatcher dispatcher4 = dispatcher3;
        Dispatcher dispatcher5 = dispatcher;
        DeviceCache deviceCache3 = deviceCache;
        HTTPClient hTTPClient = new HTTPClient(appConfig2, eTagManager, diagnosticsTracker, signingManager, deviceCache, (DateProvider) null, (MapConverter) null, 96, (DefaultConstructorMarker) null);
        BackendHelper backendHelper = new BackendHelper(purchasesConfiguration.getApiKey(), dispatcher2, appConfig, hTTPClient);
        Backend backend = new Backend(appConfig2, dispatcher2, dispatcher4, hTTPClient, backendHelper);
        PurchasesStateCache purchasesStateCache2 = new PurchasesStateCache(new PurchasesState((Boolean) null, (Map) null, (ProductChangeCallback) null, false, false, 31, (DefaultConstructorMarker) null));
        if (billingAbstract == null) {
            purchasesStateCache = purchasesStateCache2;
            billingAbstract2 = BillingFactory.INSTANCE.createBilling(purchasesConfiguration.getStore(), application, backendHelper, deviceCache3, purchasesConfiguration.getObserverMode(), diagnosticsTracker, purchasesStateCache2);
        } else {
            purchasesStateCache = purchasesStateCache2;
            billingAbstract2 = billingAbstract;
        }
        SubscriberAttributesPoster subscriberAttributesPoster = new SubscriberAttributesPoster(backendHelper);
        DeviceIdentifiersFetcher createAttributionFetcher = AttributionFetcherFactory.INSTANCE.createAttributionFetcher(purchasesConfiguration.getStore(), dispatcher2);
        DeviceCache deviceCache4 = deviceCache3;
        SubscriberAttributesCache subscriberAttributesCache = new SubscriberAttributesCache(deviceCache4);
        SubscriberAttributesManager subscriberAttributesManager = new SubscriberAttributesManager(subscriberAttributesCache, subscriberAttributesPoster, createAttributionFetcher);
        OfflineEntitlementsManager offlineEntitlementsManager = new OfflineEntitlementsManager(backend, new OfflineCustomerInfoCalculator(new PurchasedProductsFetcher(deviceCache4, billingAbstract2, (DateProvider) null, 4, (DefaultConstructorMarker) null), appConfig, (DateProvider) null, 4, (DefaultConstructorMarker) null), deviceCache4, appConfig);
        OfferingsCache offeringsCache = new OfferingsCache(deviceCache4, (DateProvider) null, (InMemoryCachedObject) null, 6, (DefaultConstructorMarker) null);
        IdentityManager identityManager = new IdentityManager(deviceCache4, subscriberAttributesCache, subscriberAttributesManager, offeringsCache, backend, offlineEntitlementsManager);
        IdentityManager identityManager2 = identityManager;
        OfflineEntitlementsManager offlineEntitlementsManager2 = offlineEntitlementsManager;
        SubscriberAttributesManager subscriberAttributesManager2 = subscriberAttributesManager;
        BillingAbstract billingAbstract3 = billingAbstract2;
        CustomerInfoUpdateHandler customerInfoUpdateHandler = new CustomerInfoUpdateHandler(deviceCache4, identityManager, offlineEntitlementsManager, appConfig, (Handler) null, 16, (DefaultConstructorMarker) null);
        PaywallPresentedCache paywallPresentedCache = new PaywallPresentedCache();
        AppConfig appConfig3 = appConfig;
        Application application2 = application;
        PostReceiptHelper postReceiptHelper = r3;
        DeviceCache deviceCache5 = deviceCache4;
        PostReceiptHelper postReceiptHelper2 = new PostReceiptHelper(appConfig3, backend, billingAbstract3, customerInfoUpdateHandler, deviceCache4, subscriberAttributesManager2, offlineEntitlementsManager2, paywallPresentedCache);
        BillingAbstract billingAbstract4 = billingAbstract3;
        PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper = new PostTransactionWithProductDetailsHelper(billingAbstract4, postReceiptHelper);
        PostPendingTransactionsHelper postPendingTransactionsHelper = new PostPendingTransactionsHelper(appConfig3, deviceCache5, billingAbstract4, dispatcher2, identityManager2, postTransactionWithProductDetailsHelper);
        CustomerInfoHelper customerInfoHelper = new CustomerInfoHelper(deviceCache5, backend, offlineEntitlementsManager2, customerInfoUpdateHandler, postPendingTransactionsHelper, (Handler) null, 32, (DefaultConstructorMarker) null);
        OfferingParser createOfferingParser = OfferingParserFactory.INSTANCE.createOfferingParser(purchasesConfiguration.getStore());
        DiagnosticsSynchronizer diagnosticsSynchronizer = (diagnosticsFileHelper == null || diagnosticsTracker == null || !AndroidVersionUtilsKt.isAndroidNOrNewer()) ? null : new DiagnosticsSynchronizer(purchasesConfiguration.getContext(), diagnosticsFileHelper, diagnosticsTracker, backend, dispatcher4, (Lazy) null, 32, (DefaultConstructorMarker) null);
        SyncPurchasesHelper syncPurchasesHelper = r4;
        IdentityManager identityManager3 = identityManager2;
        SyncPurchasesHelper syncPurchasesHelper2 = new SyncPurchasesHelper(billingAbstract4, identityManager3, customerInfoHelper, postReceiptHelper);
        OfferingsManager offeringsManager = r21;
        OfferingsManager offeringsManager2 = new OfferingsManager(offeringsCache, backend, new OfferingsFactory(billingAbstract4, createOfferingParser, dispatcher5), new OfferingImagePreDownloader(false, new CoilImageDownloader(context), 1, (DefaultConstructorMarker) null), (Handler) null, 16, (DefaultConstructorMarker) null);
        LogWrapperKt.log(LogIntent.DEBUG, ConfigureStrings.DEBUG_ENABLED);
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(ConfigureStrings.SDK_VERSION, Arrays.copyOf(new Object[]{Purchases.Companion.getFrameworkVersion()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        LogIntent logIntent2 = LogIntent.DEBUG;
        String format2 = String.format(ConfigureStrings.PACKAGE_NAME, Arrays.copyOf(new Object[]{appConfig.getPackageName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        LogWrapperKt.log(logIntent2, format2);
        LogIntent logIntent3 = LogIntent.USER;
        String format3 = String.format(ConfigureStrings.INITIAL_APP_USER_ID, Arrays.copyOf(new Object[]{purchasesConfiguration.getAppUserID()}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
        LogWrapperKt.log(logIntent3, format3);
        LogIntent logIntent4 = LogIntent.DEBUG;
        String format4 = String.format(ConfigureStrings.VERIFICATION_MODE_SELECTED, Arrays.copyOf(new Object[]{purchasesConfiguration.getVerificationMode().name()}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
        LogWrapperKt.log(logIntent4, format4);
        return new Purchases(new PurchasesOrchestrator(application2, purchasesConfiguration.getAppUserID(), backend, billingAbstract4, deviceCache5, identityManager3, subscriberAttributesManager2, appConfig, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer, offlineEntitlementsManager2, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, createPaywallEventsManager(context, identityManager3, dispatcher4, backend), paywallPresentedCache, purchasesStateCache, (Handler) null, 1048576, (DefaultConstructorMarker) null));
    }

    private final PaywallEventsManager createPaywallEventsManager(Context context, IdentityManager identityManager, Dispatcher dispatcher, Backend backend) {
        if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            return new PaywallEventsManager(new EventsFileHelper(new FileHelper(context), PaywallEventsManager.PAYWALL_EVENTS_FILE_PATH, new PurchasesFactory$createPaywallEventsManager$1(PaywallStoredEvent.Companion)), identityManager, dispatcher, backend);
        }
        LogUtilsKt.debugLog("Paywall events are only supported on Android N or newer.");
        return null;
    }

    public final void validateConfiguration(PurchasesConfiguration purchasesConfiguration) {
        Intrinsics.checkNotNullParameter(purchasesConfiguration, "configuration");
        if (!hasPermission(purchasesConfiguration.getContext(), "android.permission.INTERNET")) {
            throw new IllegalArgumentException("Purchases requires INTERNET permission.".toString());
        } else if (!(!StringsKt.isBlank(purchasesConfiguration.getApiKey()))) {
            throw new IllegalArgumentException("API key must be set. Get this from the RevenueCat web app".toString());
        } else if (purchasesConfiguration.getContext().getApplicationContext() instanceof Application) {
            this.apiKeyValidator.validateAndLog(purchasesConfiguration.getApiKey(), purchasesConfiguration.getStore());
        } else {
            throw new IllegalArgumentException("Needs an application context.".toString());
        }
    }

    private final Application getApplication(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    private final boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    private final ExecutorService createDefaultExecutor() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        return newSingleThreadScheduledExecutor;
    }

    private final ExecutorService createEventsExecutor() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new LowPriorityThreadFactory("revenuecat-events-thread"));
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduled…venuecat-events-thread\"))");
        return newSingleThreadScheduledExecutor;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/PurchasesFactory$LowPriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadName", "", "(Ljava/lang/String;)V", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PurchasesFactory.kt */
    private static final class LowPriorityThreadFactory implements ThreadFactory {
        private final String threadName;

        public LowPriorityThreadFactory(String str) {
            Intrinsics.checkNotNullParameter(str, "threadName");
            this.threadName = str;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(new PurchasesFactory$LowPriorityThreadFactory$$ExternalSyntheticLambda0(runnable), this.threadName);
        }

        /* access modifiers changed from: private */
        public static final void newThread$lambda$1(Runnable runnable) {
            if (runnable != null) {
                Process.setThreadPriority(19);
                runnable.run();
            }
        }
    }
}
