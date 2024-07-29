package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfcq implements zzfde {
    private final zzfhw zza;
    private final Executor zzb;
    private final zzgea zzc = new zzfco(this);

    public zzfcq(zzfhw zzfhw, Executor executor) {
        this.zza = zzfhw;
        this.zzb = executor;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzcxx zzcxx, zzfcz zzfcz) throws Exception {
        zzfhw zzfhw = this.zza;
        zzfig zzfig = zzfcz.zzb;
        zzbxd zzbxd = zzfcz.zza;
        zzfif zzb2 = zzfhw.zzb(zzfig);
        if (!(zzb2 == null || zzbxd == null)) {
            zzgee.zzr(zzcxx.zzb().zzh(zzbxd), this.zzc, this.zzb);
        }
        return zzgee.zzh(new zzfcp(zzfig, zzbxd, zzb2));
    }

    public final ListenableFuture zzb(zzfdf zzfdf, zzfdd zzfdd, zzcxx zzcxx) {
        return zzgee.zze(zzgee.zzn(zzgdv.zzu(new zzfda(this.zza, zzcxx, this.zzb).zzc()), new zzfcm(this, zzcxx), this.zzb), Exception.class, new zzfcn(this), this.zzb);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdf zzfdf, zzfdd zzfdd, Object obj) {
        return zzb(zzfdf, zzfdd, (zzcxx) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
