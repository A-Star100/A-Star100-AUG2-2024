package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.data.INotificationRepository;
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
import org.json.JSONException;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$listNotificationsForGroup$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<INotificationRepository.NotificationData> $listOfNotifications;
    final /* synthetic */ String $summaryGroup;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$listNotificationsForGroup$2(String str, NotificationRepository notificationRepository, List<INotificationRepository.NotificationData> list, Continuation<? super NotificationRepository$listNotificationsForGroup$2> continuation) {
        super(2, continuation);
        this.$summaryGroup = str;
        this.this$0 = notificationRepository;
        this.$listOfNotifications = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$listNotificationsForGroup$2(this.$summaryGroup, this.this$0, this.$listOfNotifications, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$listNotificationsForGroup$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String[] strArr = {this.$summaryGroup};
            IDatabase os = this.this$0._databaseProvider.getOs();
            String[] columns_for_list_notifications = NotificationRepository.Companion.getCOLUMNS_FOR_LIST_NOTIFICATIONS();
            final List<INotificationRepository.NotificationData> list = this.$listOfNotifications;
            final String str = this.$summaryGroup;
            IDatabase.DefaultImpls.query$default(os, OneSignalDbContract.NotificationTable.TABLE_NAME, columns_for_list_notifications, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", strArr, (String) null, (String) null, "_id DESC", (String) null, new Function1<ICursor, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ICursor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ICursor iCursor) {
                    Intrinsics.checkNotNullParameter(iCursor, "it");
                    if (iCursor.moveToFirst()) {
                        do {
                            try {
                                String optString = iCursor.getOptString("title");
                                String optString2 = iCursor.getOptString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
                                String string = iCursor.getString("notification_id");
                                list.add(new INotificationRepository.NotificationData(iCursor.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID), string, iCursor.getString(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA), iCursor.getLong(OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME), optString, optString2));
                            } catch (JSONException unused) {
                                Logging.error$default("Could not parse JSON of sub notification in group: " + str, (Throwable) null, 2, (Object) null);
                            }
                        } while (iCursor.moveToNext());
                    }
                }
            }, 176, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
