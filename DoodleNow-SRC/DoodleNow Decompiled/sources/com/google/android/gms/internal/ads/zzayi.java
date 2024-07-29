package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayi implements Callable {
    private final zzaxp zza;
    private final zzata zzb;

    public zzayi(zzaxp zzaxp, zzata zzata) {
        this.zza = zzaxp;
        this.zzb = zzata;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzaud zzc = this.zza.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                this.zzb.zzaY(zzc.zzaV(), zzgzf.zza());
            }
            return null;
        } catch (zzhak | NullPointerException unused) {
            return null;
        }
    }
}
