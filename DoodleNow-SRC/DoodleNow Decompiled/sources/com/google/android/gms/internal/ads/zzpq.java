package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzpq {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;

    public final zzpq zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzpq zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzpq zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzps zzd() {
        if (this.zza || (!this.zzb && !this.zzc)) {
            return new zzps(this, (zzpr) null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
