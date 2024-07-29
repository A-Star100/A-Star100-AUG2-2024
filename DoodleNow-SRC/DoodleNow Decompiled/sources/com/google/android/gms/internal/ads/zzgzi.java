package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgzi {
    private static final zzgzg zza = new zzgzh();
    private static final zzgzg zzb;

    static {
        zzgzg zzgzg;
        try {
            zzgzg = (zzgzg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgzg = null;
        }
        zzb = zzgzg;
    }

    static zzgzg zza() {
        zzgzg zzgzg = zzb;
        if (zzgzg != null) {
            return zzgzg;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzgzg zzb() {
        return zza;
    }
}
