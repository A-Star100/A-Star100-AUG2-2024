package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeso implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzeso(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzs zzfzs;
        zzeto zza2 = ((zzetq) this.zza).zzb();
        Context zza3 = ((zzciq) this.zzb).zza();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzla)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzB(zza3)) {
                zzfzs = zzfzs.zzo(zza2);
                zzhjd.zzb(zzfzs);
                return zzfzs;
            }
        }
        zzfzs = zzfzs.zzn();
        zzhjd.zzb(zzfzs);
        return zzfzs;
    }
}
