package com.onesignal.notifications.internal.channels.impl;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/onesignal/notifications/internal/channels/impl/NotificationChannelManager;", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "hexPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "createChannel", "", "context", "Landroid/content/Context;", "notificationManager", "Landroid/app/NotificationManager;", "payload", "Lorg/json/JSONObject;", "createDefaultChannel", "createNotificationChannel", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "createRestoreChannel", "priorityToImportance", "", "priority", "processChannelList", "", "list", "Lorg/json/JSONArray;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationChannelManager.kt */
public final class NotificationChannelManager implements INotificationChannelManager {
    private static final String CHANNEL_PREFIX = "OS_";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_CHANNEL_ID = "fcm_fallback_notification_channel";
    private static final String RESTORE_CHANNEL_ID = "restored_OS_notifications";
    private final IApplicationService _applicationService;
    private final ILanguageContext _languageContext;
    private final Pattern hexPattern = Pattern.compile("^([A-Fa-f0-9]{8})$");

    private final int priorityToImportance(int i) {
        if (i > 9) {
            return 5;
        }
        if (i > 7) {
            return 4;
        }
        if (i > 5) {
            return 3;
        }
        if (i > 3) {
            return 2;
        }
        return i > 1 ? 1 : 0;
    }

    public NotificationChannelManager(IApplicationService iApplicationService, ILanguageContext iLanguageContext) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iLanguageContext, "_languageContext");
        this._applicationService = iApplicationService;
        this._languageContext = iLanguageContext;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/internal/channels/impl/NotificationChannelManager$Companion;", "", "()V", "CHANNEL_PREFIX", "", "DEFAULT_CHANNEL_ID", "RESTORE_CHANNEL_ID", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationChannelManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String createNotificationChannel(NotificationGenerationJob notificationGenerationJob) {
        Intrinsics.checkNotNullParameter(notificationGenerationJob, "notificationJob");
        if (Build.VERSION.SDK_INT < 26) {
            return "fcm_fallback_notification_channel";
        }
        Context appContext = this._applicationService.getAppContext();
        JSONObject jsonPayload = notificationGenerationJob.getJsonPayload();
        Intrinsics.checkNotNull(jsonPayload);
        NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(appContext);
        if (notificationGenerationJob.isRestoring()) {
            return createRestoreChannel(notificationManager);
        }
        if (jsonPayload.has("oth_chnl")) {
            String optString = jsonPayload.optString("oth_chnl");
            if (notificationManager.getNotificationChannel(optString) != null) {
                Intrinsics.checkNotNullExpressionValue(optString, "otherChannel");
                return optString;
            }
        }
        if (!jsonPayload.has("chnl")) {
            return createDefaultChannel(notificationManager);
        }
        try {
            return createChannel(appContext, notificationManager, jsonPayload);
        } catch (JSONException e) {
            Logging.error("Could not create notification channel due to JSON payload error!", e);
            return "fcm_fallback_notification_channel";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String createChannel(android.content.Context r9, android.app.NotificationManager r10, org.json.JSONObject r11) throws org.json.JSONException {
        /*
            r8 = this;
            java.lang.String r0 = "chnl"
            java.lang.Object r0 = r11.opt(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x0012
            org.json.JSONObject r1 = new org.json.JSONObject
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r0)
            goto L_0x001a
        L_0x0012:
            java.lang.String r1 = "null cannot be cast to non-null type org.json.JSONObject"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r1 = r0
            org.json.JSONObject r1 = (org.json.JSONObject) r1
        L_0x001a:
            java.lang.String r0 = "id"
            java.lang.String r2 = "fcm_fallback_notification_channel"
            java.lang.String r0 = r1.optString(r0, r2)
            java.lang.String r3 = "miscellaneous"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r2 = r0
        L_0x002c:
            java.lang.String r0 = "langs"
            boolean r3 = r1.has(r0)
            if (r3 == 0) goto L_0x0049
            org.json.JSONObject r0 = r1.getJSONObject(r0)
            com.onesignal.core.internal.language.ILanguageContext r3 = r8._languageContext
            java.lang.String r3 = r3.getLanguage()
            boolean r4 = r0.has(r3)
            if (r4 == 0) goto L_0x0049
            org.json.JSONObject r0 = r0.optJSONObject(r3)
            goto L_0x004a
        L_0x0049:
            r0 = r1
        L_0x004a:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r3 = "nm"
            java.lang.String r4 = "Miscellaneous"
            java.lang.String r3 = r0.optString(r3, r4)
            java.lang.String r4 = "pri"
            r5 = 6
            int r4 = r11.optInt(r4, r5)
            int r4 = r8.priorityToImportance(r4)
            com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0.m()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            android.app.NotificationChannel r3 = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m((java.lang.String) r2, (java.lang.CharSequence) r3, (int) r4)
            java.lang.String r4 = "dscr"
            r5 = 0
            java.lang.String r4 = r0.optString(r4, r5)
            r3.setDescription(r4)
            java.lang.String r4 = "grp_id"
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x0096
            java.lang.String r1 = r1.optString(r4)
            java.lang.String r4 = "grp_nm"
            java.lang.String r0 = r0.optString(r4)
            java.lang.String r4 = "payloadWithText.optString(\"grp_nm\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.app.NotificationChannelGroup r0 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m((java.lang.String) r1, (java.lang.CharSequence) r0)
            r10.createNotificationChannelGroup(r0)
            r3.setGroup(r1)
        L_0x0096:
            java.lang.String r0 = "ledc"
            boolean r1 = r11.has(r0)
            r4 = 2
            if (r1 == 0) goto L_0x00ce
            java.lang.String r0 = r11.optString(r0)
            java.util.regex.Pattern r1 = r8.hexPattern
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.util.regex.Matcher r1 = r1.matcher(r6)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x00b9
            java.lang.String r0 = "OneSignal LED Color Settings: ARGB Hex value incorrect format (E.g: FF9900FF)"
            com.onesignal.debug.internal.logging.Logging.warn$default(r0, r5, r4, r5)
            java.lang.String r0 = "FFFFFFFF"
        L_0x00b9:
            java.math.BigInteger r1 = new java.math.BigInteger     // Catch:{ all -> 0x00c8 }
            r6 = 16
            r1.<init>(r0, r6)     // Catch:{ all -> 0x00c8 }
            int r0 = r1.intValue()     // Catch:{ all -> 0x00c8 }
            r3.setLightColor(r0)     // Catch:{ all -> 0x00c8 }
            goto L_0x00ce
        L_0x00c8:
            r0 = move-exception
            java.lang.String r1 = "Couldn't convert ARGB Hex value to BigInteger:"
            com.onesignal.debug.internal.logging.Logging.error(r1, r0)
        L_0x00ce:
            java.lang.String r0 = "led"
            r1 = 1
            int r0 = r11.optInt(r0, r1)
            r6 = 0
            if (r0 != r1) goto L_0x00da
            r0 = r1
            goto L_0x00db
        L_0x00da:
            r0 = r6
        L_0x00db:
            r3.enableLights(r0)
            java.lang.String r0 = "vib_pt"
            boolean r0 = r11.has(r0)
            if (r0 == 0) goto L_0x00f1
            com.onesignal.notifications.internal.common.NotificationHelper r0 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            long[] r0 = r0.parseVibrationPattern(r11)
            if (r0 == 0) goto L_0x00f1
            r3.setVibrationPattern(r0)
        L_0x00f1:
            java.lang.String r0 = "vib"
            int r0 = r11.optInt(r0, r1)
            if (r0 != r1) goto L_0x00fb
            r0 = r1
            goto L_0x00fc
        L_0x00fb:
            r0 = r6
        L_0x00fc:
            r3.enableVibration(r0)
            java.lang.String r0 = "sound"
            boolean r7 = r11.has(r0)
            if (r7 == 0) goto L_0x012a
            java.lang.String r0 = r11.optString(r0, r5)
            com.onesignal.notifications.internal.common.NotificationHelper r7 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            android.net.Uri r9 = r7.getSoundUri(r9, r0)
            if (r9 == 0) goto L_0x0117
            r3.setSound(r9, r5)
            goto L_0x012a
        L_0x0117:
            java.lang.String r9 = "null"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r0)
            if (r9 != 0) goto L_0x0127
            java.lang.String r9 = "nil"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r0)
            if (r9 == 0) goto L_0x012a
        L_0x0127:
            r3.setSound(r5, r5)
        L_0x012a:
            java.lang.String r9 = "vis"
            int r9 = r11.optInt(r9, r6)
            r3.setLockscreenVisibility(r9)
            java.lang.String r9 = "bdg"
            int r9 = r11.optInt(r9, r1)
            if (r9 != r1) goto L_0x013d
            r9 = r1
            goto L_0x013e
        L_0x013d:
            r9 = r6
        L_0x013e:
            r3.setShowBadge(r9)
            java.lang.String r9 = "bdnd"
            int r9 = r11.optInt(r9, r6)
            if (r9 != r1) goto L_0x014a
            goto L_0x014b
        L_0x014a:
            r1 = r6
        L_0x014b:
            r3.setBypassDnd(r1)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "Creating notification channel with channel:\n"
            r9.<init>(r11)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            com.onesignal.debug.internal.logging.Logging.verbose$default(r9, r5, r4, r5)
            r10.createNotificationChannel(r3)     // Catch:{ IllegalArgumentException -> 0x0163 }
            goto L_0x0167
        L_0x0163:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0167:
            java.lang.String r9 = "channelId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.channels.impl.NotificationChannelManager.createChannel(android.content.Context, android.app.NotificationManager, org.json.JSONObject):java.lang.String");
    }

    private final String createDefaultChannel(NotificationManager notificationManager) {
        Chip$$ExternalSyntheticApiModelOutline0.m();
        NotificationChannel m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("fcm_fallback_notification_channel", (CharSequence) "Miscellaneous", 3);
        m.enableLights(true);
        m.enableVibration(true);
        notificationManager.createNotificationChannel(m);
        return "fcm_fallback_notification_channel";
    }

    private final String createRestoreChannel(NotificationManager notificationManager) {
        Chip$$ExternalSyntheticApiModelOutline0.m();
        notificationManager.createNotificationChannel(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(RESTORE_CHANNEL_ID, (CharSequence) "Restored", 2));
        return RESTORE_CHANNEL_ID;
    }

    public void processChannelList(JSONArray jSONArray) {
        if (Build.VERSION.SDK_INT >= 26 && jSONArray != null && jSONArray.length() != 0) {
            NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(this._applicationService.getAppContext());
            Set hashSet = new HashSet();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    Context appContext = this._applicationService.getAppContext();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "list.getJSONObject(i)");
                    hashSet.add(createChannel(appContext, notificationManager, jSONObject));
                } catch (JSONException e) {
                    Logging.error("Could not create notification channel due to JSON payload error!", e);
                }
            }
            if (!hashSet.isEmpty()) {
                List<Object> arrayList = new ArrayList<>();
                try {
                    List m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(notificationManager);
                    Intrinsics.checkNotNullExpressionValue(m, "notificationManager.notificationChannels");
                    arrayList = m;
                } catch (NullPointerException e2) {
                    Logging.error$default("Error when trying to delete notification channel: " + e2.getMessage(), (Throwable) null, 2, (Object) null);
                }
                for (Object m2 : arrayList) {
                    String m3 = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(m2).getId();
                    Intrinsics.checkNotNullExpressionValue(m3, "id");
                    if (StringsKt.startsWith$default(m3, CHANNEL_PREFIX, false, 2, (Object) null) && !hashSet.contains(m3)) {
                        notificationManager.deleteNotificationChannel(m3);
                    }
                }
            }
        }
    }
}
