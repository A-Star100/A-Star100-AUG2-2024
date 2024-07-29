package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcui implements zzgea {
    final /* synthetic */ zzgea zza;
    final /* synthetic */ zzcuk zzb;

    zzcui(zzcuk zzcuk, zzgea zzgea) {
        this.zza = zzgea;
        this.zzb = zzcuk;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzcbr.zze.execute(new zzcue(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcuk.zzb(this.zzb, ((zzcud) obj).zza, this.zza);
    }
}
