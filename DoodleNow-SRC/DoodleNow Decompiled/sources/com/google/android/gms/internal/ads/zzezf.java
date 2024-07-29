package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzezf implements zzewr {
    final zzgep zza;
    final String zzb;
    final zzcav zzc;

    public zzezf(zzcav zzcav, zzgep zzgep, String str) {
        this.zzc = zzcav;
        this.zza = zzgep;
        this.zzb = str;
    }

    public final int zza() {
        return 47;
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzh = zzgee.zzh((Object) null);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfR)).booleanValue()) {
            zzh = zzgee.zzh((Object) null);
        }
        ListenableFuture zzh2 = zzgee.zzh((Object) null);
        return zzgee.zzc(zzh, zzh2).zza(new zzeze(zzh, zzh2), zzcbr.zza);
    }
}
