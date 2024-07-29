package com.airbnb.android.react.lottie;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/airbnb/android/react/lottie/LottieAnimationViewManagerImpl$play$1$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LottieAnimationViewManagerImpl.kt */
public final class LottieAnimationViewManagerImpl$play$1$1 implements View.OnAttachStateChangeListener {
    LottieAnimationViewManagerImpl$play$1$1() {
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
        lottieAnimationView.setProgress(0.0f);
        lottieAnimationView.playAnimation();
        lottieAnimationView.removeOnAttachStateChangeListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        ((LottieAnimationView) view).removeOnAttachStateChangeListener(this);
    }
}
