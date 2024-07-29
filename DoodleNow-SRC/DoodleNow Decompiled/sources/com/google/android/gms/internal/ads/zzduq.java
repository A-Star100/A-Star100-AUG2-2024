package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults_Factory;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder_Factory;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzduq implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;

    public zzduq(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzdum(zzgep, (zzr) this.zzb.zzb(), ((CsiParamDefaults_Factory) this.zzc).zzb(), ((CsiUrlBuilder_Factory) this.zzd).zzb(), ((zzciq) this.zze).zza());
    }
}
