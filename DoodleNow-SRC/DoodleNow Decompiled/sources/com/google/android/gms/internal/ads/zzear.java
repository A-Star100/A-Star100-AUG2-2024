package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzear implements zzgdl {
    public final /* synthetic */ zzbxd zza;

    public /* synthetic */ zzear(zzbxd zzbxd) {
        this.zza = zzbxd;
    }

    public final ListenableFuture zza(Object obj) {
        String str = new String(zzgbx.zzb((InputStream) obj), zzfwd.zzc);
        zzbxd zzbxd = this.zza;
        zzbxd.zzj = str;
        return zzgee.zzh(zzbxd);
    }
}
