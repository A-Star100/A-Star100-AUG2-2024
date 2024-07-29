package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzhaf extends AbstractList {
    private final List zza;
    private final zzhae zzb;

    public zzhaf(List list, zzhae zzhae) {
        this.zza = list;
        this.zzb = zzhae;
    }

    public final Object get(int i) {
        return this.zzb.zzb(this.zza.get(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
