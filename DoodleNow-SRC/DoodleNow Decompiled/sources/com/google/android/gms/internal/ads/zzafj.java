package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzafj implements zzaco {
    private final zzads zza;
    private final int zzb;
    private final zzadn zzc = new zzadn();

    /* synthetic */ zzafj(zzads zzads, int i, zzafi zzafi) {
        this.zza = zzads;
        this.zzb = i;
    }

    private final long zzc(zzadg zzadg) throws IOException {
        while (zzadg.zze() < zzadg.zzd() - 6) {
            zzads zzads = this.zza;
            int i = this.zzb;
            zzadn zzadn = this.zzc;
            long zze = zzadg.zze();
            byte[] bArr = new byte[2];
            zzact zzact = (zzact) zzadg;
            zzact.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzadg.zzj();
                zzact.zzl((int) (zze - zzadg.zzf()), false);
            } else {
                zzfo zzfo = new zzfo(16);
                System.arraycopy(bArr, 0, zzfo.zzM(), 0, 2);
                zzfo.zzJ(zzadj.zza(zzadg, zzfo.zzM(), 2, 14));
                zzadg.zzj();
                zzact.zzl((int) (zze - zzadg.zzf()), false);
                if (zzado.zzc(zzfo, zzads, i, zzadn)) {
                    break;
                }
            }
            zzact.zzl(1, false);
        }
        if (zzadg.zze() < zzadg.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzact) zzadg).zzl((int) (zzadg.zzd() - zzadg.zze()), false);
        return this.zza.zzj;
    }

    public final zzacn zza(zzadg zzadg, long j) throws IOException {
        int i = this.zza.zzc;
        long zzf = zzadg.zzf();
        long zzc2 = zzc(zzadg);
        long zze = zzadg.zze();
        ((zzact) zzadg).zzl(Math.max(6, i), false);
        int i2 = (zzc2 > j ? 1 : (zzc2 == j ? 0 : -1));
        long zzc3 = zzc(zzadg);
        long zze2 = zzadg.zze();
        if (i2 > 0 || zzc3 <= j) {
            return zzc3 <= j ? zzacn.zzf(zzc3, zze2) : zzacn.zzd(zzc2, zzf);
        }
        return zzacn.zze(zze);
    }

    public final /* synthetic */ void zzb() {
    }
}
