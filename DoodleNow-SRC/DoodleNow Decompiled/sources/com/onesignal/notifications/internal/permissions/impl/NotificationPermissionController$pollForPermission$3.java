package com.onesignal.notifications.internal.permissions.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$3", f = "NotificationPermissionController.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationPermissionController.kt */
final class NotificationPermissionController$pollForPermission$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    int label;
    final /* synthetic */ NotificationPermissionController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationPermissionController$pollForPermission$3(NotificationPermissionController notificationPermissionController, Continuation<? super NotificationPermissionController$pollForPermission$3> continuation) {
        super(2, continuation);
        this.this$0 = notificationPermissionController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationPermissionController$pollForPermission$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((NotificationPermissionController$pollForPermission$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.pollingWaiter.waitForWake(this);
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
