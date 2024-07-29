package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbow extends zzccd {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzbpb zzb;
    private boolean zzc;

    public zzbow(zzbpb zzbpb) {
        this.zzb = zzbpb;
    }

    public final void zzb() {
        zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("release: Lock acquired");
            if (this.zzc) {
                zze.zza("release: Lock already released");
                return;
            }
            this.zzc = true;
            zzj(new zzbot(this), new zzcbz());
            zzj(new zzbou(this), new zzbov(this));
            zze.zza("release: Lock released");
        }
    }
}
