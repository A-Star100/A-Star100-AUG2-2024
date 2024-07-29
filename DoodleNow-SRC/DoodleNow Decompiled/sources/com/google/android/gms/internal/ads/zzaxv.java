package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaxv extends BroadcastReceiver {
    final /* synthetic */ zzaxw zza;

    zzaxv(zzaxw zzaxw) {
        this.zza = zzaxw;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzf();
    }
}
