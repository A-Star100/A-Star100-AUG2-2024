package com.facebook.react.uimanager;

import android.view.Choreographer;
import com.facebook.react.bridge.ReactContext;

public abstract class GuardedFrameCallback implements Choreographer.FrameCallback {
    private final ReactContext mReactContext;

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j);

    protected GuardedFrameCallback(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    public final void doFrame(long j) {
        try {
            doFrameGuarded(j);
        } catch (RuntimeException e) {
            this.mReactContext.handleException(e);
        }
    }
}
