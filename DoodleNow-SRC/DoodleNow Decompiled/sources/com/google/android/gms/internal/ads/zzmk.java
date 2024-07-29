package com.google.android.gms.internal.ads;

import android.content.Context;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzmk {
    private final zzji zza;

    @Deprecated
    public zzmk(Context context, zzcfw zzcfw) {
        this.zza = new zzji(context, zzcfw);
    }

    @Deprecated
    public final zzmk zza(zzlc zzlc) {
        zzji zzji = this.zza;
        zzek.zzf(!zzji.zzq);
        zzlc.getClass();
        zzji.zzf = new zzja(zzlc);
        return this;
    }

    @Deprecated
    public final zzmk zzb(zzzf zzzf) {
        zzji zzji = this.zza;
        zzek.zzf(!zzji.zzq);
        zzzf.getClass();
        zzji.zze = new zzjh(zzzf);
        return this;
    }

    @Deprecated
    public final zzml zzc() {
        zzji zzji = this.zza;
        zzek.zzf(!zzji.zzq);
        zzji.zzq = true;
        return new zzml(zzji);
    }
}
