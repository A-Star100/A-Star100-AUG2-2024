package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcbd extends zzb {
    final /* synthetic */ zzcbh zza;

    zzcbd(zzcbh zzcbh) {
        this.zza = zzcbh;
    }

    public final void zza() {
        zzcbh zzcbh = this.zza;
        zzbec zzbec = new zzbec(zzcbh.zze, zzcbh.zzf.afmaVersion);
        synchronized (this.zza.zza) {
            try {
                zzu.zze();
                zzbef.zza(this.zza.zzh, zzbec);
            } catch (IllegalArgumentException e) {
                zzm.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
