package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.Influence;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", i = {}, l = {295}, m = "getUniqueIds", n = {}, s = {})
/* compiled from: OutcomeEventsController.kt */
final class OutcomeEventsController$getUniqueIds$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutcomeEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsController$getUniqueIds$1(OutcomeEventsController outcomeEventsController, Continuation<? super OutcomeEventsController$getUniqueIds$1> continuation) {
        super(continuation);
        this.this$0 = outcomeEventsController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUniqueIds((String) null, (List<Influence>) null, this);
    }
}
