package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfny implements zzfnr {
    private static zzfny zza;
    private float zzb = 0.0f;
    private final zzfnn zzc;
    private final zzfnl zzd;
    private zzfnm zze;
    private zzfnq zzf;

    public zzfny(zzfnn zzfnn, zzfnl zzfnl) {
        this.zzc = zzfnn;
        this.zzd = zzfnl;
    }

    public static zzfny zzb() {
        if (zza == null) {
            zza = new zzfny(new zzfnn(), new zzfnl());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    public final void zzc(boolean z) {
        if (z) {
            zzfoz.zzd().zzi();
        } else {
            zzfoz.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zze = new zzfnm(new Handler(), context, new zzfnk(), this);
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzf == null) {
            this.zzf = zzfnq.zza();
        }
        for (zzfnc zzg : this.zzf.zzb()) {
            zzg.zzg().zzl(f);
        }
    }

    public final void zzf() {
        zzfnp.zza().zze(this);
        zzfnp.zza().zzf();
        zzfoz.zzd().zzi();
        this.zze.zza();
    }

    public final void zzg() {
        zzfoz.zzd().zzj();
        zzfnp.zza().zzg();
        this.zze.zzb();
    }
}
