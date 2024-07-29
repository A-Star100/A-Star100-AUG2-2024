package com.onesignal.location.internal.controller.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.HmsLocationController", f = "HmsLocationController.kt", i = {0, 0}, l = {229}, m = "stop", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* compiled from: HmsLocationController.kt */
final class HmsLocationController$stop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HmsLocationController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HmsLocationController$stop$1(HmsLocationController hmsLocationController, Continuation<? super HmsLocationController$stop$1> continuation) {
        super(continuation);
        this.this$0 = hmsLocationController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.stop(this);
    }
}
