package com.onesignal.core.internal.application.impl;

import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationService.kt */
final class ApplicationService$handleLostFocus$1 extends Lambda implements Function1<IApplicationLifecycleHandler, Unit> {
    public static final ApplicationService$handleLostFocus$1 INSTANCE = new ApplicationService$handleLostFocus$1();

    ApplicationService$handleLostFocus$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IApplicationLifecycleHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IApplicationLifecycleHandler iApplicationLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iApplicationLifecycleHandler, "it");
        iApplicationLifecycleHandler.onUnfocused();
    }
}
