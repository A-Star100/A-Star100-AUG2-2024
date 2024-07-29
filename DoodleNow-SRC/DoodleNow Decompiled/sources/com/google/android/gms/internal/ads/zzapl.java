package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.audio.WavUtil;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzapl {
    public static Pair zza(zzadg zzadg) throws IOException {
        zzadg.zzj();
        zzapk zzd = zzd(1684108385, zzadg, new zzfo(8));
        ((zzact) zzadg).zzo(8, false);
        return Pair.create(Long.valueOf(zzadg.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzapj zzb(zzadg zzadg) throws IOException {
        byte[] bArr;
        zzfo zzfo = new zzfo(16);
        zzapk zzd = zzd(WavUtil.FMT_FOURCC, zzadg, zzfo);
        zzek.zzf(zzd.zzb >= 16);
        zzact zzact = (zzact) zzadg;
        zzact.zzm(zzfo.zzM(), 0, 16, false);
        zzfo.zzK(0);
        int zzk = zzfo.zzk();
        int zzk2 = zzfo.zzk();
        int zzj = zzfo.zzj();
        int zzj2 = zzfo.zzj();
        int zzk3 = zzfo.zzk();
        int zzk4 = zzfo.zzk();
        int i = ((int) zzd.zzb) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzact.zzm(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = zzfx.zzf;
        }
        zzact.zzo((int) (zzadg.zze() - zzadg.zzf()), false);
        return new zzapj(zzk, zzk2, zzj, zzj2, zzk3, zzk4, bArr);
    }

    public static boolean zzc(zzadg zzadg) throws IOException {
        zzfo zzfo = new zzfo(8);
        int i = zzapk.zza(zzadg, zzfo).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ((zzact) zzadg).zzm(zzfo.zzM(), 0, 4, false);
        zzfo.zzK(0);
        int zzg = zzfo.zzg();
        if (zzg == 1463899717) {
            return true;
        }
        zzfe.zzc("WavHeaderReader", "Unsupported form type: " + zzg);
        return false;
    }

    private static zzapk zzd(int i, zzadg zzadg, zzfo zzfo) throws IOException {
        zzapk zza = zzapk.zza(zzadg, zzfo);
        while (true) {
            int i2 = zza.zza;
            if (i2 == i) {
                return zza;
            }
            zzfe.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zza.zzb + 8;
            if (j <= 2147483647L) {
                ((zzact) zzadg).zzo((int) j, false);
                zza = zzapk.zza(zzadg, zzfo);
            } else {
                int i3 = zza.zza;
                throw zzcc.zzc("Chunk is too large (~2GB+) to skip; id: " + i3);
            }
        }
    }
}
