package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzzg {
    public final int zza;
    public final zzmi[] zzb;
    public final zzyz[] zzc;
    public final zzdk zzd;
    public final Object zze;

    public zzzg(zzmi[] zzmiArr, zzyz[] zzyzArr, zzdk zzdk, Object obj) {
        this.zzb = zzmiArr;
        this.zzc = (zzyz[]) zzyzArr.clone();
        this.zzd = zzdk;
        this.zze = obj;
        this.zza = zzmiArr.length;
    }

    public final boolean zza(zzzg zzzg, int i) {
        if (zzzg != null && zzfx.zzG(this.zzb[i], zzzg.zzb[i]) && zzfx.zzG(this.zzc[i], zzzg.zzc[i])) {
            return true;
        }
        return false;
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}
