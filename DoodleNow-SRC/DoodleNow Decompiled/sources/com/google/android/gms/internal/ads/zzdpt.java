package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdpt {
    private final zzcyo zza;
    private final zzczx zzb;
    private final zzdak zzc;
    private final zzdaw zzd;
    private final zzddk zze;
    private final zzffn zzf;
    private final zzffq zzg;
    private final zzcpk zzh;

    public zzdpt(zzcyo zzcyo, zzczx zzczx, zzdak zzdak, zzdaw zzdaw, zzddk zzddk, zzffn zzffn, zzffq zzffq, zzcpk zzcpk) {
        this.zza = zzcyo;
        this.zzb = zzczx;
        this.zzc = zzdak;
        this.zzd = zzdaw;
        this.zze = zzddk;
        this.zzf = zzffn;
        this.zzg = zzffq;
        this.zzh = zzcpk;
    }

    public final void zza(zzdpx zzdpx) {
        zzczx zzczx = this.zzb;
        zzdpk zzb2 = zzdpx.zza;
        Objects.requireNonNull(zzczx);
        zzb2.zzh(this.zza, this.zzc, this.zzd, this.zze, new zzdps(zzczx));
        zzdpx.zzh(this.zzf, this.zzg, this.zzh);
    }
}
