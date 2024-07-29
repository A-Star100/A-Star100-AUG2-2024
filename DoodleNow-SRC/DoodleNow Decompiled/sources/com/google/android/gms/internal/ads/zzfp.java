package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfp {
    public static final zzfp zza = new zzfp(-1, -1);
    public static final zzfp zzb = new zzfp(0, 0);
    private final int zzc;
    private final int zzd;

    public zzfp(int i, int i2) {
        boolean z = false;
        if ((i == -1 || i >= 0) && (i2 == -1 || i2 >= 0)) {
            z = true;
        }
        zzek.zzd(z);
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfp) {
            zzfp zzfp = (zzfp) obj;
            return this.zzc == zzfp.zzc && this.zzd == zzfp.zzd;
        }
    }

    public final int hashCode() {
        int i = this.zzc;
        return ((i >>> 16) | (i << 16)) ^ this.zzd;
    }

    public final String toString() {
        return this.zzc + "x" + this.zzd;
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzc;
    }
}
