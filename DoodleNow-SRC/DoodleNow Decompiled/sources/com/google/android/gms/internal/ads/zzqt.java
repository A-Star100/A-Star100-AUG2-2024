package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzqt {
    public static zzps zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzps.zza;
        }
        zzpq zzpq = new zzpq();
        zzpq.zza(true);
        zzpq.zzc(z);
        return zzpq.zzd();
    }
}
