package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzalb {
    public static void zza(zzalc zzalc, zzalg zzalg, zzep zzep) {
        for (int i = 0; i < zzalc.zza(); i++) {
            long zzb = zzalc.zzb(i);
            List zzc = zzalc.zzc(zzb);
            if (!zzc.isEmpty()) {
                if (i != zzalc.zza() - 1) {
                    zzep.zza(new zzakz(zzc, zzb, zzalc.zzb(i + 1) - zzalc.zzb(i)));
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }
}
