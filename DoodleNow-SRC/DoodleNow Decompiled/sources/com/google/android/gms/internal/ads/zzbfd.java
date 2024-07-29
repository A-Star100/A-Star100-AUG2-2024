package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbfd implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;

    public zzbfd(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
    }

    public final /* synthetic */ Object zzb() {
        return new zzbfc(((zzciq) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb(), new zzbfe(), (zzflh) this.zzd.zzb());
    }
}
