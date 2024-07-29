package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaof implements zzapb {
    private final zzano zza;
    private final zzfn zzb = new zzfn(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfv zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaof(zzano zzano) {
        this.zza = zzano;
    }

    private final void zzd(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zze(zzfo zzfo, byte[] bArr, int i) {
        int min = Math.min(zzfo.zzb(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfo.zzL(min);
        } else {
            zzfo.zzG(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    public final void zza(zzfo zzfo, int i) throws zzcc {
        int i2;
        int i3;
        boolean z;
        int i4;
        long j;
        int i5;
        zzfo zzfo2 = zzfo;
        zzek.zzb(this.zze);
        int i6 = -1;
        int i7 = 2;
        boolean z2 = false;
        int i8 = 1;
        if ((i & 1) != 0) {
            int i9 = this.zzc;
            if (!(i9 == 0 || i9 == 1)) {
                if (i9 != 2) {
                    int i10 = this.zzj;
                    if (i10 != -1) {
                        zzfe.zzf("PesReader", "Unexpected start indicator: expected " + i10 + " more bytes");
                    }
                    this.zza.zzc(zzfo.zze() == 0);
                } else {
                    zzfe.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i11 = i;
        while (zzfo.zzb() > 0) {
            int i12 = this.zzc;
            if (i12 == 0) {
                i2 = i7;
                z = z2;
                i3 = i8;
                zzfo2.zzL(zzfo.zzb());
            } else if (i12 != i8) {
                if (i12 != i7) {
                    int zzb2 = zzfo.zzb();
                    int i13 = this.zzj;
                    int i14 = i13 == i6 ? z2 : zzb2 - i13;
                    if (i14 > 0) {
                        zzb2 -= i14;
                        zzfo2.zzJ(zzfo.zzd() + zzb2);
                    }
                    this.zza.zza(zzfo2);
                    int i15 = this.zzj;
                    if (i15 != i6) {
                        int i16 = i15 - zzb2;
                        this.zzj = i16;
                        if (i16 == 0) {
                            this.zza.zzc(z2);
                            zzd(i8);
                        }
                    }
                } else {
                    if (zze(zzfo2, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzfo2, (byte[]) null, this.zzi)) {
                        this.zzb.zzk(z2 ? 1 : 0);
                        if (this.zzf) {
                            this.zzb.zzm(4);
                            long zzd2 = (long) this.zzb.zzd(3);
                            this.zzb.zzm(i8);
                            int zzd3 = this.zzb.zzd(15) << 15;
                            this.zzb.zzm(i8);
                            long zzd4 = (long) this.zzb.zzd(15);
                            this.zzb.zzm(i8);
                            if (this.zzh || !this.zzg) {
                                i5 = zzd3;
                            } else {
                                this.zzb.zzm(4);
                                this.zzb.zzm(i8);
                                this.zzb.zzm(i8);
                                long zzd5 = (long) this.zzb.zzd(15);
                                this.zzb.zzm(i8);
                                i5 = zzd3;
                                this.zze.zzb((((long) this.zzb.zzd(3)) << 30) | ((long) (this.zzb.zzd(15) << 15)) | zzd5);
                                this.zzh = true;
                            }
                            j = this.zze.zzb((zzd2 << 30) | ((long) i5) | zzd4);
                        } else {
                            j = C.TIME_UNSET;
                        }
                        i11 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(j, i11);
                        zzd(3);
                        i6 = -1;
                        i7 = 2;
                        z2 = false;
                        i8 = 1;
                    }
                }
                i2 = i7;
                z = z2;
                i3 = i8;
            } else if (zze(zzfo2, this.zzb.zza, 9)) {
                z = false;
                this.zzb.zzk(0);
                int zzd6 = this.zzb.zzd(24);
                i3 = 1;
                if (zzd6 != 1) {
                    zzfe.zzf("PesReader", "Unexpected start code prefix: " + zzd6);
                    i6 = -1;
                    this.zzj = -1;
                    i4 = 0;
                    i2 = 2;
                } else {
                    this.zzb.zzm(8);
                    zzfn zzfn = this.zzb;
                    int zzd7 = zzfn.zzd(16);
                    zzfn.zzm(5);
                    this.zzk = this.zzb.zzo();
                    i2 = 2;
                    this.zzb.zzm(2);
                    this.zzf = this.zzb.zzo();
                    this.zzg = this.zzb.zzo();
                    this.zzb.zzm(6);
                    int zzd8 = this.zzb.zzd(8);
                    this.zzi = zzd8;
                    if (zzd7 == 0) {
                        this.zzj = -1;
                        i6 = -1;
                    } else {
                        int i17 = (zzd7 - 3) - zzd8;
                        this.zzj = i17;
                        if (i17 < 0) {
                            zzfe.zzf("PesReader", "Found negative packet payload size: " + i17);
                            i6 = -1;
                            this.zzj = -1;
                        } else {
                            i6 = -1;
                        }
                    }
                    i4 = 2;
                }
                zzd(i4);
            } else {
                i6 = -1;
                z = false;
                i3 = 1;
                i2 = 2;
            }
            i8 = i3;
            z2 = z;
            i7 = i2;
        }
    }

    public final void zzb(zzfv zzfv, zzadi zzadi, zzapa zzapa) {
        this.zze = zzfv;
        this.zza.zzb(zzadi, zzapa);
    }

    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
