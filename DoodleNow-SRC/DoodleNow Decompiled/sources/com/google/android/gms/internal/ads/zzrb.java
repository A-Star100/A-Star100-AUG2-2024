package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzrb {
    public static void zza(AudioTrack audioTrack, zzpb zzpb) {
        LogSessionId zza = zzpb.zza();
        if (!zza.equals(ReactTextView$$ExternalSyntheticApiModelOutline0.m())) {
            audioTrack.setLogSessionId(zza);
        }
    }
}
