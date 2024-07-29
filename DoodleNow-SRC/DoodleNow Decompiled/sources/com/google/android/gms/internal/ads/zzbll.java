package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbll implements zzbky {
    private final zzdyc zza;

    public zzbll(zzdyc zzdyc) {
        this.zza = zzdyc;
    }

    public final void zza(Object obj, Map map) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjm)).booleanValue()) {
            String str = (String) map.get("action");
            String str2 = (String) map.get("adUnitId");
            String str3 = (String) map.get("redirectUrl");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String str4 = (String) map.get("format");
                if (str.equals("load") && !TextUtils.isEmpty(str4)) {
                    this.zza.zzh(str2, str4, str3);
                } else if (str.equals("show")) {
                    this.zza.zzi(str2, str3);
                }
            }
        }
    }
}
