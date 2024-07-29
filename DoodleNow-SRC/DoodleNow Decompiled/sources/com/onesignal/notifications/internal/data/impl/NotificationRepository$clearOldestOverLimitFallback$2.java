package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$clearOldestOverLimitFallback$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$clearOldestOverLimitFallback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxNumberOfNotificationsInt;
    final /* synthetic */ int $notificationsToMakeRoomFor;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$clearOldestOverLimitFallback$2(int i, NotificationRepository notificationRepository, int i2, Continuation<? super NotificationRepository$clearOldestOverLimitFallback$2> continuation) {
        super(2, continuation);
        this.$maxNumberOfNotificationsInt = i;
        this.this$0 = notificationRepository;
        this.$notificationsToMakeRoomFor = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$clearOldestOverLimitFallback$2(this.$maxNumberOfNotificationsInt, this.this$0, this.$notificationsToMakeRoomFor, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$clearOldestOverLimitFallback$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String valueOf = String.valueOf(this.$maxNumberOfNotificationsInt);
            try {
                final int i = this.$maxNumberOfNotificationsInt;
                final int i2 = this.$notificationsToMakeRoomFor;
                final NotificationRepository notificationRepository = this.this$0;
                IDatabase.DefaultImpls.query$default(this.this$0._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, this.this$0._queryHelper.recentUninteractedWithNotificationsWhere().toString(), (String[]) null, (String) null, (String) null, "_id", valueOf + this.$notificationsToMakeRoomFor, new Function1<ICursor, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ICursor) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ICursor iCursor) {
                        Intrinsics.checkNotNullParameter(iCursor, "it");
                        int count = (iCursor.getCount() - i) + i2;
                        if (count >= 1) {
                            while (iCursor.moveToNext()) {
                                boolean unused = notificationRepository.internalMarkAsDismissed(iCursor.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                                count--;
                                if (count <= 0) {
                                    return;
                                }
                            }
                        }
                    }
                }, 56, (Object) null);
            } catch (Throwable th) {
                Logging.error("Error clearing oldest notifications over limit! ", th);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
