package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdnm implements Callable {
    public final /* synthetic */ zzdno zza;
    public final /* synthetic */ zzffz zzb;
    public final /* synthetic */ zzffn zzc;
    public final /* synthetic */ JSONObject zzd;

    public /* synthetic */ zzdnm(zzdno zzdno, zzffz zzffz, zzffn zzffn, JSONObject jSONObject) {
        this.zza = zzdno;
        this.zzb = zzffz;
        this.zzc = zzffn;
        this.zzd = jSONObject;
    }

    public final Object call() {
        zzdky zzdky = new zzdky();
        JSONObject jSONObject = this.zzd;
        zzdky.zzaa(jSONObject.optInt("template_id", -1));
        zzdky.zzK(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        String optString = optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null;
        zzffz zzffz = this.zzb;
        zzdky.zzV(optString);
        zzfgi zzfgi = zzffz.zza.zza;
        if (zzfgi.zzg.contains(Integer.toString(zzdky.zzc()))) {
            if (zzdky.zzc() == 3) {
                if (zzdky.zzA() == null) {
                    throw new zzekh(1, "No custom template id for custom template ad response.");
                } else if (!zzfgi.zzh.contains(zzdky.zzA())) {
                    throw new zzekh(1, "Unexpected custom template id in the response.");
                }
            }
            zzffn zzffn = this.zzc;
            zzdky.zzY(jSONObject.optDouble("rating", -1.0d));
            String optString2 = jSONObject.optString("headline", (String) null);
            if (zzffn.zzN) {
                zzu.zzp();
                optString2 = zzt.zzy() + " : " + optString2;
            }
            zzdky.zzZ("headline", optString2);
            zzdky.zzZ(TtmlNode.TAG_BODY, jSONObject.optString(TtmlNode.TAG_BODY, (String) null));
            zzdky.zzZ("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdky.zzZ(ProductResponseJsonKeys.STORE, jSONObject.optString(ProductResponseJsonKeys.STORE, (String) null));
            zzdky.zzZ(b.x, jSONObject.optString(b.x, (String) null));
            zzdky.zzZ("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzdky;
        }
        throw new zzekh(1, "Invalid template ID: " + zzdky.zzc());
    }
}
