package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcny {
    private final Map zza;
    private final Map zzb;

    zzcny(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzffz zzffz) throws Exception {
        for (zzffx zzffx : zzffz.zzb.zzc) {
            if (this.zza.containsKey(zzffx.zza)) {
                ((zzcob) this.zza.get(zzffx.zza)).zza(zzffx.zzb);
            } else if (this.zzb.containsKey(zzffx.zza)) {
                zzcoa zzcoa = (zzcoa) this.zzb.get(zzffx.zza);
                JSONObject jSONObject = zzffx.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzcoa.zza(hashMap);
            }
        }
    }
}
