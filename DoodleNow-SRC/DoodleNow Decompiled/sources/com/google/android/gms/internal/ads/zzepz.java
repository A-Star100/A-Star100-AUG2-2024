package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzepz implements zzewr {
    private final Set zza;

    zzepz(Set set) {
        this.zza = set;
    }

    public final int zza() {
        return 8;
    }

    public final ListenableFuture zzb() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zza) {
            arrayList.add(add);
        }
        return zzgee.zzh(new zzepy(arrayList));
    }
}
