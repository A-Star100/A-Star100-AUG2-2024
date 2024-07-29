package com.onesignal.session.internal.outcomes.impl;

import com.amazon.a.a.o.b;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.InfluenceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2", f = "OutcomeEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutcomeEventsRepository.kt */
final class OutcomeEventsRepository$getAllEventsToSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OutcomeEventParams> $events;
    int label;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsRepository$getAllEventsToSend$2(OutcomeEventsRepository outcomeEventsRepository, List<OutcomeEventParams> list, Continuation<? super OutcomeEventsRepository$getAllEventsToSend$2> continuation) {
        super(2, continuation);
        this.this$0 = outcomeEventsRepository;
        this.$events = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutcomeEventsRepository$getAllEventsToSend$2(this.this$0, this.$events, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutcomeEventsRepository$getAllEventsToSend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IDatabase os = this.this$0._databaseProvider.getOs();
            final OutcomeEventsRepository outcomeEventsRepository = this.this$0;
            final List<OutcomeEventParams> list = this.$events;
            IDatabase.DefaultImpls.query$default(os, "outcome", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null, new Function1<ICursor, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ICursor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ICursor iCursor) {
                    ICursor iCursor2 = iCursor;
                    Intrinsics.checkNotNullParameter(iCursor2, b.b);
                    if (iCursor.moveToFirst()) {
                        do {
                            InfluenceType fromString = InfluenceType.Companion.fromString(iCursor2.getString(OutcomeEventsTable.COLUMN_NAME_NOTIFICATION_INFLUENCE_TYPE));
                            InfluenceType fromString2 = InfluenceType.Companion.fromString(iCursor2.getString(OutcomeEventsTable.COLUMN_NAME_IAM_INFLUENCE_TYPE));
                            String optString = iCursor2.getOptString("notification_ids");
                            if (optString == null) {
                                optString = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                            }
                            String optString2 = iCursor2.getOptString(OutcomeEventsTable.COLUMN_NAME_IAM_IDS);
                            String str = optString2 == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : optString2;
                            String string = iCursor2.getString("name");
                            float f = iCursor2.getFloat("weight");
                            long j = iCursor2.getLong("timestamp");
                            long j2 = iCursor2.getLong("session_time");
                            try {
                                OutcomeSourceBody outcomeSourceBody = new OutcomeSourceBody((JSONArray) null, (JSONArray) null, 3, (DefaultConstructorMarker) null);
                                OutcomeSourceBody outcomeSourceBody2 = new OutcomeSourceBody((JSONArray) null, (JSONArray) null, 3, (DefaultConstructorMarker) null);
                                OutcomeSource access$getNotificationInfluenceSource = outcomeEventsRepository.getNotificationInfluenceSource(fromString, outcomeSourceBody, outcomeSourceBody2, optString);
                                OutcomeSource unused = outcomeEventsRepository.getIAMInfluenceSource(fromString2, outcomeSourceBody, outcomeSourceBody2, str, access$getNotificationInfluenceSource);
                                if (access$getNotificationInfluenceSource == null) {
                                    access$getNotificationInfluenceSource = new OutcomeSource((OutcomeSourceBody) null, (OutcomeSourceBody) null);
                                }
                                list.add(new OutcomeEventParams(string, access$getNotificationInfluenceSource, f, j2, j));
                            } catch (JSONException e) {
                                Logging.error("Generating JSONArray from notifications ids outcome:JSON Failed.", e);
                            }
                        } while (iCursor.moveToNext());
                    }
                }
            }, 254, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
