package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ InputStream f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda0(InputStream inputStream, String str, boolean z) {
        this.f$0 = inputStream;
        this.f$1 = str;
        this.f$2 = z;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonInputStreamSync(this.f$0, this.f$1, this.f$2);
    }
}
