package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzzf {
    private zzze zza;
    private zzzn zzb;

    public zzmg zze() {
        throw null;
    }

    public void zzj() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzk(zzk zzk) {
        throw null;
    }

    public boolean zzn() {
        throw null;
    }

    public abstract zzzg zzp(zzmh[] zzmhArr, zzxk zzxk, zzvh zzvh, zzcx zzcx) throws zziz;

    public abstract void zzq(Object obj);

    /* access modifiers changed from: protected */
    public final zzzn zzr() {
        zzzn zzzn = this.zzb;
        zzek.zzb(zzzn);
        return zzzn;
    }

    public final void zzs(zzze zzze, zzzn zzzn) {
        this.zza = zzze;
        this.zzb = zzzn;
    }

    /* access modifiers changed from: protected */
    public final void zzt() {
        zzze zzze = this.zza;
        if (zzze != null) {
            zzze.zzj();
        }
    }
}
