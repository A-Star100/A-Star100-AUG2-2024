package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdxv extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ AdView zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzdyc zzd;

    zzdxv(zzdyc zzdyc, String str, AdView adView, String str2) {
        this.zza = str;
        this.zzb = adView;
        this.zzc = str2;
        this.zzd = zzdyc;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzd.zzm(zzdyc.zzl(loadAdError), this.zzc);
    }

    public final void onAdLoaded() {
        this.zzd.zzg(this.zza, this.zzb, this.zzc);
    }
}
