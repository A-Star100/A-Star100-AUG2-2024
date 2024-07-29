package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzadp {
    public static zzadr zzb(zzfo zzfo) {
        zzfo.zzL(1);
        int zzo = zzfo.zzo();
        long zzd = (long) zzfo.zzd();
        long j = (long) zzo;
        int i = zzo / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzt = zzfo.zzt();
            if (zzt == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = zzt;
            jArr2[i2] = zzfo.zzt();
            zzfo.zzL(2);
            i2++;
        }
        zzfo.zzL((int) ((zzd + j) - ((long) zzfo.zzd())));
        return new zzadr(jArr, jArr2);
    }

    public static zzby zza(zzadg zzadg, boolean z) throws IOException {
        zzby zza = new zzadx().zza(zzadg, z ? null : zzahc.zza);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }
}
