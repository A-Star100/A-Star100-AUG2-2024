package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzefs implements Runnable {
    public final /* synthetic */ zzfmy zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzefs(zzfmy zzfmy, View view) {
        this.zza = zzfmy;
        this.zzb = view;
    }

    public final void run() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzeW)).booleanValue() && zzfmw.zzb()) {
            this.zza.zzb(this.zzb, zzfnf.NOT_VISIBLE, "Ad overlay");
        }
    }
}
