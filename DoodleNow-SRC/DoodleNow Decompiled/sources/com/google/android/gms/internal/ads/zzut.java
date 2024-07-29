package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzut {
    private final zzadm zza;
    private final Map zzb = new HashMap();
    private final Set zzc = new HashSet();
    private final Map zzd = new HashMap();
    private zzgu zze;
    private final zzalf zzf;

    public zzut(zzadm zzadm, zzalf zzalf) {
        this.zza = zzadm;
        this.zzf = zzalf;
    }

    public final void zza(zzgu zzgu) {
        if (zzgu != this.zze) {
            this.zze = zzgu;
            this.zzb.clear();
            this.zzd.clear();
        }
    }
}
