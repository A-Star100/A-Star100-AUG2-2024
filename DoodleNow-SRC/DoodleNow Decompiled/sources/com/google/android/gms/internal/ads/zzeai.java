package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeai implements zzeak {
    private final Map zza;
    private final zzgep zzb;
    /* access modifiers changed from: private */
    public final zzdbj zzc;

    public zzeai(Map map, zzgep zzgep, zzdbj zzdbj) {
        this.zza = map;
        this.zzb = zzgep;
        this.zzc = zzdbj;
    }

    public final ListenableFuture zzb(zzbxd zzbxd) {
        this.zzc.zzdn(zzbxd);
        ListenableFuture zzg = zzgee.zzg(new zzdyi(3));
        for (String trim : ((String) zzba.zzc().zza(zzbdz.zzih)).split(f.a)) {
            zzhjm zzhjm = (zzhjm) this.zza.get(trim.trim());
            if (zzhjm != null) {
                zzg = zzgee.zzf(zzg, zzdyi.class, new zzeag(zzhjm, zzbxd), this.zzb);
            }
        }
        zzgee.zzr(zzg, new zzeah(this), zzcbr.zzf);
        return zzg;
    }
}
