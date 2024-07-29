package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbcd implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbcf zza;

    zzbcd(zzbcf zzbcf) {
        this.zza = zzbcf;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzbcf zzbcf = this.zza;
                if (zzbcf.zzd != null) {
                    zzbcf.zzf = zzbcf.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                zzm.zzh("Unable to obtain a cache service instance.", e);
                zzbcf.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
