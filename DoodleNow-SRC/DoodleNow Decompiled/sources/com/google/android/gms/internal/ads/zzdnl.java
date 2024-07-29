package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdnl implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzdnl(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzdnk((zzbq) this.zza.zzb(), (Clock) this.zzb.zzb(), zzgep);
    }
}
