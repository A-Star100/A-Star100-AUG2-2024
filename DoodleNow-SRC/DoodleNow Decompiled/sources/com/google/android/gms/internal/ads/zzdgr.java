package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdgr {
    private final List zza;
    private final zzfmt zzb;
    private boolean zzc;

    public zzdgr(zzffn zzffn, zzfmt zzfmt) {
        this.zza = zzffn.zzq;
        this.zzb = zzfmt;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzd(this.zza);
            this.zzc = true;
        }
    }
}
