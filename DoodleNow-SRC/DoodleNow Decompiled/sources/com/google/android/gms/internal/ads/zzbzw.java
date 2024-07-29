package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbzw {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzcad zzd;

    private zzbzw() {
    }

    /* synthetic */ zzbzw(zzbzv zzbzv) {
    }

    public final zzbzw zza(zzg zzg) {
        this.zzc = zzg;
        return this;
    }

    public final zzbzw zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzbzw zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzbzw zzd(zzcad zzcad) {
        this.zzd = zzcad;
        return this;
    }

    public final zzcae zze() {
        zzhjd.zzc(this.zza, Context.class);
        zzhjd.zzc(this.zzb, Clock.class);
        zzhjd.zzc(this.zzc, zzg.class);
        zzhjd.zzc(this.zzd, zzcad.class);
        return new zzbzy(this.zza, this.zzb, this.zzc, this.zzd, (zzbzx) null);
    }
}
