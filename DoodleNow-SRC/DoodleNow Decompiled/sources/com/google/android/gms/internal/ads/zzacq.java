package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzacq {
    public static void zza(long j, zzfo zzfo, zzaem[] zzaemArr) {
        int i;
        while (true) {
            boolean z = true;
            if (zzfo.zzb() > 1) {
                int zzc = zzc(zzfo);
                int zzc2 = zzc(zzfo);
                int zzd = zzfo.zzd() + zzc2;
                if (zzc2 == -1 || zzc2 > zzfo.zzb()) {
                    zzfe.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzd = zzfo.zze();
                } else if (zzc == 4 && zzc2 >= 8) {
                    int zzm = zzfo.zzm();
                    int zzq = zzfo.zzq();
                    if (zzq == 49) {
                        i = zzfo.zzg();
                        zzq = 49;
                    } else {
                        i = 0;
                    }
                    int zzm2 = zzfo.zzm();
                    if (zzq == 47) {
                        zzfo.zzL(1);
                        zzq = 47;
                    }
                    boolean z2 = zzm == 181 && (zzq == 49 || zzq == 47) && zzm2 == 3;
                    if (zzq == 49) {
                        if (i != 1195456820) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        zzb(j, zzfo, zzaemArr);
                    }
                }
                zzfo.zzK(zzd);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j, zzfo zzfo, zzaem[] zzaemArr) {
        zzfo zzfo2 = zzfo;
        zzaem[] zzaemArr2 = zzaemArr;
        int zzm = zzfo.zzm();
        if ((zzm & 64) != 0) {
            int i = zzm & 31;
            zzfo2.zzL(1);
            int zzd = zzfo.zzd();
            for (zzaem zzaem : zzaemArr2) {
                int i2 = i * 3;
                zzfo2.zzK(zzd);
                zzaem.zzq(zzfo2, i2);
                zzek.zzf(j != C.TIME_UNSET);
                zzaem.zzs(j, 1, i2, 0, (zzael) null);
            }
        }
    }

    private static int zzc(zzfo zzfo) {
        int i = 0;
        while (zzfo.zzb() != 0) {
            int zzm = zzfo.zzm();
            i += zzm;
            if (zzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
