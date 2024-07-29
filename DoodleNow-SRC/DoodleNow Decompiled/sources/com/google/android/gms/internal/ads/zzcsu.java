package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcsu implements zzhiv {
    private final zzhjm zza;

    public zzcsu(zzhjm zzhjm) {
        this.zza = zzhjm;
    }

    /* renamed from: zza */
    public final Boolean zzb() {
        boolean z = true;
        if (((zzcyh) this.zza).zza().zza() == null) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzfA)).booleanValue()) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
