package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcbe extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzcbh zza;

    zzcbe(zzcbh zzcbh) {
        this.zza = zzcbh;
    }

    public final void onAvailable(Network network) {
        this.zza.zzo.set(true);
    }

    public final void onLost(Network network) {
        this.zza.zzo.set(false);
    }
}
