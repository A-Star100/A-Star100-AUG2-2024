package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaqw {
    public final Object zza;
    public final zzapz zzb;
    public final zzaqz zzc;
    public boolean zzd;

    private zzaqw(zzaqz zzaqz) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzaqz;
    }

    private zzaqw(Object obj, zzapz zzapz) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzapz;
        this.zzc = null;
    }

    public static zzaqw zza(zzaqz zzaqz) {
        return new zzaqw(zzaqz);
    }

    public static zzaqw zzb(Object obj, zzapz zzapz) {
        return new zzaqw(obj, zzapz);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
