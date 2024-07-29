package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
abstract class zzafs {
    protected final zzaem zza;

    protected zzafs(zzaem zzaem) {
        this.zza = zzaem;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzfo zzfo) throws zzcc;

    /* access modifiers changed from: protected */
    public abstract boolean zzb(zzfo zzfo, long j) throws zzcc;

    public final boolean zzf(zzfo zzfo, long j) throws zzcc {
        return zza(zzfo) && zzb(zzfo, j);
    }
}
