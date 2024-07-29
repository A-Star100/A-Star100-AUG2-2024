package com.onesignal.notifications.internal.registration.impl;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS", f = "PushRegistratorHMS.kt", i = {0}, l = {77}, m = "getHMSTokenTask", n = {"pushToken"}, s = {"L$0"})
/* compiled from: PushRegistratorHMS.kt */
final class PushRegistratorHMS$getHMSTokenTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRegistratorHMS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorHMS$getHMSTokenTask$1(PushRegistratorHMS pushRegistratorHMS, Continuation<? super PushRegistratorHMS$getHMSTokenTask$1> continuation) {
        super(continuation);
        this.this$0 = pushRegistratorHMS;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getHMSTokenTask((Context) null, this);
    }
}
