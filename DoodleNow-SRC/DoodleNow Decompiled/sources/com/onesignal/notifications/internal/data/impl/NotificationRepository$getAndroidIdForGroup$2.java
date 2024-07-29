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
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$getAndroidIdForGroup$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Integer> $recentId;
    final /* synthetic */ String[] $whereArgs;
    final /* synthetic */ Ref.ObjectRef<String> $whereStr;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$getAndroidIdForGroup$2(NotificationRepository notificationRepository, Ref.ObjectRef<String> objectRef, String[] strArr, Ref.ObjectRef<Integer> objectRef2, Continuation<? super NotificationRepository$getAndroidIdForGroup$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationRepository;
        this.$whereStr = objectRef;
        this.$whereArgs = strArr;
        this.$recentId = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$getAndroidIdForGroup$2(this.this$0, this.$whereStr, this.$whereArgs, this.$recentId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$getAndroidIdForGroup$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String[] strArr = this.$whereArgs;
            final Ref.ObjectRef<Integer> objectRef = this.$recentId;
            IDatabase.DefaultImpls.query$default(this.this$0._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, (String) this.$whereStr.element, strArr, (String) null, (String) null, "created_time DESC", "1", new Function1<ICursor, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ICursor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ICursor iCursor) {
                    T t;
                    Intrinsics.checkNotNullParameter(iCursor, "it");
                    boolean moveToFirst = iCursor.moveToFirst();
                    Ref.ObjectRef<Integer> objectRef = objectRef;
                    if (!moveToFirst) {
                        t = null;
                        Integer num = null;
                    } else {
                        t = Integer.valueOf(iCursor.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                    }
                    objectRef.element = t;
                }
            }, 48, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
