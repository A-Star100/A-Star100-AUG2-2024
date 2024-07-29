package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
abstract class zzgdq extends zzgen {
    private final Executor zza;
    final /* synthetic */ zzgdr zzb;

    zzgdq(zzgdr zzgdr, Executor executor) {
        this.zzb = zzgdr;
        executor.getClass();
        this.zza = executor;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzc(Object obj);

    /* access modifiers changed from: package-private */
    public final void zzd(Throwable th) {
        this.zzb.zza = null;
        if (th instanceof ExecutionException) {
            this.zzb.zzd(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zzd(th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        this.zzb.zza = null;
        zzc(obj);
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zzb.isDone();
    }
}
