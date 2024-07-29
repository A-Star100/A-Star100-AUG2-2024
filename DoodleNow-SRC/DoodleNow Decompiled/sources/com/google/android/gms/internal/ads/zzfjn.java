package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfjn implements zzhiv {
    private final zzhjm zza;

    public zzfjn(zzhjm zzhjm) {
        this.zza = zzhjm;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzftf.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, (ThreadFactory) this.zza.zzb()));
        zzhjd.zzb(unconfigurableScheduledExecutorService);
        return unconfigurableScheduledExecutorService;
    }
}
