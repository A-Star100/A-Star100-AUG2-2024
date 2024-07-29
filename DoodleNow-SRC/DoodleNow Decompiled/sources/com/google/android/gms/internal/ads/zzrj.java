package com.google.android.gms.internal.ads;

import android.media.AudioRouting;
import android.media.AudioRouting$OnRoutingChangedListener;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzrj {
    private final AudioTrack zza;
    private final zzpo zzb;
    private AudioRouting$OnRoutingChangedListener zzc = new zzri(this);

    public zzrj(AudioTrack audioTrack, zzpo zzpo) {
        this.zza = audioTrack;
        this.zzb = zzpo;
        audioTrack.addOnRoutingChangedListener(this.zzc, new Handler(Looper.myLooper()));
    }

    /* access modifiers changed from: private */
    public void zzc(AudioRouting audioRouting) {
        if (this.zzc != null && audioRouting.getRoutedDevice() != null) {
            this.zzb.zzh(audioRouting.getRoutedDevice());
        }
    }

    public void zzb() {
        AudioRouting$OnRoutingChangedListener audioRouting$OnRoutingChangedListener = this.zzc;
        audioRouting$OnRoutingChangedListener.getClass();
        this.zza.removeOnRoutingChangedListener(audioRouting$OnRoutingChangedListener);
        this.zzc = null;
    }
}
