package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaol {
    private final zzano zza;
    private final zzfv zzb;
    private final zzfn zzc = new zzfn(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzaol(zzano zzano, zzfv zzfv) {
        this.zza = zzano;
        this.zzb = zzfv;
    }

    public final void zza(zzfo zzfo) throws zzcc {
        long j;
        long j2;
        zzfo zzfo2 = zzfo;
        zzfo2.zzG(this.zzc.zza, 0, 3);
        this.zzc.zzk(0);
        this.zzc.zzm(8);
        this.zzd = this.zzc.zzo();
        this.zze = this.zzc.zzo();
        this.zzc.zzm(6);
        zzfn zzfn = this.zzc;
        zzfo2.zzG(zzfn.zza, 0, zzfn.zzd(8));
        this.zzc.zzk(0);
        if (this.zzd) {
            this.zzc.zzm(4);
            long zzd2 = (long) this.zzc.zzd(3);
            this.zzc.zzm(1);
            int zzd3 = this.zzc.zzd(15) << 15;
            this.zzc.zzm(1);
            long zzd4 = (long) this.zzc.zzd(15);
            this.zzc.zzm(1);
            if (this.zzf || !this.zze) {
                j2 = zzd2;
            } else {
                this.zzc.zzm(4);
                this.zzc.zzm(1);
                this.zzc.zzm(1);
                j2 = zzd2;
                this.zzc.zzm(1);
                this.zzb.zzb(((long) (this.zzc.zzd(15) << 15)) | (((long) this.zzc.zzd(3)) << 30) | ((long) this.zzc.zzd(15)));
                this.zzf = true;
            }
            j = this.zzb.zzb((j2 << 30) | ((long) zzd3) | zzd4);
        } else {
            j = 0;
        }
        this.zza.zzd(j, 4);
        this.zza.zza(zzfo2);
        this.zza.zzc(false);
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
