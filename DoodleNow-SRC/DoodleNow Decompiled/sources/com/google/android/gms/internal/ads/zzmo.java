package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.wifi.WifiManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzmo {
    private final WifiManager zza;

    public zzmo(Context context) {
        this.zza = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }
}
