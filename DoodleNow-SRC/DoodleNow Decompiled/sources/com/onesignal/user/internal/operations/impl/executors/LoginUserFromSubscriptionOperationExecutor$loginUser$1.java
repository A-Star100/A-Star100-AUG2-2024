package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor", f = "LoginUserFromSubscriptionOperationExecutor.kt", i = {0, 0}, l = {46}, m = "loginUser", n = {"this", "loginUserOp"}, s = {"L$0", "L$1"})
/* compiled from: LoginUserFromSubscriptionOperationExecutor.kt */
final class LoginUserFromSubscriptionOperationExecutor$loginUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginUserFromSubscriptionOperationExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginUserFromSubscriptionOperationExecutor$loginUser$1(LoginUserFromSubscriptionOperationExecutor loginUserFromSubscriptionOperationExecutor, Continuation<? super LoginUserFromSubscriptionOperationExecutor$loginUser$1> continuation) {
        super(continuation);
        this.this$0 = loginUserFromSubscriptionOperationExecutor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loginUser((LoginUserFromSubscriptionOperation) null, this);
    }
}
