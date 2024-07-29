package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaou implements zzaon {
    final /* synthetic */ zzaow zza;
    private final zzfn zzb = new zzfn(new byte[4], 4);

    public zzaou(zzaow zzaow) {
        this.zza = zzaow;
    }

    public final void zza(zzfo zzfo) {
        if (zzfo.zzm() == 0 && (zzfo.zzm() & 128) != 0) {
            zzfo.zzL(6);
            int zzb2 = zzfo.zzb() / 4;
            for (int i = 0; i < zzb2; i++) {
                zzfo.zzF(this.zzb, 4);
                zzfn zzfn = this.zzb;
                int zzd = zzfn.zzd(16);
                zzfn.zzm(3);
                if (zzd == 0) {
                    this.zzb.zzm(13);
                } else {
                    int zzd2 = this.zzb.zzd(13);
                    if (this.zza.zzg.get(zzd2) == null) {
                        zzaow zzaow = this.zza;
                        zzaow.zzg.put(zzd2, new zzaoo(new zzaov(zzaow, zzd2)));
                        zzaow zzaow2 = this.zza;
                        zzaow2.zzm = zzaow2.zzm + 1;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    public final void zzb(zzfv zzfv, zzadi zzadi, zzapa zzapa) {
    }
}
