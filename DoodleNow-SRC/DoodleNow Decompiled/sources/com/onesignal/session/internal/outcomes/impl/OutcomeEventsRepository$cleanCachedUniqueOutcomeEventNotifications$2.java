package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.InfluenceChannel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2", f = "OutcomeEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutcomeEventsRepository.kt */
final class OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $notificationIdColumnName;
    final /* synthetic */ String $notificationTableName;
    int label;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2(String str, String str2, OutcomeEventsRepository outcomeEventsRepository, Continuation<? super OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2> continuation) {
        super(2, continuation);
        this.$notificationTableName = str;
        this.$notificationIdColumnName = str2;
        this.this$0 = outcomeEventsRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2(this.$notificationTableName, this.$notificationIdColumnName, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb = new StringBuilder("NOT EXISTS(SELECT NULL FROM ");
            sb.append(this.$notificationTableName);
            sb.append(" n WHERE n.");
            sb.append(this.$notificationIdColumnName);
            sb.append(" = channel_influence_id AND channel_type = \"");
            String influenceChannel = InfluenceChannel.NOTIFICATION.toString();
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = influenceChannel.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            sb.append("\")");
            this.this$0._databaseProvider.getOs().delete("cached_unique_outcome", sb.toString(), (String[]) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
