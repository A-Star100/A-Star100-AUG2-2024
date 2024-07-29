package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor", f = "SubscriptionOperationExecutor.kt", i = {}, l = {221}, m = "transferSubscription", n = {}, s = {})
/* compiled from: SubscriptionOperationExecutor.kt */
final class SubscriptionOperationExecutor$transferSubscription$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubscriptionOperationExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionOperationExecutor$transferSubscription$1(SubscriptionOperationExecutor subscriptionOperationExecutor, Continuation<? super SubscriptionOperationExecutor$transferSubscription$1> continuation) {
        super(continuation);
        this.this$0 = subscriptionOperationExecutor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transferSubscription((TransferSubscriptionOperation) null, this);
    }
}
