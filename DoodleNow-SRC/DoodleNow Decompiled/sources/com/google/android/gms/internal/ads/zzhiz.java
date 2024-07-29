package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhiz extends zzhir {
    private static final zzhje zza = zzhiw.zza(Collections.emptyMap());

    /* synthetic */ zzhiz(Map map, zzhix zzhix) {
        super(map);
    }

    public static zzhiy zzc(int i) {
        return new zzhiy(i, (zzhix) null);
    }

    /* renamed from: zzd */
    public final Map zzb() {
        LinkedHashMap zzb = zzhis.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzb.put(entry.getKey(), ((zzhje) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzb);
    }
}
