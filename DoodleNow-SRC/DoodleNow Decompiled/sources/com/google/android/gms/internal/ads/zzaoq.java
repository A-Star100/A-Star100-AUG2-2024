package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaoq implements zzaco {
    private final zzfv zza;
    private final zzfo zzb = new zzfo();
    private final int zzc;

    public zzaoq(int i, zzfv zzfv, int i2) {
        this.zzc = i;
        this.zza = zzfv;
    }

    public final zzacn zza(zzadg zzadg, long j) throws IOException {
        int zza2;
        int i;
        long zzf = zzadg.zzf();
        int min = (int) Math.min(112800, zzadg.zzd() - zzf);
        this.zzb.zzH(min);
        ((zzact) zzadg).zzm(this.zzb.zzM(), 0, min, false);
        zzfo zzfo = this.zzb;
        int zze = zzfo.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzfo.zzb() >= 188 && (i = zza2 + TsExtractor.TS_PACKET_SIZE) <= zze) {
            long zzb2 = zzapc.zzb(zzfo, (zza2 = zzapc.zza(zzfo.zzM(), zzfo.zzd(), zze)), this.zzc);
            if (zzb2 != C.TIME_UNSET) {
                long zzb3 = this.zza.zzb(zzb2);
                if (zzb3 <= j) {
                    j4 = (long) zza2;
                    if (100000 + zzb3 <= j) {
                        j3 = zzb3;
                    }
                } else if (j3 == C.TIME_UNSET) {
                    return zzacn.zzd(zzb3, zzf);
                }
                return zzacn.zze(zzf + j4);
            }
            zzfo.zzK(i);
            j2 = (long) i;
        }
        return j3 != C.TIME_UNSET ? zzacn.zzf(j3, zzf + j2) : zzacn.zza;
    }

    public final void zzb() {
        byte[] bArr = zzfx.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
