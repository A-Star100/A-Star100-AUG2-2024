package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzane implements zzano {
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

    public zzane() {
        this((String) null, 0);
    }

    public final void zza(zzfo zzfo) {
        zzek.zzb(this.zzf);
        while (zzfo.zzb() > 0) {
            int i = this.zzg;
            boolean z = true;
            if (i == 0) {
                while (true) {
                    if (zzfo.zzb() <= 0) {
                        break;
                    } else if (!this.zzi) {
                        this.zzi = zzfo.zzm() == 11;
                    } else {
                        int zzm2 = zzfo.zzm();
                        if (zzm2 == 119) {
                            this.zzi = false;
                            this.zzg = 1;
                            zzfo zzfo2 = this.zzb;
                            zzfo2.zzM()[0] = Ascii.VT;
                            zzfo2.zzM()[1] = 119;
                            this.zzh = 2;
                            break;
                        }
                        this.zzi = zzm2 == 11;
                    }
                }
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
                int min2 = Math.min(zzfo.zzb(), 128 - this.zzh);
                zzfo.zzG(zzM, this.zzh, min2);
                int i3 = this.zzh + min2;
                this.zzh = i3;
                if (i3 == 128) {
                    this.zza.zzk(0);
                    zzacd zze2 = zzace.zze(this.zza);
                    zzam zzam = this.zzk;
                    if (zzam == null || zze2.zzc != zzam.zzz || zze2.zzb != zzam.zzA || !zzfx.zzG(zze2.zza, zzam.zzm)) {
                        zzak zzak = new zzak();
                        zzak.zzK(this.zze);
                        zzak.zzW(zze2.zza);
                        zzak.zzy(zze2.zzc);
                        zzak.zzX(zze2.zzb);
                        zzak.zzN(this.zzc);
                        zzak.zzU(this.zzd);
                        zzak.zzR(zze2.zzf);
                        if (MimeTypes.AUDIO_AC3.equals(zze2.zza)) {
                            zzak.zzx(zze2.zzf);
                        }
                        zzam zzac = zzak.zzac();
                        this.zzk = zzac;
                        this.zzf.zzl(zzac);
                    }
                    this.zzl = zze2.zzd;
                    this.zzj = (((long) zze2.zze) * 1000000) / ((long) this.zzk.zzA);
                    this.zzb.zzK(0);
                    this.zzf.zzq(this.zzb, 128);
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

    public zzane(String str, int i) {
        zzfn zzfn = new zzfn(new byte[128], 128);
        this.zza = zzfn;
        this.zzb = new zzfo(zzfn.zza);
        this.zzg = 0;
        this.zzm = C.TIME_UNSET;
        this.zzc = str;
        this.zzd = i;
    }
}
