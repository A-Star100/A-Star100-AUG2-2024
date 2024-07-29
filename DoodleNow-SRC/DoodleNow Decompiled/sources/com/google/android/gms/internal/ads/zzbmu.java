package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbmu implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcbw zza;

    zzbmu(zzbmv zzbmv, zzcbw zzcbw) {
        this.zza = zzcbw;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zza.zzd(new RuntimeException("Connection failed."));
    }
}
