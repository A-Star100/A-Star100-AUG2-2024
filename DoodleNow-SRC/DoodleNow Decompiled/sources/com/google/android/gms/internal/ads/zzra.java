package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzra {
    public static void zza(AudioTrack audioTrack, zzpp zzpp) {
        audioTrack.setPreferredDevice(zzpp == null ? null : zzpp.zza);
    }
}
