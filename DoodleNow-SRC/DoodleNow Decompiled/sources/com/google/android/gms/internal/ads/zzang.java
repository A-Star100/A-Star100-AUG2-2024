package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzang implements zzadf {
    public static final zzadm zza = zzanf.zza;
    private final zzanh zzb = new zzanh((String) null, 0);
    private final zzfo zzc = new zzfo(16384);
    private boolean zzd;

    public final int zzb(zzadg zzadg, zzaec zzaec) throws IOException {
        int zza2 = zzadg.zza(this.zzc.zzM(), 0, 16384);
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzK(0);
        this.zzc.zzJ(zza2);
        if (!this.zzd) {
            this.zzb.zzd(0, 4);
            this.zzd = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final /* synthetic */ List zzc() {
        return zzfzn.zzm();
    }

    public final void zzd(zzadi zzadi) {
        this.zzb.zzb(zzadi, new zzapa(Integer.MIN_VALUE, 0, 1));
        zzadi.zzD();
        zzadi.zzO(new zzaee(C.TIME_UNSET, 0));
    }

    public final void zze(long j, long j2) {
        this.zzd = false;
        this.zzb.zze();
    }

    public final boolean zzf(zzadg zzadg) throws IOException {
        zzact zzact;
        int i;
        zzfo zzfo = new zzfo(10);
        int i2 = 0;
        while (true) {
            zzact = (zzact) zzadg;
            zzact.zzm(zzfo.zzM(), 0, 10, false);
            zzfo.zzK(0);
            if (zzfo.zzo() != 4801587) {
                break;
            }
            zzfo.zzL(3);
            int zzl = zzfo.zzl();
            i2 += zzl + 10;
            zzact.zzl(zzl, false);
        }
        zzadg.zzj();
        zzact.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzact.zzm(zzfo.zzM(), 0, 7, false);
            zzfo.zzK(0);
            int zzq = zzfo.zzq();
            if (zzq == 44096 || zzq == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] zzM = zzfo.zzM();
                int i6 = zzach.zza;
                if (zzM.length < 7) {
                    i = -1;
                } else {
                    byte b = ((zzM[2] & 255) << 8) | (zzM[3] & 255);
                    if (b == 65535) {
                        b = ((zzM[4] & 255) << Ascii.DLE) | ((zzM[5] & 255) << 8) | (zzM[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (zzq == 44097) {
                        i5 += 2;
                    }
                    i = b + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzact.zzl(i - 7, false);
            } else {
                zzadg.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzact.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
