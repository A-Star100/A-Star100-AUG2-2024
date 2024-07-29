package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcqb implements zzbky {
    final /* synthetic */ zzcqc zza;

    zzcqb(zzcqc zzcqc) {
        this.zza = zzcqc;
    }

    public final void zza(Object obj, Map map) {
        if (zzcqc.zzg(this.zza, map)) {
            this.zza.zzc.execute(new zzcqa(this));
        }
    }
}
