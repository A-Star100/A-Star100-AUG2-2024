package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzli {
    public final zzvf zza;
    public final Object zzb;
    public final zzwy[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzlj zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzmh[] zzi;
    private final zzzf zzj;
    private final zzlx zzk;
    private zzli zzl;
    private zzxk zzm = zzxk.zza;
    private zzzg zzn;
    private long zzo;

    public zzli(zzmh[] zzmhArr, long j, zzzf zzzf, zzzo zzzo, zzlx zzlx, zzlj zzlj, zzzg zzzg) {
        this.zzi = zzmhArr;
        this.zzo = j;
        this.zzj = zzzf;
        this.zzk = zzlx;
        this.zzb = zzlj.zza.zza;
        this.zzf = zzlj;
        this.zzn = zzzg;
        this.zzc = new zzwy[2];
        this.zzh = new boolean[2];
        zzvh zzvh = zzlj.zza;
        long j2 = zzlj.zzb;
        long j3 = zzlj.zzd;
        zzvf zzp = zzlx.zzp(zzvh, zzzo, j2);
        this.zza = j3 != C.TIME_UNSET ? new zzul(zzp, true, 0, j3) : zzp;
    }

    private final void zzs() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzzg zzzg = this.zzn;
                if (i < zzzg.zza) {
                    zzzg.zzb(i);
                    zzyz zzyz = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzzg zzzg = this.zzn;
                if (i < zzzg.zza) {
                    zzzg.zzb(i);
                    zzyz zzyz = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzzg zzzg, long j, boolean z) {
        return zzb(zzzg, j, false, new boolean[2]);
    }

    public final long zzb(zzzg zzzg, long j, boolean z, boolean[] zArr) {
        zzzg zzzg2 = zzzg;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzzg2.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzzg.zza(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzmh[] zzmhArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzmhArr[i2].zzb();
            i2++;
        }
        zzs();
        this.zzn = zzzg2;
        zzt();
        long zzf2 = this.zza.zzf(zzzg2.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzmh[] zzmhArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzmhArr2[i3].zzb();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzwy[] zzwyArr = this.zzc;
            if (i4 >= 2) {
                return zzf2;
            }
            if (zzwyArr[i4] != null) {
                zzek.zzf(zzzg.zzb(i4));
                this.zzi[i4].zzb();
                this.zze = true;
            } else {
                zzek.zzf(zzzg2.zzc[i4] == null);
            }
            i4++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long zzb2 = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return zzb2 == Long.MIN_VALUE ? this.zzf.zze : zzb2;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzli zzg() {
        return this.zzl;
    }

    public final zzxk zzh() {
        return this.zzm;
    }

    public final zzzg zzi() {
        return this.zzn;
    }

    public final zzzg zzj(float f, zzcx zzcx) throws zziz {
        zzzg zzp = this.zzj.zzp(this.zzi, this.zzm, this.zzf.zza, zzcx);
        for (zzyz zzyz : zzp.zzc) {
        }
        return zzp;
    }

    public final void zzk(long j, float f, long j2) {
        zzek.zzf(zzu());
        long j3 = j - this.zzo;
        zzle zzle = new zzle();
        zzle.zze(j3);
        zzle.zzf(f);
        zzle.zzd(j2);
        this.zza.zzo(new zzlg(zzle, (zzlf) null));
    }

    public final void zzl(float f, zzcx zzcx) throws zziz {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzzg zzj2 = zzj(f, zzcx);
        zzlj zzlj = this.zzf;
        long j = zzlj.zzb;
        long j2 = zzlj.zze;
        if (j2 != C.TIME_UNSET && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        long zza2 = zza(zzj2, j, false);
        long j3 = this.zzo;
        zzlj zzlj2 = this.zzf;
        this.zzo = j3 + (zzlj2.zzb - zza2);
        this.zzf = zzlj2.zzb(zza2);
    }

    public final void zzm(long j) {
        zzek.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzvf zzvf = this.zza;
        try {
            boolean z = zzvf instanceof zzul;
            zzlx zzlx = this.zzk;
            if (z) {
                zzlx.zzi(((zzul) zzvf).zza);
            } else {
                zzlx.zzi(zzvf);
            }
        } catch (RuntimeException e) {
            zzfe.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzli zzli) {
        if (zzli != this.zzl) {
            zzs();
            this.zzl = zzli;
            zzt();
        }
    }

    public final void zzp(long j) {
        this.zzo = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
    }

    public final void zzq() {
        zzvf zzvf = this.zza;
        if (zzvf instanceof zzul) {
            long j = this.zzf.zzd;
            if (j == C.TIME_UNSET) {
                j = Long.MIN_VALUE;
            }
            ((zzul) zzvf).zzn(0, j);
        }
    }

    public final boolean zzr() {
        if (!this.zzd) {
            return false;
        }
        if (this.zze) {
            return this.zza.zzb() == Long.MIN_VALUE;
        }
        return true;
    }
}
