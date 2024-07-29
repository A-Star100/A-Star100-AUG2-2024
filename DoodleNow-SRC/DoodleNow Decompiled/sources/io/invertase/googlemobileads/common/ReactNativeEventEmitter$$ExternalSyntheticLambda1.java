package io.invertase.googlemobileads.common;

import io.invertase.googlemobileads.interfaces.NativeEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeEventEmitter$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ReactNativeEventEmitter f$0;
    public final /* synthetic */ NativeEvent f$1;

    public /* synthetic */ ReactNativeEventEmitter$$ExternalSyntheticLambda1(ReactNativeEventEmitter reactNativeEventEmitter, NativeEvent nativeEvent) {
        this.f$0 = reactNativeEventEmitter;
        this.f$1 = nativeEvent;
    }

    public final void run() {
        this.f$0.lambda$sendEvent$2(this.f$1);
    }
}
