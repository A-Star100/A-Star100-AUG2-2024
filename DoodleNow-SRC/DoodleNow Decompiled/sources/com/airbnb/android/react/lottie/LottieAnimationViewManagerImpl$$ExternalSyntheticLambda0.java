package com.airbnb.android.react.lottie;

import com.airbnb.lottie.LottieAnimationView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieAnimationViewManagerImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ LottieAnimationView f$2;

    public /* synthetic */ LottieAnimationViewManagerImpl$$ExternalSyntheticLambda0(int i, int i2, LottieAnimationView lottieAnimationView) {
        this.f$0 = i;
        this.f$1 = i2;
        this.f$2 = lottieAnimationView;
    }

    public final void run() {
        LottieAnimationViewManagerImpl.play$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}
