package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$deleteExpiredNotifications$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$deleteExpiredNotifications$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$deleteExpiredNotifications$2(NotificationRepository notificationRepository, Continuation<? super NotificationRepository$deleteExpiredNotifications$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$deleteExpiredNotifications$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$deleteExpiredNotifications$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String valueOf = String.valueOf((this.this$0._time.getCurrentTimeMillis() / 1000) - 604800);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(\n               …FETIME,\n                )");
            this.this$0._databaseProvider.getOs().delete(OneSignalDbContract.NotificationTable.TABLE_NAME, "created_time < ?", new String[]{valueOf});
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
