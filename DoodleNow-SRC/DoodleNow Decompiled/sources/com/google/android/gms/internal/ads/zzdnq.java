package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdnq implements zzgdl {
    public final /* synthetic */ zzdob zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdnq(zzdob zzdob, String str) {
        this.zza = zzdob;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, obj);
    }
}
