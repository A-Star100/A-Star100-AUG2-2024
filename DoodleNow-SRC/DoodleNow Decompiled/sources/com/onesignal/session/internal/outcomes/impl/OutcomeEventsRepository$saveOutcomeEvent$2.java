package com.onesignal.session.internal.outcomes.impl;

import android.content.ContentValues;
import com.onesignal.session.internal.influence.InfluenceType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/ContentValues;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$saveOutcomeEvent$2", f = "OutcomeEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutcomeEventsRepository.kt */
final class OutcomeEventsRepository$saveOutcomeEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ContentValues>, Object> {
    final /* synthetic */ OutcomeEventParams $eventParams;
    int label;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsRepository$saveOutcomeEvent$2(OutcomeEventParams outcomeEventParams, OutcomeEventsRepository outcomeEventsRepository, Continuation<? super OutcomeEventsRepository$saveOutcomeEvent$2> continuation) {
        super(2, continuation);
        this.$eventParams = outcomeEventParams;
        this.this$0 = outcomeEventsRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutcomeEventsRepository$saveOutcomeEvent$2(this.$eventParams, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ContentValues> continuation) {
        return ((OutcomeEventsRepository$saveOutcomeEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        OutcomeSourceBody indirectBody;
        OutcomeSourceBody directBody;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new JSONArray();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = new JSONArray();
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = InfluenceType.UNATTRIBUTED;
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = InfluenceType.UNATTRIBUTED;
            OutcomeSource outcomeSource = this.$eventParams.getOutcomeSource();
            if (!(outcomeSource == null || (directBody = outcomeSource.getDirectBody()) == null)) {
                T notificationIds = directBody.getNotificationIds();
                if (notificationIds != null && notificationIds.length() > 0) {
                    objectRef3.element = InfluenceType.DIRECT;
                    objectRef.element = notificationIds;
                }
                T inAppMessagesIds = directBody.getInAppMessagesIds();
                if (inAppMessagesIds != null && inAppMessagesIds.length() > 0) {
                    objectRef4.element = InfluenceType.DIRECT;
                    objectRef2.element = inAppMessagesIds;
                }
            }
            OutcomeSource outcomeSource2 = this.$eventParams.getOutcomeSource();
            if (!(outcomeSource2 == null || (indirectBody = outcomeSource2.getIndirectBody()) == null)) {
                T notificationIds2 = indirectBody.getNotificationIds();
                if (notificationIds2 != null && notificationIds2.length() > 0) {
                    objectRef3.element = InfluenceType.INDIRECT;
                    objectRef.element = notificationIds2;
                }
                T inAppMessagesIds2 = indirectBody.getInAppMessagesIds();
                if (inAppMessagesIds2 != null && inAppMessagesIds2.length() > 0) {
                    objectRef4.element = InfluenceType.INDIRECT;
                    objectRef2.element = inAppMessagesIds2;
                }
            }
            ContentValues contentValues = new ContentValues();
            OutcomeEventParams outcomeEventParams = this.$eventParams;
            contentValues.put("notification_ids", ((JSONArray) objectRef.element).toString());
            contentValues.put(OutcomeEventsTable.COLUMN_NAME_IAM_IDS, ((JSONArray) objectRef2.element).toString());
            String influenceType = ((InfluenceType) objectRef3.element).toString();
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = influenceType.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            contentValues.put(OutcomeEventsTable.COLUMN_NAME_NOTIFICATION_INFLUENCE_TYPE, lowerCase);
            String influenceType2 = ((InfluenceType) objectRef4.element).toString();
            Locale locale2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
            String lowerCase2 = influenceType2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            contentValues.put(OutcomeEventsTable.COLUMN_NAME_IAM_INFLUENCE_TYPE, lowerCase2);
            contentValues.put("name", outcomeEventParams.getOutcomeId());
            contentValues.put("weight", Boxing.boxFloat(outcomeEventParams.getWeight()));
            contentValues.put("timestamp", Boxing.boxLong(outcomeEventParams.getTimestamp()));
            contentValues.put("session_time", Boxing.boxLong(outcomeEventParams.getSessionTime()));
            this.this$0._databaseProvider.getOs().insert("outcome", (String) null, contentValues);
            return contentValues;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
