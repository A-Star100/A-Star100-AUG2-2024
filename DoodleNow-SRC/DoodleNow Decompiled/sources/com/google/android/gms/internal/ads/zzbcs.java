package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbcs implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcbw zza;
    final /* synthetic */ zzbct zzb;

    zzbcs(zzbct zzbct, zzcbw zzcbw) {
        this.zza = zzcbw;
        this.zzb = zzbct;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
