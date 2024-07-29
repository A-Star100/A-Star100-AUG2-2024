package com.onesignal.user.internal.migrations;

import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.user.internal.migrations.RecoverFromDroppedLoginBug$start$1", f = "RecoverFromDroppedLoginBug.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RecoverFromDroppedLoginBug.kt */
final class RecoverFromDroppedLoginBug$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RecoverFromDroppedLoginBug this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecoverFromDroppedLoginBug$start$1(RecoverFromDroppedLoginBug recoverFromDroppedLoginBug, Continuation<? super RecoverFromDroppedLoginBug$start$1> continuation) {
        super(2, continuation);
        this.this$0 = recoverFromDroppedLoginBug;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RecoverFromDroppedLoginBug$start$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RecoverFromDroppedLoginBug$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0._operationRepo.awaitInitialized(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.isInBadState()) {
            Logging.warn$default("User with externalId:" + ((IdentityModel) this.this$0._identityModelStore.getModel()).getExternalId() + " was in a bad state, causing it to not update on OneSignal's backend! We are recovering and replaying all unsent operations now.", (Throwable) null, 2, (Object) null);
            this.this$0.recoverByAddingBackDroppedLoginOperation();
        }
        return Unit.INSTANCE;
    }
}
