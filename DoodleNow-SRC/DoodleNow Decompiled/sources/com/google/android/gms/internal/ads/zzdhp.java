package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzdhp {
    private final zzdiu zza;
    private final zzcgm zzb;

    public zzdhp(zzdiu zzdiu, zzcgm zzcgm) {
        this.zza = zzdiu;
        this.zzb = zzcgm;
    }

    public static final zzdgf zzh(zzfkt zzfkt) {
        return new zzdgf(zzfkt, zzcbr.zzf);
    }

    public static final zzdgf zzi(zzdiz zzdiz) {
        return new zzdgf(zzdiz, zzcbr.zzf);
    }

    public final View zza() {
        zzcgm zzcgm = this.zzb;
        if (zzcgm == null) {
            return null;
        }
        return zzcgm.zzG();
    }

    public final View zzb() {
        zzcgm zzcgm = this.zzb;
        if (zzcgm != null) {
            return zzcgm.zzG();
        }
        return null;
    }

    public final zzcgm zzc() {
        return this.zzb;
    }

    public final zzdgf zzd(Executor executor) {
        return new zzdgf(new zzdho(this.zzb), executor);
    }

    public final zzdiu zze() {
        return this.zza;
    }

    public Set zzf(zzcxn zzcxn) {
        return Collections.singleton(new zzdgf(zzcxn, zzcbr.zzf));
    }

    public Set zzg(zzcxn zzcxn) {
        return Collections.singleton(new zzdgf(zzcxn, zzcbr.zzf));
    }
}
