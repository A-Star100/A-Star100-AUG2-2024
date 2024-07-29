package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzapd {
    private final List zza;
    private final zzaem[] zzb;

    public zzapd(List list) {
        this.zza = list;
        this.zzb = new zzaem[list.size()];
    }

    public final void zza(long j, zzfo zzfo) {
        if (zzfo.zzb() >= 9) {
            int zzg = zzfo.zzg();
            int zzg2 = zzfo.zzg();
            int zzm = zzfo.zzm();
            if (zzg == 434 && zzg2 == 1195456820 && zzm == 3) {
                zzacq.zzb(j, zzfo, this.zzb);
            }
        }
    }

    public final void zzb(zzadi zzadi, zzapa zzapa) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzapa.zzc();
            zzaem zzw = zzadi.zzw(zzapa.zza(), 3);
            zzam zzam = (zzam) this.zza.get(i);
            String str = zzam.zzm;
            boolean z = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                z = false;
            }
            zzek.zze(z, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            zzak zzak = new zzak();
            zzak.zzK(zzapa.zzb());
            zzak.zzW(str);
            zzak.zzY(zzam.zze);
            zzak.zzN(zzam.zzd);
            zzak.zzw(zzam.zzE);
            zzak.zzL(zzam.zzo);
            zzw.zzl(zzak.zzac());
            this.zzb[i] = zzw;
        }
    }
}
