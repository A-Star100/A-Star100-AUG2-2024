package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbfk {
    public static final zzbff zza = zzbfg.zzf("gads:consent:gmscore:dsid:enabled", true);
    public static final zzbff zzb = zzbfg.zzf("gads:consent:gmscore:lat:enabled", true);
    public static final zzbff zzc = new zzbfg("gads:consent:gmscore:backend_url", "https://adservice.google.com/getconfig/pubvendors", 4);
    public static final zzbff zzd = new zzbfg("gads:consent:gmscore:time_out", Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS), 2);
    public static final zzbff zze = zzbfg.zzf("gads:consent:gmscore:enabled", true);
}
