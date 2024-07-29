package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdpx;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzm implements zzgdl {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ zzdpx[] zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzm(zzab zzab, zzdpx[] zzdpxArr, String str) {
        this.zza = zzab;
        this.zzb = zzdpxArr;
        this.zzc = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzv(this.zzb, this.zzc, (zzdpx) obj);
    }
}
