package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzaee implements zzaef {
    private final long zza;
    private final zzaed zzb;

    public zzaee(long j, long j2) {
        this.zza = j;
        zzaeg zzaeg = j2 == 0 ? zzaeg.zza : new zzaeg(0, j2);
        this.zzb = new zzaed(zzaeg, zzaeg);
    }

    public final long zza() {
        return this.zza;
    }

    public final zzaed zzg(long j) {
        return this.zzb;
    }

    public final boolean zzh() {
        return false;
    }
}
