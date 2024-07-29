package com.onesignal.notifications.internal.generation.impl;

import com.onesignal.notifications.internal.Notification;
import com.onesignal.notifications.internal.NotificationWillDisplayEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3", f = "NotificationGenerationProcessor.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationGenerationProcessor.kt */
final class NotificationGenerationProcessor$processNotificationData$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Notification $notification;
    final /* synthetic */ NotificationWillDisplayEvent $notificationWillDisplayEvent;
    final /* synthetic */ Ref.BooleanRef $wantsToDisplay;
    int label;
    final /* synthetic */ NotificationGenerationProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationGenerationProcessor$processNotificationData$3(NotificationGenerationProcessor notificationGenerationProcessor, NotificationWillDisplayEvent notificationWillDisplayEvent, Ref.BooleanRef booleanRef, Notification notification, Continuation<? super NotificationGenerationProcessor$processNotificationData$3> continuation) {
        super(2, continuation);
        this.this$0 = notificationGenerationProcessor;
        this.$notificationWillDisplayEvent = notificationWillDisplayEvent;
        this.$wantsToDisplay = booleanRef;
        this.$notification = notification;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationGenerationProcessor$processNotificationData$3(this.this$0, this.$notificationWillDisplayEvent, this.$wantsToDisplay, this.$notification, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationGenerationProcessor$processNotificationData$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3$1", f = "NotificationGenerationProcessor.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3$1  reason: invalid class name */
    /* compiled from: NotificationGenerationProcessor.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(notificationGenerationProcessor, notificationWillDisplayEvent, booleanRef, notification, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                notificationGenerationProcessor._lifecycleService.externalNotificationWillShowInForeground(notificationWillDisplayEvent);
                if (notificationWillDisplayEvent.getDiscard()) {
                    booleanRef.element = false;
                } else if (notificationWillDisplayEvent.isPreventDefault()) {
                    booleanRef.element = false;
                    this.label = 1;
                    if (notification.getDisplayWaiter().waitForWake(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef.element = true;
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final NotificationGenerationProcessor notificationGenerationProcessor = this.this$0;
            final NotificationWillDisplayEvent notificationWillDisplayEvent = this.$notificationWillDisplayEvent;
            final Ref.BooleanRef booleanRef = this.$wantsToDisplay;
            final Notification notification = this.$notification;
            this.label = 1;
            if (BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null).join(this) == coroutine_suspended) {
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
