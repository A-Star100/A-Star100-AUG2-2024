package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.onesignal.common.AndroidUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/onesignal/core/internal/application/impl/ApplicationService$start$configuration$1", "Landroid/content/ComponentCallbacks;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationService.kt */
public final class ApplicationService$start$configuration$1 implements ComponentCallbacks {
    final /* synthetic */ ApplicationService this$0;

    public void onLowMemory() {
    }

    ApplicationService$start$configuration$1(ApplicationService applicationService) {
        this.this$0 = applicationService;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        if (this.this$0.getCurrent() != null) {
            AndroidUtils androidUtils = AndroidUtils.INSTANCE;
            Activity current = this.this$0.getCurrent();
            Intrinsics.checkNotNull(current);
            if (androidUtils.hasConfigChangeFlag(current, 128)) {
                ApplicationService applicationService = this.this$0;
                int i = configuration.orientation;
                Activity current2 = this.this$0.getCurrent();
                Intrinsics.checkNotNull(current2);
                applicationService.onOrientationChanged(i, current2);
            }
        }
    }
}
