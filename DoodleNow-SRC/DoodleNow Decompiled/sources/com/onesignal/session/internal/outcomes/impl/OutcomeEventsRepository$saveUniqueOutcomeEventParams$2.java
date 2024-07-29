package com.onesignal.session.internal.outcomes.impl;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$saveUniqueOutcomeEventParams$2", f = "OutcomeEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutcomeEventsRepository.kt */
final class OutcomeEventsRepository$saveUniqueOutcomeEventParams$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OutcomeEventParams $eventParams;
    int label;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsRepository$saveUniqueOutcomeEventParams$2(OutcomeEventParams outcomeEventParams, OutcomeEventsRepository outcomeEventsRepository, Continuation<? super OutcomeEventsRepository$saveUniqueOutcomeEventParams$2> continuation) {
        super(2, continuation);
        this.$eventParams = outcomeEventParams;
        this.this$0 = outcomeEventsRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutcomeEventsRepository$saveUniqueOutcomeEventParams$2(this.$eventParams, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutcomeEventsRepository$saveUniqueOutcomeEventParams$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String outcomeId = this.$eventParams.getOutcomeId();
            List<CachedUniqueOutcome> arrayList = new ArrayList<>();
            OutcomeSource outcomeSource = this.$eventParams.getOutcomeSource();
            OutcomeSourceBody directBody = outcomeSource != null ? outcomeSource.getDirectBody() : null;
            OutcomeSource outcomeSource2 = this.$eventParams.getOutcomeSource();
            OutcomeSourceBody indirectBody = outcomeSource2 != null ? outcomeSource2.getIndirectBody() : null;
            this.this$0.addIdsToListFromSource(arrayList, directBody);
            this.this$0.addIdsToListFromSource(arrayList, indirectBody);
            for (CachedUniqueOutcome cachedUniqueOutcome : arrayList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("channel_influence_id", cachedUniqueOutcome.getInfluenceId());
                contentValues.put("channel_type", cachedUniqueOutcome.getChannel().toString());
                contentValues.put("name", outcomeId);
                this.this$0._databaseProvider.getOs().insert("cached_unique_outcome", (String) null, contentValues);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
