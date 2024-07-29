package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzamn implements zzalh {
    private final zzfo zza = new zzfo();

    public final void zza(byte[] bArr, int i, int i2, zzalg zzalg, zzep zzep) {
        zzec zzec;
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfo zzfo = this.zza;
            if (zzfo.zzb() > 0) {
                zzek.zze(zzfo.zzb() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
                zzfo zzfo2 = this.zza;
                int zzg = zzfo2.zzg() - 8;
                if (zzfo2.zzg() == 1987343459) {
                    zzfo zzfo3 = this.zza;
                    CharSequence charSequence = null;
                    zzea zzea = null;
                    while (zzg > 0) {
                        zzek.zze(zzg >= 8, "Incomplete vtt cue box header found.");
                        int zzg2 = zzfo3.zzg();
                        int zzg3 = zzfo3.zzg();
                        int i3 = zzg - 8;
                        int i4 = zzg2 - 8;
                        String zzB = zzfx.zzB(zzfo3.zzM(), zzfo3.zzd(), i4);
                        zzfo3.zzL(i4);
                        if (zzg3 == 1937011815) {
                            zzea = zzamx.zzb(zzB);
                        } else if (zzg3 == 1885436268) {
                            charSequence = zzamx.zza((String) null, zzB.trim(), Collections.emptyList());
                        }
                        zzg = i3 - i4;
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (zzea != null) {
                        zzea.zzl(charSequence);
                        zzec = zzea.zzp();
                    } else {
                        zzamw zzamw = new zzamw();
                        zzamw.zzc = charSequence;
                        zzec = zzamw.zza().zzp();
                    }
                    arrayList.add(zzec);
                } else {
                    this.zza.zzL(zzg);
                }
            } else {
                zzep.zza(new zzakz(arrayList, C.TIME_UNSET, C.TIME_UNSET));
                return;
            }
        }
    }
}
