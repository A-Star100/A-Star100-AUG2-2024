package com.onesignal.user.internal.backend.impl;

import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.IUserBackendService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JO\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/UserBackendService;", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "createUser", "Lcom/onesignal/user/internal/backend/CreateUserResponse;", "appId", "", "identities", "", "subscriptions", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "properties", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "aliasLabel", "aliasValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "refreshDeviceMetadata", "", "propertyiesDelta", "Lcom/onesignal/user/internal/backend/PropertiesDeltasObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/PropertiesObject;ZLcom/onesignal/user/internal/backend/PropertiesDeltasObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserBackendService.kt */
public final class UserBackendService implements IUserBackendService {
    private final IHttpClient _httpClient;

    public UserBackendService(IHttpClient iHttpClient) {
        Intrinsics.checkNotNullParameter(iHttpClient, "_httpClient");
        this._httpClient = iHttpClient;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createUser(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.util.List<com.onesignal.user.internal.backend.SubscriptionObject> r7, java.util.Map<java.lang.String, java.lang.String> r8, kotlin.coroutines.Continuation<? super com.onesignal.user.internal.backend.CreateUserResponse> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1 r0 = (com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1 r0 = new com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1
            r0.<init>(r4, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009c
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            boolean r2 = r6.isEmpty()
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x004f
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r6 = com.onesignal.common.JSONObjectExtensionsKt.putMap(r2, r6)
            java.lang.String r2 = "identity"
            r9.put(r2, r6)
        L_0x004f:
            r6 = r7
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0064
            com.onesignal.user.internal.backend.impl.JSONConverter r6 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONArray r6 = r6.convertToJSON((java.util.List<com.onesignal.user.internal.backend.SubscriptionObject>) r7)
            java.lang.String r7 = "subscriptions"
            r9.put(r7, r6)
        L_0x0064:
            boolean r6 = r8.isEmpty()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0079
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            org.json.JSONObject r6 = com.onesignal.common.JSONObjectExtensionsKt.putMap(r6, r8)
            java.lang.String r7 = "properties"
            r9.put(r7, r6)
        L_0x0079:
            java.lang.String r6 = "refresh_device_metadata"
            r9.put(r6, r3)
            com.onesignal.core.internal.http.IHttpClient r6 = r4._httpClient
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "apps/"
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r5 = "/users"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.label = r3
            java.lang.Object r9 = r6.post(r5, r9, r0)
            if (r9 != r1) goto L_0x009c
            return r1
        L_0x009c:
            com.onesignal.core.internal.http.HttpResponse r9 = (com.onesignal.core.internal.http.HttpResponse) r9
            boolean r5 = r9.isSuccess()
            if (r5 == 0) goto L_0x00b7
            com.onesignal.user.internal.backend.impl.JSONConverter r5 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r6 = new org.json.JSONObject
            java.lang.String r7 = r9.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r6.<init>(r7)
            com.onesignal.user.internal.backend.CreateUserResponse r5 = r5.convertToCreateUserResponse(r6)
            return r5
        L_0x00b7:
            com.onesignal.common.exceptions.BackendException r5 = new com.onesignal.common.exceptions.BackendException
            int r6 = r9.getStatusCode()
            java.lang.String r7 = r9.getPayload()
            java.lang.Integer r8 = r9.getRetryAfterSeconds()
            r5.<init>(r6, r7, r8)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.UserBackendService.createUser(java.lang.String, java.util.Map, java.util.List, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateUser(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.onesignal.user.internal.backend.PropertiesObject r8, boolean r9, com.onesignal.user.internal.backend.PropertiesDeltasObject r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r4 = this;
            boolean r0 = r11 instanceof com.onesignal.user.internal.backend.impl.UserBackendService$updateUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.user.internal.backend.impl.UserBackendService$updateUser$1 r0 = (com.onesignal.user.internal.backend.impl.UserBackendService$updateUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.user.internal.backend.impl.UserBackendService$updateUser$1 r0 = new com.onesignal.user.internal.backend.impl.UserBackendService$updateUser$1
            r0.<init>(r4, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0090
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r11)
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
            java.lang.String r2 = "refresh_device_metadata"
            org.json.JSONObject r9 = r11.put(r2, r9)
            boolean r11 = r8.getHasAtLeastOnePropertySet()
            if (r11 == 0) goto L_0x0051
            com.onesignal.user.internal.backend.impl.JSONConverter r11 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r8 = r11.convertToJSON((com.onesignal.user.internal.backend.PropertiesObject) r8)
            java.lang.String r11 = "properties"
            r9.put(r11, r8)
        L_0x0051:
            boolean r8 = r10.getHasAtLeastOnePropertySet()
            if (r8 == 0) goto L_0x0062
            com.onesignal.user.internal.backend.impl.JSONConverter r8 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r8 = r8.convertToJSON((com.onesignal.user.internal.backend.PropertiesDeltasObject) r10)
            java.lang.String r10 = "deltas"
            r9.put(r10, r8)
        L_0x0062:
            com.onesignal.core.internal.http.IHttpClient r8 = r4._httpClient
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "apps/"
            r10.<init>(r11)
            r10.append(r5)
            java.lang.String r5 = "/users/by/"
            r10.append(r5)
            r10.append(r6)
            r5 = 47
            r10.append(r5)
            r10.append(r7)
            java.lang.String r5 = r10.toString()
            java.lang.String r6 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
            r0.label = r3
            java.lang.Object r11 = r8.patch(r5, r9, r0)
            if (r11 != r1) goto L_0x0090
            return r1
        L_0x0090:
            com.onesignal.core.internal.http.HttpResponse r11 = (com.onesignal.core.internal.http.HttpResponse) r11
            boolean r5 = r11.isSuccess()
            if (r5 == 0) goto L_0x009b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x009b:
            com.onesignal.common.exceptions.BackendException r5 = new com.onesignal.common.exceptions.BackendException
            int r6 = r11.getStatusCode()
            java.lang.String r7 = r11.getPayload()
            java.lang.Integer r8 = r11.getRetryAfterSeconds()
            r5.<init>(r6, r7, r8)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.UserBackendService.updateUser(java.lang.String, java.lang.String, java.lang.String, com.onesignal.user.internal.backend.PropertiesObject, boolean, com.onesignal.user.internal.backend.PropertiesDeltasObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getUser(java.lang.String r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super com.onesignal.user.internal.backend.CreateUserResponse> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1 r0 = (com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1 r0 = new com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1
            r0.<init>(r7, r11)
        L_0x0019:
            r4 = r0
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0063
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r3 = "apps/"
            r11.<init>(r3)
            r11.append(r8)
            java.lang.String r8 = "/users/by/"
            r11.append(r8)
            r11.append(r9)
            r8 = 47
            r11.append(r8)
            r11.append(r10)
            java.lang.String r8 = r11.toString()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r2 = r8
            java.lang.Object r11 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.get$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L_0x0063
            return r0
        L_0x0063:
            com.onesignal.core.internal.http.HttpResponse r11 = (com.onesignal.core.internal.http.HttpResponse) r11
            boolean r8 = r11.isSuccess()
            if (r8 == 0) goto L_0x007b
            com.onesignal.user.internal.backend.impl.JSONConverter r8 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r9 = new org.json.JSONObject
            java.lang.String r10 = r11.getPayload()
            r9.<init>(r10)
            com.onesignal.user.internal.backend.CreateUserResponse r8 = r8.convertToCreateUserResponse(r9)
            return r8
        L_0x007b:
            com.onesignal.common.exceptions.BackendException r8 = new com.onesignal.common.exceptions.BackendException
            int r9 = r11.getStatusCode()
            java.lang.String r10 = r11.getPayload()
            java.lang.Integer r11 = r11.getRetryAfterSeconds()
            r8.<init>(r9, r10, r11)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.UserBackendService.getUser(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
