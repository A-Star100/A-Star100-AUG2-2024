package com.revenuecat.purchases.hybridcommon;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.amazon.a.a.o.b;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.EntitlementVerificationMode;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.hybridcommon.mappers.LogHandlerWithMapping;
import com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.StoreTransaction;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a,\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u001ae\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u001b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\fH\u0000\u001a\u0006\u0010\u001e\u001a\u00020\f\u001a\u000e\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u0019\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0002\u0010$\u001a\u000e\u0010%\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a$\u0010&\u001a\u00020\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020)\u001a\u0006\u0010*\u001a\u00020+\u001a\b\u0010,\u001a\u0004\u0018\u00010\f\u001a$\u0010-\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010.2\u0006\u0010\u0007\u001a\u00020 H\u0002\u001a\"\u00101\u001a\u0014\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010.2\u0006\u0010\u0007\u001a\u00020 H\u0002\u001a\u0006\u00103\u001a\u00020\u0001\u001a\u0006\u00104\u001a\u00020\t\u001a\u0016\u00105\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020 \u001a\u000e\u00106\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u0010\u00107\u001a\u0002082\u0006\u0010(\u001a\u00020\fH\u0001\u001aK\u00109\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020 ¢\u0006\u0002\u0010A\u001a_\u0010B\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010C\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\t2\b\u0010E\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020 ¢\u0006\u0002\u0010F\u001aU\u0010G\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010C\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\t2\b\u0010E\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020 ¢\u0006\u0002\u0010I\u001a\u000e\u0010J\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u0010\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\tH\u0007\u001a\u0010\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\tH\u0007\u001a\u000e\u0010O\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\t\u001a5\u0010P\u001a\u00020\u00012-\u0010Q\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020\u00010R\u001a\u000e\u0010V\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u000e\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\f\u001a\u0010\u0010Y\u001a\u00020\u00012\b\u0010Z\u001a\u0004\u0018\u00010\f\u001a$\u0010[\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u0005H\u0007\u001a\u0006\u0010^\u001a\u00020\u0001\u001a\u0010\u0010_\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\fH\u0000\u001a\u0016\u0010`\u001a\u00020a*\u00020a2\b\u0010E\u001a\u0004\u0018\u00010\fH\u0002¨\u0006b"}, d2 = {"canMakePayments", "", "context", "Landroid/content/Context;", "features", "", "", "onResult", "Lcom/revenuecat/purchases/hybridcommon/OnResultAny;", "", "checkTrialOrIntroductoryPriceEligibility", "", "", "", "productIdentifiers", "configure", "apiKey", "appUserID", "observerMode", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "store", "Lcom/revenuecat/purchases/Store;", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "shouldShowInAppMessagesAutomatically", "verificationMode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/revenuecat/purchases/common/PlatformInfo;Lcom/revenuecat/purchases/Store;Lcom/revenuecat/purchases/DangerousSettings;Ljava/lang/Boolean;Ljava/lang/String;)V", "errorLog", "message", "getAppUserID", "getCustomerInfo", "Lcom/revenuecat/purchases/hybridcommon/OnResult;", "getGoogleProrationMode", "Lcom/revenuecat/purchases/models/GoogleProrationMode;", "prorationModeInt", "(Ljava/lang/Integer;)Lcom/revenuecat/purchases/models/GoogleProrationMode;", "getOfferings", "getProductInfo", "productIDs", "type", "Lcom/revenuecat/purchases/hybridcommon/OnResultList;", "getPromotionalOffer", "Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;", "getProxyURLString", "getPurchaseCompletedFunction", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "Lcom/revenuecat/purchases/CustomerInfo;", "getPurchaseErrorFunction", "Lcom/revenuecat/purchases/PurchasesError;", "invalidateCustomerInfoCache", "isAnonymous", "logIn", "logOut", "mapStringToProductType", "Lcom/revenuecat/purchases/ProductType;", "purchasePackage", "activity", "Landroid/app/Activity;", "packageIdentifier", "offeringIdentifier", "googleOldProductId", "googleProrationMode", "googleIsPersonalizedPrice", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/revenuecat/purchases/hybridcommon/OnResult;)V", "purchaseProduct", "productIdentifier", "googleBasePlanId", "presentedOfferingIdentifier", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/hybridcommon/OnResult;)V", "purchaseSubscriptionOption", "optionIdentifier", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/hybridcommon/OnResult;)V", "restorePurchases", "setAllowSharingAppStoreAccount", "allowSharingAppStoreAccount", "setDebugLogsEnabled", "enabled", "setFinishTransactions", "setLogHandler", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "logDetails", "setLogHandlerWithOnResult", "setLogLevel", "level", "setProxyURLString", "proxyURLString", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "syncPurchases", "warnLog", "applyOfferingIdentifier", "Lcom/revenuecat/purchases/models/StoreProduct;", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
public final class CommonKt {
    public static final void configure(Context context, String str, String str2, Boolean bool, PlatformInfo platformInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "apiKey");
        PlatformInfo platformInfo2 = platformInfo;
        Intrinsics.checkNotNullParameter(platformInfo2, "platformInfo");
        configure$default(context, str, str2, bool, platformInfo2, (Store) null, (DangerousSettings) null, (Boolean) null, (String) null, 480, (Object) null);
    }

    public static final void configure(Context context, String str, String str2, Boolean bool, PlatformInfo platformInfo, Store store) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "apiKey");
        PlatformInfo platformInfo2 = platformInfo;
        Intrinsics.checkNotNullParameter(platformInfo2, "platformInfo");
        Store store2 = store;
        Intrinsics.checkNotNullParameter(store2, ProductResponseJsonKeys.STORE);
        configure$default(context, str, str2, bool, platformInfo2, store2, (DangerousSettings) null, (Boolean) null, (String) null, 448, (Object) null);
    }

    public static final void configure(Context context, String str, String str2, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "apiKey");
        PlatformInfo platformInfo2 = platformInfo;
        Intrinsics.checkNotNullParameter(platformInfo2, "platformInfo");
        Store store2 = store;
        Intrinsics.checkNotNullParameter(store2, ProductResponseJsonKeys.STORE);
        DangerousSettings dangerousSettings2 = dangerousSettings;
        Intrinsics.checkNotNullParameter(dangerousSettings2, "dangerousSettings");
        configure$default(context, str, str2, bool, platformInfo2, store2, dangerousSettings2, (Boolean) null, (String) null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, (Object) null);
    }

    public static final void configure(Context context, String str, String str2, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "apiKey");
        PlatformInfo platformInfo2 = platformInfo;
        Intrinsics.checkNotNullParameter(platformInfo2, "platformInfo");
        Store store2 = store;
        Intrinsics.checkNotNullParameter(store2, ProductResponseJsonKeys.STORE);
        DangerousSettings dangerousSettings2 = dangerousSettings;
        Intrinsics.checkNotNullParameter(dangerousSettings2, "dangerousSettings");
        configure$default(context, str, str2, bool, platformInfo2, store2, dangerousSettings2, bool2, (String) null, 256, (Object) null);
    }

    public static final void showInAppMessagesIfNeeded(Activity activity) {
        showInAppMessagesIfNeeded$default(activity, (List) null, 2, (Object) null);
    }

    @Deprecated(message = "Replaced with configuration in the RevenueCat dashboard", replaceWith = @ReplaceWith(expression = "configure through the RevenueCat dashboard", imports = {}))
    public static final void setAllowSharingAppStoreAccount(boolean z) {
        Purchases.Companion.getSharedInstance().setAllowSharingPlayStoreAccount(z);
    }

    public static final void getOfferings(OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsCommonKt.getOfferingsWith(Purchases.Companion.getSharedInstance(), new CommonKt$getOfferings$1(onResult), new CommonKt$getOfferings$2(onResult));
    }

    public static final void getProductInfo(List<String> list, String str, OnResultList onResultList) {
        Intrinsics.checkNotNullParameter(list, "productIDs");
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(onResultList, "onResult");
        Function1 commonKt$getProductInfo$onError$1 = new CommonKt$getProductInfo$onError$1(onResultList);
        Function1 commonKt$getProductInfo$onReceived$1 = new CommonKt$getProductInfo$onReceived$1(onResultList);
        if (mapStringToProductType(str) == ProductType.SUBS) {
            ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), list, ProductType.SUBS, commonKt$getProductInfo$onError$1, commonKt$getProductInfo$onReceived$1);
        } else {
            ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), list, ProductType.INAPP, commonKt$getProductInfo$onError$1, commonKt$getProductInfo$onReceived$1);
        }
    }

    public static final void purchaseProduct(Activity activity, String str, String str2, String str3, String str4, Integer num, Boolean bool, String str5, OnResult onResult) {
        String str6 = str;
        OnResult onResult2 = onResult;
        Intrinsics.checkNotNullParameter(str, "productIdentifier");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(onResult2, "onResult");
        try {
            GoogleProrationMode googleProrationMode = getGoogleProrationMode(num);
            ProductType mapStringToProductType = mapStringToProductType(str2);
            if (activity != null) {
                Function1 commonKt$purchaseProduct$onReceiveStoreProducts$1 = new CommonKt$purchaseProduct$onReceiveStoreProducts$1(str5, activity, str4, googleProrationMode, bool, onResult, str, mapStringToProductType, str3);
                if (mapStringToProductType == ProductType.SUBS) {
                    ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), CollectionsKt.listOf((String) CollectionsKt.first(StringsKt.split$default((CharSequence) str6, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null))), ProductType.SUBS, new CommonKt$purchaseProduct$1(onResult2), commonKt$purchaseProduct$onReceiveStoreProducts$1);
                } else {
                    ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), CollectionsKt.listOf(str), ProductType.INAPP, new CommonKt$purchaseProduct$2(onResult2), commonKt$purchaseProduct$onReceiveStoreProducts$1);
                }
            } else {
                onResult2.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), (Map) null, 1, (Object) null));
            }
        } catch (InvalidProrationModeException unused) {
            onResult2.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google proration mode passed to purchaseProduct."), (Map) null, 1, (Object) null));
        }
    }

    public static final void purchasePackage(Activity activity, String str, String str2, String str3, Integer num, Boolean bool, OnResult onResult) {
        OnResult onResult2 = onResult;
        String str4 = str;
        Intrinsics.checkNotNullParameter(str, "packageIdentifier");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str2, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(onResult2, "onResult");
        try {
            GoogleProrationMode googleProrationMode = getGoogleProrationMode(num);
            if (activity != null) {
                ListenerConversionsCommonKt.getOfferingsWith(Purchases.Companion.getSharedInstance(), new CommonKt$purchasePackage$1(onResult2), new CommonKt$purchasePackage$2(str2, activity, str3, googleProrationMode, bool, onResult, str));
            } else {
                onResult2.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), (Map) null, 1, (Object) null));
            }
        } catch (InvalidProrationModeException unused) {
            onResult2.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google proration mode passed to purchasePackage."), (Map) null, 1, (Object) null));
        }
    }

    public static final void purchaseSubscriptionOption(Activity activity, String str, String str2, String str3, Integer num, Boolean bool, String str4, OnResult onResult) {
        OnResult onResult2 = onResult;
        String str5 = str;
        Intrinsics.checkNotNullParameter(str, "productIdentifier");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str2, "optionIdentifier");
        Intrinsics.checkNotNullParameter(onResult2, "onResult");
        if (Purchases.Companion.getSharedInstance().getStore() != Store.PLAY_STORE) {
            onResult2.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "purchaseSubscriptionOption() is only supported on the Play Store."), (Map) null, 1, (Object) null));
            return;
        }
        try {
            GoogleProrationMode googleProrationMode = getGoogleProrationMode(num);
            if (activity != null) {
                ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), CollectionsKt.listOf(str), ProductType.SUBS, new CommonKt$purchaseSubscriptionOption$1(onResult2), new CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1(activity, str3, bool, onResult, str, str2, str4, googleProrationMode));
                return;
            }
            onResult2.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), (Map) null, 1, (Object) null));
        } catch (InvalidProrationModeException unused) {
            onResult2.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google proration mode passed to purchaseSubscriptionOption."), (Map) null, 1, (Object) null));
        }
    }

    public static final String getAppUserID() {
        return Purchases.Companion.getSharedInstance().getAppUserID();
    }

    public static final void restorePurchases(OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsCommonKt.restorePurchasesWith(Purchases.Companion.getSharedInstance(), new CommonKt$restorePurchases$1(onResult), new CommonKt$restorePurchases$2(onResult));
    }

    public static final void logIn(String str, OnResult onResult) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsKt.logInWith(Purchases.Companion.getSharedInstance(), str, new CommonKt$logIn$1(onResult), new CommonKt$logIn$2(onResult));
    }

    public static final void logOut(OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsKt.logOutWith(Purchases.Companion.getSharedInstance(), new CommonKt$logOut$1(onResult), new CommonKt$logOut$2(onResult));
    }

    @Deprecated(message = "Use setLogLevel instead")
    public static final void setDebugLogsEnabled(boolean z) {
        Purchases.Companion.setDebugLogsEnabled(z);
    }

    public static final void setLogLevel(String str) {
        Intrinsics.checkNotNullParameter(str, "level");
        try {
            Purchases.Companion.setLogLevel(LogLevel.valueOf(str));
        } catch (IllegalArgumentException unused) {
            warnLog("Unrecognized log level: " + str);
        }
    }

    public static final void setLogHandler(Function1<? super Map<String, String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Purchases.Companion.setLogHandler(new LogHandlerWithMapping(function1));
    }

    public static final void setLogHandlerWithOnResult(OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        setLogHandler(new CommonKt$setLogHandlerWithOnResult$1(onResult));
    }

    public static final void setProxyURLString(String str) {
        Purchases.Companion.setProxyURL(str != null ? new URL(str) : null);
    }

    public static final String getProxyURLString() {
        return String.valueOf(Purchases.Companion.getProxyURL());
    }

    public static final void getCustomerInfo(OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsKt.getCustomerInfoWith(Purchases.Companion.getSharedInstance(), new CommonKt$getCustomerInfo$1(onResult), new CommonKt$getCustomerInfo$2(onResult));
    }

    public static final void syncPurchases() {
        Purchases.syncPurchases$default(Purchases.Companion.getSharedInstance(), (SyncPurchasesCallback) null, 1, (Object) null);
    }

    public static final boolean isAnonymous() {
        return Purchases.Companion.getSharedInstance().isAnonymous();
    }

    public static final void setFinishTransactions(boolean z) {
        Purchases.Companion.getSharedInstance().setFinishTransactions(z);
    }

    public static final Map<String, Map<String, Object>> checkTrialOrIntroductoryPriceEligibility(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "productIdentifiers");
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String str : iterable) {
            arrayList.add(TuplesKt.to(str, MapsKt.mapOf(TuplesKt.to("status", 0), TuplesKt.to(b.c, "Status indeterminate."))));
        }
        return MapsKt.toMap((List) arrayList);
    }

    public static final void invalidateCustomerInfoCache() {
        Purchases.Companion.getSharedInstance().invalidateCustomerInfoCache();
    }

    public static final void canMakePayments(Context context, List<Integer> list, OnResultAny<Boolean> onResultAny) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "features");
        Intrinsics.checkNotNullParameter(onResultAny, "onResult");
        List arrayList = new ArrayList();
        try {
            BillingFeature[] values = BillingFeature.values();
            Iterable<Number> iterable = list;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Number intValue : iterable) {
                arrayList2.add(values[intValue.intValue()]);
            }
            arrayList.addAll((List) arrayList2);
            Purchases.Companion.canMakePayments(context, arrayList, new CommonKt$$ExternalSyntheticLambda0(onResultAny));
        } catch (IndexOutOfBoundsException unused) {
            onResultAny.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid feature type passed to canMakePayments."), (Map) null, 1, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public static final void canMakePayments$lambda$2(OnResultAny onResultAny, Boolean bool) {
        Intrinsics.checkNotNullParameter(onResultAny, "$onResult");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        onResultAny.onReceived(bool);
    }

    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Activity activity, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        showInAppMessagesIfNeeded(activity, list);
    }

    public static final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list) {
        if (activity == null) {
            errorLog("showInAppMessages called with null activity");
        } else if (list == null) {
            Purchases.showInAppMessagesIfNeeded$default(Purchases.Companion.getSharedInstance(), activity, (List) null, 2, (Object) null);
        } else {
            Purchases.Companion.getSharedInstance().showInAppMessagesIfNeeded(activity, list);
        }
    }

    public static /* synthetic */ void configure$default(Context context, String str, String str2, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool2, String str3, int i, Object obj) {
        int i2 = i;
        configure(context, str, str2, bool, platformInfo, (i2 & 32) != 0 ? Store.PLAY_STORE : store, (i2 & 64) != 0 ? new DangerousSettings(true) : dangerousSettings, (i2 & 128) != 0 ? null : bool2, (i2 & 256) != 0 ? null : str3);
    }

    public static final void configure(Context context, String str, String str2, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(store, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        Purchases.Companion.setPlatformInfo(platformInfo);
        PurchasesConfiguration.Builder dangerousSettings2 = new PurchasesConfiguration.Builder(context, str).appUserID(str2).store(store).dangerousSettings(dangerousSettings);
        if (bool != null) {
            dangerousSettings2.observerMode(bool.booleanValue());
        }
        if (bool2 != null) {
            dangerousSettings2.showInAppMessagesAutomatically(bool2.booleanValue());
        }
        if (str3 != null) {
            try {
                dangerousSettings2.entitlementVerificationMode(EntitlementVerificationMode.valueOf(str3));
            } catch (IllegalArgumentException unused) {
                warnLog("Attempted to configure with unknown verification mode: " + str3 + '.');
            }
        }
        Purchases.Companion.configure(dangerousSettings2.build());
    }

    public static final ErrorContainer getPromotionalOffer() {
        return new ErrorContainer(PurchasesErrorCode.UnsupportedError.getCode(), "Android platform doesn't support promotional offers", MapsKt.emptyMap());
    }

    public static final ProductType mapStringToProductType(String str) {
        MappedProductCategory mappedProductCategory;
        Intrinsics.checkNotNullParameter(str, "type");
        MappedProductCategory[] values = MappedProductCategory.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                mappedProductCategory = null;
                break;
            }
            mappedProductCategory = values[i];
            if (StringsKt.equals(mappedProductCategory.getValue(), str, true)) {
                break;
            }
            i++;
        }
        if (mappedProductCategory != null) {
            return mappedProductCategory.getToProductType();
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) lowerCase, (Object) "subs")) {
            return ProductType.SUBS;
        }
        if (Intrinsics.areEqual((Object) lowerCase, (Object) "inapp")) {
            return ProductType.INAPP;
        }
        warnLog("Unrecognized product type: " + str + "... Defaulting to INAPP");
        return ProductType.INAPP;
    }

    public static final GoogleProrationMode getGoogleProrationMode(Integer num) throws InvalidProrationModeException {
        GoogleProrationMode googleProrationMode = null;
        if (num != null) {
            int intValue = num.intValue();
            GoogleProrationMode[] values = GoogleProrationMode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                GoogleProrationMode googleProrationMode2 = values[i];
                if (googleProrationMode2.getPlayBillingClientMode() == intValue) {
                    googleProrationMode = googleProrationMode2;
                    break;
                }
                i++;
            }
            if (googleProrationMode == null) {
                throw new InvalidProrationModeException();
            }
        }
        return googleProrationMode;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r0.copyWithOfferingId(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.revenuecat.purchases.models.StoreProduct applyOfferingIdentifier(com.revenuecat.purchases.models.StoreProduct r0, java.lang.String r1) {
        /*
            if (r1 == 0) goto L_0x000a
            com.revenuecat.purchases.models.StoreProduct r1 = r0.copyWithOfferingId(r1)
            if (r1 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.hybridcommon.CommonKt.applyOfferingIdentifier(com.revenuecat.purchases.models.StoreProduct, java.lang.String):com.revenuecat.purchases.models.StoreProduct");
    }

    /* access modifiers changed from: private */
    public static final Function2<PurchasesError, Boolean, Unit> getPurchaseErrorFunction(OnResult onResult) {
        return new CommonKt$getPurchaseErrorFunction$1(onResult);
    }

    /* access modifiers changed from: private */
    public static final Function2<StoreTransaction, CustomerInfo, Unit> getPurchaseCompletedFunction(OnResult onResult) {
        return new CommonKt$getPurchaseCompletedFunction$1(onResult);
    }

    public static final void warnLog(String str) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (Purchases.Companion.getLogLevel().compareTo(LogLevel.WARN) <= 0) {
            Log.w("PurchasesHybridCommon", str);
        }
    }

    public static final void errorLog(String str) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (Purchases.Companion.getLogLevel().compareTo(LogLevel.ERROR) <= 0) {
            Log.e("PurchasesHybridCommon", str);
        }
    }
}
