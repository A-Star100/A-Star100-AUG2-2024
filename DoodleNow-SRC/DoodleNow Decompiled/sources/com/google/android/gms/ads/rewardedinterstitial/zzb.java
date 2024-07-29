package com.google.android.gms.ads.rewardedinterstitial;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbzd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ RewardedInterstitialAdLoadCallback zzd;

    public /* synthetic */ zzb(Context context, String str, AdRequest adRequest, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adRequest;
        this.zzd = rewardedInterstitialAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdRequest adRequest = this.zzc;
        try {
            new zzbzd(context, str).zza(adRequest.zza(), this.zzd);
        } catch (IllegalStateException e) {
            zzbvs.zza(context).zzg(e, "RewardedInterstitialAd.load");
        }
    }
}
