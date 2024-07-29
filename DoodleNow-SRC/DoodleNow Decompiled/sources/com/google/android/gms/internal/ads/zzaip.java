package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaip implements zzaiu {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzaip(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == C.TIME_UNSET ? zzfx.zzr(jArr2[jArr2.length - 1]) : j;
    }

    public static zzaip zzb(long j, zzahh zzahh, long j2) {
        int length = zzahh.zzd.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzahh.zzb + zzahh.zzd[i3]);
            j3 += (long) (zzahh.zzc + zzahh.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzaip(jArr, jArr2, j2);
    }

    private static Pair zze(long j, long[] jArr, long[] jArr2) {
        int zzc2 = zzfx.zzc(jArr, j, true, true);
        long j2 = jArr[zzc2];
        long j3 = jArr2[zzc2];
        int i = zzc2 + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? AudioStats.AUDIO_AMPLITUDE_NONE : (((double) j) - ((double) j2)) / ((double) (j4 - j2))) * ((double) (jArr2[i] - j3)))) + j3));
    }

    public final long zza() {
        return this.zzc;
    }

    public final long zzc() {
        return -1;
    }

    public final long zzd(long j) {
        return zzfx.zzr(((Long) zze(j, this.zza, this.zzb).second).longValue());
    }

    public final zzaed zzg(long j) {
        Pair zze = zze(zzfx.zzu(Math.max(0, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzaeg zzaeg = new zzaeg(zzfx.zzr(((Long) zze.first).longValue()), ((Long) zze.second).longValue());
        return new zzaed(zzaeg, zzaeg);
    }

    public final boolean zzh() {
        return true;
    }
}
