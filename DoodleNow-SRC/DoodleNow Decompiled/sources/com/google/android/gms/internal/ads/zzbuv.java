package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbuv {
    public final boolean zza;
    public final String zzb;

    public zzbuv(boolean z, String str) {
        this.zza = z;
        this.zzb = str;
    }

    public static zzbuv zza(JSONObject jSONObject) {
        return new zzbuv(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
