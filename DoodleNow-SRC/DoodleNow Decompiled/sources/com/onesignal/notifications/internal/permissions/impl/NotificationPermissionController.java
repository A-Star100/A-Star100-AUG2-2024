package com.onesignal.notifications.internal.permissions.impl;

import android.app.Activity;
import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.Waiter;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.notifications.R;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadPoolDispatcherKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0011\u0010'\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0016H\u0016J\u0010\u0010/\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/onesignal/notifications/internal/permissions/impl/NotificationPermissionController;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "_requestPermission", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_applicationService", "_preferenceService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/permissions/IRequestPermissionService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "enabled", "events", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "hasSubscribers", "getHasSubscribers", "pollingWaitInterval", "", "pollingWaiter", "Lcom/onesignal/common/threading/Waiter;", "supportsNativePrompt", "getSupportsNativePrompt", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "notificationsEnabled", "onAccept", "", "onReject", "fallbackToSettings", "permissionPromptCompleted", "pollForPermission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prompt", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPollingLifecycleListener", "showFallbackAlertDialog", "subscribe", "handler", "unsubscribe", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationPermissionController.kt */
public final class NotificationPermissionController implements IRequestPermissionService.PermissionCallback, INotificationPermissionController {
    private static final String ANDROID_PERMISSION_STRING = "android.permission.POST_NOTIFICATIONS";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PERMISSION_TYPE = "NOTIFICATION";
    private final IApplicationService _application;
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final ConfigModelStore _configModelStore;
    private final IPreferencesService _preferenceService;
    private final IRequestPermissionService _requestPermission;
    private final CoroutineScope coroutineScope;
    private boolean enabled;
    private final EventProducer<INotificationPermissionChangedHandler> events = new EventProducer<>();
    /* access modifiers changed from: private */
    public long pollingWaitInterval;
    /* access modifiers changed from: private */
    public final Waiter pollingWaiter = new Waiter();
    private final boolean supportsNativePrompt;
    private final WaiterWithValue<Boolean> waiter = new WaiterWithValue<>();

    public final boolean getSupportsNativePrompt() {
        return this.supportsNativePrompt;
    }

    public NotificationPermissionController(IApplicationService iApplicationService, IRequestPermissionService iRequestPermissionService, IApplicationService iApplicationService2, IPreferencesService iPreferencesService, ConfigModelStore configModelStore) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_application");
        Intrinsics.checkNotNullParameter(iRequestPermissionService, "_requestPermission");
        Intrinsics.checkNotNullParameter(iApplicationService2, "_applicationService");
        Intrinsics.checkNotNullParameter(iPreferencesService, "_preferenceService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this._application = iApplicationService;
        this._requestPermission = iRequestPermissionService;
        this._applicationService = iApplicationService2;
        this._preferenceService = iPreferencesService;
        this._configModelStore = configModelStore;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("NotificationPermissionController"));
        this.coroutineScope = CoroutineScope;
        this.enabled = notificationsEnabled();
        iRequestPermissionService.registerAsCallback(PERMISSION_TYPE, this);
        this.pollingWaitInterval = ((ConfigModel) configModelStore.getModel()).getBackgroundFetchNotificationPermissionInterval();
        registerPollingLifecycleListener();
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        this.supportsNativePrompt = Build.VERSION.SDK_INT > 32 && AndroidUtils.INSTANCE.getTargetSdkVersion(iApplicationService.getAppContext()) > 32;
    }

    public boolean getCanRequestPermission() {
        Boolean bool = this._preferenceService.getBool(PreferenceStores.ONESIGNAL, "USER_RESOLVED_PERMISSION_android.permission.POST_NOTIFICATIONS", false);
        Intrinsics.checkNotNull(bool);
        return !bool.booleanValue();
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$1", f = "NotificationPermissionController.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$1  reason: invalid class name */
    /* compiled from: NotificationPermissionController.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NotificationPermissionController this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.pollForPermission(this) == coroutine_suspended) {
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

    private final void registerPollingLifecycleListener() {
        this._applicationService.addApplicationLifecycleHandler(new NotificationPermissionController$registerPollingLifecycleListener$1(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object pollForPermission(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1 r0 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1 r0 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController r2 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003a
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r7
        L_0x003a:
            boolean r8 = r2.notificationsEnabled()
            boolean r4 = r2.enabled
            if (r4 == r8) goto L_0x0050
            r2.enabled = r8
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler> r4 = r2.events
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$2 r5 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$2
            r5.<init>(r8)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r4.fire(r5)
        L_0x0050:
            long r4 = r2.pollingWaitInterval
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$3 r8 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$pollForPermission$3
            r6 = 0
            r8.<init>(r2, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r4, r8, r0)
            if (r8 != r1) goto L_0x003a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.pollForPermission(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void permissionPromptCompleted(boolean z) {
        this.enabled = z;
        this.waiter.wake(Boolean.valueOf(z));
        this.events.fire(new NotificationPermissionController$permissionPromptCompleted$1(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object prompt(boolean r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1 r0 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1 r0 = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$prompt$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0080
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            boolean r8 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController r2 = (com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0050
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r7
            r0.Z$0 = r8
            r0.label = r4
            java.lang.Object r9 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r9 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r2 = r7
        L_0x0050:
            boolean r9 = r2.notificationsEnabled()
            if (r9 == 0) goto L_0x005b
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x005b:
            boolean r9 = r2.supportsNativePrompt
            if (r9 == 0) goto L_0x006d
            com.onesignal.core.internal.permissions.IRequestPermissionService r9 = r2._requestPermission
            java.lang.String r4 = "android.permission.POST_NOTIFICATIONS"
            java.lang.Class r5 = r2.getClass()
            java.lang.String r6 = "NOTIFICATION"
            r9.startPrompt(r8, r6, r4, r5)
            goto L_0x0072
        L_0x006d:
            if (r8 == 0) goto L_0x0081
            r2.showFallbackAlertDialog()
        L_0x0072:
            com.onesignal.common.threading.WaiterWithValue<java.lang.Boolean> r8 = r2.waiter
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r9 = r8.waitForWake(r0)
            if (r9 != r1) goto L_0x0080
            return r1
        L_0x0080:
            return r9
        L_0x0081:
            r8 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.prompt(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void subscribe(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler) {
        Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler, "handler");
        this.events.subscribe(iNotificationPermissionChangedHandler);
    }

    public void unsubscribe(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler) {
        Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler, "handler");
        this.events.subscribe(iNotificationPermissionChangedHandler);
    }

    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    public void onAccept() {
        permissionPromptCompleted(true);
    }

    public void onReject(boolean z) {
        if (!z || !showFallbackAlertDialog()) {
            permissionPromptCompleted(false);
        }
    }

    private final boolean showFallbackAlertDialog() {
        Activity current = this._application.getCurrent();
        if (current == null) {
            return false;
        }
        AlertDialogPrepromptForAndroidSettings alertDialogPrepromptForAndroidSettings = AlertDialogPrepromptForAndroidSettings.INSTANCE;
        String string = current.getString(R.string.notification_permission_name_for_title);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…ermission_name_for_title)");
        String string2 = current.getString(R.string.notification_permission_settings_message);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…mission_settings_message)");
        alertDialogPrepromptForAndroidSettings.show(current, string, string2, new NotificationPermissionController$showFallbackAlertDialog$1(this, current));
        return true;
    }

    private final boolean notificationsEnabled() {
        return NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._application.getAppContext(), (String) null, 2, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/permissions/impl/NotificationPermissionController$Companion;", "", "()V", "ANDROID_PERMISSION_STRING", "", "PERMISSION_TYPE", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationPermissionController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
