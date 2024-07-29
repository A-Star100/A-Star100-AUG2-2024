package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzedm {
    private final zzbwx zza;

    zzedm(zzbwx zzbwx) {
        this.zza = zzbwx;
    }

    public static void zza(Map map, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("pii");
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optJSONObject.optString("doritos", ""))) {
                    map.put("x-afma-drt-cookie", optJSONObject.optString("doritos", ""));
                }
                if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", ""))) {
                    map.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", ""));
                    return;
                }
                return;
            }
            zze.zza("DSID signal does not exist.");
        }
    }

    public final void zzb() {
        ListenableFuture zza2 = this.zza.zza();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhJ)).booleanValue()) {
            zzcbu.zzb(zza2, "persistFlags");
        } else {
            zzcbu.zza(zza2, "persistFlags");
        }
    }
}
