package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbjv implements zzbky {
    public static final /* synthetic */ zzbjv zza = new zzbjv();

    private /* synthetic */ zzbjv() {
    }

    public final void zza(Object obj, Map map) {
        zzchr zzchr = (zzchr) obj;
        zzbky zzbky = zzbkx.zza;
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzm.zzj("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(f.a);
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzchr.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            hashMap.put(str2, valueOf);
            zze.zza("/canOpenURLs;" + str2 + ";" + valueOf);
        }
        ((zzbnt) zzchr).zzd("openableURLs", hashMap);
    }
}
