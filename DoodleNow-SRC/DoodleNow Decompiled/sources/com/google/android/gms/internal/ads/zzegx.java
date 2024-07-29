package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzegx implements zzdiu {
    public final /* synthetic */ zzegm zza;

    public /* synthetic */ zzegx(zzegm zzegm) {
        this.zza = zzegm;
    }

    public final void zza(boolean z, Context context, zzczd zzczd) {
        zzegm zzegm = this.zza;
        try {
            ((zzfhg) zzegm.zzb).zzv(z);
            ((zzfhg) zzegm.zzb).zzw(context);
        } catch (zzfgp e) {
            throw new zzdit(e.getCause());
        }
    }
}
