package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdhi extends zzdee {
    private boolean zzb;

    protected zzdhi(Set set) {
        super(set);
    }

    public final void zza() {
        zzq(zzdhf.zza);
    }

    public final void zzb() {
        zzq(zzdhe.zza);
    }

    public final synchronized void zzc() {
        if (!this.zzb) {
            zzq(zzdhg.zza);
            this.zzb = true;
        }
        zzq(zzdhh.zza);
    }

    public final synchronized void zzd() {
        zzq(zzdhg.zza);
        this.zzb = true;
    }
}
