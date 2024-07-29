package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzczi extends zzdee {
    private boolean zzb = false;

    public zzczi(Set set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzq(zzczh.zza);
            this.zzb = true;
        }
    }
}
