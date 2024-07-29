package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgzo implements zzhbj {
    private static final zzgzo zza = new zzgzo();

    private zzgzo() {
    }

    public static zzgzo zza() {
        return zza;
    }

    public final zzhbi zzb(Class cls) {
        if (zzgzv.class.isAssignableFrom(cls)) {
            try {
                return (zzhbi) zzgzv.zzbh(cls.asSubclass(zzgzv.class)).zzbN();
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzgzv.class.isAssignableFrom(cls);
    }
}
