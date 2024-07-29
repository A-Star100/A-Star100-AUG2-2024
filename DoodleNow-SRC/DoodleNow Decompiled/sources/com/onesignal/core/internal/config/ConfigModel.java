package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010v\u001a\u0004\u0018\u00010\u00012\u0006\u0010w\u001a\u00020\u00042\u0006\u0010x\u001a\u00020yH\u0014R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R$\u0010$\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010+\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R$\u0010.\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R$\u00101\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R(\u00104\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR$\u00108\u001a\u0002072\u0006\u0010\u0003\u001a\u0002078F@FX\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0002072\u0006\u0010\u0003\u001a\u0002078F@FX\u000e¢\u0006\f\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R$\u0010@\u001a\u0002072\u0006\u0010\u0003\u001a\u0002078F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\u0011\u0010C\u001a\u00020D8F¢\u0006\u0006\u001a\u0004\bE\u0010FR$\u0010G\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018R$\u0010I\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010\u0018R(\u0010M\u001a\u0004\u0018\u00010L2\b\u0010\u0003\u001a\u0004\u0018\u00010L8F@FX\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012R$\u0010U\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bV\u0010\u0010\"\u0004\bW\u0010\u0012R$\u0010X\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012R$\u0010[\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R$\u0010^\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R(\u0010a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bb\u0010\u0007\"\u0004\bc\u0010\tR$\u0010d\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\be\u0010\u0016\"\u0004\bf\u0010\u0018R$\u0010g\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\bh\u0010\u0016\"\u0004\bi\u0010\u0018R$\u0010j\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bk\u0010\u0010\"\u0004\bl\u0010\u0012R$\u0010m\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R$\u0010p\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\bq\u0010\u0016\"\u0004\br\u0010\u0018R$\u0010s\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\bt\u0010\u0016\"\u0004\bu\u0010\u0018¨\u0006z"}, d2 = {"Lcom/onesignal/core/internal/config/ConfigModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "apiUrl", "getApiUrl", "()Ljava/lang/String;", "setApiUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "", "backgroundFetchNotificationPermissionInterval", "getBackgroundFetchNotificationPermissionInterval", "()J", "setBackgroundFetchNotificationPermissionInterval", "(J)V", "", "clearGroupOnSummaryClick", "getClearGroupOnSummaryClick", "()Z", "setClearGroupOnSummaryClick", "(Z)V", "consentGiven", "getConsentGiven", "()Ljava/lang/Boolean;", "setConsentGiven", "(Ljava/lang/Boolean;)V", "consentRequired", "getConsentRequired", "setConsentRequired", "disableGMSMissingPrompt", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "enterprise", "getEnterprise", "setEnterprise", "fcmParams", "Lcom/onesignal/core/internal/config/FCMConfigModel;", "getFcmParams", "()Lcom/onesignal/core/internal/config/FCMConfigModel;", "fetchIAMMinInterval", "getFetchIAMMinInterval", "setFetchIAMMinInterval", "firebaseAnalytics", "getFirebaseAnalytics", "setFirebaseAnalytics", "foregroundFetchNotificationPermissionInterval", "getForegroundFetchNotificationPermissionInterval", "setForegroundFetchNotificationPermissionInterval", "googleProjectNumber", "getGoogleProjectNumber", "setGoogleProjectNumber", "", "httpGetTimeout", "getHttpGetTimeout", "()I", "setHttpGetTimeout", "(I)V", "httpRetryAfterParseFailFallback", "getHttpRetryAfterParseFailFallback", "setHttpRetryAfterParseFailFallback", "httpTimeout", "getHttpTimeout", "setHttpTimeout", "influenceParams", "Lcom/onesignal/core/internal/config/InfluenceConfigModel;", "getInfluenceParams", "()Lcom/onesignal/core/internal/config/InfluenceConfigModel;", "isInitializedWithRemote", "setInitializedWithRemote", "locationShared", "getLocationShared", "setLocationShared", "Lorg/json/JSONArray;", "notificationChannels", "getNotificationChannels", "()Lorg/json/JSONArray;", "setNotificationChannels", "(Lorg/json/JSONArray;)V", "opRepoDefaultFailRetryBackoff", "getOpRepoDefaultFailRetryBackoff", "setOpRepoDefaultFailRetryBackoff", "opRepoExecutionInterval", "getOpRepoExecutionInterval", "setOpRepoExecutionInterval", "opRepoPostCreateDelay", "getOpRepoPostCreateDelay", "setOpRepoPostCreateDelay", "opRepoPostCreateRetryUpTo", "getOpRepoPostCreateRetryUpTo", "setOpRepoPostCreateRetryUpTo", "opRepoPostWakeDelay", "getOpRepoPostWakeDelay", "setOpRepoPostWakeDelay", "pushSubscriptionId", "getPushSubscriptionId", "setPushSubscriptionId", "receiveReceiptEnabled", "getReceiveReceiptEnabled", "setReceiveReceiptEnabled", "restoreTTLFilter", "getRestoreTTLFilter", "setRestoreTTLFilter", "sessionFocusTimeout", "getSessionFocusTimeout", "setSessionFocusTimeout", "unsubscribeWhenNotificationsDisabled", "getUnsubscribeWhenNotificationsDisabled", "setUnsubscribeWhenNotificationsDisabled", "useIdentityVerification", "getUseIdentityVerification", "setUseIdentityVerification", "userRejectedGMSUpdate", "getUserRejectedGMSUpdate", "setUserRejectedGMSUpdate", "createModelForProperty", "property", "jsonObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModel.kt */
public final class ConfigModel extends Model {
    public ConfigModel() {
        super((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public final boolean isInitializedWithRemote() {
        return getBooleanProperty("isInitializedWithRemote", ConfigModel$isInitializedWithRemote$2.INSTANCE);
    }

    public final void setInitializedWithRemote(boolean z) {
        Model.setBooleanProperty$default(this, "isInitializedWithRemote", z, (String) null, false, 12, (Object) null);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", (Function0) null, 2, (Object) null);
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "appId", str, (String) null, false, 12, (Object) null);
    }

    public final String getPushSubscriptionId() {
        return Model.getOptStringProperty$default(this, "pushSubscriptionId", (Function0) null, 2, (Object) null);
    }

    public final void setPushSubscriptionId(String str) {
        Model.setOptStringProperty$default(this, "pushSubscriptionId", str, (String) null, false, 12, (Object) null);
    }

    public final String getApiUrl() {
        return getStringProperty("apiUrl", ConfigModel$apiUrl$2.INSTANCE);
    }

    public final void setApiUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "apiUrl", str, (String) null, false, 12, (Object) null);
    }

    public final Boolean getConsentRequired() {
        return Model.getOptBooleanProperty$default(this, "consentRequired", (Function0) null, 2, (Object) null);
    }

    public final void setConsentRequired(Boolean bool) {
        Model.setOptBooleanProperty$default(this, "consentRequired", bool, (String) null, false, 12, (Object) null);
    }

    public final Boolean getConsentGiven() {
        return Model.getOptBooleanProperty$default(this, "consentGiven", (Function0) null, 2, (Object) null);
    }

    public final void setConsentGiven(Boolean bool) {
        Model.setOptBooleanProperty$default(this, "consentGiven", bool, (String) null, false, 12, (Object) null);
    }

    public final boolean getLocationShared() {
        return getBooleanProperty("locationShared", ConfigModel$locationShared$2.INSTANCE);
    }

    public final void setLocationShared(boolean z) {
        Model.setBooleanProperty$default(this, "locationShared", z, (String) null, false, 12, (Object) null);
    }

    public final boolean getDisableGMSMissingPrompt() {
        return getBooleanProperty("disableGMSMissingPrompt", ConfigModel$disableGMSMissingPrompt$2.INSTANCE);
    }

    public final void setDisableGMSMissingPrompt(boolean z) {
        Model.setBooleanProperty$default(this, "disableGMSMissingPrompt", z, (String) null, false, 12, (Object) null);
    }

    public final boolean getUserRejectedGMSUpdate() {
        return getBooleanProperty("userRejectedGMSUpdate", ConfigModel$userRejectedGMSUpdate$2.INSTANCE);
    }

    public final void setUserRejectedGMSUpdate(boolean z) {
        Model.setBooleanProperty$default(this, "userRejectedGMSUpdate", z, (String) null, false, 12, (Object) null);
    }

    public final boolean getUnsubscribeWhenNotificationsDisabled() {
        return getBooleanProperty("unsubscribeWhenNotificationsDisabled", ConfigModel$unsubscribeWhenNotificationsDisabled$2.INSTANCE);
    }

    public final void setUnsubscribeWhenNotificationsDisabled(boolean z) {
        Model.setBooleanProperty$default(this, "unsubscribeWhenNotificationsDisabled", z, (String) null, false, 12, (Object) null);
    }

    public final int getHttpTimeout() {
        return getIntProperty("httpTimeout", ConfigModel$httpTimeout$2.INSTANCE);
    }

    public final void setHttpTimeout(int i) {
        Model.setIntProperty$default(this, "httpTimeout", i, (String) null, false, 12, (Object) null);
    }

    public final int getHttpGetTimeout() {
        return getIntProperty("httpGetTimeout", ConfigModel$httpGetTimeout$2.INSTANCE);
    }

    public final void setHttpGetTimeout(int i) {
        Model.setIntProperty$default(this, "httpGetTimeout", i, (String) null, false, 12, (Object) null);
    }

    public final int getHttpRetryAfterParseFailFallback() {
        return getIntProperty("httpRetryAfterParseFailFallback", ConfigModel$httpRetryAfterParseFailFallback$2.INSTANCE);
    }

    public final void setHttpRetryAfterParseFailFallback(int i) {
        Model.setIntProperty$default(this, "httpRetryAfterParseFailFallback", i, (String) null, false, 12, (Object) null);
    }

    public final long getSessionFocusTimeout() {
        return getLongProperty("sessionFocusTimeout", ConfigModel$sessionFocusTimeout$2.INSTANCE);
    }

    public final void setSessionFocusTimeout(long j) {
        Model.setLongProperty$default(this, "sessionFocusTimeout", j, (String) null, false, 12, (Object) null);
    }

    public final long getOpRepoExecutionInterval() {
        return getLongProperty("opRepoExecutionInterval", ConfigModel$opRepoExecutionInterval$2.INSTANCE);
    }

    public final void setOpRepoExecutionInterval(long j) {
        Model.setLongProperty$default(this, "opRepoExecutionInterval", j, (String) null, false, 12, (Object) null);
    }

    public final long getOpRepoPostWakeDelay() {
        return getLongProperty("opRepoPostWakeDelay", ConfigModel$opRepoPostWakeDelay$2.INSTANCE);
    }

    public final void setOpRepoPostWakeDelay(long j) {
        Model.setLongProperty$default(this, "opRepoPostWakeDelay", j, (String) null, false, 12, (Object) null);
    }

    public final long getOpRepoPostCreateDelay() {
        return getLongProperty("opRepoPostCreateDelay", ConfigModel$opRepoPostCreateDelay$2.INSTANCE);
    }

    public final void setOpRepoPostCreateDelay(long j) {
        Model.setLongProperty$default(this, "opRepoPostCreateDelay", j, (String) null, false, 12, (Object) null);
    }

    public final long getOpRepoPostCreateRetryUpTo() {
        return getLongProperty("opRepoPostCreateRetryUpTo", ConfigModel$opRepoPostCreateRetryUpTo$2.INSTANCE);
    }

    public final void setOpRepoPostCreateRetryUpTo(long j) {
        Model.setLongProperty$default(this, "opRepoPostCreateRetryUpTo", j, (String) null, false, 12, (Object) null);
    }

    public final long getOpRepoDefaultFailRetryBackoff() {
        return getLongProperty("opRepoDefaultFailRetryBackoff", ConfigModel$opRepoDefaultFailRetryBackoff$2.INSTANCE);
    }

    public final void setOpRepoDefaultFailRetryBackoff(long j) {
        Model.setLongProperty$default(this, "opRepoDefaultFailRetryBackoff", j, (String) null, false, 12, (Object) null);
    }

    public final long getFetchIAMMinInterval() {
        return getLongProperty("fetchIAMMinInterval", ConfigModel$fetchIAMMinInterval$2.INSTANCE);
    }

    public final void setFetchIAMMinInterval(long j) {
        Model.setLongProperty$default(this, "fetchIAMMinInterval", j, (String) null, false, 12, (Object) null);
    }

    public final long getForegroundFetchNotificationPermissionInterval() {
        return getLongProperty("foregroundFetchNotificationPermissionInterval", ConfigModel$foregroundFetchNotificationPermissionInterval$2.INSTANCE);
    }

    public final void setForegroundFetchNotificationPermissionInterval(long j) {
        Model.setLongProperty$default(this, "foregroundFetchNotificationPermissionInterval", j, (String) null, false, 12, (Object) null);
    }

    public final long getBackgroundFetchNotificationPermissionInterval() {
        return getLongProperty("backgroundFetchNotificationPermissionInterval", ConfigModel$backgroundFetchNotificationPermissionInterval$2.INSTANCE);
    }

    public final void setBackgroundFetchNotificationPermissionInterval(long j) {
        Model.setLongProperty$default(this, "backgroundFetchNotificationPermissionInterval", j, (String) null, false, 12, (Object) null);
    }

    public final String getGoogleProjectNumber() {
        return Model.getOptStringProperty$default(this, "googleProjectNumber", (Function0) null, 2, (Object) null);
    }

    public final void setGoogleProjectNumber(String str) {
        Model.setOptStringProperty$default(this, "googleProjectNumber", str, (String) null, false, 12, (Object) null);
    }

    public final boolean getEnterprise() {
        return getBooleanProperty("enterprise", ConfigModel$enterprise$2.INSTANCE);
    }

    public final void setEnterprise(boolean z) {
        Model.setBooleanProperty$default(this, "enterprise", z, (String) null, false, 12, (Object) null);
    }

    public final boolean getUseIdentityVerification() {
        return getBooleanProperty("useIdentityVerification", ConfigModel$useIdentityVerification$2.INSTANCE);
    }

    public final void setUseIdentityVerification(boolean z) {
        Model.setBooleanProperty$default(this, "useIdentityVerification", z, (String) null, false, 12, (Object) null);
    }

    public final JSONArray getNotificationChannels() {
        String optStringProperty = getOptStringProperty("notificationChannels", ConfigModel$notificationChannels$2.INSTANCE);
        if (optStringProperty == null) {
            optStringProperty = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return new JSONArray(optStringProperty);
    }

    public final void setNotificationChannels(JSONArray jSONArray) {
        Model.setOptStringProperty$default(this, "notificationChannels", jSONArray != null ? jSONArray.toString() : null, (String) null, false, 12, (Object) null);
    }

    public final boolean getFirebaseAnalytics() {
        return getBooleanProperty("firebaseAnalytics", ConfigModel$firebaseAnalytics$2.INSTANCE);
    }

    public final void setFirebaseAnalytics(boolean z) {
        Model.setBooleanProperty$default(this, "firebaseAnalytics", z, (String) null, false, 12, (Object) null);
    }

    public final boolean getRestoreTTLFilter() {
        return getBooleanProperty("restoreTTLFilter", ConfigModel$restoreTTLFilter$2.INSTANCE);
    }

    public final void setRestoreTTLFilter(boolean z) {
        Model.setBooleanProperty$default(this, "restoreTTLFilter", z, (String) null, false, 12, (Object) null);
    }

    public final boolean getReceiveReceiptEnabled() {
        return getBooleanProperty("receiveReceiptEnabled", ConfigModel$receiveReceiptEnabled$2.INSTANCE);
    }

    public final void setReceiveReceiptEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "receiveReceiptEnabled", z, (String) null, false, 12, (Object) null);
    }

    public final boolean getClearGroupOnSummaryClick() {
        return getBooleanProperty("clearGroupOnSummaryClick", ConfigModel$clearGroupOnSummaryClick$2.INSTANCE);
    }

    public final void setClearGroupOnSummaryClick(boolean z) {
        Model.setBooleanProperty$default(this, "clearGroupOnSummaryClick", z, (String) null, false, 12, (Object) null);
    }

    public final InfluenceConfigModel getInfluenceParams() {
        Object anyProperty = getAnyProperty("influenceParams", new ConfigModel$influenceParams$2(this));
        Intrinsics.checkNotNull(anyProperty, "null cannot be cast to non-null type com.onesignal.core.internal.config.InfluenceConfigModel");
        return (InfluenceConfigModel) anyProperty;
    }

    public final FCMConfigModel getFcmParams() {
        Object anyProperty = getAnyProperty("fcmParams", new ConfigModel$fcmParams$2(this));
        Intrinsics.checkNotNull(anyProperty, "null cannot be cast to non-null type com.onesignal.core.internal.config.FCMConfigModel");
        return (FCMConfigModel) anyProperty;
    }

    /* access modifiers changed from: protected */
    public Model createModelForProperty(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "property");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        if (Intrinsics.areEqual((Object) str, (Object) "influenceParams")) {
            InfluenceConfigModel influenceConfigModel = new InfluenceConfigModel(this, "influenceParams");
            influenceConfigModel.initializeFromJson(jSONObject);
            return influenceConfigModel;
        } else if (!Intrinsics.areEqual((Object) str, (Object) "fcmParams")) {
            return null;
        } else {
            FCMConfigModel fCMConfigModel = new FCMConfigModel(this, "influenceParams");
            fCMConfigModel.initializeFromJson(jSONObject);
            return fCMConfigModel;
        }
    }
}
