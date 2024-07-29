package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgqu implements zzggh {
    private final zzgos zza;
    private final zzgrt zzb;
    private final zzgrt zzc;

    /* synthetic */ zzgqu(zzgos zzgos, zzgqt zzgqt) {
        zzgrt zzgrt;
        this.zza = zzgos;
        if (zzgos.zzg()) {
            zzgru zzb2 = zzgnp.zza().zzb();
            zzgrz zza2 = zzgnh.zza(zzgos);
            this.zzb = zzb2.zza(zza2, "mac", "compute");
            zzgrt = zzb2.zza(zza2, "mac", "verify");
        } else {
            zzgrt = zzgnh.zza;
            this.zzb = zzgrt;
        }
        this.zzc = zzgrt;
    }
}
