package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdpr implements zzgea {
    final /* synthetic */ zzffn zza;
    final /* synthetic */ zzffq zzb;
    final /* synthetic */ zzcpk zzc;
    final /* synthetic */ zzdpx zzd;

    zzdpr(zzdpx zzdpx, zzffn zzffn, zzffq zzffq, zzcpk zzcpk) {
        this.zza = zzffn;
        this.zzb = zzffq;
        this.zzc = zzcpk;
        this.zzd = zzdpx;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcgm zzcgm = (zzcgm) obj;
        zzcgm.zzU(this.zza, this.zzb);
        zzcic zzN = zzcgm.zzN();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjS)).booleanValue() && zzN != null) {
            zzcpk zzcpk = this.zzc;
            zzdpx zzdpx = this.zzd;
            zzN.zzI(zzcpk, zzdpx.zzj, zzdpx.zzk);
            zzcpk zzcpk2 = this.zzc;
            zzdpx zzdpx2 = this.zzd;
            zzN.zzK(zzcpk2, zzdpx2.zzj, zzdpx2.zze);
        }
    }
}
