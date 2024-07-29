package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgya implements Comparator {
    zzgya() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgyj zzgyj = (zzgyj) obj;
        zzgyj zzgyj2 = (zzgyj) obj2;
        zzgyd zzs = zzgyj.iterator();
        zzgyd zzs2 = zzgyj2.iterator();
        while (zzs.hasNext() && zzs2.hasNext()) {
            int compareTo = Integer.valueOf(zzs.zza() & 255).compareTo(Integer.valueOf(zzs2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzgyj.zzd()).compareTo(Integer.valueOf(zzgyj2.zzd()));
    }
}
