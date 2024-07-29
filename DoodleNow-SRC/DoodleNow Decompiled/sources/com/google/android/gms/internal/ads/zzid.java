package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzid {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(0, 0);

    /* synthetic */ zzid(MediaCodec.CryptoInfo cryptoInfo, zzic zzic) {
        this.zza = cryptoInfo;
    }

    static /* bridge */ /* synthetic */ void zza(zzid zzid, int i, int i2) {
        zzid.zzb.set(i, i2);
        zzid.zza.setPattern(zzid.zzb);
    }
}
