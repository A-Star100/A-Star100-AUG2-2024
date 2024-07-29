package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzq;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdoi implements zzgdl {
    public final /* synthetic */ zzdot zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzffn zzc;
    public final /* synthetic */ zzffq zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ String zzf;

    public /* synthetic */ zzdoi(zzdot zzdot, zzq zzq, zzffn zzffn, zzffq zzffq, String str, String str2) {
        this.zza = zzdot;
        this.zzb = zzq;
        this.zzc = zzffn;
        this.zzd = zzffq;
        this.zze = str;
        this.zzf = str2;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, obj);
    }
}
