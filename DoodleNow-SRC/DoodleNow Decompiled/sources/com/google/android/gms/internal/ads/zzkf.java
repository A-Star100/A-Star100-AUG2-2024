package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzkf {
    public static zzpb zza(Context context, zzko zzko, boolean z, String str) {
        zzox zzb = zzox.zzb(context);
        if (zzb == null) {
            zzfe.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zzpb(ReactTextView$$ExternalSyntheticApiModelOutline0.m(), str);
        }
        if (z) {
            zzko.zzz(zzb);
        }
        return new zzpb(zzb.zza(), str);
    }
}
