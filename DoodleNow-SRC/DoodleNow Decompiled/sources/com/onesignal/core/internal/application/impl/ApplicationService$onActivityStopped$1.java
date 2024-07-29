package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationService.kt */
final class ApplicationService$onActivityStopped$1 extends Lambda implements Function1<IActivityLifecycleHandler, Unit> {
    final /* synthetic */ Activity $activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ApplicationService$onActivityStopped$1(Activity activity) {
        super(1);
        this.$activity = activity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IActivityLifecycleHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IActivityLifecycleHandler iActivityLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iActivityLifecycleHandler, "it");
        iActivityLifecycleHandler.onActivityStopped(this.$activity);
    }
}
