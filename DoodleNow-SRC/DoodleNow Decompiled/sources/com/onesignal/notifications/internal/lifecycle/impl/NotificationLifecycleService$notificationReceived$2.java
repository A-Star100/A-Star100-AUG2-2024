package com.onesignal.notifications.internal.lifecycle.impl;

import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationReceived$2", f = "NotificationLifecycleService.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationLifecycleService.kt */
final class NotificationLifecycleService$notificationReceived$2 extends SuspendLambda implements Function2<INotificationLifecycleEventHandler, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotificationGenerationJob $notificationJob;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationLifecycleService$notificationReceived$2(NotificationGenerationJob notificationGenerationJob, Continuation<? super NotificationLifecycleService$notificationReceived$2> continuation) {
        super(2, continuation);
        this.$notificationJob = notificationGenerationJob;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NotificationLifecycleService$notificationReceived$2 notificationLifecycleService$notificationReceived$2 = new NotificationLifecycleService$notificationReceived$2(this.$notificationJob, continuation);
        notificationLifecycleService$notificationReceived$2.L$0 = obj;
        return notificationLifecycleService$notificationReceived$2;
    }

    public final Object invoke(INotificationLifecycleEventHandler iNotificationLifecycleEventHandler, Continuation<? super Unit> continuation) {
        return ((NotificationLifecycleService$notificationReceived$2) create(iNotificationLifecycleEventHandler, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((INotificationLifecycleEventHandler) this.L$0).onNotificationReceived(this.$notificationJob, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
