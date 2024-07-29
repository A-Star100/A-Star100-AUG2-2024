package com.onesignal.notifications.activities;

import android.content.Intent;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.activities.NotificationOpenedActivityHMS$processOpen$1", f = "NotificationOpenedActivityHMS.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationOpenedActivityHMS.kt */
final class NotificationOpenedActivityHMS$processOpen$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ Ref.ObjectRef<INotificationOpenedProcessorHMS> $notificationPayloadProcessorHMS;
    final /* synthetic */ NotificationOpenedActivityHMS $self;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationOpenedActivityHMS$processOpen$1(Ref.ObjectRef<INotificationOpenedProcessorHMS> objectRef, NotificationOpenedActivityHMS notificationOpenedActivityHMS, Intent intent, Continuation<? super NotificationOpenedActivityHMS$processOpen$1> continuation) {
        super(1, continuation);
        this.$notificationPayloadProcessorHMS = objectRef;
        this.$self = notificationOpenedActivityHMS;
        this.$intent = intent;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NotificationOpenedActivityHMS$processOpen$1(this.$notificationPayloadProcessorHMS, this.$self, this.$intent, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((NotificationOpenedActivityHMS$processOpen$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((INotificationOpenedProcessorHMS) this.$notificationPayloadProcessorHMS.element).handleHMSNotificationOpenIntent(this.$self, this.$intent, this) == coroutine_suspended) {
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
