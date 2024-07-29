package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzvb extends zzcx {
    private final zzbp zzc;

    public zzvb(zzbp zzbp) {
        this.zzc = zzbp;
    }

    public final int zza(Object obj) {
        return obj == zzva.zzd ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzcu zzd(int i, zzcu zzcu, boolean z) {
        Object obj = null;
        Integer num = z ? 0 : null;
        if (z) {
            obj = zzva.zzd;
        }
        zzcu.zzl(num, obj, 0, C.TIME_UNSET, 0, zzd.zza, true);
        return zzcu;
    }

    public final zzcw zze(int i, zzcw zzcw, long j) {
        zzcw zzcw2 = zzcw;
        zzcw.zza(zzcw.zza, this.zzc, (Object) null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, (zzbf) null, 0, C.TIME_UNSET, 0, 0, 0);
        zzcw zzcw3 = zzcw;
        zzcw3.zzm = true;
        return zzcw3;
    }

    public final Object zzf(int i) {
        return zzva.zzd;
    }
}
