package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgeq implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzgcs zzb;

    zzgeq(Executor executor, zzgcs zzgcs) {
        this.zza = executor;
        this.zzb = zzgcs;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }
}
