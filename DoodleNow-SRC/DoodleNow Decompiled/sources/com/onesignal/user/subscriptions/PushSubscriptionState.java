package com.onesignal.user.subscriptions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/onesignal/user/subscriptions/PushSubscriptionState;", "", "id", "", "token", "optedIn", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getOptedIn", "()Z", "getToken", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PushSubscriptionState.kt */
public final class PushSubscriptionState {
    private final String id;
    private final boolean optedIn;
    private final String token;

    public final String getId() {
        return this.id;
    }

    public final boolean getOptedIn() {
        return this.optedIn;
    }

    public final String getToken() {
        return this.token;
    }

    public PushSubscriptionState(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "token");
        this.id = str;
        this.token = str2;
        this.optedIn = z;
    }

    public final JSONObject toJSONObject() {
        JSONObject put = new JSONObject().put("id", this.id).put("token", this.token).put("optedIn", this.optedIn);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           … .put(\"optedIn\", optedIn)");
        return put;
    }
}
