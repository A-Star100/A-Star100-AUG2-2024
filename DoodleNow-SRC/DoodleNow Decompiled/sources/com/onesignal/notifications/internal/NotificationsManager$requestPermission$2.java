package com.onesignal.notifications.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.NotificationsManager$requestPermission$2", f = "NotificationsManager.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationsManager.kt */
final class NotificationsManager$requestPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $fallbackToSettings;
    int label;
    final /* synthetic */ NotificationsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationsManager$requestPermission$2(NotificationsManager notificationsManager, boolean z, Continuation<? super NotificationsManager$requestPermission$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationsManager;
        this.$fallbackToSettings = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationsManager$requestPermission$2(this.this$0, this.$fallbackToSettings, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((NotificationsManager$requestPermission$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0._notificationPermissionController.prompt(this.$fallbackToSettings, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
