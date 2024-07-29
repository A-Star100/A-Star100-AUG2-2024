package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b;
import com.amplitude.api.Constants;
import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdwz {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private final int zzf;
    private final boolean zzg;

    public zzdwz(String str, String str2, String str3, int i, String str4, int i2, boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = i;
        this.zze = str4;
        this.zzf = i2;
        this.zzg = z;
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adapterClassName", this.zza);
        jSONObject.put(Constants.AMP_PLAN_VERSION, this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjk)).booleanValue()) {
            jSONObject.put(b.I, this.zzb);
        }
        jSONObject.put("status", this.zzd);
        jSONObject.put(b.c, this.zze);
        jSONObject.put("initializationLatencyMillis", this.zzf);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjl)).booleanValue()) {
            jSONObject.put("supportsInitialization", this.zzg);
        }
        return jSONObject;
    }
}
