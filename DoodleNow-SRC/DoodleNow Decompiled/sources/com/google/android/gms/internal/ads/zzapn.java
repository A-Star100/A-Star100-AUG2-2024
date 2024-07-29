package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzapn implements zzadf {
    private final zzfo zza = new zzfo(4);
    private final zzaeh zzb = new zzaeh(-1, -1, "image/webp");

    public final int zzb(zzadg zzadg, zzaec zzaec) throws IOException {
        return this.zzb.zzb(zzadg, zzaec);
    }

    public final /* synthetic */ List zzc() {
        return zzfzn.zzm();
    }

    public final void zzd(zzadi zzadi) {
        this.zzb.zzd(zzadi);
    }

    public final void zze(long j, long j2) {
        this.zzb.zze(j, j2);
    }

    public final boolean zzf(zzadg zzadg) throws IOException {
        this.zza.zzH(4);
        zzact zzact = (zzact) zzadg;
        zzact.zzm(this.zza.zzM(), 0, 4, false);
        if (this.zza.zzu() == 1380533830) {
            zzact.zzl(4, false);
            this.zza.zzH(4);
            zzact.zzm(this.zza.zzM(), 0, 4, false);
            if (this.zza.zzu() == 1464156752) {
                return true;
            }
        }
        return false;
    }
}
