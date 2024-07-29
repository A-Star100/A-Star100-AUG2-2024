package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdss implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzdss(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        zzdtk zza2 = ((zzdtl) this.zzb).zzb();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzeQ)).booleanValue()) {
            set = Collections.singleton(new zzdgf(zza2, zzgep));
        } else {
            set = Collections.emptySet();
        }
        zzhjd.zzb(set);
        return set;
    }
}
