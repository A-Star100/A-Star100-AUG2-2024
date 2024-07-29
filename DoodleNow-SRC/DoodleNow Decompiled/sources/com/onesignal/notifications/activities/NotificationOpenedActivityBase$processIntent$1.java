package com.onesignal.notifications.activities;

import android.content.Intent;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.activities.NotificationOpenedActivityBase$processIntent$1", f = "NotificationOpenedActivityBase.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationOpenedActivityBase.kt */
final class NotificationOpenedActivityBase$processIntent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotificationOpenedActivityBase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationOpenedActivityBase$processIntent$1(NotificationOpenedActivityBase notificationOpenedActivityBase, Continuation<? super NotificationOpenedActivityBase$processIntent$1> continuation) {
        super(1, continuation);
        this.this$0 = notificationOpenedActivityBase;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NotificationOpenedActivityBase$processIntent$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((NotificationOpenedActivityBase$processIntent$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NotificationOpenedActivityBase notificationOpenedActivityBase = this.this$0;
            Intent intent = notificationOpenedActivityBase.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            this.label = 1;
            if (((INotificationOpenedProcessor) OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessor.class)).processFromContext(notificationOpenedActivityBase, intent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.finish();
        return Unit.INSTANCE;
    }
}
