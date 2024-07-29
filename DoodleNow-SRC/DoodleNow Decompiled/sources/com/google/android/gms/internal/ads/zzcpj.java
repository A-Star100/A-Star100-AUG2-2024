package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcpj implements zzgea {
    final /* synthetic */ zzfmt zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcpk zzc;

    zzcpj(zzcpk zzcpk, zzfmt zzfmt, String str) {
        this.zza = zzfmt;
        this.zzb = str;
        this.zzc = zzcpk;
    }

    public final void zza(Throwable th) {
        this.zzc.zzg.zza(new zzcph(this, th, this.zza, this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzc.zzg.zza(new zzcpi(this.zza, (String) obj));
    }
}
