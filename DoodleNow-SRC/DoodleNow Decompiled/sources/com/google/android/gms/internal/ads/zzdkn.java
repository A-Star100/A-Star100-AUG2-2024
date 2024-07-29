package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdkn implements Runnable {
    public final /* synthetic */ zzdkt zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzdkn(zzdkt zzdkt, View view, boolean z, int i) {
        this.zza = zzdkt;
        this.zzb = view;
        this.zzc = z;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc, this.zzd);
    }
}
