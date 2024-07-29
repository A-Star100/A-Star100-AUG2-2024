package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzebt implements zzgdl {
    public final /* synthetic */ zzebv zza;
    public final /* synthetic */ zzbxd zzb;

    public /* synthetic */ zzebt(zzebv zzebv, zzbxd zzbxd) {
        this.zza = zzebv;
        this.zzb = zzbxd;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (InputStream) obj);
    }
}
