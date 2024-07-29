package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfcf implements zzfde {
    private zzcxx zza;
    private final Executor zzb = zzgev.zzb();

    public final zzcxx zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzfdf zzfdf, zzfdd zzfdd, zzcxx zzcxx) {
        zzcxw zza2 = zzfdd.zza(zzfdf.zzb);
        zza2.zzb(new zzfdi(true));
        zzcxx zzcxx2 = (zzcxx) zza2.zzh();
        this.zza = zzcxx2;
        zzcvd zzb2 = zzcxx2.zzb();
        zzfif zzfif = new zzfif();
        return zzgee.zzm(zzgee.zzn(zzgdv.zzu(zzb2.zzj()), new zzfcd(this, zzfif, zzb2), this.zzb), new zzfce(zzfif), this.zzb);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdf zzfdf, zzfdd zzfdd, Object obj) {
        return zzb(zzfdf, zzfdd, (zzcxx) null);
    }

    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
