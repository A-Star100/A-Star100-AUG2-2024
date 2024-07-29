package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzapc {
    public static int zza(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long zzb(zzfo zzfo, int i, int i2) {
        zzfo.zzK(i);
        if (zzfo.zzb() < 5) {
            return C.TIME_UNSET;
        }
        int zzg = zzfo.zzg();
        if ((8388608 & zzg) != 0 || ((zzg >> 8) & 8191) != i2 || (zzg & 32) == 0 || zzfo.zzm() < 7 || zzfo.zzb() < 7 || (zzfo.zzm() & 16) != 16) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[6];
        zzfo.zzG(bArr, 0, 6);
        long j = ((long) bArr[3]) & 255;
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | (j + j) | ((((long) bArr[4]) & 255) >> 7);
    }
}
