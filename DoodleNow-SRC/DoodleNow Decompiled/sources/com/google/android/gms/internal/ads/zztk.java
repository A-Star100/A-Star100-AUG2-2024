package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zztk {
    /* access modifiers changed from: private */
    public static Boolean zza;

    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (zzfx.zza < 29) {
            return 0;
        }
        Boolean bool = zza;
        if (bool == null || !bool.booleanValue()) {
            return zztj.zza(videoCapabilities, i, i2, d);
        }
        return 0;
    }
}
