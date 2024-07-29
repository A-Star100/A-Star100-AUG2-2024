package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfci implements zzfiq {
    private final zzfde zza;

    public zzfci(zzfde zzfde) {
        this.zza = zzfde;
    }

    public final ListenableFuture zza(zzfir zzfir) {
        zzfcj zzfcj = (zzfcj) zzfir;
        return ((zzfcf) this.zza).zzb(zzfcj.zzb, zzfcj.zza, (zzcxx) null);
    }

    public final void zzb(zzfif zzfif) {
        zzfif.zza = ((zzfcf) this.zza).zza();
    }
}
