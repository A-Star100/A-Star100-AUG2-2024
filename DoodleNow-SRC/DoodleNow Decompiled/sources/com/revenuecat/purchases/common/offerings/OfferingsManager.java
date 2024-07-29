package com.revenuecat.purchases.common.offerings;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0002JF\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012JF\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012J&\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsManager;", "", "offeringsCache", "Lcom/revenuecat/purchases/common/offerings/OfferingsCache;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offeringsFactory", "Lcom/revenuecat/purchases/common/offerings/OfferingsFactory;", "offeringImagePreDownloader", "Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;", "mainHandler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/common/offerings/OfferingsCache;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offerings/OfferingsFactory;Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;Landroid/os/Handler;)V", "createAndCacheOfferings", "", "offeringsJSON", "Lorg/json/JSONObject;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onSuccess", "Lcom/revenuecat/purchases/Offerings;", "dispatch", "action", "Lkotlin/Function0;", "fetchAndCacheOfferings", "appUserID", "", "appInBackground", "", "getOfferings", "handleErrorFetchingOfferings", "error", "onAppForeground", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsManager.kt */
public final class OfferingsManager {
    private final Backend backend;
    private final Handler mainHandler;
    /* access modifiers changed from: private */
    public final OfferingImagePreDownloader offeringImagePreDownloader;
    /* access modifiers changed from: private */
    public final OfferingsCache offeringsCache;
    private final OfferingsFactory offeringsFactory;

    public OfferingsManager(OfferingsCache offeringsCache2, Backend backend2, OfferingsFactory offeringsFactory2, OfferingImagePreDownloader offeringImagePreDownloader2, Handler handler) {
        Intrinsics.checkNotNullParameter(offeringsCache2, "offeringsCache");
        Intrinsics.checkNotNullParameter(backend2, "backend");
        Intrinsics.checkNotNullParameter(offeringsFactory2, "offeringsFactory");
        Intrinsics.checkNotNullParameter(offeringImagePreDownloader2, "offeringImagePreDownloader");
        this.offeringsCache = offeringsCache2;
        this.backend = backend2;
        this.offeringsFactory = offeringsFactory2;
        this.offeringImagePreDownloader = offeringImagePreDownloader2;
        this.mainHandler = handler;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferingsManager(OfferingsCache offeringsCache2, Backend backend2, OfferingsFactory offeringsFactory2, OfferingImagePreDownloader offeringImagePreDownloader2, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offeringsCache2, backend2, offeringsFactory2, offeringImagePreDownloader2, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    public static /* synthetic */ void getOfferings$default(OfferingsManager offeringsManager, String str, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        offeringsManager.getOfferings(str, z, function1, function12);
    }

    public final void getOfferings(String str, boolean z, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Offerings cachedOfferings = this.offeringsCache.getCachedOfferings();
        if (cachedOfferings == null) {
            LogWrapperKt.log(LogIntent.DEBUG, OfferingStrings.NO_CACHED_OFFERINGS_FETCHING_NETWORK);
            fetchAndCacheOfferings(str, z, function1, function12);
            return;
        }
        LogWrapperKt.log(LogIntent.DEBUG, OfferingStrings.VENDING_OFFERINGS_CACHE);
        dispatch(new OfferingsManager$getOfferings$1(function12, cachedOfferings));
        if (this.offeringsCache.isOfferingsCacheStale(z)) {
            LogWrapperKt.log(LogIntent.DEBUG, z ? OfferingStrings.OFFERINGS_STALE_UPDATING_IN_BACKGROUND : OfferingStrings.OFFERINGS_STALE_UPDATING_IN_FOREGROUND);
            fetchAndCacheOfferings$default(this, str, z, (Function1) null, (Function1) null, 12, (Object) null);
        }
    }

    public final void onAppForeground(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        if (this.offeringsCache.isOfferingsCacheStale(false)) {
            LogWrapperKt.log(LogIntent.DEBUG, OfferingStrings.OFFERINGS_STALE_UPDATING_IN_FOREGROUND);
            fetchAndCacheOfferings$default(this, str, false, (Function1) null, (Function1) null, 12, (Object) null);
        }
    }

    public static /* synthetic */ void fetchAndCacheOfferings$default(OfferingsManager offeringsManager, String str, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        offeringsManager.fetchAndCacheOfferings(str, z, function1, function12);
    }

    public final void fetchAndCacheOfferings(String str, boolean z, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        LogWrapperKt.log(LogIntent.RC_SUCCESS, OfferingStrings.OFFERINGS_START_UPDATE_FROM_NETWORK);
        this.backend.getOfferings(str, z, new OfferingsManager$fetchAndCacheOfferings$1(this, function1, function12), new OfferingsManager$fetchAndCacheOfferings$2(this, function1, function12));
    }

    static /* synthetic */ void createAndCacheOfferings$default(OfferingsManager offeringsManager, JSONObject jSONObject, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        offeringsManager.createAndCacheOfferings(jSONObject, function1, function12);
    }

    /* access modifiers changed from: private */
    public final void createAndCacheOfferings(JSONObject jSONObject, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        this.offeringsFactory.createOfferings(jSONObject, new OfferingsManager$createAndCacheOfferings$1(this, function1), new OfferingsManager$createAndCacheOfferings$2(this, jSONObject, function12));
    }

    /* access modifiers changed from: private */
    public final void handleErrorFetchingOfferings(PurchasesError purchasesError, Function1<? super PurchasesError, Unit> function1) {
        LogIntent logIntent = SetsKt.setOf(PurchasesErrorCode.ConfigurationError, PurchasesErrorCode.UnexpectedBackendResponseError).contains(purchasesError.getCode()) ? LogIntent.RC_ERROR : LogIntent.GOOGLE_ERROR;
        String format = String.format(OfferingStrings.FETCHING_OFFERINGS_ERROR, Arrays.copyOf(new Object[]{purchasesError}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.offeringsCache.clearOfferingsCacheTimestamp();
        dispatch(new OfferingsManager$handleErrorFetchingOfferings$1(function1, purchasesError));
    }

    /* access modifiers changed from: private */
    public final void dispatch(Function0<Unit> function0) {
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
            Handler handler = this.mainHandler;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new OfferingsManager$$ExternalSyntheticLambda0(function0));
            return;
        }
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final void dispatch$lambda$0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }
}
