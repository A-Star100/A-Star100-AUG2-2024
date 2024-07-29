package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbce implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbcf zza;

    zzbce(zzbcf zzbcf) {
        this.zza = zzbcf;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzbcf zzbcf = this.zza;
            if (zzbcf.zzd != null) {
                zzbcf.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
