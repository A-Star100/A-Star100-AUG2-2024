package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzesj implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzesj(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzs zzfzs;
        zzerr zza2 = zzert.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzb();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdX)).booleanValue()) {
            zzfzs = zzfzs.zzo(new zzeuz(zza2, (long) ((Integer) zzba.zzc().zza(zzbdz.zzdY)).intValue(), scheduledExecutorService));
        } else {
            zzfzs = zzfzs.zzn();
        }
        zzhjd.zzb(zzfzs);
        return zzfzs;
    }
}
