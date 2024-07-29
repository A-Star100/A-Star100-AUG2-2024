package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfni {
    private final String zza;
    private final String zzb;

    private zzfni(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfni zza(String str, String str2) {
        zzfop.zza(str, "Name is null or empty");
        zzfop.zza(str2, "Version is null or empty");
        return new zzfni(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
