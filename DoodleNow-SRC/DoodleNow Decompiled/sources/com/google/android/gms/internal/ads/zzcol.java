package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcol implements zzcob {
    private final zzdxf zza;

    zzcol(zzdxf zzdxf) {
        this.zza = zzdxf;
    }

    public final void zza(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzje)).booleanValue()) {
                this.zza.zzn(jSONObject);
            }
        }
    }
}
