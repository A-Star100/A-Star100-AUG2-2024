package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzamy implements zzalh {
    private final zzfo zza = new zzfo();
    private final zzamo zzb = new zzamo();

    public final void zza(byte[] bArr, int i, int i2, zzalg zzalg, zzep zzep) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        try {
            zzfo zzfo = this.zza;
            int zzd = zzfo.zzd();
            String zzy = zzfo.zzy(zzfwd.zzc);
            if (zzy == null || !zzy.startsWith("WEBVTT")) {
                zzfo.zzK(zzd);
                throw zzcc.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzfo.zzy(zzfwd.zzc))), (Throwable) null);
            }
            do {
            } while (!TextUtils.isEmpty(this.zza.zzy(zzfwd.zzc)));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzfo zzfo2 = this.zza;
                char c = 65535;
                int i3 = 0;
                while (c == 65535) {
                    i3 = zzfo2.zzd();
                    String zzy2 = zzfo2.zzy(zzfwd.zzc);
                    if (zzy2 == null) {
                        c = 0;
                    } else if ("STYLE".equals(zzy2)) {
                        c = 2;
                    } else {
                        c = zzy2.startsWith("NOTE") ? (char) 1 : 3;
                    }
                }
                zzfo2.zzK(i3);
                if (c == 0) {
                    zzalb.zza(new zzanb(arrayList2), zzalg, zzep);
                    return;
                } else if (c == 1) {
                    do {
                    } while (!TextUtils.isEmpty(this.zza.zzy(zzfwd.zzc)));
                } else if (c != 2) {
                    zzamq zzc = zzamx.zzc(this.zza, arrayList);
                    if (zzc != null) {
                        arrayList2.add(zzc);
                    }
                } else if (arrayList2.isEmpty()) {
                    this.zza.zzy(zzfwd.zzc);
                    arrayList.addAll(this.zzb.zzb(this.zza));
                } else {
                    throw new IllegalArgumentException("A style block was found after the first cue.");
                }
            }
        } catch (zzcc e) {
            throw new IllegalArgumentException(e);
        }
    }
}
