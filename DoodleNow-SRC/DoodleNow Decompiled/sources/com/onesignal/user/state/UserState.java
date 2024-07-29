package com.onesignal.user.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/onesignal/user/state/UserState;", "", "onesignalId", "", "externalId", "(Ljava/lang/String;Ljava/lang/String;)V", "getExternalId", "()Ljava/lang/String;", "getOnesignalId", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserState.kt */
public final class UserState {
    private final String externalId;
    private final String onesignalId;

    public final String getExternalId() {
        return this.externalId;
    }

    public final String getOnesignalId() {
        return this.onesignalId;
    }

    public UserState(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "onesignalId");
        Intrinsics.checkNotNullParameter(str2, "externalId");
        this.onesignalId = str;
        this.externalId = str2;
    }

    public final JSONObject toJSONObject() {
        JSONObject put = new JSONObject().put("onesignalId", this.onesignalId).put("externalId", this.externalId);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …\"externalId\", externalId)");
        return put;
    }
}
