package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdth implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;

    public zzdth(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String str = (String) this.zza.zzb();
        Context zza2 = ((zzciq) this.zzb).zza();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        Map zzd2 = ((zzhiz) this.zzd).zzb();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzeQ)).booleanValue()) {
            zzbcx zzbcx = new zzbcx(new zzbdf(zza2));
            zzbcx.zzc(new zzdti(str));
            set = Collections.singleton(new zzdgf(new zzdtk(zzbcx, zzd2), zzgep));
        } else {
            set = Collections.emptySet();
        }
        zzhjd.zzb(set);
        return set;
    }
}
