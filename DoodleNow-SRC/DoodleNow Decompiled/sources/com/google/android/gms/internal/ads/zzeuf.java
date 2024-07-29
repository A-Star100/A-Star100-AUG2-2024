package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeuf implements zzewq {
    public final Bundle zza;

    public zzeuf(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfgw.zza(bundle, "device");
        zza2.putBundle("android_mem_info", this.zza);
        bundle.putBundle("device", zza2);
    }
}
