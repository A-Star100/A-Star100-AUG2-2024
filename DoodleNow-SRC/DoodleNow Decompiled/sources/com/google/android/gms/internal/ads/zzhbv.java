package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhbv {
    private static final zzhbv zza = new zzhbv();
    private final zzhch zzb = new zzhbd();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzhbv() {
    }

    public static zzhbv zza() {
        return zza;
    }

    public final zzhcg zzb(Class cls) {
        zzhai.zzc(cls, "messageType");
        zzhcg zzhcg = (zzhcg) this.zzc.get(cls);
        if (zzhcg == null) {
            zzhcg = this.zzb.zza(cls);
            zzhai.zzc(cls, "messageType");
            zzhcg zzhcg2 = (zzhcg) this.zzc.putIfAbsent(cls, zzhcg);
            return zzhcg2 == null ? zzhcg : zzhcg2;
        }
    }
}
