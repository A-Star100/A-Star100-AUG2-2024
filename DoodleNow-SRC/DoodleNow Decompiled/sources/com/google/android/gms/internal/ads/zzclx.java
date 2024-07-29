package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzclx implements zzfds {
    private final zzckh zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzclx(zzckh zzckh, zzclw zzclw) {
        this.zza = zzckh;
    }

    public final /* synthetic */ zzfds zza(zzq zzq) {
        zzq.getClass();
        this.zzd = zzq;
        return this;
    }

    public final /* synthetic */ zzfds zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfds zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfdt zzd() {
        zzhjd.zzc(this.zzb, Context.class);
        zzhjd.zzc(this.zzc, String.class);
        zzhjd.zzc(this.zzd, zzq.class);
        return new zzclz(this.zza, this.zzb, this.zzc, this.zzd, (zzcly) null);
    }
}
