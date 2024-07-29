package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzerj implements zzewq {
    private final double zza;
    private final boolean zzb;

    public zzerj(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfgw.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfgw.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}
