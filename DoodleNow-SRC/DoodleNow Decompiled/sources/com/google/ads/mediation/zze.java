package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.formats.zzi;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.internal.ads.zzbhz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zze extends AdListener implements zzi, zzg, zzf {
    final AbstractAdViewAdapter zza;
    final MediationNativeListener zzb;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, (AdError) loadAdError);
    }

    public final void onAdImpression() {
        this.zzb.onAdImpression(this.zza);
    }

    public final void onAdLoaded() {
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened(this.zza);
    }

    public final void zza(UnifiedNativeAd unifiedNativeAd) {
        this.zzb.onAdLoaded(this.zza, new zza(unifiedNativeAd));
    }

    public final void zzb(zzbhz zzbhz, String str) {
        this.zzb.zze(this.zza, zzbhz, str);
    }

    public final void zzc(zzbhz zzbhz) {
        this.zzb.zzd(this.zza, zzbhz);
    }
}
