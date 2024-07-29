package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzalv implements zzalh {
    private final zzfo zza = new zzfo();
    private final zzfo zzb = new zzfo();
    private final zzalu zzc = new zzalu();
    private Inflater zzd;

    public final void zza(byte[] bArr, int i, int i2, zzalg zzalg, zzep zzep) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        zzfo zzfo = this.zza;
        if (zzfo.zzb() > 0 && zzfo.zzf() == 120) {
            if (this.zzd == null) {
                this.zzd = new Inflater();
            }
            if (zzfx.zzI(zzfo, this.zzb, this.zzd)) {
                zzfo zzfo2 = this.zzb;
                zzfo.zzI(zzfo2.zzM(), zzfo2.zze());
            }
        }
        this.zzc.zze();
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfo zzfo3 = this.zza;
            if (zzfo3.zzb() >= 3) {
                zzalu zzalu = this.zzc;
                int zze = zzfo3.zze();
                int zzm = zzfo3.zzm();
                int zzq = zzfo3.zzq();
                int zzd2 = zzfo3.zzd() + zzq;
                zzec zzec = null;
                if (zzd2 > zze) {
                    zzfo3.zzK(zze);
                } else {
                    if (zzm != 128) {
                        switch (zzm) {
                            case 20:
                                zzalu.zzd(zzalu, zzfo3, zzq);
                                break;
                            case 21:
                                zzalu.zzb(zzalu, zzfo3, zzq);
                                break;
                            case 22:
                                zzalu.zzc(zzalu, zzfo3, zzq);
                                break;
                        }
                    } else {
                        zzec zza2 = zzalu.zza();
                        zzalu.zze();
                        zzec = zza2;
                    }
                    zzfo3.zzK(zzd2);
                }
                if (zzec != null) {
                    arrayList.add(zzec);
                }
            } else {
                zzep.zza(new zzakz(arrayList, C.TIME_UNSET, C.TIME_UNSET));
                return;
            }
        }
    }
}
