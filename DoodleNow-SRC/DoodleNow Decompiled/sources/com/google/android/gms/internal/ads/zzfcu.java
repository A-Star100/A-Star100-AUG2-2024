package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfcu implements zzfde {
    private final zzfde zza;
    private zzcxx zzb;

    public zzfcu(zzfde zzfde) {
        this.zza = zzfde;
    }

    /* renamed from: zza */
    public final synchronized zzcxx zzd() {
        return this.zzb;
    }

    public final synchronized ListenableFuture zzb(zzfdf zzfdf, zzfdd zzfdd, zzcxx zzcxx) {
        this.zzb = zzcxx;
        if (zzfdf.zza != null) {
            zzcvd zzb2 = this.zzb.zzb();
            return zzb2.zzi(zzb2.zzk(zzgee.zzh(zzfdf.zza)));
        }
        return ((zzfct) this.zza).zzb(zzfdf, zzfdd, zzcxx);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdf zzfdf, zzfdd zzfdd, Object obj) {
        return zzb(zzfdf, zzfdd, (zzcxx) null);
    }
}
