package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcud implements zzeke {
    public final List zza;

    public zzcud(zzctv zzctv) {
        this.zza = Collections.singletonList(zzgee.zzh(zzctv));
    }

    public zzcud(List list) {
        this.zza = list;
    }

    public final void zzq() {
        for (ListenableFuture zzr : this.zza) {
            zzgee.zzr(zzr, new zzcuc(this), zzgev.zzb());
        }
    }
}
