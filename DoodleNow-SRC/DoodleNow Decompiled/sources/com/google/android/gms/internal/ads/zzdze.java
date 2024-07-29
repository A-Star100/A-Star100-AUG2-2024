package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdze implements zzgdl {
    public final /* synthetic */ zzbxd zza;

    public /* synthetic */ zzdze(zzbxd zzbxd) {
        this.zza = zzbxd;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgee.zzh(new zzeam((InputStream) obj, this.zza));
    }
}
