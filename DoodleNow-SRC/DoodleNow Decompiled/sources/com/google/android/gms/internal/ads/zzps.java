package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzps {
    public static final zzps zza = new zzpq().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzps(zzpq zzpq, zzpr zzpr) {
        this.zzb = zzpq.zza;
        this.zzc = zzpq.zzb;
        this.zzd = zzpq.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzps zzps = (zzps) obj;
            return this.zzb == zzps.zzb && this.zzc == zzps.zzc && this.zzd == zzps.zzd;
        }
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return ((z ? 1 : 0) << true) + (z2 ? 1 : 0) + z2 + (this.zzd ? 1 : 0);
    }
}
