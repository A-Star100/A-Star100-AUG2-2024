package com.onesignal.notifications.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.notifications.INotificationClickResult;
import com.onesignal.notifications.internal.common.NotificationConstants;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationClickResult;", "Lcom/onesignal/notifications/INotificationClickResult;", "actionId", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/String;", "getUrl", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationClickResult.kt */
public final class NotificationClickResult implements INotificationClickResult {
    private final String actionId;
    private final String url;

    public String getActionId() {
        return this.actionId;
    }

    public String getUrl() {
        return this.url;
    }

    public NotificationClickResult(String str, String str2) {
        this.actionId = str;
        this.url = str2;
    }

    public final JSONObject toJSONObject() {
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(new JSONObject(), NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, getActionId()), ImagesContract.URL, getUrl());
    }
}
