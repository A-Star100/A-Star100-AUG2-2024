package com.onesignal.user.internal.backend.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.backend.impl.IdentityBackendService", f = "IdentityBackendService.kt", i = {}, l = {40}, m = "deleteAlias", n = {}, s = {})
/* compiled from: IdentityBackendService.kt */
final class IdentityBackendService$deleteAlias$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IdentityBackendService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IdentityBackendService$deleteAlias$1(IdentityBackendService identityBackendService, Continuation<? super IdentityBackendService$deleteAlias$1> continuation) {
        super(continuation);
        this.this$0 = identityBackendService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleteAlias((String) null, (String) null, (String) null, (String) null, this);
    }
}
