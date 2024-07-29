package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
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
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$getGroupId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $androidId;
    final /* synthetic */ Ref.ObjectRef<String> $groupId;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$getGroupId$2(NotificationRepository notificationRepository, int i, Ref.ObjectRef<String> objectRef, Continuation<? super NotificationRepository$getGroupId$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationRepository;
        this.$androidId = i;
        this.$groupId = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$getGroupId$2(this.this$0, this.$androidId, this.$groupId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$getGroupId$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef<String> objectRef = this.$groupId;
            IDatabase.DefaultImpls.query$default(this.this$0._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_GROUP_ID}, "android_notification_id = " + this.$androidId, (String[]) null, (String) null, (String) null, (String) null, (String) null, new Function1<ICursor, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ICursor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ICursor iCursor) {
                    Intrinsics.checkNotNullParameter(iCursor, "it");
                    if (iCursor.moveToFirst()) {
                        objectRef.element = iCursor.getOptString(OneSignalDbContract.NotificationTable.COLUMN_NAME_GROUP_ID);
                    }
                }
            }, 248, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
