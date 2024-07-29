package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcpf implements zzgdl {
    public final /* synthetic */ zzcpk zza;
    public final /* synthetic */ Uri.Builder zzb;

    public /* synthetic */ zzcpf(zzcpk zzcpk, Uri.Builder builder) {
        this.zza = zzcpk;
        this.zzb = builder;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zze(this.zzb, (Throwable) obj);
    }
}
