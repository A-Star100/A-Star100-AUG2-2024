package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzpn extends BroadcastReceiver {
    final /* synthetic */ zzpo zza;

    /* synthetic */ zzpn(zzpo zzpo, zzpm zzpm) {
        this.zza = zzpo;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!isInitialStickyBroadcast()) {
            zzpo zzpo = this.zza;
            zzpo.zzj(zzph.zzd(context, intent, zzpo.zzh, zzpo.zzg));
        }
    }
}
