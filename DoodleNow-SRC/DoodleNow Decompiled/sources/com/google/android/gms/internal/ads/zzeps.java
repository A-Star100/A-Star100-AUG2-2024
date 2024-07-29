package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeps implements zzewr {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    public zzeps(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return 6;
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzn = zzgee.zzn(this.zza, zzepo.zza, this.zzb);
        if (((Integer) zzba.zzc().zza(zzbdz.zzme)).intValue() > 0) {
            zzbdq zzbdq = zzbdz.zzme;
            zzn = zzgee.zzo(zzn, (long) ((Integer) zzba.zzc().zza(zzbdq)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgee.zzf(zzn, Throwable.class, zzepp.zza, this.zzb);
    }
}
