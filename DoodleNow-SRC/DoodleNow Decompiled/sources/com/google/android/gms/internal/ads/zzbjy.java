package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbjy implements zzgdl {
    public final /* synthetic */ zzcpk zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbjy(zzcpk zzcpk, String str) {
        this.zza = zzcpk;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        zzcpk zzcpk;
        String str = (String) obj;
        zzbky zzbky = zzbkx.zza;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzjR)).booleanValue() || (zzcpk = this.zza) == null || !zzcpk.zzj(this.zzb)) {
            return zzgee.zzh(str);
        }
        return zzcpk.zzb(str, zzay.zze());
    }
}
