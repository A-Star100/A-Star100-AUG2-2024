package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzako {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzfo zzg = new zzfo(255);

    zzako() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzadg zzadg, boolean z) throws IOException {
        zza();
        this.zzg.zzH(27);
        if (zzadj.zzc(zzadg, this.zzg.zzM(), 0, 27, z) && this.zzg.zzu() == 1332176723) {
            if (this.zzg.zzm() == 0) {
                this.zza = this.zzg.zzm();
                this.zzb = this.zzg.zzr();
                this.zzg.zzs();
                this.zzg.zzs();
                this.zzg.zzs();
                int zzm = this.zzg.zzm();
                this.zzc = zzm;
                this.zzd = zzm + 27;
                this.zzg.zzH(zzm);
                if (zzadj.zzc(zzadg, this.zzg.zzM(), 0, this.zzc, z)) {
                    for (int i = 0; i < this.zzc; i++) {
                        this.zzf[i] = this.zzg.zzm();
                        this.zze += this.zzf[i];
                    }
                    return true;
                }
            } else if (z) {
                return false;
            } else {
                throw zzcc.zzc("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean zzc(zzadg zzadg, long j) throws IOException {
        int i;
        zzek.zzd(zzadg.zzf() == zzadg.zze());
        this.zzg.zzH(4);
        while (true) {
            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if ((i == 0 || zzadg.zzf() + 4 < j) && zzadj.zzc(zzadg, this.zzg.zzM(), 0, 4, true)) {
                this.zzg.zzK(0);
                if (this.zzg.zzu() != 1332176723) {
                    ((zzact) zzadg).zzo(1, false);
                } else {
                    zzadg.zzj();
                    return true;
                }
            }
        }
        do {
            if ((i != 0 && zzadg.zzf() >= j) || zzadg.zzc(1) == -1) {
                return false;
            }
            break;
        } while (zzadg.zzc(1) == -1);
        return false;
    }
}
