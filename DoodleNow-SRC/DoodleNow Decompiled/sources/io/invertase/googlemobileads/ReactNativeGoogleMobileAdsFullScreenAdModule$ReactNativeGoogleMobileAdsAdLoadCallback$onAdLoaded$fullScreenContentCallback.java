package io.invertase.googlemobileads;

import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.FullScreenContentCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"io/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$onAdLoaded$fullScreenContentCallback$1", "Lcom/google/android/gms/ads/FullScreenContentCallback;", "onAdClicked", "", "onAdDismissedFullScreenContent", "onAdImpression", "onAdShowedFullScreenContent", "sendAdEvent", "type", "", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeGoogleMobileAdsFullScreenAdModule.kt */
public final class ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$onAdLoaded$fullScreenContentCallback$1 extends FullScreenContentCallback {
    final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule<T> this$0;
    final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule<T>.ReactNativeGoogleMobileAdsAdLoadCallback this$1;

    public void onAdImpression() {
    }

    ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$onAdLoaded$fullScreenContentCallback$1(ReactNativeGoogleMobileAdsFullScreenAdModule<T> reactNativeGoogleMobileAdsFullScreenAdModule, ReactNativeGoogleMobileAdsFullScreenAdModule<T>.ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback) {
        this.this$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
        this.this$1 = reactNativeGoogleMobileAdsAdLoadCallback;
    }

    public void onAdShowedFullScreenContent() {
        sendAdEvent("opened");
    }

    public void onAdDismissedFullScreenContent() {
        sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLOSED);
    }

    public void onAdClicked() {
        sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLICKED);
    }

    private final void sendAdEvent(String str) {
        this.this$0.sendAdEvent(str, this.this$1.requestId, this.this$1.adUnitId, (WritableMap) null, (WritableMap) null);
    }
}
