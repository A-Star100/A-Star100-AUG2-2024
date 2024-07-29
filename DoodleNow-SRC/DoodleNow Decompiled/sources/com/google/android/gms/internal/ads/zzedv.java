package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzedv {
    private final zzedr zza;
    private final zzgep zzb;

    public zzedv(zzedr zzedr, zzgep zzgep) {
        this.zza = zzedr;
        this.zzb = zzgep;
    }

    public final void zza(zzfjq zzfjq) {
        zzedr zzedr = this.zza;
        Objects.requireNonNull(zzedr);
        zzgee.zzr(this.zzb.zzb(new zzedt(zzedr)), new zzedu(this, zzfjq), this.zzb);
    }
}
