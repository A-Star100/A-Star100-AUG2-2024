package com.onesignal.inAppMessages.internal.display.impl;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.onesignal.common.ViewUtils;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissing", "", "draggingDisabled", "mDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "mListener", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$DraggableListener;", "params", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;", "computeScroll", "", "createDragHelper", "dismiss", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "setListener", "listener", "setParams", "Companion", "DraggableListener", "Params", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DraggableRelativeLayout.kt */
public final class DraggableRelativeLayout extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int EXTRA_PX_DISMISS = ViewUtils.INSTANCE.dpToPx(64);
    private static final int MARGIN_PX_SIZE = ViewUtils.INSTANCE.dpToPx(28);
    /* access modifiers changed from: private */
    public boolean dismissing;
    private final boolean draggingDisabled;
    /* access modifiers changed from: private */
    public ViewDragHelper mDragHelper;
    /* access modifiers changed from: private */
    public DraggableListener mListener;
    /* access modifiers changed from: private */
    public Params params;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$DraggableListener;", "", "onDismiss", "", "onDragEnd", "onDragStart", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DraggableRelativeLayout.kt */
    public interface DraggableListener {
        void onDismiss();

        void onDragEnd();

        void onDragStart();
    }

    public final void setListener(DraggableListener draggableListener) {
        this.mListener = draggableListener;
    }

    public DraggableRelativeLayout(Context context) {
        super(context);
        setClipChildren(false);
        createDragHelper();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006+"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;", "", "()V", "dismissingYPos", "", "getDismissingYPos", "()I", "setDismissingYPos", "(I)V", "dismissingYVelocity", "getDismissingYVelocity", "setDismissingYVelocity", "dragDirection", "getDragDirection", "setDragDirection", "dragThresholdY", "getDragThresholdY", "setDragThresholdY", "draggingDisabled", "", "getDraggingDisabled", "()Z", "setDraggingDisabled", "(Z)V", "height", "getHeight", "setHeight", "maxXPos", "getMaxXPos", "setMaxXPos", "maxYPos", "getMaxYPos", "setMaxYPos", "messageHeight", "getMessageHeight", "setMessageHeight", "offScreenYPos", "getOffScreenYPos", "setOffScreenYPos", "posY", "getPosY", "setPosY", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DraggableRelativeLayout.kt */
    public static final class Params {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int DRAGGABLE_DIRECTION_DOWN = 1;
        public static final int DRAGGABLE_DIRECTION_UP = 0;
        private int dismissingYPos;
        private int dismissingYVelocity;
        private int dragDirection;
        private int dragThresholdY;
        private boolean draggingDisabled;
        private int height;
        private int maxXPos;
        private int maxYPos;
        private int messageHeight;
        private int offScreenYPos;
        private int posY;

        public final int getDismissingYPos() {
            return this.dismissingYPos;
        }

        public final int getDismissingYVelocity() {
            return this.dismissingYVelocity;
        }

        public final int getDragDirection() {
            return this.dragDirection;
        }

        public final int getDragThresholdY() {
            return this.dragThresholdY;
        }

        public final boolean getDraggingDisabled() {
            return this.draggingDisabled;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getMaxXPos() {
            return this.maxXPos;
        }

        public final int getMaxYPos() {
            return this.maxYPos;
        }

        public final int getMessageHeight() {
            return this.messageHeight;
        }

        public final int getOffScreenYPos() {
            return this.offScreenYPos;
        }

        public final int getPosY() {
            return this.posY;
        }

        public final void setDismissingYPos(int i) {
            this.dismissingYPos = i;
        }

        public final void setDismissingYVelocity(int i) {
            this.dismissingYVelocity = i;
        }

        public final void setDragDirection(int i) {
            this.dragDirection = i;
        }

        public final void setDragThresholdY(int i) {
            this.dragThresholdY = i;
        }

        public final void setDraggingDisabled(boolean z) {
            this.draggingDisabled = z;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setMaxXPos(int i) {
            this.maxXPos = i;
        }

        public final void setMaxYPos(int i) {
            this.maxYPos = i;
        }

        public final void setMessageHeight(int i) {
            this.messageHeight = i;
        }

        public final void setOffScreenYPos(int i) {
            this.offScreenYPos = i;
        }

        public final void setPosY(int i) {
            this.posY = i;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params$Companion;", "", "()V", "DRAGGABLE_DIRECTION_DOWN", "", "DRAGGABLE_DIRECTION_UP", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: DraggableRelativeLayout.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public final void setParams(Params params2) {
        Intrinsics.checkNotNullParameter(params2, OutcomeEventsTable.COLUMN_NAME_PARAMS);
        this.params = params2;
        params2.setOffScreenYPos(params2.getMessageHeight() + params2.getPosY() + ((Resources.getSystem().getDisplayMetrics().heightPixels - params2.getMessageHeight()) - params2.getPosY()) + EXTRA_PX_DISMISS);
        params2.setDismissingYVelocity(ViewUtils.INSTANCE.dpToPx(3000));
        if (params2.getDragDirection() == 0) {
            params2.setOffScreenYPos((-params2.getMessageHeight()) - MARGIN_PX_SIZE);
            params2.setDismissingYVelocity(-params2.getDismissingYVelocity());
            params2.setDismissingYPos(params2.getOffScreenYPos() / 3);
            return;
        }
        params2.setDismissingYPos((params2.getMessageHeight() / 3) + (params2.getMaxYPos() * 2));
    }

    private final void createDragHelper() {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new DraggableRelativeLayout$createDragHelper$1(this));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        DraggableListener draggableListener;
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.dismissing) {
            return true;
        }
        int action = motionEvent.getAction();
        if ((action == 0 || action == 5) && (draggableListener = this.mListener) != null) {
            Intrinsics.checkNotNull(draggableListener);
            draggableListener.onDragEnd();
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        Intrinsics.checkNotNull(viewDragHelper);
        viewDragHelper.processTouchEvent(motionEvent);
        return false;
    }

    public void computeScroll() {
        super.computeScroll();
        ViewDragHelper viewDragHelper = this.mDragHelper;
        Intrinsics.checkNotNull(viewDragHelper);
        if (viewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void dismiss() {
        this.dismissing = true;
        ViewDragHelper viewDragHelper = this.mDragHelper;
        Intrinsics.checkNotNull(viewDragHelper);
        View view = this;
        int left = getLeft();
        Params params2 = this.params;
        Intrinsics.checkNotNull(params2);
        viewDragHelper.smoothSlideViewTo(view, left, params2.getOffScreenYPos());
        ViewCompat.postInvalidateOnAnimation(view);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Companion;", "", "()V", "EXTRA_PX_DISMISS", "", "MARGIN_PX_SIZE", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DraggableRelativeLayout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
