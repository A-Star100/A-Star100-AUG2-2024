package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzemb implements zzg {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcyo zzb;
    private final zzczi zzc;
    private final zzdgp zzd;
    private final zzdgh zze;
    private final zzcqh zzf;

    zzemb(zzcyo zzcyo, zzczi zzczi, zzdgp zzdgp, zzdgh zzdgh, zzcqh zzcqh) {
        this.zzb = zzcyo;
        this.zzc = zzczi;
        this.zzd = zzdgp;
        this.zze = zzdgh;
        this.zzf = zzcqh;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzr();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
