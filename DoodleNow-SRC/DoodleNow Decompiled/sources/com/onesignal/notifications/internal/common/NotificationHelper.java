package com.onesignal.notifications.internal.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotification;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.NotificationClickResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006J*\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0007J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J \u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\t\u001a\u00020\nH\u0007J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010!J\u000e\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\t\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u0006J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0010H\u0007J\u0010\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/onesignal/notifications/internal/common/NotificationHelper;", "", "()V", "GROUPLESS_SUMMARY_ID", "", "GROUPLESS_SUMMARY_KEY", "", "areNotificationsEnabled", "", "context", "Landroid/content/Context;", "channelId", "assignGrouplessNotifications", "", "grouplessNotifs", "Ljava/util/ArrayList;", "Landroid/service/notification/StatusBarNotification;", "Lkotlin/collections/ArrayList;", "generateNotificationOpenedResult", "Lcom/onesignal/notifications/internal/NotificationClickEvent;", "jsonArray", "Lorg/json/JSONArray;", "time", "Lcom/onesignal/core/internal/time/ITime;", "generateNotificationOpenedResult$com_onesignal_notifications", "getActiveGrouplessNotifications", "getActiveNotifications", "", "(Landroid/content/Context;)[Landroid/service/notification/StatusBarNotification;", "getCampaignNameFromNotification", "notification", "Lcom/onesignal/notifications/INotification;", "getCustomJSONObject", "Lorg/json/JSONObject;", "jsonObject", "getGrouplessNotifsCount", "getNotificationIdFromFCMJson", "fcmJson", "getNotificationManager", "Landroid/app/NotificationManager;", "getSoundUri", "Landroid/net/Uri;", "sound", "isGroupSummary", "notif", "parseVibrationPattern", "", "fcmBundle", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationHelper.kt */
public final class NotificationHelper {
    public static final int GROUPLESS_SUMMARY_ID = -718463522;
    public static final String GROUPLESS_SUMMARY_KEY = "os_group_undefined";
    public static final NotificationHelper INSTANCE = new NotificationHelper();

    private NotificationHelper() {
    }

    public final StatusBarNotification[] getActiveNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StatusBarNotification[] statusBarNotificationArr = new StatusBarNotification[0];
        try {
            StatusBarNotification[] activeNotifications = getNotificationManager(context).getActiveNotifications();
            Intrinsics.checkNotNullExpressionValue(activeNotifications, "getNotificationManager(c…text).activeNotifications");
            return activeNotifications;
        } catch (Throwable unused) {
            return statusBarNotificationArr;
        }
    }

    public final int getGrouplessNotifsCount(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = 0;
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            if (!NotificationCompat.isGroupSummary(statusBarNotification.getNotification()) && Intrinsics.areEqual((Object) GROUPLESS_SUMMARY_KEY, (Object) statusBarNotification.getNotification().getGroup())) {
                i++;
            }
        }
        return i;
    }

    public final ArrayList<StatusBarNotification> getActiveGrouplessNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<StatusBarNotification> arrayList = new ArrayList<>();
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            Notification notification = statusBarNotification.getNotification();
            boolean isGroupSummary = isGroupSummary(statusBarNotification);
            boolean z = notification.getGroup() == null || Intrinsics.areEqual((Object) notification.getGroup(), (Object) GROUPLESS_SUMMARY_KEY);
            if (!isGroupSummary && z) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    public final boolean isGroupSummary(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "notif");
        return (statusBarNotification.getNotification().flags & 512) != 0;
    }

    public final void assignGrouplessNotifications(Context context, ArrayList<StatusBarNotification> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "grouplessNotifs");
        Iterator<StatusBarNotification> it = arrayList.iterator();
        while (it.hasNext()) {
            StatusBarNotification next = it.next();
            Notification.Builder m = Notification.Builder.recoverBuilder(context, next.getNotification());
            Intrinsics.checkNotNullExpressionValue(m, "recoverBuilder(context, …uplessNotif.notification)");
            Notification build = m.setGroup(GROUPLESS_SUMMARY_KEY).setOnlyAlertOnce(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "grouplessNotifBuilder\n  …                 .build()");
            Intrinsics.checkNotNull(context);
            NotificationManagerCompat.from(context).notify(next.getId(), build);
        }
    }

    public static /* synthetic */ boolean areNotificationsEnabled$default(NotificationHelper notificationHelper, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return notificationHelper.areNotificationsEnabled(context, str);
    }

    public final boolean areNotificationsEnabled(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return false;
            }
            if (str == null || Build.VERSION.SDK_INT < 26) {
                return true;
            }
            NotificationManager notificationManager = getNotificationManager(context);
            NotificationChannel m = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (m == null || m.getImportance() != 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final NotificationManager getNotificationManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    public final JSONObject getCustomJSONObject(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        return new JSONObject(jSONObject.optString("custom"));
    }

    public final String getNotificationIdFromFCMJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom"));
            if (jSONObject2.has("i")) {
                return jSONObject2.optString("i", (String) null);
            }
            Logging.debug$default("Not a OneSignal formatted FCM message. No 'i' field in custom.", (Throwable) null, 2, (Object) null);
            return null;
        } catch (JSONException unused) {
            Logging.debug$default("Not a OneSignal formatted FCM message. No 'custom' field in the JSONObject.", (Throwable) null, 2, (Object) null);
        }
    }

    public final long[] parseVibrationPattern(JSONObject jSONObject) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(jSONObject, "fcmBundle");
        try {
            Object opt = jSONObject.opt("vib_pt");
            if (opt instanceof String) {
                jSONArray = new JSONArray((String) opt);
            } else {
                Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type org.json.JSONArray");
                jSONArray = (JSONArray) opt;
            }
            long[] jArr = new long[jSONArray.length()];
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final Uri getSoundUri(Context context, String str) {
        int identifier;
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (!AndroidUtils.INSTANCE.isValidResourceName(str) || (identifier = resources.getIdentifier(str, "raw", packageName)) == 0) {
            int identifier2 = resources.getIdentifier("onesignal_default_sound", "raw", packageName);
            if (identifier2 == 0) {
                return null;
            }
            return Uri.parse("android.resource://" + packageName + IOUtils.DIR_SEPARATOR_UNIX + identifier2);
        }
        return Uri.parse("android.resource://" + packageName + IOUtils.DIR_SEPARATOR_UNIX + identifier);
    }

    public final String getCampaignNameFromNotification(INotification iNotification) {
        String templateId;
        Intrinsics.checkNotNullParameter(iNotification, OneSignalDbContract.NotificationTable.TABLE_NAME);
        String templateName = iNotification.getTemplateName();
        if ((templateName == null || templateName.length() != 0) && ((templateId = iNotification.getTemplateId()) == null || templateId.length() != 0)) {
            return iNotification.getTemplateName() + " - " + iNotification.getTemplateId();
        } else if (iNotification.getTitle() == null) {
            return "";
        } else {
            String title = iNotification.getTitle();
            Intrinsics.checkNotNull(title);
            String title2 = iNotification.getTitle();
            Intrinsics.checkNotNull(title2);
            String substring = title.substring(0, Math.min(10, title2.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
    }

    public final NotificationClickEvent generateNotificationOpenedResult$com_onesignal_notifications(JSONArray jSONArray, ITime iTime) {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        Intrinsics.checkNotNullParameter(iTime, "time");
        int length = jSONArray.length();
        int optInt = jSONArray.optJSONObject(0).optInt(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
        List arrayList = new ArrayList();
        boolean z = true;
        JSONObject jSONObject = null;
        String str = null;
        for (int i = 0; i < length; i++) {
            try {
                jSONObject = jSONArray.getJSONObject(i);
                if (str == null && jSONObject.has(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID)) {
                    str = jSONObject.optString(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, (String) null);
                }
                if (z) {
                    z = false;
                } else {
                    arrayList.add(new com.onesignal.notifications.internal.Notification(jSONObject, iTime));
                }
            } catch (Throwable th) {
                Logging.error("Error parsing JSON item " + i + IOUtils.DIR_SEPARATOR_UNIX + length + " for callback.", th);
            }
        }
        Intrinsics.checkNotNull(jSONObject);
        com.onesignal.notifications.internal.Notification notification = new com.onesignal.notifications.internal.Notification(arrayList, jSONObject, optInt, iTime);
        return new NotificationClickEvent(notification, new NotificationClickResult(str, notification.getLaunchURL()));
    }
}
