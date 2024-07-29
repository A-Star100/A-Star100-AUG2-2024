package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcuq implements zzp {
    private final zzczx zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzcuq(zzczx zzczx) {
        this.zza = zzczx;
    }

    private final void zzh() {
        if (!this.zzc.get()) {
            this.zzc.set(true);
            this.zza.zza();
        }
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
        zzh();
    }

    public final void zzdr() {
        this.zza.zzc();
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
        this.zzb.set(true);
        zzh();
    }

    public final boolean zzg() {
        return this.zzb.get();
    }
}
