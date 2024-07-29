package com.onesignal.notifications.internal.data.impl;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$doesNotificationExist$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ Ref.BooleanRef $result;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$doesNotificationExist$2(String str, NotificationRepository notificationRepository, Ref.BooleanRef booleanRef, Continuation<? super NotificationRepository$doesNotificationExist$2> continuation) {
        super(2, continuation);
        this.$id = str;
        this.this$0 = notificationRepository;
        this.$result = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$doesNotificationExist$2(this.$id, this.this$0, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$doesNotificationExist$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$id;
            Intrinsics.checkNotNull(str);
            IDatabase os = this.this$0._databaseProvider.getOs();
            final String str2 = this.$id;
            final Ref.BooleanRef booleanRef = this.$result;
            IDatabase.DefaultImpls.query$default(os, OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{"notification_id"}, "notification_id = ?", new String[]{str}, (String) null, (String) null, (String) null, (String) null, new Function1<ICursor, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ICursor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ICursor iCursor) {
                    Intrinsics.checkNotNullParameter(iCursor, "it");
                    if (iCursor.moveToFirst()) {
                        Logging.debug$default("Notification notValidOrDuplicated with id duplicated, duplicate FCM message received, skip processing of " + str2, (Throwable) null, 2, (Object) null);
                        booleanRef.element = true;
                    }
                }
            }, PsExtractor.VIDEO_STREAM_MASK, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
