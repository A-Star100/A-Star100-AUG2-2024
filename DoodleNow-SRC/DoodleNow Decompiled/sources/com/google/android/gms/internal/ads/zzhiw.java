package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhiw implements zzhiv, zzhip {
    private static final zzhiw zza = new zzhiw((Object) null);
    private final Object zzb;

    private zzhiw(Object obj) {
        this.zzb = obj;
    }

    public static zzhiv zza(Object obj) {
        zzhjd.zza(obj, "instance cannot be null");
        return new zzhiw(obj);
    }

    public static zzhiv zzc(Object obj) {
        return obj == null ? zza : new zzhiw(obj);
    }

    public final Object zzb() {
        return this.zzb;
    }
}
