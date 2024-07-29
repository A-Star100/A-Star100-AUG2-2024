package com.revenuecat.purchases.common;

import android.os.Build;
import androidx.browser.trusted.sharing.ShareTarget;
import com.amazon.a.a.o.b;
import com.amplitude.api.DeviceInfo;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\n \"*\u0004\u0018\u00010!0!2\u0006\u0010#\u001a\u00020$H\u0002JT\u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010!2\u0006\u0010,\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\u001dH\u0002J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020$H\u0002J\b\u00102\u001a\u00020!H\u0002Jj\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\u001a\u0010:\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0<\u0018\u00010;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\u0006\u0010)\u001a\u00020*H\u0002Jh\u0010>\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\u001a\u0010:\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0<\u0018\u00010;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\b\b\u0002\u0010)\u001a\u00020*J\u0010\u0010?\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010@\u001a\u00020\u001b2\u0006\u00107\u001a\u0002082\u0006\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u000104H\u0002J6\u0010D\u001a\u00020E2\u0006\u0010(\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010!2\b\u0010+\u001a\u0004\u0018\u00010!2\b\u0010-\u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u00172\u0006\u00109\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/revenuecat/purchases/common/HTTPClient;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "eTagManager", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "signingManager", "Lcom/revenuecat/purchases/common/verification/SigningManager;", "storefrontProvider", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "mapConverter", "Lcom/revenuecat/purchases/common/networking/MapConverter;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/networking/ETagManager;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/verification/SigningManager;Lcom/revenuecat/purchases/interfaces/StorefrontProvider;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/networking/MapConverter;)V", "getSigningManager", "()Lcom/revenuecat/purchases/common/verification/SigningManager;", "buffer", "Ljava/io/BufferedReader;", "inputStream", "Ljava/io/InputStream;", "Ljava/io/BufferedWriter;", "outputStream", "Ljava/io/OutputStream;", "clearCaches", "", "getConnection", "Ljava/net/HttpURLConnection;", "request", "Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "getETagHeader", "", "kotlin.jvm.PlatformType", "connection", "Ljava/net/URLConnection;", "getHeaders", "", "authenticationHeaders", "urlPath", "refreshETag", "", "nonce", "shouldSignResponse", "postFieldsToSignHeader", "getInputStream", "getRequestDateHeader", "Ljava/util/Date;", "getRequestTimeHeader", "getXPlatformHeader", "performCall", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "baseURL", "Ljava/net/URL;", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "body", "postFieldsToSign", "", "Lkotlin/Pair;", "requestHeaders", "performRequest", "readFully", "trackHttpRequestPerformedIfNeeded", "requestStartTime", "callSuccessful", "callResult", "verifyResponse", "Lcom/revenuecat/purchases/VerificationResult;", "payload", "writeFully", "writer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HTTPClient.kt */
public final class HTTPClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NO_STATUS_CODE = -1;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final ETagManager eTagManager;
    private final MapConverter mapConverter;
    private final SigningManager signingManager;
    private final StorefrontProvider storefrontProvider;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HTTPClient.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.AMAZON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final SigningManager getSigningManager() {
        return this.signingManager;
    }

    public HTTPClient(AppConfig appConfig2, ETagManager eTagManager2, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager2, StorefrontProvider storefrontProvider2, DateProvider dateProvider2, MapConverter mapConverter2) {
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(eTagManager2, "eTagManager");
        Intrinsics.checkNotNullParameter(signingManager2, "signingManager");
        Intrinsics.checkNotNullParameter(storefrontProvider2, "storefrontProvider");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(mapConverter2, "mapConverter");
        this.appConfig = appConfig2;
        this.eTagManager = eTagManager2;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.signingManager = signingManager2;
        this.storefrontProvider = storefrontProvider2;
        this.dateProvider = dateProvider2;
        this.mapConverter = mapConverter2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HTTPClient(AppConfig appConfig2, ETagManager eTagManager2, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager2, StorefrontProvider storefrontProvider2, DateProvider dateProvider2, MapConverter mapConverter2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appConfig2, eTagManager2, diagnosticsTracker, signingManager2, storefrontProvider2, (i & 32) != 0 ? new DefaultDateProvider() : dateProvider2, (i & 64) != 0 ? new MapConverter() : mapConverter2);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/HTTPClient$Companion;", "", "()V", "NO_STATUS_CODE", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HTTPClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final BufferedReader buffer(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    private final String readFully(InputStream inputStream) throws IOException {
        return TextStreamsKt.readText(buffer(inputStream));
    }

    private final InputStream getInputStream(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException) && !(e instanceof IOException)) {
                throw e;
            }
            LogIntent logIntent = LogIntent.WARNING;
            String format = String.format(NetworkStrings.PROBLEM_CONNECTING, Arrays.copyOf(new Object[]{e.getMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            return httpURLConnection.getErrorStream();
        }
    }

    private final void writeFully(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write(str);
        bufferedWriter.flush();
    }

    public static /* synthetic */ HTTPResult performRequest$default(HTTPClient hTTPClient, URL url, Endpoint endpoint, Map map, List list, Map map2, boolean z, int i, Object obj) throws JSONException, IOException {
        if ((i & 32) != 0) {
            z = false;
        }
        return hTTPClient.performRequest(url, endpoint, map, list, map2, z);
    }

    public final HTTPResult performRequest(URL url, Endpoint endpoint, Map<String, ? extends Object> map, List<Pair<String, String>> list, Map<String, String> map2, boolean z) throws JSONException, IOException {
        Intrinsics.checkNotNullParameter(url, "baseURL");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(map2, "requestHeaders");
        if (this.appConfig.getForceServerErrors()) {
            LogUtilsKt.warnLog("Forcing server error for request to " + endpoint.getPath());
            return new HTTPResult(500, "", HTTPResult.Origin.BACKEND, (Date) null, VerificationResult.NOT_REQUESTED);
        }
        Date now = this.dateProvider.getNow();
        try {
            HTTPResult performCall = performCall(url, endpoint, map, list, map2, z);
            trackHttpRequestPerformedIfNeeded(endpoint, now, true, performCall);
            if (performCall != null) {
                return performCall;
            }
            LogWrapperKt.log(LogIntent.WARNING, NetworkStrings.ETAG_RETRYING_CALL);
            return performRequest(url, endpoint, map, list, map2, true);
        } catch (Throwable th) {
            trackHttpRequestPerformedIfNeeded(endpoint, now, false, (HTTPResult) null);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f A[Catch:{ all -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.revenuecat.purchases.common.networking.HTTPResult performCall(java.net.URL r22, com.revenuecat.purchases.common.networking.Endpoint r23, java.util.Map<java.lang.String, ? extends java.lang.Object> r24, java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> r25, java.util.Map<java.lang.String, java.lang.String> r26, boolean r27) {
        /*
            r21 = this;
            r8 = r21
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.String r9 = "format(this, *args)"
            if (r1 == 0) goto L_0x0014
            com.revenuecat.purchases.common.networking.MapConverter r3 = r8.mapConverter
            org.json.JSONObject r1 = r3.convertToJSON$purchases_defaultsRelease(r1)
            r11 = r1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r12 = r23.getPath()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "/v1"
            r1.<init>(r3)
            r1.append(r12)
            java.lang.String r15 = r1.toString()
            com.revenuecat.purchases.common.verification.SigningManager r1 = r8.signingManager
            boolean r13 = r1.shouldVerifyEndpoint(r0)
            r14 = 1
            r16 = 0
            if (r13 == 0) goto L_0x003a
            boolean r1 = r23.getNeedsNonceToPerformSigning()
            if (r1 == 0) goto L_0x003a
            r1 = r14
            goto L_0x003c
        L_0x003a:
            r1 = r16
        L_0x003c:
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0131 }
            r3 = r22
            r7.<init>(r3, r15)     // Catch:{ MalformedURLException -> 0x0131 }
            if (r1 == 0) goto L_0x004e
            com.revenuecat.purchases.common.verification.SigningManager r1 = r8.signingManager     // Catch:{ MalformedURLException -> 0x0131 }
            java.lang.String r1 = r1.createRandomNonce()     // Catch:{ MalformedURLException -> 0x0131 }
            r17 = r1
            goto L_0x0050
        L_0x004e:
            r17 = 0
        L_0x0050:
            if (r2 == 0) goto L_0x0060
            if (r13 == 0) goto L_0x0056
            r1 = r2
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            if (r1 == 0) goto L_0x0060
            com.revenuecat.purchases.common.verification.SigningManager r1 = r8.signingManager     // Catch:{ MalformedURLException -> 0x0131 }
            java.lang.String r0 = r1.getPostParamsForSigningHeaderIfNeeded(r0, r2)     // Catch:{ MalformedURLException -> 0x0131 }
            goto L_0x0061
        L_0x0060:
            r0 = 0
        L_0x0061:
            r1 = r21
            r2 = r26
            r3 = r15
            r4 = r27
            r5 = r17
            r6 = r13
            r10 = r7
            r7 = r0
            java.util.Map r1 = r1.getHeaders(r2, r3, r4, r5, r6, r7)     // Catch:{ MalformedURLException -> 0x0131 }
            com.revenuecat.purchases.common.networking.HTTPRequest r2 = new com.revenuecat.purchases.common.networking.HTTPRequest     // Catch:{ MalformedURLException -> 0x0131 }
            r2.<init>(r10, r1, r11)     // Catch:{ MalformedURLException -> 0x0131 }
            java.net.HttpURLConnection r7 = r8.getConnection(r2)     // Catch:{ MalformedURLException -> 0x0131 }
            java.io.InputStream r1 = r8.getInputStream(r7)
            java.lang.String r2 = "API request started: %s %s"
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0127 }
            java.lang.String r5 = r7.getRequestMethod()     // Catch:{ all -> 0x0127 }
            r4[r16] = r5     // Catch:{ all -> 0x0127 }
            r4[r14] = r12     // Catch:{ all -> 0x0127 }
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r3)     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x0127 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0127 }
            com.revenuecat.purchases.common.LogUtilsKt.debugLog(r2)     // Catch:{ all -> 0x0127 }
            int r10 = r7.getResponseCode()     // Catch:{ all -> 0x0127 }
            if (r1 == 0) goto L_0x00a6
            java.lang.String r2 = r8.readFully(r1)     // Catch:{ all -> 0x0127 }
            r18 = r2
            goto L_0x00a8
        L_0x00a6:
            r18 = 0
        L_0x00a8:
            if (r1 == 0) goto L_0x00ad
            r1.close()
        L_0x00ad:
            r7.disconnect()
            r1 = 3
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r4 = r7.getRequestMethod()
            r2[r16] = r4
            r2[r14] = r12
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2[r3] = r4
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r2 = "API request completed with status: %s %s %s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)
            com.revenuecat.purchases.common.LogUtilsKt.debugLog(r1)
            if (r18 == 0) goto L_0x011f
            if (r13 == 0) goto L_0x00ed
            com.revenuecat.purchases.common.networking.RCHTTPStatusCodes r1 = com.revenuecat.purchases.common.networking.RCHTTPStatusCodes.INSTANCE
            boolean r1 = r1.isSuccessful(r10)
            if (r1 == 0) goto L_0x00ed
            r3 = r7
            java.net.URLConnection r3 = (java.net.URLConnection) r3
            r1 = r21
            r2 = r15
            r4 = r18
            r5 = r17
            r6 = r0
            com.revenuecat.purchases.VerificationResult r0 = r1.verifyResponse(r2, r3, r4, r5, r6)
            goto L_0x00ef
        L_0x00ed:
            com.revenuecat.purchases.VerificationResult r0 = com.revenuecat.purchases.VerificationResult.NOT_REQUESTED
        L_0x00ef:
            com.revenuecat.purchases.VerificationResult r1 = com.revenuecat.purchases.VerificationResult.FAILED
            if (r0 != r1) goto L_0x0104
            com.revenuecat.purchases.common.verification.SigningManager r1 = r8.signingManager
            com.revenuecat.purchases.common.verification.SignatureVerificationMode r1 = r1.getSignatureVerificationMode()
            boolean r1 = r1 instanceof com.revenuecat.purchases.common.verification.SignatureVerificationMode.Enforced
            if (r1 != 0) goto L_0x00fe
            goto L_0x0104
        L_0x00fe:
            com.revenuecat.purchases.common.verification.SignatureVerificationException r0 = new com.revenuecat.purchases.common.verification.SignatureVerificationException
            r0.<init>(r12)
            throw r0
        L_0x0104:
            com.revenuecat.purchases.common.networking.ETagManager r13 = r8.eTagManager
            java.net.URLConnection r7 = (java.net.URLConnection) r7
            java.lang.String r16 = r8.getETagHeader(r7)
            java.util.Date r19 = r8.getRequestDateHeader(r7)
            r14 = r10
            r1 = r15
            r15 = r18
            r17 = r1
            r18 = r27
            r20 = r0
            com.revenuecat.purchases.common.networking.HTTPResult r0 = r13.getHTTPResultFromCacheOrBackend$purchases_defaultsRelease(r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x011f:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "HTTP Response payload is null"
            r0.<init>(r1)
            throw r0
        L_0x0127:
            r0 = move-exception
            if (r1 == 0) goto L_0x012d
            r1.close()
        L_0x012d:
            r7.disconnect()
            throw r0
        L_0x0131:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.HTTPClient.performCall(java.net.URL, com.revenuecat.purchases.common.networking.Endpoint, java.util.Map, java.util.List, java.util.Map, boolean):com.revenuecat.purchases.common.networking.HTTPResult");
    }

    private final void trackHttpRequestPerformedIfNeeded(Endpoint endpoint, Date date, boolean z, HTTPResult hTTPResult) {
        VerificationResult verificationResult;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long between = DurationExtensionsKt.between(Duration.Companion, date, this.dateProvider.getNow());
            int responseCode = z ? hTTPResult != null ? hTTPResult.getResponseCode() : RCHTTPStatusCodes.NOT_MODIFIED : -1;
            HTTPResult.Origin origin = hTTPResult != null ? hTTPResult.getOrigin() : null;
            if (hTTPResult == null || (verificationResult = hTTPResult.getVerificationResult()) == null) {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            diagnosticsTracker.m1100trackHttpRequestPerformedNcHsxvU(endpoint, between, z && RCHTTPStatusCodes.INSTANCE.isSuccessful(responseCode), responseCode, origin, verificationResult);
        }
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$purchases_defaultsRelease();
    }

    private final Map<String, String> getHeaders(Map<String, String> map, String str, boolean z, String str2, boolean z2, String str3) {
        Pair[] pairArr = new Pair[14];
        pairArr[0] = TuplesKt.to("Content-Type", "application/json");
        pairArr[1] = TuplesKt.to("X-Platform", getXPlatformHeader());
        pairArr[2] = TuplesKt.to("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor());
        pairArr[3] = TuplesKt.to("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion());
        pairArr[4] = TuplesKt.to("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT));
        pairArr[5] = TuplesKt.to("X-Version", "7.6.0");
        pairArr[6] = TuplesKt.to("X-Client-Locale", this.appConfig.getLanguageTag());
        pairArr[7] = TuplesKt.to("X-Client-Version", this.appConfig.getVersionName());
        pairArr[8] = TuplesKt.to("X-Client-Bundle-ID", this.appConfig.getPackageName());
        boolean finishTransactions = this.appConfig.getFinishTransactions();
        String str4 = b.ac;
        pairArr[9] = TuplesKt.to("X-Observer-Mode-Enabled", finishTransactions ? "false" : str4);
        pairArr[10] = TuplesKt.to("X-Nonce", str2);
        pairArr[11] = TuplesKt.to(HTTPRequest.POST_PARAMS_HASH, str3);
        if (!this.appConfig.getCustomEntitlementComputation()) {
            str4 = null;
        }
        pairArr[12] = TuplesKt.to("X-Custom-Entitlements-Computation", str4);
        pairArr[13] = TuplesKt.to("X-Storefront", this.storefrontProvider.getStorefront());
        return MapExtensionsKt.filterNotNullValues(MapsKt.plus(MapsKt.plus(MapsKt.mapOf(pairArr), (Map) map), this.eTagManager.getETagHeaders$purchases_defaultsRelease(str, z2, z)));
    }

    private final HttpURLConnection getConnection(HTTPRequest hTTPRequest) {
        URLConnection openConnection = hTTPRequest.getFullURL().openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        for (Map.Entry next : hTTPRequest.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        JSONObject body = hTTPRequest.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(outputStream, "os");
            BufferedWriter buffer = buffer(outputStream);
            String jSONObject = body.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "body.toString()");
            writeFully(buffer, jSONObject);
        }
        return httpURLConnection;
    }

    private final String getXPlatformHeader() {
        return WhenMappings.$EnumSwitchMapping$0[this.appConfig.getStore().ordinal()] == 1 ? "amazon" : DeviceInfo.OS_NAME;
    }

    private final VerificationResult verifyResponse(String str, URLConnection uRLConnection, String str2, String str3, String str4) {
        return this.signingManager.verifyResponse(str, uRLConnection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), str3, str2, getRequestTimeHeader(uRLConnection), getETagHeader(uRLConnection), str4);
    }

    private final String getETagHeader(URLConnection uRLConnection) {
        return uRLConnection.getHeaderField("X-RevenueCat-ETag");
    }

    private final String getRequestTimeHeader(URLConnection uRLConnection) {
        String headerField = uRLConnection.getHeaderField(HTTPResult.REQUEST_TIME_HEADER_NAME);
        if (headerField == null || !(!StringsKt.isBlank(headerField))) {
            return null;
        }
        return headerField;
    }

    private final Date getRequestDateHeader(URLConnection uRLConnection) {
        String requestTimeHeader = getRequestTimeHeader(uRLConnection);
        if (requestTimeHeader != null) {
            return new Date(Long.parseLong(requestTimeHeader));
        }
        return null;
    }
}
