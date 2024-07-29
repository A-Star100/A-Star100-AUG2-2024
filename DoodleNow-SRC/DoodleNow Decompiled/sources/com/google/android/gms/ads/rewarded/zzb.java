package com.google.android.gms.ads.rewarded;

import android.content.Context;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbys;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdManagerAdRequest zzc;
    public final /* synthetic */ RewardedAdLoadCallback zzd;

    public /* synthetic */ zzb(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adManagerAdRequest;
        this.zzd = rewardedAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdManagerAdRequest adManagerAdRequest = this.zzc;
        try {
            new zzbys(context, str).zza(adManagerAdRequest.zza(), this.zzd);
        } catch (IllegalStateException e) {
            zzbvs.zza(context).zzg(e, "RewardedAd.loadAdManager");
        }
    }
}
