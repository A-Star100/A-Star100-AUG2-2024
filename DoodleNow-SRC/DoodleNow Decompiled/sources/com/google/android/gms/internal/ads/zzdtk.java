package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdtk implements zzfko {
    private final Map zza;
    private final zzbcx zzb;

    zzdtk(zzbcx zzbcx, Map map) {
        this.zza = map;
        this.zzb = zzbcx;
    }

    public final void zzd(zzfkh zzfkh, String str) {
        if (this.zza.containsKey(zzfkh)) {
            this.zzb.zzb(((zzdtj) this.zza.get(zzfkh)).zzb);
        }
    }

    public final void zzdC(zzfkh zzfkh, String str) {
    }

    public final void zzdD(zzfkh zzfkh, String str, Throwable th) {
        if (this.zza.containsKey(zzfkh)) {
            this.zzb.zzb(((zzdtj) this.zza.get(zzfkh)).zzc);
        }
    }

    public final void zzdE(zzfkh zzfkh, String str) {
        if (this.zza.containsKey(zzfkh)) {
            this.zzb.zzb(((zzdtj) this.zza.get(zzfkh)).zza);
        }
    }
}
