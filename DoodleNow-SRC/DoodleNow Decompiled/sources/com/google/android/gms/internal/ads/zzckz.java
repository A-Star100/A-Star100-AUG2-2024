package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzckz implements zzfcb {
    private final zzckh zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzckz(zzckh zzckh, zzcky zzcky) {
        this.zza = zzckh;
    }

    public final /* synthetic */ zzfcb zza(zzq zzq) {
        zzq.getClass();
        this.zzd = zzq;
        return this;
    }

    public final /* synthetic */ zzfcb zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfcb zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfcc zzd() {
        zzhjd.zzc(this.zzb, Context.class);
        zzhjd.zzc(this.zzc, String.class);
        zzhjd.zzc(this.zzd, zzq.class);
        return new zzclb(this.zza, this.zzb, this.zzc, this.zzd, (zzcla) null);
    }
}
