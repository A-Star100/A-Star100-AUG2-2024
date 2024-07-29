package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbvs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzf implements Runnable {
    public final /* synthetic */ BaseAdView zza;
    public final /* synthetic */ AdRequest zzb;

    public /* synthetic */ zzf(BaseAdView baseAdView, AdRequest adRequest) {
        this.zza = baseAdView;
        this.zzb = adRequest;
    }

    public final void run() {
        BaseAdView baseAdView = this.zza;
        try {
            baseAdView.zza.zzm(this.zzb.zza);
        } catch (IllegalStateException e) {
            zzbvs.zza(baseAdView.getContext()).zzg(e, "BaseAdView.loadAd");
        }
    }
}
