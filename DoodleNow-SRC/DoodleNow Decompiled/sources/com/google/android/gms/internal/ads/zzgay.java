package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgay implements Comparator {
    protected zzgay() {
    }

    public static zzgay zzb(Comparator comparator) {
        return new zzfyy(comparator);
    }

    public static zzgay zzc() {
        return zzgaw.zza;
    }

    public abstract int compare(Object obj, Object obj2);

    public zzgay zza() {
        return new zzgbh(this);
    }
}
