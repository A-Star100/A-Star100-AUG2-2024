package com.onesignal.notifications.internal.display.impl;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.onesignal.common.AndroidSupportV4Compat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.exceptions.MainThreadException;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.R;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0002J*\u0010#\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0002J\u0019\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020+2\u0006\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0014\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\u0017H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010/2\u0006\u00104\u001a\u00020\u0017H\u0002J\u0010\u00105\u001a\u00020)2\u0006\u00100\u001a\u00020\u0017H\u0002J\u0012\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\u0017H\u0002J!\u00108\u001a\u0004\u0018\u00010)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010:J2\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020=2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017H\u0002J\u0019\u0010A\u001a\u00020+2\u0006\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayer;", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationLimitManager", "Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;", "_summaryNotificationDisplayer", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_notificationDisplayBuilder", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;)V", "contextResources", "Landroid/content/res/Resources;", "getContextResources", "()Landroid/content/res/Resources;", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "isRunningOnMainThreadCheck", "", "()Lkotlin/Unit;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "addBackgroundImage", "fcmJson", "Lorg/json/JSONObject;", "notifBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "applyNotificationExtender", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "notificationBuilder", "createGenericPendingIntentsForNotif", "Landroid/app/Notification;", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "gcmBundle", "notificationId", "", "displayIAMPreviewNotification", "", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayNotification", "getBitmap", "Landroid/graphics/Bitmap;", "name", "getBitmapFromAssetsOrResourceName", "bitmapStr", "getBitmapFromURL", "location", "getDrawableId", "getResourceIcon", "iconName", "safeGetColorFromHex", "colorKey", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "setTextColor", "customView", "Landroid/widget/RemoteViews;", "viewId", "colorPayloadKey", "colorDefaultResource", "showNotification", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationDisplayer.kt */
public final class NotificationDisplayer implements INotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;
    private final INotificationLimitManager _notificationLimitManager;
    private final ISummaryNotificationDisplayer _summaryNotificationDisplayer;

    public NotificationDisplayer(IApplicationService iApplicationService, INotificationLimitManager iNotificationLimitManager, ISummaryNotificationDisplayer iSummaryNotificationDisplayer, INotificationDisplayBuilder iNotificationDisplayBuilder) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationLimitManager, "_notificationLimitManager");
        Intrinsics.checkNotNullParameter(iSummaryNotificationDisplayer, "_summaryNotificationDisplayer");
        Intrinsics.checkNotNullParameter(iNotificationDisplayBuilder, "_notificationDisplayBuilder");
        this._applicationService = iApplicationService;
        this._notificationLimitManager = iNotificationLimitManager;
        this._summaryNotificationDisplayer = iSummaryNotificationDisplayer;
        this._notificationDisplayBuilder = iNotificationDisplayBuilder;
    }

    private final Resources getContextResources() {
        return this._applicationService.getAppContext().getResources();
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    private final String getPackageName() {
        return this._applicationService.getAppContext().getPackageName();
    }

    public Object displayNotification(NotificationGenerationJob notificationGenerationJob, Continuation<? super Boolean> continuation) {
        isRunningOnMainThreadCheck();
        return showNotification(notificationGenerationJob, continuation);
    }

    public final Object displayIAMPreviewNotification(NotificationGenerationJob notificationGenerationJob, Continuation<? super Boolean> continuation) {
        return showNotification(notificationGenerationJob, continuation);
    }

    public final Unit isRunningOnMainThreadCheck() {
        if (!AndroidUtils.INSTANCE.isRunningOnMainThread()) {
            return Unit.INSTANCE;
        }
        throw new MainThreadException("Process for showing a notification should never been done on Main Thread!");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r0 = r26
            boolean r3 = r0 instanceof com.onesignal.notifications.internal.display.impl.NotificationDisplayer$showNotification$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.onesignal.notifications.internal.display.impl.NotificationDisplayer$showNotification$1 r3 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayer$showNotification$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.onesignal.notifications.internal.display.impl.NotificationDisplayer$showNotification$1 r3 = new com.onesignal.notifications.internal.display.impl.NotificationDisplayer$showNotification$1
            r3.<init>(r1, r0)
        L_0x001f:
            r9 = r3
            java.lang.Object r0 = r9.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r9.label
            java.lang.String r5 = "os_group_undefined"
            r6 = 24
            r7 = 3
            r8 = 2
            r10 = 1
            if (r4 == 0) goto L_0x0081
            if (r4 == r10) goto L_0x0058
            if (r4 == r8) goto L_0x0040
            if (r4 != r7) goto L_0x0038
            goto L_0x0040
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0040:
            int r2 = r9.I$0
            java.lang.Object r3 = r9.L$3
            android.app.Notification r3 = (android.app.Notification) r3
            java.lang.Object r4 = r9.L$2
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r4 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder) r4
            java.lang.Object r5 = r9.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r9.L$0
            com.onesignal.notifications.internal.display.impl.NotificationDisplayer r5 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayer) r5
            kotlin.ResultKt.throwOnFailure(r0)
            r12 = r10
            goto L_0x0179
        L_0x0058:
            int r2 = r9.I$0
            java.lang.Object r4 = r9.L$7
            androidx.core.app.NotificationCompat$Builder r4 = (androidx.core.app.NotificationCompat.Builder) r4
            java.lang.Object r11 = r9.L$6
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r11 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder) r11
            java.lang.Object r12 = r9.L$5
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r9.L$4
            com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r13 = (com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications) r13
            java.lang.Object r14 = r9.L$3
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r9.L$2
            org.json.JSONObject r15 = (org.json.JSONObject) r15
            java.lang.Object r8 = r9.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r8 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r8
            java.lang.Object r10 = r9.L$0
            com.onesignal.notifications.internal.display.impl.NotificationDisplayer r10 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayer) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r10
            r10 = r11
            goto L_0x0122
        L_0x0081:
            kotlin.ResultKt.throwOnFailure(r0)
            int r4 = r25.getAndroidId()
            org.json.JSONObject r15 = r25.getJsonPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            java.lang.String r0 = "grp"
            java.lang.String r0 = com.onesignal.common.JSONObjectExtensionsKt.safeString(r15, r0)
            com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r8 = new com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications
            android.content.Context r10 = r24.getCurrentContext()
            r8.<init>(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r6) goto L_0x00c4
            com.onesignal.notifications.internal.common.NotificationHelper r10 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            android.content.Context r11 = r24.getCurrentContext()
            java.util.ArrayList r10 = r10.getActiveGrouplessNotifications(r11)
            if (r0 != 0) goto L_0x00c4
            int r11 = r10.size()
            if (r11 < r7) goto L_0x00c4
            com.onesignal.notifications.internal.common.NotificationHelper r0 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            android.content.Context r11 = r24.getCurrentContext()
            r0.assignGrouplessNotifications(r11, r10)
            r14 = r5
            goto L_0x00c5
        L_0x00c4:
            r14 = r0
        L_0x00c5:
            r12 = r10
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r0 = r1._notificationDisplayBuilder
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r10 = r0.getBaseOneSignalNotificationBuilder(r2)
            androidx.core.app.NotificationCompat$Builder r11 = r10.getCompatBuilder()
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r0 = r1._notificationDisplayBuilder
            r22 = 0
            r17 = r0
            r18 = r15
            r19 = r8
            r20 = r11
            r21 = r4
            r17.addNotificationActionButtons(r18, r19, r20, r21, r22)
            r1.addBackgroundImage(r15, r11)     // Catch:{ all -> 0x00e5 }
            goto L_0x00ec
        L_0x00e5:
            r0 = move-exception
            r13 = r0
            java.lang.String r0 = "Could not set background notification image!"
            com.onesignal.debug.internal.logging.Logging.error(r0, r13)
        L_0x00ec:
            r1.applyNotificationExtender(r2, r11)
            boolean r0 = r25.isRestoring()
            if (r0 == 0) goto L_0x00fa
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r0 = r1._notificationDisplayBuilder
            r0.removeNotifyOptions(r11)
        L_0x00fa:
            if (r14 != 0) goto L_0x00fe
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 2
        L_0x00ff:
            com.onesignal.notifications.internal.limiting.INotificationLimitManager r13 = r1._notificationLimitManager
            r9.L$0 = r1
            r9.L$1 = r2
            r9.L$2 = r15
            r9.L$3 = r14
            r9.L$4 = r8
            r9.L$5 = r12
            r9.L$6 = r10
            r9.L$7 = r11
            r9.I$0 = r4
            r7 = 1
            r9.label = r7
            java.lang.Object r0 = r13.clearOldestOverLimit(r0, r9)
            if (r0 != r3) goto L_0x011d
            return r3
        L_0x011d:
            r0 = r1
            r13 = r8
            r8 = r2
            r2 = r4
            r4 = r11
        L_0x0122:
            if (r14 == 0) goto L_0x01a1
            com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer r7 = r0._summaryNotificationDisplayer
            r18 = r7
            r19 = r4
            r20 = r13
            r21 = r15
            r22 = r14
            r23 = r2
            r18.createGenericPendingIntentsForGroup(r19, r20, r21, r22, r23)
            com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer r7 = r0._summaryNotificationDisplayer
            android.app.Notification r11 = r7.createSingleNotificationBeforeSummaryBuilder(r8, r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r7 = 0
            if (r4 < r6) goto L_0x017c
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x017c
            com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer r4 = r0._summaryNotificationDisplayer
            int r5 = r12.size()
            r12 = 1
            int r15 = r5 + 1
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r5 = r0._notificationDisplayBuilder
            int r16 = r5.getGroupAlertBehavior()
            r9.L$0 = r0
            r9.L$1 = r14
            r9.L$2 = r10
            r9.L$3 = r11
            r9.L$4 = r7
            r9.L$5 = r7
            r9.L$6 = r7
            r9.L$7 = r7
            r9.I$0 = r2
            r5 = 2
            r9.label = r5
            r5 = r8
            r6 = r13
            r7 = r15
            r8 = r16
            java.lang.Object r4 = r4.createGrouplessSummaryNotification(r5, r6, r7, r8, r9)
            if (r4 != r3) goto L_0x0176
            return r3
        L_0x0176:
            r5 = r0
            r4 = r10
            r3 = r11
        L_0x0179:
            r10 = r4
            r0 = r5
            goto L_0x01a6
        L_0x017c:
            r12 = 1
            com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer r4 = r0._summaryNotificationDisplayer
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r5 = r0._notificationDisplayBuilder
            int r5 = r5.getGroupAlertBehavior()
            r9.L$0 = r0
            r9.L$1 = r14
            r9.L$2 = r10
            r9.L$3 = r11
            r9.L$4 = r7
            r9.L$5 = r7
            r9.L$6 = r7
            r9.L$7 = r7
            r9.I$0 = r2
            r6 = 3
            r9.label = r6
            java.lang.Object r4 = r4.createSummaryNotification(r8, r10, r5, r9)
            if (r4 != r3) goto L_0x0176
            return r3
        L_0x01a1:
            r12 = 1
            android.app.Notification r3 = r0.createGenericPendingIntentsForNotif(r4, r13, r15, r2)
        L_0x01a6:
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r4 = r0._notificationDisplayBuilder
            r4.addXiaomiSettings(r10, r3)
            android.content.Context r4 = r0.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.core.app.NotificationManagerCompat r4 = androidx.core.app.NotificationManagerCompat.from(r4)
            r4.notify(r2, r3)
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            if (r2 < r4) goto L_0x01d1
            com.onesignal.notifications.internal.common.NotificationHelper r2 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            android.content.Context r0 = r0.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r3 = r3.getChannelId()
            boolean r10 = r2.areNotificationsEnabled(r0, r3)
            goto L_0x01d2
        L_0x01d1:
            r10 = r12
        L_0x01d2:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.NotificationDisplayer.showNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Notification createGenericPendingIntentsForNotif(NotificationCompat.Builder builder, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, JSONObject jSONObject, int i) {
        Random secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt();
        Intent putExtra = intentGeneratorForAttachingToNotifications.getNewBaseIntent(i).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString());
        Intrinsics.checkNotNullExpressionValue(putExtra, "intentGenerator.getNewBa…TA, gcmBundle.toString())");
        PendingIntent newActionPendingIntent = intentGeneratorForAttachingToNotifications.getNewActionPendingIntent(nextInt, putExtra);
        Intrinsics.checkNotNull(builder);
        builder.setContentIntent(newActionPendingIntent);
        builder.setDeleteIntent(this._notificationDisplayBuilder.getNewDismissActionPendingIntent(secureRandom.nextInt(), this._notificationDisplayBuilder.getNewBaseDismissIntent(i)));
        Notification build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "notifBuilder.build()");
        return build;
    }

    private final void applyNotificationExtender(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder) {
        if (notificationGenerationJob.hasExtender()) {
            try {
                Field declaredField = NotificationCompat.Builder.class.getDeclaredField("mNotification");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(builder);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Notification");
                Notification notification = (Notification) obj;
                notificationGenerationJob.setOrgFlags(Integer.valueOf(notification.flags));
                notificationGenerationJob.setOrgSound(notification.sound);
                Intrinsics.checkNotNull(builder);
                com.onesignal.notifications.internal.Notification notification2 = notificationGenerationJob.getNotification();
                Intrinsics.checkNotNull(notification2);
                NotificationCompat.Extender notificationExtender = notification2.getNotificationExtender();
                Intrinsics.checkNotNull(notificationExtender);
                builder.extend(notificationExtender);
                Object obj2 = declaredField.get(builder);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.app.Notification");
                Notification notification3 = (Notification) obj2;
                Field declaredField2 = NotificationCompat.Builder.class.getDeclaredField("mContentText");
                declaredField2.setAccessible(true);
                Field declaredField3 = NotificationCompat.Builder.class.getDeclaredField("mContentTitle");
                declaredField3.setAccessible(true);
                notificationGenerationJob.setOverriddenBodyFromExtender((CharSequence) declaredField2.get(builder));
                notificationGenerationJob.setOverriddenTitleFromExtender((CharSequence) declaredField3.get(builder));
                if (!notificationGenerationJob.isRestoring()) {
                    notificationGenerationJob.setOverriddenFlags(Integer.valueOf(notification3.flags));
                    notificationGenerationJob.setOverriddenSound(notification3.sound);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final void addBackgroundImage(JSONObject jSONObject, NotificationCompat.Builder builder) throws Throwable {
        JSONObject jSONObject2;
        Bitmap bitmap;
        String str;
        if (Build.VERSION.SDK_INT >= 31) {
            Logging.verbose$default("Cannot use background images in notifications for device on version: " + Build.VERSION.SDK_INT, (Throwable) null, 2, (Object) null);
            return;
        }
        String optString = jSONObject.optString("bg_img", (String) null);
        if (optString != null) {
            jSONObject2 = new JSONObject(optString);
            bitmap = getBitmap(jSONObject2.optString("img", (String) null));
        } else {
            bitmap = null;
            jSONObject2 = null;
        }
        if (bitmap == null) {
            bitmap = getBitmapFromAssetsOrResourceName("onesignal_bgimage_default_image");
        }
        if (bitmap != null) {
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            RemoteViews remoteViews = new RemoteViews(currentContext.getPackageName(), R.layout.onesignal_bgimage_notif_layout);
            remoteViews.setTextViewText(R.id.os_bgimage_notif_title, this._notificationDisplayBuilder.getTitle(jSONObject));
            remoteViews.setTextViewText(R.id.os_bgimage_notif_body, jSONObject.optString("alert"));
            RemoteViews remoteViews2 = remoteViews;
            JSONObject jSONObject3 = jSONObject2;
            setTextColor(remoteViews2, jSONObject3, R.id.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
            setTextColor(remoteViews2, jSONObject3, R.id.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
            if (jSONObject2 == null || !jSONObject2.has("img_align")) {
                Resources contextResources = getContextResources();
                Intrinsics.checkNotNull(contextResources);
                int identifier = contextResources.getIdentifier("onesignal_bgimage_notif_image_align", "string", getPackageName());
                if (identifier != 0) {
                    Resources contextResources2 = getContextResources();
                    Intrinsics.checkNotNull(contextResources2);
                    str = contextResources2.getString(identifier);
                } else {
                    str = null;
                }
            } else {
                str = jSONObject2.getString("img_align");
            }
            if (Intrinsics.areEqual((Object) "right", (Object) str)) {
                remoteViews.setViewPadding(R.id.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage_right_aligned, bitmap);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage_right_aligned, 0);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage, 8);
            } else {
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage, bitmap);
            }
            Intrinsics.checkNotNull(builder);
            builder.setContent(remoteViews);
            builder.setStyle((NotificationCompat.Style) null);
        }
    }

    private final void setTextColor(RemoteViews remoteViews, JSONObject jSONObject, int i, String str, String str2) {
        Integer safeGetColorFromHex = safeGetColorFromHex(jSONObject, str);
        if (safeGetColorFromHex != null) {
            remoteViews.setTextColor(i, safeGetColorFromHex.intValue());
            return;
        }
        Resources contextResources = getContextResources();
        Intrinsics.checkNotNull(contextResources);
        int identifier = contextResources.getIdentifier(str2, "color", getPackageName());
        if (identifier != 0) {
            AndroidSupportV4Compat.ContextCompat contextCompat = AndroidSupportV4Compat.ContextCompat.INSTANCE;
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            remoteViews.setTextColor(i, contextCompat.getColor(currentContext, identifier));
        }
    }

    private final Integer safeGetColorFromHex(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return Integer.valueOf(new BigInteger(jSONObject.optString(str), 16).intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final Bitmap getBitmapFromAssetsOrResourceName(String str) {
        Bitmap bitmap;
        try {
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            bitmap = BitmapFactory.decodeStream(currentContext.getAssets().open(str));
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            for (String str2 : Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"})) {
                try {
                    Context currentContext2 = getCurrentContext();
                    Intrinsics.checkNotNull(currentContext2);
                    bitmap = BitmapFactory.decodeStream(currentContext2.getAssets().open(str + str2));
                    continue;
                } catch (Throwable unused2) {
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            int resourceIcon = getResourceIcon(str);
            if (resourceIcon != 0) {
                return BitmapFactory.decodeResource(getContextResources(), resourceIcon);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private final Bitmap getBitmapFromURL(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            Logging.warn("Could not download image!", th);
            return null;
        }
    }

    private final int getDrawableId(String str) {
        Resources contextResources = getContextResources();
        Intrinsics.checkNotNull(contextResources);
        return contextResources.getIdentifier(str, "drawable", getPackageName());
    }

    private final Bitmap getBitmap(String str) {
        if (str == null) {
            return null;
        }
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj = charSequence.subSequence(i, length + 1).toString();
        if (StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null)) {
            return getBitmapFromURL(obj);
        }
        return getBitmapFromAssetsOrResourceName(str);
    }

    private final int getResourceIcon(String str) {
        if (str == null) {
            return 0;
        }
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj = charSequence.subSequence(i, length + 1).toString();
        if (!AndroidUtils.INSTANCE.isValidResourceName(obj)) {
            return 0;
        }
        int drawableId = getDrawableId(obj);
        if (drawableId != 0) {
            return drawableId;
        }
        try {
            return R.drawable.class.getField(str).getInt((Object) null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
