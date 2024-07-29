package com.google.android.gms.internal.ads;

import android.util.Log;
import com.revenuecat.purchases.common.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhii extends zzhin {
    final String zza;

    public zzhii(String str) {
        this.zza = str;
    }

    public final void zza(String str) {
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
