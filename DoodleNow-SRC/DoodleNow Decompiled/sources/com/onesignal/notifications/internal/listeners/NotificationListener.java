package com.onesignal.notifications.internal.listeners;

import android.app.Activity;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.common.OSNotificationOpenAppSettings;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020!H\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/onesignal/notifications/internal/listeners/NotificationListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationLifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_backend", "Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "_receiveReceiptWorkManager", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;", "_activityOpener", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "_analyticsTracker", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/notifications/internal/backend/INotificationBackendService;Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;Lcom/onesignal/notifications/internal/INotificationActivityOpener;Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;Lcom/onesignal/core/internal/time/ITime;)V", "postedOpenedNotifIds", "", "", "getLatestNotificationId", "data", "Lorg/json/JSONArray;", "onNotificationOpened", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onNotificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldInitDirectSessionFromNotificationOpen", "", "context", "start", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationListener.kt */
public final class NotificationListener implements IStartableService, INotificationLifecycleEventHandler {
    private final INotificationActivityOpener _activityOpener;
    private final IAnalyticsTracker _analyticsTracker;
    private final IApplicationService _applicationService;
    private final INotificationBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IInfluenceManager _influenceManager;
    private final INotificationLifecycleService _notificationLifecycleService;
    private final IReceiveReceiptWorkManager _receiveReceiptWorkManager;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final Set<String> postedOpenedNotifIds = new LinkedHashSet();

    public NotificationListener(IApplicationService iApplicationService, INotificationLifecycleService iNotificationLifecycleService, ConfigModelStore configModelStore, IInfluenceManager iInfluenceManager, ISubscriptionManager iSubscriptionManager, IDeviceService iDeviceService, INotificationBackendService iNotificationBackendService, IReceiveReceiptWorkManager iReceiveReceiptWorkManager, INotificationActivityOpener iNotificationActivityOpener, IAnalyticsTracker iAnalyticsTracker, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService, "_notificationLifecycleService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iInfluenceManager, "_influenceManager");
        Intrinsics.checkNotNullParameter(iSubscriptionManager, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(iNotificationBackendService, "_backend");
        Intrinsics.checkNotNullParameter(iReceiveReceiptWorkManager, "_receiveReceiptWorkManager");
        Intrinsics.checkNotNullParameter(iNotificationActivityOpener, "_activityOpener");
        Intrinsics.checkNotNullParameter(iAnalyticsTracker, "_analyticsTracker");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._notificationLifecycleService = iNotificationLifecycleService;
        this._configModelStore = configModelStore;
        this._influenceManager = iInfluenceManager;
        this._subscriptionManager = iSubscriptionManager;
        this._deviceService = iDeviceService;
        this._backend = iNotificationBackendService;
        this._receiveReceiptWorkManager = iReceiveReceiptWorkManager;
        this._activityOpener = iNotificationActivityOpener;
        this._analyticsTracker = iAnalyticsTracker;
        this._time = iTime;
    }

    public void start() {
        this._notificationLifecycleService.addInternalNotificationLifecycleEventHandler(this);
    }

    public Object onNotificationReceived(NotificationGenerationJob notificationGenerationJob, Continuation<? super Unit> continuation) {
        this._receiveReceiptWorkManager.enqueueReceiveReceipt(notificationGenerationJob.getApiNotificationId());
        this._influenceManager.onNotificationReceived(notificationGenerationJob.getApiNotificationId());
        try {
            JSONObject jSONObject = new JSONObject(notificationGenerationJob.getJsonPayload().toString());
            jSONObject.put(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, notificationGenerationJob.getAndroidId());
            NotificationClickEvent generateNotificationOpenedResult$com_onesignal_notifications = NotificationHelper.INSTANCE.generateNotificationOpenedResult$com_onesignal_notifications(JSONUtils.INSTANCE.wrapInJsonArray(jSONObject), this._time);
            IAnalyticsTracker iAnalyticsTracker = this._analyticsTracker;
            String notificationId = generateNotificationOpenedResult$com_onesignal_notifications.getNotification().getNotificationId();
            Intrinsics.checkNotNull(notificationId);
            iAnalyticsTracker.trackReceivedEvent(notificationId, NotificationHelper.INSTANCE.getCampaignNameFromNotification(generateNotificationOpenedResult$com_onesignal_notifications.getNotification()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:26|(2:27|28)|29|30|31|(1:33)(3:34|35|41)|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fe, code lost:
        r13 = r2;
        r12 = r3;
        r2 = r4;
        r3 = r14;
        r4 = r15;
        r14 = r16;
        r11 = r17;
        r10 = r18;
        r9 = r19;
        r8 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010d, code lost:
        com.onesignal.debug.internal.logging.Logging.error$default("Notification opened confirmation failed with statusCode: " + r0.getStatusCode() + " response: " + r0.getResponse(), (java.lang.Throwable) null, 2, (java.lang.Object) null);
        r15 = r4;
        r6 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0194 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object onNotificationOpened(android.app.Activity r24, org.json.JSONArray r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            r23 = this;
            r1 = r23
            r0 = r26
            boolean r2 = r0 instanceof com.onesignal.notifications.internal.listeners.NotificationListener$onNotificationOpened$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.onesignal.notifications.internal.listeners.NotificationListener$onNotificationOpened$1 r2 = (com.onesignal.notifications.internal.listeners.NotificationListener$onNotificationOpened$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.onesignal.notifications.internal.listeners.NotificationListener$onNotificationOpened$1 r2 = new com.onesignal.notifications.internal.listeners.NotificationListener$onNotificationOpened$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x005f
            if (r4 == r6) goto L_0x003b
            if (r4 != r5) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0195
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003b:
            int r4 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$5
            com.onesignal.core.internal.device.IDeviceService$DeviceType r9 = (com.onesignal.core.internal.device.IDeviceService.DeviceType) r9
            java.lang.Object r10 = r2.L$4
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$3
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r2.L$2
            org.json.JSONArray r12 = (org.json.JSONArray) r12
            java.lang.Object r13 = r2.L$1
            android.app.Activity r13 = (android.app.Activity) r13
            java.lang.Object r14 = r2.L$0
            com.onesignal.notifications.internal.listeners.NotificationListener r14 = (com.onesignal.notifications.internal.listeners.NotificationListener) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x005c }
            goto L_0x00ef
        L_0x005c:
            r0 = move-exception
            goto L_0x010d
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.core.internal.config.ConfigModelStore r0 = r1._configModelStore
            com.onesignal.common.modeling.Model r0 = r0.getModel()
            com.onesignal.core.internal.config.ConfigModel r0 = (com.onesignal.core.internal.config.ConfigModel) r0
            java.lang.String r0 = r0.getAppId()
            if (r0 != 0) goto L_0x0072
            java.lang.String r0 = ""
        L_0x0072:
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r4 = r1._subscriptionManager
            com.onesignal.user.internal.subscriptions.SubscriptionList r4 = r4.getSubscriptions()
            com.onesignal.user.subscriptions.IPushSubscription r4 = r4.getPush()
            java.lang.String r4 = r4.getId()
            com.onesignal.core.internal.device.IDeviceService r8 = r1._deviceService
            com.onesignal.core.internal.device.IDeviceService$DeviceType r8 = r8.getDeviceType()
            int r9 = r25.length()
            r10 = 0
            r14 = r3
            r11 = r4
            r12 = r8
            r15 = r9
            r13 = r10
            r3 = r25
            r10 = r0
            r9 = r1
            r4 = r2
            r2 = r24
        L_0x0097:
            if (r13 >= r15) goto L_0x0142
            com.onesignal.notifications.internal.common.NotificationFormatHelper r0 = com.onesignal.notifications.internal.common.NotificationFormatHelper.INSTANCE
            java.lang.Object r8 = r3.get(r13)
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            java.lang.String r0 = r0.getOSNotificationIdFromJson(r8)
            if (r0 != 0) goto L_0x00a9
            goto L_0x013f
        L_0x00a9:
            java.util.Set<java.lang.String> r8 = r9.postedOpenedNotifIds
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L_0x00b3
            goto L_0x013f
        L_0x00b3:
            java.util.Set<java.lang.String> r8 = r9.postedOpenedNotifIds
            r8.add(r0)
            com.onesignal.notifications.internal.backend.INotificationBackendService r8 = r9._backend     // Catch:{ BackendException -> 0x00f3 }
            r4.L$0 = r9     // Catch:{ BackendException -> 0x00f3 }
            r4.L$1 = r2     // Catch:{ BackendException -> 0x00f3 }
            r4.L$2 = r3     // Catch:{ BackendException -> 0x00f3 }
            r4.L$3 = r10     // Catch:{ BackendException -> 0x00f3 }
            r4.L$4 = r11     // Catch:{ BackendException -> 0x00f3 }
            r4.L$5 = r12     // Catch:{ BackendException -> 0x00f3 }
            r4.I$0 = r13     // Catch:{ BackendException -> 0x00f3 }
            r4.I$1 = r15     // Catch:{ BackendException -> 0x00f3 }
            r4.label = r6     // Catch:{ BackendException -> 0x00f3 }
            r16 = r9
            r9 = r10
            r17 = r10
            r10 = r0
            r18 = r11
            r19 = r12
            r20 = r13
            r13 = r4
            java.lang.Object r0 = r8.updateNotificationAsOpened(r9, r10, r11, r12, r13)     // Catch:{ BackendException -> 0x00f1 }
            if (r0 != r14) goto L_0x00e0
            return r14
        L_0x00e0:
            r13 = r2
            r12 = r3
            r2 = r4
            r3 = r14
            r4 = r15
            r14 = r16
            r11 = r17
            r10 = r18
            r9 = r19
            r8 = r20
        L_0x00ef:
            r15 = r4
            goto L_0x0130
        L_0x00f1:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f3:
            r0 = move-exception
            r16 = r9
            r17 = r10
            r18 = r11
            r19 = r12
            r20 = r13
        L_0x00fe:
            r13 = r2
            r12 = r3
            r2 = r4
            r3 = r14
            r4 = r15
            r14 = r16
            r11 = r17
            r10 = r18
            r9 = r19
            r8 = r20
        L_0x010d:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r6 = "Notification opened confirmation failed with statusCode: "
            r15.<init>(r6)
            int r6 = r0.getStatusCode()
            r15.append(r6)
            java.lang.String r6 = " response: "
            r15.append(r6)
            java.lang.String r0 = r0.getResponse()
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            com.onesignal.debug.internal.logging.Logging.error$default(r0, r7, r5, r7)
            r15 = r4
            r6 = 1
        L_0x0130:
            r4 = r2
            r2 = r13
            r13 = r8
            r21 = r14
            r14 = r3
            r3 = r12
            r12 = r9
            r9 = r21
            r22 = r11
            r11 = r10
            r10 = r22
        L_0x013f:
            int r13 = r13 + r6
            goto L_0x0097
        L_0x0142:
            r16 = r9
            com.onesignal.notifications.internal.common.NotificationHelper r0 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            com.onesignal.core.internal.time.ITime r6 = r9._time
            com.onesignal.notifications.internal.NotificationClickEvent r0 = r0.generateNotificationOpenedResult$com_onesignal_notifications(r3, r6)
            com.onesignal.notifications.internal.analytics.IAnalyticsTracker r6 = r9._analyticsTracker
            com.onesignal.notifications.INotification r8 = r0.getNotification()
            java.lang.String r8 = r8.getNotificationId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.onesignal.notifications.internal.common.NotificationHelper r10 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            com.onesignal.notifications.INotification r0 = r0.getNotification()
            java.lang.String r0 = r10.getCampaignNameFromNotification(r0)
            r6.trackOpenedEvent(r8, r0)
            java.lang.String r0 = r9.getLatestNotificationId(r3)
            boolean r6 = r9.shouldInitDirectSessionFromNotificationOpen(r2)
            if (r6 == 0) goto L_0x017e
            com.onesignal.core.internal.application.IApplicationService r6 = r9._applicationService
            com.onesignal.core.internal.application.AppEntryAction r8 = com.onesignal.core.internal.application.AppEntryAction.NOTIFICATION_CLICK
            r6.setEntryState(r8)
            if (r0 == 0) goto L_0x017e
            com.onesignal.session.internal.influence.IInfluenceManager r6 = r9._influenceManager
            r6.onDirectInfluenceFromNotification(r0)
        L_0x017e:
            com.onesignal.notifications.internal.INotificationActivityOpener r0 = r9._activityOpener
            r4.L$0 = r7
            r4.L$1 = r7
            r4.L$2 = r7
            r4.L$3 = r7
            r4.L$4 = r7
            r4.L$5 = r7
            r4.label = r5
            java.lang.Object r0 = r0.openDestinationActivity(r2, r3, r4)
            if (r0 != r14) goto L_0x0195
            return r14
        L_0x0195:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.listeners.NotificationListener.onNotificationOpened(android.app.Activity, org.json.JSONArray, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean shouldInitDirectSessionFromNotificationOpen(Activity activity) {
        if (this._applicationService.isInForeground()) {
            return false;
        }
        try {
            return OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(activity);
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    private final String getLatestNotificationId(JSONArray jSONArray) {
        JSONObject jSONObject;
        if (jSONArray.length() > 0) {
            Object obj = jSONArray.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = null;
        }
        return NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(jSONObject);
    }
}
