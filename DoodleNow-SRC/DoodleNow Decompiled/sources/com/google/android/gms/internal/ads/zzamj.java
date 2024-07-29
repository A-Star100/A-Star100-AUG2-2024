package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzamj {
    public static zzamk zza(zzamk zzamk, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzamk == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzamk) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzamk zzamk2 = new zzamk();
                while (i < length2) {
                    zzamk2.zzl((zzamk) map.get(strArr[i]));
                    i++;
                }
                return zzamk2;
            }
        } else if (strArr != null && strArr.length == 1) {
            zzamk.zzl((zzamk) map.get(strArr[0]));
            return zzamk;
        } else if (strArr != null && (length = strArr.length) > 1) {
            while (i < length) {
                zzamk.zzl((zzamk) map.get(strArr[i]));
                i++;
            }
        }
        return zzamk;
    }
}
