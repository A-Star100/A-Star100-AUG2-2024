package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzakm implements zzadf {
    public static final zzadm zza = zzakl.zza;
    private zzadi zzb;
    private zzaku zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zza(zzadg zzadg) throws IOException {
        zzako zzako = new zzako();
        if (zzako.zzb(zzadg, true) && (zzako.zza & 2) == 2) {
            int min = Math.min(zzako.zze, 8);
            zzfo zzfo = new zzfo(min);
            ((zzact) zzadg).zzm(zzfo.zzM(), 0, min, false);
            zzfo.zzK(0);
            if (zzfo.zzb() >= 5 && zzfo.zzm() == 127 && zzfo.zzu() == 1179402563) {
                this.zzc = new zzakk();
            } else {
                zzfo.zzK(0);
                try {
                    if (zzaes.zzd(1, zzfo, true)) {
                        this.zzc = new zzakw();
                    }
                } catch (zzcc unused) {
                }
                zzfo.zzK(0);
                if (zzakq.zzd(zzfo)) {
                    this.zzc = new zzakq();
                }
            }
            return true;
        }
        return false;
    }

    public final int zzb(zzadg zzadg, zzaec zzaec) throws IOException {
        zzek.zzb(this.zzb);
        if (this.zzc == null) {
            if (zza(zzadg)) {
                zzadg.zzj();
            } else {
                throw zzcc.zza("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzd) {
            zzaem zzw = this.zzb.zzw(0, 1);
            this.zzb.zzD();
            this.zzc.zzh(this.zzb, zzw);
            this.zzd = true;
        }
        return this.zzc.zze(zzadg, zzaec);
    }

    public final /* synthetic */ List zzc() {
        return zzfzn.zzm();
    }

    public final void zzd(zzadi zzadi) {
        this.zzb = zzadi;
    }

    public final void zze(long j, long j2) {
        zzaku zzaku = this.zzc;
        if (zzaku != null) {
            zzaku.zzj(j, j2);
        }
    }

    public final boolean zzf(zzadg zzadg) throws IOException {
        try {
            return zza(zzadg);
        } catch (zzcc unused) {
            return false;
        }
    }
}
