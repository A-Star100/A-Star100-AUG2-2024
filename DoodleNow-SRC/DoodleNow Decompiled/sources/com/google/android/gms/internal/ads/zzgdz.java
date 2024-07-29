package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgdz extends zzgdx implements ListenableFuture {
    protected zzgdz() {
    }

    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract ListenableFuture zzc();
}
