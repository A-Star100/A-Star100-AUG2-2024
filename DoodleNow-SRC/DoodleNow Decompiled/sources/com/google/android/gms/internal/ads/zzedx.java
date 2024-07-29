package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzedx implements zzdae, zzcyt {
    private static final Object zza = new Object();
    private static int zzb;
    private final zzg zzc;
    private final zzeeh zzd;

    public zzedx(zzeeh zzeeh, zzg zzg) {
        this.zzd = zzeeh;
        this.zzc = zzg;
    }

    private final void zzb(boolean z) {
        int i;
        int intValue;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue() && !this.zzc.zzO()) {
            Object obj = zza;
            synchronized (obj) {
                i = zzb;
                intValue = ((Integer) zzba.zzc().zza(zzbdz.zzgn)).intValue();
            }
            if (i < intValue) {
                this.zzd.zzd(z);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    public final void zzdB(zze zze) {
        zzb(false);
    }

    public final void zzs() {
        zzb(true);
    }
}
