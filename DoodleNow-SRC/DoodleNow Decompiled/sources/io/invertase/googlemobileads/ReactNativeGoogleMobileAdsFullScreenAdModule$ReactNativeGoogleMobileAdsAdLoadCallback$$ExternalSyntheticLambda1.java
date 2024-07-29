package io.invertase.googlemobileads;

import com.google.android.gms.ads.admanager.AppEventListener;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda1 implements AppEventListener {
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule f$0;
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback f$1;

    public /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda1(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback) {
        this.f$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
        this.f$1 = reactNativeGoogleMobileAdsAdLoadCallback;
    }

    public final void onAppEvent(String str, String str2) {
        ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback.onAdLoaded$lambda$4(this.f$0, this.f$1, str, str2);
    }
}
