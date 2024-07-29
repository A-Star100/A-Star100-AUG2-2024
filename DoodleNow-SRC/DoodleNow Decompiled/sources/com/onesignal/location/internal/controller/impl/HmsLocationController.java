package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.common.LocationConstants;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0011\u0010\u0017\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/location/internal/controller/impl/HmsLocationController;", "Lcom/onesignal/location/internal/controller/ILocationController;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "event", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "hasSubscribers", "", "getHasSubscribers", "()Z", "hmsFusedLocationClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "lastLocation", "Landroid/location/Location;", "locationHandlerThread", "Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationHandlerThread;", "locationUpdateListener", "Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationUpdateListener;", "startStopMutex", "Lkotlinx/coroutines/sync/Mutex;", "getLastLocation", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "", "subscribe", "handler", "unsubscribe", "LocationHandlerThread", "LocationUpdateListener", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HmsLocationController.kt */
public final class HmsLocationController implements ILocationController {
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final EventProducer<ILocationUpdatedHandler> event = new EventProducer<>();
    /* access modifiers changed from: private */
    public FusedLocationProviderClient hmsFusedLocationClient;
    /* access modifiers changed from: private */
    public Location lastLocation;
    /* access modifiers changed from: private */
    public final LocationHandlerThread locationHandlerThread = new LocationHandlerThread();
    /* access modifiers changed from: private */
    public LocationUpdateListener locationUpdateListener;
    /* access modifiers changed from: private */
    public final Mutex startStopMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    public HmsLocationController(IApplicationService iApplicationService) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        this._applicationService = iApplicationService;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.location.internal.controller.impl.HmsLocationController$start$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$1 r0 = (com.onesignal.location.internal.controller.impl.HmsLocationController$start$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$1 r0 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005f
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r8.element = r7
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$2 r5 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$2
            r6 = 0
            r5.<init>(r7, r2, r8, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r0)
            if (r8 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r0 = r2
        L_0x005f:
            boolean r8 = r0.element
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.HmsLocationController.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053 A[Catch:{ all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f A[Catch:{ all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object stop(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1 r0 = (com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1 r0 = new com.onesignal.location.internal.controller.impl.HmsLocationController$stop$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            com.onesignal.location.internal.controller.impl.HmsLocationController r0 = (com.onesignal.location.internal.controller.impl.HmsLocationController) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.startStopMutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r5
            r1 = r6
        L_0x004f:
            com.onesignal.location.internal.controller.impl.HmsLocationController$LocationUpdateListener r6 = r0.locationUpdateListener     // Catch:{ all -> 0x006b }
            if (r6 == 0) goto L_0x005b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x006b }
            r6.close()     // Catch:{ all -> 0x006b }
            r0.locationUpdateListener = r4     // Catch:{ all -> 0x006b }
        L_0x005b:
            com.huawei.hms.location.FusedLocationProviderClient r6 = r0.hmsFusedLocationClient     // Catch:{ all -> 0x006b }
            if (r6 == 0) goto L_0x0061
            r0.hmsFusedLocationClient = r4     // Catch:{ all -> 0x006b }
        L_0x0061:
            r0.lastLocation = r4     // Catch:{ all -> 0x006b }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006b }
            r1.unlock(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x006b:
            r6 = move-exception
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.HmsLocationController.stop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Location getLastLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = this.hmsFusedLocationClient;
        if (fusedLocationProviderClient == null) {
            return null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ThreadUtilsKt.suspendifyOnThread$default(0, new HmsLocationController$getLastLocation$1(fusedLocationProviderClient, objectRef, (Continuation<? super HmsLocationController$getLastLocation$1>) null), 1, (Object) null);
        return (Location) objectRef.element;
    }

    public void subscribe(ILocationUpdatedHandler iLocationUpdatedHandler) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler, "handler");
        this.event.subscribe(iLocationUpdatedHandler);
    }

    public void unsubscribe(ILocationUpdatedHandler iLocationUpdatedHandler) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler, "handler");
        this.event.unsubscribe(iLocationUpdatedHandler);
    }

    public boolean getHasSubscribers() {
        return this.event.getHasSubscribers();
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationUpdateListener;", "Lcom/huawei/hms/location/LocationCallback;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "Ljava/io/Closeable;", "_parent", "Lcom/onesignal/location/internal/controller/impl/HmsLocationController;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "huaweiFusedLocationProviderClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "(Lcom/onesignal/location/internal/controller/impl/HmsLocationController;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/huawei/hms/location/FusedLocationProviderClient;)V", "hasExistingRequest", "", "close", "", "onFocus", "firedOnSubscribe", "onLocationResult", "locationResult", "Lcom/huawei/hms/location/LocationResult;", "onUnfocused", "refreshRequest", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HmsLocationController.kt */
    public static final class LocationUpdateListener extends LocationCallback implements IApplicationLifecycleHandler, Closeable {
        private final IApplicationService _applicationService;
        private final HmsLocationController _parent;
        private boolean hasExistingRequest;
        private final FusedLocationProviderClient huaweiFusedLocationProviderClient;

        public LocationUpdateListener(HmsLocationController hmsLocationController, IApplicationService iApplicationService, FusedLocationProviderClient fusedLocationProviderClient) {
            Intrinsics.checkNotNullParameter(hmsLocationController, "_parent");
            Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
            Intrinsics.checkNotNullParameter(fusedLocationProviderClient, "huaweiFusedLocationProviderClient");
            this._parent = hmsLocationController;
            this._applicationService = iApplicationService;
            this.huaweiFusedLocationProviderClient = fusedLocationProviderClient;
            iApplicationService.addApplicationLifecycleHandler(this);
            refreshRequest();
        }

        public void onFocus(boolean z) {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onFocus()");
            refreshRequest();
        }

        public void onUnfocused() {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onUnfocused()");
            refreshRequest();
        }

        public void close() {
            this._applicationService.removeApplicationLifecycleHandler(this);
            if (this.hasExistingRequest) {
                this.huaweiFusedLocationProviderClient.removeLocationUpdates((LocationCallback) this);
            }
        }

        public void onLocationResult(LocationResult locationResult) {
            Intrinsics.checkNotNullParameter(locationResult, "locationResult");
            Logging.debug$default("HMSLocationController onLocationResult: " + locationResult, (Throwable) null, 2, (Object) null);
            this._parent.lastLocation = locationResult.getLastLocation();
        }

        private final void refreshRequest() {
            if (this.hasExistingRequest) {
                this.huaweiFusedLocationProviderClient.removeLocationUpdates((LocationCallback) this);
            }
            long j = this._applicationService.isInForeground() ? LocationConstants.FOREGROUND_UPDATE_TIME_MS : LocationConstants.BACKGROUND_UPDATE_TIME_MS;
            LocationRequest priority = LocationRequest.create().setFastestInterval(j).setInterval(j).setMaxWaitTime((long) (((double) j) * 1.5d)).setPriority(102);
            Logging.debug$default("HMSLocationController Huawei LocationServices requestLocationUpdates!", (Throwable) null, 2, (Object) null);
            this.huaweiFusedLocationProviderClient.requestLocationUpdates(priority, (LocationCallback) this, this._parent.locationHandlerThread.getLooper());
            this.hasExistingRequest = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationHandlerThread;", "Landroid/os/HandlerThread;", "()V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HmsLocationController.kt */
    public static final class LocationHandlerThread extends HandlerThread {
        private Handler mHandler = new Handler(getLooper());

        public final Handler getMHandler() {
            return this.mHandler;
        }

        public final void setMHandler(Handler handler) {
            Intrinsics.checkNotNullParameter(handler, "<set-?>");
            this.mHandler = handler;
        }

        public LocationHandlerThread() {
            super("OSH_LocationHandlerThread");
            start();
        }
    }
}
