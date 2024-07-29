package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcsz implements Runnable {
    public final /* synthetic */ AtomicReference zza;

    public /* synthetic */ zzcsz(AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    public final void run() {
        zzctb.zzi(this.zza);
    }
}
