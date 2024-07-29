package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdmd implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzdmd(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdmc(((zzdkc) this.zza).zza(), (Clock) this.zzb.zzb());
    }
}
