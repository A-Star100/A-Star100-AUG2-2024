package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgeu extends zzger implements ScheduledExecutorService, zzgep {
    final ScheduledExecutorService zza;

    zzgeu(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgfe zze = zzgfe.zze(runnable, (Object) null);
        return new zzges(zze, scheduledExecutorService.schedule(zze, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzget zzget = new zzget(runnable);
        return new zzges(zzget, this.zza.scheduleAtFixedRate(zzget, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzget zzget = new zzget(runnable);
        return new zzges(zzget, this.zza.scheduleWithFixedDelay(zzget, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgfe zzgfe = new zzgfe(callable);
        return new zzges(zzgfe, this.zza.schedule(zzgfe, j, timeUnit));
    }
}
