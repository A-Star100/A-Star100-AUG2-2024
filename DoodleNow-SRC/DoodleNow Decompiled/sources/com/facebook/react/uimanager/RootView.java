package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.View;

public interface RootView {
    void handleException(Throwable th);

    void onChildEndedNativeGesture(View view, MotionEvent motionEvent);

    @Deprecated
    void onChildStartedNativeGesture(MotionEvent motionEvent);

    void onChildStartedNativeGesture(View view, MotionEvent motionEvent);

    /* renamed from: com.facebook.react.uimanager.RootView$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated
        public static void $default$onChildStartedNativeGesture(RootView _this, MotionEvent motionEvent) {
            _this.onChildStartedNativeGesture((View) null, motionEvent);
        }
    }
}
