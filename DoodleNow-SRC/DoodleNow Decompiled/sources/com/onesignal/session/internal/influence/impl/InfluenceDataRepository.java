package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\fH\u0016J\u0010\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\fH\u0016J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u0014\u0010\"\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0012R\u0014\u0010$\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "Lcom/onesignal/session/internal/influence/impl/IInfluenceDataRepository;", "preferences", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "cachedNotificationOpenId", "", "getCachedNotificationOpenId", "()Ljava/lang/String;", "iamCachedInfluenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "getIamCachedInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "iamIndirectAttributionWindow", "", "getIamIndirectAttributionWindow", "()I", "iamLimit", "getIamLimit", "isDirectInfluenceEnabled", "", "()Z", "isIndirectInfluenceEnabled", "isUnattributedInfluenceEnabled", "lastIAMsReceivedData", "Lorg/json/JSONArray;", "getLastIAMsReceivedData", "()Lorg/json/JSONArray;", "lastNotificationsReceivedData", "getLastNotificationsReceivedData", "notificationCachedInfluenceType", "getNotificationCachedInfluenceType", "notificationIndirectAttributionWindow", "getNotificationIndirectAttributionWindow", "notificationLimit", "getNotificationLimit", "cacheIAMInfluenceType", "", "influenceType", "cacheNotificationInfluenceType", "cacheNotificationOpenId", "id", "saveIAMs", "iams", "saveNotifications", "notifications", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InfluenceDataRepository.kt */
public final class InfluenceDataRepository implements IInfluenceDataRepository {
    private final ConfigModelStore _configModelStore;
    private final IPreferencesService preferences;

    public InfluenceDataRepository(IPreferencesService iPreferencesService, ConfigModelStore configModelStore) {
        Intrinsics.checkNotNullParameter(iPreferencesService, "preferences");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this.preferences = iPreferencesService;
        this._configModelStore = configModelStore;
    }

    public void cacheNotificationInfluenceType(InfluenceType influenceType) {
        Intrinsics.checkNotNullParameter(influenceType, "influenceType");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, influenceType.toString());
    }

    public InfluenceType getNotificationCachedInfluenceType() {
        return InfluenceType.Companion.fromString(this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, InfluenceType.UNATTRIBUTED.toString()));
    }

    public void cacheIAMInfluenceType(InfluenceType influenceType) {
        Intrinsics.checkNotNullParameter(influenceType, "influenceType");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, influenceType.toString());
    }

    public InfluenceType getIamCachedInfluenceType() {
        return InfluenceType.Companion.fromString(this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, InfluenceType.UNATTRIBUTED.toString()));
    }

    public void cacheNotificationOpenId(String str) {
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, str);
    }

    public String getCachedNotificationOpenId() {
        return this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, (String) null);
    }

    public void saveNotifications(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "notifications");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, jSONArray.toString());
    }

    public void saveIAMs(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "iams");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_IAMS_RECEIVED, jSONArray.toString());
    }

    public JSONArray getLastNotificationsReceivedData() throws JSONException {
        JSONArray jSONArray;
        String string = this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (string == null) {
            jSONArray = new JSONArray();
        }
        return jSONArray;
    }

    public JSONArray getLastIAMsReceivedData() throws JSONException {
        JSONArray jSONArray;
        String string = this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_IAMS_RECEIVED, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (string == null) {
            jSONArray = new JSONArray();
        }
        return jSONArray;
    }

    public int getNotificationLimit() {
        return ((ConfigModel) this._configModelStore.getModel()).getInfluenceParams().getNotificationLimit();
    }

    public int getIamLimit() {
        return ((ConfigModel) this._configModelStore.getModel()).getInfluenceParams().getIamLimit();
    }

    public int getNotificationIndirectAttributionWindow() {
        return ((ConfigModel) this._configModelStore.getModel()).getInfluenceParams().getIndirectNotificationAttributionWindow();
    }

    public int getIamIndirectAttributionWindow() {
        return ((ConfigModel) this._configModelStore.getModel()).getInfluenceParams().getIndirectIAMAttributionWindow();
    }

    public boolean isDirectInfluenceEnabled() {
        return ((ConfigModel) this._configModelStore.getModel()).getInfluenceParams().isDirectEnabled();
    }

    public boolean isIndirectInfluenceEnabled() {
        return ((ConfigModel) this._configModelStore.getModel()).getInfluenceParams().isIndirectEnabled();
    }

    public boolean isUnattributedInfluenceEnabled() {
        return ((ConfigModel) this._configModelStore.getModel()).getInfluenceParams().isUnattributedEnabled();
    }
}
