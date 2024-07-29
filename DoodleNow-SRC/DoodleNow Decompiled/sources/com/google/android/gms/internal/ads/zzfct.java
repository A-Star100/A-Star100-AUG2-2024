package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfct implements zzfde {
    private zzcxx zza;

    /* renamed from: zza */
    public final synchronized zzcxx zzd() {
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdf zzfdf, zzfdd zzfdd, Object obj) {
        return zzb(zzfdf, zzfdd, (zzcxx) null);
    }

    public final synchronized ListenableFuture zzb(zzfdf zzfdf, zzfdd zzfdd, zzcxx zzcxx) {
        zzcvd zzb;
        if (zzcxx != null) {
            this.zza = zzcxx;
        } else {
            this.zza = (zzcxx) zzfdd.zza(zzfdf.zzb).zzh();
        }
        zzb = this.zza.zzb();
        return zzb.zzi(zzb.zzj());
    }
}
