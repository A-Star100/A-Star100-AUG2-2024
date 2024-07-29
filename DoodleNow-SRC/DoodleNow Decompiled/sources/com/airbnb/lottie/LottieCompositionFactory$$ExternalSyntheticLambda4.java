package com.airbnb.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda4 implements LottieListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ AtomicBoolean f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda4(String str, AtomicBoolean atomicBoolean) {
        this.f$0 = str;
        this.f$1 = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$15(this.f$0, this.f$1, (LottieComposition) obj);
    }
}
