package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzuf implements zztg {
    private final MediaCodec zza;

    public zzuf(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzd(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    public final void zze(int i, int i2, zzie zzie, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzie.zza(), j, 0);
    }

    public final void zzf(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzg() {
    }

    public final void zzh() {
    }
}
