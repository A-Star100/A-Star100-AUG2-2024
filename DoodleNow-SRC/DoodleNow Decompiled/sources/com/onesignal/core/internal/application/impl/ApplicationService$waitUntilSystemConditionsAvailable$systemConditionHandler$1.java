package com.onesignal.core.internal.application.impl;

import com.onesignal.common.DeviceUtils;
import com.onesignal.common.threading.Waiter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/onesignal/core/internal/application/impl/ApplicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$1", "Lcom/onesignal/core/internal/application/impl/ISystemConditionHandler;", "systemConditionChanged", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationService.kt */
public final class ApplicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$1 implements ISystemConditionHandler {
    final /* synthetic */ Waiter $waiter;
    final /* synthetic */ ApplicationService this$0;

    ApplicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$1(ApplicationService applicationService, Waiter waiter) {
        this.this$0 = applicationService;
        this.$waiter = waiter;
    }

    public void systemConditionChanged() {
        if (!DeviceUtils.INSTANCE.isKeyboardUp(new WeakReference(this.this$0.getCurrent()))) {
            this.$waiter.wake();
        }
    }
}
