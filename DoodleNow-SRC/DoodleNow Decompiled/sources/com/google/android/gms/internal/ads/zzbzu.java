package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbzu implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzbzu(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    /* renamed from: zza */
    public final zzbzt zzb() {
        return new zzbzt((Clock) this.zza.zzb(), (zzbzr) this.zzb.zzb());
    }
}
