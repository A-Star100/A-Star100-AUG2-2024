package com.onesignal.inAppMessages.internal.display.impl;

import android.os.Build;
import android.view.animation.Animation;
import androidx.cardview.widget.CardView;
import com.onesignal.common.ViewUtils;
import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/onesignal/inAppMessages/internal/display/impl/InAppMessageView$createAnimationListener$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageView.kt */
public final class InAppMessageView$createAnimationListener$1 implements Animation.AnimationListener {
    final /* synthetic */ CardView $messageViewCardView;
    final /* synthetic */ InAppMessageView this$0;

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    InAppMessageView$createAnimationListener$1(CardView cardView, InAppMessageView inAppMessageView) {
        this.$messageViewCardView = cardView;
        this.this$0 = inAppMessageView;
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (Build.VERSION.SDK_INT == 23) {
            this.$messageViewCardView.setCardElevation((float) ViewUtils.INSTANCE.dpToPx(5));
        }
        if (this.this$0.messageController != null) {
            InAppMessageView.InAppMessageViewListener access$getMessageController$p = this.this$0.messageController;
            Intrinsics.checkNotNull(access$getMessageController$p);
            access$getMessageController$p.onMessageWasDisplayed();
        }
    }
}
