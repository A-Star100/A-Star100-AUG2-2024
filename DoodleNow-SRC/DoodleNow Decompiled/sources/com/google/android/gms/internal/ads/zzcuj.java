package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcuj implements zzgea {
    final /* synthetic */ zzgea zza;
    final /* synthetic */ zzcuk zzb;

    zzcuj(zzcuk zzcuk, zzgea zzgea) {
        this.zza = zzgea;
        this.zzb = zzcuk;
    }

    public final void zza(Throwable th) {
        zzcbr.zze.execute(new zzcue(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcbr.zze.execute(new zzcue(this.zzb));
        this.zza.zzb((zzctv) obj);
    }
}
