package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdlv implements Runnable {
    public final /* synthetic */ zzdly zza;
    public final /* synthetic */ ViewGroup zzb;

    public /* synthetic */ zzdlv(zzdly zzdly, ViewGroup viewGroup) {
        this.zza = zzdly;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
