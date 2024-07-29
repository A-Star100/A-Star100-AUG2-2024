package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcpb implements zzgdl {
    public final /* synthetic */ zzcpk zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzcpb(zzcpk zzcpk, String str) {
        this.zza = zzcpk;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (Throwable) obj);
    }
}
