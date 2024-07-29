package com.onesignal.notifications.internal.registration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM", f = "PushRegistratorFCM.kt", i = {0, 0}, l = {60, 69}, m = "getToken", n = {"this", "senderId"}, s = {"L$0", "L$1"})
/* compiled from: PushRegistratorFCM.kt */
final class PushRegistratorFCM$getToken$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRegistratorFCM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorFCM$getToken$1(PushRegistratorFCM pushRegistratorFCM, Continuation<? super PushRegistratorFCM$getToken$1> continuation) {
        super(continuation);
        this.this$0 = pushRegistratorFCM;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getToken((String) null, this);
    }
}
