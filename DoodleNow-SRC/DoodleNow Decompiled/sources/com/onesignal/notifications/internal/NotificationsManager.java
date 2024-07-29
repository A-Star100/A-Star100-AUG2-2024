package com.onesignal.notifications.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.notifications.internal.common.GenerateNotificationOpenIntentFromPushPayload;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J!\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u001eH\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u00103\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001cH\u0016J\u0019\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationsManager;", "Lcom/onesignal/notifications/INotificationsManager;", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationPermissionController", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;", "_notificationRestoreWorkManager", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;", "_notificationLifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_notificationDataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_summaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;)V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "setPermission", "(Z)V", "permissionChangedNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/IPermissionObserver;", "addClickListener", "", "listener", "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "clearAllNotifications", "onFocus", "firedOnSubscribe", "onNotificationPermissionChanged", "enabled", "onUnfocused", "openDestinationActivity", "activity", "Landroid/app/Activity;", "pushPayloads", "Lorg/json/JSONArray;", "(Landroid/app/Activity;Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshNotificationState", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPermissionStatusAndFire", "isEnabled", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationsManager.kt */
public final class NotificationsManager implements INotificationsManager, INotificationActivityOpener, INotificationPermissionChangedHandler, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final INotificationRepository _notificationDataController;
    private final INotificationLifecycleService _notificationLifecycleService;
    /* access modifiers changed from: private */
    public final INotificationPermissionController _notificationPermissionController;
    private final INotificationRestoreWorkManager _notificationRestoreWorkManager;
    /* access modifiers changed from: private */
    public final INotificationSummaryManager _summaryManager;
    private boolean permission;
    private final EventProducer<IPermissionObserver> permissionChangedNotifier = new EventProducer<>();

    public boolean getPermission() {
        return this.permission;
    }

    public void onUnfocused() {
    }

    public void setPermission(boolean z) {
        this.permission = z;
    }

    public NotificationsManager(IApplicationService iApplicationService, INotificationPermissionController iNotificationPermissionController, INotificationRestoreWorkManager iNotificationRestoreWorkManager, INotificationLifecycleService iNotificationLifecycleService, INotificationRepository iNotificationRepository, INotificationSummaryManager iNotificationSummaryManager) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationPermissionController, "_notificationPermissionController");
        Intrinsics.checkNotNullParameter(iNotificationRestoreWorkManager, "_notificationRestoreWorkManager");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService, "_notificationLifecycleService");
        Intrinsics.checkNotNullParameter(iNotificationRepository, "_notificationDataController");
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager, "_summaryManager");
        this._applicationService = iApplicationService;
        this._notificationPermissionController = iNotificationPermissionController;
        this._notificationRestoreWorkManager = iNotificationRestoreWorkManager;
        this._notificationLifecycleService = iNotificationLifecycleService;
        this._notificationDataController = iNotificationRepository;
        this._summaryManager = iNotificationSummaryManager;
        this.permission = NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, iApplicationService.getAppContext(), (String) null, 2, (Object) null);
        iApplicationService.addApplicationLifecycleHandler(this);
        iNotificationPermissionController.subscribe(this);
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 1, (Object) null);
    }

    public boolean getCanRequestPermission() {
        return this._notificationPermissionController.getCanRequestPermission();
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.onesignal.notifications.internal.NotificationsManager$1", f = "NotificationsManager.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.onesignal.notifications.internal.NotificationsManager$1  reason: invalid class name */
    /* compiled from: NotificationsManager.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NotificationsManager this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0._notificationDataController.deleteExpiredNotifications(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public void onFocus(boolean z) {
        refreshNotificationState();
    }

    public void onNotificationPermissionChanged(boolean z) {
        setPermissionStatusAndFire(z);
    }

    private final void refreshNotificationState() {
        this._notificationRestoreWorkManager.beginEnqueueingWork(this._applicationService.getAppContext(), false);
        setPermissionStatusAndFire(NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._applicationService.getAppContext(), (String) null, 2, (Object) null));
    }

    public Object requestPermission(boolean z, Continuation<? super Boolean> continuation) {
        Logging.debug$default("NotificationsManager.requestPermission()", (Throwable) null, 2, (Object) null);
        return BuildersKt.withContext(Dispatchers.getMain(), new NotificationsManager$requestPermission$2(this, z, (Continuation<? super NotificationsManager$requestPermission$2>) null), continuation);
    }

    private final void setPermissionStatusAndFire(boolean z) {
        boolean permission2 = getPermission();
        setPermission(z);
        if (permission2 != z) {
            this.permissionChangedNotifier.fireOnMain(new NotificationsManager$setPermissionStatusAndFire$1(z));
        }
    }

    public void removeNotification(int i) {
        Logging.debug$default("NotificationsManager.removeNotification(id: " + i + ')', (Throwable) null, 2, (Object) null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new NotificationsManager$removeNotification$1(this, i, (Continuation<? super NotificationsManager$removeNotification$1>) null), 1, (Object) null);
    }

    public void removeGroupedNotifications(String str) {
        Intrinsics.checkNotNullParameter(str, "group");
        Logging.debug$default("NotificationsManager.removeGroupedNotifications(group: " + str + ')', (Throwable) null, 2, (Object) null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new NotificationsManager$removeGroupedNotifications$1(this, str, (Continuation<? super NotificationsManager$removeGroupedNotifications$1>) null), 1, (Object) null);
    }

    public void clearAllNotifications() {
        Logging.debug$default("NotificationsManager.clearAllNotifications()", (Throwable) null, 2, (Object) null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new NotificationsManager$clearAllNotifications$1(this, (Continuation<? super NotificationsManager$clearAllNotifications$1>) null), 1, (Object) null);
    }

    public void addPermissionObserver(IPermissionObserver iPermissionObserver) {
        Intrinsics.checkNotNullParameter(iPermissionObserver, "observer");
        Logging.debug$default("NotificationsManager.addPermissionObserver(observer: " + iPermissionObserver + ')', (Throwable) null, 2, (Object) null);
        this.permissionChangedNotifier.subscribe(iPermissionObserver);
    }

    public void removePermissionObserver(IPermissionObserver iPermissionObserver) {
        Intrinsics.checkNotNullParameter(iPermissionObserver, "observer");
        Logging.debug$default("NotificationsManager.removePermissionObserver(observer: " + iPermissionObserver + ')', (Throwable) null, 2, (Object) null);
        this.permissionChangedNotifier.unsubscribe(iPermissionObserver);
    }

    public void addForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("NotificationsManager.addForegroundLifecycleListener(listener: " + iNotificationLifecycleListener + ')', (Throwable) null, 2, (Object) null);
        this._notificationLifecycleService.addExternalForegroundLifecycleListener(iNotificationLifecycleListener);
    }

    public void removeForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("NotificationsManager.removeForegroundLifecycleListener(listener: " + iNotificationLifecycleListener + ')', (Throwable) null, 2, (Object) null);
        this._notificationLifecycleService.removeExternalForegroundLifecycleListener(iNotificationLifecycleListener);
    }

    public void addClickListener(INotificationClickListener iNotificationClickListener) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("NotificationsManager.addClickListener(handler: " + iNotificationClickListener + ')', (Throwable) null, 2, (Object) null);
        this._notificationLifecycleService.addExternalClickListener(iNotificationClickListener);
    }

    public void removeClickListener(INotificationClickListener iNotificationClickListener) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("NotificationsManager.removeClickListener(listener: " + iNotificationClickListener + ')', (Throwable) null, 2, (Object) null);
        this._notificationLifecycleService.removeExternalClickListener(iNotificationClickListener);
    }

    public Object openDestinationActivity(Activity activity, JSONArray jSONArray, Continuation<? super Unit> continuation) {
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "firstPayloadItem");
            Intent intentVisible = GenerateNotificationOpenIntentFromPushPayload.INSTANCE.create(activity, jSONObject).getIntentVisible();
            if (intentVisible != null) {
                Logging.info$default("SDK running startActivity with Intent: " + intentVisible, (Throwable) null, 2, (Object) null);
                activity.startActivity(intentVisible);
            } else {
                Logging.info$default("SDK not showing an Activity automatically due to it's settings.", (Throwable) null, 2, (Object) null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }
}
