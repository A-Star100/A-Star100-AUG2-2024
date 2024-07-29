package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaoc implements zzano {
    private final zzfo zza;
    private final zzadz zzb;
    private final String zzc;
    private final int zzd;
    private zzaem zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private int zzl;
    private long zzm;

    public zzaoc() {
        this((String) null, 0);
    }

    public final void zza(zzfo zzfo) {
        zzek.zzb(this.zze);
        while (zzfo.zzb() > 0) {
            int i = this.zzg;
            boolean z = true;
            if (i == 0) {
                byte[] zzM = zzfo.zzM();
                int zzd2 = zzfo.zzd();
                int zze2 = zzfo.zze();
                while (true) {
                    if (zzd2 >= zze2) {
                        zzfo.zzK(zze2);
                        break;
                    }
                    int i2 = zzd2 + 1;
                    byte b = zzM[zzd2];
                    boolean z2 = (b & 255) == 255;
                    boolean z3 = this.zzj && (b & 224) == 224;
                    this.zzj = z2;
                    if (z3) {
                        zzfo.zzK(i2);
                        this.zzj = false;
                        this.zza.zzM()[1] = zzM[zzd2];
                        this.zzh = 2;
                        this.zzg = 1;
                        break;
                    }
                    zzd2 = i2;
                }
            } else if (i != 1) {
                int min = Math.min(zzfo.zzb(), this.zzl - this.zzh);
                this.zze.zzq(zzfo, min);
                int i3 = this.zzh + min;
                this.zzh = i3;
                if (i3 >= this.zzl) {
                    if (this.zzm == C.TIME_UNSET) {
                        z = false;
                    }
                    zzek.zzf(z);
                    this.zze.zzs(this.zzm, 1, this.zzl, 0, (zzael) null);
                    this.zzm += this.zzk;
                    this.zzh = 0;
                    this.zzg = 0;
                }
            } else {
                int min2 = Math.min(zzfo.zzb(), 4 - this.zzh);
                zzfo.zzG(this.zza.zzM(), this.zzh, min2);
                int i4 = this.zzh + min2;
                this.zzh = i4;
                if (i4 >= 4) {
                    this.zza.zzK(0);
                    if (!this.zzb.zza(this.zza.zzg())) {
                        this.zzh = 0;
                        this.zzg = 1;
                    } else {
                        zzadz zzadz = this.zzb;
                        this.zzl = zzadz.zzc;
                        if (!this.zzi) {
                            this.zzk = (((long) zzadz.zzg) * 1000000) / ((long) zzadz.zzd);
                            zzak zzak = new zzak();
                            zzak.zzK(this.zzf);
                            zzak.zzW(this.zzb.zzb);
                            zzak.zzO(4096);
                            zzak.zzy(this.zzb.zze);
                            zzak.zzX(this.zzb.zzd);
                            zzak.zzN(this.zzc);
                            zzak.zzU(this.zzd);
                            this.zze.zzl(zzak.zzac());
                            this.zzi = true;
                        }
                        this.zza.zzK(0);
                        this.zze.zzq(this.zza, 4);
                        this.zzg = 2;
                    }
                }
            }
        }
    }

    public final void zzb(zzadi zzadi, zzapa zzapa) {
        zzapa.zzc();
        this.zzf = zzapa.zzb();
        this.zze = zzadi.zzw(zzapa.zza(), 1);
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzj = false;
        this.zzm = C.TIME_UNSET;
    }

    public zzaoc(String str, int i) {
        this.zzg = 0;
        zzfo zzfo = new zzfo(4);
        this.zza = zzfo;
        zzfo.zzM()[0] = -1;
        this.zzb = new zzadz();
        this.zzm = C.TIME_UNSET;
        this.zzc = str;
        this.zzd = i;
    }
}
