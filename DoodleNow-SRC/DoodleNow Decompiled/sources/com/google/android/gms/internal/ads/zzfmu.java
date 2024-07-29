package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfmu implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;

    public zzfmu(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzciq) this.zza).zza();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzfmt(zza2, zzgep, (zzr) this.zzc.zzb(), (zzflk) this.zzd.zzb());
    }
}
