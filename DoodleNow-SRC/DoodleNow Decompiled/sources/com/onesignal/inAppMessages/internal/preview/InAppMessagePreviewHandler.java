package com.onesignal.inAppMessages.internal.preview;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0003J\b\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/onesignal/inAppMessages/internal/preview/InAppMessagePreviewHandler;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleCallback;", "_iamDisplayer", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationDisplayer", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_notificationActivityOpener", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "_notificationLifeCycle", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/display/INotificationDisplayer;Lcom/onesignal/notifications/internal/INotificationActivityOpener;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/core/internal/time/ITime;)V", "canOpenNotification", "", "activity", "Landroid/app/Activity;", "jsonData", "Lorg/json/JSONObject;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canReceiveNotification", "jsonPayload", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inAppPreviewPushUUID", "", "payload", "shouldDisplayNotification", "start", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessagePreviewHandler.kt */
public final class InAppMessagePreviewHandler implements IStartableService, INotificationLifecycleCallback {
    private final IApplicationService _applicationService;
    private final IInAppDisplayer _iamDisplayer;
    private final INotificationActivityOpener _notificationActivityOpener;
    private final INotificationDisplayer _notificationDisplayer;
    private final INotificationLifecycleService _notificationLifeCycle;
    private final InAppStateService _state;
    private final ITime _time;

    private final boolean shouldDisplayNotification() {
        return true;
    }

    public InAppMessagePreviewHandler(IInAppDisplayer iInAppDisplayer, IApplicationService iApplicationService, INotificationDisplayer iNotificationDisplayer, INotificationActivityOpener iNotificationActivityOpener, INotificationLifecycleService iNotificationLifecycleService, InAppStateService inAppStateService, ITime iTime) {
        Intrinsics.checkNotNullParameter(iInAppDisplayer, "_iamDisplayer");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationDisplayer, "_notificationDisplayer");
        Intrinsics.checkNotNullParameter(iNotificationActivityOpener, "_notificationActivityOpener");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService, "_notificationLifeCycle");
        Intrinsics.checkNotNullParameter(inAppStateService, "_state");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._iamDisplayer = iInAppDisplayer;
        this._applicationService = iApplicationService;
        this._notificationDisplayer = iNotificationDisplayer;
        this._notificationActivityOpener = iNotificationActivityOpener;
        this._notificationLifeCycle = iNotificationLifecycleService;
        this._state = inAppStateService;
        this._time = iTime;
    }

    public void start() {
        this._notificationLifeCycle.setInternalNotificationLifecycleCallback(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object canReceiveNotification(org.json.JSONObject r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1 r0 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1 r0 = new com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canReceiveNotification$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x008d
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$0
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler r6 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0066
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r5.inAppPreviewPushUUID(r6)
            if (r7 != 0) goto L_0x004b
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L_0x004b:
            com.onesignal.core.internal.application.IApplicationService r2 = r5._applicationService
            boolean r2 = r2.isInForeground()
            if (r2 == 0) goto L_0x0075
            com.onesignal.inAppMessages.internal.state.InAppStateService r6 = r5._state
            r6.setInAppMessageIdShowing(r7)
            com.onesignal.inAppMessages.internal.display.IInAppDisplayer r6 = r5._iamDisplayer
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r6.displayPreviewMessage(r7, r0)
            if (r7 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r6 = r5
        L_0x0066:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x008d
            com.onesignal.inAppMessages.internal.state.InAppStateService r6 = r6._state
            r7 = 0
            r6.setInAppMessageIdShowing(r7)
            goto L_0x008d
        L_0x0075:
            boolean r7 = r5.shouldDisplayNotification()
            if (r7 == 0) goto L_0x008d
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = new com.onesignal.notifications.internal.common.NotificationGenerationJob
            com.onesignal.core.internal.time.ITime r2 = r5._time
            r7.<init>((org.json.JSONObject) r6, (com.onesignal.core.internal.time.ITime) r2)
            com.onesignal.notifications.internal.display.INotificationDisplayer r6 = r5._notificationDisplayer
            r0.label = r3
            java.lang.Object r6 = r6.displayNotification(r7, r0)
            if (r6 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canReceiveNotification(org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object canOpenNotification(android.app.Activity r8, org.json.JSONObject r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1 r0 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1 r0 = new com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler$canOpenNotification$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r8 = r0.L$0
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler r8 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0088
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$0
            com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler r9 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r8
            r8 = r9
            goto L_0x0074
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = r7.inAppPreviewPushUUID(r9)
            if (r10 != 0) goto L_0x0056
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r8
        L_0x0056:
            com.onesignal.notifications.internal.INotificationActivityOpener r2 = r7._notificationActivityOpener
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            org.json.JSONArray r9 = r6.put(r9)
            java.lang.String r6 = "JSONArray().put(jsonData)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
            r0.L$0 = r7
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r8 = r2.openDestinationActivity(r8, r9, r0)
            if (r8 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r8 = r7
        L_0x0074:
            com.onesignal.inAppMessages.internal.state.InAppStateService r9 = r8._state
            r9.setInAppMessageIdShowing(r10)
            com.onesignal.inAppMessages.internal.display.IInAppDisplayer r9 = r8._iamDisplayer
            r0.L$0 = r8
            r0.L$1 = r3
            r0.label = r4
            java.lang.Object r10 = r9.displayPreviewMessage(r10, r0)
            if (r10 != r1) goto L_0x0088
            return r1
        L_0x0088:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r9 = r10.booleanValue()
            if (r9 != 0) goto L_0x0095
            com.onesignal.inAppMessages.internal.state.InAppStateService r8 = r8._state
            r8.setInAppMessageIdShowing(r3)
        L_0x0095:
            r8 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canOpenNotification(android.app.Activity, org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String inAppPreviewPushUUID(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            JSONObject customJSONObject = NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject);
            if (!customJSONObject.has("a") || (optJSONObject = customJSONObject.optJSONObject("a")) == null) {
                return null;
            }
            if (optJSONObject.has(NotificationConstants.IAM_PREVIEW_KEY)) {
                return optJSONObject.optString(NotificationConstants.IAM_PREVIEW_KEY);
            }
            String str = null;
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }
}
