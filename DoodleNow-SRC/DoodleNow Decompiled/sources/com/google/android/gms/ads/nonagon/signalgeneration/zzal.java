package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdhc;
import com.google.android.gms.internal.ads.zzfjs;
import com.google.android.gms.internal.ads.zzfkh;
import com.google.android.gms.internal.ads.zzfkn;
import com.google.android.gms.internal.ads.zzgee;
import com.google.android.gms.internal.ads.zzhiv;
import com.google.android.gms.internal.ads.zzhjm;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzal implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;

    public zzal(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfjs zza2 = ((zzfkn) this.zza.zzb()).zzb(zzfkh.GENERATE_SIGNALS, ((zzcxv) this.zzc).zzb().zzc()).zzf(((zzao) this.zzb).zzb()).zzi((long) ((Integer) zzba.zzc().zza(zzbdz.zzfz)).intValue(), TimeUnit.SECONDS).zza();
        zzgee.zzr(zza2, new zzad((zzdhc) this.zzd.zzb()), zzcbr.zza);
        return zza2;
    }
}
