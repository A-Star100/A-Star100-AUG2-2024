package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzadq implements zzaef {
    private final zzads zza;
    private final long zzb;

    public zzadq(zzads zzads, long j) {
        this.zza = zzads;
        this.zzb = j;
    }

    private final zzaeg zzb(long j, long j2) {
        return new zzaeg((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    public final long zza() {
        return this.zza.zza();
    }

    public final zzaed zzg(long j) {
        long j2;
        zzek.zzb(this.zza.zzk);
        zzads zzads = this.zza;
        zzadr zzadr = zzads.zzk;
        long[] jArr = zzadr.zza;
        long[] jArr2 = zzadr.zzb;
        int zzc = zzfx.zzc(jArr, zzads.zzb(j), true, false);
        long j3 = 0;
        if (zzc == -1) {
            j2 = 0;
        } else {
            j2 = jArr[zzc];
        }
        if (zzc != -1) {
            j3 = jArr2[zzc];
        }
        zzaeg zzb2 = zzb(j2, j3);
        if (zzb2.zzb == j || zzc == jArr.length - 1) {
            return new zzaed(zzb2, zzb2);
        }
        int i = zzc + 1;
        return new zzaed(zzb2, zzb(jArr[i], jArr2[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
