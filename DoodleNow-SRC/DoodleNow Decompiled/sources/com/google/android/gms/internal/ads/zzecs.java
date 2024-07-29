package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzecs implements zzbpj {
    zzecs() {
    }

    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzect zzect = (zzect) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjh)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzect.zzd.zzg());
            jSONObject2.put("ad_request_post_body", zzect.zzd.zzf());
        }
        jSONObject2.put("base_url", zzect.zzd.zzd());
        jSONObject2.put("signals", zzect.zzc);
        jSONObject3.put(TtmlNode.TAG_BODY, zzect.zzb.zzc);
        jSONObject3.put("headers", zzay.zzb().zzj(zzect.zzb.zzb));
        jSONObject3.put(DiagnosticsTracker.RESPONSE_CODE_KEY, zzect.zzb.zza);
        jSONObject3.put("latency", zzect.zzb.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzect.zzd.zzi());
        return jSONObject;
    }
}
