package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhit implements zzhiv {
    private zzhje zza;

    public static void zza(zzhje zzhje, zzhje zzhje2) {
        zzhit zzhit = (zzhit) zzhje;
        if (zzhit.zza == null) {
            zzhit.zza = zzhje2;
            return;
        }
        throw new IllegalStateException();
    }

    public final Object zzb() {
        zzhje zzhje = this.zza;
        if (zzhje != null) {
            return zzhje.zzb();
        }
        throw new IllegalStateException();
    }
}
