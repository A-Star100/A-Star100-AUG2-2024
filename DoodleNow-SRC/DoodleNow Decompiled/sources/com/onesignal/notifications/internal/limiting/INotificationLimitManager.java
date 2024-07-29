package com.onesignal.notifications.internal.limiting;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;", "", "clearOldestOverLimit", "", "notificationsToMakeRoomFor", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Constants", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: INotificationLimitManager.kt */
public interface INotificationLimitManager {
    Object clearOldestOverLimit(int i, Continuation<? super Unit> continuation);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager$Constants;", "", "()V", "maxNumberOfNotifications", "", "getMaxNumberOfNotifications", "()I", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: INotificationLimitManager.kt */
    public static final class Constants {
        public static final Constants INSTANCE = new Constants();
        private static final int maxNumberOfNotifications = 49;

        public final int getMaxNumberOfNotifications() {
            return maxNumberOfNotifications;
        }

        private Constants() {
        }
    }
}
