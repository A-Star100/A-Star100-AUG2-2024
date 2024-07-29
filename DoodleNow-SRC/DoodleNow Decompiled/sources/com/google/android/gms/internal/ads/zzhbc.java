package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhbc implements zzhbj {
    private final zzhbj[] zza;

    zzhbc(zzhbj... zzhbjArr) {
        this.zza = zzhbjArr;
    }

    public final zzhbi zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzhbj zzhbj = this.zza[i];
            if (zzhbj.zzc(cls)) {
                return zzhbj.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
