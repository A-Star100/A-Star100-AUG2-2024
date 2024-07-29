package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", i = {0, 1}, l = {66, 68}, m = "sendSavedOutcomes", n = {"this", "this"}, s = {"L$0", "L$0"})
/* compiled from: OutcomeEventsController.kt */
final class OutcomeEventsController$sendSavedOutcomes$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutcomeEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsController$sendSavedOutcomes$1(OutcomeEventsController outcomeEventsController, Continuation<? super OutcomeEventsController$sendSavedOutcomes$1> continuation) {
        super(continuation);
        this.this$0 = outcomeEventsController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendSavedOutcomes(this);
    }
}
