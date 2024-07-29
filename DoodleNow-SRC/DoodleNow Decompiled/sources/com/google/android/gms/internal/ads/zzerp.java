package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzerp implements zzewr {
    private final AtomicReference zza = new AtomicReference();
    private final Clock zzb;
    private final zzewr zzc;
    private final long zzd;

    public zzerp(zzewr zzewr, long j, Clock clock) {
        this.zzb = clock;
        this.zzc = zzewr;
        this.zzd = j;
    }

    public final int zza() {
        return 16;
    }

    public final ListenableFuture zzb() {
        zzero zzero = (zzero) this.zza.get();
        if (zzero == null || zzero.zza()) {
            zzewr zzewr = this.zzc;
            zzero zzero2 = new zzero(zzewr.zzb(), this.zzd, this.zzb);
            this.zza.set(zzero2);
            zzero = zzero2;
        }
        return zzero.zza;
    }
}
