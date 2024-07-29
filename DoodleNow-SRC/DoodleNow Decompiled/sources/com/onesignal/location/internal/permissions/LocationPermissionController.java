package com.onesignal.location.internal.permissions;

import android.app.Activity;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.location.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000  2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001 B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J!\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0004H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/onesignal/location/internal/permissions/LocationPermissionController;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "_requestPermission", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/permissions/IRequestPermissionService;Lcom/onesignal/core/internal/application/IApplicationService;)V", "currPermission", "", "events", "Lcom/onesignal/common/events/EventProducer;", "hasSubscribers", "", "getHasSubscribers", "()Z", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "onAccept", "", "onReject", "fallbackToSettings", "prompt", "androidPermissionString", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFallbackAlertDialog", "start", "subscribe", "handler", "unsubscribe", "Companion", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationPermissionController.kt */
public final class LocationPermissionController implements IRequestPermissionService.PermissionCallback, IStartableService, IEventNotifier<ILocationPermissionChangedHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PERMISSION_TYPE = "LOCATION";
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    private final IRequestPermissionService _requestPermission;
    /* access modifiers changed from: private */
    public String currPermission = "";
    /* access modifiers changed from: private */
    public final EventProducer<ILocationPermissionChangedHandler> events = new EventProducer<>();
    /* access modifiers changed from: private */
    public final WaiterWithValue<Boolean> waiter = new WaiterWithValue<>();

    public LocationPermissionController(IRequestPermissionService iRequestPermissionService, IApplicationService iApplicationService) {
        Intrinsics.checkNotNullParameter(iRequestPermissionService, "_requestPermission");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        this._requestPermission = iRequestPermissionService;
        this._applicationService = iApplicationService;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/location/internal/permissions/LocationPermissionController$Companion;", "", "()V", "PERMISSION_TYPE", "", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LocationPermissionController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void start() {
        this._requestPermission.registerAsCallback("LOCATION", this);
    }

    public final Object prompt(boolean z, String str, Continuation<? super Boolean> continuation) {
        this.currPermission = str;
        this._requestPermission.startPrompt(z, "LOCATION", str, getClass());
        return this.waiter.waitForWake(continuation);
    }

    public void onAccept() {
        this.waiter.wake(true);
        this.events.fire(LocationPermissionController$onAccept$1.INSTANCE);
    }

    public void onReject(boolean z) {
        if (!z || !showFallbackAlertDialog()) {
            this.waiter.wake(false);
            this.events.fire(LocationPermissionController$onReject$1.INSTANCE);
        }
    }

    private final boolean showFallbackAlertDialog() {
        Activity current = this._applicationService.getCurrent();
        if (current == null) {
            return false;
        }
        AlertDialogPrepromptForAndroidSettings alertDialogPrepromptForAndroidSettings = AlertDialogPrepromptForAndroidSettings.INSTANCE;
        String string = current.getString(R.string.location_permission_name_for_title);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…ermission_name_for_title)");
        String string2 = current.getString(R.string.location_permission_settings_message);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…mission_settings_message)");
        alertDialogPrepromptForAndroidSettings.show(current, string, string2, new LocationPermissionController$showFallbackAlertDialog$1(this, current));
        return true;
    }

    public void subscribe(ILocationPermissionChangedHandler iLocationPermissionChangedHandler) {
        Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler, "handler");
        this.events.subscribe(iLocationPermissionChangedHandler);
    }

    public void unsubscribe(ILocationPermissionChangedHandler iLocationPermissionChangedHandler) {
        Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler, "handler");
        this.events.subscribe(iLocationPermissionChangedHandler);
    }

    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }
}
