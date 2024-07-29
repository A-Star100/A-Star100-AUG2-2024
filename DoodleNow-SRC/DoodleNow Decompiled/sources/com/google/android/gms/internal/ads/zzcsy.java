package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcsy implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzcsy(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    /* renamed from: zza */
    public final zzcsx zzb() {
        return new zzcsx(((zzcsi) this.zza).zza(), (Executor) this.zzb.zzb());
    }
}
