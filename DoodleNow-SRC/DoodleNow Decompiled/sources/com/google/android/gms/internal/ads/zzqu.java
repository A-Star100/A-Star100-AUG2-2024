package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzqu {
    public static zzps zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        int m = FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(audioFormat, audioAttributes);
        if (m == 0) {
            return zzps.zza;
        }
        zzpq zzpq = new zzpq();
        boolean z2 = false;
        if (zzfx.zza > 32 && m == 2) {
            z2 = true;
        }
        zzpq.zza(true);
        zzpq.zzb(z2);
        zzpq.zzc(z);
        return zzpq.zzd();
    }
}
