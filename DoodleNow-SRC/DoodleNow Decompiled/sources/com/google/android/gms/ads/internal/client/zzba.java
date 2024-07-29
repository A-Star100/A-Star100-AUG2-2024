package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbds;
import com.google.android.gms.internal.ads.zzbdx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzba {
    private static final zzba zza = new zzba();
    private final zzbdr zzb;
    private final zzbds zzc;
    private final zzbdx zzd;

    protected zzba() {
        zzbdr zzbdr = new zzbdr();
        zzbds zzbds = new zzbds();
        zzbdx zzbdx = new zzbdx();
        this.zzb = zzbdr;
        this.zzc = zzbds;
        this.zzd = zzbdx;
    }

    public static zzbdr zza() {
        return zza.zzb;
    }

    public static zzbds zzb() {
        return zza.zzc;
    }

    public static zzbdx zzc() {
        return zza.zzd;
    }
}
