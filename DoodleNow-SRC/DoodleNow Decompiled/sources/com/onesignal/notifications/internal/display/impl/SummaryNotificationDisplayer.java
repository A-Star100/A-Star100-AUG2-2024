package com.onesignal.notifications.internal.display.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder;
import java.security.SecureRandom;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J2\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J1\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J+\u0010%\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010&2\u0006\u0010!\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/SummaryNotificationDisplayer;", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_notificationDisplayBuilder", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;)V", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "createBaseSummaryIntent", "Landroid/content/Intent;", "summaryNotificationId", "", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "fcmJson", "Lorg/json/JSONObject;", "group", "", "createGenericPendingIntentsForGroup", "", "notifBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "gcmBundle", "notificationId", "createGrouplessSummaryNotification", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "grouplessNotifCount", "groupAlertBehavior", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSingleNotificationBeforeSummaryBuilder", "Landroid/app/Notification;", "createSummaryNotification", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryNotification", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SummaryNotificationDisplayer.kt */
public final class SummaryNotificationDisplayer implements ISummaryNotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationRepository _dataController;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;

    public SummaryNotificationDisplayer(IApplicationService iApplicationService, INotificationRepository iNotificationRepository, INotificationDisplayBuilder iNotificationDisplayBuilder) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationRepository, "_dataController");
        Intrinsics.checkNotNullParameter(iNotificationDisplayBuilder, "_notificationDisplayBuilder");
        this._applicationService = iApplicationService;
        this._dataController = iNotificationRepository;
        this._notificationDisplayBuilder = iNotificationDisplayBuilder;
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    public void createGenericPendingIntentsForGroup(NotificationCompat.Builder builder, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, JSONObject jSONObject, String str, int i) {
        Intrinsics.checkNotNullParameter(intentGeneratorForAttachingToNotifications, "intentGenerator");
        Intrinsics.checkNotNullParameter(jSONObject, "gcmBundle");
        Intrinsics.checkNotNullParameter(str, "group");
        Random secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt();
        Intent putExtra = intentGeneratorForAttachingToNotifications.getNewBaseIntent(i).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString()).putExtra("grp", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "intentGenerator.getNewBa…)).putExtra(\"grp\", group)");
        PendingIntent newActionPendingIntent = intentGeneratorForAttachingToNotifications.getNewActionPendingIntent(nextInt, putExtra);
        Intrinsics.checkNotNull(builder);
        builder.setContentIntent(newActionPendingIntent);
        INotificationDisplayBuilder iNotificationDisplayBuilder = this._notificationDisplayBuilder;
        int nextInt2 = secureRandom.nextInt();
        Intent putExtra2 = this._notificationDisplayBuilder.getNewBaseDismissIntent(i).putExtra("grp", str);
        Intrinsics.checkNotNullExpressionValue(putExtra2, "_notificationDisplayBuil…d).putExtra(\"grp\", group)");
        builder.setDeleteIntent(iNotificationDisplayBuilder.getNewDismissActionPendingIntent(nextInt2, putExtra2));
        builder.setGroup(str);
        try {
            builder.setGroupAlertBehavior(this._notificationDisplayBuilder.getGroupAlertBehavior());
        } catch (Throwable unused) {
        }
    }

    public Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder) {
        Intrinsics.checkNotNullParameter(notificationGenerationJob, "notificationJob");
        boolean z = Build.VERSION.SDK_INT < 24 && !notificationGenerationJob.isRestoring();
        if (z && notificationGenerationJob.getOverriddenSound() != null) {
            Uri overriddenSound = notificationGenerationJob.getOverriddenSound();
            Intrinsics.checkNotNull(overriddenSound);
            if (!overriddenSound.equals(notificationGenerationJob.getOrgSound())) {
                Intrinsics.checkNotNull(builder);
                builder.setSound((Uri) null);
            }
        }
        Intrinsics.checkNotNull(builder);
        Notification build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "notifBuilder!!.build()");
        if (z) {
            builder.setSound(notificationGenerationJob.getOverriddenSound());
        }
        return build;
    }

    public Object updateSummaryNotification(NotificationGenerationJob notificationGenerationJob, Continuation<? super Unit> continuation) {
        Object createSummaryNotification = createSummaryNotification(notificationGenerationJob, (NotificationDisplayBuilder.OneSignalNotificationBuilder) null, this._notificationDisplayBuilder.getGroupAlertBehavior(), continuation);
        return createSummaryNotification == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? createSummaryNotification : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x02b3, code lost:
        if (r7 == null) goto L_0x02b5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0257 A[EDGE_INSN: B:108:0x0257->B:51:0x0257 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01c0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x03da A[LOOP:1: B:97:0x03d4->B:99:0x03da, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r27, com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder r28, int r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            r26 = this;
            r0 = r26
            r1 = r30
            boolean r2 = r1 instanceof com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createSummaryNotification$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createSummaryNotification$1 r2 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createSummaryNotification$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createSummaryNotification$1 r2 = new com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createSummaryNotification$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            java.lang.String r7 = "group"
            r10 = 1
            if (r4 == 0) goto L_0x00cb
            if (r4 == r10) goto L_0x0094
            if (r4 == r6) goto L_0x0067
            if (r4 != r5) goto L_0x005f
            boolean r3 = r2.Z$0
            int r4 = r2.I$0
            java.lang.Object r5 = r2.L$8
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r6 = r2.L$7
            android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            java.lang.Object r11 = r2.L$6
            java.security.SecureRandom r11 = (java.security.SecureRandom) r11
            java.lang.Object r12 = r2.L$5
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$4
            com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r13 = (com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications) r13
            java.lang.Object r14 = r2.L$3
            org.json.JSONObject r14 = (org.json.JSONObject) r14
            java.lang.Object r15 = r2.L$2
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r15 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder) r15
            java.lang.Object r10 = r2.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r10 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r10
            java.lang.Object r2 = r2.L$0
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer r2 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01c6
        L_0x005f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0067:
            boolean r4 = r2.Z$0
            int r6 = r2.I$0
            java.lang.Object r10 = r2.L$8
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.Object r11 = r2.L$7
            android.app.PendingIntent r11 = (android.app.PendingIntent) r11
            java.lang.Object r12 = r2.L$6
            java.security.SecureRandom r12 = (java.security.SecureRandom) r12
            java.lang.Object r13 = r2.L$5
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$4
            com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r14 = (com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications) r14
            java.lang.Object r15 = r2.L$3
            org.json.JSONObject r15 = (org.json.JSONObject) r15
            java.lang.Object r5 = r2.L$2
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r5 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder) r5
            java.lang.Object r8 = r2.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r8 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r8
            java.lang.Object r9 = r2.L$0
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer r9 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer) r9
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0189
        L_0x0094:
            boolean r4 = r2.Z$0
            int r5 = r2.I$0
            java.lang.Object r8 = r2.L$7
            android.app.PendingIntent r8 = (android.app.PendingIntent) r8
            java.lang.Object r9 = r2.L$6
            java.security.SecureRandom r9 = (java.security.SecureRandom) r9
            java.lang.Object r10 = r2.L$5
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$4
            com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r11 = (com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications) r11
            java.lang.Object r12 = r2.L$3
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            java.lang.Object r13 = r2.L$2
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r13 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder) r13
            java.lang.Object r14 = r2.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r14 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r14
            java.lang.Object r15 = r2.L$0
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer r15 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r24 = r14
            r14 = r5
            r5 = r9
            r9 = r15
            r15 = r12
            r12 = r24
            r25 = r11
            r11 = r8
            r8 = r10
            r10 = r25
            goto L_0x0147
        L_0x00cb:
            kotlin.ResultKt.throwOnFailure(r1)
            boolean r1 = r27.isRestoring()
            org.json.JSONObject r4 = r27.getJsonPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r5 = new com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications
            android.content.Context r8 = r26.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r5.<init>(r8)
            java.lang.String r8 = "grp"
            r9 = 0
            java.lang.String r8 = r4.optString(r8, r9)
            java.security.SecureRandom r9 = new java.security.SecureRandom
            r9.<init>()
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r10 = r0._notificationDisplayBuilder
            int r11 = r9.nextInt()
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r12 = r0._notificationDisplayBuilder
            r13 = 0
            android.content.Intent r12 = r12.getNewBaseDismissIntent(r13)
            java.lang.String r13 = "summary"
            android.content.Intent r12 = r12.putExtra(r13, r8)
            java.lang.String r13 = "_notificationDisplayBuil…utExtra(\"summary\", group)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            android.app.PendingIntent r10 = r10.getNewDismissActionPendingIntent(r11, r12)
            r11 = 0
            r12 = r11
            java.lang.Integer r12 = (java.lang.Integer) r12
            r12 = r11
            java.lang.String r12 = (java.lang.String) r12
            r12 = r11
            java.util.Collection r12 = (java.util.Collection) r12
            com.onesignal.notifications.internal.data.INotificationRepository r11 = r0._dataController
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r2.L$0 = r0
            r12 = r27
            r2.L$1 = r12
            r13 = r28
            r2.L$2 = r13
            r2.L$3 = r4
            r2.L$4 = r5
            r2.L$5 = r8
            r2.L$6 = r9
            r2.L$7 = r10
            r14 = r29
            r2.I$0 = r14
            r2.Z$0 = r1
            r15 = 1
            r2.label = r15
            java.lang.Object r11 = r11.getAndroidIdForGroup(r8, r15, r2)
            if (r11 != r3) goto L_0x0140
            return r3
        L_0x0140:
            r15 = r4
            r4 = r1
            r1 = r11
            r11 = r10
            r10 = r5
            r5 = r9
            r9 = r0
        L_0x0147:
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L_0x0195
            int r1 = r5.nextInt()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            com.onesignal.notifications.internal.data.INotificationRepository r6 = r9._dataController
            int r0 = r1.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r2.L$0 = r9
            r2.L$1 = r12
            r2.L$2 = r13
            r2.L$3 = r15
            r2.L$4 = r10
            r2.L$5 = r8
            r2.L$6 = r5
            r2.L$7 = r11
            r2.L$8 = r1
            r2.I$0 = r14
            r2.Z$0 = r4
            r27 = r1
            r1 = 2
            r2.label = r1
            java.lang.Object r0 = r6.createSummaryNotification(r0, r8, r2)
            if (r0 != r3) goto L_0x017e
            return r3
        L_0x017e:
            r6 = r14
            r14 = r10
            r10 = r27
            r24 = r12
            r12 = r5
            r5 = r13
            r13 = r8
            r8 = r24
        L_0x0189:
            r0 = r5
            r5 = r10
            r10 = r8
            r24 = r14
            r14 = r6
            r6 = r11
            r11 = r12
            r12 = r13
            r13 = r24
            goto L_0x019c
        L_0x0195:
            r6 = r11
            r0 = r13
            r11 = r5
            r13 = r10
            r10 = r12
            r5 = r1
            r12 = r8
        L_0x019c:
            com.onesignal.notifications.internal.data.INotificationRepository r1 = r9._dataController
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)
            r2.L$0 = r9
            r2.L$1 = r10
            r2.L$2 = r0
            r2.L$3 = r15
            r2.L$4 = r13
            r2.L$5 = r12
            r2.L$6 = r11
            r2.L$7 = r6
            r2.L$8 = r5
            r2.I$0 = r14
            r2.Z$0 = r4
            r8 = 3
            r2.label = r8
            java.lang.Object r1 = r1.listNotificationsForGroup(r12, r2)
            if (r1 != r3) goto L_0x01c1
            return r3
        L_0x01c1:
            r3 = r4
            r2 = r9
            r4 = r14
            r14 = r15
            r15 = r0
        L_0x01c6:
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r1.iterator()
            r9 = 0
        L_0x01d4:
            boolean r8 = r1.hasNext()
            r27 = r15
            java.lang.String r15 = ""
            if (r8 == 0) goto L_0x0257
            java.lang.Object r8 = r1.next()
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r8 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r8
            r29 = r1
            if (r3 != 0) goto L_0x01f7
            int r1 = r8.getAndroidId()
            r16 = r4
            int r4 = r10.getAndroidId()
            if (r1 != r4) goto L_0x01f9
            r23 = r6
            goto L_0x024d
        L_0x01f7:
            r16 = r4
        L_0x01f9:
            java.lang.String r1 = r8.getTitle()
            if (r1 != 0) goto L_0x0200
            goto L_0x0211
        L_0x0200:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r1 = 32
            r4.append(r1)
            java.lang.String r15 = r4.toString()
        L_0x0211:
            android.text.SpannableString r1 = new android.text.SpannableString
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r15)
            r23 = r6
            java.lang.String r6 = r8.getMessage()
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.<init>(r4)
            int r4 = r15.length()
            if (r4 <= 0) goto L_0x0241
            android.text.style.StyleSpan r4 = new android.text.style.StyleSpan
            r6 = 1
            r4.<init>(r6)
            int r6 = r15.length()
            r15 = 0
            r1.setSpan(r4, r15, r6, r15)
        L_0x0241:
            r4 = r0
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r4.add(r1)
            if (r9 != 0) goto L_0x024d
            java.lang.String r9 = r8.getFullData()
        L_0x024d:
            r15 = r27
            r1 = r29
            r4 = r16
            r6 = r23
            goto L_0x01d4
        L_0x0257:
            r16 = r4
            r23 = r6
            int r1 = r11.nextInt()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r4 = r5.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)
            android.content.Intent r4 = r2.createBaseSummaryIntent(r4, r13, r14, r12)
            android.app.PendingIntent r1 = r13.getNewActionPendingIntent(r1, r4)
            java.lang.String r4 = "summaryBuilder.build()"
            if (r3 == 0) goto L_0x027f
            r6 = r0
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r6.size()
            r7 = 1
            if (r6 > r7) goto L_0x028a
        L_0x027f:
            if (r3 != 0) goto L_0x03f6
            r6 = r0
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x03f6
        L_0x028a:
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r6 = r0.size()
            r7 = r3 ^ 1
            int r6 = r6 + r7
            java.lang.String r7 = "grp_msg"
            java.lang.String r17 = com.onesignal.common.JSONObjectExtensionsKt.safeString(r14, r7)
            if (r17 == 0) goto L_0x02b5
            java.lang.String r18 = "$[notif_count]"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r15)
            r7.append(r6)
            java.lang.String r19 = r7.toString()
            r20 = 0
            r21 = 4
            r22 = 0
            java.lang.String r7 = kotlin.text.StringsKt.replace$default((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (boolean) r20, (int) r21, (java.lang.Object) r22)
            if (r7 != 0) goto L_0x02c6
        L_0x02b5:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r8 = " new messages"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
        L_0x02c6:
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r8 = r2._notificationDisplayBuilder
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r8 = r8.getBaseOneSignalNotificationBuilder(r10)
            androidx.core.app.NotificationCompat$Builder r8 = r8.getCompatBuilder()
            if (r3 == 0) goto L_0x02d8
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r9 = r2._notificationDisplayBuilder
            r9.removeNotifyOptions(r8)
            goto L_0x02ff
        L_0x02d8:
            android.net.Uri r9 = r10.getOverriddenSound()
            if (r9 == 0) goto L_0x02e8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            android.net.Uri r9 = r10.getOverriddenSound()
            r8.setSound(r9)
        L_0x02e8:
            java.lang.Integer r9 = r10.getOverriddenFlags()
            if (r9 == 0) goto L_0x02ff
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            java.lang.Integer r9 = r10.getOverriddenFlags()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r9 = r9.intValue()
            r8.setDefaults(r9)
        L_0x02ff:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            androidx.core.app.NotificationCompat$Builder r1 = r8.setContentIntent(r1)
            r9 = r23
            androidx.core.app.NotificationCompat$Builder r1 = r1.setDeleteIntent(r9)
            android.content.Context r9 = r2.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.content.pm.PackageManager r9 = r9.getPackageManager()
            android.content.Context r11 = r2.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            android.content.pm.ApplicationInfo r11 = r11.getApplicationInfo()
            java.lang.CharSequence r9 = r9.getApplicationLabel(r11)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setContentTitle(r9)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            androidx.core.app.NotificationCompat$Builder r1 = r1.setContentText(r7)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setNumber(r6)
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r6 = r2._notificationDisplayBuilder
            int r6 = r6.getDefaultSmallIconId()
            androidx.core.app.NotificationCompat$Builder r1 = r1.setSmallIcon((int) r6)
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r6 = r2._notificationDisplayBuilder
            android.graphics.Bitmap r6 = r6.getDefaultLargeIcon()
            androidx.core.app.NotificationCompat$Builder r1 = r1.setLargeIcon((android.graphics.Bitmap) r6)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setOnlyAlertOnce(r3)
            r6 = 0
            androidx.core.app.NotificationCompat$Builder r1 = r1.setAutoCancel(r6)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setGroup(r12)
            r6 = 1
            r1.setGroupSummary(r6)
            r6 = r16
            r8.setGroupAlertBehavior(r6)     // Catch:{ all -> 0x035e }
        L_0x035e:
            if (r3 != 0) goto L_0x0363
            r8.setTicker(r7)
        L_0x0363:
            androidx.core.app.NotificationCompat$InboxStyle r1 = new androidx.core.app.NotificationCompat$InboxStyle
            r1.<init>()
            if (r3 != 0) goto L_0x03d0
            r3 = 0
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.CharSequence r6 = r10.getTitle()
            if (r6 == 0) goto L_0x037d
            java.lang.CharSequence r3 = r10.getTitle()
            java.lang.String r9 = java.lang.String.valueOf(r3)
            goto L_0x037e
        L_0x037d:
            r9 = r3
        L_0x037e:
            if (r9 != 0) goto L_0x0382
            r3 = r15
            goto L_0x0393
        L_0x0382:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r6 = 32
            r3.append(r6)
            java.lang.String r3 = r3.toString()
        L_0x0393:
            java.lang.CharSequence r6 = r10.getBody()
            if (r6 == 0) goto L_0x03a1
            java.lang.String r6 = r6.toString()
            if (r6 != 0) goto L_0x03a0
            goto L_0x03a1
        L_0x03a0:
            r15 = r6
        L_0x03a1:
            android.text.SpannableString r6 = new android.text.SpannableString
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r15)
            java.lang.String r9 = r9.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r6.<init>(r9)
            int r9 = r3.length()
            if (r9 <= 0) goto L_0x03cb
            android.text.style.StyleSpan r9 = new android.text.style.StyleSpan
            r10 = 1
            r9.<init>(r10)
            int r3 = r3.length()
            r10 = 0
            r6.setSpan(r9, r10, r3, r10)
        L_0x03cb:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.addLine(r6)
        L_0x03d0:
            java.util.Iterator r0 = r0.iterator()
        L_0x03d4:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x03e6
            java.lang.Object r3 = r0.next()
            android.text.SpannableString r3 = (android.text.SpannableString) r3
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.addLine(r3)
            goto L_0x03d4
        L_0x03e6:
            r1.setBigContentTitle(r7)
            androidx.core.app.NotificationCompat$Style r1 = (androidx.core.app.NotificationCompat.Style) r1
            r8.setStyle(r1)
            android.app.Notification r0 = r8.build()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            goto L_0x0446
        L_0x03f6:
            r6 = r16
            r9 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNull(r27)
            androidx.core.app.NotificationCompat$Builder r0 = r27.getCompatBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.ArrayList<androidx.core.app.NotificationCompat$Action> r7 = r0.mActions
            r7.clear()
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r7 = r2._notificationDisplayBuilder
            int r21 = r5.intValue()
            r17 = r7
            r18 = r14
            r19 = r13
            r20 = r0
            r22 = r12
            r17.addNotificationActionButtons(r18, r19, r20, r21, r22)
            androidx.core.app.NotificationCompat$Builder r1 = r0.setContentIntent(r1)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setDeleteIntent(r9)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setOnlyAlertOnce(r3)
            r3 = 0
            androidx.core.app.NotificationCompat$Builder r1 = r1.setAutoCancel(r3)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setGroup(r12)
            r3 = 1
            r1.setGroupSummary(r3)
            r0.setGroupAlertBehavior(r6)     // Catch:{ all -> 0x0438 }
        L_0x0438:
            android.app.Notification r0 = r0.build()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r1 = r2._notificationDisplayBuilder
            r15 = r27
            r1.addXiaomiSettings(r15, r0)
        L_0x0446:
            android.content.Context r1 = r2.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.core.app.NotificationManagerCompat r1 = androidx.core.app.NotificationManagerCompat.from(r1)
            int r2 = r5.intValue()
            r1.notify(r2, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createGrouplessSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r10, com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r11, int r12, int r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createGrouplessSummaryNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createGrouplessSummaryNotification$1 r0 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createGrouplessSummaryNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createGrouplessSummaryNotification$1 r0 = new com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createGrouplessSummaryNotification$1
            r0.<init>(r9, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 != r3) goto L_0x004e
            int r10 = r0.I$2
            int r13 = r0.I$1
            int r12 = r0.I$0
            java.lang.Object r11 = r0.L$6
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r1 = r0.L$5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.L$4
            java.security.SecureRandom r2 = (java.security.SecureRandom) r2
            java.lang.Object r4 = r0.L$3
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.Object r5 = r0.L$2
            com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r5 = (com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications) r5
            java.lang.Object r6 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r6 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r6
            java.lang.Object r0 = r0.L$0
            com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer r0 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer) r0
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r11
            r11 = r5
            goto L_0x009e
        L_0x004e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r14)
            org.json.JSONObject r4 = r10.getJsonPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.security.SecureRandom r2 = new java.security.SecureRandom
            r2.<init>()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r12)
            java.lang.String r5 = " new messages"
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            com.onesignal.notifications.internal.data.INotificationRepository r5 = r9._dataController
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.L$3 = r4
            r0.L$4 = r2
            java.lang.String r6 = "os_group_undefined"
            r0.L$5 = r6
            r0.L$6 = r14
            r0.I$0 = r12
            r0.I$1 = r13
            r7 = -718463522(0xffffffffd52d1dde, float:-1.18964869E13)
            r0.I$2 = r7
            r0.label = r3
            java.lang.Object r0 = r5.createSummaryNotification(r7, r6, r0)
            if (r0 != r1) goto L_0x009a
            return r1
        L_0x009a:
            r0 = r9
            r1 = r6
            r6 = r10
            r10 = r7
        L_0x009e:
            int r5 = r2.nextInt()
            android.content.Intent r4 = r0.createBaseSummaryIntent(r10, r11, r4, r1)
            android.app.PendingIntent r11 = r11.getNewActionPendingIntent(r5, r4)
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r4 = r0._notificationDisplayBuilder
            int r2 = r2.nextInt()
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r5 = r0._notificationDisplayBuilder
            r7 = 0
            android.content.Intent r5 = r5.getNewBaseDismissIntent(r7)
            java.lang.String r8 = "summary"
            android.content.Intent r5 = r5.putExtra(r8, r1)
            java.lang.String r8 = "_notificationDisplayBuil…utExtra(\"summary\", group)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            android.app.PendingIntent r2 = r4.getNewDismissActionPendingIntent(r2, r5)
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r4 = r0._notificationDisplayBuilder
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r4 = r4.getBaseOneSignalNotificationBuilder(r6)
            androidx.core.app.NotificationCompat$Builder r4 = r4.getCompatBuilder()
            android.net.Uri r5 = r6.getOverriddenSound()
            if (r5 == 0) goto L_0x00e0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            android.net.Uri r5 = r6.getOverriddenSound()
            r4.setSound(r5)
        L_0x00e0:
            java.lang.Integer r5 = r6.getOverriddenFlags()
            if (r5 == 0) goto L_0x00f7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Integer r5 = r6.getOverriddenFlags()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.intValue()
            r4.setDefaults(r5)
        L_0x00f7:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.core.app.NotificationCompat$Builder r11 = r4.setContentIntent(r11)
            androidx.core.app.NotificationCompat$Builder r11 = r11.setDeleteIntent(r2)
            android.content.Context r2 = r0.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            android.content.Context r5 = r0.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()
            java.lang.CharSequence r2 = r2.getApplicationLabel(r5)
            androidx.core.app.NotificationCompat$Builder r11 = r11.setContentTitle(r2)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            androidx.core.app.NotificationCompat$Builder r11 = r11.setContentText(r14)
            androidx.core.app.NotificationCompat$Builder r11 = r11.setNumber(r12)
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r12 = r0._notificationDisplayBuilder
            int r12 = r12.getDefaultSmallIconId()
            androidx.core.app.NotificationCompat$Builder r11 = r11.setSmallIcon((int) r12)
            com.onesignal.notifications.internal.display.INotificationDisplayBuilder r12 = r0._notificationDisplayBuilder
            android.graphics.Bitmap r12 = r12.getDefaultLargeIcon()
            androidx.core.app.NotificationCompat$Builder r11 = r11.setLargeIcon((android.graphics.Bitmap) r12)
            androidx.core.app.NotificationCompat$Builder r11 = r11.setOnlyAlertOnce(r3)
            androidx.core.app.NotificationCompat$Builder r11 = r11.setAutoCancel(r7)
            androidx.core.app.NotificationCompat$Builder r11 = r11.setGroup(r1)
            r11.setGroupSummary(r3)
            r4.setGroupAlertBehavior(r13)     // Catch:{ all -> 0x0150 }
        L_0x0150:
            androidx.core.app.NotificationCompat$InboxStyle r11 = new androidx.core.app.NotificationCompat$InboxStyle
            r11.<init>()
            r11.setBigContentTitle(r14)
            androidx.core.app.NotificationCompat$Style r11 = (androidx.core.app.NotificationCompat.Style) r11
            r4.setStyle(r11)
            android.app.Notification r11 = r4.build()
            java.lang.String r12 = "summaryBuilder.build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            android.content.Context r12 = r0.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            androidx.core.app.NotificationManagerCompat r12 = androidx.core.app.NotificationManagerCompat.from(r12)
            r12.notify(r10, r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createGrouplessSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Intent createBaseSummaryIntent(int i, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, JSONObject jSONObject, String str) {
        Intent putExtra = intentGeneratorForAttachingToNotifications.getNewBaseIntent(i).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString()).putExtra("summary", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "intentGenerator.getNewBa…utExtra(\"summary\", group)");
        return putExtra;
    }
}
