package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdzo implements zzgdl {
    public final /* synthetic */ zzdzr zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzdzo(zzdzr zzdzr, String str, String str2) {
        this.zza = zzdzr;
        this.zzb = str;
        this.zzc = str2;
    }

    public final ListenableFuture zza(Object obj) {
        String str = (String) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        String str2 = this.zzb;
        String str3 = this.zzc;
        try {
            jSONObject3.put("headers", new JSONObject());
            jSONObject3.put(TtmlNode.TAG_BODY, str2);
            jSONObject2.put("base_url", "");
            jSONObject2.put("signals", new JSONObject(str3));
            jSONObject.put("request", jSONObject2);
            jSONObject.put("response", jSONObject3);
            jSONObject.put("flags", new JSONObject());
            return zzgee.zzh(jSONObject);
        } catch (JSONException e) {
            throw new JSONException("Preloaded loader: ".concat(String.valueOf(String.valueOf(e.getCause()))));
        }
    }
}
