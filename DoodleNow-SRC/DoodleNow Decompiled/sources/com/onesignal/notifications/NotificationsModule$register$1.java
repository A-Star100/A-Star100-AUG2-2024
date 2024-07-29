package com.onesignal.notifications;

import com.onesignal.common.services.IServiceProvider;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.FirebaseAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.NoAnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "it", "Lcom/onesignal/common/services/IServiceProvider;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationsModule.kt */
final class NotificationsModule$register$1 extends Lambda implements Function1<IServiceProvider, IAnalyticsTracker> {
    public static final NotificationsModule$register$1 INSTANCE = new NotificationsModule$register$1();

    NotificationsModule$register$1() {
        super(1);
    }

    public final IAnalyticsTracker invoke(IServiceProvider iServiceProvider) {
        Intrinsics.checkNotNullParameter(iServiceProvider, "it");
        if (FirebaseAnalyticsTracker.Companion.canTrack()) {
            return new FirebaseAnalyticsTracker((IApplicationService) iServiceProvider.getService(IApplicationService.class), (ConfigModelStore) iServiceProvider.getService(ConfigModelStore.class), (ITime) iServiceProvider.getService(ITime.class));
        }
        return new NoAnalyticsTracker();
    }
}
