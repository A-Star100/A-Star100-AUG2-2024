package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdys implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzdys(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzciq) this.zzb).zza();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        ListenableFuture zzb2 = zzgep.zzb(new zzdyp((zzawo) this.zza.zzb(), zza2));
        zzhjd.zzb(zzb2);
        return zzb2;
    }
}
