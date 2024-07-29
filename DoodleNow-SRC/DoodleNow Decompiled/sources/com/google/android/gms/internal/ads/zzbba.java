package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbba implements Comparator {
    zzbba(zzbbc zzbbc) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbbg zzbbg = (zzbbg) obj;
        zzbbg zzbbg2 = (zzbbg) obj2;
        int i = zzbbg.zzc - zzbbg2.zzc;
        if (i != 0) {
            return i;
        }
        return Long.compare(zzbbg.zza, zzbbg2.zza);
    }
}
