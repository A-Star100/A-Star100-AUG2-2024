package com.onesignal.notifications.internal.lifecycle.impl;

import android.app.Activity;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleCallback;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2", f = "NotificationLifecycleService.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationLifecycleService.kt */
final class NotificationLifecycleService$canOpenNotification$2 extends SuspendLambda implements Function2<INotificationLifecycleCallback, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Ref.BooleanRef $canOpen;
    final /* synthetic */ JSONObject $data;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationLifecycleService$canOpenNotification$2(Ref.BooleanRef booleanRef, Activity activity, JSONObject jSONObject, Continuation<? super NotificationLifecycleService$canOpenNotification$2> continuation) {
        super(2, continuation);
        this.$canOpen = booleanRef;
        this.$activity = activity;
        this.$data = jSONObject;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NotificationLifecycleService$canOpenNotification$2 notificationLifecycleService$canOpenNotification$2 = new NotificationLifecycleService$canOpenNotification$2(this.$canOpen, this.$activity, this.$data, continuation);
        notificationLifecycleService$canOpenNotification$2.L$0 = obj;
        return notificationLifecycleService$canOpenNotification$2;
    }

    public final Object invoke(INotificationLifecycleCallback iNotificationLifecycleCallback, Continuation<? super Unit> continuation) {
        return ((NotificationLifecycleService$canOpenNotification$2) create(iNotificationLifecycleCallback, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = this.$canOpen;
            this.L$0 = booleanRef2;
            this.label = 1;
            obj = ((INotificationLifecycleCallback) this.L$0).canOpenNotification(this.$activity, this.$data, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        booleanRef.element = ((Boolean) obj).booleanValue();
        return Unit.INSTANCE;
    }
}
