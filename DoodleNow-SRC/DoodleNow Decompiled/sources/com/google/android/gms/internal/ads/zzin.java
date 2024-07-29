package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzin implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzip zza;
    private final Handler zzb;

    public zzin(zzip zzip, Handler handler) {
        this.zza = zzip;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i) {
        this.zzb.post(new zzim(this, i));
    }
}
