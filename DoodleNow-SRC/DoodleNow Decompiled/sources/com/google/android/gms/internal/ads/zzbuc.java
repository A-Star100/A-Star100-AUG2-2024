package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbuc {
    /* access modifiers changed from: private */
    public final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    /* access modifiers changed from: private */
    public final NativeCustomFormatAd.OnCustomClickListener zzb;
    private NativeCustomFormatAd zzc;

    public zzbuc(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomFormatAd zzf(zzbhy zzbhy) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbud zzbud = new zzbud(zzbhy);
        this.zzc = zzbud;
        return zzbud;
    }

    public final zzbii zza() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbtz(this, (zzbty) null);
    }

    public final zzbil zzb() {
        return new zzbub(this, (zzbua) null);
    }
}
