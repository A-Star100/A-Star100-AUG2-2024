package com.onesignal.core.internal.backend.impl;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.backend.InfluenceParamsObject;
import com.onesignal.core.internal.http.IHttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/onesignal/core/internal/backend/impl/ParamsBackendService;", "Lcom/onesignal/core/internal/backend/IParamsBackendService;", "_http", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "fetchParams", "Lcom/onesignal/core/internal/backend/ParamsObject;", "appId", "", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processOutcomeJson", "Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "outcomeJson", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ParamsBackendService.kt */
public final class ParamsBackendService implements IParamsBackendService {
    private final IHttpClient _http;

    public ParamsBackendService(IHttpClient iHttpClient) {
        Intrinsics.checkNotNullParameter(iHttpClient, "_http");
        this._http = iHttpClient;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchParams(java.lang.String r31, java.lang.String r32, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.backend.ParamsObject> r33) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            boolean r4 = r3 instanceof com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$1 r4 = (com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$1 r4 = new com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 1
            if (r6 == 0) goto L_0x003e
            if (r6 != r7) goto L_0x0036
            java.lang.Object r1 = r4.L$0
            com.onesignal.core.internal.backend.impl.ParamsBackendService r1 = (com.onesignal.core.internal.backend.impl.ParamsBackendService) r1
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x00a2
        L_0x0036:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r3)
            com.onesignal.debug.LogLevel r3 = com.onesignal.debug.LogLevel.DEBUG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "ParamsBackendService.fetchParams(appId: "
            r6.<init>(r8)
            r6.append(r1)
            java.lang.String r8 = ", subscriptionId: "
            r6.append(r8)
            r6.append(r2)
            r8 = 41
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            com.onesignal.debug.internal.logging.Logging.log(r3, r6)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "apps/"
            r3.<init>(r6)
            r3.append(r1)
            java.lang.String r1 = "/android_params.js"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            if (r2 == 0) goto L_0x0092
            com.onesignal.common.IDManager r3 = com.onesignal.common.IDManager.INSTANCE
            boolean r3 = r3.isLocalId(r2)
            if (r3 != 0) goto L_0x0092
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = "?player_id="
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
        L_0x0092:
            com.onesignal.core.internal.http.IHttpClient r2 = r0._http
            r4.L$0 = r0
            r4.label = r7
            java.lang.String r3 = "CACHE_KEY_REMOTE_PARAMS"
            java.lang.Object r3 = r2.get(r1, r3, r4)
            if (r3 != r5) goto L_0x00a1
            return r5
        L_0x00a1:
            r1 = r0
        L_0x00a2:
            com.onesignal.core.internal.http.HttpResponse r3 = (com.onesignal.core.internal.http.HttpResponse) r3
            boolean r2 = r3.isSuccess()
            if (r2 == 0) goto L_0x0169
            org.json.JSONObject r2 = new org.json.JSONObject
            java.lang.String r3 = r3.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r2.<init>(r3)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$2 r4 = new com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$2
            r4.<init>(r3, r1)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.String r1 = "outcomes"
            com.onesignal.common.JSONObjectExtensionsKt.expandJSONObject(r2, r1, r4)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$3 r4 = new com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$3
            r4.<init>(r1)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.String r5 = "fcm"
            com.onesignal.common.JSONObjectExtensionsKt.expandJSONObject(r2, r5, r4)
            com.onesignal.core.internal.backend.ParamsObject r4 = new com.onesignal.core.internal.backend.ParamsObject
            java.lang.String r5 = "android_sender_id"
            java.lang.String r7 = com.onesignal.common.JSONObjectExtensionsKt.safeString(r2, r5)
            java.lang.String r5 = "enterp"
            java.lang.Boolean r8 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "require_ident_auth"
            java.lang.Boolean r9 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "chnl_lst"
            org.json.JSONArray r10 = r2.optJSONArray(r5)
            java.lang.String r5 = "fba"
            java.lang.Boolean r11 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "restore_ttl_filter"
            java.lang.Boolean r12 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "clear_group_on_summary_click"
            java.lang.Boolean r13 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "receive_receipts_enable"
            java.lang.Boolean r14 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "disable_gms_missing_prompt"
            java.lang.Boolean r15 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "unsubscribe_on_notifications_disabled"
            java.lang.Boolean r16 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "location_shared"
            java.lang.Boolean r17 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "requires_user_privacy_consent"
            java.lang.Boolean r18 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r2, r5)
            java.lang.String r5 = "oprepo_execution_interval"
            java.lang.Long r19 = com.onesignal.common.JSONObjectExtensionsKt.safeLong(r2, r5)
            T r2 = r3.element
            com.onesignal.core.internal.backend.InfluenceParamsObject r2 = (com.onesignal.core.internal.backend.InfluenceParamsObject) r2
            if (r2 != 0) goto L_0x0148
            com.onesignal.core.internal.backend.InfluenceParamsObject r2 = new com.onesignal.core.internal.backend.InfluenceParamsObject
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 127(0x7f, float:1.78E-43)
            r29 = 0
            r20 = r2
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29)
            goto L_0x014a
        L_0x0148:
            r20 = r2
        L_0x014a:
            T r1 = r1.element
            com.onesignal.core.internal.backend.FCMParamsObject r1 = (com.onesignal.core.internal.backend.FCMParamsObject) r1
            if (r1 != 0) goto L_0x0162
            com.onesignal.core.internal.backend.FCMParamsObject r1 = new com.onesignal.core.internal.backend.FCMParamsObject
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 7
            r26 = 0
            r21 = r1
            r21.<init>(r22, r23, r24, r25, r26)
            goto L_0x0164
        L_0x0162:
            r21 = r1
        L_0x0164:
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r4
        L_0x0169:
            com.onesignal.common.exceptions.BackendException r1 = new com.onesignal.common.exceptions.BackendException
            int r2 = r3.getStatusCode()
            java.lang.String r4 = r3.getPayload()
            java.lang.Integer r3 = r3.getRetryAfterSeconds()
            r1.<init>(r2, r4, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.backend.impl.ParamsBackendService.fetchParams(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final InfluenceParamsObject processOutcomeJson(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
        JSONObjectExtensionsKt.expandJSONObject(jSONObject2, "direct", new ParamsBackendService$processOutcomeJson$1(objectRef5));
        JSONObjectExtensionsKt.expandJSONObject(jSONObject2, "indirect", new ParamsBackendService$processOutcomeJson$2(objectRef6, objectRef, objectRef2, objectRef3, objectRef4));
        JSONObjectExtensionsKt.expandJSONObject(jSONObject2, "unattributed", new ParamsBackendService$processOutcomeJson$3(objectRef7));
        return new InfluenceParamsObject((Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element, (Integer) objectRef4.element, (Boolean) objectRef5.element, (Boolean) objectRef6.element, (Boolean) objectRef7.element);
    }
}
