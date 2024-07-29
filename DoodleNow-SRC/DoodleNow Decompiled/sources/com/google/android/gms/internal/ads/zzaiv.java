package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaiv implements zzaiu {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzaiv(long[] jArr, long[] jArr2, long j, long j2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzaiv zzb(long j, long j2, zzadz zzadz, zzfo zzfo) {
        int i;
        long j3 = j;
        zzadz zzadz2 = zzadz;
        zzfo zzfo2 = zzfo;
        zzfo2.zzL(10);
        int zzg = zzfo.zzg();
        if (zzg <= 0) {
            return null;
        }
        int i2 = zzadz2.zzd;
        long zzt = zzfx.zzt((long) zzg, ((long) (i2 >= 32000 ? 1152 : 576)) * 1000000, (long) i2, RoundingMode.FLOOR);
        int zzq = zzfo.zzq();
        int zzq2 = zzfo.zzq();
        int zzq3 = zzfo.zzq();
        zzfo2.zzL(2);
        long j4 = j2 + ((long) zzadz2.zzc);
        long[] jArr = new long[zzq];
        long[] jArr2 = new long[zzq];
        int i3 = 0;
        long j5 = j2;
        while (i3 < zzq) {
            long j6 = zzt;
            jArr[i3] = (((long) i3) * zzt) / ((long) zzq);
            long j7 = j4;
            jArr2[i3] = Math.max(j5, j7);
            if (zzq3 == 1) {
                i = zzfo.zzm();
            } else if (zzq3 == 2) {
                i = zzfo.zzq();
            } else if (zzq3 == 3) {
                i = zzfo.zzo();
            } else if (zzq3 != 4) {
                return null;
            } else {
                i = zzfo.zzp();
            }
            j5 += ((long) i) * ((long) zzq2);
            i3++;
            j4 = j7;
            zzq = zzq;
            zzt = j6;
            zzfo zzfo3 = zzfo;
        }
        long j8 = zzt;
        if (!(j3 == -1 || j3 == j5)) {
            zzfe.zzf("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new zzaiv(jArr, jArr2, j8, j5);
    }

    public final long zza() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzd;
    }

    public final long zzd(long j) {
        return this.zza[zzfx.zzc(this.zzb, j, true, true)];
    }

    public final zzaed zzg(long j) {
        long[] jArr = this.zza;
        int zzc2 = zzfx.zzc(jArr, j, true, true);
        zzaeg zzaeg = new zzaeg(jArr[zzc2], this.zzb[zzc2]);
        if (zzaeg.zzb < j) {
            long[] jArr2 = this.zza;
            if (zzc2 != jArr2.length - 1) {
                int i = zzc2 + 1;
                return new zzaed(zzaeg, new zzaeg(jArr2[i], this.zzb[i]));
            }
        }
        return new zzaed(zzaeg, zzaeg);
    }

    public final boolean zzh() {
        return true;
    }
}
