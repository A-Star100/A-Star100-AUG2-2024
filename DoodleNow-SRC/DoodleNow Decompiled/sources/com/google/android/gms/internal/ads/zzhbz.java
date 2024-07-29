package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhbz extends zzgyb {
    final zzhcd zza;
    zzgyd zzb = zzb();
    final /* synthetic */ zzhcf zzc;

    zzhbz(zzhcf zzhcf) {
        this.zzc = zzhcf;
        this.zza = new zzhcd(zzhcf, (zzhcc) null);
    }

    private final zzgyd zzb() {
        zzhcd zzhcd = this.zza;
        if (zzhcd.hasNext()) {
            return zzhcd.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzgyd zzgyd = this.zzb;
        if (zzgyd != null) {
            byte zza2 = zzgyd.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
