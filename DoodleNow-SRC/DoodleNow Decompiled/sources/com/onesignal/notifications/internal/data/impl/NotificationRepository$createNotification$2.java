package com.onesignal.notifications.internal.data.impl;

import android.content.ContentValues;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
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
import org.json.JSONException;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$createNotification$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$createNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $androidId;
    final /* synthetic */ String $body;
    final /* synthetic */ String $collapseKey;
    final /* synthetic */ long $expireTime;
    final /* synthetic */ String $groupId;
    final /* synthetic */ String $id;
    final /* synthetic */ boolean $isOpened;
    final /* synthetic */ String $jsonPayload;
    final /* synthetic */ boolean $shouldDismissIdenticals;
    final /* synthetic */ String $title;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$createNotification$2(String str, boolean z, int i, NotificationRepository notificationRepository, String str2, String str3, boolean z2, String str4, String str5, long j, String str6, Continuation<? super NotificationRepository$createNotification$2> continuation) {
        super(2, continuation);
        this.$id = str;
        this.$shouldDismissIdenticals = z;
        this.$androidId = i;
        this.this$0 = notificationRepository;
        this.$groupId = str2;
        this.$collapseKey = str3;
        this.$isOpened = z2;
        this.$title = str4;
        this.$body = str5;
        this.$expireTime = j;
        this.$jsonPayload = str6;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$createNotification$2(this.$id, this.$shouldDismissIdenticals, this.$androidId, this.this$0, this.$groupId, this.$collapseKey, this.$isOpened, this.$title, this.$body, this.$expireTime, this.$jsonPayload, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$createNotification$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Logging.debug$default("Saving Notification id=" + this.$id, (Throwable) null, 2, (Object) null);
            try {
                if (this.$shouldDismissIdenticals) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("dismissed", Boxing.boxInt(1));
                    this.this$0._databaseProvider.getOs().update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "android_notification_id = " + this.$androidId, (String[]) null);
                    this.this$0._badgeCountUpdater.update();
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("notification_id", this.$id);
                String str = this.$groupId;
                if (str != null) {
                    contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_GROUP_ID, str);
                }
                String str2 = this.$collapseKey;
                if (str2 != null) {
                    contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_COLLAPSE_ID, str2);
                }
                contentValues2.put("opened", Boxing.boxInt(this.$isOpened ? 1 : 0));
                if (!this.$isOpened) {
                    contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, Boxing.boxInt(this.$androidId));
                }
                String str3 = this.$title;
                if (str3 != null) {
                    contentValues2.put("title", str3);
                }
                String str4 = this.$body;
                if (str4 != null) {
                    contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str4);
                }
                contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_EXPIRE_TIME, Boxing.boxLong(this.$expireTime));
                contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA, this.$jsonPayload);
                this.this$0._databaseProvider.getOs().insertOrThrow(OneSignalDbContract.NotificationTable.TABLE_NAME, (String) null, contentValues2);
                Logging.debug$default("Notification saved values: " + contentValues2, (Throwable) null, 2, (Object) null);
                if (!this.$isOpened) {
                    this.this$0._badgeCountUpdater.update();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
