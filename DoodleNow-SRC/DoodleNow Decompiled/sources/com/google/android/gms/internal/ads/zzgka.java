package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgka {
    public static final zzgka zza = new zzgka("ASSUME_AES_GCM");
    public static final zzgka zzb = new zzgka("ASSUME_XCHACHA20POLY1305");
    public static final zzgka zzc = new zzgka("ASSUME_CHACHA20POLY1305");
    public static final zzgka zzd = new zzgka("ASSUME_AES_CTR_HMAC");
    public static final zzgka zze = new zzgka("ASSUME_AES_EAX");
    public static final zzgka zzf = new zzgka("ASSUME_AES_GCM_SIV");
    private final String zzg;

    private zzgka(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
