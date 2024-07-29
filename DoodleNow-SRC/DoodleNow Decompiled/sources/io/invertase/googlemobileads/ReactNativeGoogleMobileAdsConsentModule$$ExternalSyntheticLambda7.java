package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda7 implements ConsentForm.OnConsentFormDismissedListener {
    public final /* synthetic */ ReactNativeGoogleMobileAdsConsentModule f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda7(ReactNativeGoogleMobileAdsConsentModule reactNativeGoogleMobileAdsConsentModule, Promise promise) {
        this.f$0 = reactNativeGoogleMobileAdsConsentModule;
        this.f$1 = promise;
    }

    public final void onConsentFormDismissed(FormError formError) {
        this.f$0.lambda$showPrivacyOptionsForm$6(this.f$1, formError);
    }
}
