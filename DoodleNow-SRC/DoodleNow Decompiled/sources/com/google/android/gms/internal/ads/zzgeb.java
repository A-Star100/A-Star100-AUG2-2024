package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgeb implements Runnable {
    final Future zza;
    final zzgea zzb;

    zzgeb(Future future, zzgea zzgea) {
        this.zza = future;
        this.zzb = zzgea;
    }

    public final void run() {
        Throwable zza2;
        Future future = this.zza;
        if (!(future instanceof zzgfh) || (zza2 = zzgfi.zza((zzgfh) future)) == null) {
            try {
                this.zzb.zzb(zzgee.zzp(this.zza));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
            } catch (Throwable th) {
                this.zzb.zza(th);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzfwj zza2 = zzfwk.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
