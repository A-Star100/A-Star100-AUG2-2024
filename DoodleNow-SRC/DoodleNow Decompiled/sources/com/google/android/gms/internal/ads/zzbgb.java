package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbgb {
    public static final zzbff zza = zzbff.zzb("gads:dynamite_load:fail:sample_rate", WorkRequest.MIN_BACKOFF_MILLIS);
    public static final zzbff zzb = zzbff.zzd("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbff zzc = zzbff.zzc("gads:public_beta:traffic_multiplier", "1.0");
    public static final zzbff zzd = zzbff.zzc("gads:sdk_crash_report_class_prefix", "com.google.");
    public static final zzbff zze = zzbff.zzd("gads:sdk_crash_report_enabled", false);
    public static final zzbff zzf = zzbff.zzd("gads:sdk_crash_report_full_stacktrace", false);
    public static final zzbff zzg = zzbff.zza("gads:trapped_exception_sample_rate", 0.01d);
}
