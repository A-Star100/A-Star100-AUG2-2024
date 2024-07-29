package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbfv;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zze extends zzm {
    public static void zza(String str) {
        if (!zzc()) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.v("Ads", str);
            return;
        }
        boolean z = true;
        for (String str2 : zza.zzd(str)) {
            if (z) {
                Log.v("Ads", str2);
            } else {
                Log.v("Ads-cont", str2);
            }
            z = false;
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzc()) {
            Log.v("Ads", str, th);
        }
    }

    public static boolean zzc() {
        return zzm(2) && ((Boolean) zzbfv.zza.zze()).booleanValue();
    }
}
