package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeod implements zzdbb {
    private final AtomicReference zza = new AtomicReference();

    public final void zza(zzdg zzdg) {
        this.zza.set(zzdg);
    }

    public final void zzh(zzs zzs) {
        zzfcs.zza(this.zza, new zzeoc(zzs));
    }
}
