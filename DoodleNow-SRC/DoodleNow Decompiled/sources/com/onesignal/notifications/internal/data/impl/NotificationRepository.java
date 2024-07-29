package com.onesignal.notifications.internal.data.impl;

import android.content.ContentValues;
import android.content.Context;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012Ji\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0011\u0010$\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010'J#\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u001b\u0010-\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u001f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u00103\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010'J'\u00104\u001a\b\u0012\u0004\u0012\u000202012\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000101H@ø\u0001\u0000¢\u0006\u0002\u00106J3\u00107\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00192\b\u00103\u001a\u0004\u0018\u00010\u00152\u0006\u00109\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010:J\u0019\u0010;\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0019\u0010<\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0011\u0010=\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/onesignal/notifications/internal/data/impl/NotificationRepository;", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_queryHelper", "Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_badgeCountUpdater", "Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;Lcom/onesignal/core/internal/database/IDatabaseProvider;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;)V", "clearOldestOverLimitFallback", "", "notificationsToMakeRoomFor", "", "maxNumberOfNotificationsInt", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotification", "id", "", "groupId", "collapseKey", "shouldDismissIdenticals", "", "isOpened", "androidId", "title", "body", "expireTime", "", "jsonPayload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSummaryNotification", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpiredNotifications", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doesNotificationExist", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndroidIdForGroup", "group", "getSummaryNotification", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndroidIdFromCollapseKey", "getGroupId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalMarkAsDismissed", "listNotificationsForGroup", "", "Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "summaryGroup", "listNotificationsForOutstanding", "excludeAndroidIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsConsumed", "dismissed", "clearGroupOnSummaryClick", "(IZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsDismissed", "markAsDismissedForGroup", "markAsDismissedForOutstanding", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationRepository.kt */
public final class NotificationRepository implements INotificationRepository {
    /* access modifiers changed from: private */
    public static final String[] COLUMNS_FOR_LIST_NOTIFICATIONS = {"title", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "notification_id", OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA, OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long NOTIFICATION_CACHE_DATA_LIFETIME = 604800;
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final IBadgeCountUpdater _badgeCountUpdater;
    /* access modifiers changed from: private */
    public final IDatabaseProvider _databaseProvider;
    /* access modifiers changed from: private */
    public final INotificationQueryHelper _queryHelper;
    /* access modifiers changed from: private */
    public final ITime _time;

    public NotificationRepository(IApplicationService iApplicationService, INotificationQueryHelper iNotificationQueryHelper, IDatabaseProvider iDatabaseProvider, ITime iTime, IBadgeCountUpdater iBadgeCountUpdater) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationQueryHelper, "_queryHelper");
        Intrinsics.checkNotNullParameter(iDatabaseProvider, "_databaseProvider");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(iBadgeCountUpdater, "_badgeCountUpdater");
        this._applicationService = iApplicationService;
        this._queryHelper = iNotificationQueryHelper;
        this._databaseProvider = iDatabaseProvider;
        this._time = iTime;
        this._badgeCountUpdater = iBadgeCountUpdater;
    }

    public Object deleteExpiredNotifications(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new NotificationRepository$deleteExpiredNotifications$2(this, (Continuation<? super NotificationRepository$deleteExpiredNotifications$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public Object markAsDismissedForOutstanding(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new NotificationRepository$markAsDismissedForOutstanding$2(this, (Continuation<? super NotificationRepository$markAsDismissedForOutstanding$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public Object markAsDismissedForGroup(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new NotificationRepository$markAsDismissedForGroup$2(this, str, (Continuation<? super NotificationRepository$markAsDismissedForGroup$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object markAsDismissed(int r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$2
            r5 = 0
            r4.<init>(r8, r6, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r7 = r8
        L_0x0058:
            boolean r7 = r7.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean internalMarkAsDismissed(int i) {
        Context appContext = this._applicationService.getAppContext();
        String str = "android_notification_id = " + i + " AND opened = 0 AND dismissed = 0";
        ContentValues contentValues = new ContentValues();
        boolean z = true;
        contentValues.put("dismissed", 1);
        if (this._databaseProvider.getOs().update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, str, (String[]) null) <= 0) {
            z = false;
        }
        this._badgeCountUpdater.update();
        NotificationHelper.INSTANCE.getNotificationManager(appContext).cancel(i);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doesNotificationExist(java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0063
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r7 == 0) goto L_0x006a
            java.lang.String r8 = ""
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r7)
            if (r8 == 0) goto L_0x0044
            goto L_0x006a
        L_0x0044:
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2
            r5 = 0
            r4.<init>(r7, r6, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r7 = r8
        L_0x0063:
            boolean r7 = r7.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        L_0x006a:
            r7 = 0
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object createSummaryNotification(int i, String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new NotificationRepository$createSummaryNotification$2(i, str, this, (Continuation<? super NotificationRepository$createSummaryNotification$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public Object createNotification(String str, String str2, String str3, boolean z, boolean z2, int i, String str4, String str5, long j, String str6, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new NotificationRepository$createNotification$2(str, z, i, this, str2, str3, z2, str4, str5, j, str6, (Continuation<? super NotificationRepository$createNotification$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public Object markAsConsumed(int i, boolean z, String str, boolean z2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new NotificationRepository$markAsConsumed$2(str, z, z2, this, i, (Continuation<? super NotificationRepository$markAsConsumed$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getGroupId(int r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2
            r5 = 0
            r4.<init>(r6, r7, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r7 = r8
        L_0x0058:
            T r7 = r7.element
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAndroidIdFromCollapseKey(java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$2
            r5 = 0
            r4.<init>(r6, r7, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r7 = r8
        L_0x0058:
            T r7 = r7.element
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object clearOldestOverLimitFallback(int i, int i2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new NotificationRepository$clearOldestOverLimitFallback$2(i2, this, i, (Continuation<? super NotificationRepository$clearOldestOverLimitFallback$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object listNotificationsForGroup(java.lang.String r7, kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.notifications.internal.data.INotificationRepository.NotificationData>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005a
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2
            r5 = 0
            r4.<init>(r7, r6, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r7 = r8
        L_0x005a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAndroidIdForGroup(java.lang.String r11, boolean r12, kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ac
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            java.lang.String r2 = "os_group_undefined"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            if (r2 == 0) goto L_0x004f
            java.lang.String r4 = "group_id IS NULL"
            goto L_0x0051
        L_0x004f:
            java.lang.String r4 = "group_id = ?"
        L_0x0051:
            r6.element = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            T r5 = r6.element
            java.lang.String r5 = (java.lang.String) r5
            r4.append(r5)
            java.lang.String r5 = " AND dismissed = 0 AND opened = 0 AND "
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r6.element = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            T r5 = r6.element
            java.lang.String r5 = (java.lang.String) r5
            r4.append(r5)
            if (r12 == 0) goto L_0x007b
            java.lang.String r12 = "is_summary = 1"
            goto L_0x007d
        L_0x007b:
            java.lang.String r12 = "is_summary = 0"
        L_0x007d:
            r4.append(r12)
            java.lang.String r12 = r4.toString()
            r6.element = r12
            if (r2 == 0) goto L_0x008a
            r11 = 0
            goto L_0x008e
        L_0x008a:
            java.lang.String[] r11 = new java.lang.String[]{r11}
        L_0x008e:
            r7 = r11
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2 r12 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2
            r9 = 0
            r4 = r12
            r5 = r10
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r0.L$0 = r13
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r12, r0)
            if (r11 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            r11 = r13
        L_0x00ac:
            T r11 = r11.element
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object listNotificationsForOutstanding(java.util.List<java.lang.Integer> r7, kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.notifications.internal.data.INotificationRepository.NotificationData>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005a
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2
            r5 = 0
            r4.<init>(r6, r7, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r7 = r8
        L_0x005a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/onesignal/notifications/internal/data/impl/NotificationRepository$Companion;", "", "()V", "COLUMNS_FOR_LIST_NOTIFICATIONS", "", "", "getCOLUMNS_FOR_LIST_NOTIFICATIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "NOTIFICATION_CACHE_DATA_LIFETIME", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getCOLUMNS_FOR_LIST_NOTIFICATIONS() {
            return NotificationRepository.COLUMNS_FOR_LIST_NOTIFICATIONS;
        }
    }
}
