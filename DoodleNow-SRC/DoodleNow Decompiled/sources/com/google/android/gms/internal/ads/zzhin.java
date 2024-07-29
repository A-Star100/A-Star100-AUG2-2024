package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzhin {
    public static zzhin zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzhii(cls.getSimpleName());
        }
        return new zzhik(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
