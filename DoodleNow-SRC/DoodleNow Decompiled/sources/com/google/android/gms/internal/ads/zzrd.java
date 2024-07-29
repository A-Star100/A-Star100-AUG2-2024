package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzrd {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzph zzb;
    private boolean zzc;
    /* access modifiers changed from: private */
    public final zzrc zzd;
    /* access modifiers changed from: private */
    public zzrf zze;
    /* access modifiers changed from: private */
    public zzqv zzf;

    @Deprecated
    public zzrd() {
        this.zza = null;
        this.zzb = zzph.zza;
        this.zzd = zzrc.zza;
    }

    public final zzrr zzd() {
        zzek.zzf(!this.zzc);
        this.zzc = true;
        if (this.zze == null) {
            this.zze = new zzrf(new zzdt[0]);
        }
        if (this.zzf == null) {
            this.zzf = new zzqv(this.zza);
        }
        return new zzrr(this, (zzrq) null);
    }

    public zzrd(Context context) {
        this.zza = context;
        this.zzb = zzph.zza;
        this.zzd = zzrc.zza;
    }
}
