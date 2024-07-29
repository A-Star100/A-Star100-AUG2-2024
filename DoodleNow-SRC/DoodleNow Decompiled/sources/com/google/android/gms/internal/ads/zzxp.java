package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzxp {
    public final long zza;
    public final long zzb;

    public zzxp(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxp)) {
            return false;
        }
        zzxp zzxp = (zzxp) obj;
        return this.zza == zzxp.zza && this.zzb == zzxp.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
