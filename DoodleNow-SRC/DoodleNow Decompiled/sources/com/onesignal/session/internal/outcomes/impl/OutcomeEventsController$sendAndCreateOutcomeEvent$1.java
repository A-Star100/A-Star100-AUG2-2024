package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.Influence;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", i = {0, 0, 0, 0}, l = {216, 230}, m = "sendAndCreateOutcomeEvent", n = {"this", "name", "eventParams", "timestampSeconds"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* compiled from: OutcomeEventsController.kt */
final class OutcomeEventsController$sendAndCreateOutcomeEvent$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutcomeEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsController$sendAndCreateOutcomeEvent$1(OutcomeEventsController outcomeEventsController, Continuation<? super OutcomeEventsController$sendAndCreateOutcomeEvent$1> continuation) {
        super(continuation);
        this.this$0 = outcomeEventsController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendAndCreateOutcomeEvent((String) null, 0.0f, 0, (List<Influence>) null, this);
    }
}
