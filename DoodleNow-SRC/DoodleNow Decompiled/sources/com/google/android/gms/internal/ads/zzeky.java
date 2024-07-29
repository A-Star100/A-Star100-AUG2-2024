package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeky implements zzegl {
    private final Map zza = new HashMap();
    private final zzdry zzb;

    public zzeky(zzdry zzdry) {
        this.zzb = zzdry;
    }

    public final zzegm zza(String str, JSONObject jSONObject) throws zzfgp {
        zzegm zzegm;
        synchronized (this) {
            zzegm = (zzegm) this.zza.get(str);
            if (zzegm == null) {
                zzegm = new zzegm(this.zzb.zzc(str, jSONObject), new zzeig(), str);
                this.zza.put(str, zzegm);
            }
        }
        return zzegm;
    }
}
