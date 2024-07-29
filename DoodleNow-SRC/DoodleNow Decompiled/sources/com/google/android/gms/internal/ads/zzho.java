package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzho extends zzhp {
    public zzho(IOException iOException, zzhb zzhb) {
        super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, zzhb, PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, 1);
    }
}
