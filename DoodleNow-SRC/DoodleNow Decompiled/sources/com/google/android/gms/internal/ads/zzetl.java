package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzetl implements zzewq {
    public final String zza;
    public final boolean zzb;

    public zzetl(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString("de", "1");
        }
    }
}
