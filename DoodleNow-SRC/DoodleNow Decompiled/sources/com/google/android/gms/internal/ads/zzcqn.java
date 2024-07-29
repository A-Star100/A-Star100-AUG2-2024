package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcqn implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzcqn(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzcqh zzcqh = (zzcqh) this.zza.zzb();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        if (((JSONObject) this.zzc.zzb()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzdgf(zzcqh, zzgep));
        }
        zzhjd.zzb(set);
        return set;
    }
}
