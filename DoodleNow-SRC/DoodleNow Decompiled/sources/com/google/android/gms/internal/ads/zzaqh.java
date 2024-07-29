package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaqh {
    private final Executor zza;

    public zzaqh(Handler handler) {
        this.zza = new zzaqf(this, handler);
    }

    public final void zza(zzaqq zzaqq, zzaqz zzaqz) {
        zzaqq.zzm("post-error");
        ((zzaqf) this.zza).zza.post(new zzaqg(zzaqq, zzaqw.zza(zzaqz), (Runnable) null));
    }

    public final void zzb(zzaqq zzaqq, zzaqw zzaqw, Runnable runnable) {
        zzaqq.zzq();
        zzaqq.zzm("post-response");
        ((zzaqf) this.zza).zza.post(new zzaqg(zzaqq, zzaqw, runnable));
    }
}
