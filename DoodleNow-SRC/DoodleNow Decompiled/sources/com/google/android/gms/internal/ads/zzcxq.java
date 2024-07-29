package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcxq implements zzdae, zzczl {
    private final Context zza;
    private final zzffn zzb;
    private final zzbuu zzc;

    public zzcxq(Context context, zzffn zzffn, zzbuu zzbuu) {
        this.zza = context;
        this.zzb = zzffn;
        this.zzc = zzbuu;
    }

    public final void zzdj(Context context) {
    }

    public final void zzdl(Context context) {
    }

    public final void zzdm(Context context) {
    }

    public final void zzs() {
        zzbuv zzbuv = this.zzb.zzae;
        if (zzbuv != null && zzbuv.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzae.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzae.zzb);
            }
        }
    }
}
