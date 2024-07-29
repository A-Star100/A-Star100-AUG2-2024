package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzafm implements zzadf {
    public static final zzadm zza = zzafl.zza;
    private final byte[] zzb;
    private final zzfo zzc;
    private final zzadn zzd;
    private zzadi zze;
    private zzaem zzf;
    private int zzg;
    private zzby zzh;
    private zzads zzi;
    private int zzj;
    private int zzk;
    private zzafk zzl;
    private int zzm;
    private long zzn;

    public zzafm() {
        this(0);
    }

    private final void zzg() {
        zzads zzads = this.zzi;
        int i = zzfx.zza;
        this.zzf.zzs((this.zzn * 1000000) / ((long) zzads.zze), 1, this.zzm, 0, (zzael) null);
    }

    public final /* synthetic */ List zzc() {
        return zzfzn.zzm();
    }

    public final void zzd(zzadi zzadi) {
        this.zze = zzadi;
        this.zzf = zzadi.zzw(0, 1);
        zzadi.zzD();
    }

    public final void zze(long j, long j2) {
        long j3 = 0;
        if (j == 0) {
            this.zzg = 0;
        } else {
            zzafk zzafk = this.zzl;
            if (zzafk != null) {
                zzafk.zzd(j2);
            }
        }
        if (j2 != 0) {
            j3 = -1;
        }
        this.zzn = j3;
        this.zzm = 0;
        this.zzc.zzH(0);
    }

    public final boolean zzf(zzadg zzadg) throws IOException {
        zzadp.zza(zzadg, false);
        zzfo zzfo = new zzfo(4);
        ((zzact) zzadg).zzm(zzfo.zzM(), 0, 4, false);
        if (zzfo.zzu() == 1716281667) {
            return true;
        }
        return false;
    }

    public zzafm(int i) {
        this.zzb = new byte[42];
        this.zzc = new zzfo(new byte[32768], 0);
        this.zzd = new zzadn();
        this.zzg = 0;
    }

    private final long zza(zzfo zzfo, boolean z) {
        boolean z2;
        this.zzi.getClass();
        int zzd2 = zzfo.zzd();
        while (zzd2 <= zzfo.zze() - 16) {
            zzfo.zzK(zzd2);
            if (zzado.zzc(zzfo, this.zzi, this.zzk, this.zzd)) {
                zzfo.zzK(zzd2);
                return this.zzd.zza;
            }
            zzd2++;
        }
        if (z) {
            while (zzd2 <= zzfo.zze() - this.zzj) {
                zzfo.zzK(zzd2);
                try {
                    z2 = zzado.zzc(zzfo, this.zzi, this.zzk, this.zzd);
                } catch (IndexOutOfBoundsException unused) {
                    z2 = false;
                }
                if (zzfo.zzd() <= zzfo.zze() && z2) {
                    zzfo.zzK(zzd2);
                    return this.zzd.zza;
                }
                zzd2++;
            }
            zzfo.zzK(zzfo.zze());
            return -1;
        }
        zzfo.zzK(zzd2);
        return -1;
    }

    public final int zzb(zzadg zzadg, zzaec zzaec) throws IOException {
        boolean zzo;
        zzaef zzaef;
        zzadg zzadg2 = zzadg;
        int i = this.zzg;
        boolean z = true;
        if (i == 0) {
            zzadg.zzj();
            long zze2 = zzadg.zze();
            zzby zza2 = zzadp.zza(zzadg2, true);
            ((zzact) zzadg2).zzo((int) (zzadg.zze() - zze2), false);
            this.zzh = zza2;
            this.zzg = 1;
            return 0;
        } else if (i == 1) {
            ((zzact) zzadg2).zzm(this.zzb, 0, 42, false);
            zzadg.zzj();
            this.zzg = 2;
            return 0;
        } else if (i == 2) {
            zzfo zzfo = new zzfo(4);
            ((zzact) zzadg2).zzn(zzfo.zzM(), 0, 4, false);
            if (zzfo.zzu() == 1716281667) {
                this.zzg = 3;
                return 0;
            }
            throw zzcc.zza("Failed to read FLAC stream marker.", (Throwable) null);
        } else if (i == 3) {
            zzads zzads = this.zzi;
            do {
                zzadg.zzj();
                zzfn zzfn = new zzfn(new byte[4], 4);
                zzact zzact = (zzact) zzadg2;
                zzact.zzm(zzfn.zza, 0, 4, false);
                zzo = zzfn.zzo();
                int zzd2 = zzfn.zzd(7);
                int zzd3 = zzfn.zzd(24) + 4;
                if (zzd2 == 0) {
                    byte[] bArr = new byte[38];
                    zzact.zzn(bArr, 0, 38, false);
                    zzads = new zzads(bArr, 4);
                } else if (zzads == null) {
                    throw new IllegalArgumentException();
                } else if (zzd2 == 3) {
                    zzfo zzfo2 = new zzfo(zzd3);
                    zzact.zzn(zzfo2.zzM(), 0, zzd3, false);
                    zzads = zzads.zzf(zzadp.zzb(zzfo2));
                } else if (zzd2 == 4) {
                    zzfo zzfo3 = new zzfo(zzd3);
                    zzact.zzn(zzfo3.zzM(), 0, zzd3, false);
                    zzfo3.zzL(4);
                    zzads = zzads.zzg(Arrays.asList(zzaes.zzc(zzfo3, false, false).zzb));
                } else if (zzd2 == 6) {
                    zzfo zzfo4 = new zzfo(zzd3);
                    zzact.zzn(zzfo4.zzM(), 0, zzd3, false);
                    zzfo4.zzL(4);
                    zzads = zzads.zze(zzfzn.zzn(zzagi.zzb(zzfo4)));
                } else {
                    zzact.zzo(zzd3, false);
                }
                int i2 = zzfx.zza;
                this.zzi = zzads;
            } while (!zzo);
            zzads.getClass();
            this.zzj = Math.max(zzads.zzc, 6);
            this.zzf.zzl(this.zzi.zzc(this.zzb, this.zzh));
            this.zzg = 4;
            return 0;
        } else if (i != 4) {
            this.zzf.getClass();
            zzads zzads2 = this.zzi;
            zzads2.getClass();
            zzafk zzafk = this.zzl;
            if (zzafk != null && zzafk.zze()) {
                return zzafk.zza(zzadg2, zzaec);
            }
            if (this.zzn == -1) {
                this.zzn = zzado.zzb(zzadg2, zzads2);
                return 0;
            }
            zzfo zzfo5 = this.zzc;
            int zze3 = zzfo5.zze();
            if (zze3 < 32768) {
                int zza3 = zzadg2.zza(zzfo5.zzM(), zze3, 32768 - zze3);
                if (zza3 != -1) {
                    z = false;
                }
                if (!z) {
                    this.zzc.zzJ(zze3 + zza3);
                } else if (this.zzc.zzb() == 0) {
                    zzg();
                    return -1;
                }
            } else {
                z = false;
            }
            zzfo zzfo6 = this.zzc;
            int zzd4 = zzfo6.zzd();
            int i3 = this.zzm;
            int i4 = this.zzj;
            if (i3 < i4) {
                zzfo6.zzL(Math.min(i4 - i3, zzfo6.zzb()));
            }
            long zza4 = zza(this.zzc, z);
            zzfo zzfo7 = this.zzc;
            int zzd5 = zzfo7.zzd() - zzd4;
            zzfo7.zzK(zzd4);
            zzaek.zzb(this.zzf, this.zzc, zzd5);
            this.zzm += zzd5;
            if (zza4 != -1) {
                zzg();
                this.zzm = 0;
                this.zzn = zza4;
            }
            zzfo zzfo8 = this.zzc;
            if (zzfo8.zzb() >= 16) {
                return 0;
            }
            int zzb2 = zzfo8.zzb();
            System.arraycopy(zzfo8.zzM(), zzfo8.zzd(), zzfo8.zzM(), 0, zzb2);
            this.zzc.zzK(0);
            this.zzc.zzJ(zzb2);
            return 0;
        } else {
            zzadg.zzj();
            zzfo zzfo9 = new zzfo(2);
            ((zzact) zzadg2).zzm(zzfo9.zzM(), 0, 2, false);
            int zzq = zzfo9.zzq();
            if ((zzq >> 2) == 16382) {
                zzadg.zzj();
                this.zzk = zzq;
                zzadi zzadi = this.zze;
                int i5 = zzfx.zza;
                long zzf2 = zzadg.zzf();
                long zzd6 = zzadg.zzd();
                zzads zzads3 = this.zzi;
                zzads3.getClass();
                if (zzads3.zzk != null) {
                    zzaef = new zzadq(zzads3, zzf2);
                } else if (zzd6 == -1 || zzads3.zzj <= 0) {
                    zzaef = new zzaee(zzads3.zza(), 0);
                } else {
                    zzafk zzafk2 = new zzafk(zzads3, this.zzk, zzf2, zzd6);
                    this.zzl = zzafk2;
                    zzaef = zzafk2.zzb();
                }
                zzadi.zzO(zzaef);
                this.zzg = 5;
                return 0;
            }
            zzadg.zzj();
            throw zzcc.zza("First frame does not start with sync code.", (Throwable) null);
        }
    }
}
