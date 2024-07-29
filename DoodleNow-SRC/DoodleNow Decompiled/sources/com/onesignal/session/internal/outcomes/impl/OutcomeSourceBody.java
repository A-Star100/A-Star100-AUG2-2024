package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "", "notificationIds", "Lorg/json/JSONArray;", "inAppMessagesIds", "(Lorg/json/JSONArray;Lorg/json/JSONArray;)V", "getInAppMessagesIds", "()Lorg/json/JSONArray;", "setInAppMessagesIds", "(Lorg/json/JSONArray;)V", "getNotificationIds", "setNotificationIds", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutcomeSourceBody.kt */
public final class OutcomeSourceBody {
    private JSONArray inAppMessagesIds;
    private JSONArray notificationIds;

    public OutcomeSourceBody() {
        this((JSONArray) null, (JSONArray) null, 3, (DefaultConstructorMarker) null);
    }

    public OutcomeSourceBody(JSONArray jSONArray) {
        this(jSONArray, (JSONArray) null, 2, (DefaultConstructorMarker) null);
    }

    public final JSONArray getInAppMessagesIds() {
        return this.inAppMessagesIds;
    }

    public final JSONArray getNotificationIds() {
        return this.notificationIds;
    }

    public final void setInAppMessagesIds(JSONArray jSONArray) {
        this.inAppMessagesIds = jSONArray;
    }

    public final void setNotificationIds(JSONArray jSONArray) {
        this.notificationIds = jSONArray;
    }

    public OutcomeSourceBody(JSONArray jSONArray, JSONArray jSONArray2) {
        this.notificationIds = jSONArray;
        this.inAppMessagesIds = jSONArray2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutcomeSourceBody(JSONArray jSONArray, JSONArray jSONArray2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new JSONArray() : jSONArray, (i & 2) != 0 ? new JSONArray() : jSONArray2);
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject put = new JSONObject().put("notification_ids", this.notificationIds).put(OutcomeConstants.IAM_IDS, this.inAppMessagesIds);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …AM_IDS, inAppMessagesIds)");
        return put;
    }

    public String toString() {
        return "OutcomeSourceBody{notificationIds=" + this.notificationIds + ", inAppMessagesIds=" + this.inAppMessagesIds + AbstractJsonLexerKt.END_OBJ;
    }
}
