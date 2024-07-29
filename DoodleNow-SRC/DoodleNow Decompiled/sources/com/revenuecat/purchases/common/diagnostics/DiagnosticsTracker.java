package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.EventsFileHelper;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0010J3\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ3\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001aJE\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020#J\u0016\u0010-\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "diagnosticsAnonymizer", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsAnonymizer;", "diagnosticsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/utils/EventsFileHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsAnonymizer;Lcom/revenuecat/purchases/common/Dispatcher;)V", "trackEvent", "", "diagnosticsEntry", "trackEventInCurrentThread", "trackEventInCurrentThread$purchases_defaultsRelease", "trackGoogleQueryProductDetailsRequest", "productType", "", "billingResponseCode", "", "billingDebugMessage", "responseTime", "Lkotlin/time/Duration;", "trackGoogleQueryProductDetailsRequest-Wn2Vu4Y", "(Ljava/lang/String;ILjava/lang/String;J)V", "trackGoogleQueryPurchaseHistoryRequest", "trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y", "trackGoogleQueryPurchasesRequest", "trackGoogleQueryPurchasesRequest-Wn2Vu4Y", "trackHttpRequestPerformed", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "wasSuccessful", "", "responseCode", "resultOrigin", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "trackHttpRequestPerformed-NcHsxvU", "(Lcom/revenuecat/purchases/common/networking/Endpoint;JZILcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Lcom/revenuecat/purchases/VerificationResult;)V", "trackMaxEventsStoredLimitReached", "useCurrentThread", "trackProductDetailsNotSupported", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DiagnosticsTracker.kt */
public final class DiagnosticsTracker {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String ENDPOINT_NAME_KEY = "endpoint_name";
    @Deprecated
    public static final String ETAG_HIT_KEY = "etag_hit";
    @Deprecated
    public static final String PRODUCT_TYPE_QUERIED_KEY = "product_type_queried";
    @Deprecated
    public static final String RESPONSE_CODE_KEY = "response_code";
    @Deprecated
    public static final String RESPONSE_TIME_MILLIS_KEY = "response_time_millis";
    @Deprecated
    public static final String SUCCESSFUL_KEY = "successful";
    @Deprecated
    public static final String VERIFICATION_RESULT_KEY = "verification_result";
    private final AppConfig appConfig;
    private final DiagnosticsAnonymizer diagnosticsAnonymizer;
    private final Dispatcher diagnosticsDispatcher;
    private final EventsFileHelper<DiagnosticsEntry> diagnosticsFileHelper;

    public DiagnosticsTracker(AppConfig appConfig2, EventsFileHelper<DiagnosticsEntry> eventsFileHelper, DiagnosticsAnonymizer diagnosticsAnonymizer2, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(eventsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsAnonymizer2, "diagnosticsAnonymizer");
        Intrinsics.checkNotNullParameter(dispatcher, "diagnosticsDispatcher");
        this.appConfig = appConfig2;
        this.diagnosticsFileHelper = eventsFileHelper;
        this.diagnosticsAnonymizer = diagnosticsAnonymizer2;
        this.diagnosticsDispatcher = dispatcher;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$Companion;", "", "()V", "ENDPOINT_NAME_KEY", "", "ETAG_HIT_KEY", "PRODUCT_TYPE_QUERIED_KEY", "RESPONSE_CODE_KEY", "RESPONSE_TIME_MILLIS_KEY", "SUCCESSFUL_KEY", "VERIFICATION_RESULT_KEY", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DiagnosticsTracker.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: trackHttpRequestPerformed-NcHsxvU  reason: not valid java name */
    public final void m1100trackHttpRequestPerformedNcHsxvU(Endpoint endpoint, long j, boolean z, int i, HTTPResult.Origin origin, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        boolean z2 = origin == HTTPResult.Origin.CACHE;
        DiagnosticsEventName diagnosticsEventName = DiagnosticsEventName.HTTP_REQUEST_PERFORMED;
        Map mapOf = MapsKt.mapOf(TuplesKt.to(ENDPOINT_NAME_KEY, endpoint.getName()), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2581getInWholeMillisecondsimpl(j))), TuplesKt.to(SUCCESSFUL_KEY, Boolean.valueOf(z)), TuplesKt.to(RESPONSE_CODE_KEY, Integer.valueOf(i)), TuplesKt.to(ETAG_HIT_KEY, Boolean.valueOf(z2)), TuplesKt.to(VERIFICATION_RESULT_KEY, verificationResult.name()));
        Object obj = VERIFICATION_RESULT_KEY;
        Object obj2 = ETAG_HIT_KEY;
        Object obj3 = RESPONSE_CODE_KEY;
        trackEvent(new DiagnosticsEntry.Event(diagnosticsEventName, mapOf, (DateProvider) null, (Date) null, 12, (DefaultConstructorMarker) null));
        trackEvent(new DiagnosticsEntry.Counter(DiagnosticsCounterName.HTTP_REQUEST_PERFORMED, MapsKt.mapOf(TuplesKt.to(ENDPOINT_NAME_KEY, endpoint.getName()), TuplesKt.to(SUCCESSFUL_KEY, String.valueOf(z)), TuplesKt.to(obj3, String.valueOf(i)), TuplesKt.to(obj2, String.valueOf(z2)), TuplesKt.to(obj, verificationResult.name())), 1));
    }

    /* renamed from: trackGoogleQueryProductDetailsRequest-Wn2Vu4Y  reason: not valid java name */
    public final void m1097trackGoogleQueryProductDetailsRequestWn2Vu4Y(String str, int i, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "productType");
        Intrinsics.checkNotNullParameter(str2, "billingDebugMessage");
        trackEvent(new DiagnosticsEntry.Event(DiagnosticsEventName.GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, str), TuplesKt.to("billing_response_code", Integer.valueOf(i)), TuplesKt.to("billing_debug_message", str2), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2581getInWholeMillisecondsimpl(j)))), (DateProvider) null, (Date) null, 12, (DefaultConstructorMarker) null));
    }

    /* renamed from: trackGoogleQueryPurchasesRequest-Wn2Vu4Y  reason: not valid java name */
    public final void m1099trackGoogleQueryPurchasesRequestWn2Vu4Y(String str, int i, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "productType");
        Intrinsics.checkNotNullParameter(str2, "billingDebugMessage");
        trackEvent(new DiagnosticsEntry.Event(DiagnosticsEventName.GOOGLE_QUERY_PURCHASES_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, str), TuplesKt.to("billing_response_code", Integer.valueOf(i)), TuplesKt.to("billing_debug_message", str2), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2581getInWholeMillisecondsimpl(j)))), (DateProvider) null, (Date) null, 12, (DefaultConstructorMarker) null));
    }

    /* renamed from: trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y  reason: not valid java name */
    public final void m1098trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(String str, int i, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "productType");
        Intrinsics.checkNotNullParameter(str2, "billingDebugMessage");
        trackEvent(new DiagnosticsEntry.Event(DiagnosticsEventName.GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, str), TuplesKt.to("billing_response_code", Integer.valueOf(i)), TuplesKt.to("billing_debug_message", str2), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2581getInWholeMillisecondsimpl(j)))), (DateProvider) null, (Date) null, 12, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ void trackMaxEventsStoredLimitReached$default(DiagnosticsTracker diagnosticsTracker, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        diagnosticsTracker.trackMaxEventsStoredLimitReached(z);
    }

    public final void trackMaxEventsStoredLimitReached(boolean z) {
        DiagnosticsEntry.Event event = new DiagnosticsEntry.Event(DiagnosticsEventName.MAX_EVENTS_STORED_LIMIT_REACHED, MapsKt.emptyMap(), (DateProvider) null, (Date) null, 12, (DefaultConstructorMarker) null);
        if (z) {
            trackEventInCurrentThread$purchases_defaultsRelease(event);
        } else {
            trackEvent(event);
        }
    }

    public final void trackProductDetailsNotSupported(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "billingDebugMessage");
        DiagnosticsCounterName diagnosticsCounterName = DiagnosticsCounterName.PRODUCT_DETAILS_NOT_SUPPORTED;
        Pair[] pairArr = new Pair[4];
        String playStoreVersionName = this.appConfig.getPlayStoreVersionName();
        String str2 = "";
        if (playStoreVersionName == null) {
            playStoreVersionName = str2;
        }
        pairArr[0] = TuplesKt.to("play_store_version", playStoreVersionName);
        String playServicesVersionName = this.appConfig.getPlayServicesVersionName();
        if (playServicesVersionName != null) {
            str2 = playServicesVersionName;
        }
        pairArr[1] = TuplesKt.to("play_services_version", str2);
        pairArr[2] = TuplesKt.to("billing_response_code", String.valueOf(i));
        pairArr[3] = TuplesKt.to("billing_debug_message", str);
        trackEvent(new DiagnosticsEntry.Counter(diagnosticsCounterName, MapsKt.mapOf(pairArr), 1));
    }

    public final void trackEvent(DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new DiagnosticsTracker$$ExternalSyntheticLambda0(this, diagnosticsEntry), (Delay) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void trackEvent$lambda$0(DiagnosticsTracker diagnosticsTracker, DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsTracker, "this$0");
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "$diagnosticsEntry");
        diagnosticsTracker.trackEventInCurrentThread$purchases_defaultsRelease(diagnosticsEntry);
    }

    public final void trackEventInCurrentThread$purchases_defaultsRelease(DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            DiagnosticsEntry anonymizeEntryIfNeeded = this.diagnosticsAnonymizer.anonymizeEntryIfNeeded(diagnosticsEntry);
            LogUtilsKt.verboseLog("Tracking diagnostics event: " + anonymizeEntryIfNeeded);
            try {
                this.diagnosticsFileHelper.appendEvent(anonymizeEntryIfNeeded);
            } catch (IOException e) {
                LogUtilsKt.verboseLog("Error tracking diagnostics event: " + e);
            }
        }
    }
}
