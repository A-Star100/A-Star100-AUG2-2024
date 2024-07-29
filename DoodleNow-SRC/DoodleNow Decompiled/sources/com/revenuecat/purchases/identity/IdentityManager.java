package com.revenuecat.purchases.identity;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J<\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00122\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00160#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160&J\u001c\u0010(\u001a\u00020\u00162\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\u00160&J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0012\u0010,\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010$H\u0002J\u000e\u0010.\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/identity/IdentityManager;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "offeringsCache", "Lcom/revenuecat/purchases/common/offerings/OfferingsCache;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/offerings/OfferingsCache;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;)V", "anonymousIdRegex", "Lkotlin/text/Regex;", "currentAppUserID", "", "getCurrentAppUserID", "()Ljava/lang/String;", "configure", "", "appUserID", "copySubscriberAttributesToNewUserIfOldIsAnonymous", "oldAppUserId", "newAppUserId", "currentUserIsAnonymous", "", "generateRandomID", "invalidateCustomerInfoAndETagCacheIfNeeded", "isUserIDAnonymous", "logIn", "newAppUserID", "onSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "logOut", "completion", "resetAndSaveUserID", "newUserID", "shouldInvalidateCustomerInfoAndETagCache", "customerInfo", "switchUser", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IdentityManager.kt */
public final class IdentityManager {
    private final Regex anonymousIdRegex = new Regex("^\\$RCAnonymousID:([a-f0-9]{32})$");
    /* access modifiers changed from: private */
    public final Backend backend;
    /* access modifiers changed from: private */
    public final DeviceCache deviceCache;
    /* access modifiers changed from: private */
    public final OfferingsCache offeringsCache;
    /* access modifiers changed from: private */
    public final OfflineEntitlementsManager offlineEntitlementsManager;
    /* access modifiers changed from: private */
    public final SubscriberAttributesCache subscriberAttributesCache;
    private final SubscriberAttributesManager subscriberAttributesManager;

    public IdentityManager(DeviceCache deviceCache2, SubscriberAttributesCache subscriberAttributesCache2, SubscriberAttributesManager subscriberAttributesManager2, OfferingsCache offeringsCache2, Backend backend2, OfflineEntitlementsManager offlineEntitlementsManager2) {
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesCache2, "subscriberAttributesCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager2, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offeringsCache2, "offeringsCache");
        Intrinsics.checkNotNullParameter(backend2, "backend");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager2, "offlineEntitlementsManager");
        this.deviceCache = deviceCache2;
        this.subscriberAttributesCache = subscriberAttributesCache2;
        this.subscriberAttributesManager = subscriberAttributesManager2;
        this.offeringsCache = offeringsCache2;
        this.backend = backend2;
        this.offlineEntitlementsManager = offlineEntitlementsManager2;
    }

    public final String getCurrentAppUserID() {
        String cachedAppUserID = this.deviceCache.getCachedAppUserID();
        return cachedAppUserID == null ? "" : cachedAppUserID;
    }

    public final synchronized void configure(String str) {
        if (str != null) {
            try {
                if (StringsKt.isBlank(str)) {
                    LogWrapperKt.log(LogIntent.WARNING, IdentityStrings.EMPTY_APP_USER_ID_WILL_BECOME_ANONYMOUS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                LogIntent logIntent = LogIntent.USER;
                String format = String.format(IdentityStrings.IDENTIFYING_APP_USER_ID, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(logIntent, format);
                this.deviceCache.cacheAppUserID(str);
                this.subscriberAttributesCache.cleanUpSubscriberAttributeCache(str);
                this.deviceCache.cleanupOldAttributionData();
                invalidateCustomerInfoAndETagCacheIfNeeded(str);
            }
        }
        str = this.deviceCache.getCachedAppUserID();
        if (str == null && (str = this.deviceCache.getLegacyCachedAppUserID()) == null) {
            str = generateRandomID();
        }
        LogIntent logIntent2 = LogIntent.USER;
        String format2 = String.format(IdentityStrings.IDENTIFYING_APP_USER_ID, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        LogWrapperKt.log(logIntent2, format2);
        this.deviceCache.cacheAppUserID(str);
        this.subscriberAttributesCache.cleanUpSubscriberAttributeCache(str);
        this.deviceCache.cleanupOldAttributionData();
        invalidateCustomerInfoAndETagCacheIfNeeded(str);
    }

    public final void logIn(String str, Function2<? super CustomerInfo, ? super Boolean, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "newAppUserID");
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        if (StringsKt.isBlank(str)) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.InvalidAppUserIdError, IdentityStrings.LOG_IN_ERROR_MISSING_APP_USER_ID);
            LogUtilsKt.errorLog(purchasesError);
            function1.invoke(purchasesError);
            return;
        }
        LogIntent logIntent = LogIntent.USER;
        String format = String.format(IdentityStrings.LOGGING_IN, Arrays.copyOf(new Object[]{getCurrentAppUserID(), str}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(str, new IdentityManager$logIn$2(this, getCurrentAppUserID(), str, function1, function2));
    }

    public final void switchUser(String str) {
        Intrinsics.checkNotNullParameter(str, "newAppUserID");
        String format = String.format(IdentityStrings.SWITCHING_USER, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.debugLog(format);
        resetAndSaveUserID(str);
    }

    public final synchronized void logOut(Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "completion");
        if (currentUserIsAnonymous()) {
            LogWrapperKt.log(LogIntent.RC_ERROR, IdentityStrings.LOG_OUT_CALLED_ON_ANONYMOUS_USER);
            function1.invoke(new PurchasesError(PurchasesErrorCode.LogOutWithAnonymousUserError, (String) null, 2, (DefaultConstructorMarker) null));
            return;
        }
        this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getCurrentAppUserID(), new IdentityManager$logOut$1(this, function1));
    }

    public final synchronized boolean currentUserIsAnonymous() {
        String cachedAppUserID;
        cachedAppUserID = this.deviceCache.getCachedAppUserID();
        if (cachedAppUserID == null) {
            cachedAppUserID = "";
        }
        return isUserIDAnonymous(cachedAppUserID) || Intrinsics.areEqual((Object) this.deviceCache.getCachedAppUserID(), (Object) this.deviceCache.getLegacyCachedAppUserID());
    }

    /* access modifiers changed from: private */
    public final void copySubscriberAttributesToNewUserIfOldIsAnonymous(String str, String str2) {
        if (isUserIDAnonymous(str)) {
            this.subscriberAttributesManager.copyUnsyncedSubscriberAttributes(str, str2);
        }
    }

    private final void invalidateCustomerInfoAndETagCacheIfNeeded(String str) {
        if (shouldInvalidateCustomerInfoAndETagCache(this.deviceCache.getCachedCustomerInfo(str))) {
            LogUtilsKt.infoLog(IdentityStrings.INVALIDATING_CACHED_CUSTOMER_INFO);
            this.deviceCache.clearCustomerInfoCache(str);
            this.backend.clearCaches();
        }
    }

    private final boolean shouldInvalidateCustomerInfoAndETagCache(CustomerInfo customerInfo) {
        return customerInfo != null && customerInfo.getEntitlements().getVerification() == VerificationResult.NOT_REQUESTED && !Intrinsics.areEqual((Object) this.backend.getVerificationMode(), (Object) SignatureVerificationMode.Disabled.INSTANCE);
    }

    private final boolean isUserIDAnonymous(String str) {
        return this.anonymousIdRegex.matches(str);
    }

    /* access modifiers changed from: private */
    public final String generateRandomID() {
        StringBuilder sb = new StringBuilder("$RCAnonymousID:");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = uuid.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String replace$default = StringsKt.replace$default(lowerCase, "-", "", false, 4, (Object) null);
        LogWrapperKt.log(LogIntent.USER, IdentityStrings.SETTING_NEW_ANON_ID);
        sb.append(replace$default);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final synchronized void resetAndSaveUserID(String str) {
        this.deviceCache.clearCachesForAppUserID(getCurrentAppUserID());
        this.offeringsCache.clearCache();
        this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
        this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
        this.deviceCache.cacheAppUserID(str);
        this.backend.clearCaches();
    }
}
