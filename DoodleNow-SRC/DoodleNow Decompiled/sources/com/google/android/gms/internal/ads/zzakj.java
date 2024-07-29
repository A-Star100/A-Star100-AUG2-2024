package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzakj implements zzakp {
    private final zzads zza;
    private final zzadr zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzakj(zzads zzads, zzadr zzadr) {
        this.zza = zzads;
        this.zzb = zzadr;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    public final long zzd(zzadg zzadg) {
        long j = this.zzd;
        if (j < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j + 2);
    }

    public final zzaef zze() {
        zzek.zzf(this.zzc != -1);
        return new zzadq(this.zza, this.zzc);
    }

    public final void zzg(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfx.zzc(jArr, j, true, true)];
    }
}
