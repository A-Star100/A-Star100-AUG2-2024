package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzckp implements zzfan {
    private final zzckh zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzckp(zzckh zzckh, zzcko zzcko) {
        this.zza = zzckh;
    }

    public final /* synthetic */ zzfan zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfan zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfao zzc() {
        zzhjd.zzc(this.zzb, Context.class);
        zzhjd.zzc(this.zzc, String.class);
        return new zzckr(this.zza, this.zzb, this.zzc, (zzckq) null);
    }
}
