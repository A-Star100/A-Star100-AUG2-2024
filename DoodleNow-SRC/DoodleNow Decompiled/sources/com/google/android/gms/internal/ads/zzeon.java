package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbh;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeon {
    private final zzdlj zza;
    private final zzeoa zzb;
    private final zzcyt zzc;

    public zzeon(zzdlj zzdlj, zzduh zzduh) {
        this.zza = zzdlj;
        zzeoa zzeoa = new zzeoa(zzduh);
        this.zzb = zzeoa;
        this.zzc = new zzeom(zzeoa, zzdlj.zzg());
    }

    public final zzcyt zza() {
        return this.zzc;
    }

    public final zzdae zzb() {
        return this.zzb;
    }

    public final zzdjd zzc() {
        return new zzdjd(this.zza, this.zzb.zzg());
    }

    public final zzeoa zzd() {
        return this.zzb;
    }

    public final void zze(zzbh zzbh) {
        this.zzb.zzj(zzbh);
    }
}
