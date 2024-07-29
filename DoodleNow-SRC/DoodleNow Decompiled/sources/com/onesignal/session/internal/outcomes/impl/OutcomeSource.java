package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "", "directBody", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "indirectBody", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;)V", "getDirectBody", "()Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "setDirectBody", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;)V", "getIndirectBody", "setIndirectBody", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutcomeSource.kt */
public final class OutcomeSource {
    private OutcomeSourceBody directBody;
    private OutcomeSourceBody indirectBody;

    public final OutcomeSourceBody getDirectBody() {
        return this.directBody;
    }

    public final OutcomeSourceBody getIndirectBody() {
        return this.indirectBody;
    }

    /* renamed from: setDirectBody  reason: collision with other method in class */
    public final void m1046setDirectBody(OutcomeSourceBody outcomeSourceBody) {
        this.directBody = outcomeSourceBody;
    }

    /* renamed from: setIndirectBody  reason: collision with other method in class */
    public final void m1047setIndirectBody(OutcomeSourceBody outcomeSourceBody) {
        this.indirectBody = outcomeSourceBody;
    }

    public OutcomeSource(OutcomeSourceBody outcomeSourceBody, OutcomeSourceBody outcomeSourceBody2) {
        this.directBody = outcomeSourceBody;
        this.indirectBody = outcomeSourceBody2;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        OutcomeSourceBody outcomeSourceBody = this.directBody;
        if (outcomeSourceBody != null) {
            jSONObject.put("direct", outcomeSourceBody.toJSONObject());
        }
        OutcomeSourceBody outcomeSourceBody2 = this.indirectBody;
        if (outcomeSourceBody2 != null) {
            jSONObject.put("indirect", outcomeSourceBody2.toJSONObject());
        }
        return jSONObject;
    }

    public final OutcomeSource setDirectBody(OutcomeSourceBody outcomeSourceBody) {
        OutcomeSource outcomeSource = this;
        this.directBody = outcomeSourceBody;
        return this;
    }

    public final OutcomeSource setIndirectBody(OutcomeSourceBody outcomeSourceBody) {
        OutcomeSource outcomeSource = this;
        this.indirectBody = outcomeSourceBody;
        return this;
    }

    public String toString() {
        return "OutcomeSource{directBody=" + this.directBody + ", indirectBody=" + this.indirectBody + AbstractJsonLexerKt.END_OBJ;
    }
}
