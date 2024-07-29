package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeuz implements zzewr {
    private final zzewr zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzeuz(zzewr zzewr, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzewr;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzb2 = this.zza.zzb();
        long j = this.zzb;
        if (j > 0) {
            zzb2 = zzgee.zzo(zzb2, j, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgee.zzf(zzb2, Throwable.class, zzeuy.zza, zzcbr.zzf);
    }
}
