package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgad {
    public static ArrayList zza(int i) {
        zzfyk.zza(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static List zzb(List list, zzfwf zzfwf) {
        if (list instanceof RandomAccess) {
            return new zzgaa(list, zzfwf);
        }
        return new zzgac(list, zzfwf);
    }
}
