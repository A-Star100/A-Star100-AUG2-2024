package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcou implements zzcob {
    private final zzbzt zza;

    zzcou(zzbzt zzbzt) {
        this.zza = zzbzt;
    }

    public final void zza(JSONObject jSONObject) {
        int i;
        long optLong = jSONObject.optLong("timestamp");
        if (jSONObject.optBoolean("npa_reset")) {
            i = -1;
        } else {
            i = jSONObject.optBoolean("npa");
        }
        this.zza.zzb(i, optLong);
    }
}
