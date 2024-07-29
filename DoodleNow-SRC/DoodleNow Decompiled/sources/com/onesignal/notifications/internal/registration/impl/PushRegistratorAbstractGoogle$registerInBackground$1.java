package com.onesignal.notifications.internal.registration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle", f = "PushRegistratorAbstractGoogle.kt", i = {0, 0, 0, 1, 1, 1}, l = {108, 113}, m = "registerInBackground", n = {"this", "senderId", "currentRetry", "this", "senderId", "currentRetry"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: PushRegistratorAbstractGoogle.kt */
final class PushRegistratorAbstractGoogle$registerInBackground$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRegistratorAbstractGoogle this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorAbstractGoogle$registerInBackground$1(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, Continuation<? super PushRegistratorAbstractGoogle$registerInBackground$1> continuation) {
        super(continuation);
        this.this$0 = pushRegistratorAbstractGoogle;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerInBackground((String) null, this);
    }
}
