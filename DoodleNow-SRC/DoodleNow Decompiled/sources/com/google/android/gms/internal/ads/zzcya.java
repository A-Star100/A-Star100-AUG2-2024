package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcya {
    private final Context zza;
    private final zzfgi zzb;
    private final Bundle zzc;
    private final zzfga zzd;
    private final zzcxs zze;
    private final zzego zzf;

    /* synthetic */ zzcya(zzcxy zzcxy, zzcxz zzcxz) {
        this.zza = zzcxy.zza;
        this.zzb = zzcxy.zzb;
        this.zzc = zzcxy.zzc;
        this.zzd = zzcxy.zzd;
        this.zze = zzcxy.zze;
        this.zzf = zzcxy.zzf;
    }

    /* access modifiers changed from: package-private */
    public final Context zza(Context context) {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzcxs zzc() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final zzcxy zzd() {
        zzcxy zzcxy = new zzcxy();
        zzcxy.zze(this.zza);
        zzcxy.zzi(this.zzb);
        zzcxy.zzf(this.zzc);
        zzcxy.zzg(this.zze);
        zzcxy.zzd(this.zzf);
        return zzcxy;
    }

    /* access modifiers changed from: package-private */
    public final zzego zze(String str) {
        zzego zzego = this.zzf;
        return zzego != null ? zzego : new zzego(str);
    }

    /* access modifiers changed from: package-private */
    public final zzfga zzf() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfgi zzg() {
        return this.zzb;
    }
}
