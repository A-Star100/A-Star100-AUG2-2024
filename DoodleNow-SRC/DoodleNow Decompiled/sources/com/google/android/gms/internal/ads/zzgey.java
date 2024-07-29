package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgey implements Runnable {
    @CheckForNull
    zzgfb zza;

    zzgey(zzgfb zzgfb) {
        this.zza = zzgfb;
    }

    public final void run() {
        ListenableFuture zze;
        String str;
        zzgfb zzgfb = this.zza;
        if (zzgfb != null && (zze = zzgfb.zza) != null) {
            this.zza = null;
            if (zze.isDone()) {
                zzgfb.zzs(zze);
                return;
            }
            try {
                ScheduledFuture zzv = zzgfb.zzb;
                zzgfb.zzb = null;
                str = "Timed out";
                if (zzv != null) {
                    long abs = Math.abs(zzv.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                zzgfb.zzd(new zzgfa(str + ": " + zze.toString(), (zzgez) null));
                zze.cancel(true);
            } catch (Throwable th) {
                zze.cancel(true);
                throw th;
            }
        }
    }
}
