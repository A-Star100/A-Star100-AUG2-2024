package com.airbnb.lottie;

import com.airbnb.lottie.utils.Utils;
import java.io.InputStream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ InputStream f$0;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda3(InputStream inputStream) {
        this.f$0 = inputStream;
    }

    public final void run() {
        Utils.closeQuietly(this.f$0);
    }
}
