package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdjj implements zzhiv {
    private final zzhjm zza;

    public zzdjj(zzhjm zzhjm) {
        this.zza = zzhjm;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        if (((zzdjg) this.zza).zza().zze() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzhjd.zzb(set);
        return set;
    }
}
