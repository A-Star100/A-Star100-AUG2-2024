package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeua implements zzewr {
    private final zzgep zza;
    private final zzdxf zzb;

    zzeua(zzgep zzgep, zzdxf zzdxf) {
        this.zza = zzgep;
        this.zzb = zzdxf;
    }

    public final int zza() {
        return 23;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzetz(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeub zzc() throws Exception {
        zzdxf zzdxf = this.zzb;
        String zzc = zzdxf.zzc();
        boolean zzr = zzdxf.zzr();
        boolean zzl = zzu.zzs().zzl();
        zzdxf zzdxf2 = this.zzb;
        return new zzeub(zzc, zzr, zzl, zzdxf2.zzp(), zzdxf2.zzs());
    }
}
