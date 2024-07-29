package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzczd extends zzdee implements zzcyu {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd = false;

    public zzczd(zzczc zzczc, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzb = scheduledExecutorService;
        zzo(zzczc, executor);
    }

    public final void zza(zze zze) {
        zzq(new zzcyv(zze));
    }

    public final void zzb() {
        zzq(zzcyw.zza);
    }

    public final void zzc(zzdit zzdit) {
        if (!this.zzd) {
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzq(new zzcyy(zzdit));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        synchronized (this) {
            zzm.zzg("Timeout waiting for show call succeed to be called.");
            zzc(new zzdit("Timeout for show call succeed."));
            this.zzd = true;
        }
    }

    public final synchronized void zze() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void zzf() {
        int intValue = ((Integer) zzba.zzc().zza(zzbdz.zzks)).intValue();
        this.zzc = this.zzb.schedule(new zzcyx(this), (long) intValue, TimeUnit.MILLISECONDS);
    }
}
