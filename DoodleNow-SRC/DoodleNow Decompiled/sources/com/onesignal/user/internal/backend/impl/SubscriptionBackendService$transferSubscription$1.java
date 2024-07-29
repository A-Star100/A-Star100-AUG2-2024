package com.onesignal.user.internal.backend.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.backend.impl.SubscriptionBackendService", f = "SubscriptionBackendService.kt", i = {}, l = {76}, m = "transferSubscription", n = {}, s = {})
/* compiled from: SubscriptionBackendService.kt */
final class SubscriptionBackendService$transferSubscription$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubscriptionBackendService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionBackendService$transferSubscription$1(SubscriptionBackendService subscriptionBackendService, Continuation<? super SubscriptionBackendService$transferSubscription$1> continuation) {
        super(continuation);
        this.this$0 = subscriptionBackendService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transferSubscription((String) null, (String) null, (String) null, (String) null, this);
    }
}
