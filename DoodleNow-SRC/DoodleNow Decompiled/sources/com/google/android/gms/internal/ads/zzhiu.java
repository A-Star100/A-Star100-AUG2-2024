package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhiu implements zzhje, zzhip {
    private static final Object zza = new Object();
    private volatile zzhje zzb;
    private volatile Object zzc = zza;

    private zzhiu(zzhje zzhje) {
        this.zzb = zzhje;
    }

    public static zzhip zza(zzhje zzhje) {
        return zzhje instanceof zzhip ? (zzhip) zzhje : new zzhiu(zzhje);
    }

    public static zzhje zzc(zzhje zzhje) {
        return zzhje instanceof zzhiu ? zzhje : new zzhiu(zzhje);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj2) {
                    obj = this.zzb.zzb();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }
}
