package com.onesignal.user.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/onesignal/user/state/UserChangedState;", "", "current", "Lcom/onesignal/user/state/UserState;", "(Lcom/onesignal/user/state/UserState;)V", "getCurrent", "()Lcom/onesignal/user/state/UserState;", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserChangedState.kt */
public final class UserChangedState {
    private final UserState current;

    public final UserState getCurrent() {
        return this.current;
    }

    public UserChangedState(UserState userState) {
        Intrinsics.checkNotNullParameter(userState, "current");
        this.current = userState;
    }

    public final JSONObject toJSONObject() {
        JSONObject put = new JSONObject().put("current", this.current.toJSONObject());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …, current.toJSONObject())");
        return put;
    }
}
