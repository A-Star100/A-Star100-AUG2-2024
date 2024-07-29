package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzccj implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzccr zzb;

    zzccj(zzccr zzccr, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzccr;
    }

    public final void run() {
        zzccr.zzl(this.zzb, this.zza);
        zzccr zzccr = this.zzb;
        if (zzccr.zzq != null) {
            zzccr.zzq.zzf();
        }
    }
}
