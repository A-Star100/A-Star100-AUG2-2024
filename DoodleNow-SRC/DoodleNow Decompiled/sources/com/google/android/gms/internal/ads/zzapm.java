package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzapm implements zzaef {
    private final zzapj zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzapm(zzapj zzapj, int i, long j, long j2) {
        this.zza = zzapj;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzapj.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzfx.zzt(j * ((long) this.zzb), 1000000, (long) this.zza.zzc, RoundingMode.FLOOR);
    }

    public final long zza() {
        return this.zze;
    }

    public final zzaed zzg(long j) {
        long max = Math.max(0, Math.min((((long) this.zza.zzc) * j) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long zzb2 = zzb(max);
        zzaeg zzaeg = new zzaeg(zzb2, this.zzc + (((long) this.zza.zzd) * max));
        if (zzb2 >= j || max == this.zzd - 1) {
            return new zzaed(zzaeg, zzaeg);
        }
        long j2 = max + 1;
        return new zzaed(zzaeg, new zzaeg(zzb(j2), this.zzc + (j2 * ((long) this.zza.zzd))));
    }

    public final boolean zzh() {
        return true;
    }
}
