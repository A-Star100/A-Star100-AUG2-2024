package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzh;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzepk implements zzewr {
    private final zzgep zza;
    private final zzfgi zzb;
    private final zzfgx zzc;

    zzepk(zzgep zzgep, zzfgi zzfgi, zzfgx zzfgx) {
        this.zza = zzgep;
        this.zzb = zzfgi;
        this.zzc = zzfgx;
    }

    public final int zza() {
        return 5;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzepj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepl zzc() throws Exception {
        String str = null;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhl)).booleanValue() && "requester_type_2".equals(zzh.zzb(this.zzb.zzd))) {
            str = zzfgx.zza();
        }
        return new zzepl(str);
    }
}
