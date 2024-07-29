package com.revenuecat.purchases.common.caching;

import android.content.SharedPreferences;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.strings.ReceiptStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000 f2\u00020\u0001:\u0001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u0016\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205J\u0014\u00106\u001a\u00020)2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000508J\u0006\u00109\u001a\u00020)J\u000e\u0010:\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020)J\u000e\u0010>\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0005082\u0006\u0010A\u001a\u00020\u0005J \u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020D0EJ\b\u0010F\u001a\u0004\u0018\u00010\u0005J\u0010\u0010G\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020\u0005J\u0010\u0010H\u001a\u00020I2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0012\u0010J\u001a\u0004\u0018\u0001022\u0006\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u0004\u0018\u00010\u0005J\b\u0010M\u001a\u0004\u0018\u000102J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000508J\b\u0010O\u001a\u0004\u0018\u000105J\n\u0010P\u001a\u0004\u0018\u00010IH\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010R\u001a\u00020S2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010T\u001a\u00020SJ\u0006\u0010U\u001a\u00020SJ\u000e\u0010V\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0005J\u0018\u0010W\u001a\u00020)2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005H\u0016J\u000e\u0010Y\u001a\u00020)2\u0006\u0010A\u001a\u00020\u0005J\u0016\u0010Z\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010[\u001a\u00020IJ\u000e\u0010\\\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u0010\u0010]\u001a\u00020)2\u0006\u0010[\u001a\u00020IH\u0002J\u0006\u0010^\u001a\u00020)J\u0016\u0010_\u001a\u00020)2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000508H\u0002J\u000e\u0010a\u001a\u00020)2\u0006\u0010b\u001a\u00020\u0005J\f\u0010c\u001a\u00020d*\u00020dH\u0002J\f\u0010e\u001a\u00020d*\u00020dH\u0002J\u0014\u0010<\u001a\u00020d*\u00020d2\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001b\u0010\u0013\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0017\u0010\u000bR\u001b\u0010\u0019\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001a\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001d\u0010\u000bR\u001b\u0010\u001f\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b \u0010\u000bR\u001b\u0010\"\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b#\u0010\u000bR\u001b\u0010%\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b&\u0010\u000b¨\u0006g"}, d2 = {"Lcom/revenuecat/purchases/common/caching/DeviceCache;", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "preferences", "Landroid/content/SharedPreferences;", "apiKey", "", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;)V", "apiKeyPrefix", "getApiKeyPrefix", "()Ljava/lang/String;", "apiKeyPrefix$delegate", "Lkotlin/Lazy;", "appUserIDCacheKey", "getAppUserIDCacheKey", "appUserIDCacheKey$delegate", "attributionCacheKey", "getAttributionCacheKey$purchases_defaultsRelease", "customerInfoCachesLastUpdatedCacheBaseKey", "getCustomerInfoCachesLastUpdatedCacheBaseKey", "customerInfoCachesLastUpdatedCacheBaseKey$delegate", "legacyAppUserIDCacheKey", "getLegacyAppUserIDCacheKey", "legacyAppUserIDCacheKey$delegate", "offeringsResponseCacheKey", "getOfferingsResponseCacheKey", "offeringsResponseCacheKey$delegate", "productEntitlementMappingCacheKey", "getProductEntitlementMappingCacheKey", "productEntitlementMappingCacheKey$delegate", "productEntitlementMappingLastUpdatedCacheKey", "getProductEntitlementMappingLastUpdatedCacheKey", "productEntitlementMappingLastUpdatedCacheKey$delegate", "storefrontCacheKey", "getStorefrontCacheKey", "storefrontCacheKey$delegate", "tokensCacheKey", "getTokensCacheKey", "tokensCacheKey$delegate", "addSuccessfullyPostedToken", "", "token", "cacheAppUserID", "appUserID", "cacheCustomerInfo", "info", "Lcom/revenuecat/purchases/CustomerInfo;", "cacheOfferingsResponse", "offeringsResponse", "Lorg/json/JSONObject;", "cacheProductEntitlementMapping", "productEntitlementMapping", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "cleanPreviouslySentTokens", "hashedTokens", "", "cleanupOldAttributionData", "clearCachesForAppUserID", "clearCustomerInfoCache", "clearCustomerInfoCacheTimestamp", "clearOfferingsResponseCache", "customerInfoCacheKey", "customerInfoLastUpdatedCacheKey", "findKeysThatStartWith", "cacheKey", "getActivePurchasesNotInCache", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "", "getCachedAppUserID", "getCachedCustomerInfo", "getCustomerInfoCachesLastUpdated", "Ljava/util/Date;", "getJSONObjectOrNull", "key", "getLegacyCachedAppUserID", "getOfferingsResponseCache", "getPreviouslySentHashedTokens", "getProductEntitlementMapping", "getProductEntitlementMappingLastUpdated", "getStorefront", "isCustomerInfoCacheStale", "", "appInBackground", "isProductEntitlementMappingCacheStale", "newKey", "putString", "value", "remove", "setCustomerInfoCacheTimestamp", "date", "setCustomerInfoCacheTimestampToNow", "setProductEntitlementMappingCacheTimestamp", "setProductEntitlementMappingCacheTimestampToNow", "setSavedTokenHashes", "newSet", "setStorefront", "countryCode", "clearAppUserID", "Landroid/content/SharedPreferences$Editor;", "clearCustomerInfo", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DeviceCache.kt */
public class DeviceCache implements StorefrontProvider {
    private static final String CUSTOMER_INFO_REQUEST_DATE_KEY = "customer_info_request_date";
    private static final String CUSTOMER_INFO_SCHEMA_VERSION_KEY = "schema_version";
    private static final String CUSTOMER_INFO_VERIFICATION_RESULT_KEY = "verification_result";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final String apiKey;
    private final Lazy apiKeyPrefix$delegate;
    private final Lazy appUserIDCacheKey$delegate;
    private final String attributionCacheKey;
    private final Lazy customerInfoCachesLastUpdatedCacheBaseKey$delegate;
    private final DateProvider dateProvider;
    private final Lazy legacyAppUserIDCacheKey$delegate;
    private final Lazy offeringsResponseCacheKey$delegate;
    private final SharedPreferences preferences;
    private final Lazy productEntitlementMappingCacheKey$delegate;
    private final Lazy productEntitlementMappingLastUpdatedCacheKey$delegate;
    private final Lazy storefrontCacheKey$delegate;
    private final Lazy tokensCacheKey$delegate;

    public final String getAttributionCacheKey$purchases_defaultsRelease() {
        return this.attributionCacheKey;
    }

    public DeviceCache(SharedPreferences sharedPreferences, String str, DateProvider dateProvider2) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        this.preferences = sharedPreferences;
        this.apiKey = str;
        this.dateProvider = dateProvider2;
        this.apiKeyPrefix$delegate = LazyKt.lazy(new DeviceCache$apiKeyPrefix$2(this));
        this.legacyAppUserIDCacheKey$delegate = LazyKt.lazy(new DeviceCache$legacyAppUserIDCacheKey$2(this));
        this.appUserIDCacheKey$delegate = LazyKt.lazy(new DeviceCache$appUserIDCacheKey$2(this));
        this.attributionCacheKey = "com.revenuecat.purchases..attribution";
        this.tokensCacheKey$delegate = LazyKt.lazy(new DeviceCache$tokensCacheKey$2(this));
        this.storefrontCacheKey$delegate = LazyKt.lazy(DeviceCache$storefrontCacheKey$2.INSTANCE);
        this.productEntitlementMappingCacheKey$delegate = LazyKt.lazy(new DeviceCache$productEntitlementMappingCacheKey$2(this));
        this.productEntitlementMappingLastUpdatedCacheKey$delegate = LazyKt.lazy(new DeviceCache$productEntitlementMappingLastUpdatedCacheKey$2(this));
        this.customerInfoCachesLastUpdatedCacheBaseKey$delegate = LazyKt.lazy(new DeviceCache$customerInfoCachesLastUpdatedCacheBaseKey$2(this));
        this.offeringsResponseCacheKey$delegate = LazyKt.lazy(new DeviceCache$offeringsResponseCacheKey$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceCache(SharedPreferences sharedPreferences, String str, DateProvider dateProvider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, str, (i & 4) != 0 ? new DefaultDateProvider() : dateProvider2);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/caching/DeviceCache$Companion;", "", "()V", "CUSTOMER_INFO_REQUEST_DATE_KEY", "", "CUSTOMER_INFO_SCHEMA_VERSION_KEY", "CUSTOMER_INFO_VERIFICATION_RESULT_KEY", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DeviceCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final String getApiKeyPrefix() {
        return (String) this.apiKeyPrefix$delegate.getValue();
    }

    public final String getLegacyAppUserIDCacheKey() {
        return (String) this.legacyAppUserIDCacheKey$delegate.getValue();
    }

    public final String getAppUserIDCacheKey() {
        return (String) this.appUserIDCacheKey$delegate.getValue();
    }

    public final String getTokensCacheKey() {
        return (String) this.tokensCacheKey$delegate.getValue();
    }

    public final String getStorefrontCacheKey() {
        return (String) this.storefrontCacheKey$delegate.getValue();
    }

    private final String getProductEntitlementMappingCacheKey() {
        return (String) this.productEntitlementMappingCacheKey$delegate.getValue();
    }

    private final String getProductEntitlementMappingLastUpdatedCacheKey() {
        return (String) this.productEntitlementMappingLastUpdatedCacheKey$delegate.getValue();
    }

    private final String getCustomerInfoCachesLastUpdatedCacheBaseKey() {
        return (String) this.customerInfoCachesLastUpdatedCacheBaseKey$delegate.getValue();
    }

    private final String getOfferingsResponseCacheKey() {
        return (String) this.offeringsResponseCacheKey$delegate.getValue();
    }

    public final synchronized String getLegacyCachedAppUserID() {
        return this.preferences.getString(getLegacyAppUserIDCacheKey(), (String) null);
    }

    public final synchronized String getCachedAppUserID() {
        return this.preferences.getString(getAppUserIDCacheKey(), (String) null);
    }

    public final synchronized void cacheAppUserID(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        this.preferences.edit().putString(getAppUserIDCacheKey(), str).apply();
    }

    public final synchronized void clearCachesForAppUserID(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(clearAppUserID(clearCustomerInfo(edit)), str).apply();
    }

    private final SharedPreferences.Editor clearCustomerInfo(SharedPreferences.Editor editor) {
        String cachedAppUserID = getCachedAppUserID();
        if (cachedAppUserID != null) {
            editor.remove(customerInfoCacheKey(cachedAppUserID));
        }
        String legacyCachedAppUserID = getLegacyCachedAppUserID();
        if (legacyCachedAppUserID != null) {
            editor.remove(customerInfoCacheKey(legacyCachedAppUserID));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearAppUserID(SharedPreferences.Editor editor) {
        editor.remove(getAppUserIDCacheKey());
        editor.remove(getLegacyAppUserIDCacheKey());
        return editor;
    }

    private final SharedPreferences.Editor clearCustomerInfoCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(customerInfoLastUpdatedCacheKey(str));
        return editor;
    }

    public final String customerInfoCacheKey(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        return getLegacyAppUserIDCacheKey() + '.' + str;
    }

    public final String customerInfoLastUpdatedCacheKey(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        return getCustomerInfoCachesLastUpdatedCacheBaseKey() + '.' + str;
    }

    public final CustomerInfo getCachedCustomerInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        String string = this.preferences.getString(customerInfoCacheKey(str), (String) null);
        if (string == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int optInt = jSONObject.optInt(CUSTOMER_INFO_SCHEMA_VERSION_KEY);
            String string2 = jSONObject.has("verification_result") ? jSONObject.getString("verification_result") : "NOT_REQUESTED";
            Long valueOf = Long.valueOf(jSONObject.optLong(CUSTOMER_INFO_REQUEST_DATE_KEY));
            if (valueOf.longValue() <= 0) {
                valueOf = null;
            }
            Date date = valueOf != null ? new Date(valueOf.longValue()) : null;
            jSONObject.remove("verification_result");
            jSONObject.remove(CUSTOMER_INFO_REQUEST_DATE_KEY);
            Intrinsics.checkNotNullExpressionValue(string2, "verificationResultString");
            VerificationResult valueOf2 = VerificationResult.valueOf(string2);
            if (optInt == 3) {
                return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, date, valueOf2);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final synchronized void cacheCustomerInfo(String str, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(customerInfo, "info");
        JSONObject rawData = customerInfo.getRawData();
        rawData.put(CUSTOMER_INFO_SCHEMA_VERSION_KEY, 3);
        rawData.put("verification_result", customerInfo.getEntitlements().getVerification().name());
        rawData.put(CUSTOMER_INFO_REQUEST_DATE_KEY, customerInfo.getRequestDate().getTime());
        this.preferences.edit().putString(customerInfoCacheKey(str), rawData.toString()).apply();
        setCustomerInfoCacheTimestampToNow(str);
    }

    public final synchronized boolean isCustomerInfoCacheStale(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        return DateExtensionsKt.isCacheStale(getCustomerInfoCachesLastUpdated(str), z, this.dateProvider);
    }

    public final synchronized void clearCustomerInfoCacheTimestamp(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(edit, str).apply();
    }

    public final synchronized void clearCustomerInfoCache(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        clearCustomerInfoCacheTimestamp(edit, str);
        edit.remove(customerInfoCacheKey(str));
        edit.apply();
    }

    public final synchronized void setCustomerInfoCacheTimestampToNow(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        setCustomerInfoCacheTimestamp(str, this.dateProvider.getNow());
    }

    public final synchronized void setCustomerInfoCacheTimestamp(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(date, "date");
        this.preferences.edit().putLong(customerInfoLastUpdatedCacheKey(str), date.getTime()).apply();
    }

    public final synchronized void setStorefront(String str) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        String format = String.format(BillingStrings.BILLING_STOREFRONT_CACHING, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.verboseLog(format);
        this.preferences.edit().putString(getStorefrontCacheKey(), str).apply();
    }

    public synchronized String getStorefront() {
        String string;
        string = this.preferences.getString(getStorefrontCacheKey(), (String) null);
        if (string == null) {
            LogUtilsKt.debugLog(BillingStrings.BILLING_STOREFRONT_NULL_FROM_CACHE);
        }
        return string;
    }

    private final synchronized Date getCustomerInfoCachesLastUpdated(String str) {
        return new Date(this.preferences.getLong(customerInfoLastUpdatedCacheKey(str), 0));
    }

    public final synchronized void cleanupOldAttributionData() {
        SharedPreferences.Editor edit = this.preferences.edit();
        for (String next : this.preferences.getAll().keySet()) {
            if (next != null && StringsKt.startsWith$default(next, this.attributionCacheKey, false, 2, (Object) null)) {
                edit.remove(next);
            }
        }
        edit.apply();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = kotlin.collections.SetsKt.emptySet();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.Set<java.lang.String> getPreviouslySentHashedTokens() {
        /*
            r6 = this;
            monitor-enter(r6)
            android.content.SharedPreferences r0 = r6.preferences     // Catch:{ ClassCastException -> 0x003a }
            java.lang.String r1 = r6.getTokensCacheKey()     // Catch:{ ClassCastException -> 0x003a }
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()     // Catch:{ ClassCastException -> 0x003a }
            java.util.Set r0 = r0.getStringSet(r1, r2)     // Catch:{ ClassCastException -> 0x003a }
            if (r0 == 0) goto L_0x0019
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ ClassCastException -> 0x003a }
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r0)     // Catch:{ ClassCastException -> 0x003a }
            if (r0 != 0) goto L_0x001d
        L_0x0019:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()     // Catch:{ ClassCastException -> 0x003a }
        L_0x001d:
            com.revenuecat.purchases.common.LogIntent r1 = com.revenuecat.purchases.common.LogIntent.DEBUG     // Catch:{ ClassCastException -> 0x003a }
            java.lang.String r2 = "Tokens already posted: %s"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ ClassCastException -> 0x003a }
            r5 = 0
            r4[r5] = r0     // Catch:{ ClassCastException -> 0x003a }
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r4, r3)     // Catch:{ ClassCastException -> 0x003a }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ ClassCastException -> 0x003a }
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ ClassCastException -> 0x003a }
            com.revenuecat.purchases.common.LogWrapperKt.log(r1, r2)     // Catch:{ ClassCastException -> 0x003a }
            goto L_0x003e
        L_0x0038:
            r0 = move-exception
            goto L_0x0040
        L_0x003a:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()     // Catch:{ all -> 0x0038 }
        L_0x003e:
            monitor-exit(r6)
            return r0
        L_0x0040:
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.caching.DeviceCache.getPreviouslySentHashedTokens():java.util.Set");
    }

    public final synchronized void addSuccessfullyPostedToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(ReceiptStrings.SAVING_TOKENS_WITH_HASH, Arrays.copyOf(new Object[]{str, UtilsKt.sha1(str)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Set<String> previouslySentHashedTokens = getPreviouslySentHashedTokens();
        LogIntent logIntent2 = LogIntent.DEBUG;
        String format2 = String.format(ReceiptStrings.TOKENS_IN_CACHE, Arrays.copyOf(new Object[]{previouslySentHashedTokens}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        LogWrapperKt.log(logIntent2, format2);
        Set mutableSet = CollectionsKt.toMutableSet(previouslySentHashedTokens);
        mutableSet.add(UtilsKt.sha1(str));
        setSavedTokenHashes(mutableSet);
    }

    private final synchronized void setSavedTokenHashes(Set<String> set) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(ReceiptStrings.SAVING_TOKENS, Arrays.copyOf(new Object[]{set}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.preferences.edit().putStringSet(getTokensCacheKey(), set).apply();
    }

    public final synchronized void cleanPreviouslySentTokens(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "hashedTokens");
        LogWrapperKt.log(LogIntent.DEBUG, ReceiptStrings.CLEANING_PREV_SENT_HASHED_TOKEN);
        setSavedTokenHashes(CollectionsKt.intersect(set, getPreviouslySentHashedTokens()));
    }

    public final synchronized List<StoreTransaction> getActivePurchasesNotInCache(Map<String, StoreTransaction> map) {
        Intrinsics.checkNotNullParameter(map, "hashedTokens");
        return CollectionsKt.toList(MapsKt.minus(map, getPreviouslySentHashedTokens()).values());
    }

    public final synchronized JSONObject getOfferingsResponseCache() {
        return getJSONObjectOrNull(getOfferingsResponseCacheKey());
    }

    public final synchronized void cacheOfferingsResponse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "offeringsResponse");
        this.preferences.edit().putString(getOfferingsResponseCacheKey(), jSONObject.toString()).apply();
    }

    public final synchronized void clearOfferingsResponseCache() {
        this.preferences.edit().remove(getOfferingsResponseCacheKey()).apply();
    }

    public final synchronized void cacheProductEntitlementMapping(ProductEntitlementMapping productEntitlementMapping) {
        Intrinsics.checkNotNullParameter(productEntitlementMapping, "productEntitlementMapping");
        this.preferences.edit().putString(getProductEntitlementMappingCacheKey(), productEntitlementMapping.toJson().toString()).apply();
        setProductEntitlementMappingCacheTimestampToNow();
    }

    public final synchronized void setProductEntitlementMappingCacheTimestampToNow() {
        setProductEntitlementMappingCacheTimestamp(this.dateProvider.getNow());
    }

    private final void setProductEntitlementMappingCacheTimestamp(Date date) {
        this.preferences.edit().putLong(getProductEntitlementMappingLastUpdatedCacheKey(), date.getTime()).apply();
    }

    public final synchronized boolean isProductEntitlementMappingCacheStale() {
        return DateExtensionsKt.m1095isCacheStale8Mi8wO0(getProductEntitlementMappingLastUpdated(), DeviceCacheKt.PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD, this.dateProvider);
    }

    public final synchronized ProductEntitlementMapping getProductEntitlementMapping() {
        ProductEntitlementMapping productEntitlementMapping;
        productEntitlementMapping = null;
        String string = this.preferences.getString(getProductEntitlementMappingCacheKey(), (String) null);
        if (string == null) {
            return null;
        }
        try {
            productEntitlementMapping = ProductEntitlementMapping.Companion.fromJson(new JSONObject(string));
        } catch (JSONException e) {
            String format = String.format(OfflineEntitlementsStrings.ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING, Arrays.copyOf(new Object[]{string}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog(format, e);
            this.preferences.edit().remove(getProductEntitlementMappingCacheKey()).apply();
        }
        return productEntitlementMapping;
    }

    private final Date getProductEntitlementMappingLastUpdated() {
        if (this.preferences.contains(getProductEntitlementMappingLastUpdatedCacheKey())) {
            return new Date(this.preferences.getLong(getProductEntitlementMappingLastUpdatedCacheKey(), -1));
        }
        return null;
    }

    public JSONObject getJSONObjectOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        String string = this.preferences.getString(str, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void putString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.preferences.edit().putString(str, str2).apply();
    }

    public final void remove(String str) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        this.preferences.edit().remove(str).apply();
    }

    public final Set<String> findKeysThatStartWith(String str) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        try {
            Map<String, ?> all = this.preferences.getAll();
            if (all != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry next : all.entrySet()) {
                    String str2 = (String) next.getKey();
                    Intrinsics.checkNotNullExpressionValue(str2, "it");
                    if (StringsKt.startsWith$default(str2, str, false, 2, (Object) null)) {
                        linkedHashMap.put(next.getKey(), next.getValue());
                    }
                }
                Set<String> keySet = linkedHashMap.keySet();
                if (keySet != null) {
                    return keySet;
                }
            }
            return SetsKt.emptySet();
        } catch (NullPointerException unused) {
            return SetsKt.emptySet();
        }
    }

    public final String newKey(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        return getApiKeyPrefix() + '.' + str;
    }
}
