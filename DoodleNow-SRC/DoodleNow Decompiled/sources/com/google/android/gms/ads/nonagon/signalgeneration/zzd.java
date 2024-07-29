package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzdgz;
import com.google.android.gms.internal.ads.zzduc;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzd implements zzdgz {
    private final zzduc zza;
    private final zzc zzb;
    private final String zzc;

    public zzd(zzduc zzduc, zzc zzc2, String str) {
        this.zza = zzduc;
        this.zzb = zzc2;
        this.zzc = str;
    }

    public final void zzd(zzap zzap) {
        if (zzap != null) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzha)).booleanValue()) {
                this.zzb.zzd(this.zzc, zzap.zzb, this.zza);
            }
        }
    }

    public final void zze(String str) {
    }
}
