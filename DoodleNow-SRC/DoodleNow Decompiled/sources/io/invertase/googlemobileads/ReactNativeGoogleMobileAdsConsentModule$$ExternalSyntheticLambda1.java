package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.FormError;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda1 implements ConsentInformation.OnConsentInfoUpdateFailureListener {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda1(Promise promise) {
        this.f$0 = promise;
    }

    public final void onConsentInfoUpdateFailure(FormError formError) {
        ReactNativeGoogleMobileAdsConsentModule.rejectPromiseWithCodeAndMessage(this.f$0, "consent-update-failed", formError.getMessage());
    }
}
