package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzacr implements zzaef {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzacr(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length > 0) {
            int i = length - 1;
            this.zzf = jArr2[i] + jArr3[i];
            return;
        }
        this.zzf = 0;
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        String arrays = Arrays.toString(this.zzb);
        String arrays2 = Arrays.toString(jArr3);
        String arrays3 = Arrays.toString(jArr2);
        String arrays4 = Arrays.toString(jArr);
        return "ChunkIndex(length=" + this.zza + ", sizes=" + arrays + ", offsets=" + arrays2 + ", timeUs=" + arrays3 + ", durationsUs=" + arrays4 + ")";
    }

    public final long zza() {
        return this.zzf;
    }

    public final zzaed zzg(long j) {
        long[] jArr = this.zze;
        int zzc2 = zzfx.zzc(jArr, j, true, true);
        zzaeg zzaeg = new zzaeg(jArr[zzc2], this.zzc[zzc2]);
        if (zzaeg.zzb >= j || zzc2 == this.zza - 1) {
            return new zzaed(zzaeg, zzaeg);
        }
        int i = zzc2 + 1;
        return new zzaed(zzaeg, new zzaeg(this.zze[i], this.zzc[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
