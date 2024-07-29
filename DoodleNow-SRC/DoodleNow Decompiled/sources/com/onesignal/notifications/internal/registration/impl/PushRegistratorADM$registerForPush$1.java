package com.onesignal.notifications.internal.registration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorADM", f = "PushRegistratorADM.kt", i = {0}, l = {35}, m = "registerForPush", n = {"registrationId"}, s = {"L$0"})
/* compiled from: PushRegistratorADM.kt */
final class PushRegistratorADM$registerForPush$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRegistratorADM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorADM$registerForPush$1(PushRegistratorADM pushRegistratorADM, Continuation<? super PushRegistratorADM$registerForPush$1> continuation) {
        super(continuation);
        this.this$0 = pushRegistratorADM;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerForPush(this);
    }
}
