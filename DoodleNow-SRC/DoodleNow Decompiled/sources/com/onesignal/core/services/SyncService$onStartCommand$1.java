package com.onesignal.core.services;

import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.debug.internal.logging.Logging;
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
@DebugMetadata(c = "com.onesignal.core.services.SyncService$onStartCommand$1", f = "SyncService.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SyncService.kt */
final class SyncService$onStartCommand$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<IBackgroundManager> $backgroundService;
    int label;
    final /* synthetic */ SyncService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncService$onStartCommand$1(Ref.ObjectRef<IBackgroundManager> objectRef, SyncService syncService, Continuation<? super SyncService$onStartCommand$1> continuation) {
        super(1, continuation);
        this.$backgroundService = objectRef;
        this.this$0 = syncService;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SyncService$onStartCommand$1(this.$backgroundService, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SyncService$onStartCommand$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((IBackgroundManager) this.$backgroundService.element).runBackgroundServices(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Logging.debug$default("LegacySyncRunnable:Stopped", (Throwable) null, 2, (Object) null);
        this.this$0.stopSelf();
        return Unit.INSTANCE;
    }
}
