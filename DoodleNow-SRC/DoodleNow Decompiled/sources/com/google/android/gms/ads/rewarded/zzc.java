package com.google.android.gms.ads.rewarded;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbys;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzc implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ RewardedAdLoadCallback zzd;

    public /* synthetic */ zzc(Context context, String str, AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adRequest;
        this.zzd = rewardedAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdRequest adRequest = this.zzc;
        try {
            new zzbys(context, str).zza(adRequest.zza(), this.zzd);
        } catch (IllegalStateException e) {
            zzbvs.zza(context).zzg(e, "RewardedAd.load");
        }
    }
}
