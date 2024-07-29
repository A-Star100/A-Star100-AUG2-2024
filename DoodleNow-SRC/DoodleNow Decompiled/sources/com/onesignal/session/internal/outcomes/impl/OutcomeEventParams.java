package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "", "outcomeId", "", "outcomeSource", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "weight", "", "sessionTime", "", "timestamp", "(Ljava/lang/String;Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;FJJ)V", "getOutcomeId", "()Ljava/lang/String;", "getOutcomeSource", "()Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "getSessionTime", "()J", "setSessionTime", "(J)V", "getTimestamp", "setTimestamp", "getWeight", "()F", "setWeight", "(F)V", "isUnattributed", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutcomeEventParams.kt */
public final class OutcomeEventParams {
    private final String outcomeId;
    private final OutcomeSource outcomeSource;
    private long sessionTime;
    private long timestamp;
    private float weight;

    public final String getOutcomeId() {
        return this.outcomeId;
    }

    public final OutcomeSource getOutcomeSource() {
        return this.outcomeSource;
    }

    public final long getSessionTime() {
        return this.sessionTime;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setSessionTime(long j) {
        this.sessionTime = j;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    public OutcomeEventParams(String str, OutcomeSource outcomeSource2, float f, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "outcomeId");
        this.outcomeId = str;
        this.outcomeSource = outcomeSource2;
        this.weight = f;
        this.sessionTime = j;
        this.timestamp = j2;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject put = new JSONObject().put("id", this.outcomeId);
        OutcomeSource outcomeSource2 = this.outcomeSource;
        if (outcomeSource2 != null) {
            put.put(OutcomeConstants.OUTCOME_SOURCES, outcomeSource2.toJSONObject());
        }
        float f = this.weight;
        if (f > 0.0f) {
            put.put("weight", Float.valueOf(f));
        }
        long j = this.timestamp;
        if (j > 0) {
            put.put("timestamp", j);
        }
        long j2 = this.sessionTime;
        if (j2 > 0) {
            put.put("session_time", j2);
        }
        Intrinsics.checkNotNullExpressionValue(put, "json");
        return put;
    }

    public final boolean isUnattributed() {
        OutcomeSource outcomeSource2 = this.outcomeSource;
        return outcomeSource2 == null || (outcomeSource2.getDirectBody() == null && this.outcomeSource.getIndirectBody() == null);
    }

    public String toString() {
        return "OutcomeEventParams{outcomeId='" + this.outcomeId + "', outcomeSource=" + this.outcomeSource + ", weight=" + this.weight + ", timestamp=" + this.timestamp + ", sessionTime=" + this.sessionTime + AbstractJsonLexerKt.END_OBJ;
    }
}
