package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.IOutcomeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "Lcom/onesignal/session/internal/outcomes/IOutcomeEvent;", "session", "Lcom/onesignal/session/internal/influence/InfluenceType;", "notificationIds", "Lorg/json/JSONArray;", "name", "", "timestamp", "", "sessionTime", "weight", "", "(Lcom/onesignal/session/internal/influence/InfluenceType;Lorg/json/JSONArray;Ljava/lang/String;JJF)V", "getName", "()Ljava/lang/String;", "getNotificationIds", "()Lorg/json/JSONArray;", "getSession", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "getSessionTime", "()J", "getTimestamp", "getWeight", "()F", "equals", "", "o", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutcomeEvent.kt */
public final class OutcomeEvent implements IOutcomeEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NOTIFICATION_IDS = "notification_ids";
    private static final String OUTCOME_ID = "id";
    private static final String SESSION = "session";
    private static final String SESSION_TIME = "session_time";
    private static final String TIMESTAMP = "timestamp";
    private static final String WEIGHT = "weight";
    private final String name;
    private final JSONArray notificationIds;
    private final InfluenceType session;
    private final long sessionTime;
    private final long timestamp;
    private final float weight;

    public String getName() {
        return this.name;
    }

    public JSONArray getNotificationIds() {
        return this.notificationIds;
    }

    public InfluenceType getSession() {
        return this.session;
    }

    public long getSessionTime() {
        return this.sessionTime;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public float getWeight() {
        return this.weight;
    }

    public OutcomeEvent(InfluenceType influenceType, JSONArray jSONArray, String str, long j, long j2, float f) {
        Intrinsics.checkNotNullParameter(influenceType, "session");
        Intrinsics.checkNotNullParameter(str, "name");
        this.session = influenceType;
        this.notificationIds = jSONArray;
        this.name = str;
        this.timestamp = j;
        this.sessionTime = j2;
        this.weight = f;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("session", getSession());
        jSONObject.put("notification_ids", getNotificationIds());
        jSONObject.put("id", getName());
        jSONObject.put("timestamp", getTimestamp());
        jSONObject.put("session_time", getSessionTime());
        jSONObject.put("weight", Float.valueOf(getWeight()));
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        OutcomeEvent outcomeEvent = (OutcomeEvent) obj;
        if (getSession() == outcomeEvent.getSession() && Intrinsics.areEqual((Object) getNotificationIds(), (Object) outcomeEvent.getNotificationIds()) && Intrinsics.areEqual((Object) getName(), (Object) outcomeEvent.getName()) && getTimestamp() == outcomeEvent.getTimestamp() && getSessionTime() == outcomeEvent.getSessionTime() && getWeight() == outcomeEvent.getWeight()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 1;
        Object[] objArr = {getSession(), getNotificationIds(), getName(), Long.valueOf(getTimestamp()), Long.valueOf(getSessionTime()), Float.valueOf(getWeight())};
        for (int i2 = 0; i2 < 6; i2++) {
            Object obj = objArr[i2];
            i = (i * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return i;
    }

    public String toString() {
        return "OutcomeEvent{session=" + getSession() + ", notificationIds=" + getNotificationIds() + ", name='" + getName() + "', timestamp=" + getTimestamp() + ", sessionTime=" + getSessionTime() + ", weight=" + getWeight() + AbstractJsonLexerKt.END_OBJ;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent$Companion;", "", "()V", "NOTIFICATION_IDS", "", "OUTCOME_ID", "SESSION", "SESSION_TIME", "TIMESTAMP", "WEIGHT", "fromOutcomeEventParamstoOutcomeEvent", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "outcomeEventParams", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OutcomeEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OutcomeEvent fromOutcomeEventParamstoOutcomeEvent(OutcomeEventParams outcomeEventParams) {
            JSONArray jSONArray;
            Intrinsics.checkNotNullParameter(outcomeEventParams, "outcomeEventParams");
            InfluenceType influenceType = InfluenceType.UNATTRIBUTED;
            if (outcomeEventParams.getOutcomeSource() != null) {
                OutcomeSource outcomeSource = outcomeEventParams.getOutcomeSource();
                if (outcomeSource.getDirectBody() != null) {
                    OutcomeSourceBody directBody = outcomeSource.getDirectBody();
                    Intrinsics.checkNotNull(directBody);
                    if (directBody.getNotificationIds() != null) {
                        OutcomeSourceBody directBody2 = outcomeSource.getDirectBody();
                        Intrinsics.checkNotNull(directBody2);
                        JSONArray notificationIds = directBody2.getNotificationIds();
                        Intrinsics.checkNotNull(notificationIds);
                        if (notificationIds.length() > 0) {
                            influenceType = InfluenceType.DIRECT;
                            OutcomeSourceBody directBody3 = outcomeSource.getDirectBody();
                            Intrinsics.checkNotNull(directBody3);
                            jSONArray = directBody3.getNotificationIds();
                            return new OutcomeEvent(influenceType, jSONArray, outcomeEventParams.getOutcomeId(), outcomeEventParams.getTimestamp(), outcomeEventParams.getSessionTime(), outcomeEventParams.getWeight());
                        }
                    }
                }
                if (outcomeSource.getIndirectBody() != null) {
                    OutcomeSourceBody indirectBody = outcomeSource.getIndirectBody();
                    Intrinsics.checkNotNull(indirectBody);
                    if (indirectBody.getNotificationIds() != null) {
                        OutcomeSourceBody indirectBody2 = outcomeSource.getIndirectBody();
                        Intrinsics.checkNotNull(indirectBody2);
                        JSONArray notificationIds2 = indirectBody2.getNotificationIds();
                        Intrinsics.checkNotNull(notificationIds2);
                        if (notificationIds2.length() > 0) {
                            influenceType = InfluenceType.INDIRECT;
                            OutcomeSourceBody indirectBody3 = outcomeSource.getIndirectBody();
                            Intrinsics.checkNotNull(indirectBody3);
                            jSONArray = indirectBody3.getNotificationIds();
                            return new OutcomeEvent(influenceType, jSONArray, outcomeEventParams.getOutcomeId(), outcomeEventParams.getTimestamp(), outcomeEventParams.getSessionTime(), outcomeEventParams.getWeight());
                        }
                    }
                }
            }
            jSONArray = null;
            return new OutcomeEvent(influenceType, jSONArray, outcomeEventParams.getOutcomeId(), outcomeEventParams.getTimestamp(), outcomeEventParams.getSessionTime(), outcomeEventParams.getWeight());
        }
    }
}
