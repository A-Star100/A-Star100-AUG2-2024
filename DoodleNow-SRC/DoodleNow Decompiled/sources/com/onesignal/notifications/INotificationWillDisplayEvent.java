package com.onesignal.notifications;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "", "notification", "Lcom/onesignal/notifications/IDisplayableNotification;", "getNotification", "()Lcom/onesignal/notifications/IDisplayableNotification;", "preventDefault", "", "discard", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: INotificationWillDisplayEvent.kt */
public interface INotificationWillDisplayEvent {
    IDisplayableNotification getNotification();

    void preventDefault();

    void preventDefault(boolean z);
}
