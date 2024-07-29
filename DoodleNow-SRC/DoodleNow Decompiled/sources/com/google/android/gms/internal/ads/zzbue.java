package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbue extends zzbir {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbue(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbjb zzbjb) {
        this.zza.onNativeAdLoaded(new zzbtx(zzbjb));
    }
}
