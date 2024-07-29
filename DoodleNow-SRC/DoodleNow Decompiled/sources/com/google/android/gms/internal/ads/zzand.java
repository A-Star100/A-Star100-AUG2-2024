package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzand implements zzadf {
    public static final zzadm zza = zzanc.zza;
    private final zzane zzb = new zzane((String) null, 0);
    private final zzfo zzc = new zzfo(2786);
    private boolean zzd;

    public final int zzb(zzadg zzadg, zzaec zzaec) throws IOException {
        int zza2 = zzadg.zza(this.zzc.zzM(), 0, 2786);
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
        zzfo zzfo = new zzfo(10);
        int i = 0;
        while (true) {
            zzact = (zzact) zzadg;
            zzact.zzm(zzfo.zzM(), 0, 10, false);
            zzfo.zzK(0);
            if (zzfo.zzo() != 4801587) {
                break;
            }
            zzfo.zzL(3);
            int zzl = zzfo.zzl();
            i += zzl + 10;
            zzact.zzl(zzl, false);
        }
        zzadg.zzj();
        zzact.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzact.zzm(zzfo.zzM(), 0, 6, false);
            zzfo.zzK(0);
            if (zzfo.zzq() != 2935) {
                zzadg.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzact.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int zzb2 = zzace.zzb(zzfo.zzM());
                if (zzb2 == -1) {
                    return false;
                }
                zzact.zzl(zzb2 - 6, false);
            }
        }
    }
}
