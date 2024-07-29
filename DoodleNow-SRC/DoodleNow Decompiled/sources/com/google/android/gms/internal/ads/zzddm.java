package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzddm implements zzdbl {
    private int zza = ((Integer) zzba.zzc().zza(zzbdz.zzbg)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final void zzdn(zzbxd zzbxd) {
    }

    public final synchronized void zzdo(zzffz zzffz) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbh)).booleanValue()) {
            try {
                this.zza = zzffz.zzb.zzb.zzc;
            } catch (NullPointerException unused) {
            }
        }
    }
}
