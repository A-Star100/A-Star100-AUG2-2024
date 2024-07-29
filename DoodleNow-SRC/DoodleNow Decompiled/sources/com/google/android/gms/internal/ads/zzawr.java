package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzawr extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzaws zza;

    zzawr(zzaws zzaws) {
        this.zza = zzaws;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzaws.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzaws.class) {
            this.zza.zza = null;
        }
    }
}
