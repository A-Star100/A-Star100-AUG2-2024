package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdqc {
    private final zzcyo zza;
    private final zzczx zzb;
    private final zzdak zzc;
    private final zzdaw zzd;
    private final zzddk zze;
    private final zzdgl zzf;
    private final zzduh zzg;
    private final zzfmt zzh;
    private final zzefd zzi;
    private final zzcpk zzj;

    zzdqc(zzcyo zzcyo, zzczx zzczx, zzdak zzdak, zzdaw zzdaw, zzddk zzddk, zzdgl zzdgl, zzduh zzduh, zzfmt zzfmt, zzefd zzefd, zzcpk zzcpk) {
        this.zza = zzcyo;
        this.zzb = zzczx;
        this.zzc = zzdak;
        this.zzd = zzdaw;
        this.zze = zzddk;
        this.zzf = zzdgl;
        this.zzg = zzduh;
        this.zzh = zzfmt;
        this.zzi = zzefd;
        this.zzj = zzcpk;
    }

    public final void zza(zzdqd zzdqd, zzcgm zzcgm) {
        zzdqa zza2 = zzdqd.zza;
        zzczx zzczx = this.zzb;
        Objects.requireNonNull(zzczx);
        zza2.zzi(this.zza, this.zzc, this.zzd, this.zze, new zzdqb(zzczx), this.zzf);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjU)).booleanValue() && zzcgm != null && zzcgm.zzN() != null) {
            zzcic zzN = zzcgm.zzN();
            zzN.zzI(this.zzj, this.zzi, this.zzh);
            zzN.zzK(this.zzj, this.zzi, this.zzg);
        }
    }
}
