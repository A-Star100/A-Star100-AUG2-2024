package com.onesignal.user.internal.backend.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.backend.impl.UserBackendService", f = "UserBackendService.kt", i = {}, l = {80}, m = "getUser", n = {}, s = {})
/* compiled from: UserBackendService.kt */
final class UserBackendService$getUser$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserBackendService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserBackendService$getUser$1(UserBackendService userBackendService, Continuation<? super UserBackendService$getUser$1> continuation) {
        super(continuation);
        this.this$0 = userBackendService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUser((String) null, (String) null, (String) null, this);
    }
}
