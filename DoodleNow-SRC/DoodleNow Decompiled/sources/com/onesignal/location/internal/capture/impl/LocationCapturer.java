package com.onesignal.location.internal.capture.impl;

import android.location.Location;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationPoint;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/onesignal/location/internal/capture/impl/LocationCapturer;", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "Lcom/onesignal/location/internal/capture/ILocationCapturer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_prefs", "Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_controller", "Lcom/onesignal/location/internal/controller/ILocationController;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/location/internal/controller/ILocationController;)V", "locationCoarse", "", "getLocationCoarse", "()Z", "setLocationCoarse", "(Z)V", "capture", "", "location", "Landroid/location/Location;", "captureLastLocation", "onLocationChanged", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationCapturer.kt */
public final class LocationCapturer implements ILocationUpdatedHandler, ILocationCapturer {
    private final IApplicationService _applicationService;
    private final ILocationController _controller;
    private final ILocationPreferencesService _prefs;
    private final PropertiesModelStore _propertiesModelStore;
    private final ITime _time;
    private boolean locationCoarse;

    public boolean getLocationCoarse() {
        return this.locationCoarse;
    }

    public void setLocationCoarse(boolean z) {
        this.locationCoarse = z;
    }

    public LocationCapturer(IApplicationService iApplicationService, ITime iTime, ILocationPreferencesService iLocationPreferencesService, PropertiesModelStore propertiesModelStore, ILocationController iLocationController) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(iLocationPreferencesService, "_prefs");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(iLocationController, "_controller");
        this._applicationService = iApplicationService;
        this._time = iTime;
        this._prefs = iLocationPreferencesService;
        this._propertiesModelStore = propertiesModelStore;
        this._controller = iLocationController;
        iLocationController.subscribe(this);
    }

    public void captureLastLocation() {
        Location lastLocation = this._controller.getLastLocation();
        if (lastLocation != null) {
            capture(lastLocation);
        } else {
            this._prefs.setLastLocationTime(this._time.getCurrentTimeMillis());
        }
    }

    public void onLocationChanged(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Logging.debug$default("LocationController fireCompleteForLocation with location: " + location, (Throwable) null, 2, (Object) null);
        capture(location);
    }

    private final void capture(Location location) {
        LocationPoint locationPoint = new LocationPoint();
        locationPoint.setAccuracy(Float.valueOf(location.getAccuracy()));
        locationPoint.setBg(Boolean.valueOf(!this._applicationService.isInForeground()));
        locationPoint.setType(getLocationCoarse() ? 0 : 1);
        locationPoint.setTimeStamp(Long.valueOf(location.getTime()));
        if (getLocationCoarse()) {
            locationPoint.setLat(Double.valueOf(new BigDecimal(location.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue()));
            locationPoint.setLog(Double.valueOf(new BigDecimal(location.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue()));
        } else {
            locationPoint.setLat(Double.valueOf(location.getLatitude()));
            locationPoint.setLog(Double.valueOf(location.getLongitude()));
        }
        PropertiesModel propertiesModel = (PropertiesModel) this._propertiesModelStore.getModel();
        propertiesModel.setLocationLongitude(locationPoint.getLog());
        propertiesModel.setLocationLatitude(locationPoint.getLat());
        propertiesModel.setLocationAccuracy(locationPoint.getAccuracy());
        propertiesModel.setLocationBackground(locationPoint.getBg());
        propertiesModel.setLocationType(locationPoint.getType());
        propertiesModel.setLocationTimestamp(locationPoint.getTimeStamp());
        this._prefs.setLastLocationTime(this._time.getCurrentTimeMillis());
    }
}
