package com.onesignal.notifications.internal.data.impl;

import android.text.TextUtils;
import com.amazon.a.a.o.b.f;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$listNotificationsForOutstanding$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Integer> $excludeAndroidIds;
    final /* synthetic */ List<INotificationRepository.NotificationData> $listOfNotifications;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$listNotificationsForOutstanding$2(NotificationRepository notificationRepository, List<Integer> list, List<INotificationRepository.NotificationData> list2, Continuation<? super NotificationRepository$listNotificationsForOutstanding$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationRepository;
        this.$excludeAndroidIds = list;
        this.$listOfNotifications = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$listNotificationsForOutstanding$2(this.this$0, this.$excludeAndroidIds, this.$listOfNotifications, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$listNotificationsForOutstanding$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder recentUninteractedWithNotificationsWhere = this.this$0._queryHelper.recentUninteractedWithNotificationsWhere();
            if (this.$excludeAndroidIds != null) {
                recentUninteractedWithNotificationsWhere.append(" AND android_notification_id NOT IN (");
                recentUninteractedWithNotificationsWhere.append(TextUtils.join(f.a, this.$excludeAndroidIds));
                recentUninteractedWithNotificationsWhere.append(")");
            }
            IDatabase os = this.this$0._databaseProvider.getOs();
            String[] columns_for_list_notifications = NotificationRepository.Companion.getCOLUMNS_FOR_LIST_NOTIFICATIONS();
            String sb = recentUninteractedWithNotificationsWhere.toString();
            String valueOf = String.valueOf(INotificationLimitManager.Constants.INSTANCE.getMaxNumberOfNotifications());
            final List<INotificationRepository.NotificationData> list = this.$listOfNotifications;
            IDatabase.DefaultImpls.query$default(os, OneSignalDbContract.NotificationTable.TABLE_NAME, columns_for_list_notifications, sb, (String[]) null, (String) null, (String) null, "_id DESC", valueOf, new Function1<ICursor, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ICursor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ICursor iCursor) {
                    Intrinsics.checkNotNullParameter(iCursor, "it");
                    while (iCursor.moveToNext()) {
                        String optString = iCursor.getOptString("title");
                        String optString2 = iCursor.getOptString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
                        String string = iCursor.getString("notification_id");
                        list.add(new INotificationRepository.NotificationData(iCursor.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID), string, iCursor.getString(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA), iCursor.getLong(OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME), optString, optString2));
                    }
                }
            }, 56, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
