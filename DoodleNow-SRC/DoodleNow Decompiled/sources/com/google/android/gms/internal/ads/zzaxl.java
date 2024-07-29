package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaxl implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();
    private final AtomicInteger zzb = new AtomicInteger(1);

    zzaxl() {
    }

    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.zzb;
        Thread newThread = this.zza.newThread(runnable);
        int andIncrement = atomicInteger.getAndIncrement();
        newThread.setName("gads-" + andIncrement);
        return newThread;
    }
}
