package io.invertase.googlemobileads;

import android.view.View;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager;
import io.invertase.googlemobileads.common.ReactNativeAdView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsBannerAdViewManager$2$$ExternalSyntheticLambda0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ReactNativeGoogleMobileAdsBannerAdViewManager.AnonymousClass2 f$0;
    public final /* synthetic */ ReactNativeAdView f$1;

    public /* synthetic */ ReactNativeGoogleMobileAdsBannerAdViewManager$2$$ExternalSyntheticLambda0(ReactNativeGoogleMobileAdsBannerAdViewManager.AnonymousClass2 r1, ReactNativeAdView reactNativeAdView) {
        this.f$0 = r1;
        this.f$1 = reactNativeAdView;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f$0.lambda$onAdLoaded$0(this.f$1, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
