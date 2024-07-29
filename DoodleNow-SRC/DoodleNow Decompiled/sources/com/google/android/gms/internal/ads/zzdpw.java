package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdpw implements zzbky {
    final /* synthetic */ zzdpx zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbky zzd;

    /* synthetic */ zzdpw(zzdpx zzdpx, WeakReference weakReference, String str, zzbky zzbky, zzdpv zzdpv) {
        this.zza = zzdpx;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbky;
    }

    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzn(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
