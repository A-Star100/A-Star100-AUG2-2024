package com.onesignal.core.internal.operations.impl;

import com.onesignal.core.internal.operations.impl.OperationRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.operations.impl.OperationRepo", f = "OperationRepo.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2}, l = {232, 252, 319}, m = "executeOperations$com_onesignal_core", n = {"this", "ops", "startingOp", "operations", "this", "ops", "startingOp", "operations", "response", "waitTime", "this", "ops"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1"})
/* compiled from: OperationRepo.kt */
final class OperationRepo$executeOperations$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OperationRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OperationRepo$executeOperations$1(OperationRepo operationRepo, Continuation<? super OperationRepo$executeOperations$1> continuation) {
        super(continuation);
        this.this$0 = operationRepo;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeOperations$com_onesignal_core((List<OperationRepo.OperationQueueItem>) null, this);
    }
}
