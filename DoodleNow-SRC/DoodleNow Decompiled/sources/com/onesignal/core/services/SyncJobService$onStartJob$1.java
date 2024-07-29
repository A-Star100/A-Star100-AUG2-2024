package com.onesignal.core.services;

import android.app.job.JobParameters;
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
@DebugMetadata(c = "com.onesignal.core.services.SyncJobService$onStartJob$1", f = "SyncJobService.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SyncJobService.kt */
final class SyncJobService$onStartJob$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<IBackgroundManager> $backgroundService;
    final /* synthetic */ JobParameters $jobParameters;
    int label;
    final /* synthetic */ SyncJobService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncJobService$onStartJob$1(Ref.ObjectRef<IBackgroundManager> objectRef, SyncJobService syncJobService, JobParameters jobParameters, Continuation<? super SyncJobService$onStartJob$1> continuation) {
        super(1, continuation);
        this.$backgroundService = objectRef;
        this.this$0 = syncJobService;
        this.$jobParameters = jobParameters;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SyncJobService$onStartJob$1(this.$backgroundService, this.this$0, this.$jobParameters, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SyncJobService$onStartJob$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        Logging.debug$default("LollipopSyncRunnable:JobFinished needsJobReschedule: " + ((IBackgroundManager) this.$backgroundService.element).getNeedsJobReschedule(), (Throwable) null, 2, (Object) null);
        boolean needsJobReschedule = ((IBackgroundManager) this.$backgroundService.element).getNeedsJobReschedule();
        ((IBackgroundManager) this.$backgroundService.element).setNeedsJobReschedule(false);
        this.this$0.jobFinished(this.$jobParameters, needsJobReschedule);
        return Unit.INSTANCE;
    }
}
