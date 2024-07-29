package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzanj implements zzadf {
    public static final zzadm zza = zzani.zza;
    private final zzank zzb;
    private final zzfo zzc;
    private final zzfo zzd;
    private final zzfn zze;
    private zzadi zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;

    public zzanj() {
        this(0);
    }

    public final int zzb(zzadg zzadg, zzaec zzaec) throws IOException {
        zzek.zzb(this.zzf);
        int zza2 = zzadg.zza(this.zzc.zzM(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzO(new zzaee(C.TIME_UNSET, 0));
            this.zzj = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzK(0);
        this.zzc.zzJ(zza2);
        if (!this.zzi) {
            this.zzb.zzd(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final /* synthetic */ List zzc() {
        return zzfzn.zzm();
    }

    public final void zzd(zzadi zzadi) {
        this.zzf = zzadi;
        this.zzb.zzb(zzadi, new zzapa(Integer.MIN_VALUE, 0, 1));
        zzadi.zzD();
    }

    public final void zze(long j, long j2) {
        this.zzi = false;
        this.zzb.zze();
        this.zzg = j2;
    }

    public final boolean zzf(zzadg zzadg) throws IOException {
        zzact zzact;
        int i = 0;
        while (true) {
            zzact = (zzact) zzadg;
            zzact.zzm(this.zzd.zzM(), 0, 10, false);
            this.zzd.zzK(0);
            if (this.zzd.zzo() != 4801587) {
                break;
            }
            this.zzd.zzL(3);
            int zzl = this.zzd.zzl();
            i += zzl + 10;
            zzact.zzl(zzl, false);
        }
        zzadg.zzj();
        zzact.zzl(i, false);
        if (this.zzh == -1) {
            this.zzh = (long) i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzact.zzm(this.zzd.zzM(), 0, 2, false);
            this.zzd.zzK(0);
            if (!zzank.zzf(this.zzd.zzq())) {
                i4++;
                zzadg.zzj();
                zzact.zzl(i4, false);
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzact.zzm(this.zzd.zzM(), 0, 4, false);
                this.zze.zzk(14);
                int zzd2 = this.zze.zzd(13);
                if (zzd2 <= 6) {
                    i4++;
                    zzadg.zzj();
                    zzact.zzl(i4, false);
                } else {
                    zzact.zzl(zzd2 - 6, false);
                    i3 += zzd2;
                }
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }

    public zzanj(int i) {
        this.zzb = new zzank(true, (String) null, 0);
        this.zzc = new zzfo(2048);
        this.zzh = -1;
        zzfo zzfo = new zzfo(10);
        this.zzd = zzfo;
        byte[] zzM = zzfo.zzM();
        this.zze = new zzfn(zzM, zzM.length);
    }
}
