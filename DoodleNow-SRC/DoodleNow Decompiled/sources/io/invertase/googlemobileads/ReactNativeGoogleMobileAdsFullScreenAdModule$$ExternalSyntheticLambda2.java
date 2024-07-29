package io.invertase.googlemobileads;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ ReadableMap f$2;
    public final /* synthetic */ Activity f$3;
    public final /* synthetic */ Promise f$4;
    public final /* synthetic */ String f$5;

    public /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda2(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, ReadableMap readableMap, Activity activity, Promise promise, String str) {
        this.f$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
        this.f$1 = i;
        this.f$2 = readableMap;
        this.f$3 = activity;
        this.f$4 = promise;
        this.f$5 = str;
    }

    public final void run() {
        ReactNativeGoogleMobileAdsFullScreenAdModule.show$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
