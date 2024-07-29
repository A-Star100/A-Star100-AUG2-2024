package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.onesignal.common.threading.Waiter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/onesignal/inAppMessages/internal/display/impl/InAppMessageView$animateAndDismissLayout$animCallback$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageView.kt */
public final class InAppMessageView$animateAndDismissLayout$animCallback$1 extends AnimatorListenerAdapter {
    final /* synthetic */ Waiter $waiter;
    final /* synthetic */ InAppMessageView this$0;

    InAppMessageView$animateAndDismissLayout$animCallback$1(InAppMessageView inAppMessageView, Waiter waiter) {
        this.this$0 = inAppMessageView;
        this.$waiter = waiter;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.this$0.cleanupViewsAfterDismiss();
        this.$waiter.wake();
    }
}
