package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzerv implements zzewr {
    private final zzgep zza;
    private final zzdsd zzb;
    private final String zzc;
    private final zzfgi zzd;

    public zzerv(zzgep zzgep, zzdsd zzdsd, zzfgi zzfgi, String str) {
        this.zza = zzgep;
        this.zzb = zzdsd;
        this.zzd = zzfgi;
        this.zzc = str;
    }

    public final int zza() {
        return 17;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeru(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzerw zzc() throws Exception {
        zzfgi zzfgi = this.zzd;
        zzdsd zzdsd = this.zzb;
        return new zzerw(zzdsd.zzb(zzfgi.zzf, this.zzc), zzdsd.zza());
    }
}
