package com.onesignal.notifications.internal.registration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS", f = "PushRegistratorHMS.kt", i = {}, l = {34}, m = "registerForPush", n = {}, s = {})
/* compiled from: PushRegistratorHMS.kt */
final class PushRegistratorHMS$registerForPush$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRegistratorHMS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorHMS$registerForPush$1(PushRegistratorHMS pushRegistratorHMS, Continuation<? super PushRegistratorHMS$registerForPush$1> continuation) {
        super(continuation);
        this.this$0 = pushRegistratorHMS;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerForPush(this);
    }
}
