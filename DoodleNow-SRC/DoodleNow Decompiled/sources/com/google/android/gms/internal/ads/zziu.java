package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zziu {
    private final long zza;
    private final long zzb;
    private long zzc = C.TIME_UNSET;
    private long zzd = C.TIME_UNSET;
    private long zze = C.TIME_UNSET;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzi = 1.03f;
    private float zzj = 0.97f;
    private float zzk = 1.0f;
    private long zzl = C.TIME_UNSET;
    private long zzm = C.TIME_UNSET;
    private long zzn = C.TIME_UNSET;

    /* synthetic */ zziu(float f, float f2, long j, float f3, long j2, long j3, float f4, zzit zzit) {
        this.zza = j2;
        this.zzb = j3;
    }

    private static long zzf(long j, long j2, float f) {
        return (long) ((((float) j) * 0.999f) + (((float) j2) * 9.999871E-4f));
    }

    private final void zzg() {
        long j;
        long j2 = this.zzc;
        if (j2 != C.TIME_UNSET) {
            j = this.zzd;
            if (j == C.TIME_UNSET) {
                long j3 = this.zzf;
                if (j3 != C.TIME_UNSET && j2 < j3) {
                    j2 = j3;
                }
                j = this.zzg;
                if (j == C.TIME_UNSET || j2 <= j) {
                    j = j2;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.zze != j) {
            this.zze = j;
            this.zzh = j;
            this.zzm = C.TIME_UNSET;
            this.zzn = C.TIME_UNSET;
            this.zzl = C.TIME_UNSET;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j = this.zzh;
        if (j != C.TIME_UNSET) {
            long j2 = j + this.zzb;
            this.zzh = j2;
            long j3 = this.zzg;
            if (j3 != C.TIME_UNSET && j2 > j3) {
                this.zzh = j3;
            }
            this.zzl = C.TIME_UNSET;
        }
    }

    public final void zzd(zzbf zzbf) {
        long j = zzbf.zzc;
        this.zzc = zzfx.zzr(C.TIME_UNSET);
        long j2 = zzbf.zzd;
        this.zzf = zzfx.zzr(C.TIME_UNSET);
        long j3 = zzbf.zze;
        this.zzg = zzfx.zzr(C.TIME_UNSET);
        float f = zzbf.zzf;
        this.zzj = 0.97f;
        float f2 = zzbf.zzg;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j) {
        this.zzd = j;
        zzg();
    }

    public final float zza(long j, long j2) {
        if (this.zzc == C.TIME_UNSET) {
            return 1.0f;
        }
        long j3 = j - j2;
        long j4 = this.zzm;
        if (j4 == C.TIME_UNSET) {
            this.zzm = j3;
            this.zzn = 0;
        } else {
            long max = Math.max(j3, zzf(j4, j3, 0.999f));
            this.zzm = max;
            this.zzn = zzf(this.zzn, Math.abs(j3 - max), 0.999f);
        }
        if (this.zzl != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j5 = this.zzm + (this.zzn * 3);
        if (this.zzh > j5) {
            float zzr = (float) zzfx.zzr(1000);
            long[] jArr = {j5, this.zze, this.zzh - (((long) ((this.zzk - 4.0f) * zzr)) + ((long) ((this.zzi - 4.0f) * zzr)))};
            for (int i = 1; i < 3; i++) {
                long j6 = jArr[i];
                if (j6 > j5) {
                    j5 = j6;
                }
            }
            this.zzh = j5;
        } else {
            j5 = Math.max(this.zzh, Math.min(j - ((long) (Math.max(0.0f, this.zzk - 4.0f) / 1.0E-7f)), j5));
            this.zzh = j5;
            long j7 = this.zzg;
            if (j7 != C.TIME_UNSET && j5 > j7) {
                this.zzh = j7;
                j5 = j7;
            }
        }
        long j8 = j - j5;
        if (Math.abs(j8) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float max2 = Math.max(this.zzj, Math.min((((float) j8) * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = max2;
        return max2;
    }
}
