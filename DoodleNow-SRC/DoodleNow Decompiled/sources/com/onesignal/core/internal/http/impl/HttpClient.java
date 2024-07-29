package com.onesignal.core.internal.http.impl;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IInstallIdService;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J#\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J>\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\"0!H\u0002J?\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010$J?\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010$J!\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010(J!\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010(J!\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0017\u0010+\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020-H\u0002¢\u0006\u0002\u0010.R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/onesignal/core/internal/http/impl/HttpClient;", "Lcom/onesignal/core/internal/http/IHttpClient;", "_connectionFactory", "Lcom/onesignal/core/internal/http/impl/IHttpConnectionFactory;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_installIdService", "Lcom/onesignal/core/internal/device/IInstallIdService;", "(Lcom/onesignal/core/internal/http/impl/IHttpConnectionFactory;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/core/internal/device/IInstallIdService;)V", "delayNewRequestsUntil", "", "delete", "Lcom/onesignal/core/internal/http/HttpResponse;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "cacheKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThreadTimeout", "", "timeout", "logHTTPSent", "", "method", "Ljava/net/URL;", "jsonBody", "Lorg/json/JSONObject;", "headers", "", "", "makeRequest", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeRequestIODispatcher", "patch", "body", "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "put", "retryAfterFromResponse", "con", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;)Ljava/lang/Integer;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HttpClient.kt */
public final class HttpClient implements IHttpClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String OS_ACCEPT_HEADER = "application/vnd.onesignal.v1+json";
    private static final String OS_API_VERSION = "1";
    private static final int THREAD_ID = 10000;
    /* access modifiers changed from: private */
    public final ConfigModelStore _configModelStore;
    /* access modifiers changed from: private */
    public final IHttpConnectionFactory _connectionFactory;
    /* access modifiers changed from: private */
    public final IInstallIdService _installIdService;
    /* access modifiers changed from: private */
    public final IPreferencesService _prefs;
    /* access modifiers changed from: private */
    public final ITime _time;
    /* access modifiers changed from: private */
    public long delayNewRequestsUntil;

    private final int getThreadTimeout(int i) {
        return i + 5000;
    }

    public HttpClient(IHttpConnectionFactory iHttpConnectionFactory, IPreferencesService iPreferencesService, ConfigModelStore configModelStore, ITime iTime, IInstallIdService iInstallIdService) {
        Intrinsics.checkNotNullParameter(iHttpConnectionFactory, "_connectionFactory");
        Intrinsics.checkNotNullParameter(iPreferencesService, "_prefs");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(iInstallIdService, "_installIdService");
        this._connectionFactory = iHttpConnectionFactory;
        this._prefs = iPreferencesService;
        this._configModelStore = configModelStore;
        this._time = iTime;
        this._installIdService = iInstallIdService;
    }

    public Object post(String str, JSONObject jSONObject, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, ShareTarget.METHOD_POST, jSONObject, ((ConfigModel) this._configModelStore.getModel()).getHttpTimeout(), (String) null, continuation);
    }

    public Object get(String str, String str2, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, (String) null, (JSONObject) null, ((ConfigModel) this._configModelStore.getModel()).getHttpGetTimeout(), str2, continuation);
    }

    public Object put(String str, JSONObject jSONObject, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, "PUT", jSONObject, ((ConfigModel) this._configModelStore.getModel()).getHttpTimeout(), (String) null, continuation);
    }

    public Object patch(String str, JSONObject jSONObject, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, "PATCH", jSONObject, ((ConfigModel) this._configModelStore.getModel()).getHttpTimeout(), (String) null, continuation);
    }

    public Object delete(String str, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, "DELETE", (JSONObject) null, ((ConfigModel) this._configModelStore.getModel()).getHttpTimeout(), (String) null, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x013a, code lost:
        return new com.onesignal.core.internal.http.HttpResponse(0, (java.lang.String) null, r0, (java.lang.Integer) null, 8, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013c, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x0037, B:35:0x0108] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c A[ExcHandler: all (r0v10 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x012d A[PHI: r3 
      PHI: (r3v4 java.lang.Object) = (r3v5 java.lang.Object), (r3v1 java.lang.Object) binds: [B:37:0x012a, B:12:?] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object makeRequest(java.lang.String r22, java.lang.String r23, org.json.JSONObject r24, int r25, java.lang.String r26, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.http.HttpResponse> r27) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r23
            r3 = r27
            boolean r4 = r3 instanceof com.onesignal.core.internal.http.impl.HttpClient$makeRequest$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            com.onesignal.core.internal.http.impl.HttpClient$makeRequest$1 r4 = (com.onesignal.core.internal.http.impl.HttpClient$makeRequest$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            com.onesignal.core.internal.http.impl.HttpClient$makeRequest$1 r4 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequest$1
            r4.<init>(r1, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 2
            r8 = 1
            r9 = 0
            if (r6 == 0) goto L_0x006a
            if (r6 == r8) goto L_0x004b
            if (r6 != r7) goto L_0x0043
            java.lang.Object r0 = r4.L$0
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ TimeoutCancellationException -> 0x0040, all -> 0x003c }
            goto L_0x012d
        L_0x003c:
            r0 = move-exception
            r7 = r0
            goto L_0x012e
        L_0x0040:
            r0 = move-exception
            goto L_0x013d
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004b:
            int r0 = r4.I$0
            java.lang.Object r2 = r4.L$4
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r4.L$3
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            java.lang.Object r8 = r4.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r10 = r4.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r4.L$0
            com.onesignal.core.internal.http.impl.HttpClient r11 = (com.onesignal.core.internal.http.impl.HttpClient) r11
            kotlin.ResultKt.throwOnFailure(r3)
            r12 = r0
            r3 = r6
            r6 = r2
            r2 = r8
            goto L_0x00f2
        L_0x006a:
            kotlin.ResultKt.throwOnFailure(r3)
            if (r2 == 0) goto L_0x00c6
            com.onesignal.core.internal.config.ConfigModelStore r3 = r1._configModelStore
            com.onesignal.common.modeling.Model r3 = r3.getModel()
            com.onesignal.core.internal.config.ConfigModel r3 = (com.onesignal.core.internal.config.ConfigModel) r3
            java.lang.Boolean r3 = r3.getConsentRequired()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x00c6
            com.onesignal.core.internal.config.ConfigModelStore r3 = r1._configModelStore
            com.onesignal.common.modeling.Model r3 = r3.getModel()
            com.onesignal.core.internal.config.ConfigModel r3 = (com.onesignal.core.internal.config.ConfigModel) r3
            java.lang.Boolean r3 = r3.getConsentGiven()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 != 0) goto L_0x00c6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " `"
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = "` was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.privacyConsent"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.onesignal.debug.internal.logging.Logging.warn$default(r0, r9, r7, r9)
            com.onesignal.core.internal.http.HttpResponse r0 = new com.onesignal.core.internal.http.HttpResponse
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8
            r16 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)
            return r0
        L_0x00c6:
            long r10 = r1.delayNewRequestsUntil
            com.onesignal.core.internal.time.ITime r3 = r1._time
            long r12 = r3.getCurrentTimeMillis()
            long r10 = r10 - r12
            r12 = 0
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00fa
            r4.L$0 = r1
            r4.L$1 = r0
            r4.L$2 = r2
            r3 = r24
            r4.L$3 = r3
            r6 = r26
            r4.L$4 = r6
            r12 = r25
            r4.I$0 = r12
            r4.label = r8
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r10, r4)
            if (r8 != r5) goto L_0x00f0
            return r5
        L_0x00f0:
            r10 = r0
            r11 = r1
        L_0x00f2:
            r16 = r2
            r17 = r3
            r19 = r6
            r14 = r11
            goto L_0x0108
        L_0x00fa:
            r3 = r24
            r12 = r25
            r6 = r26
            r10 = r0
            r14 = r1
            r16 = r2
            r17 = r3
            r19 = r6
        L_0x0108:
            int r0 = r14.getThreadTimeout(r12)     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            long r2 = (long) r0     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            com.onesignal.core.internal.http.impl.HttpClient$makeRequest$2 r0 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequest$2     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            r20 = 0
            r13 = r0
            r15 = r10
            r18 = r12
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            r4.L$0 = r10     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            r4.L$1 = r9     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            r4.L$2 = r9     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            r4.L$3 = r9     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            r4.L$4 = r9     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            r4.label = r7     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            java.lang.Object r3 = kotlinx.coroutines.TimeoutKt.withTimeout(r2, r0, r4)     // Catch:{ TimeoutCancellationException -> 0x013b, all -> 0x003c }
            if (r3 != r5) goto L_0x012d
            return r5
        L_0x012d:
            return r3
        L_0x012e:
            com.onesignal.core.internal.http.HttpResponse r0 = new com.onesignal.core.internal.http.HttpResponse
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 8
            r10 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r0
        L_0x013b:
            r0 = move-exception
            r2 = r10
        L_0x013d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "HttpClient: Request timed out: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r6 = r0
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            com.onesignal.debug.internal.logging.Logging.error(r2, r6)
            com.onesignal.core.internal.http.HttpResponse r0 = new com.onesignal.core.internal.http.HttpResponse
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 8
            r9 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient.makeRequest(java.lang.String, java.lang.String, org.json.JSONObject, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object makeRequestIODispatcher(java.lang.String r19, java.lang.String r20, org.json.JSONObject r21, int r22, java.lang.String r23, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.http.HttpResponse> r24) {
        /*
            r18 = this;
            r0 = r24
            boolean r1 = r0 instanceof com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1 r1 = (com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r11 = r18
            goto L_0x001f
        L_0x0018:
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1 r1 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1
            r11 = r18
            r1.<init>(r11, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r13 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r13) goto L_0x0034
            java.lang.Object r1 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0089
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            r14 = r2
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            r15 = r2
            kotlin.coroutines.CoroutineContext r15 = (kotlin.coroutines.CoroutineContext) r15
            r16 = 0
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1 r17 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1
            r10 = 0
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r21
            r7 = r20
            r8 = r23
            r9 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r17
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = 2
            r4 = 0
            r19 = r14
            r20 = r15
            r21 = r16
            r22 = r2
            r23 = r3
            r24 = r4
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r19, r20, r21, r22, r23, r24)
            r1.L$0 = r0
            r1.label = r13
            java.lang.Object r1 = r2.join(r1)
            if (r1 != r12) goto L_0x0088
            return r12
        L_0x0088:
            r1 = r0
        L_0x0089:
            T r0 = r1.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher(java.lang.String, java.lang.String, org.json.JSONObject, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Integer retryAfterFromResponse(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.RETRY_AFTER);
        if (headerField != null) {
            Logging.debug$default("HttpClient: Response Retry-After: " + headerField, (Throwable) null, 2, (Object) null);
            Integer intOrNull = StringsKt.toIntOrNull(headerField);
            return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : ((ConfigModel) this._configModelStore.getModel()).getHttpRetryAfterParseFailFallback());
        } else if (httpURLConnection.getResponseCode() == 429) {
            return Integer.valueOf(((ConfigModel) this._configModelStore.getModel()).getHttpRetryAfterParseFailFallback());
        } else {
            Integer num = null;
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void logHTTPSent(String str, URL url, JSONObject jSONObject, Map<String, ? extends List<String>> map) {
        String joinToString$default = CollectionsKt.joinToString$default(map.entrySet(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        if (str == null) {
            str = ShareTarget.METHOD_GET;
        }
        String unescapedEUIDString = jSONObject != null ? JSONUtils.INSTANCE.toUnescapedEUIDString(jSONObject) : null;
        Logging.debug$default("HttpClient: Request Sent = " + str + ' ' + url + " - Body: " + unescapedEUIDString + " - Headers: " + joinToString$default, (Throwable) null, 2, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/core/internal/http/impl/HttpClient$Companion;", "", "()V", "OS_ACCEPT_HEADER", "", "OS_API_VERSION", "THREAD_ID", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HttpClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
