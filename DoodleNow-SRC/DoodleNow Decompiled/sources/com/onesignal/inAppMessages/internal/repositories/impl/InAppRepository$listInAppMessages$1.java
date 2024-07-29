package com.onesignal.inAppMessages.internal.repositories.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository", f = "InAppRepository.kt", i = {0}, l = {68}, m = "listInAppMessages", n = {"inAppMessages"}, s = {"L$0"})
/* compiled from: InAppRepository.kt */
final class InAppRepository$listInAppMessages$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppRepository$listInAppMessages$1(InAppRepository inAppRepository, Continuation<? super InAppRepository$listInAppMessages$1> continuation) {
        super(continuation);
        this.this$0 = inAppRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.listInAppMessages(this);
    }
}
