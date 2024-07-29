package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaft extends zzafs {
    private final zzfo zzb = new zzfo(zzgl.zza);
    private final zzfo zzc = new zzfo(4);
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzaft(zzaem zzaem) {
        super(zzaem);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfo zzfo) throws zzafr {
        int zzm = zzfo.zzm();
        int i = zzm >> 4;
        int i2 = zzm & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzafr("Video format not supported: " + i2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfo zzfo, long j) throws zzcc {
        int i;
        zzfo zzfo2 = zzfo;
        int zzm = zzfo.zzm();
        long zzh = (long) zzfo.zzh();
        if (zzm == 0) {
            if (!this.zze) {
                zzfo zzfo3 = new zzfo(new byte[zzfo.zzb()]);
                zzfo2.zzG(zzfo3.zzM(), 0, zzfo.zzb());
                zzaci zza = zzaci.zza(zzfo3);
                this.zzd = zza.zzb;
                zzak zzak = new zzak();
                zzak.zzW(MimeTypes.VIDEO_H264);
                zzak.zzz(zza.zzk);
                zzak.zzab(zza.zzc);
                zzak.zzI(zza.zzd);
                zzak.zzS(zza.zzj);
                zzak.zzL(zza.zza);
                this.zza.zzl(zzak.zzac());
                this.zze = true;
                return false;
            }
        } else if (zzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            byte[] zzM = this.zzc.zzM();
            zzM[0] = 0;
            zzM[1] = 0;
            zzM[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzfo.zzb() > 0) {
                zzfo2.zzG(this.zzc.zzM(), i3, this.zzd);
                this.zzc.zzK(0);
                zzfo zzfo4 = this.zzc;
                zzfo zzfo5 = this.zzb;
                int zzp = zzfo4.zzp();
                zzfo5.zzK(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzfo2, zzp);
                i4 = i4 + 4 + zzp;
            }
            this.zza.zzs(j + (zzh * 1000), i, i4, 0, (zzael) null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
