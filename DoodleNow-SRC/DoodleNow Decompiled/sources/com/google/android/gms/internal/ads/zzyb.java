package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzyb implements Comparator {
    public static final /* synthetic */ zzyb zza = new zzyb();

    private /* synthetic */ zzyb() {
    }

    public final int compare(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        return zzfzc.zzk().zzd((zzyw) Collections.max(list, zzyu.zza), (zzyw) Collections.max(list2, zzyu.zza), zzyu.zza).zzb(list.size(), list2.size()).zzd((zzyw) Collections.max(list, zzyv.zza), (zzyw) Collections.max(list2, zzyv.zza), zzyv.zza).zza();
    }
}
