package com.onesignal.location;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.location.internal.LocationManager;
import com.onesignal.location.internal.background.LocationBackgroundService;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.capture.impl.LocationCapturer;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.impl.FusedLocationApiWrapperImpl;
import com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper;
import com.onesignal.location.internal.permissions.LocationPermissionController;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.location.internal.preferences.impl.LocationPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/location/LocationModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationModule.kt */
public final class LocationModule implements IModule {
    public void register(ServiceBuilder serviceBuilder) {
        Intrinsics.checkNotNullParameter(serviceBuilder, "builder");
        serviceBuilder.register(LocationPermissionController.class).provides(LocationPermissionController.class).provides(IStartableService.class);
        serviceBuilder.register(FusedLocationApiWrapperImpl.class).provides(IFusedLocationApiWrapper.class);
        serviceBuilder.register(LocationModule$register$1.INSTANCE).provides(ILocationController.class);
        serviceBuilder.register(LocationPreferencesService.class).provides(ILocationPreferencesService.class);
        serviceBuilder.register(LocationCapturer.class).provides(ILocationCapturer.class);
        serviceBuilder.register(LocationBackgroundService.class).provides(IBackgroundService.class);
        serviceBuilder.register(LocationManager.class).provides(ILocationManager.class).provides(IStartableService.class);
    }
}
