package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzuy {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzhb zza;
    public final Uri zzb;
    public final Map zzc;

    public zzuy(long j, zzhb zzhb, Uri uri, Map map, long j2, long j3, long j4) {
        this.zza = zzhb;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
