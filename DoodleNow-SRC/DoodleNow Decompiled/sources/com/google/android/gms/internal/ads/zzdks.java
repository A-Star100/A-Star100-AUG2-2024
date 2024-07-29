package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdks implements zzgea {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdkt zzb;

    zzdks(zzdkt zzdkt, View view) {
        this.zza = view;
        this.zzb = zzdkt;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfd)).booleanValue()) {
            zzu.zzo().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzac(this.zza, (zzfmy) obj);
    }
}
