package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzij extends BroadcastReceiver implements Runnable {
    final /* synthetic */ zzil zza;
    private final zzik zzb;
    private final Handler zzc;

    public zzij(zzil zzil, Handler handler, zzik zzik) {
        this.zza = zzil;
        this.zzc = handler;
        this.zzb = zzik;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zzc.post(this);
        }
    }

    public final void run() {
    }
}
