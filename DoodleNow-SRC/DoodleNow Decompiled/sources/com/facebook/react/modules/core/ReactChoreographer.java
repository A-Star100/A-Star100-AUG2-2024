package com.facebook.react.modules.core;

import android.view.Choreographer;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.internal.ChoreographerProvider;
import java.util.ArrayDeque;

public final class ReactChoreographer {
    private static ReactChoreographer sInstance;
    /* access modifiers changed from: private */
    public final ArrayDeque<Choreographer.FrameCallback>[] mCallbackQueues;
    private ChoreographerProvider.Choreographer mChoreographer;
    private final Choreographer.FrameCallback mFrameCallback = new Choreographer.FrameCallback() {
        public void doFrame(long j) {
            synchronized (ReactChoreographer.this.mCallbackQueues) {
                ReactChoreographer.this.mHasPostedCallback = false;
                for (ArrayDeque arrayDeque : ReactChoreographer.this.mCallbackQueues) {
                    int size = arrayDeque.size();
                    for (int i = 0; i < size; i++) {
                        Choreographer.FrameCallback frameCallback = (Choreographer.FrameCallback) arrayDeque.pollFirst();
                        if (frameCallback != null) {
                            frameCallback.doFrame(j);
                            ReactChoreographer reactChoreographer = ReactChoreographer.this;
                            reactChoreographer.mTotalCallbacks = reactChoreographer.mTotalCallbacks - 1;
                        } else {
                            FLog.e(ReactConstants.TAG, "Tried to execute non-existent frame callback");
                        }
                    }
                }
                ReactChoreographer.this.maybeRemoveFrameCallback();
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mHasPostedCallback;
    /* access modifiers changed from: private */
    public int mTotalCallbacks;

    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        
        private final int mOrder;

        /* access modifiers changed from: package-private */
        public int getOrder() {
            return this.mOrder;
        }

        private CallbackType(int i) {
            this.mOrder = i;
        }
    }

    public static void initialize(ChoreographerProvider choreographerProvider) {
        if (sInstance == null) {
            sInstance = new ReactChoreographer(choreographerProvider);
        }
    }

    public static ReactChoreographer getInstance() {
        Assertions.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
        return sInstance;
    }

    private ReactChoreographer(ChoreographerProvider choreographerProvider) {
        int i = 0;
        this.mTotalCallbacks = 0;
        this.mHasPostedCallback = false;
        this.mCallbackQueues = new ArrayDeque[CallbackType.values().length];
        while (true) {
            ArrayDeque<Choreographer.FrameCallback>[] arrayDequeArr = this.mCallbackQueues;
            if (i < arrayDequeArr.length) {
                arrayDequeArr[i] = new ArrayDeque<>();
                i++;
            } else {
                UiThreadUtil.runOnUiThread(new ReactChoreographer$$ExternalSyntheticLambda0(this, choreographerProvider));
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ChoreographerProvider choreographerProvider) {
        this.mChoreographer = choreographerProvider.getChoreographer();
    }

    public void postFrameCallback(CallbackType callbackType, Choreographer.FrameCallback frameCallback) {
        synchronized (this.mCallbackQueues) {
            this.mCallbackQueues[callbackType.getOrder()].addLast(frameCallback);
            boolean z = true;
            int i = this.mTotalCallbacks + 1;
            this.mTotalCallbacks = i;
            if (i <= 0) {
                z = false;
            }
            Assertions.assertCondition(z);
            if (!this.mHasPostedCallback) {
                if (this.mChoreographer == null) {
                    UiThreadUtil.runOnUiThread(new ReactChoreographer$$ExternalSyntheticLambda1(this));
                } else {
                    postFrameCallbackOnChoreographer();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postFrameCallback$1() {
        synchronized (this.mCallbackQueues) {
            postFrameCallbackOnChoreographer();
        }
    }

    private void postFrameCallbackOnChoreographer() {
        this.mChoreographer.postFrameCallback(this.mFrameCallback);
        this.mHasPostedCallback = true;
    }

    public void removeFrameCallback(CallbackType callbackType, Choreographer.FrameCallback frameCallback) {
        synchronized (this.mCallbackQueues) {
            if (this.mCallbackQueues[callbackType.getOrder()].removeFirstOccurrence(frameCallback)) {
                this.mTotalCallbacks--;
                maybeRemoveFrameCallback();
            } else {
                FLog.e(ReactConstants.TAG, "Tried to remove non-existent frame callback");
            }
        }
    }

    /* access modifiers changed from: private */
    public void maybeRemoveFrameCallback() {
        Assertions.assertCondition(this.mTotalCallbacks >= 0);
        if (this.mTotalCallbacks == 0 && this.mHasPostedCallback) {
            ChoreographerProvider.Choreographer choreographer = this.mChoreographer;
            if (choreographer != null) {
                choreographer.removeFrameCallback(this.mFrameCallback);
            }
            this.mHasPostedCallback = false;
        }
    }
}
