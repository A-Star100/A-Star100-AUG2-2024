package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbap implements Runnable {
    final /* synthetic */ zzbaq zza;

    zzbap(zzbaq zzbaq) {
        this.zza = zzbaq;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            zzbaq zzbaq = this.zza;
            if (!zzbaq.zzd || !zzbaq.zze) {
                zzm.zze("App is still foreground");
            } else {
                zzbaq.zzd = false;
                zzm.zze("App went background");
                for (zzbar zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e) {
                        zzm.zzh("", e);
                    }
                }
            }
        }
    }
}
