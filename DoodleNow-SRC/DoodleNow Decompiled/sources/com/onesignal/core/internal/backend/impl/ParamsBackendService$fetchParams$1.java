package com.onesignal.core.internal.backend.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.backend.impl.ParamsBackendService", f = "ParamsBackendService.kt", i = {0}, l = {34}, m = "fetchParams", n = {"this"}, s = {"L$0"})
/* compiled from: ParamsBackendService.kt */
final class ParamsBackendService$fetchParams$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ParamsBackendService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ParamsBackendService$fetchParams$1(ParamsBackendService paramsBackendService, Continuation<? super ParamsBackendService$fetchParams$1> continuation) {
        super(continuation);
        this.this$0 = paramsBackendService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchParams((String) null, (String) null, this);
    }
}
