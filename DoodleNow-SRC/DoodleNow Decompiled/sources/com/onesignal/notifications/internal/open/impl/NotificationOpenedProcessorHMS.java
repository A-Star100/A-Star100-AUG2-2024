package com.onesignal.notifications.internal.open.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.common.JSONUtils;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J#\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/onesignal/notifications/internal/open/impl/NotificationOpenedProcessorHMS;", "Lcom/onesignal/notifications/internal/open/INotificationOpenedProcessorHMS;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "(Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;)V", "covertHMSOpenIntentToJson", "Lorg/json/JSONObject;", "intent", "Landroid/content/Intent;", "handleHMSNotificationOpenIntent", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleProcessJsonOpenData", "jsonData", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reformatButtonClickAction", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationOpenedProcessorHMS.kt */
public final class NotificationOpenedProcessorHMS implements INotificationOpenedProcessorHMS {
    private final INotificationLifecycleService _lifecycleService;

    public NotificationOpenedProcessorHMS(INotificationLifecycleService iNotificationLifecycleService) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService, "_lifecycleService");
        this._lifecycleService = iNotificationLifecycleService;
    }

    public Object handleHMSNotificationOpenIntent(Activity activity, Intent intent, Continuation<? super Unit> continuation) {
        if (intent == null) {
            return Unit.INSTANCE;
        }
        JSONObject covertHMSOpenIntentToJson = covertHMSOpenIntentToJson(intent);
        if (covertHMSOpenIntentToJson == null) {
            return Unit.INSTANCE;
        }
        Object handleProcessJsonOpenData = handleProcessJsonOpenData(activity, covertHMSOpenIntentToJson, continuation);
        return handleProcessJsonOpenData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? handleProcessJsonOpenData : Unit.INSTANCE;
    }

    private final JSONObject covertHMSOpenIntentToJson(Intent intent) {
        if (!NotificationFormatHelper.INSTANCE.isOneSignalIntent(intent)) {
            return null;
        }
        Intrinsics.checkNotNull(intent);
        Bundle extras = intent.getExtras();
        JSONUtils jSONUtils = JSONUtils.INSTANCE;
        Intrinsics.checkNotNull(extras);
        JSONObject bundleAsJSONObject = jSONUtils.bundleAsJSONObject(extras);
        reformatButtonClickAction(bundleAsJSONObject);
        return bundleAsJSONObject;
    }

    private final void reformatButtonClickAction(JSONObject jSONObject) {
        try {
            String str = (String) NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject).remove(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID);
            if (str != null) {
                jSONObject.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: org.json.JSONObject} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleProcessJsonOpenData(android.app.Activity r6, org.json.JSONObject r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$2
            r7 = r6
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.lang.Object r6 = r0.L$1
            android.app.Activity r6 = (android.app.Activity) r6
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS r2 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005b
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r8 = r5._lifecycleService
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r8.canOpenNotification(r6, r7, r0)
            if (r8 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r2 = r5
        L_0x005b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0066
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0066:
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r8 = r2._lifecycleService
            com.onesignal.common.JSONUtils r2 = com.onesignal.common.JSONUtils.INSTANCE
            org.json.JSONArray r7 = r2.wrapInJsonArray(r7)
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.notificationOpened(r6, r7, r0)
            if (r6 != r1) goto L_0x007e
            return r1
        L_0x007e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS.handleProcessJsonOpenData(android.app.Activity, org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
