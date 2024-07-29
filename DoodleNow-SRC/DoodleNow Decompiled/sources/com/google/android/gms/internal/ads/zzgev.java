package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgev {
    public static zzgep zza(ExecutorService executorService) {
        zzgep zzgep;
        if (executorService instanceof zzgep) {
            return (zzgep) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzgep = new zzgeu((ScheduledExecutorService) executorService);
        } else {
            zzgep = new zzger(executorService);
        }
        return zzgep;
    }

    public static Executor zzb() {
        return zzgds.INSTANCE;
    }

    static Executor zzc(Executor executor, zzgcs zzgcs) {
        executor.getClass();
        if (executor == zzgds.INSTANCE) {
            return executor;
        }
        return new zzgeq(executor, zzgcs);
    }
}
