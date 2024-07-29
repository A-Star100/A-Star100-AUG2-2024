package com.onesignal.inAppMessages.internal.display.impl;

import android.view.animation.Interpolator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/OneSignalBounceInterpolator;", "Landroid/view/animation/Interpolator;", "amplitude", "", "frequency", "(DD)V", "mAmplitude", "mFrequency", "getInterpolation", "", "time", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneSignalBounceInterpolator.kt */
public final class OneSignalBounceInterpolator implements Interpolator {
    private double mAmplitude;
    private double mFrequency;

    public OneSignalBounceInterpolator(double d, double d2) {
        this.mAmplitude = d;
        this.mFrequency = d2;
    }

    public float getInterpolation(float f) {
        return (float) ((((double) -1) * Math.pow(2.718281828459045d, ((double) (-f)) / this.mAmplitude) * Math.cos(this.mFrequency * ((double) f))) + ((double) 1));
    }
}
