package io.invertase.googlemobileads;

import android.app.Activity;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ AdManagerAdRequest f$3;
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback f$4;

    public /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda1(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, Activity activity, String str, AdManagerAdRequest adManagerAdRequest, ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback) {
        this.f$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
        this.f$1 = activity;
        this.f$2 = str;
        this.f$3 = adManagerAdRequest;
        this.f$4 = reactNativeGoogleMobileAdsAdLoadCallback;
    }

    public final void run() {
        ReactNativeGoogleMobileAdsFullScreenAdModule.load$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
