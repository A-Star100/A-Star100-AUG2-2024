package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzehp implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzehp(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeho((Context) this.zza.zzb(), (zzcsm) this.zzb.zzb(), (Executor) this.zzc.zzb());
    }
}
