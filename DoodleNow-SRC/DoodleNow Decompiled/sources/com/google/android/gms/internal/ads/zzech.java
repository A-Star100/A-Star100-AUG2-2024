package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzech implements zzfjq {
    public static final /* synthetic */ zzech zza = new zzech();

    private /* synthetic */ zzech() {
    }

    public final Object zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zze.zza("Ad request signals:");
        zze.zza(jSONObject.toString(2));
        return jSONObject;
    }
}
