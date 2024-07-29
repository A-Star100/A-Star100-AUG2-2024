package io.invertase.googlemobileads;

import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda0 implements OnUserEarnedRewardListener {
    public final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda0(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, String str) {
        this.f$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
        this.f$1 = i;
        this.f$2 = str;
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        ReactNativeGoogleMobileAdsFullScreenAdModule.show$lambda$2$lambda$1(this.f$0, this.f$1, this.f$2, rewardItem);
    }
}
