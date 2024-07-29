package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcln implements zzdvq {
    private final zzckh zza;
    private Context zzb;
    private zzblx zzc;

    /* synthetic */ zzcln(zzckh zzckh, zzclm zzclm) {
        this.zza = zzckh;
    }

    public final /* synthetic */ zzdvq zza(zzblx zzblx) {
        zzblx.getClass();
        this.zzc = zzblx;
        return this;
    }

    public final /* synthetic */ zzdvq zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzdvr zzc() {
        zzhjd.zzc(this.zzb, Context.class);
        zzhjd.zzc(this.zzc, zzblx.class);
        return new zzclp(this.zza, this.zzb, this.zzc, (zzclo) null);
    }
}
