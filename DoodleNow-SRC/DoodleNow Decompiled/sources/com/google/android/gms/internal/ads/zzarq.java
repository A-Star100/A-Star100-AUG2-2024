package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzarq extends zzare {
    static List zza(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzaqi : (List) entry.getValue()) {
                    arrayList.add(new zzaqi((String) entry.getKey(), zzaqi));
                }
            }
        }
        return arrayList;
    }
}
