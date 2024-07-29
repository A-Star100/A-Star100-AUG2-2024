package com.onesignal.session.internal.session.impl;

import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SessionService.kt */
final class SessionService$onFocus$2 extends Lambda implements Function1<ISessionLifecycleHandler, Unit> {
    public static final SessionService$onFocus$2 INSTANCE = new SessionService$onFocus$2();

    SessionService$onFocus$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ISessionLifecycleHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ISessionLifecycleHandler iSessionLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iSessionLifecycleHandler, "it");
        iSessionLifecycleHandler.onSessionActive();
    }
}
