package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdni implements zzhiv {
    private final zzdnb zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzdni(zzdnb zzdnb, zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzdnb;
        this.zzb = zzhjm;
        this.zzc = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgf(((zzdqi) this.zzb).zzb(), (Executor) this.zzc.zzb());
    }
}
