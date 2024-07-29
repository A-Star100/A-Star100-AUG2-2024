package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzciw implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzciw(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzdwm zzdwm = (zzdwm) this.zza.zzb();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbD)).booleanValue()) {
            set = Collections.singleton(new zzdgf(zzdwm, zzgep));
        } else {
            set = Collections.emptySet();
        }
        zzhjd.zzb(set);
        return set;
    }
}
