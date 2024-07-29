package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzxq {
    private final zzel zza = zzel.zza;

    /* access modifiers changed from: protected */
    public final zzxr zza(zzcz zzcz, int[] iArr, int i, zzzn zzzn, zzfzn zzfzn) {
        return new zzxr(zzcz, iArr, 0, zzzn, WorkRequest.MIN_BACKOFF_MILLIS, 25000, 25000, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, zzfzn, this.zza);
    }
}
