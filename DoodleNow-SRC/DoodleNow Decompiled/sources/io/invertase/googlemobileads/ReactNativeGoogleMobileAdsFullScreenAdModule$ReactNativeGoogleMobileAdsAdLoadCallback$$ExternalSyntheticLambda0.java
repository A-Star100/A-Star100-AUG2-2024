package io.invertase.googlemobileads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda0 implements OnPaidEventListener {
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule f$0;
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback f$1;

    public /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda0(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback) {
        this.f$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
        this.f$1 = reactNativeGoogleMobileAdsAdLoadCallback;
    }

    public final void onPaidEvent(AdValue adValue) {
        ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback.onAdLoaded$lambda$0(this.f$0, this.f$1, adValue);
    }
}
