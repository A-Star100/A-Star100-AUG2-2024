package com.revenuecat.purchases.google.attribution;

import android.app.Application;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GoogleDeviceIdentifiersFetcher$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ GoogleDeviceIdentifiersFetcher f$0;
    public final /* synthetic */ Application f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ GoogleDeviceIdentifiersFetcher$$ExternalSyntheticLambda0(GoogleDeviceIdentifiersFetcher googleDeviceIdentifiersFetcher, Application application, Function1 function1) {
        this.f$0 = googleDeviceIdentifiersFetcher;
        this.f$1 = application;
        this.f$2 = function1;
    }

    public final void run() {
        GoogleDeviceIdentifiersFetcher.getDeviceIdentifiers$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}
