package com.airbnb.lottie;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda14 implements Runnable {
    public final /* synthetic */ JsonReader f$0;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda14(JsonReader jsonReader) {
        this.f$0 = jsonReader;
    }

    public final void run() {
        Utils.closeQuietly(this.f$0);
    }
}
