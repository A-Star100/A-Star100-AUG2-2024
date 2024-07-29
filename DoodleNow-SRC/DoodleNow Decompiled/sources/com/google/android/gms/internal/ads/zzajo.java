package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzajo {
    public final zzaem zza;
    public final zzakd zzb = new zzakd();
    public final zzfo zzc = new zzfo();
    public zzake zzd;
    public zzajk zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzfo zzj = new zzfo(1);
    private final zzfo zzk = new zzfo();
    /* access modifiers changed from: private */
    public boolean zzl;

    public zzajo(zzaem zzaem, zzake zzake, zzajk zzajk) {
        this.zza = zzaem;
        this.zzd = zzake;
        this.zze = zzajk;
        zzh(zzake, zzajk);
    }

    public final int zza() {
        int i;
        if (!this.zzl) {
            i = this.zzd.zzg[this.zzf];
        } else {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzfo zzfo;
        zzakc zzf2 = zzf();
        if (zzf2 == null) {
            return 0;
        }
        int i3 = zzf2.zzd;
        if (i3 != 0) {
            zzfo = this.zzb.zzn;
        } else {
            byte[] bArr = zzf2.zze;
            int i4 = zzfx.zza;
            zzfo zzfo2 = this.zzk;
            int length = bArr.length;
            zzfo2.zzI(bArr, length);
            zzfo = this.zzk;
            i3 = length;
        }
        boolean zzb2 = this.zzb.zzb(this.zzf);
        boolean z = zzb2 || i2 != 0;
        zzfo zzfo3 = this.zzj;
        zzfo3.zzM()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzfo3.zzK(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzfo, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zzb2) {
            this.zzc.zzH(8);
            zzfo zzfo4 = this.zzc;
            byte[] zzM = zzfo4.zzM();
            zzM[0] = 0;
            zzM[1] = 1;
            zzM[2] = 0;
            zzM[3] = (byte) i2;
            zzM[4] = (byte) ((i >> 24) & 255);
            zzM[5] = (byte) ((i >> 16) & 255);
            zzM[6] = (byte) ((i >> 8) & 255);
            zzM[7] = (byte) (i & 255);
            this.zza.zzr(zzfo4, 8, 1);
            return i3 + 9;
        }
        int i5 = i3 + 1;
        zzfo zzfo5 = this.zzb.zzn;
        int zzq = zzfo5.zzq();
        zzfo5.zzL(-2);
        int i6 = (zzq * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzH(i6);
            byte[] zzM2 = this.zzc.zzM();
            zzfo5.zzG(zzM2, 0, i6);
            int i7 = (((zzM2[2] & 255) << 8) | (zzM2[3] & 255)) + i2;
            zzM2[2] = (byte) ((i7 >> 8) & 255);
            zzM2[3] = (byte) (i7 & 255);
            zzfo5 = this.zzc;
        }
        this.zza.zzr(zzfo5, i6, 1);
        return i5 + i6;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzakd zzakd = this.zzb;
        return zzakd.zzi[this.zzf];
    }

    public final zzakc zzf() {
        if (!this.zzl) {
            return null;
        }
        zzajk zzajk = this.zzb.zza;
        int i = zzfx.zza;
        int i2 = zzajk.zza;
        zzakc zzakc = this.zzb.zzm;
        if (zzakc == null) {
            zzakc = this.zzd.zza.zza(i2);
        }
        if (zzakc == null || !zzakc.zza) {
            return null;
        }
        return zzakc;
    }

    public final void zzh(zzake zzake, zzajk zzajk) {
        this.zzd = zzake;
        this.zze = zzajk;
        this.zza.zzl(zzake.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzakd zzakd = this.zzb;
        zzakd.zzd = 0;
        zzakd.zzp = 0;
        zzakd.zzq = false;
        zzakd.zzk = false;
        zzakd.zzo = false;
        zzakd.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
