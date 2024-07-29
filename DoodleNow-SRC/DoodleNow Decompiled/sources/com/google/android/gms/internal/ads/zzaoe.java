package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaoe implements zzaon {
    private zzam zza;
    private zzfv zzb;
    private zzaem zzc;

    public zzaoe(String str) {
        zzak zzak = new zzak();
        zzak.zzW(str);
        this.zza = zzak.zzac();
    }

    public final void zza(zzfo zzfo) {
        zzek.zzb(this.zzb);
        int i = zzfx.zza;
        long zze = this.zzb.zze();
        long zzf = this.zzb.zzf();
        if (zze != C.TIME_UNSET && zzf != C.TIME_UNSET) {
            zzam zzam = this.zza;
            if (zzf != zzam.zzq) {
                zzak zzb2 = zzam.zzb();
                zzb2.zzaa(zzf);
                zzam zzac = zzb2.zzac();
                this.zza = zzac;
                this.zzc.zzl(zzac);
            }
            int zzb3 = zzfo.zzb();
            this.zzc.zzq(zzfo, zzb3);
            this.zzc.zzs(zze, 1, zzb3, 0, (zzael) null);
        }
    }

    public final void zzb(zzfv zzfv, zzadi zzadi, zzapa zzapa) {
        this.zzb = zzfv;
        zzapa.zzc();
        zzaem zzw = zzadi.zzw(zzapa.zza(), 5);
        this.zzc = zzw;
        zzw.zzl(this.zza);
    }
}
