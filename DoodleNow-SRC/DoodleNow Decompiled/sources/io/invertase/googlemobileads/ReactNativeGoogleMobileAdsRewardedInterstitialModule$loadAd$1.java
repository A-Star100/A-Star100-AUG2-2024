package io.invertase.googlemobileads;

import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"io/invertase/googlemobileads/ReactNativeGoogleMobileAdsRewardedInterstitialModule$loadAd$1", "Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAdLoadCallback;", "onAdFailedToLoad", "", "error", "Lcom/google/android/gms/ads/LoadAdError;", "onAdLoaded", "ad", "Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAd;", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeGoogleMobileAdsRewardedInterstitialModule.kt */
public final class ReactNativeGoogleMobileAdsRewardedInterstitialModule$loadAd$1 extends RewardedInterstitialAdLoadCallback {
    final /* synthetic */ AdLoadCallback<RewardedInterstitialAd> $adLoadCallback;

    ReactNativeGoogleMobileAdsRewardedInterstitialModule$loadAd$1(AdLoadCallback<RewardedInterstitialAd> adLoadCallback) {
        this.$adLoadCallback = adLoadCallback;
    }

    public void onAdLoaded(RewardedInterstitialAd rewardedInterstitialAd) {
        Intrinsics.checkNotNullParameter(rewardedInterstitialAd, "ad");
        this.$adLoadCallback.onAdLoaded(rewardedInterstitialAd);
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        Intrinsics.checkNotNullParameter(loadAdError, "error");
        this.$adLoadCallback.onAdFailedToLoad(loadAdError);
    }
}
