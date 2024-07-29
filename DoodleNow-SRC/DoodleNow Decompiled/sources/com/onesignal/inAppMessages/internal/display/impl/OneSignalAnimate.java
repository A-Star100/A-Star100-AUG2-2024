package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0014J*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0016"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/OneSignalAnimate;", "", "()V", "animateViewByTranslation", "Landroid/view/animation/Animation;", "view", "Landroid/view/View;", "deltaFromY", "", "deltaToY", "duration", "", "interpolator", "Landroid/view/animation/Interpolator;", "animCallback", "Landroid/view/animation/Animation$AnimationListener;", "animateViewColor", "Landroid/animation/ValueAnimator;", "colorStart", "colorEnd", "Landroid/animation/Animator$AnimatorListener;", "animateViewSmallToLarge", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneSignalAnimate.kt */
public final class OneSignalAnimate {
    public static final OneSignalAnimate INSTANCE = new OneSignalAnimate();

    private OneSignalAnimate() {
    }

    public final Animation animateViewByTranslation(View view, float f, float f2, int i, Interpolator interpolator, Animation.AnimationListener animationListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setDuration((long) i);
        translateAnimation.setInterpolator(interpolator);
        if (animationListener != null) {
            translateAnimation.setAnimationListener(animationListener);
        }
        view.setAnimation(translateAnimation);
        return translateAnimation;
    }

    public final ValueAnimator animateViewColor(View view, int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) i);
        valueAnimator.setIntValues(new int[]{i2, i3});
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.addUpdateListener(new OneSignalAnimate$$ExternalSyntheticLambda0(view));
        if (animatorListener != null) {
            valueAnimator.addListener(animatorListener);
        }
        return valueAnimator;
    }

    /* access modifiers changed from: private */
    /* renamed from: animateViewColor$lambda-0  reason: not valid java name */
    public static final void m1036animateViewColor$lambda0(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        view.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    public final Animation animateViewSmallToLarge(View view, int i, Interpolator interpolator, Animation.AnimationListener animationListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration((long) i);
        scaleAnimation.setInterpolator(interpolator);
        if (animationListener != null) {
            scaleAnimation.setAnimationListener(animationListener);
        }
        view.setAnimation(scaleAnimation);
        return scaleAnimation;
    }
}
