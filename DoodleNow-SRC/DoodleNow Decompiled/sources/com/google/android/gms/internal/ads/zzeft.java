package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeft implements Runnable {
    public final /* synthetic */ zzfmy zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzeft(zzfmy zzfmy, View view) {
        this.zza = zzfmy;
        this.zzb = view;
    }

    public final void run() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzeW)).booleanValue() && zzfmw.zzb()) {
            this.zza.zzd(this.zzb);
        }
    }
}
