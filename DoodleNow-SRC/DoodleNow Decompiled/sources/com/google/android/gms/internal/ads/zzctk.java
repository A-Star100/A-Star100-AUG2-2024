package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzctk implements zzdae, zzazy {
    private final zzffn zza;
    private final zzczi zzb;
    private final zzdan zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzctk(zzffn zzffn, zzczi zzczi, zzdan zzdan) {
        this.zza = zzffn;
        this.zzb = zzczi;
        this.zzc = zzdan;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final void zzdp(zzazx zzazx) {
        if (this.zza.zzf == 1 && zzazx.zzj) {
            zza();
        }
        if (zzazx.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    public final synchronized void zzs() {
        if (this.zza.zzf != 1) {
            zza();
        }
    }
}
