package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfhv {
    private final LinkedList zza = new LinkedList();
    private final int zzb;
    private final int zzc;
    private final zzfiu zzd;

    public zzfhv(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = new zzfiu();
    }

    private final void zzi() {
        while (!this.zza.isEmpty() && zzu.zzB().currentTimeMillis() - ((zzfif) this.zza.getFirst()).zzd >= ((long) this.zzc)) {
            this.zzd.zzg();
            this.zza.remove();
        }
    }

    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        zzi();
        return this.zza.size();
    }

    public final long zzc() {
        return this.zzd.zzb();
    }

    public final long zzd() {
        return this.zzd.zzc();
    }

    public final zzfif zze() {
        this.zzd.zzf();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzfif zzfif = (zzfif) this.zza.remove();
        if (zzfif != null) {
            this.zzd.zzh();
        }
        return zzfif;
    }

    public final zzfit zzf() {
        return this.zzd.zzd();
    }

    public final String zzg() {
        return this.zzd.zze();
    }

    public final boolean zzh(zzfif zzfif) {
        this.zzd.zzf();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzfif);
        return true;
    }
}
