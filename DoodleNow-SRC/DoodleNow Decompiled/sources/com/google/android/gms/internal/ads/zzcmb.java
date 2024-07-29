package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcmb implements zzffg {
    private final zzckh zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcmb(zzckh zzckh, zzcma zzcma) {
        this.zza = zzckh;
    }

    public final /* synthetic */ zzffg zza(String str) {
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzffg zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzffh zzc() {
        zzhjd.zzc(this.zzb, Context.class);
        return new zzcmd(this.zza, this.zzb, this.zzc, (zzcmc) null);
    }
}
