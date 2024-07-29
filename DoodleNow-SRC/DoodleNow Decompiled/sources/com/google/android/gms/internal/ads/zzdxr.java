package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdxr implements NativeAd.OnNativeAdLoadedListener {
    public final /* synthetic */ zzdyc zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzdxr(zzdyc zzdyc, String str, String str2) {
        this.zza = zzdyc;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void onNativeAdLoaded(NativeAd nativeAd) {
        this.zza.zzg(this.zzb, nativeAd, this.zzc);
    }
}
