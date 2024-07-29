package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgee extends zzgeg {
    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzged zza(java.lang.Iterable r3) {
        /*
            com.google.android.gms.internal.ads.zzged r0 = new com.google.android.gms.internal.ads.zzged
            com.google.android.gms.internal.ads.zzfzn r3 = com.google.android.gms.internal.ads.zzfzn.zzk(r3)
            r1 = 0
            r2 = 0
            r0.<init>(r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgee.zza(java.lang.Iterable):com.google.android.gms.internal.ads.zzged");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Object, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzged zzb(java.lang.Iterable r3) {
        /*
            com.google.android.gms.internal.ads.zzged r0 = new com.google.android.gms.internal.ads.zzged
            int r1 = com.google.android.gms.internal.ads.zzfzn.zzd
            r3.getClass()
            com.google.android.gms.internal.ads.zzfzn r3 = com.google.android.gms.internal.ads.zzfzn.zzk(r3)
            r1 = 0
            r2 = 1
            r0.<init>(r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgee.zzb(java.lang.Iterable):com.google.android.gms.internal.ads.zzged");
    }

    @SafeVarargs
    public static zzged zzc(ListenableFuture... listenableFutureArr) {
        return new zzged(true, zzfzn.zzl(listenableFutureArr), (zzgec) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.util.concurrent.ListenableFuture zzd(java.lang.Iterable r2) {
        /*
            com.google.android.gms.internal.ads.zzgdm r0 = new com.google.android.gms.internal.ads.zzgdm
            com.google.android.gms.internal.ads.zzfzn r2 = com.google.android.gms.internal.ads.zzfzn.zzk(r2)
            r1 = 1
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgee.zzd(java.lang.Iterable):com.google.common.util.concurrent.ListenableFuture");
    }

    public static ListenableFuture zze(ListenableFuture listenableFuture, Class cls, zzfwf zzfwf, Executor executor) {
        zzgcp zzgcp = new zzgcp(listenableFuture, cls, zzfwf);
        listenableFuture.addListener(zzgcp, zzgev.zzc(executor, zzgcp));
        return zzgcp;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, Class cls, zzgdl zzgdl, Executor executor) {
        zzgco zzgco = new zzgco(listenableFuture, cls, zzgdl);
        listenableFuture.addListener(zzgco, zzgev.zzc(executor, zzgco));
        return zzgco;
    }

    public static ListenableFuture zzh(Object obj) {
        if (obj == null) {
            return zzgei.zza;
        }
        return new zzgei(obj);
    }

    public static ListenableFuture zzi() {
        return zzgei.zza;
    }

    public static ListenableFuture zzj(Callable callable, Executor executor) {
        zzgfe zzgfe = new zzgfe(callable);
        executor.execute(zzgfe);
        return zzgfe;
    }

    public static ListenableFuture zzk(zzgdk zzgdk, Executor executor) {
        zzgfe zzgfe = new zzgfe(zzgdk);
        executor.execute(zzgfe);
        return zzgfe;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzgdm(zzfzn.zzl(listenableFutureArr), false);
    }

    public static ListenableFuture zzm(ListenableFuture listenableFuture, zzfwf zzfwf, Executor executor) {
        zzgcz zzgcz = new zzgcz(listenableFuture, zzfwf);
        listenableFuture.addListener(zzgcz, zzgev.zzc(executor, zzgcz));
        return zzgcz;
    }

    public static ListenableFuture zzn(ListenableFuture listenableFuture, zzgdl zzgdl, Executor executor) {
        int i = zzgda.zzc;
        executor.getClass();
        zzgcy zzgcy = new zzgcy(listenableFuture, zzgdl);
        listenableFuture.addListener(zzgcy, zzgev.zzc(executor, zzgcy));
        return zzgcy;
    }

    public static ListenableFuture zzo(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return zzgfb.zzf(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgfg.zza(future);
        }
        throw new IllegalStateException(zzfxg.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgfg.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzgdt((Error) cause);
            }
            throw new zzgff(cause);
        }
    }

    public static ListenableFuture zzg(Throwable th) {
        th.getClass();
        return new zzgeh(th);
    }

    public static void zzr(ListenableFuture listenableFuture, zzgea zzgea, Executor executor) {
        zzgea.getClass();
        listenableFuture.addListener(new zzgeb(listenableFuture, zzgea), executor);
    }
}
