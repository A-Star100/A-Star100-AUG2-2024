package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzse extends IOException {
    public final int zza = PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED;

    public zzse(Throwable th, int i) {
        super(th);
    }
}
