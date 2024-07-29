package com.onesignal.inAppMessages.internal.display.impl;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"com/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$createDragHelper$1", "Landroidx/customview/widget/ViewDragHelper$Callback;", "lastYPos", "", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "right", "dy", "clampViewPositionVertical", "top", "onViewReleased", "", "releasedChild", "xvel", "", "yvel", "tryCaptureView", "", "pointerId", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DraggableRelativeLayout.kt */
public final class DraggableRelativeLayout$createDragHelper$1 extends ViewDragHelper.Callback {
    private int lastYPos;
    final /* synthetic */ DraggableRelativeLayout this$0;

    public boolean tryCaptureView(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "child");
        return true;
    }

    DraggableRelativeLayout$createDragHelper$1(DraggableRelativeLayout draggableRelativeLayout) {
        this.this$0 = draggableRelativeLayout;
    }

    public int clampViewPositionVertical(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        DraggableRelativeLayout.Params access$getParams$p = this.this$0.params;
        Intrinsics.checkNotNull(access$getParams$p);
        if (access$getParams$p.getDraggingDisabled()) {
            DraggableRelativeLayout.Params access$getParams$p2 = this.this$0.params;
            Intrinsics.checkNotNull(access$getParams$p2);
            return access$getParams$p2.getMaxYPos();
        }
        this.lastYPos = i;
        DraggableRelativeLayout.Params access$getParams$p3 = this.this$0.params;
        Intrinsics.checkNotNull(access$getParams$p3);
        if (access$getParams$p3.getDragDirection() == 1) {
            DraggableRelativeLayout.Params access$getParams$p4 = this.this$0.params;
            Intrinsics.checkNotNull(access$getParams$p4);
            if (i >= access$getParams$p4.getDragThresholdY() && this.this$0.mListener != null) {
                DraggableRelativeLayout.DraggableListener access$getMListener$p = this.this$0.mListener;
                Intrinsics.checkNotNull(access$getMListener$p);
                access$getMListener$p.onDragStart();
            }
            DraggableRelativeLayout.Params access$getParams$p5 = this.this$0.params;
            Intrinsics.checkNotNull(access$getParams$p5);
            if (i < access$getParams$p5.getMaxYPos()) {
                DraggableRelativeLayout.Params access$getParams$p6 = this.this$0.params;
                Intrinsics.checkNotNull(access$getParams$p6);
                return access$getParams$p6.getMaxYPos();
            }
        } else {
            DraggableRelativeLayout.Params access$getParams$p7 = this.this$0.params;
            Intrinsics.checkNotNull(access$getParams$p7);
            if (i <= access$getParams$p7.getDragThresholdY() && this.this$0.mListener != null) {
                DraggableRelativeLayout.DraggableListener access$getMListener$p2 = this.this$0.mListener;
                Intrinsics.checkNotNull(access$getMListener$p2);
                access$getMListener$p2.onDragStart();
            }
            DraggableRelativeLayout.Params access$getParams$p8 = this.this$0.params;
            Intrinsics.checkNotNull(access$getParams$p8);
            if (i > access$getParams$p8.getMaxYPos()) {
                DraggableRelativeLayout.Params access$getParams$p9 = this.this$0.params;
                Intrinsics.checkNotNull(access$getParams$p9);
                return access$getParams$p9.getMaxYPos();
            }
        }
        return i;
    }

    public int clampViewPositionHorizontal(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        DraggableRelativeLayout.Params access$getParams$p = this.this$0.params;
        Intrinsics.checkNotNull(access$getParams$p);
        return access$getParams$p.getMaxXPos();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0095, code lost:
        if (r5 < ((float) r4.getDismissingYVelocity())) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004b, code lost:
        if (r5 > ((float) r4.getDismissingYVelocity())) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewReleased(android.view.View r3, float r4, float r5) {
        /*
            r2 = this;
            java.lang.String r4 = "releasedChild"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r3 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r3 = r3.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = r3.getMaxYPos()
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            boolean r4 = r4.dismissing
            if (r4 != 0) goto L_0x00bd
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r4 = r4.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.getDragDirection()
            r0 = 1
            if (r4 != r0) goto L_0x0074
            int r4 = r2.lastYPos
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r1 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r1 = r1.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getDismissingYPos()
            if (r4 > r1) goto L_0x004d
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r4 = r4.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.getDismissingYVelocity()
            float r4 = (float) r4
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00bd
        L_0x004d:
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r3 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r3 = r3.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = r3.getOffScreenYPos()
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            r4.dismissing = r0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$DraggableListener r4 = r4.mListener
            if (r4 == 0) goto L_0x00bd
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$DraggableListener r4 = r4.mListener
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r4.onDismiss()
            goto L_0x00bd
        L_0x0074:
            int r4 = r2.lastYPos
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r1 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r1 = r1.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getDismissingYPos()
            if (r4 < r1) goto L_0x0097
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r4 = r4.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.getDismissingYVelocity()
            float r4 = (float) r4
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x00bd
        L_0x0097:
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r3 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r3 = r3.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = r3.getOffScreenYPos()
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            r4.dismissing = r0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$DraggableListener r4 = r4.mListener
            if (r4 == 0) goto L_0x00bd
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$DraggableListener r4 = r4.mListener
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r4.onDismiss()
        L_0x00bd:
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r4 = r2.this$0
            androidx.customview.widget.ViewDragHelper r4 = r4.mDragHelper
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r5 = r2.this$0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$Params r5 = r5.params
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getMaxXPos()
            boolean r3 = r4.settleCapturedViewAt(r5, r3)
            if (r3 == 0) goto L_0x00e0
            com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout r3 = r2.this$0
            android.view.View r3 = (android.view.View) r3
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r3)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout$createDragHelper$1.onViewReleased(android.view.View, float, float):void");
    }
}
