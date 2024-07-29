package com.onesignal.core.internal.application;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/onesignal/core/internal/application/ActivityLifecycleHandlerBase;", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "()V", "onActivityAvailable", "", "activity", "Landroid/app/Activity;", "onActivityStopped", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IActivityLifecycleHandler.kt */
public class ActivityLifecycleHandlerBase implements IActivityLifecycleHandler {
    public void onActivityAvailable(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
