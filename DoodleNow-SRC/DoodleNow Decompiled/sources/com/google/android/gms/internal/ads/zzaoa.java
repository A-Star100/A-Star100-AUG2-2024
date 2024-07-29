package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaoa implements zzano {
    private final zzfo zza = new zzfo(10);
    private zzaem zzb;
    private boolean zzc;
    private long zzd = C.TIME_UNSET;
    private int zze;
    private int zzf;

    public final void zza(zzfo zzfo) {
        zzek.zzb(this.zzb);
        if (this.zzc) {
            int zzb2 = zzfo.zzb();
            int i = this.zzf;
            if (i < 10) {
                int min = Math.min(zzb2, 10 - i);
                System.arraycopy(zzfo.zzM(), zzfo.zzd(), this.zza.zzM(), this.zzf, min);
                if (this.zzf + min == 10) {
                    this.zza.zzK(0);
                    if (this.zza.zzm() == 73 && this.zza.zzm() == 68 && this.zza.zzm() == 51) {
                        this.zza.zzL(3);
                        this.zze = this.zza.zzl() + 10;
                    } else {
                        zzfe.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(zzb2, this.zze - this.zzf);
            this.zzb.zzq(zzfo, min2);
            this.zzf += min2;
        }
    }

    public final void zzb(zzadi zzadi, zzapa zzapa) {
        zzapa.zzc();
        zzaem zzw = zzadi.zzw(zzapa.zza(), 5);
        this.zzb = zzw;
        zzak zzak = new zzak();
        zzak.zzK(zzapa.zzb());
        zzak.zzW(MimeTypes.APPLICATION_ID3);
        zzw.zzl(zzak.zzac());
    }

    public final void zzc(boolean z) {
        int i;
        zzek.zzb(this.zzb);
        if (this.zzc && (i = this.zze) != 0 && this.zzf == i) {
            zzek.zzf(this.zzd != C.TIME_UNSET);
            this.zzb.zzs(this.zzd, 1, this.zze, 0, (zzael) null);
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzd = j;
            this.zze = 0;
            this.zzf = 0;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
    }
}
