package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgfe extends zzgdu implements RunnableFuture {
    @CheckForNull
    private volatile zzgen zza;

    zzgfe(zzgdk zzgdk) {
        this.zza = new zzgfc(this, zzgdk);
    }

    static zzgfe zze(Runnable runnable, Object obj) {
        return new zzgfe(Executors.callable(runnable, obj));
    }

    public final void run() {
        zzgen zzgen = this.zza;
        if (zzgen != null) {
            zzgen.run();
        }
        this.zza = null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzgen zzgen = this.zza;
        if (zzgen == null) {
            return super.zza();
        }
        String obj = zzgen.toString();
        return "task=[" + obj + "]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzgen zzgen;
        if (zzt() && (zzgen = this.zza) != null) {
            zzgen.zzh();
        }
        this.zza = null;
    }

    zzgfe(Callable callable) {
        this.zza = new zzgfd(this, callable);
    }
}
