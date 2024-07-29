package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0011\u0010\u0011\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J4\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001aH\u0002J-\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010$\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010&J*\u0010'\u001a\u0004\u0018\u00010\u001a2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010)\u001a\u00020 H\u0002J\u0019\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsRepository;", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "(Lcom/onesignal/core/internal/database/IDatabaseProvider;)V", "addIdToListFromChannel", "", "cachedUniqueOutcomes", "", "Lcom/onesignal/session/internal/outcomes/impl/CachedUniqueOutcome;", "channelIds", "Lorg/json/JSONArray;", "channel", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "addIdsToListFromSource", "sourceBody", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "cleanCachedUniqueOutcomeEventNotifications", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldOutcomeEvent", "event", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEventsToSend", "", "getIAMInfluenceSource", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "iamInfluenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "directSourceBody", "indirectSourceBody", "iamIds", "", "source", "getNotCachedUniqueInfluencesForOutcome", "Lcom/onesignal/session/internal/influence/Influence;", "name", "influences", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationInfluenceSource", "notificationInfluenceType", "notificationIds", "saveOutcomeEvent", "eventParams", "saveUniqueOutcomeEventParams", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutcomeEventsRepository.kt */
public final class OutcomeEventsRepository implements IOutcomeEventsRepository {
    /* access modifiers changed from: private */
    public final IDatabaseProvider _databaseProvider;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OutcomeEventsRepository.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InfluenceType.values().length];
            iArr[InfluenceType.DIRECT.ordinal()] = 1;
            iArr[InfluenceType.INDIRECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OutcomeEventsRepository(IDatabaseProvider iDatabaseProvider) {
        Intrinsics.checkNotNullParameter(iDatabaseProvider, "_databaseProvider");
        this._databaseProvider = iDatabaseProvider;
    }

    public Object deleteOldOutcomeEvent(OutcomeEventParams outcomeEventParams, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new OutcomeEventsRepository$deleteOldOutcomeEvent$2(this, outcomeEventParams, (Continuation<? super OutcomeEventsRepository$deleteOldOutcomeEvent$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public Object saveOutcomeEvent(OutcomeEventParams outcomeEventParams, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new OutcomeEventsRepository$saveOutcomeEvent$2(outcomeEventParams, this, (Continuation<? super OutcomeEventsRepository$saveOutcomeEvent$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAllEventsToSend(kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.session.internal.outcomes.impl.OutcomeEventParams>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005a
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2 r4 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2
            r5 = 0
            r4.<init>(r6, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r0 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r7
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final OutcomeSource getNotificationInfluenceSource(InfluenceType influenceType, OutcomeSourceBody outcomeSourceBody, OutcomeSourceBody outcomeSourceBody2, String str) {
        OutcomeSource outcomeSource;
        int i = WhenMappings.$EnumSwitchMapping$0[influenceType.ordinal()];
        if (i == 1) {
            outcomeSourceBody.setNotificationIds(new JSONArray(str));
            outcomeSource = new OutcomeSource(outcomeSourceBody, (OutcomeSourceBody) null);
        } else if (i != 2) {
            OutcomeSource outcomeSource2 = null;
            return null;
        } else {
            outcomeSourceBody2.setNotificationIds(new JSONArray(str));
            outcomeSource = new OutcomeSource((OutcomeSourceBody) null, outcomeSourceBody2);
        }
        return outcomeSource;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        r7 = r7.setDirectBody(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.onesignal.session.internal.outcomes.impl.OutcomeSource getIAMInfluenceSource(com.onesignal.session.internal.influence.InfluenceType r3, com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r4, com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r5, java.lang.String r6, com.onesignal.session.internal.outcomes.impl.OutcomeSource r7) {
        /*
            r2 = this;
            int[] r0 = com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r0[r3]
            r0 = 1
            r1 = 0
            if (r3 == r0) goto L_0x0026
            r4 = 2
            if (r3 == r4) goto L_0x0010
            goto L_0x003b
        L_0x0010:
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>(r6)
            r5.setInAppMessagesIds(r3)
            if (r7 == 0) goto L_0x0020
            com.onesignal.session.internal.outcomes.impl.OutcomeSource r7 = r7.setIndirectBody((com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody) r5)
            if (r7 != 0) goto L_0x003b
        L_0x0020:
            com.onesignal.session.internal.outcomes.impl.OutcomeSource r7 = new com.onesignal.session.internal.outcomes.impl.OutcomeSource
            r7.<init>(r1, r5)
            goto L_0x003b
        L_0x0026:
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>(r6)
            r4.setInAppMessagesIds(r3)
            if (r7 == 0) goto L_0x0036
            com.onesignal.session.internal.outcomes.impl.OutcomeSource r7 = r7.setDirectBody((com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody) r4)
            if (r7 != 0) goto L_0x003b
        L_0x0036:
            com.onesignal.session.internal.outcomes.impl.OutcomeSource r7 = new com.onesignal.session.internal.outcomes.impl.OutcomeSource
            r7.<init>(r4, r1)
        L_0x003b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getIAMInfluenceSource(com.onesignal.session.internal.influence.InfluenceType, com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody, com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody, java.lang.String, com.onesignal.session.internal.outcomes.impl.OutcomeSource):com.onesignal.session.internal.outcomes.impl.OutcomeSource");
    }

    private final void addIdToListFromChannel(List<CachedUniqueOutcome> list, JSONArray jSONArray, InfluenceChannel influenceChannel) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    String string = jSONArray.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "influenceId");
                    list.add(new CachedUniqueOutcome(string, influenceChannel));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void addIdsToListFromSource(List<CachedUniqueOutcome> list, OutcomeSourceBody outcomeSourceBody) {
        if (outcomeSourceBody != null) {
            JSONArray inAppMessagesIds = outcomeSourceBody.getInAppMessagesIds();
            JSONArray notificationIds = outcomeSourceBody.getNotificationIds();
            addIdToListFromChannel(list, inAppMessagesIds, InfluenceChannel.IAM);
            addIdToListFromChannel(list, notificationIds, InfluenceChannel.NOTIFICATION);
        }
    }

    public Object saveUniqueOutcomeEventParams(OutcomeEventParams outcomeEventParams, Continuation<? super Unit> continuation) {
        Logging.debug$default("OutcomeEventsCache.saveUniqueOutcomeEventParams(eventParams: " + outcomeEventParams + ')', (Throwable) null, 2, (Object) null);
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new OutcomeEventsRepository$saveUniqueOutcomeEventParams$2(outcomeEventParams, this, (Continuation<? super OutcomeEventsRepository$saveUniqueOutcomeEventParams$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getNotCachedUniqueInfluencesForOutcome(java.lang.String r12, java.util.List<com.onesignal.session.internal.influence.Influence> r13, kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.session.internal.influence.Influence>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r12 = r0.L$0
            java.util.List r12 = (java.util.List) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x005f
        L_0x002e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.List r14 = (java.util.List) r14
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2 r10 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2
            r9 = 0
            r4 = r10
            r5 = r13
            r6 = r12
            r7 = r11
            r8 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r2, r10, r0)
            if (r12 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r12 = r14
        L_0x005f:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object cleanCachedUniqueOutcomeEventNotifications(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2(OneSignalDbContract.NotificationTable.TABLE_NAME, "notification_id", this, (Continuation<? super OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
