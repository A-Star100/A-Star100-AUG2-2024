package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyu extends zzfyh {
    final /* synthetic */ zzfyw zza;
    private final Object zzb;
    private int zzc;

    zzfyu(zzfyw zzfyw, int i) {
        this.zza = zzfyw;
        this.zzb = zzfyw.zzg(zzfyw, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzfwl.zza(this.zzb, zzfyw.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzfyw.zzj(this.zza, i);
    }

    public final Object setValue(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzfyw zzfyw = this.zza;
        Object zzj = zzfyw.zzj(zzfyw, i);
        zzfyw.zzn(zzfyw, this.zzc, obj);
        return zzj;
    }
}
