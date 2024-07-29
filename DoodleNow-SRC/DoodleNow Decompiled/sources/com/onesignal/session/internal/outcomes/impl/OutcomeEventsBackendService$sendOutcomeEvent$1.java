package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService", f = "OutcomeEventsBackendService.kt", i = {}, l = {49}, m = "sendOutcomeEvent", n = {}, s = {})
/* compiled from: OutcomeEventsBackendService.kt */
final class OutcomeEventsBackendService$sendOutcomeEvent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutcomeEventsBackendService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsBackendService$sendOutcomeEvent$1(OutcomeEventsBackendService outcomeEventsBackendService, Continuation<? super OutcomeEventsBackendService$sendOutcomeEvent$1> continuation) {
        super(continuation);
        this.this$0 = outcomeEventsBackendService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendOutcomeEvent((String) null, (String) null, (String) null, (String) null, (Boolean) null, (OutcomeEvent) null, this);
    }
}
