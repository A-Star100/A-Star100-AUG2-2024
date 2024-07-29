package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzva extends zzuv {
    public static final Object zzd = new Object();
    private final Object zze;
    /* access modifiers changed from: private */
    public final Object zzf;

    private zzva(zzcx zzcx, Object obj, Object obj2) {
        super(zzcx);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzva zzq(zzbp zzbp) {
        return new zzva(new zzvb(zzbp), zzcw.zza, zzd);
    }

    public static zzva zzr(zzcx zzcx, Object obj, Object obj2) {
        return new zzva(zzcx, obj, obj2);
    }

    public final int zza(Object obj) {
        Object obj2;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return this.zzc.zza(obj);
    }

    public final zzcu zzd(int i, zzcu zzcu, boolean z) {
        this.zzc.zzd(i, zzcu, z);
        if (zzfx.zzG(zzcu.zzc, this.zzf) && z) {
            zzcu.zzc = zzd;
        }
        return zzcu;
    }

    public final zzcw zze(int i, zzcw zzcw, long j) {
        this.zzc.zze(i, zzcw, j);
        if (zzfx.zzG(zzcw.zzc, this.zze)) {
            zzcw.zzc = zzcw.zza;
        }
        return zzcw;
    }

    public final Object zzf(int i) {
        Object zzf2 = this.zzc.zzf(i);
        return zzfx.zzG(zzf2, this.zzf) ? zzd : zzf2;
    }

    public final zzva zzp(zzcx zzcx) {
        return new zzva(zzcx, this.zze, this.zzf);
    }
}
