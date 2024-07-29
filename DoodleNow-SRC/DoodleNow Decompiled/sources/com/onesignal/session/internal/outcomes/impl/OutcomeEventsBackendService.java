package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.core.internal.http.IHttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JC\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsBackendService;", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;", "_http", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "sendOutcomeEvent", "", "appId", "", "userId", "subscriptionId", "deviceType", "direct", "", "event", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutcomeEventsBackendService.kt */
public final class OutcomeEventsBackendService implements IOutcomeEventsBackendService {
    private final IHttpClient _http;

    public OutcomeEventsBackendService(IHttpClient iHttpClient) {
        Intrinsics.checkNotNullParameter(iHttpClient, "_http");
        this._http = iHttpClient;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendOutcomeEvent(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Boolean r11, com.onesignal.session.internal.outcomes.impl.OutcomeEvent r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r6 = this;
            boolean r0 = r13 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService$sendOutcomeEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService$sendOutcomeEvent$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService$sendOutcomeEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService$sendOutcomeEvent$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService$sendOutcomeEvent$1
            r0.<init>(r6, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00d5
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r13)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r2 = "app_id"
            org.json.JSONObject r7 = r13.put(r2, r7)
            java.lang.String r13 = "onesignal_id"
            org.json.JSONObject r7 = r7.put(r13, r8)
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r13 = "id"
            org.json.JSONObject r8 = r8.put(r13, r9)
            java.lang.String r9 = "type"
            org.json.JSONObject r8 = r8.put(r9, r10)
            java.lang.String r9 = "subscription"
            org.json.JSONObject r7 = r7.put(r9, r8)
            if (r11 == 0) goto L_0x0069
            java.lang.String r8 = "direct"
            boolean r9 = r11.booleanValue()
            r7.put(r8, r9)
        L_0x0069:
            org.json.JSONArray r8 = r12.getNotificationIds()
            if (r8 == 0) goto L_0x0082
            org.json.JSONArray r8 = r12.getNotificationIds()
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0082
            java.lang.String r8 = "notification_ids"
            org.json.JSONArray r9 = r12.getNotificationIds()
            r7.put(r8, r9)
        L_0x0082:
            java.lang.String r8 = r12.getName()
            r7.put(r13, r8)
            float r8 = r12.getWeight()
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 <= 0) goto L_0x009f
            float r8 = r12.getWeight()
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            java.lang.String r9 = "weight"
            r7.put(r9, r8)
        L_0x009f:
            long r8 = r12.getTimestamp()
            r10 = 0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x00b2
            java.lang.String r8 = "timestamp"
            long r4 = r12.getTimestamp()
            r7.put(r8, r4)
        L_0x00b2:
            long r8 = r12.getSessionTime()
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c3
            java.lang.String r8 = "session_time"
            long r9 = r12.getSessionTime()
            r7.put(r8, r9)
        L_0x00c3:
            com.onesignal.core.internal.http.IHttpClient r8 = r6._http
            java.lang.String r9 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            r0.label = r3
            java.lang.String r9 = "outcomes/measure"
            java.lang.Object r13 = r8.post(r9, r7, r0)
            if (r13 != r1) goto L_0x00d5
            return r1
        L_0x00d5:
            com.onesignal.core.internal.http.HttpResponse r13 = (com.onesignal.core.internal.http.HttpResponse) r13
            boolean r7 = r13.isSuccess()
            if (r7 == 0) goto L_0x00e0
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00e0:
            com.onesignal.common.exceptions.BackendException r7 = new com.onesignal.common.exceptions.BackendException
            int r8 = r13.getStatusCode()
            java.lang.String r9 = r13.getPayload()
            java.lang.Integer r10 = r13.getRetryAfterSeconds()
            r7.<init>(r8, r9, r10)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService.sendOutcomeEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, com.onesignal.session.internal.outcomes.impl.OutcomeEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
