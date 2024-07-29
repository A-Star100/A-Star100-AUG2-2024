package com.onesignal.inAppMessages.internal.display.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$setUpDraggableLayout$1$onDismiss$1", f = "InAppMessageView.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessageView.kt */
final class InAppMessageView$setUpDraggableLayout$1$onDismiss$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageView$setUpDraggableLayout$1$onDismiss$1(InAppMessageView inAppMessageView, Continuation<? super InAppMessageView$setUpDraggableLayout$1$onDismiss$1> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessageView;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessageView$setUpDraggableLayout$1$onDismiss$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessageView$setUpDraggableLayout$1$onDismiss$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.finishAfterDelay(this) == coroutine_suspended) {
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
