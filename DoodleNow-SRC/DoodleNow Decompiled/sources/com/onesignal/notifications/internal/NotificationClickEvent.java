package com.onesignal.notifications.internal;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.notifications.INotification;
import com.onesignal.notifications.INotificationClickEvent;
import com.onesignal.notifications.INotificationClickResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationClickEvent;", "Lcom/onesignal/notifications/INotificationClickEvent;", "_notification", "Lcom/onesignal/notifications/internal/Notification;", "_result", "Lcom/onesignal/notifications/internal/NotificationClickResult;", "(Lcom/onesignal/notifications/internal/Notification;Lcom/onesignal/notifications/internal/NotificationClickResult;)V", "notification", "Lcom/onesignal/notifications/INotification;", "getNotification", "()Lcom/onesignal/notifications/INotification;", "result", "Lcom/onesignal/notifications/INotificationClickResult;", "getResult", "()Lcom/onesignal/notifications/INotificationClickResult;", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationClickEvent.kt */
public final class NotificationClickEvent implements INotificationClickEvent {
    private final Notification _notification;
    private final NotificationClickResult _result;

    public NotificationClickEvent(Notification notification, NotificationClickResult notificationClickResult) {
        Intrinsics.checkNotNullParameter(notification, "_notification");
        Intrinsics.checkNotNullParameter(notificationClickResult, "_result");
        this._notification = notification;
        this._result = notificationClickResult;
    }

    public INotification getNotification() {
        return this._notification;
    }

    public INotificationClickResult getResult() {
        return this._result;
    }

    public final JSONObject toJSONObject() {
        JSONObject put = new JSONObject().put(OneSignalDbContract.NotificationTable.TABLE_NAME, this._notification.toJSONObject()).put("action", this._result.toJSONObject());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …, _result.toJSONObject())");
        return put;
    }
}
