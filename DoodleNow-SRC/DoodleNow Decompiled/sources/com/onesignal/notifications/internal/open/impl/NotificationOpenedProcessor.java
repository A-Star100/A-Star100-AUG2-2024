package com.onesignal.notifications.internal.open.impl;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J)\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J!\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010!J/\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010%R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/onesignal/notifications/internal/open/impl/NotificationOpenedProcessor;", "Lcom/onesignal/notifications/internal/open/INotificationOpenedProcessor;", "_summaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "(Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;)V", "addChildNotifications", "", "dataArray", "Lorg/json/JSONArray;", "summaryGroup", "", "(Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearStatusBarNotifications", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDismissFromActionButtonPress", "intent", "Landroid/content/Intent;", "isOneSignalIntent", "", "markNotificationsConsumed", "dismissed", "(Landroid/content/Context;Landroid/content/Intent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newContentValuesWithConsumed", "Landroid/content/ContentValues;", "processFromContext", "(Landroid/content/Context;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIntent", "processToOpenIntent", "Lcom/onesignal/notifications/internal/open/impl/NotificationIntentExtras;", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationOpenedProcessor.kt */
public final class NotificationOpenedProcessor implements INotificationOpenedProcessor {
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationLifecycleService _lifecycleService;
    private final INotificationSummaryManager _summaryManager;

    public NotificationOpenedProcessor(INotificationSummaryManager iNotificationSummaryManager, INotificationRepository iNotificationRepository, ConfigModelStore configModelStore, INotificationLifecycleService iNotificationLifecycleService) {
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager, "_summaryManager");
        Intrinsics.checkNotNullParameter(iNotificationRepository, "_dataController");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService, "_lifecycleService");
        this._summaryManager = iNotificationSummaryManager;
        this._dataController = iNotificationRepository;
        this._configModelStore = configModelStore;
        this._lifecycleService = iNotificationLifecycleService;
    }

    public Object processFromContext(Context context, Intent intent, Continuation<? super Unit> continuation) {
        if (!isOneSignalIntent(intent)) {
            return Unit.INSTANCE;
        }
        handleDismissFromActionButtonPress(context, intent);
        Object processIntent = processIntent(context, intent, continuation);
        return processIntent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? processIntent : Unit.INSTANCE;
    }

    private final boolean isOneSignalIntent(Intent intent) {
        return intent.hasExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA) || intent.hasExtra("summary") || intent.hasExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
    }

    private final void handleDismissFromActionButtonPress(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            Intrinsics.checkNotNull(context);
            NotificationManagerCompat.from(context).cancel(intent.getIntExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, 0));
            if (Build.VERSION.SDK_INT < 31) {
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processIntent(android.content.Context r12, android.content.Intent r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processIntent$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processIntent$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processIntent$1
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 1
            r6 = 2
            r7 = 0
            if (r2 == 0) goto L_0x008b
            if (r2 == r5) goto L_0x006f
            if (r2 == r6) goto L_0x0054
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x016a
        L_0x0035:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003d:
            boolean r12 = r0.Z$0
            java.lang.Object r13 = r0.L$3
            com.onesignal.notifications.internal.open.impl.NotificationIntentExtras r13 = (com.onesignal.notifications.internal.open.impl.NotificationIntentExtras) r13
            java.lang.Object r2 = r0.L$2
            android.content.Intent r2 = (android.content.Intent) r2
            java.lang.Object r4 = r0.L$1
            android.content.Context r4 = (android.content.Context) r4
            java.lang.Object r5 = r0.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor r5 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor) r5
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00fd
        L_0x0054:
            boolean r12 = r0.Z$0
            java.lang.Object r13 = r0.L$4
            com.onesignal.notifications.internal.open.impl.NotificationIntentExtras r13 = (com.onesignal.notifications.internal.open.impl.NotificationIntentExtras) r13
            java.lang.Object r2 = r0.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$2
            android.content.Intent r5 = (android.content.Intent) r5
            java.lang.Object r8 = r0.L$1
            android.content.Context r8 = (android.content.Context) r8
            java.lang.Object r9 = r0.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor r9 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor) r9
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00d9
        L_0x006f:
            boolean r12 = r0.Z$0
            java.lang.Object r13 = r0.L$3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r2 = r0.L$2
            android.content.Intent r2 = (android.content.Intent) r2
            java.lang.Object r5 = r0.L$1
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Object r8 = r0.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor r8 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor) r8
            kotlin.ResultKt.throwOnFailure(r14)
            r10 = r2
            r2 = r12
            r12 = r5
            r5 = r14
            r14 = r13
            r13 = r10
            goto L_0x00b4
        L_0x008b:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r14 = "summary"
            java.lang.String r14 = r13.getStringExtra(r14)
            java.lang.String r2 = "dismissed"
            r8 = 0
            boolean r2 = r13.getBooleanExtra(r2, r8)
            r8 = r7
            com.onesignal.notifications.internal.open.impl.NotificationIntentExtras r8 = (com.onesignal.notifications.internal.open.impl.NotificationIntentExtras) r8
            if (r2 != 0) goto L_0x00bb
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r13
            r0.L$3 = r14
            r0.Z$0 = r2
            r0.label = r5
            java.lang.Object r5 = r11.processToOpenIntent(r12, r13, r14, r0)
            if (r5 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            r8 = r11
        L_0x00b4:
            com.onesignal.notifications.internal.open.impl.NotificationIntentExtras r5 = (com.onesignal.notifications.internal.open.impl.NotificationIntentExtras) r5
            if (r5 != 0) goto L_0x00bd
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00bb:
            r8 = r11
            r5 = r7
        L_0x00bd:
            r0.L$0 = r8
            r0.L$1 = r12
            r0.L$2 = r13
            r0.L$3 = r14
            r0.L$4 = r5
            r0.Z$0 = r2
            r0.label = r6
            java.lang.Object r9 = r8.markNotificationsConsumed(r12, r13, r2, r0)
            if (r9 != r1) goto L_0x00d2
            return r1
        L_0x00d2:
            r9 = r8
            r8 = r12
            r12 = r2
            r2 = r14
            r10 = r5
            r5 = r13
            r13 = r10
        L_0x00d9:
            if (r2 != 0) goto L_0x0100
            java.lang.String r14 = "grp"
            java.lang.String r14 = r5.getStringExtra(r14)
            if (r14 == 0) goto L_0x0100
            com.onesignal.notifications.internal.summary.INotificationSummaryManager r2 = r9._summaryManager
            r0.L$0 = r9
            r0.L$1 = r8
            r0.L$2 = r5
            r0.L$3 = r13
            r0.L$4 = r7
            r0.Z$0 = r12
            r0.label = r4
            java.lang.Object r14 = r2.updateSummaryNotificationAfterChildRemoved(r14, r12, r0)
            if (r14 != r1) goto L_0x00fa
            return r1
        L_0x00fa:
            r2 = r5
            r4 = r8
            r5 = r9
        L_0x00fd:
            r8 = r4
            r9 = r5
            r5 = r2
        L_0x0100:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r2 = "processIntent from context: "
            r14.<init>(r2)
            r14.append(r8)
            java.lang.String r2 = " and intent: "
            r14.append(r2)
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r14, r7, r6, r7)
            android.os.Bundle r14 = r5.getExtras()
            if (r14 == 0) goto L_0x0134
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r2 = "processIntent intent extras: "
            r14.<init>(r2)
            android.os.Bundle r2 = r5.getExtras()
            r14.append(r2)
            java.lang.String r14 = r14.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r14, r7, r6, r7)
        L_0x0134:
            if (r12 != 0) goto L_0x016d
            boolean r12 = r8 instanceof android.app.Activity
            if (r12 != 0) goto L_0x014c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "NotificationOpenedProcessor processIntent from an non Activity context: "
            r12.<init>(r13)
            r12.append(r8)
            java.lang.String r12 = r12.toString()
            com.onesignal.debug.internal.logging.Logging.error$default(r12, r7, r6, r7)
            goto L_0x016d
        L_0x014c:
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r12 = r9._lifecycleService
            android.app.Activity r8 = (android.app.Activity) r8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            org.json.JSONArray r13 = r13.getDataArray()
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.L$4 = r7
            r0.label = r3
            java.lang.Object r12 = r12.notificationOpened(r8, r13, r0)
            if (r12 != r1) goto L_0x016a
            return r1
        L_0x016a:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x016d:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processIntent(android.content.Context, android.content.Intent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6 A[Catch:{ JSONException -> 0x005a }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processToOpenIntent(android.content.Context r11, android.content.Intent r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.open.impl.NotificationIntentExtras> r14) {
        /*
            r10 = this;
            java.lang.String r0 = "androidNotificationId"
            java.lang.String r1 = "NotificationOpenedProcessor processIntent from an non Activity context: "
            boolean r2 = r14 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processToOpenIntent$1
            if (r2 == 0) goto L_0x0018
            r2 = r14
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processToOpenIntent$1 r2 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processToOpenIntent$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r14 = r2.label
            int r14 = r14 - r4
            r2.label = r14
            goto L_0x001d
        L_0x0018:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processToOpenIntent$1 r2 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$processToOpenIntent$1
            r2.<init>(r10, r14)
        L_0x001d:
            java.lang.Object r14 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            java.lang.String r6 = "onesignalData"
            r7 = 2
            r8 = 0
            if (r4 == 0) goto L_0x005d
            if (r4 == r5) goto L_0x0045
            if (r4 != r7) goto L_0x003d
            java.lang.Object r11 = r2.L$1
            org.json.JSONObject r11 = (org.json.JSONObject) r11
            java.lang.Object r12 = r2.L$0
            org.json.JSONArray r12 = (org.json.JSONArray) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e7
        L_0x003d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0045:
            java.lang.Object r11 = r2.L$3
            org.json.JSONObject r11 = (org.json.JSONObject) r11
            java.lang.Object r12 = r2.L$2
            r13 = r12
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r12 = r2.L$1
            android.content.Intent r12 = (android.content.Intent) r12
            java.lang.Object r1 = r2.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor r1 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor) r1
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ JSONException -> 0x005a }
            goto L_0x009e
        L_0x005a:
            r12 = move-exception
            goto L_0x00cd
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r8
            org.json.JSONArray r14 = (org.json.JSONArray) r14
            r14 = r8
            org.json.JSONObject r14 = (org.json.JSONObject) r14
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r4 = r12.getStringExtra(r6)     // Catch:{ JSONException -> 0x00ca }
            r14.<init>(r4)     // Catch:{ JSONException -> 0x00ca }
            boolean r4 = r11 instanceof android.app.Activity     // Catch:{ JSONException -> 0x00c6 }
            if (r4 != 0) goto L_0x0085
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00c6 }
            r4.<init>(r1)     // Catch:{ JSONException -> 0x00c6 }
            r4.append(r11)     // Catch:{ JSONException -> 0x00c6 }
            java.lang.String r11 = r4.toString()     // Catch:{ JSONException -> 0x00c6 }
            com.onesignal.debug.internal.logging.Logging.error$default(r11, r8, r7, r8)     // Catch:{ JSONException -> 0x00c6 }
            r1 = r10
            r11 = r14
            goto L_0x00a7
        L_0x0085:
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r1 = r10._lifecycleService     // Catch:{ JSONException -> 0x00c6 }
            android.app.Activity r11 = (android.app.Activity) r11     // Catch:{ JSONException -> 0x00c6 }
            r2.L$0 = r10     // Catch:{ JSONException -> 0x00c6 }
            r2.L$1 = r12     // Catch:{ JSONException -> 0x00c6 }
            r2.L$2 = r13     // Catch:{ JSONException -> 0x00c6 }
            r2.L$3 = r14     // Catch:{ JSONException -> 0x00c6 }
            r2.label = r5     // Catch:{ JSONException -> 0x00c6 }
            java.lang.Object r11 = r1.canOpenNotification(r11, r14, r2)     // Catch:{ JSONException -> 0x00c6 }
            if (r11 != r3) goto L_0x009a
            return r3
        L_0x009a:
            r1 = r10
            r9 = r14
            r14 = r11
            r11 = r9
        L_0x009e:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ JSONException -> 0x005a }
            boolean r14 = r14.booleanValue()     // Catch:{ JSONException -> 0x005a }
            if (r14 != 0) goto L_0x00a7
            return r8
        L_0x00a7:
            r14 = 0
            int r14 = r12.getIntExtra(r0, r14)     // Catch:{ JSONException -> 0x005a }
            r11.put(r0, r14)     // Catch:{ JSONException -> 0x005a }
            java.lang.String r14 = r11.toString()     // Catch:{ JSONException -> 0x005a }
            r12.putExtra(r6, r14)     // Catch:{ JSONException -> 0x005a }
            com.onesignal.common.JSONUtils r14 = com.onesignal.common.JSONUtils.INSTANCE     // Catch:{ JSONException -> 0x005a }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005a }
            java.lang.String r12 = r12.getStringExtra(r6)     // Catch:{ JSONException -> 0x005a }
            r0.<init>(r12)     // Catch:{ JSONException -> 0x005a }
            org.json.JSONArray r12 = r14.wrapInJsonArray(r0)     // Catch:{ JSONException -> 0x005a }
            goto L_0x00d1
        L_0x00c6:
            r12 = move-exception
            r1 = r10
            r11 = r14
            goto L_0x00cd
        L_0x00ca:
            r12 = move-exception
            r1 = r10
            r11 = r8
        L_0x00cd:
            r12.printStackTrace()
            r12 = r8
        L_0x00d1:
            if (r13 == 0) goto L_0x00e7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r2.L$0 = r12
            r2.L$1 = r11
            r2.L$2 = r8
            r2.L$3 = r8
            r2.label = r7
            java.lang.Object r13 = r1.addChildNotifications(r12, r13, r2)
            if (r13 != r3) goto L_0x00e7
            return r3
        L_0x00e7:
            com.onesignal.notifications.internal.open.impl.NotificationIntentExtras r13 = new com.onesignal.notifications.internal.open.impl.NotificationIntentExtras
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r13.<init>(r12, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processToOpenIntent(android.content.Context, android.content.Intent, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A[LOOP:0: B:16:0x004c->B:18:0x0052, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addChildNotifications(org.json.JSONArray r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0046
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.onesignal.notifications.internal.data.INotificationRepository r7 = r4._dataController
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r7.listNotificationsForGroup(r6, r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r6 = r7.iterator()
        L_0x004c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0065
            java.lang.Object r7 = r6.next()
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r7 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r7
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r7 = r7.getFullData()
            r0.<init>(r7)
            r5.put(r0)
            goto L_0x004c
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.addChildNotifications(org.json.JSONArray, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object markNotificationsConsumed(android.content.Context r8, android.content.Intent r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1
            r0.<init>(r7, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x004a
            if (r1 == r3) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x008e
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            boolean r10 = r6.Z$0
            java.lang.Object r8 = r6.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r6.L$1
            android.content.Intent r9 = (android.content.Intent) r9
            java.lang.Object r1 = r6.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor r1 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r8
            r3 = r10
            goto L_0x0067
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "summary"
            java.lang.String r11 = r9.getStringExtra(r11)
            r6.L$0 = r7
            r6.L$1 = r9
            r6.L$2 = r11
            r6.Z$0 = r10
            r6.label = r3
            java.lang.Object r8 = r7.clearStatusBarNotifications(r8, r11, r6)
            if (r8 != r0) goto L_0x0064
            return r0
        L_0x0064:
            r1 = r7
            r3 = r10
            r4 = r11
        L_0x0067:
            com.onesignal.notifications.internal.data.INotificationRepository r8 = r1._dataController
            java.lang.String r10 = "androidNotificationId"
            r11 = 0
            int r9 = r9.getIntExtra(r10, r11)
            com.onesignal.core.internal.config.ConfigModelStore r10 = r1._configModelStore
            com.onesignal.common.modeling.Model r10 = r10.getModel()
            com.onesignal.core.internal.config.ConfigModel r10 = (com.onesignal.core.internal.config.ConfigModel) r10
            boolean r5 = r10.getClearGroupOnSummaryClick()
            r10 = 0
            r6.L$0 = r10
            r6.L$1 = r10
            r6.L$2 = r10
            r6.label = r2
            r1 = r8
            r2 = r9
            java.lang.Object r8 = r1.markAsConsumed(r2, r3, r4, r5, r6)
            if (r8 != r0) goto L_0x008e
            return r0
        L_0x008e:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.markNotificationsConsumed(android.content.Context, android.content.Intent, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object clearStatusBarNotifications(Context context, String str, Continuation<? super Unit> continuation) {
        if (str != null) {
            Object clearNotificationOnSummaryClick = this._summaryManager.clearNotificationOnSummaryClick(str, continuation);
            return clearNotificationOnSummaryClick == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearNotificationOnSummaryClick : Unit.INSTANCE;
        }
        if (NotificationHelper.INSTANCE.getGrouplessNotifsCount(context) < 1) {
            NotificationHelper.INSTANCE.getNotificationManager(context).cancel(NotificationHelper.GROUPLESS_SUMMARY_ID);
        }
        return Unit.INSTANCE;
    }

    private final ContentValues newContentValuesWithConsumed(Intent intent) {
        ContentValues contentValues = new ContentValues();
        if (intent.getBooleanExtra("dismissed", false)) {
            contentValues.put("dismissed", 1);
        } else {
            contentValues.put("opened", 1);
        }
        return contentValues;
    }
}
