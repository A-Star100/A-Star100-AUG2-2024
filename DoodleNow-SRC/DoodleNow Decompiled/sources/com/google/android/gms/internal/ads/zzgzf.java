package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzgzf {
    static final zzgzf zza = new zzgzf(true);
    private static volatile boolean zzb = false;
    private static volatile zzgzf zzc;
    private final Map zzd;

    zzgzf() {
        this.zzd = new HashMap();
    }

    public static zzgzf zza() {
        return zza;
    }

    public final zzgzt zzc(zzhbl zzhbl, int i) {
        return (zzgzt) this.zzd.get(new zzgze(zzhbl, i));
    }

    zzgzf(boolean z) {
        this.zzd = Collections.emptyMap();
    }

    public static zzgzf zzb() {
        zzgzf zzgzf = zzc;
        if (zzgzf != null) {
            return zzgzf;
        }
        synchronized (zzgzf.class) {
            zzgzf zzgzf2 = zzc;
            if (zzgzf2 != null) {
                return zzgzf2;
            }
            zzgzf zzb2 = zzgzn.zzb(zzgzf.class);
            zzc = zzb2;
            return zzb2;
        }
    }
}
