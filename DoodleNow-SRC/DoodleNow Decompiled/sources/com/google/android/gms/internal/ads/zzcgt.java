package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcgt implements zzp {
    private final zzcgm zza;
    private final zzp zzb;

    public zzcgt(zzcgm zzcgm, zzp zzp) {
        this.zza = zzcgm;
        this.zzb = zzp;
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
        zzp zzp = this.zzb;
        if (zzp != null) {
            zzp.zzdq();
        }
    }

    public final void zzdr() {
        zzp zzp = this.zzb;
        if (zzp != null) {
            zzp.zzdr();
        }
        this.zza.zzY();
    }

    public final void zzdt() {
        zzp zzp = this.zzb;
        if (zzp != null) {
            zzp.zzdt();
        }
    }

    public final void zzdu(int i) {
        zzp zzp = this.zzb;
        if (zzp != null) {
            zzp.zzdu(i);
        }
        this.zza.zzW();
    }
}
