package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/touch/JSResponderHandler;", "Lcom/facebook/react/touch/OnInterceptTouchEventListener;", "()V", "currentJSResponder", "", "viewParentBlockingNativeResponder", "Landroid/view/ViewParent;", "clearJSResponder", "", "maybeUnblockNativeResponder", "onInterceptTouchEvent", "", "view", "Landroid/view/ViewGroup;", "event", "Landroid/view/MotionEvent;", "setJSResponder", "tag", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: JSResponderHandler.kt */
public final class JSResponderHandler implements OnInterceptTouchEventListener {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int JS_RESPONDER_UNSET = -1;
    private volatile int currentJSResponder = -1;
    private ViewParent viewParentBlockingNativeResponder;

    public final void setJSResponder(int i, ViewParent viewParent) {
        this.currentJSResponder = i;
        maybeUnblockNativeResponder();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.viewParentBlockingNativeResponder = viewParent;
        }
    }

    public final void clearJSResponder() {
        this.currentJSResponder = -1;
        maybeUnblockNativeResponder();
    }

    private final void maybeUnblockNativeResponder() {
        ViewParent viewParent = this.viewParentBlockingNativeResponder;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
        }
        this.viewParentBlockingNativeResponder = null;
    }

    public boolean onInterceptTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int i = this.currentJSResponder;
        if (i == -1 || motionEvent.getAction() == 1 || viewGroup.getId() != i) {
            return false;
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/react/touch/JSResponderHandler$Companion;", "", "()V", "JS_RESPONDER_UNSET", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: JSResponderHandler.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
