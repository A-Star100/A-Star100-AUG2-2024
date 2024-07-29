package com.revenuecat.purchases.common.networking;

import android.content.Context;
import android.content.SharedPreferences;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.strings.NetworkStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ5\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0014JK\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\u0017\u0010!\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0015\u0010'\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b(J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J%\u0010+\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u000fH\u0000¢\u0006\u0002\b-J \u0010.\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager;", "", "context", "Landroid/content/Context;", "prefs", "Lkotlin/Lazy;", "Landroid/content/SharedPreferences;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/Context;Lkotlin/Lazy;Lcom/revenuecat/purchases/common/DateProvider;)V", "clearCaches", "", "clearCaches$purchases_defaultsRelease", "getETagHeaders", "", "", "path", "verificationRequested", "", "refreshETag", "getETagHeaders$purchases_defaultsRelease", "getHTTPResultFromCacheOrBackend", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "responseCode", "", "payload", "eTagHeader", "urlPathWithVersion", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "getHTTPResultFromCacheOrBackend$purchases_defaultsRelease", "getStoredResult", "getStoredResult$purchases_defaultsRelease", "getStoredResultSavedInSharedPreferences", "Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "shouldStoreBackendResult", "resultFromBackend", "shouldUseCachedVersion", "shouldUseCachedVersion$purchases_defaultsRelease", "shouldUseETag", "storedResult", "storeBackendResultIfNoError", "eTagInResponse", "storeBackendResultIfNoError$purchases_defaultsRelease", "storeResult", "result", "eTag", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ETagManager.kt */
public final class ETagManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DateProvider dateProvider;
    private final Lazy<SharedPreferences> prefs;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ETagManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.revenuecat.purchases.VerificationResult[] r0 = com.revenuecat.purchases.VerificationResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.VerificationResult r1 = com.revenuecat.purchases.VerificationResult.VERIFIED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.VerificationResult r1 = com.revenuecat.purchases.VerificationResult.NOT_REQUESTED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.VerificationResult r1 = com.revenuecat.purchases.VerificationResult.FAILED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.revenuecat.purchases.VerificationResult r1 = com.revenuecat.purchases.VerificationResult.VERIFIED_ON_DEVICE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.networking.ETagManager.WhenMappings.<clinit>():void");
        }
    }

    public final boolean shouldUseCachedVersion$purchases_defaultsRelease(int i) {
        return i == 304;
    }

    public ETagManager(Context context, Lazy<? extends SharedPreferences> lazy, DateProvider dateProvider2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lazy, "prefs");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        this.prefs = lazy;
        this.dateProvider = dateProvider2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ETagManager(final Context context, Lazy lazy, DateProvider dateProvider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? LazyKt.lazy(new Function0<SharedPreferences>() {
            public final SharedPreferences invoke() {
                return ETagManager.Companion.initializeSharedPreferences(context);
            }
        }) : lazy, (i & 4) != 0 ? new DefaultDateProvider() : dateProvider2);
    }

    public static /* synthetic */ Map getETagHeaders$purchases_defaultsRelease$default(ETagManager eTagManager, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return eTagManager.getETagHeaders$purchases_defaultsRelease(str, z, z2);
    }

    public final Map<String, String> getETagHeaders$purchases_defaultsRelease(String str, boolean z, boolean z2) {
        ETagData eTagData;
        Date lastRefreshTime;
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        String str2 = null;
        HTTPResultWithETag storedResultSavedInSharedPreferences = z2 ? null : getStoredResultSavedInSharedPreferences(str);
        if (storedResultSavedInSharedPreferences == null || (eTagData = storedResultSavedInSharedPreferences.getETagData()) == null || !shouldUseETag(storedResultSavedInSharedPreferences, z)) {
            eTagData = null;
        }
        Pair[] pairArr = new Pair[2];
        String eTag = eTagData != null ? eTagData.getETag() : null;
        if (eTag == null) {
            eTag = "";
        }
        pairArr[0] = TuplesKt.to("X-RevenueCat-ETag", eTag);
        if (!(eTagData == null || (lastRefreshTime = eTagData.getLastRefreshTime()) == null)) {
            str2 = Long.valueOf(lastRefreshTime.getTime()).toString();
        }
        pairArr[1] = TuplesKt.to(HTTPRequest.ETAG_LAST_REFRESH_NAME, str2);
        return MapsKt.mapOf(pairArr);
    }

    public final HTTPResult getHTTPResultFromCacheOrBackend$purchases_defaultsRelease(int i, String str, String str2, String str3, boolean z, Date date, VerificationResult verificationResult) {
        HTTPResult hTTPResult;
        String str4 = str2;
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str, "payload");
        Intrinsics.checkNotNullParameter(str5, "urlPathWithVersion");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        HTTPResult hTTPResult2 = new HTTPResult(i, str, HTTPResult.Origin.BACKEND, date, verificationResult);
        if (str4 != null) {
            if (shouldUseCachedVersion$purchases_defaultsRelease(i)) {
                HTTPResult storedResult$purchases_defaultsRelease = getStoredResult$purchases_defaultsRelease(str5);
                if (storedResult$purchases_defaultsRelease != null) {
                    hTTPResult = HTTPResult.copy$default(storedResult$purchases_defaultsRelease, 0, (String) null, (HTTPResult.Origin) null, date == null ? storedResult$purchases_defaultsRelease.getRequestDate() : date, verificationResult, 7, (Object) null);
                } else {
                    hTTPResult = null;
                }
                if (hTTPResult != null) {
                    return hTTPResult;
                }
                if (!z) {
                    return null;
                }
                LogIntent logIntent = LogIntent.WARNING;
                String format = String.format(NetworkStrings.ETAG_CALL_ALREADY_RETRIED, Arrays.copyOf(new Object[]{hTTPResult2}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(logIntent, format);
                return hTTPResult2;
            }
            storeBackendResultIfNoError$purchases_defaultsRelease(str5, hTTPResult2, str2);
        }
        return hTTPResult2;
    }

    public final HTTPResult getStoredResult$purchases_defaultsRelease(String str) {
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        HTTPResultWithETag storedResultSavedInSharedPreferences = getStoredResultSavedInSharedPreferences(str);
        if (storedResultSavedInSharedPreferences != null) {
            return storedResultSavedInSharedPreferences.getHttpResult();
        }
        return null;
    }

    public final void storeBackendResultIfNoError$purchases_defaultsRelease(String str, HTTPResult hTTPResult, String str2) {
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(hTTPResult, "resultFromBackend");
        Intrinsics.checkNotNullParameter(str2, "eTagInResponse");
        if (shouldStoreBackendResult(hTTPResult)) {
            storeResult(str, hTTPResult, str2);
        }
    }

    public final synchronized void clearCaches$purchases_defaultsRelease() {
        this.prefs.getValue().edit().clear().apply();
    }

    private final synchronized void storeResult(String str, HTTPResult hTTPResult, String str2) {
        this.prefs.getValue().edit().putString(str, new HTTPResultWithETag(new ETagData(str2, this.dateProvider.getNow()), HTTPResult.copy$default(hTTPResult, 0, (String) null, HTTPResult.Origin.CACHE, (Date) null, (VerificationResult) null, 27, (Object) null)).serialize()).apply();
    }

    private final HTTPResultWithETag getStoredResultSavedInSharedPreferences(String str) {
        String string = this.prefs.getValue().getString(str, (String) null);
        if (string != null) {
            return HTTPResultWithETag.Companion.deserialize(string);
        }
        return null;
    }

    private final boolean shouldStoreBackendResult(HTTPResult hTTPResult) {
        int responseCode = hTTPResult.getResponseCode();
        return (responseCode == 304 || responseCode >= 500 || hTTPResult.getVerificationResult() == VerificationResult.FAILED) ? false : true;
    }

    private final boolean shouldUseETag(HTTPResultWithETag hTTPResultWithETag, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[hTTPResultWithETag.getHttpResult().getVerificationResult().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            if (!(i == 3 || i == 4)) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!z) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager$Companion;", "", "()V", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ETagManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences_etags", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }
}
