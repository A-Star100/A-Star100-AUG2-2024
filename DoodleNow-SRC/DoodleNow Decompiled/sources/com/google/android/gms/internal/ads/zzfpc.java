package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfpc {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfpb zzd = null;

    public zzfpc() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfpb zzfpb = (zzfpb) this.zzc.poll();
        this.zzd = zzfpb;
        if (zzfpb != null) {
            zzfpb.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfpb zzfpb) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfpb zzfpb) {
        zzfpb.zzb(this);
        this.zzc.add(zzfpb);
        if (this.zzd == null) {
            zzc();
        }
    }
}
