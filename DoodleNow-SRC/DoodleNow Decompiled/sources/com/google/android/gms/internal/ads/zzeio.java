package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeio implements zzdiu {
    private final zzffn zza;
    private final zzbsn zzb;
    private final AdFormat zzc;
    private zzczi zzd = null;

    zzeio(zzffn zzffn, zzbsn zzbsn, AdFormat adFormat) {
        this.zza = zzffn;
        this.zzb = zzbsn;
        this.zzc = adFormat;
    }

    public final void zza(boolean z, Context context, zzczd zzczd) throws zzdit {
        boolean z2;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int ordinal = this.zzc.ordinal();
            if (ordinal == 1) {
                z2 = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else if (ordinal != 2) {
                if (ordinal == 5) {
                    z2 = this.zzb.zzr(ObjectWrapper.wrap(context));
                }
                throw new zzdit("Adapter failed to show.");
            } else {
                z2 = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (z2) {
                if (this.zzd != null) {
                    if (!((Boolean) zzba.zzc().zza(zzbdz.zzbw)).booleanValue() && this.zza.zzZ == 2) {
                        this.zzd.zza();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new zzdit("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdit(th);
        }
    }

    public final void zzb(zzczi zzczi) {
        this.zzd = zzczi;
    }
}
