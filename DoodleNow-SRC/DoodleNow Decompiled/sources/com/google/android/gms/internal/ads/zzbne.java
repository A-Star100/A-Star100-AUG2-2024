package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbne implements AdapterStatus {
    private final AdapterStatus.State zza;
    private final String zzb;
    private final int zzc;

    public zzbne(AdapterStatus.State state, String str, int i) {
        this.zza = state;
        this.zzb = str;
        this.zzc = i;
    }

    public final String getDescription() {
        return this.zzb;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.zza;
    }

    public final int getLatency() {
        return this.zzc;
    }
}
