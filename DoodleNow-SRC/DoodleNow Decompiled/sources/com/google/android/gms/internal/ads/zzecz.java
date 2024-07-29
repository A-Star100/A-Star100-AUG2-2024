package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzecz implements zzfjq {
    public static final /* synthetic */ zzecz zza = new zzecz();

    private /* synthetic */ zzecz() {
    }

    public final Object zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zze.zza("GMS AdRequest Signals: ");
        zze.zza(jSONObject.toString(2));
        return jSONObject;
    }
}
