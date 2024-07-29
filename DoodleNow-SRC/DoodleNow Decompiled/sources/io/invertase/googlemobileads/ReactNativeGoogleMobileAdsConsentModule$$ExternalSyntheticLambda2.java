package io.invertase.googlemobileads;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.UserMessagingPlatform;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda2 implements UserMessagingPlatform.OnConsentFormLoadSuccessListener {
    public final /* synthetic */ ReactNativeGoogleMobileAdsConsentModule f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ Promise f$2;

    public /* synthetic */ ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda2(ReactNativeGoogleMobileAdsConsentModule reactNativeGoogleMobileAdsConsentModule, Activity activity, Promise promise) {
        this.f$0 = reactNativeGoogleMobileAdsConsentModule;
        this.f$1 = activity;
        this.f$2 = promise;
    }

    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.f$0.lambda$showForm$3(this.f$1, this.f$2, consentForm);
    }
}
