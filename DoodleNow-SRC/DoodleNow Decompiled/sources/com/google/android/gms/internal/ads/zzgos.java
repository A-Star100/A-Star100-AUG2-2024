package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgos {
    private final Map zza;
    private final List zzb;
    private final zzgoq zzc;
    private final Class zzd;
    private final zzgrs zze;

    /* synthetic */ zzgos(Map map, List list, zzgoq zzgoq, zzgrs zzgrs, Class cls, zzgor zzgor) {
        this.zza = map;
        this.zzb = list;
        this.zzc = zzgoq;
        this.zzd = cls;
        this.zze = zzgrs;
    }

    public static zzgoo zza(Class cls) {
        return new zzgoo(cls, (zzgon) null);
    }

    @Nullable
    public final zzgoq zzb() {
        return this.zzc;
    }

    public final zzgrs zzc() {
        return this.zze;
    }

    public final Class zzd() {
        return this.zzd;
    }

    public final Collection zze() {
        return this.zza.values();
    }

    public final List zzf(byte[] bArr) {
        List list = (List) this.zza.get(zzgxm.zzb(bArr));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzg() {
        return !this.zze.zza().isEmpty();
    }
}
