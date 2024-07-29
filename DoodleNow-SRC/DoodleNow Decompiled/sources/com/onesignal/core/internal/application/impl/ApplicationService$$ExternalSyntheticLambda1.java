package com.onesignal.core.internal.application.impl;

import com.onesignal.common.threading.Waiter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ApplicationService$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Waiter f$0;

    public /* synthetic */ ApplicationService$$ExternalSyntheticLambda1(Waiter waiter) {
        this.f$0 = waiter;
    }

    public final void run() {
        ApplicationService.m1027waitUntilActivityReady$lambda0(this.f$0);
    }
}
