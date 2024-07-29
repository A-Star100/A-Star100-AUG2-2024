package com.onesignal.location.internal.background;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/onesignal/location/internal/background/LocationBackgroundService;", "Lcom/onesignal/core/internal/background/IBackgroundService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_locationManager", "Lcom/onesignal/location/ILocationManager;", "_prefs", "Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;", "_capturer", "Lcom/onesignal/location/internal/capture/ILocationCapturer;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/location/ILocationManager;Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;Lcom/onesignal/location/internal/capture/ILocationCapturer;Lcom/onesignal/core/internal/time/ITime;)V", "scheduleBackgroundRunIn", "", "getScheduleBackgroundRunIn", "()Ljava/lang/Long;", "backgroundRun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationBackgroundService.kt */
public final class LocationBackgroundService implements IBackgroundService {
    private final IApplicationService _applicationService;
    private final ILocationCapturer _capturer;
    private final ILocationManager _locationManager;
    private final ILocationPreferencesService _prefs;
    private final ITime _time;

    public LocationBackgroundService(IApplicationService iApplicationService, ILocationManager iLocationManager, ILocationPreferencesService iLocationPreferencesService, ILocationCapturer iLocationCapturer, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iLocationManager, "_locationManager");
        Intrinsics.checkNotNullParameter(iLocationPreferencesService, "_prefs");
        Intrinsics.checkNotNullParameter(iLocationCapturer, "_capturer");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._locationManager = iLocationManager;
        this._prefs = iLocationPreferencesService;
        this._capturer = iLocationCapturer;
        this._time = iTime;
    }

    public Long getScheduleBackgroundRunIn() {
        if (!this._locationManager.isShared()) {
            Logging.debug$default("LocationController scheduleUpdate not possible, location shared not enabled", (Throwable) null, 2, (Object) null);
            return null;
        } else if (LocationUtils.INSTANCE.hasLocationPermission(this._applicationService.getAppContext())) {
            return Long.valueOf(600000 - (this._time.getCurrentTimeMillis() - this._prefs.getLastLocationTime()));
        } else {
            Logging.debug$default("LocationController scheduleUpdate not possible, location permission not enabled", (Throwable) null, 2, (Object) null);
            return null;
        }
    }

    public Object backgroundRun(Continuation<? super Unit> continuation) {
        this._capturer.captureLastLocation();
        return Unit.INSTANCE;
    }
}
