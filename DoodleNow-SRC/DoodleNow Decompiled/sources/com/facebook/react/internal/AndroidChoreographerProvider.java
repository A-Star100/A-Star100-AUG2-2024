package com.facebook.react.internal;

import android.view.Choreographer;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.ChoreographerProvider;

public final class AndroidChoreographerProvider implements ChoreographerProvider {

    public static final class AndroidChoreographer implements ChoreographerProvider.Choreographer {
        private final Choreographer sInstance = Choreographer.getInstance();

        public void postFrameCallback(Choreographer.FrameCallback frameCallback) {
            this.sInstance.postFrameCallback(frameCallback);
        }

        public void removeFrameCallback(Choreographer.FrameCallback frameCallback) {
            this.sInstance.removeFrameCallback(frameCallback);
        }
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final AndroidChoreographerProvider INSTANCE = new AndroidChoreographerProvider();

        private Holder() {
        }
    }

    public static AndroidChoreographerProvider getInstance() {
        return Holder.INSTANCE;
    }

    public ChoreographerProvider.Choreographer getChoreographer() {
        UiThreadUtil.assertOnUiThread();
        return new AndroidChoreographer();
    }
}
