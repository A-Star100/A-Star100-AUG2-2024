package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfvl extends zzfvh {
    final /* synthetic */ zzfvr zza;

    zzfvl(zzfvr zzfvr) {
        this.zza = zzfvr;
    }

    public final void zza() {
        synchronized (this.zza.zzg) {
            if (this.zza.zzl.get() <= 0 || this.zza.zzl.decrementAndGet() <= 0) {
                zzfvr zzfvr = this.zza;
                if (zzfvr.zzn != null) {
                    zzfvr.zzc.zzc("Unbind from service.", new Object[0]);
                    zzfvr zzfvr2 = this.zza;
                    zzfvr2.zzb.unbindService(zzfvr2.zzm);
                    this.zza.zzh = false;
                    this.zza.zzn = null;
                    this.zza.zzm = null;
                }
                this.zza.zzw();
                return;
            }
            this.zza.zzc.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
        }
    }
}
