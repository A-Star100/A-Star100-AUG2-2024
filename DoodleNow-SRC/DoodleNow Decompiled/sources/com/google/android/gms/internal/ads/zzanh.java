package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzanh implements zzano {
    private final zzfn zza;
    private final zzfo zzb;
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzaem zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private long zzj;
    private zzam zzk;
    private int zzl;
    private long zzm;

    public zzanh() {
        this((String) null, 0);
    }

    public final void zza(zzfo zzfo) {
        int zzm2;
        byte b;
        zzek.zzb(this.zzf);
        while (zzfo.zzb() > 0) {
            int i = this.zzg;
            boolean z = true;
            if (i == 0) {
                while (true) {
                    if (zzfo.zzb() <= 0) {
                        break;
                    } else if (!this.zzi) {
                        this.zzi = zzfo.zzm() == 172;
                    } else {
                        zzm2 = zzfo.zzm();
                        this.zzi = zzm2 == 172;
                        b = SignedBytes.MAX_POWER_OF_TWO;
                        if (zzm2 == 64) {
                            break;
                        } else if (zzm2 == 65) {
                            zzm2 = 65;
                            break;
                        }
                    }
                }
                this.zzg = 1;
                zzfo zzfo2 = this.zzb;
                zzfo2.zzM()[0] = -84;
                if (zzm2 == 65) {
                    b = 65;
                }
                zzfo2.zzM()[1] = b;
                this.zzh = 2;
            } else if (i != 1) {
                int min = Math.min(zzfo.zzb(), this.zzl - this.zzh);
                this.zzf.zzq(zzfo, min);
                int i2 = this.zzh + min;
                this.zzh = i2;
                if (i2 == this.zzl) {
                    if (this.zzm == C.TIME_UNSET) {
                        z = false;
                    }
                    zzek.zzf(z);
                    this.zzf.zzs(this.zzm, 1, this.zzl, 0, (zzael) null);
                    this.zzm += this.zzj;
                    this.zzg = 0;
                }
            } else {
                byte[] zzM = this.zzb.zzM();
                int min2 = Math.min(zzfo.zzb(), 16 - this.zzh);
                zzfo.zzG(zzM, this.zzh, min2);
                int i3 = this.zzh + min2;
                this.zzh = i3;
                if (i3 == 16) {
                    this.zza.zzk(0);
                    zzacg zza2 = zzach.zza(this.zza);
                    zzam zzam = this.zzk;
                    if (zzam == null || zzam.zzz != 2 || zza2.zza != zzam.zzA || !MimeTypes.AUDIO_AC4.equals(zzam.zzm)) {
                        zzak zzak = new zzak();
                        zzak.zzK(this.zze);
                        zzak.zzW(MimeTypes.AUDIO_AC4);
                        zzak.zzy(2);
                        zzak.zzX(zza2.zza);
                        zzak.zzN(this.zzc);
                        zzak.zzU(this.zzd);
                        zzam zzac = zzak.zzac();
                        this.zzk = zzac;
                        this.zzf.zzl(zzac);
                    }
                    this.zzl = zza2.zzb;
                    this.zzj = (((long) zza2.zzc) * 1000000) / ((long) this.zzk.zzA);
                    this.zzb.zzK(0);
                    this.zzf.zzq(this.zzb, 16);
                    this.zzg = 2;
                }
            }
        }
    }

    public final void zzb(zzadi zzadi, zzapa zzapa) {
        zzapa.zzc();
        this.zze = zzapa.zzb();
        this.zzf = zzadi.zzw(zzapa.zza(), 1);
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = C.TIME_UNSET;
    }

    public zzanh(String str, int i) {
        zzfn zzfn = new zzfn(new byte[16], 16);
        this.zza = zzfn;
        this.zzb = new zzfo(zzfn.zza);
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = C.TIME_UNSET;
        this.zzc = str;
        this.zzd = i;
    }
}
