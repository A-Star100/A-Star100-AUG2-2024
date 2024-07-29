package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzest implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzest(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeuz(((zzeux) this.zza).zzb(), (long) ((Integer) zzba.zzc().zza(zzbdz.zzlO)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
