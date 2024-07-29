package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzekf {
    private final zzfha zza;
    private final zzdrv zzb;
    private final zzduh zzc;

    public zzekf(zzfha zzfha, zzdrv zzdrv, zzduh zzduh) {
        this.zza = zzfha;
        this.zzb = zzdrv;
        this.zzc = zzduh;
    }

    public final void zza(zzffq zzffq, zzffn zzffn, int i, @Nullable zzegn zzegn, long j) {
        zzdru zzdru;
        zzdug zza2 = this.zzc.zza();
        zza2.zzd(zzffq);
        zza2.zzc(zzffn);
        zza2.zzb("action", "adapter_status");
        zza2.zzb("adapter_l", String.valueOf(j));
        zza2.zzb("sc", Integer.toString(i));
        if (zzegn != null) {
            zza2.zzb("arec", Integer.toString(zzegn.zzb().zza));
            String zza3 = this.zza.zza(zzegn.getMessage());
            if (zza3 != null) {
                zza2.zzb("areec", zza3);
            }
        }
        zzdrv zzdrv = this.zzb;
        Iterator it = zzffn.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdru = null;
                break;
            }
            zzdru = zzdrv.zza((String) it.next());
            if (zzdru != null) {
                break;
            }
        }
        if (zzdru != null) {
            zza2.zzb("ancn", zzdru.zza);
            zzbtc zzbtc = zzdru.zzb;
            if (zzbtc != null) {
                zza2.zzb("adapter_v", zzbtc.toString());
            }
            zzbtc zzbtc2 = zzdru.zzc;
            if (zzbtc2 != null) {
                zza2.zzb("adapter_sv", zzbtc2.toString());
            }
        }
        zza2.zzf();
    }
}
