package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzvv implements zzyz {
    private final zzyz zza;
    private final zzcz zzb;

    public zzvv(zzyz zzyz, zzcz zzcz) {
        this.zza = zzyz;
        this.zzb = zzcz;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvv)) {
            return false;
        }
        zzvv zzvv = (zzvv) obj;
        return this.zza.equals(zzvv.zza) && this.zzb.equals(zzvv.zzb);
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + 527) * 31) + this.zza.hashCode();
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int zzc() {
        return this.zza.zzc();
    }

    public final zzam zzd(int i) {
        return this.zzb.zzb(this.zza.zza(i));
    }

    public final zzcz zze() {
        return this.zzb;
    }
}
