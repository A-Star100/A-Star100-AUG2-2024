package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaiw {
    public final zzadz zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzaiw(zzadz zzadz, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = zzadz;
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzaiw zza(zzadz zzadz, zzfo zzfo) {
        long[] jArr;
        int i;
        int i2;
        int zzg = zzfo.zzg();
        int zzp = (zzg & 1) != 0 ? zzfo.zzp() : -1;
        long zzu = (zzg & 2) != 0 ? zzfo.zzu() : -1;
        if ((zzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr2[i3] = (long) zzfo.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((zzg & 8) != 0) {
            zzfo.zzL(4);
        }
        if (zzfo.zzb() >= 24) {
            zzfo.zzL(21);
            int zzo = zzfo.zzo();
            i = zzo & 4095;
            i2 = zzo >> 12;
        } else {
            i2 = -1;
            i = -1;
        }
        return new zzaiw(zzadz, (long) zzp, zzu, jArr, i2, i);
    }
}
