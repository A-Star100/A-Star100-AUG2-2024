package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzann implements zzano {
    private final List zza;
    private final zzaem[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = C.TIME_UNSET;

    public zzann(List list) {
        this.zza = list;
        this.zzb = new zzaem[list.size()];
    }

    private final boolean zzf(zzfo zzfo, int i) {
        if (zzfo.zzb() == 0) {
            return false;
        }
        if (zzfo.zzm() != i) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza(zzfo zzfo) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzfo, 32)) {
            if (this.zzd != 1 || zzf(zzfo, 0)) {
                int zzd2 = zzfo.zzd();
                int zzb2 = zzfo.zzb();
                zzaem[] zzaemArr = this.zzb;
                for (zzaem zzq : zzaemArr) {
                    zzfo.zzK(zzd2);
                    zzq.zzq(zzfo, zzb2);
                }
                this.zze += zzb2;
            }
        }
    }

    public final void zzb(zzadi zzadi, zzapa zzapa) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzaox zzaox = (zzaox) this.zza.get(i);
            zzapa.zzc();
            zzaem zzw = zzadi.zzw(zzapa.zza(), 3);
            zzak zzak = new zzak();
            zzak.zzK(zzapa.zzb());
            zzak.zzW(MimeTypes.APPLICATION_DVBSUBS);
            zzak.zzL(Collections.singletonList(zzaox.zzb));
            zzak.zzN(zzaox.zza);
            zzw.zzl(zzak.zzac());
            this.zzb[i] = zzw;
        }
    }

    public final void zzc(boolean z) {
        if (this.zzc) {
            zzek.zzf(this.zzf != C.TIME_UNSET);
            zzaem[] zzaemArr = this.zzb;
            for (zzaem zzs : zzaemArr) {
                zzs.zzs(this.zzf, 1, this.zze, 0, (zzael) null);
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzf = j;
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzf = C.TIME_UNSET;
    }
}
