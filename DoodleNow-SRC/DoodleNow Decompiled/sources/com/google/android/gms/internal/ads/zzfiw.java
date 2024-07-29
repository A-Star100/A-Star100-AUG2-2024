package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfiw implements zzgdl {
    public final /* synthetic */ zzfiy zza;
    public final /* synthetic */ zzfiq zzb;
    public final /* synthetic */ zzfhw zzc;
    public final /* synthetic */ zzfir zzd;

    public /* synthetic */ zzfiw(zzfiy zzfiy, zzfiq zzfiq, zzfhw zzfhw, zzfir zzfir) {
        this.zza = zzfiy;
        this.zzb = zzfiq;
        this.zzc = zzfhw;
        this.zzd = zzfir;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, (zzfif) obj);
    }
}
