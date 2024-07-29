package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaeh implements zzadf {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzadi zzf;
    private zzaem zzg;

    public zzaeh(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    public final /* synthetic */ List zzc() {
        return zzfzn.zzm();
    }

    public final void zzd(zzadi zzadi) {
        this.zzf = zzadi;
        zzaem zzw = zzadi.zzw(1024, 4);
        this.zzg = zzw;
        zzak zzak = new zzak();
        zzak.zzW(this.zzc);
        zzw.zzl(zzak.zzac());
        this.zzf.zzD();
        this.zzf.zzO(new zzaei(C.TIME_UNSET));
        this.zze = 1;
    }

    public final void zze(long j, long j2) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    public final boolean zzf(zzadg zzadg) throws IOException {
        zzek.zzf((this.zza == -1 || this.zzb == -1) ? false : true);
        zzfo zzfo = new zzfo(this.zzb);
        ((zzact) zzadg).zzm(zzfo.zzM(), 0, this.zzb, false);
        return zzfo.zzq() == this.zza;
    }

    public final int zzb(zzadg zzadg, zzaec zzaec) throws IOException {
        int i = this.zze;
        if (i == 1) {
            zzaem zzaem = this.zzg;
            zzaem.getClass();
            int zza2 = zzaek.zza(zzaem, zzadg, 1024, true);
            if (zza2 == -1) {
                this.zze = 2;
                this.zzg.zzs(0, 1, this.zzd, 0, (zzael) null);
                this.zzd = 0;
            } else {
                this.zzd += zza2;
            }
            return 0;
        } else if (i == 2) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }
}
