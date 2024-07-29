package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbla implements zzbky {
    private final zzblb zza;

    public zzbla(zzblb zzblb) {
        this.zza = zzblb;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzm.zzh("Fail to parse float", e);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f);
        zzcgm.zzav(equals);
    }
}
