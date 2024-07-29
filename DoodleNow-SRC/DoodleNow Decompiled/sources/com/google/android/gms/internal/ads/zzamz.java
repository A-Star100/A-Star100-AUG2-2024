package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.common.Constants;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzamz {
    private static final Pattern zza = Pattern.compile("^NOTE([ \t].*)?$");

    public static float zza(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long zzb(String str) throws NumberFormatException {
        int i = zzfx.zza;
        String[] split = str.split("\\.", 2);
        long j = 0;
        for (String parseLong : split[0].split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)) {
            j = (j * 60) + Long.parseLong(parseLong);
        }
        long j2 = j * 1000;
        if (split.length == 2) {
            j2 += Long.parseLong(split[1]);
        }
        return j2 * 1000;
    }
}
