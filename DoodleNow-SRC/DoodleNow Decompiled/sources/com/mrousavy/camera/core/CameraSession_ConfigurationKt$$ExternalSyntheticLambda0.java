package com.mrousavy.camera.core;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CameraSession_ConfigurationKt$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ CameraSession_ConfigurationKt$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onChanged(Object obj) {
        CameraSession_ConfigurationKt.configureCamera$lambda$8(this.f$0, obj);
    }
}
