package com.onesignal.notifications.internal;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationWillDisplayEvent;", "Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "notification", "Lcom/onesignal/notifications/internal/Notification;", "(Lcom/onesignal/notifications/internal/Notification;)V", "discard", "", "getDiscard", "()Z", "setDiscard", "(Z)V", "isPreventDefault", "setPreventDefault", "getNotification", "()Lcom/onesignal/notifications/internal/Notification;", "preventDefault", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationWillDisplayEvent.kt */
public final class NotificationWillDisplayEvent implements INotificationWillDisplayEvent {
    private boolean discard;
    private boolean isPreventDefault;
    private final Notification notification;

    public final boolean getDiscard() {
        return this.discard;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public final boolean isPreventDefault() {
        return this.isPreventDefault;
    }

    public final void setDiscard(boolean z) {
        this.discard = z;
    }

    public final void setPreventDefault(boolean z) {
        this.isPreventDefault = z;
    }

    public NotificationWillDisplayEvent(Notification notification2) {
        Intrinsics.checkNotNullParameter(notification2, OneSignalDbContract.NotificationTable.TABLE_NAME);
        this.notification = notification2;
    }

    public void preventDefault() {
        preventDefault(false);
    }

    public void preventDefault(boolean z) {
        Logging.debug$default("NotificationWillDisplayEvent.preventDefault()", (Throwable) null, 2, (Object) null);
        this.isPreventDefault = true;
        this.discard = z;
    }
}
