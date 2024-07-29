package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzebo {
    private final zzgep zza;
    private final zzebj zzb;
    private final zzfkn zzc;

    zzebo(zzgep zzgep, zzebj zzebj, zzfkn zzfkn) {
        this.zza = zzgep;
        this.zzb = zzebj;
        this.zzc = zzfkn;
    }

    public final ListenableFuture zza(zzbxd zzbxd) {
        zzfke zzb2 = this.zzc.zzb(zzfkh.GMS_SIGNALS, zzgee.zzm(zzgee.zzh((Object) null), new zzebl(zzbxd), this.zza));
        zzebj zzebj = this.zzb;
        Objects.requireNonNull(zzebj);
        return zzgee.zzm(zzb2.zzf(new zzebm(zzebj)).zza(), new zzebn(this, zzbxd), this.zza);
    }
}
