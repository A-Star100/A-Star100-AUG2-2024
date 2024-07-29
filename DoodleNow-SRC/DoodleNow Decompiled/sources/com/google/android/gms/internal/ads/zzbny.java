package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbny implements Predicate {
    public final /* synthetic */ zzbky zza;

    public /* synthetic */ zzbny(zzbky zzbky) {
        this.zza = zzbky;
    }

    public final boolean apply(Object obj) {
        zzbky zzbky = (zzbky) obj;
        if (!(zzbky instanceof zzboe)) {
            return false;
        }
        return ((zzboe) zzbky).zzb.equals(this.zza);
    }
}
