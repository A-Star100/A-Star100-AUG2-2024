package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.ExoPlayer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbgg {
    public static final zzbff zza = zzbff.zzd("gads:invalidate_token_at_refresh_start", true);
    public static final zzbff zzb = zzbff.zzd("gms:expose_token_for_gma:enabled", true);
    public static final zzbff zzc = zzbff.zzb("gads:timeout_for_trustless_token:millis", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    public static final zzbff zzd = zzbff.zzb("gads:cached_token:ttl_millis", 10800000);
}
