package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbjj {
    /* access modifiers changed from: private */
    public final zzg zza;
    /* access modifiers changed from: private */
    public final zzf zzb;
    private zzbhz zzc;

    public zzbjj(zzg zzg, zzf zzf) {
        this.zza = zzg;
        this.zzb = zzf;
    }

    /* access modifiers changed from: private */
    public final synchronized zzbhz zzf(zzbhy zzbhy) {
        zzbhz zzbhz = this.zzc;
        if (zzbhz != null) {
            return zzbhz;
        }
        zzbhz zzbhz2 = new zzbhz(zzbhy);
        this.zzc = zzbhz2;
        return zzbhz2;
    }

    public final zzbii zzc() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbjg(this, (zzbjf) null);
    }

    public final zzbil zzd() {
        return new zzbji(this, (zzbjh) null);
    }
}
