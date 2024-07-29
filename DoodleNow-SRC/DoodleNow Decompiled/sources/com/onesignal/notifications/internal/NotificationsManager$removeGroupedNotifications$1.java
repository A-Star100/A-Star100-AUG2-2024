package com.onesignal.notifications.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.NotificationsManager$removeGroupedNotifications$1", f = "NotificationsManager.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationsManager.kt */
final class NotificationsManager$removeGroupedNotifications$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $group;
    int label;
    final /* synthetic */ NotificationsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationsManager$removeGroupedNotifications$1(NotificationsManager notificationsManager, String str, Continuation<? super NotificationsManager$removeGroupedNotifications$1> continuation) {
        super(1, continuation);
        this.this$0 = notificationsManager;
        this.$group = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NotificationsManager$removeGroupedNotifications$1(this.this$0, this.$group, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((NotificationsManager$removeGroupedNotifications$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0._notificationDataController.markAsDismissedForGroup(this.$group, this) == coroutine_suspended) {
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
