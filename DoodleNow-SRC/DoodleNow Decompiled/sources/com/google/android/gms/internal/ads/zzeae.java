package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeae implements zzdbl {
    private final Context zza;
    private final zzcad zzb;

    zzeae(Context context, zzcad zzcad) {
        this.zza = context;
        this.zzb = zzcad;
    }

    public final void zzdn(zzbxd zzbxd) {
    }

    public final void zzdo(zzffz zzffz) {
        if (!TextUtils.isEmpty(zzffz.zzb.zzb.zzd)) {
            this.zzb.zzm(this.zza, zzffz.zza.zza.zzd);
            this.zzb.zzi(this.zza, zzffz.zzb.zzb.zzd);
        }
    }
}
