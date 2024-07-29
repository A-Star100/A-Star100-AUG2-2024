package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhr extends zzhp {
    public final int zzd;
    public final String zze;
    public final Map zzf;
    public final byte[] zzg;

    public zzhr(int i, String str, IOException iOException, Map map, zzhb zzhb, byte[] bArr) {
        super("Response code: " + i, iOException, zzhb, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, 1);
        this.zzd = i;
        this.zze = str;
        this.zzf = map;
        this.zzg = bArr;
    }
}
