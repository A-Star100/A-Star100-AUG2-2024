package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdkv {
    private zzbhb zza;

    public zzdkv(zzdkh zzdkh) {
        this.zza = zzdkh;
    }

    public final synchronized zzbhb zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbhb zzbhb) {
        this.zza = zzbhb;
    }
}
