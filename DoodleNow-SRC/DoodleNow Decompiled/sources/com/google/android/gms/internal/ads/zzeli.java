package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeli implements zzdiu {
    public final /* synthetic */ zzegm zza;

    public /* synthetic */ zzeli(zzegm zzegm) {
        this.zza = zzegm;
    }

    public final void zza(boolean z, Context context, zzczd zzczd) {
        zzegm zzegm = this.zza;
        try {
            ((zzfhg) zzegm.zzb).zzv(z);
            ((zzfhg) zzegm.zzb).zzA();
        } catch (zzfgp e) {
            zzm.zzk("Cannot show rewarded video.", e);
            throw new zzdit(e.getCause());
        }
    }
}
