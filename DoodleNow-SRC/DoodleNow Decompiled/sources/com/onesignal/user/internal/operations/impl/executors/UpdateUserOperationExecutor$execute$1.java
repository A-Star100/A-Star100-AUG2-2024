package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.core.internal.operations.Operation;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor", f = "UpdateUserOperationExecutor.kt", i = {0, 0, 0, 0}, l = {125}, m = "execute", n = {"this", "ops", "appId", "onesignalId"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: UpdateUserOperationExecutor.kt */
final class UpdateUserOperationExecutor$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateUserOperationExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateUserOperationExecutor$execute$1(UpdateUserOperationExecutor updateUserOperationExecutor, Continuation<? super UpdateUserOperationExecutor$execute$1> continuation) {
        super(continuation);
        this.this$0 = updateUserOperationExecutor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute((List<? extends Operation>) null, this);
    }
}
