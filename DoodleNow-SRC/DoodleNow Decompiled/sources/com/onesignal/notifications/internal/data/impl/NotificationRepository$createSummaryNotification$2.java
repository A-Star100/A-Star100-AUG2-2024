package com.onesignal.notifications.internal.data.impl;

import android.content.ContentValues;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$createSummaryNotification$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$createSummaryNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $androidId;
    final /* synthetic */ String $groupId;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$createSummaryNotification$2(int i, String str, NotificationRepository notificationRepository, Continuation<? super NotificationRepository$createSummaryNotification$2> continuation) {
        super(2, continuation);
        this.$androidId = i;
        this.$groupId = str;
        this.this$0 = notificationRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$createSummaryNotification$2(this.$androidId, this.$groupId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$createSummaryNotification$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ContentValues contentValues = new ContentValues();
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, Boxing.boxInt(this.$androidId));
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_GROUP_ID, this.$groupId);
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_IS_SUMMARY, Boxing.boxInt(1));
            this.this$0._databaseProvider.getOs().insertOrThrow(OneSignalDbContract.NotificationTable.TABLE_NAME, (String) null, contentValues);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
