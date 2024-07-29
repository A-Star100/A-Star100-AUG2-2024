package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdmw implements zzgea {
    final /* synthetic */ zzdmx zza;

    zzdmw(zzdmx zzdmx) {
        this.zza = zzdmx;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfd)).booleanValue()) {
            zzu.zzo().zzw(th, "omid native display exp");
        }
    }

    /* renamed from: zzc */
    public final void zzb(List list) {
        try {
            zzcgm zzcgm = (zzcgm) list.get(0);
            if (zzcgm != null) {
                this.zza.zzb(zzcgm);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzfd)).booleanValue()) {
                zzu.zzo().zzw(e, "omid native display exp");
            }
        }
    }
}
