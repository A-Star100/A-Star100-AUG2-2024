package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaqf implements Executor {
    final /* synthetic */ Handler zza;

    zzaqf(zzaqh zzaqh, Handler handler) {
        this.zza = handler;
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
