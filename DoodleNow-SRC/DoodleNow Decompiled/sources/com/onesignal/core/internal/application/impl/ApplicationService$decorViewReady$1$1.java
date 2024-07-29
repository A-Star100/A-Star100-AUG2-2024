package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.ActivityLifecycleHandlerBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/onesignal/core/internal/application/impl/ApplicationService$decorViewReady$1$1", "Lcom/onesignal/core/internal/application/ActivityLifecycleHandlerBase;", "onActivityAvailable", "", "currentActivity", "Landroid/app/Activity;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationService.kt */
public final class ApplicationService$decorViewReady$1$1 extends ActivityLifecycleHandlerBase {
    final /* synthetic */ Runnable $runnable;
    final /* synthetic */ ApplicationService $self;
    final /* synthetic */ ApplicationService this$0;

    ApplicationService$decorViewReady$1$1(ApplicationService applicationService, Runnable runnable, ApplicationService applicationService2) {
        this.$self = applicationService;
        this.$runnable = runnable;
        this.this$0 = applicationService2;
    }

    public void onActivityAvailable(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "currentActivity");
        this.$self.removeActivityLifecycleHandler(this);
        if (AndroidUtils.INSTANCE.isActivityFullyReady(activity)) {
            this.$runnable.run();
        } else {
            this.this$0.decorViewReady(activity, this.$runnable);
        }
    }
}
