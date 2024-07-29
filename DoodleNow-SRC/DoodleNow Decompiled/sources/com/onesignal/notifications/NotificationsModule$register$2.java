package com.onesignal.notifications;

import com.onesignal.common.services.IServiceProvider;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorADM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorNone;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/common/services/IServiceProvider;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationsModule.kt */
final class NotificationsModule$register$2 extends Lambda implements Function1<IServiceProvider, Object> {
    public static final NotificationsModule$register$2 INSTANCE = new NotificationsModule$register$2();

    NotificationsModule$register$2() {
        super(1);
    }

    public final Object invoke(IServiceProvider iServiceProvider) {
        Object obj;
        Intrinsics.checkNotNullParameter(iServiceProvider, "it");
        IDeviceService iDeviceService = (IDeviceService) iServiceProvider.getService(IDeviceService.class);
        if (iDeviceService.isFireOSDeviceType()) {
            return new PushRegistratorADM((IApplicationService) iServiceProvider.getService(IApplicationService.class));
        }
        if (!iDeviceService.isAndroidDeviceType()) {
            obj = new PushRegistratorHMS(iDeviceService, (IApplicationService) iServiceProvider.getService(IApplicationService.class));
        } else if (!iDeviceService.getHasFCMLibrary()) {
            return new PushRegistratorNone();
        } else {
            obj = new PushRegistratorFCM((ConfigModelStore) iServiceProvider.getService(ConfigModelStore.class), (IApplicationService) iServiceProvider.getService(IApplicationService.class), (GooglePlayServicesUpgradePrompt) iServiceProvider.getService(GooglePlayServicesUpgradePrompt.class), iDeviceService);
        }
        return obj;
    }
}
