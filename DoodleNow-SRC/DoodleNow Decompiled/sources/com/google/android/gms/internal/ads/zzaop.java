package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaop {
    private final List zza;
    private final zzaem[] zzb;

    public zzaop(List list) {
        this.zza = list;
        this.zzb = new zzaem[list.size()];
    }

    public final void zza(long j, zzfo zzfo) {
        zzacq.zza(j, zzfo, this.zzb);
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
            String str2 = zzam.zzb;
            if (str2 == null) {
                str2 = zzapa.zzb();
            }
            zzak zzak = new zzak();
            zzak.zzK(str2);
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
