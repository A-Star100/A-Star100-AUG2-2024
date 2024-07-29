package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbcp implements Runnable {
    public final /* synthetic */ zzcbw zza;
    public final /* synthetic */ Future zzb;

    public /* synthetic */ zzbcp(zzcbw zzcbw, Future future) {
        this.zza = zzcbw;
        this.zzb = future;
    }

    public final void run() {
        int i = zzbcr.zzd;
        if (this.zza.isCancelled()) {
            this.zzb.cancel(true);
        }
    }
}
