package com.onesignal.inAppMessages.internal.display.impl;

import android.widget.RelativeLayout;
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
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$finishAfterDelay$2", f = "InAppMessageView.kt", i = {}, l = {464, 466}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessageView.kt */
final class InAppMessageView$finishAfterDelay$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageView$finishAfterDelay$2(InAppMessageView inAppMessageView, Continuation<? super InAppMessageView$finishAfterDelay$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppMessageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppMessageView$finishAfterDelay$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppMessageView$finishAfterDelay$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(600, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.this$0.hasBackground || this.this$0.parentRelativeLayout == null) {
            this.this$0.cleanupViewsAfterDismiss();
            return Unit.INSTANCE;
        }
        InAppMessageView inAppMessageView = this.this$0;
        RelativeLayout access$getParentRelativeLayout$p = inAppMessageView.parentRelativeLayout;
        Intrinsics.checkNotNull(access$getParentRelativeLayout$p);
        this.label = 2;
        if (inAppMessageView.animateAndDismissLayout(access$getParentRelativeLayout$p, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
