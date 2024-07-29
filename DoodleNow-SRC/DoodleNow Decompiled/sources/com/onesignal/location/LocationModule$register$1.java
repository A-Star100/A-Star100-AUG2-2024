package com.onesignal.location;

import com.onesignal.common.services.IServiceProvider;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.impl.GmsLocationController;
import com.onesignal.location.internal.controller.impl.HmsLocationController;
import com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper;
import com.onesignal.location.internal.controller.impl.NullLocationController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/onesignal/location/internal/controller/ILocationController;", "it", "Lcom/onesignal/common/services/IServiceProvider;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationModule.kt */
final class LocationModule$register$1 extends Lambda implements Function1<IServiceProvider, ILocationController> {
    public static final LocationModule$register$1 INSTANCE = new LocationModule$register$1();

    LocationModule$register$1() {
        super(1);
    }

    public final ILocationController invoke(IServiceProvider iServiceProvider) {
        Intrinsics.checkNotNullParameter(iServiceProvider, "it");
        IDeviceService iDeviceService = (IDeviceService) iServiceProvider.getService(IDeviceService.class);
        if (iDeviceService.isAndroidDeviceType() && LocationUtils.INSTANCE.hasGMSLocationLibrary()) {
            return new GmsLocationController((IApplicationService) iServiceProvider.getService(IApplicationService.class), (IFusedLocationApiWrapper) iServiceProvider.getService(IFusedLocationApiWrapper.class));
        }
        if (!iDeviceService.isHuaweiDeviceType() || !LocationUtils.INSTANCE.hasHMSLocationLibrary()) {
            return new NullLocationController();
        }
        return new HmsLocationController((IApplicationService) iServiceProvider.getService(IApplicationService.class));
    }
}
