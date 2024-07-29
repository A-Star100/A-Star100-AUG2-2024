package com.onesignal.user.subscriptions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/onesignal/user/subscriptions/PushSubscriptionChangedState;", "", "previous", "Lcom/onesignal/user/subscriptions/PushSubscriptionState;", "current", "(Lcom/onesignal/user/subscriptions/PushSubscriptionState;Lcom/onesignal/user/subscriptions/PushSubscriptionState;)V", "getCurrent", "()Lcom/onesignal/user/subscriptions/PushSubscriptionState;", "getPrevious", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PushSubscriptionChangedState.kt */
public final class PushSubscriptionChangedState {
    private final PushSubscriptionState current;
    private final PushSubscriptionState previous;

    public final PushSubscriptionState getCurrent() {
        return this.current;
    }

    public final PushSubscriptionState getPrevious() {
        return this.previous;
    }

    public PushSubscriptionChangedState(PushSubscriptionState pushSubscriptionState, PushSubscriptionState pushSubscriptionState2) {
        Intrinsics.checkNotNullParameter(pushSubscriptionState, "previous");
        Intrinsics.checkNotNullParameter(pushSubscriptionState2, "current");
        this.previous = pushSubscriptionState;
        this.current = pushSubscriptionState2;
    }

    public final JSONObject toJSONObject() {
        JSONObject put = new JSONObject().put("previous", this.previous.toJSONObject()).put("current", this.current.toJSONObject());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …, current.toJSONObject())");
        return put;
    }
}
