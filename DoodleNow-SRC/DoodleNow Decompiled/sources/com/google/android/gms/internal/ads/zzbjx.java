package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbjx implements zzbky {
    public static final /* synthetic */ zzbjx zza = new zzbjx();

    private /* synthetic */ zzbjx() {
    }

    public final void zza(Object obj, Map map) {
        zzchr zzchr = (zzchr) obj;
        zzbky zzbky = zzbkx.zza;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzii)).booleanValue()) {
            zzm.zzj("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzm.zzj("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(zzchr.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
        hashMap.put(str, valueOf);
        zze.zza("/canOpenApp;" + str + ";" + valueOf);
        ((zzbnt) zzchr).zzd("openableApp", hashMap);
    }
}
