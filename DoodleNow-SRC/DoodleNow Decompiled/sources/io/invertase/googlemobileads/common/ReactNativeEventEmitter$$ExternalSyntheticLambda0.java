package io.invertase.googlemobileads.common;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeEventEmitter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ReactNativeEventEmitter f$0;

    public /* synthetic */ ReactNativeEventEmitter$$ExternalSyntheticLambda0(ReactNativeEventEmitter reactNativeEventEmitter) {
        this.f$0 = reactNativeEventEmitter;
    }

    public final void run() {
        this.f$0.sendQueuedEvents();
    }
}
