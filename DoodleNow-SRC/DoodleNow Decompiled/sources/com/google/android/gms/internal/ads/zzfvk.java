package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfvk extends zzfvh {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzfvh zzb;
    final /* synthetic */ zzfvr zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfvk(zzfvr zzfvr, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzfvh zzfvh) {
        super(taskCompletionSource);
        this.zza = taskCompletionSource2;
        this.zzb = zzfvh;
        this.zzc = zzfvr;
    }

    public final void zza() {
        synchronized (this.zzc.zzg) {
            zzfvr.zzn(this.zzc, this.zza);
            if (this.zzc.zzl.getAndIncrement() > 0) {
                this.zzc.zzc.zzc("Already connected to the service.", new Object[0]);
            }
            zzfvr.zzp(this.zzc, this.zzb);
        }
    }
}
