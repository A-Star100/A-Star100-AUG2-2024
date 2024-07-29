package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcgn implements Runnable {
    public final /* synthetic */ zzcgu zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzbzo zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzcgn(zzcgu zzcgu, View view, zzbzo zzbzo, int i) {
        this.zza = zzcgu;
        this.zzb = view;
        this.zzc = zzbzo;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd);
    }
}
