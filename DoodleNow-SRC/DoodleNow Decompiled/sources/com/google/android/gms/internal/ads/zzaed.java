package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaed {
    public final zzaeg zza;
    public final zzaeg zzb;

    public zzaed(zzaeg zzaeg, zzaeg zzaeg2) {
        this.zza = zzaeg;
        this.zzb = zzaeg2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaed zzaed = (zzaed) obj;
            return this.zza.equals(zzaed.zza) && this.zzb.equals(zzaed.zzb);
        }
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzaeg zzaeg = this.zza;
        zzaeg zzaeg2 = this.zzb;
        String obj = zzaeg.toString();
        String concat = zzaeg.equals(zzaeg2) ? "" : ", ".concat(this.zzb.toString());
        return "[" + obj + concat + "]";
    }
}
