package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbzf implements Runnable {
    public final /* synthetic */ zzbzj zza;
    public final /* synthetic */ Bitmap zzb;

    public /* synthetic */ zzbzf(zzbzj zzbzj, Bitmap bitmap) {
        this.zza = zzbzj;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
