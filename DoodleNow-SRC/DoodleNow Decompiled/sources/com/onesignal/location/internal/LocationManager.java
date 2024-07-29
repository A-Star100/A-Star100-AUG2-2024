package com.onesignal.location.internal;

import com.onesignal.common.AndroidUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationConstants;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.permissions.ILocationPermissionChangedHandler;
import com.onesignal.location.internal.permissions.LocationPermissionController;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0011\u0010\u001c\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0011\u0010\u001f\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108V@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/location/internal/LocationManager;", "Lcom/onesignal/location/ILocationManager;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_capturer", "Lcom/onesignal/location/internal/capture/ILocationCapturer;", "_locationController", "Lcom/onesignal/location/internal/controller/ILocationController;", "_locationPermissionController", "Lcom/onesignal/location/internal/permissions/LocationPermissionController;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/location/internal/capture/ILocationCapturer;Lcom/onesignal/location/internal/controller/ILocationController;Lcom/onesignal/location/internal/permissions/LocationPermissionController;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "_isShared", "", "value", "isShared", "()Z", "setShared", "(Z)V", "backgroundLocationPermissionLogic", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLocationPermissionChanged", "", "enabled", "requestPermission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "startGetLocation", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationManager.kt */
public final class LocationManager implements ILocationManager, IStartableService, ILocationPermissionChangedHandler {
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final ILocationCapturer _capturer;
    private boolean _isShared;
    private final ILocationController _locationController;
    /* access modifiers changed from: private */
    public final LocationPermissionController _locationPermissionController;
    private final IPreferencesService _prefs;

    public boolean isShared() {
        return this._isShared;
    }

    public LocationManager(IApplicationService iApplicationService, ILocationCapturer iLocationCapturer, ILocationController iLocationController, LocationPermissionController locationPermissionController, IPreferencesService iPreferencesService) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iLocationCapturer, "_capturer");
        Intrinsics.checkNotNullParameter(iLocationController, "_locationController");
        Intrinsics.checkNotNullParameter(locationPermissionController, "_locationPermissionController");
        Intrinsics.checkNotNullParameter(iPreferencesService, "_prefs");
        this._applicationService = iApplicationService;
        this._capturer = iLocationCapturer;
        this._locationController = iLocationController;
        this._locationPermissionController = locationPermissionController;
        this._prefs = iPreferencesService;
        Boolean bool = iPreferencesService.getBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_LOCATION_SHARED, false);
        Intrinsics.checkNotNull(bool);
        this._isShared = bool.booleanValue();
    }

    public void setShared(boolean z) {
        Logging.debug$default("LocationManager.setIsShared(value: " + z + ')', (Throwable) null, 2, (Object) null);
        this._prefs.saveBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_LOCATION_SHARED, Boolean.valueOf(z));
        this._isShared = z;
        onLocationPermissionChanged(z);
    }

    public void start() {
        this._locationPermissionController.subscribe((ILocationPermissionChangedHandler) this);
        if (LocationUtils.INSTANCE.hasLocationPermission(this._applicationService.getAppContext())) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new LocationManager$start$1(this, (Continuation<? super LocationManager$start$1>) null), 1, (Object) null);
        }
    }

    public void onLocationPermissionChanged(boolean z) {
        if (z) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new LocationManager$onLocationPermissionChanged$1(this, (Continuation<? super LocationManager$onLocationPermissionChanged$1>) null), 1, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object requestPermission(kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.location.internal.LocationManager$requestPermission$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.location.internal.LocationManager$requestPermission$1 r0 = (com.onesignal.location.internal.LocationManager$requestPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.location.internal.LocationManager$requestPermission$1 r0 = new com.onesignal.location.internal.LocationManager$requestPermission$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.onesignal.debug.LogLevel r7 = com.onesignal.debug.LogLevel.DEBUG
            java.lang.String r2 = "LocationManager.requestPermission()"
            com.onesignal.debug.internal.logging.Logging.log(r7, r2)
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.location.internal.LocationManager$requestPermission$2 r4 = new com.onesignal.location.internal.LocationManager$requestPermission$2
            r5 = 0
            r4.<init>(r6, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r0 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r0 = r7
        L_0x005f:
            boolean r7 = r0.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.LocationManager.requestPermission(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object backgroundLocationPermissionLogic(boolean z, Continuation<? super Boolean> continuation) {
        if (AndroidUtils.INSTANCE.hasPermission(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING, false, this._applicationService)) {
            return this._locationPermissionController.prompt(z, LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING, continuation);
        }
        return Boxing.boxBoolean(true);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object startGetLocation(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.location.internal.LocationManager$startGetLocation$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.location.internal.LocationManager$startGetLocation$1 r0 = (com.onesignal.location.internal.LocationManager$startGetLocation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.location.internal.LocationManager$startGetLocation$1 r0 = new com.onesignal.location.internal.LocationManager$startGetLocation$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x002c }
            goto L_0x0052
        L_0x002c:
            r7 = move-exception
            goto L_0x0060
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.isShared()
            if (r7 != 0) goto L_0x0042
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0042:
            java.lang.String r7 = "LocationManager.startGetLocation()"
            com.onesignal.debug.internal.logging.Logging.debug$default(r7, r5, r3, r5)
            com.onesignal.location.internal.controller.ILocationController r7 = r6._locationController     // Catch:{ all -> 0x002c }
            r0.label = r4     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = r7.start(r0)     // Catch:{ all -> 0x002c }
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x002c }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x002c }
            if (r7 != 0) goto L_0x0065
            java.lang.String r7 = "LocationManager.startGetLocation: not possible, no location dependency found"
            com.onesignal.debug.internal.logging.Logging.warn$default(r7, r5, r3, r5)     // Catch:{ all -> 0x002c }
            goto L_0x0065
        L_0x0060:
            java.lang.String r0 = "LocationManager.startGetLocation: Location permission exists but there was an error initializing: "
            com.onesignal.debug.internal.logging.Logging.warn(r0, r7)
        L_0x0065:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.LocationManager.startGetLocation(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
