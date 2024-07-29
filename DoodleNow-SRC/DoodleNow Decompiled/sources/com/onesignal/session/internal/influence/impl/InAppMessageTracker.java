package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InAppMessageTracker;", "Lcom/onesignal/session/internal/influence/impl/ChannelTracker;", "dataRepository", "Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "timeProvider", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;Lcom/onesignal/core/internal/time/ITime;)V", "channelLimit", "", "getChannelLimit", "()I", "channelType", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "getChannelType", "()Lcom/onesignal/session/internal/influence/InfluenceChannel;", "idTag", "", "getIdTag", "()Ljava/lang/String;", "indirectAttributionWindow", "getIndirectAttributionWindow", "lastChannelObjects", "Lorg/json/JSONArray;", "getLastChannelObjects", "()Lorg/json/JSONArray;", "cacheState", "", "getLastChannelObjectsReceivedByNewId", "id", "initInfluencedTypeFromCache", "saveChannelObjects", "channelObjects", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageTracker.kt */
public final class InAppMessageTracker extends ChannelTracker {
    public String getIdTag() {
        return InfluenceConstants.IAM_ID_TAG;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageTracker(InfluenceDataRepository influenceDataRepository, ITime iTime) {
        super(influenceDataRepository, iTime);
        Intrinsics.checkNotNullParameter(influenceDataRepository, "dataRepository");
        Intrinsics.checkNotNullParameter(iTime, "timeProvider");
    }

    public InfluenceChannel getChannelType() {
        return InfluenceChannel.IAM;
    }

    public JSONArray getLastChannelObjectsReceivedByNewId(String str) {
        try {
            JSONArray lastChannelObjects = getLastChannelObjects();
            try {
                JSONArray jSONArray = new JSONArray();
                int length = lastChannelObjects.length();
                for (int i = 0; i < length; i++) {
                    if (!Intrinsics.areEqual((Object) str, (Object) lastChannelObjects.getJSONObject(i).getString(getIdTag()))) {
                        jSONArray.put(lastChannelObjects.getJSONObject(i));
                    }
                }
                return jSONArray;
            } catch (JSONException e) {
                Logging.error("Generating tracker lastChannelObjectReceived get JSONObject ", e);
                return lastChannelObjects;
            }
        } catch (JSONException e2) {
            Logging.error("Generating IAM tracker getLastChannelObjects JSONObject ", e2);
            return new JSONArray();
        }
    }

    public JSONArray getLastChannelObjects() throws JSONException {
        return getDataRepository().getLastIAMsReceivedData();
    }

    public int getChannelLimit() {
        return getDataRepository().getIamLimit();
    }

    public int getIndirectAttributionWindow() {
        return getDataRepository().getIamIndirectAttributionWindow();
    }

    public void saveChannelObjects(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "channelObjects");
        getDataRepository().saveIAMs(jSONArray);
    }

    public void initInfluencedTypeFromCache() {
        InfluenceType iamCachedInfluenceType = getDataRepository().getIamCachedInfluenceType();
        if (iamCachedInfluenceType.isIndirect()) {
            setIndirectIds(getLastReceivedIds());
        }
        setInfluenceType(iamCachedInfluenceType);
        Logging.debug$default("InAppMessageTracker.initInfluencedTypeFromCache: " + this, (Throwable) null, 2, (Object) null);
    }

    public void cacheState() {
        InfluenceType influenceType = getInfluenceType();
        if (influenceType == null) {
            influenceType = InfluenceType.UNATTRIBUTED;
        }
        InfluenceDataRepository dataRepository = getDataRepository();
        if (influenceType == InfluenceType.DIRECT) {
            influenceType = InfluenceType.INDIRECT;
        }
        dataRepository.cacheIAMInfluenceType(influenceType);
    }
}
