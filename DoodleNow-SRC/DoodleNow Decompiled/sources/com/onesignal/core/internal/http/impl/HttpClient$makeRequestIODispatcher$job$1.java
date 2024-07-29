package com.onesignal.core.internal.http.impl;

import com.onesignal.core.internal.http.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1", f = "HttpClient.kt", i = {0, 0}, l = {155}, m = "invokeSuspend", n = {"con", "httpResponse"}, s = {"L$0", "I$0"})
/* compiled from: HttpClient.kt */
final class HttpClient$makeRequestIODispatcher$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ JSONObject $jsonBody;
    final /* synthetic */ String $method;
    final /* synthetic */ Ref.ObjectRef<HttpResponse> $retVal;
    final /* synthetic */ int $timeout;
    final /* synthetic */ String $url;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpClient$makeRequestIODispatcher$job$1(HttpClient httpClient, String str, int i, JSONObject jSONObject, String str2, String str3, Ref.ObjectRef<HttpResponse> objectRef, Continuation<? super HttpClient$makeRequestIODispatcher$job$1> continuation) {
        super(2, continuation);
        this.this$0 = httpClient;
        this.$url = str;
        this.$timeout = i;
        this.$jsonBody = jSONObject;
        this.$method = str2;
        this.$cacheKey = str3;
        this.$retVal = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpClient$makeRequestIODispatcher$job$1(this.this$0, this.$url, this.$timeout, this.$jsonBody, this.$method, this.$cacheKey, this.$retVal, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HttpClient$makeRequestIODispatcher$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03ee, code lost:
        if (r13 != null) goto L_0x0394;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03f3, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0392, code lost:
        if (r13 != null) goto L_0x0394;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0394, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03a4 A[Catch:{ all -> 0x03f4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r32) {
        /*
            r31 = this;
            r1 = r31
            java.lang.String r0 = "OneSignal"
            java.lang.String r2 = "HttpClient: Got Response = Response has etag of "
            java.lang.String r3 = "HttpClient: Adding header if-none-match: "
            java.lang.String r4 = "onesignal/"
            java.lang.String r5 = "HttpClient: "
            java.lang.String r6 = "HttpClient: Could not send last request, device is offline. Throwable: "
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r8 = r1.label
            r9 = 0
            r10 = 1
            r11 = 2
            r12 = 0
            if (r8 == 0) goto L_0x003e
            if (r8 != r10) goto L_0x0036
            int r4 = r1.I$0
            java.lang.Object r7 = r1.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r1.L$1
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8
            java.lang.Object r13 = r1.L$0
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13
            kotlin.ResultKt.throwOnFailure(r32)     // Catch:{ all -> 0x0031 }
            r14 = r32
            goto L_0x00e3
        L_0x0031:
            r0 = move-exception
            r25 = r4
            goto L_0x03a0
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r32)
            r8 = r12
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8
            int r8 = android.os.Build.VERSION.SDK_INT
            r13 = 26
            if (r8 < r13) goto L_0x004f
            r8 = 10000(0x2710, float:1.4013E-41)
            android.net.TrafficStats.setThreadStatsTag(r8)
        L_0x004f:
            r8 = -1
            com.onesignal.core.internal.http.impl.HttpClient r13 = r1.this$0     // Catch:{ all -> 0x039c }
            com.onesignal.core.internal.http.impl.IHttpConnectionFactory r13 = r13._connectionFactory     // Catch:{ all -> 0x039c }
            java.lang.String r14 = r1.$url     // Catch:{ all -> 0x039c }
            java.net.HttpURLConnection r13 = r13.newHttpURLConnection(r14)     // Catch:{ all -> 0x039c }
            r13.setUseCaches(r9)     // Catch:{ all -> 0x0398 }
            int r14 = r1.$timeout     // Catch:{ all -> 0x0398 }
            r13.setConnectTimeout(r14)     // Catch:{ all -> 0x0398 }
            int r14 = r1.$timeout     // Catch:{ all -> 0x0398 }
            r13.setReadTimeout(r14)     // Catch:{ all -> 0x0398 }
            java.lang.String r14 = "SDK-Version"
            java.lang.String r15 = "onesignal/android/050115"
            r13.setRequestProperty(r14, r15)     // Catch:{ all -> 0x0398 }
            java.lang.String r14 = com.onesignal.common.OneSignalWrapper.getSdkType()     // Catch:{ all -> 0x0398 }
            if (r14 == 0) goto L_0x009d
            java.lang.String r14 = com.onesignal.common.OneSignalWrapper.getSdkVersion()     // Catch:{ all -> 0x0398 }
            if (r14 == 0) goto L_0x009d
            java.lang.String r14 = "SDK-Wrapper"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0398 }
            r15.<init>(r4)     // Catch:{ all -> 0x0398 }
            java.lang.String r4 = com.onesignal.common.OneSignalWrapper.getSdkType()     // Catch:{ all -> 0x0398 }
            r15.append(r4)     // Catch:{ all -> 0x0398 }
            r4 = 47
            r15.append(r4)     // Catch:{ all -> 0x0398 }
            java.lang.String r4 = com.onesignal.common.OneSignalWrapper.getSdkVersion()     // Catch:{ all -> 0x0398 }
            r15.append(r4)     // Catch:{ all -> 0x0398 }
            java.lang.String r4 = r15.toString()     // Catch:{ all -> 0x0398 }
            r13.setRequestProperty(r14, r4)     // Catch:{ all -> 0x0398 }
        L_0x009d:
            java.lang.String r4 = "Accept"
            java.lang.String r14 = "application/vnd.onesignal.v1+json"
            r13.setRequestProperty(r4, r14)     // Catch:{ all -> 0x0398 }
            com.onesignal.core.internal.http.impl.HttpClient r4 = r1.this$0     // Catch:{ all -> 0x0398 }
            com.onesignal.core.internal.config.ConfigModelStore r4 = r4._configModelStore     // Catch:{ all -> 0x0398 }
            com.onesignal.common.modeling.Model r4 = r4.getModel()     // Catch:{ all -> 0x0398 }
            com.onesignal.core.internal.config.ConfigModel r4 = (com.onesignal.core.internal.config.ConfigModel) r4     // Catch:{ all -> 0x0398 }
            java.lang.String r4 = r4.getPushSubscriptionId()     // Catch:{ all -> 0x0398 }
            if (r4 == 0) goto L_0x00c4
            r14 = r4
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ all -> 0x0398 }
            int r14 = r14.length()     // Catch:{ all -> 0x0398 }
            if (r14 <= 0) goto L_0x00c4
            java.lang.String r14 = "OneSignal-Subscription-Id"
            r13.setRequestProperty(r14, r4)     // Catch:{ all -> 0x0398 }
        L_0x00c4:
            java.lang.String r4 = "OneSignal-Install-Id"
            com.onesignal.core.internal.http.impl.HttpClient r14 = r1.this$0     // Catch:{ all -> 0x0398 }
            com.onesignal.core.internal.device.IInstallIdService r14 = r14._installIdService     // Catch:{ all -> 0x0398 }
            r15 = r1
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15     // Catch:{ all -> 0x0398 }
            r1.L$0 = r13     // Catch:{ all -> 0x0398 }
            r1.L$1 = r13     // Catch:{ all -> 0x0398 }
            r1.L$2 = r4     // Catch:{ all -> 0x0398 }
            r1.I$0 = r8     // Catch:{ all -> 0x0398 }
            r1.label = r10     // Catch:{ all -> 0x0398 }
            java.lang.Object r14 = r14.getId(r15)     // Catch:{ all -> 0x0398 }
            if (r14 != r7) goto L_0x00e0
            return r7
        L_0x00e0:
            r7 = r4
            r4 = r8
            r8 = r13
        L_0x00e3:
            java.util.UUID r14 = (java.util.UUID) r14     // Catch:{ all -> 0x0031 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0031 }
            r8.setRequestProperty(r7, r14)     // Catch:{ all -> 0x0031 }
            org.json.JSONObject r7 = r1.$jsonBody     // Catch:{ all -> 0x0031 }
            if (r7 == 0) goto L_0x00f3
            r13.setDoInput(r10)     // Catch:{ all -> 0x0031 }
        L_0x00f3:
            java.lang.String r7 = r1.$method     // Catch:{ all -> 0x0031 }
            if (r7 == 0) goto L_0x0106
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "application/json; charset=UTF-8"
            r13.setRequestProperty(r7, r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = r1.$method     // Catch:{ all -> 0x0031 }
            r13.setRequestMethod(r7)     // Catch:{ all -> 0x0031 }
            r13.setDoOutput(r10)     // Catch:{ all -> 0x0031 }
        L_0x0106:
            com.onesignal.core.internal.http.impl.HttpClient r7 = r1.this$0     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r13.getRequestMethod()     // Catch:{ all -> 0x0031 }
            java.net.URL r10 = r13.getURL()     // Catch:{ all -> 0x0031 }
            java.lang.String r14 = "con.url"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r14)     // Catch:{ all -> 0x0031 }
            org.json.JSONObject r14 = r1.$jsonBody     // Catch:{ all -> 0x0031 }
            java.util.Map r15 = r13.getRequestProperties()     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "con.requestProperties"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r9)     // Catch:{ all -> 0x0031 }
            r7.logHTTPSent(r8, r10, r14, r15)     // Catch:{ all -> 0x0031 }
            org.json.JSONObject r7 = r1.$jsonBody     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = "UTF-8"
            if (r7 == 0) goto L_0x014e
            com.onesignal.common.JSONUtils r7 = com.onesignal.common.JSONUtils.INSTANCE     // Catch:{ all -> 0x0031 }
            org.json.JSONObject r9 = r1.$jsonBody     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = r7.toUnescapedEUIDString(r9)     // Catch:{ all -> 0x0031 }
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r10 = "forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ all -> 0x0031 }
            byte[] r7 = r7.getBytes(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)     // Catch:{ all -> 0x0031 }
            int r9 = r7.length     // Catch:{ all -> 0x0031 }
            r13.setFixedLengthStreamingMode(r9)     // Catch:{ all -> 0x0031 }
            java.io.OutputStream r9 = r13.getOutputStream()     // Catch:{ all -> 0x0031 }
            r9.write(r7)     // Catch:{ all -> 0x0031 }
        L_0x014e:
            java.lang.String r7 = r1.$cacheKey     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "PREFS_OS_ETAG_PREFIX_"
            if (r7 == 0) goto L_0x018a
            com.onesignal.core.internal.http.impl.HttpClient r7 = r1.this$0     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.preferences.IPreferencesService r17 = r7._prefs     // Catch:{ all -> 0x0031 }
            java.lang.String r18 = "OneSignal"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r7.<init>(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r10 = r1.$cacheKey     // Catch:{ all -> 0x0031 }
            r7.append(r10)     // Catch:{ all -> 0x0031 }
            java.lang.String r19 = r7.toString()     // Catch:{ all -> 0x0031 }
            r20 = 0
            r21 = 4
            r22 = 0
            java.lang.String r7 = com.onesignal.core.internal.preferences.IPreferencesService.DefaultImpls.getString$default(r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0031 }
            if (r7 == 0) goto L_0x018a
            java.lang.String r10 = "if-none-match"
            r13.setRequestProperty(r10, r7)     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r10.<init>(r3)     // Catch:{ all -> 0x0031 }
            r10.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r10.toString()     // Catch:{ all -> 0x0031 }
            com.onesignal.debug.internal.logging.Logging.debug$default(r3, r12, r11, r12)     // Catch:{ all -> 0x0031 }
        L_0x018a:
            int r4 = r13.getResponseCode()     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.http.impl.HttpClient r3 = r1.this$0     // Catch:{ all -> 0x0031 }
            java.lang.Integer r21 = r3.retryAfterFromResponse(r13)     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.http.impl.HttpClient r3 = r1.this$0     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.time.ITime r3 = r3._time     // Catch:{ all -> 0x0031 }
            long r14 = r3.getCurrentTimeMillis()     // Catch:{ all -> 0x0031 }
            if (r21 == 0) goto L_0x01a5
            int r3 = r21.intValue()     // Catch:{ all -> 0x0031 }
            goto L_0x01a6
        L_0x01a5:
            r3 = 0
        L_0x01a6:
            int r3 = r3 * 1000
            long r11 = (long) r3     // Catch:{ all -> 0x0031 }
            long r14 = r14 + r11
            com.onesignal.core.internal.http.impl.HttpClient r3 = r1.this$0     // Catch:{ all -> 0x0031 }
            long r11 = r3.delayNewRequestsUntil     // Catch:{ all -> 0x0031 }
            int r3 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x01b9
            com.onesignal.core.internal.http.impl.HttpClient r3 = r1.this$0     // Catch:{ all -> 0x0031 }
            r3.delayNewRequestsUntil = r14     // Catch:{ all -> 0x0031 }
        L_0x01b9:
            r3 = 304(0x130, float:4.26E-43)
            r11 = 32
            java.lang.String r12 = "GET"
            java.lang.String r14 = "PREFS_OS_HTTP_CACHE_PREFIX_"
            java.lang.String r15 = "HttpClient: Got Response = "
            if (r4 == r3) goto L_0x032e
            java.lang.String r3 = " - Body: "
            java.lang.String r16 = ""
            java.lang.String r7 = "\\A"
            java.lang.String r10 = " - STATUS: "
            switch(r4) {
                case 200: goto L_0x0277;
                case 201: goto L_0x0277;
                case 202: goto L_0x0277;
                default: goto L_0x01d0;
            }
        L_0x01d0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r0.<init>(r15)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = r1.$method     // Catch:{ all -> 0x0031 }
            if (r2 != 0) goto L_0x01da
            goto L_0x01db
        L_0x01da:
            r12 = r2
        L_0x01db:
            r0.append(r12)     // Catch:{ all -> 0x0031 }
            r0.append(r11)     // Catch:{ all -> 0x0031 }
            java.net.URL r2 = r13.getURL()     // Catch:{ all -> 0x0031 }
            r0.append(r2)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = " - FAILED STATUS: "
            r0.append(r2)     // Catch:{ all -> 0x0031 }
            r0.append(r4)     // Catch:{ all -> 0x0031 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0031 }
            r2 = 2
            r9 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r9, r2, r9)     // Catch:{ all -> 0x0031 }
            java.io.InputStream r0 = r13.getErrorStream()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0203
            java.io.InputStream r0 = r13.getInputStream()     // Catch:{ all -> 0x0031 }
        L_0x0203:
            r12 = r9
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0242
            java.util.Scanner r11 = new java.util.Scanner     // Catch:{ all -> 0x0031 }
            r11.<init>(r0, r8)     // Catch:{ all -> 0x0031 }
            java.util.Scanner r0 = r11.useDelimiter(r7)     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.hasNext()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x021b
            java.lang.String r16 = r11.next()     // Catch:{ all -> 0x0031 }
        L_0x021b:
            r0 = r16
            r11.close()     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r7.<init>(r15)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r1.$method     // Catch:{ all -> 0x0031 }
            r7.append(r8)     // Catch:{ all -> 0x0031 }
            r7.append(r10)     // Catch:{ all -> 0x0031 }
            r7.append(r4)     // Catch:{ all -> 0x0031 }
            r7.append(r3)     // Catch:{ all -> 0x0031 }
            r7.append(r0)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0031 }
            r2 = 2
            r7 = 0
            com.onesignal.debug.internal.logging.Logging.warn$default(r3, r7, r2, r7)     // Catch:{ all -> 0x0031 }
            r19 = r0
            goto L_0x0262
        L_0x0242:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r0.<init>(r15)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r1.$method     // Catch:{ all -> 0x0031 }
            r0.append(r3)     // Catch:{ all -> 0x0031 }
            r0.append(r10)     // Catch:{ all -> 0x0031 }
            r0.append(r4)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = " - No response body!"
            r0.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0031 }
            r2 = 2
            r3 = 0
            com.onesignal.debug.internal.logging.Logging.warn$default(r0, r3, r2, r3)     // Catch:{ all -> 0x0031 }
            r19 = 0
        L_0x0262:
            kotlin.jvm.internal.Ref$ObjectRef<com.onesignal.core.internal.http.HttpResponse> r0 = r1.$retVal     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.http.HttpResponse r2 = new com.onesignal.core.internal.http.HttpResponse     // Catch:{ all -> 0x0031 }
            r20 = 0
            r22 = 4
            r23 = 0
            r17 = r2
            r18 = r4
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0031 }
            r0.element = r2     // Catch:{ all -> 0x0031 }
            goto L_0x0392
        L_0x0277:
            java.io.InputStream r11 = r13.getInputStream()     // Catch:{ all -> 0x0031 }
            r17 = r12
            java.util.Scanner r12 = new java.util.Scanner     // Catch:{ all -> 0x0031 }
            r12.<init>(r11, r8)     // Catch:{ all -> 0x0031 }
            java.util.Scanner r7 = r12.useDelimiter(r7)     // Catch:{ all -> 0x0031 }
            boolean r7 = r7.hasNext()     // Catch:{ all -> 0x0031 }
            if (r7 == 0) goto L_0x0292
            java.lang.String r7 = r12.next()     // Catch:{ all -> 0x0031 }
            r8 = r7
            goto L_0x0294
        L_0x0292:
            r8 = r16
        L_0x0294:
            r12.close()     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r7.<init>(r15)     // Catch:{ all -> 0x0031 }
            java.lang.String r11 = r1.$method     // Catch:{ all -> 0x0031 }
            if (r11 != 0) goto L_0x02a3
            r12 = r17
            goto L_0x02a4
        L_0x02a3:
            r12 = r11
        L_0x02a4:
            r7.append(r12)     // Catch:{ all -> 0x0031 }
            r11 = 32
            r7.append(r11)     // Catch:{ all -> 0x0031 }
            java.net.URL r11 = r13.getURL()     // Catch:{ all -> 0x0031 }
            r7.append(r11)     // Catch:{ all -> 0x0031 }
            r7.append(r10)     // Catch:{ all -> 0x0031 }
            r7.append(r4)     // Catch:{ all -> 0x0031 }
            r7.append(r3)     // Catch:{ all -> 0x0031 }
            r7.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0031 }
            r7 = 2
            r10 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r3, r10, r7, r10)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r1.$cacheKey     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0318
            java.lang.String r3 = "etag"
            java.lang.String r3 = r13.getHeaderField(r3)     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0318
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r11.<init>(r2)     // Catch:{ all -> 0x0031 }
            r11.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = " so caching the response."
            r11.append(r2)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = r11.toString()     // Catch:{ all -> 0x0031 }
            r7 = 2
            r10 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r2, r10, r7, r10)     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.http.impl.HttpClient r2 = r1.this$0     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.preferences.IPreferencesService r2 = r2._prefs     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r11.<init>(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = r1.$cacheKey     // Catch:{ all -> 0x0031 }
            r11.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x0031 }
            r2.saveString(r0, r9, r3)     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.http.impl.HttpClient r2 = r1.this$0     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.preferences.IPreferencesService r2 = r2._prefs     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r3.<init>(r14)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = r1.$cacheKey     // Catch:{ all -> 0x0031 }
            r3.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0031 }
            r2.saveString(r0, r3, r8)     // Catch:{ all -> 0x0031 }
        L_0x0318:
            kotlin.jvm.internal.Ref$ObjectRef<com.onesignal.core.internal.http.HttpResponse> r0 = r1.$retVal     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.http.HttpResponse r2 = new com.onesignal.core.internal.http.HttpResponse     // Catch:{ all -> 0x0031 }
            r20 = 0
            r22 = 4
            r23 = 0
            r17 = r2
            r18 = r4
            r19 = r8
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0031 }
            r0.element = r2     // Catch:{ all -> 0x0031 }
            goto L_0x0392
        L_0x032e:
            r17 = r12
            com.onesignal.core.internal.http.impl.HttpClient r0 = r1.this$0     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.preferences.IPreferencesService r22 = r0._prefs     // Catch:{ all -> 0x0031 }
            java.lang.String r23 = "OneSignal"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r0.<init>(r14)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = r1.$cacheKey     // Catch:{ all -> 0x0031 }
            r0.append(r2)     // Catch:{ all -> 0x0031 }
            java.lang.String r24 = r0.toString()     // Catch:{ all -> 0x0031 }
            r25 = 0
            r26 = 4
            r27 = 0
            java.lang.String r0 = com.onesignal.core.internal.preferences.IPreferencesService.DefaultImpls.getString$default(r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r2.<init>(r15)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = r1.$method     // Catch:{ all -> 0x0031 }
            if (r3 != 0) goto L_0x035c
            r12 = r17
            goto L_0x035d
        L_0x035c:
            r12 = r3
        L_0x035d:
            r2.append(r12)     // Catch:{ all -> 0x0031 }
            r3 = 32
            r2.append(r3)     // Catch:{ all -> 0x0031 }
            java.net.URL r3 = r13.getURL()     // Catch:{ all -> 0x0031 }
            r2.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = " - Using Cached response due to 304: "
            r2.append(r3)     // Catch:{ all -> 0x0031 }
            r2.append(r0)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0031 }
            r3 = 2
            r7 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r2, r7, r3, r7)     // Catch:{ all -> 0x0031 }
            kotlin.jvm.internal.Ref$ObjectRef<com.onesignal.core.internal.http.HttpResponse> r2 = r1.$retVal     // Catch:{ all -> 0x0031 }
            com.onesignal.core.internal.http.HttpResponse r3 = new com.onesignal.core.internal.http.HttpResponse     // Catch:{ all -> 0x0031 }
            r20 = 0
            r22 = 4
            r23 = 0
            r17 = r3
            r18 = r4
            r19 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0031 }
            r2.element = r3     // Catch:{ all -> 0x0031 }
        L_0x0392:
            if (r13 == 0) goto L_0x03f1
        L_0x0394:
            r13.disconnect()
            goto L_0x03f1
        L_0x0398:
            r0 = move-exception
            r25 = r8
            goto L_0x03a0
        L_0x039c:
            r0 = move-exception
            r25 = r8
            r13 = 0
        L_0x03a0:
            boolean r2 = r0 instanceof java.net.ConnectException     // Catch:{ all -> 0x03f4 }
            if (r2 != 0) goto L_0x03c0
            boolean r2 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x03f4 }
            if (r2 == 0) goto L_0x03a9
            goto L_0x03c0
        L_0x03a9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f4 }
            r2.<init>(r5)     // Catch:{ all -> 0x03f4 }
            java.lang.String r3 = r1.$method     // Catch:{ all -> 0x03f4 }
            r2.append(r3)     // Catch:{ all -> 0x03f4 }
            java.lang.String r3 = " Error thrown from network stack. "
            r2.append(r3)     // Catch:{ all -> 0x03f4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03f4 }
            com.onesignal.debug.internal.logging.Logging.warn(r2, r0)     // Catch:{ all -> 0x03f4 }
            goto L_0x03d9
        L_0x03c0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f4 }
            r2.<init>(r6)     // Catch:{ all -> 0x03f4 }
            java.lang.Class r3 = r0.getClass()     // Catch:{ all -> 0x03f4 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x03f4 }
            r2.append(r3)     // Catch:{ all -> 0x03f4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03f4 }
            r3 = 2
            r4 = 0
            com.onesignal.debug.internal.logging.Logging.info$default(r2, r4, r3, r4)     // Catch:{ all -> 0x03f4 }
        L_0x03d9:
            kotlin.jvm.internal.Ref$ObjectRef<com.onesignal.core.internal.http.HttpResponse> r2 = r1.$retVal     // Catch:{ all -> 0x03f4 }
            com.onesignal.core.internal.http.HttpResponse r3 = new com.onesignal.core.internal.http.HttpResponse     // Catch:{ all -> 0x03f4 }
            r26 = 0
            r28 = 0
            r29 = 8
            r30 = 0
            r24 = r3
            r27 = r0
            r24.<init>(r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x03f4 }
            r2.element = r3     // Catch:{ all -> 0x03f4 }
            if (r13 == 0) goto L_0x03f1
            goto L_0x0394
        L_0x03f1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x03f4:
            r0 = move-exception
            if (r13 == 0) goto L_0x03fa
            r13.disconnect()
        L_0x03fa:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
