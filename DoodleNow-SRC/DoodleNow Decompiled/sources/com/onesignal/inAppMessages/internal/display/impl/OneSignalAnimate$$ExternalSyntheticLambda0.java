package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OneSignalAnimate$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ OneSignalAnimate$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        OneSignalAnimate.m1036animateViewColor$lambda0(this.f$0, valueAnimator);
    }
}
