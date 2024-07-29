package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u00103\u001a\u00020\u001c2\b\u00104\u001a\u0004\u0018\u00010\u0014H&J\b\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u000207H&J\b\u00108\u001a\u000207H\u0016J\u0010\u00109\u001a\u0002072\u0006\u0010:\u001a\u00020\u001cH&J\u0012\u0010;\u001a\u0002072\b\u00104\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010<\u001a\u00020\u0014H\u0016R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010)R\u0014\u0010*\u001a\u00020(8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020(8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020\u001c8fX¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u0014\u0010.\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/onesignal/session/internal/influence/impl/ChannelTracker;", "Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "dataRepository", "Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "timeProvider", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;Lcom/onesignal/core/internal/time/ITime;)V", "channelLimit", "", "getChannelLimit", "()I", "currentSessionInfluence", "Lcom/onesignal/session/internal/influence/Influence;", "getCurrentSessionInfluence", "()Lcom/onesignal/session/internal/influence/Influence;", "getDataRepository", "()Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "setDataRepository", "(Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;)V", "directId", "", "getDirectId", "()Ljava/lang/String;", "setDirectId", "(Ljava/lang/String;)V", "indirectAttributionWindow", "getIndirectAttributionWindow", "indirectIds", "Lorg/json/JSONArray;", "getIndirectIds", "()Lorg/json/JSONArray;", "setIndirectIds", "(Lorg/json/JSONArray;)V", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "getInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "setInfluenceType", "(Lcom/onesignal/session/internal/influence/InfluenceType;)V", "isDirectSessionEnabled", "", "()Z", "isIndirectSessionEnabled", "isUnattributedSessionEnabled", "lastChannelObjects", "getLastChannelObjects", "lastReceivedIds", "getLastReceivedIds", "equals", "other", "", "getLastChannelObjectsReceivedByNewId", "id", "hashCode", "initInfluencedTypeFromCache", "", "resetAndInitInfluence", "saveChannelObjects", "channelObjects", "saveLastId", "toString", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ChannelTracker.kt */
public abstract class ChannelTracker implements IChannelTracker {
    private InfluenceDataRepository dataRepository;
    private String directId;
    private JSONArray indirectIds;
    private InfluenceType influenceType;
    private ITime timeProvider;

    public abstract int getChannelLimit();

    /* access modifiers changed from: protected */
    public final InfluenceDataRepository getDataRepository() {
        return this.dataRepository;
    }

    public String getDirectId() {
        return this.directId;
    }

    public abstract int getIndirectAttributionWindow();

    public JSONArray getIndirectIds() {
        return this.indirectIds;
    }

    public InfluenceType getInfluenceType() {
        return this.influenceType;
    }

    public abstract JSONArray getLastChannelObjects() throws JSONException;

    public abstract JSONArray getLastChannelObjectsReceivedByNewId(String str);

    public abstract void initInfluencedTypeFromCache();

    public abstract void saveChannelObjects(JSONArray jSONArray);

    /* access modifiers changed from: protected */
    public final void setDataRepository(InfluenceDataRepository influenceDataRepository) {
        Intrinsics.checkNotNullParameter(influenceDataRepository, "<set-?>");
        this.dataRepository = influenceDataRepository;
    }

    public void setDirectId(String str) {
        this.directId = str;
    }

    public void setIndirectIds(JSONArray jSONArray) {
        this.indirectIds = jSONArray;
    }

    public void setInfluenceType(InfluenceType influenceType2) {
        this.influenceType = influenceType2;
    }

    public ChannelTracker(InfluenceDataRepository influenceDataRepository, ITime iTime) {
        Intrinsics.checkNotNullParameter(influenceDataRepository, "dataRepository");
        Intrinsics.checkNotNullParameter(iTime, "timeProvider");
        this.dataRepository = influenceDataRepository;
        this.timeProvider = iTime;
    }

    private final boolean isDirectSessionEnabled() {
        return this.dataRepository.isDirectInfluenceEnabled();
    }

    private final boolean isIndirectSessionEnabled() {
        return this.dataRepository.isIndirectInfluenceEnabled();
    }

    private final boolean isUnattributedSessionEnabled() {
        return this.dataRepository.isUnattributedInfluenceEnabled();
    }

    public Influence getCurrentSessionInfluence() {
        Influence influence = new Influence(getChannelType(), InfluenceType.DISABLED, (JSONArray) null);
        if (getInfluenceType() == null) {
            initInfluencedTypeFromCache();
        }
        InfluenceType influenceType2 = getInfluenceType();
        if (influenceType2 == null) {
            influenceType2 = InfluenceType.DISABLED;
        }
        if (influenceType2.isDirect()) {
            if (isDirectSessionEnabled()) {
                influence.setIds(new JSONArray().put(getDirectId()));
                influence.setInfluenceType(InfluenceType.DIRECT);
            }
        } else if (influenceType2.isIndirect()) {
            if (isIndirectSessionEnabled()) {
                influence.setIds(getIndirectIds());
                influence.setInfluenceType(InfluenceType.INDIRECT);
            }
        } else if (isUnattributedSessionEnabled()) {
            influence.setInfluenceType(InfluenceType.UNATTRIBUTED);
        }
        return influence;
    }

    public JSONArray getLastReceivedIds() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray lastChannelObjects = getLastChannelObjects();
            Logging.debug$default("ChannelTracker.getLastReceivedIds: lastChannelObjectReceived: " + lastChannelObjects, (Throwable) null, 2, (Object) null);
            long indirectAttributionWindow = ((long) (getIndirectAttributionWindow() * 60)) * 1000;
            long currentTimeMillis = this.timeProvider.getCurrentTimeMillis();
            int length = lastChannelObjects.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = lastChannelObjects.getJSONObject(i);
                if (currentTimeMillis - jSONObject.getLong("time") <= indirectAttributionWindow) {
                    jSONArray.put(jSONObject.getString(getIdTag()));
                }
            }
        } catch (JSONException e) {
            Logging.error("ChannelTracker.getLastReceivedIds: Generating tracker getLastReceivedIds JSONObject ", e);
        }
        return jSONArray;
    }

    public void resetAndInitInfluence() {
        setDirectId((String) null);
        setIndirectIds(getLastReceivedIds());
        JSONArray indirectIds2 = getIndirectIds();
        setInfluenceType((indirectIds2 == null || indirectIds2.length() <= 0) ? InfluenceType.UNATTRIBUTED : InfluenceType.INDIRECT);
        cacheState();
        Logging.debug$default("ChannelTracker.resetAndInitInfluence: " + getIdTag() + " finish with influenceType: " + getInfluenceType(), (Throwable) null, 2, (Object) null);
    }

    public void saveLastId(String str) {
        Logging.debug$default("ChannelTracker.saveLastId(id: " + str + "): idTag=" + getIdTag(), (Throwable) null, 2, (Object) null);
        if (str != null && str.length() != 0) {
            JSONArray lastChannelObjectsReceivedByNewId = getLastChannelObjectsReceivedByNewId(str);
            Logging.debug$default("ChannelTracker.saveLastId: for " + getIdTag() + " saveLastId with lastChannelObjectsReceived: " + lastChannelObjectsReceivedByNewId, (Throwable) null, 2, (Object) null);
            try {
                lastChannelObjectsReceivedByNewId.put(new JSONObject().put(getIdTag(), str).put("time", this.timeProvider.getCurrentTimeMillis()));
                if (lastChannelObjectsReceivedByNewId.length() > getChannelLimit()) {
                    JSONArray jSONArray = new JSONArray();
                    int length = lastChannelObjectsReceivedByNewId.length();
                    for (int length2 = lastChannelObjectsReceivedByNewId.length() - getChannelLimit(); length2 < length; length2++) {
                        try {
                            jSONArray.put(lastChannelObjectsReceivedByNewId.get(length2));
                        } catch (JSONException e) {
                            Logging.error("ChannelTracker.saveLastId: Generating tracker lastChannelObjectsReceived get JSONObject ", e);
                        }
                    }
                    lastChannelObjectsReceivedByNewId = jSONArray;
                }
                Logging.debug$default("ChannelTracker.saveLastId: for " + getIdTag() + " with channelObjectToSave: " + lastChannelObjectsReceivedByNewId, (Throwable) null, 2, (Object) null);
                saveChannelObjects(lastChannelObjectsReceivedByNewId);
            } catch (JSONException e2) {
                Logging.error("ChannelTracker.saveLastId: Generating tracker newInfluenceId JSONObject ", e2);
            }
        }
    }

    public String toString() {
        return "ChannelTracker{tag=" + getIdTag() + ", influenceType=" + getInfluenceType() + ", indirectIds=" + getIndirectIds() + ", directId=" + getDirectId() + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        ChannelTracker channelTracker = (ChannelTracker) obj;
        if (getInfluenceType() != channelTracker.getInfluenceType() || !Intrinsics.areEqual((Object) channelTracker.getIdTag(), (Object) getIdTag())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        InfluenceType influenceType2 = getInfluenceType();
        return ((influenceType2 != null ? influenceType2.hashCode() : 0) * 31) + getIdTag().hashCode();
    }
}
