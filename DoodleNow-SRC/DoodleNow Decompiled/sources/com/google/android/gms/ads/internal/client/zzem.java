package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzem {
    private final String zza;
    private final Bundle zzb;
    private final String zzc;

    public zzem(String str, Bundle bundle, String str2) {
        this.zza = str;
        this.zzb = bundle;
        this.zzc = str2;
    }

    public final Bundle zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        if (!TextUtils.isEmpty(this.zzc)) {
            try {
                return new JSONObject(this.zzc).optString(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, "");
            } catch (JSONException unused) {
            }
        }
        return "";
    }
}
