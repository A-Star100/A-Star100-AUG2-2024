package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzh;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzets implements zzewr {
    private final zzgep zza;
    private final zzfgi zzb;

    zzets(zzgep zzgep, zzfgi zzfgi) {
        this.zza = zzgep;
        this.zzb = zzfgi;
    }

    public final int zza() {
        return 21;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzetr(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzett zzc() throws Exception {
        return new zzett("requester_type_2".equals(zzh.zzb(this.zzb.zzd)));
    }
}
