package com.onesignal.notifications.internal.restoration;

import com.onesignal.notifications.internal.data.INotificationRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;", "", "process", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNotification", "notification", "Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "delay", "", "(Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: INotificationRestoreProcessor.kt */
public interface INotificationRestoreProcessor {
    Object process(Continuation<? super Unit> continuation);

    Object processNotification(INotificationRepository.NotificationData notificationData, int i, Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: INotificationRestoreProcessor.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object processNotification$default(INotificationRestoreProcessor iNotificationRestoreProcessor, INotificationRepository.NotificationData notificationData, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return iNotificationRestoreProcessor.processNotification(notificationData, i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processNotification");
        }
    }
}
