package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfvn extends zzfvh {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzfvq zzb;

    zzfvn(zzfvq zzfvq, IBinder iBinder) {
        this.zza = iBinder;
        this.zzb = zzfvq;
    }

    public final void zza() {
        this.zzb.zza.zzn = zzfty.zzb(this.zza);
        zzfvr.zzq(this.zzb.zza);
        this.zzb.zza.zzh = false;
        for (Runnable run : this.zzb.zza.zze) {
            run.run();
        }
        this.zzb.zza.zze.clear();
    }
}
