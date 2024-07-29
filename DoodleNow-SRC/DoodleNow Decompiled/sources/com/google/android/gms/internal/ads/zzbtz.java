package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzbtz extends zzbih {
    final /* synthetic */ zzbuc zza;

    /* synthetic */ zzbtz(zzbuc zzbuc, zzbty zzbty) {
        this.zza = zzbuc;
    }

    public final void zze(zzbhy zzbhy, String str) {
        zzbuc zzbuc = this.zza;
        if (zzbuc.zzb != null) {
            zzbuc.zzb.onCustomClick(zzbuc.zzf(zzbhy), str);
        }
    }
}
