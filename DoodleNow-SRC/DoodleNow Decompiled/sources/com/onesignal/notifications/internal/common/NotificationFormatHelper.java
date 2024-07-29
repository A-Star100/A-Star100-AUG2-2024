package com.onesignal.notifications.internal.common;

import android.content.Intent;
import android.os.Bundle;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/onesignal/notifications/internal/common/NotificationFormatHelper;", "", "()V", "PAYLOAD_OS_NOTIFICATION_ID", "", "PAYLOAD_OS_ROOT_CUSTOM", "getOSNotificationIdFromBundle", "bundle", "Landroid/os/Bundle;", "getOSNotificationIdFromJson", "jsonObject", "Lorg/json/JSONObject;", "getOSNotificationIdFromJsonString", "jsonStr", "isOneSignalBundle", "", "isOneSignalIntent", "intent", "Landroid/content/Intent;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationFormatHelper.kt */
public final class NotificationFormatHelper {
    public static final NotificationFormatHelper INSTANCE = new NotificationFormatHelper();
    public static final String PAYLOAD_OS_NOTIFICATION_ID = "i";
    public static final String PAYLOAD_OS_ROOT_CUSTOM = "custom";

    private NotificationFormatHelper() {
    }

    public final boolean isOneSignalIntent(Intent intent) {
        if (intent == null) {
            return false;
        }
        return isOneSignalBundle(intent.getExtras());
    }

    public final boolean isOneSignalBundle(Bundle bundle) {
        return getOSNotificationIdFromBundle(bundle) != null;
    }

    private final String getOSNotificationIdFromBundle(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            String string = bundle.getString("custom", (String) null);
            if (string != null) {
                return getOSNotificationIdFromJsonString(string);
            }
            Logging.debug$default("Not a OneSignal formatted Bundle. No 'custom' field in the bundle.", (Throwable) null, 2, (Object) null);
        }
        return null;
    }

    public final String getOSNotificationIdFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return getOSNotificationIdFromJsonString(jSONObject.optString("custom", (String) null));
    }

    private final String getOSNotificationIdFromJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("i")) {
                return jSONObject.optString("i", (String) null);
            }
            Logging.debug$default("Not a OneSignal formatted JSON string. No 'i' field in custom.", (Throwable) null, 2, (Object) null);
            return null;
        } catch (JSONException unused) {
            Logging.debug$default("Not a OneSignal formatted JSON String, error parsing string as JSON.", (Throwable) null, 2, (Object) null);
        }
    }
}
