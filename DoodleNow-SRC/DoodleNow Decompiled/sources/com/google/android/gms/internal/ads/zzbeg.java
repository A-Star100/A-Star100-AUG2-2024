package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbeg {
    public static boolean zza(zzbeo zzbeo, zzbel zzbel, String... strArr) {
        if (zzbel == null) {
            return false;
        }
        zzbeo.zze(zzbel, zzu.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
