package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgxn {
    private final zzgxm zza;

    private zzgxn(zzgxm zzgxm) {
        this.zza = zzgxm;
    }

    public static zzgxn zzb(byte[] bArr, zzggn zzggn) {
        return new zzgxn(zzgxm.zzb(bArr));
    }

    public static zzgxn zzc(int i) {
        return new zzgxn(zzgxm.zzb(zzgow.zzb(i)));
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zzd(zzggn zzggn) {
        return this.zza.zzc();
    }
}
