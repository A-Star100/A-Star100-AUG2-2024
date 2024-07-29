package com.facebook.react.fabric;

import android.view.Choreographer;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;

public abstract class GuardedFrameCallback implements Choreographer.FrameCallback {
    private final JSExceptionHandler mExceptionHandler;

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j);

    protected GuardedFrameCallback(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected GuardedFrameCallback(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }

    public final void doFrame(long j) {
        try {
            doFrameGuarded(j);
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
        }
    }
}
