package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzclp implements zzdvr {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzblx zzb;
    private final zzckh zzc;
    private final zzclp zzd = this;
    private final zzhje zze;
    private final zzhje zzf;
    private final zzhje zzg;
    private final zzhje zzh;

    /* synthetic */ zzclp(zzckh zzckh, Context context, zzblx zzblx, zzclo zzclo) {
        this.zzc = zzckh;
        this.zza = context;
        this.zzb = zzblx;
        zzhiv zza2 = zzhiw.zza(this);
        this.zze = zza2;
        zzhiv zza3 = zzhiw.zza(zzblx);
        this.zzf = zza3;
        zzdvn zzdvn = new zzdvn(zza3);
        this.zzg = zzdvn;
        this.zzh = zzhiu.zzc(new zzdvp(zza2, zzdvn));
    }

    public final zzdvi zzb() {
        return new zzclj(this.zzc, this.zzd, (zzcli) null);
    }

    public final zzdvo zzd() {
        return (zzdvo) this.zzh.zzb();
    }
}
