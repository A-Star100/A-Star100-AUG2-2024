package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzctn {
    private final zzdbf zza;
    private final zzddm zzb;

    public zzctn(zzdbf zzdbf, zzddm zzddm) {
        this.zza = zzdbf;
        this.zzb = zzddm;
    }

    public final zzdbf zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final zzddm zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzdgf zzc() {
        zzddm zzddm = this.zzb;
        if (zzddm != null) {
            return new zzdgf(zzddm, zzcbr.zzf);
        }
        return new zzdgf(new zzctm(this), zzcbr.zzf);
    }
}
