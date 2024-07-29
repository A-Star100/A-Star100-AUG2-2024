package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda3 implements UserMessagingPlatform.OnConsentFormLoadFailureListener {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda3(Promise promise) {
        this.f$0 = promise;
    }

    public final void onConsentFormLoadFailure(FormError formError) {
        ReactNativeGoogleMobileAdsConsentModule.rejectPromiseWithCodeAndMessage(this.f$0, "consent-form-error", formError.getMessage());
    }
}
