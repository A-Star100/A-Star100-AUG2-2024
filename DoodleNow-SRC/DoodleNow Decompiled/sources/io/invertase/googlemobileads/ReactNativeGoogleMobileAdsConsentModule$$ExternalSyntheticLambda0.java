package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.google.android.ump.ConsentInformation;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda0 implements ConsentInformation.OnConsentInfoUpdateSuccessListener {
    public final /* synthetic */ ReactNativeGoogleMobileAdsConsentModule f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda0(ReactNativeGoogleMobileAdsConsentModule reactNativeGoogleMobileAdsConsentModule, Promise promise) {
        this.f$0 = reactNativeGoogleMobileAdsConsentModule;
        this.f$1 = promise;
    }

    public final void onConsentInfoUpdateSuccess() {
        this.f$0.lambda$requestInfoUpdate$0(this.f$1);
    }
}
