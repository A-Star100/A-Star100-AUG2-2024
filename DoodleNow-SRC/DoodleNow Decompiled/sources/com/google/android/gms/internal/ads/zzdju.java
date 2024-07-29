package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdju implements zzbky {
    private final WeakReference zza;

    /* synthetic */ zzdju(zzdjv zzdjv, zzdjt zzdjt) {
        this.zza = new WeakReference(zzdjv);
    }

    public final void zza(Object obj, Map map) {
        zzdjv zzdjv = (zzdjv) this.zza.get();
        if (zzdjv != null) {
            zzdjv.zzg.zza();
        }
    }
}
