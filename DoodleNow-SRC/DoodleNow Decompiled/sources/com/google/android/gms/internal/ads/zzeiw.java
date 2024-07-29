package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeiw implements zzegl {
    private final zzdry zza;

    public zzeiw(zzdry zzdry) {
        this.zza = zzdry;
    }

    public final zzegm zza(String str, JSONObject jSONObject) throws zzfgp {
        return new zzegm(this.zza.zzc(str, jSONObject), new zzeif(), str);
    }
}
