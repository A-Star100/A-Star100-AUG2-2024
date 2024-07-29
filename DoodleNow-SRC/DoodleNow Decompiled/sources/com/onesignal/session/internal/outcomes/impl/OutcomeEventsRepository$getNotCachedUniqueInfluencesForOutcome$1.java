package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.Influence;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository", f = "OutcomeEventsRepository.kt", i = {0}, l = {284}, m = "getNotCachedUniqueInfluencesForOutcome", n = {"uniqueInfluences"}, s = {"L$0"})
/* compiled from: OutcomeEventsRepository.kt */
final class OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1(OutcomeEventsRepository outcomeEventsRepository, Continuation<? super OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1> continuation) {
        super(continuation);
        this.this$0 = outcomeEventsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getNotCachedUniqueInfluencesForOutcome((String) null, (List<Influence>) null, this);
    }
}
