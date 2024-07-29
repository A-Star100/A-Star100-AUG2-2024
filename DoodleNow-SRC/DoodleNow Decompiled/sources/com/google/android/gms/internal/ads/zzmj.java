package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzmj {
    public static final zzmj zza;
    public static final zzmj zzb = new zzmj(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final zzmj zzc = new zzmj(Long.MAX_VALUE, 0);
    public static final zzmj zzd = new zzmj(0, Long.MAX_VALUE);
    public static final zzmj zze;
    public final long zzf;
    public final long zzg;

    static {
        zzmj zzmj = new zzmj(0, 0);
        zza = zzmj;
        zze = zzmj;
    }

    public zzmj(long j, long j2) {
        boolean z = true;
        zzek.zzd(j >= 0);
        zzek.zzd(j2 < 0 ? false : z);
        this.zzf = j;
        this.zzg = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmj zzmj = (zzmj) obj;
            return this.zzf == zzmj.zzf && this.zzg == zzmj.zzg;
        }
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
