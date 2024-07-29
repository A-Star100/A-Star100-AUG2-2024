package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzrp {
    final /* synthetic */ zzrr zza;
    private final Handler zzb = new Handler(Looper.myLooper());
    private final AudioTrack$StreamEventCallback zzc;

    public zzrp(zzrr zzrr) {
        this.zza = zzrr;
        this.zzc = new zzro(this, zzrr);
    }

    public void zza(AudioTrack audioTrack) {
        Handler handler = this.zzb;
        Objects.requireNonNull(handler);
        audioTrack.registerStreamEventCallback(new zzrn(handler), this.zzc);
    }

    public void zzb(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages((Object) null);
    }
}
