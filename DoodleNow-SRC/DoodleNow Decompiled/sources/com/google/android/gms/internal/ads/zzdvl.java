package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdvl {
    /* access modifiers changed from: private */
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public Integer zzf;

    /* synthetic */ zzdvl(String str, zzdvk zzdvk) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdvl zzdvl) {
        String str = (String) zzba.zzc().zza(zzbdz.zzjO);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdvl.zza);
            jSONObject.put("eventCategory", zzdvl.zzb);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, zzdvl.zzc);
            jSONObject.putOpt("errorCode", zzdvl.zzd);
            jSONObject.putOpt("rewardType", zzdvl.zze);
            jSONObject.putOpt("rewardAmount", zzdvl.zzf);
        } catch (JSONException unused) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        return str + "(\"h5adsEvent\"," + jSONObject2 + ");";
    }
}
