package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbzc extends zzbyp {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbzd zzb;

    public zzbzc(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbzd zzbzd) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbzd;
    }

    public final void zze(int i) {
    }

    public final void zzf(zze zze) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzg() {
        zzbzd zzbzd;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzbzd = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzbzd);
        }
    }
}
