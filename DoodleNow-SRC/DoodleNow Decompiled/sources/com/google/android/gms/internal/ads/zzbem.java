package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbem {
    private final Map zza = new HashMap();
    private final zzbeo zzb;

    public zzbem(zzbeo zzbeo) {
        this.zzb = zzbeo;
    }

    public final zzbeo zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbel zzbel) {
        this.zza.put(str, zzbel);
    }

    public final void zzc(String str, String str2, long j) {
        zzbel zzbel = (zzbel) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbel != null) {
            this.zzb.zze(zzbel, j, strArr);
        }
        this.zza.put(str, new zzbel(j, (String) null, (zzbel) null));
    }
}
