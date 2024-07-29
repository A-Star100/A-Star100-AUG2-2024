package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.core.internal.operations.Operation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor", f = "SubscriptionOperationExecutor.kt", i = {0, 0}, l = {178}, m = "updateSubscription", n = {"this", "lastOperation"}, s = {"L$0", "L$1"})
/* compiled from: SubscriptionOperationExecutor.kt */
final class SubscriptionOperationExecutor$updateSubscription$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubscriptionOperationExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionOperationExecutor$updateSubscription$1(SubscriptionOperationExecutor subscriptionOperationExecutor, Continuation<? super SubscriptionOperationExecutor$updateSubscription$1> continuation) {
        super(continuation);
        this.this$0 = subscriptionOperationExecutor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSubscription((UpdateSubscriptionOperation) null, (List<? extends Operation>) null, this);
    }
}
