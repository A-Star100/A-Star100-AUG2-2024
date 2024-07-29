package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfch implements zzgdl {
    public final /* synthetic */ zzfck zza;
    public final /* synthetic */ zzfdf zzb;
    public final /* synthetic */ zzfcj zzc;
    public final /* synthetic */ zzfdd zzd;
    public final /* synthetic */ zzcxx zze;

    public /* synthetic */ zzfch(zzfck zzfck, zzfdf zzfdf, zzfcj zzfcj, zzfdd zzfdd, zzcxx zzcxx) {
        this.zza = zzfck;
        this.zzb = zzfdf;
        this.zzc = zzfcj;
        this.zzd = zzfdd;
        this.zze = zzcxx;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze, (zzfcp) obj);
    }
}
