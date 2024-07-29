package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhbg {
    zzhbg() {
    }

    public static final boolean zza(Object obj) {
        return !((zzhbf) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzhbf zzhbf = (zzhbf) obj;
        zzhbf zzhbf2 = (zzhbf) obj2;
        if (!zzhbf2.isEmpty()) {
            if (!zzhbf.zze()) {
                zzhbf = zzhbf.zzb();
            }
            zzhbf.zzd(zzhbf2);
        }
        return zzhbf;
    }
}
