package com.onesignal.session.internal.influence;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u0000J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0003J\b\u0010!\u001a\u00020\u0003H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/onesignal/session/internal/influence/Influence;", "", "jsonString", "", "(Ljava/lang/String;)V", "influenceChannel", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "ids", "Lorg/json/JSONArray;", "(Lcom/onesignal/session/internal/influence/InfluenceChannel;Lcom/onesignal/session/internal/influence/InfluenceType;Lorg/json/JSONArray;)V", "directId", "getDirectId", "()Ljava/lang/String;", "getIds", "()Lorg/json/JSONArray;", "setIds", "(Lorg/json/JSONArray;)V", "<set-?>", "getInfluenceChannel", "()Lcom/onesignal/session/internal/influence/InfluenceChannel;", "getInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "setInfluenceType", "(Lcom/onesignal/session/internal/influence/InfluenceType;)V", "copy", "equals", "", "o", "hashCode", "", "toJSONString", "toString", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Influence.kt */
public final class Influence {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String INFLUENCE_CHANNEL = "influence_channel";
    public static final String INFLUENCE_IDS = "influence_ids";
    public static final String INFLUENCE_TYPE = "influence_type";
    private JSONArray ids;
    private InfluenceChannel influenceChannel;
    private InfluenceType influenceType;

    public final JSONArray getIds() {
        return this.ids;
    }

    public final InfluenceChannel getInfluenceChannel() {
        return this.influenceChannel;
    }

    public final InfluenceType getInfluenceType() {
        return this.influenceType;
    }

    public final void setIds(JSONArray jSONArray) {
        this.ids = jSONArray;
    }

    public final void setInfluenceType(InfluenceType influenceType2) {
        Intrinsics.checkNotNullParameter(influenceType2, "<set-?>");
        this.influenceType = influenceType2;
    }

    public Influence(String str) throws JSONException {
        Intrinsics.checkNotNullParameter(str, "jsonString");
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString(INFLUENCE_CHANNEL);
        String string2 = jSONObject.getString(INFLUENCE_TYPE);
        String string3 = jSONObject.getString(INFLUENCE_IDS);
        this.influenceChannel = InfluenceChannel.Companion.fromString(string);
        this.influenceType = InfluenceType.Companion.fromString(string2);
        Intrinsics.checkNotNullExpressionValue(string3, "ids");
        this.ids = string3.length() == 0 ? null : new JSONArray(string3);
    }

    public Influence(InfluenceChannel influenceChannel2, InfluenceType influenceType2, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(influenceChannel2, "influenceChannel");
        Intrinsics.checkNotNullParameter(influenceType2, "influenceType");
        this.influenceChannel = influenceChannel2;
        this.influenceType = influenceType2;
        this.ids = jSONArray;
    }

    public final String getDirectId() throws JSONException {
        JSONArray jSONArray = this.ids;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        return jSONArray.getString(0);
    }

    public final Influence copy() {
        return new Influence(this.influenceChannel, this.influenceType, this.ids);
    }

    public final String toJSONString() throws JSONException {
        JSONObject put = new JSONObject().put(INFLUENCE_CHANNEL, this.influenceChannel.toString()).put(INFLUENCE_TYPE, this.influenceType.toString());
        JSONArray jSONArray = this.ids;
        String jSONObject = put.put(INFLUENCE_IDS, jSONArray != null ? String.valueOf(jSONArray) : "").toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           …)\n            .toString()");
        return jSONObject;
    }

    public String toString() {
        return "SessionInfluence{influenceChannel=" + this.influenceChannel + ", influenceType=" + this.influenceType + ", ids=" + this.ids + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        Influence influence = (Influence) obj;
        if (this.influenceChannel == influence.influenceChannel && this.influenceType == influence.influenceType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.influenceChannel.hashCode() * 31) + this.influenceType.hashCode();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/internal/influence/Influence$Companion;", "", "()V", "INFLUENCE_CHANNEL", "", "INFLUENCE_IDS", "INFLUENCE_TYPE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Influence.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
