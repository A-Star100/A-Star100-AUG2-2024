package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzaah implements Executor {
    public final /* synthetic */ zzev zza;

    public /* synthetic */ zzaah(zzev zzev) {
        this.zza = zzev;
    }

    public final void execute(Runnable runnable) {
        this.zza.zzh(runnable);
    }
}
