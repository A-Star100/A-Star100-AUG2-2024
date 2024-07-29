package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhjk implements zzhje {
    private static final Object zza = new Object();
    private volatile zzhje zzb;
    private volatile Object zzc = zza;

    private zzhjk(zzhje zzhje) {
        this.zzb = zzhje;
    }

    public static zzhje zza(zzhje zzhje) {
        return ((zzhje instanceof zzhjk) || (zzhje instanceof zzhiu)) ? zzhje : new zzhjk(zzhje);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzhje zzhje = this.zzb;
        if (zzhje == null) {
            return this.zzc;
        }
        Object zzb2 = zzhje.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}
